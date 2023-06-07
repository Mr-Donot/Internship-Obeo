package fr.obeo.emficon.views;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import fr.obeo.emficon.models.EMFIconViewer;
import fr.obeo.emficon.models.ImageManager;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class EMFIconView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "treeplugin.views.SampleView";

	@Inject
	IWorkbench workbench;

	private TreeViewer treeViewer;
	private Action cleanIconsAction;
	private Action actionSelectEcoreInList;
	private Map<String, File> mapEcoreGenModel;
	private IWorkspace workspace = ResourcesPlugin.getWorkspace();
	private IWorkspaceRoot root = workspace.getRoot();
	private EMFIconViewer viewer;
	private ImageManager imageManager = new ImageManager();
	private String actualEcorePath = "";
	private ISelectionListener listener;

	@Override
	public void createPartControl(Composite parent) {

		viewer = new EMFIconViewer(this, parent);
		treeViewer = viewer.getTree();

		getSite().setSelectionProvider(treeViewer);
		makeActions(parent);
		hookContextMenu();
		contributeToActionBars();
		listener = new ISelectionListener() {
			@Override
			public void selectionChanged(IWorkbenchPart sourcepart, ISelection selection) {
				if (sourcepart != this && selection instanceof IStructuredSelection) {
					List<?> selectionList = ((IStructuredSelection) selection).toList();
					if (!selectionList.isEmpty()) {
						// case : ecore file selected
						if (selectionList.get(0) instanceof IFile) {
							IFile selectedFile = (IFile) selectionList.get(0);
							if (selectedFile.getFileExtension().equals("ecore")) {
								// format needed : /webpage/model/webpage.ecore
								updateView(selectedFile.getFullPath().toString());
							}
						}
					}
				}
			}
		};
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(listener);

	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				EMFIconView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, treeViewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(actionSelectEcoreInList);
		manager.add(cleanIconsAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(actionSelectEcoreInList);
		manager.add(cleanIconsAction);
		manager.add(new Separator());
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(actionSelectEcoreInList);
		manager.add(cleanIconsAction);
		manager.add(new Separator());
	}

	/**
	 * Create the actions.
	 * 
	 * @param parent the initial composite.
	 */
	private void makeActions(Composite parent) {

		cleanIconsAction = new Action() {
			public void run() {
				cleanIconMsgBox(parent);
			}
		};
		cleanIconsAction.setText("Clean unused icons");
		cleanIconsAction.setToolTipText("Clean unused icons");
		cleanIconsAction
		.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("fr.obeo.emficon", "icons/warning.gif"));
		cleanIconsAction
		.setImageDescriptor(workbench.getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE));

		actionSelectEcoreInList = new Action() {
			public void run() {
				selectionMenuAndUpdateView(parent);

			}
		};
		actionSelectEcoreInList.setText("Select ecore file");
		actionSelectEcoreInList.setToolTipText("Select ecore file");
		actionSelectEcoreInList.setImageDescriptor(
				AbstractUIPlugin.imageDescriptorFromPlugin("fr.obeo.emficon", "icons/hierarchy.gif"));

	}

	/**
	 * Create a message box to confirm the cleaning icons' choice.
	 * 
	 * @param parent the initial composite.
	 */
	private void cleanIconMsgBox(Composite parent) {
		if (!actualEcorePath.equals("")) {
			boolean result = MessageDialog.openConfirm(parent.getShell(), "Clean icons",
					"Do you want to delete all the unused icons ?");
			if (result) {
				this.imageManager.deleteUnusedIcons(actualEcorePath);
				this.updateView(actualEcorePath);
			}
		}
	}

	/**
	 * Create a message box with the item's list in the input.
	 * 
	 * @param itemsList an item list of all the ecore files to show.
	 * @param parent    the initial composite.
	 * @return the selected result.
	 */
	private ElementListSelectionDialog createDialog(ArrayList<String> itemsList, Composite parent) {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(parent.getShell(), new LabelProvider());
		dialog.setElements(itemsList.toArray(new String[0]));
		dialog.setTitle("Which metamodel you want to display ?");
		dialog.open();

		return dialog;
	}

	@SuppressWarnings("unchecked")
	private ArrayList<String> getKeys(Iterator<?> it) {
		ArrayList<String> result = new ArrayList<String>();
		while (it.hasNext()) {
			Map.Entry<String, File> entry = (Entry<String, File>) it.next();
			result.add(entry.getKey());
		}
		return result;
	}

	/**
	 * Create a message box and get the returning answer, then update the view
	 * according to the selected ecore file.
	 * 
	 * @param parent the initial composite.
	 */
	private void selectionMenuAndUpdateView(Composite parent) {
		mapEcoreGenModel = viewer.getEcorePaths();
		Iterator<?> it = mapEcoreGenModel.entrySet().iterator();
		ArrayList<String> ecoreList = getKeys(it);
		ElementListSelectionDialog dialog = createDialog(ecoreList, parent);
		String ecorePath = dialog.getResult() != null ? (String) dialog.getResult()[0] : ""; // "" if selection canceled
		if (ecorePath == "") {
			return;
		}
		updateView(ecorePath);
	}

	public Resource createResourceFromEcorePath(String ecorePath) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(root.getLocation() + ecorePath);
		return resourceSet.getResource(fileURI, true);
	}

	/**
	 * Update the view according to the ecore path in the input.
	 * 
	 * @param ecorePath the ecore file's path choosen in the selection dialog.
	 */
	public void updateView(String ecorePath) {
		actualEcorePath = ecorePath;
		imageManager = new ImageManager();
		mapEcoreGenModel = viewer.getEcorePaths();
		Resource resource = createResourceFromEcorePath(ecorePath);
		IProject[] projectList = root.getProjects();
		for (IProject project : projectList) {
			File fileTemp = new File(ecorePath);
			String projectFilePath = fileTemp.getParentFile().getParentFile().getName();
			String projectEditFilePath = projectFilePath + ".edit";

			if (project.getName().equals(projectEditFilePath)) {
				File genmodelFile = mapEcoreGenModel.get(ecorePath);
				String editPluginID = viewer.getEditByFile(genmodelFile, resource);
				if (editPluginID != "") {
					viewer.updateTree(workbench, resource, editPluginID, imageManager);
					break;
				}
			}
		}

	}

	@Override
	public void dispose() {
		if (listener != null) {
			ISelectionService selService = getSite().getWorkbenchWindow().getSelectionService();
			selService.removeSelectionListener(listener);

			listener = null;
		}

		super.dispose();
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}
}
