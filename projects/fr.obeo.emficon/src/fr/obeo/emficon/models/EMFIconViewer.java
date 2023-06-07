package fr.obeo.emficon.models;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;

import fr.obeo.emficon.controllers.EMFIconContentProvider;
import fr.obeo.emficon.controllers.EMFIconLabelProvider;
import fr.obeo.emficon.views.EMFIconView;

/**
 * Class that controls the view by updating the data shown.
 * 
 * @author fdaunay
 *
 */
public class EMFIconViewer {

	private TreeViewer tree;
	private IWorkspaceRoot root;

	public EMFIconViewer(EMFIconView view, Composite parent) {
		this.tree = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		this.root = ResourcesPlugin.getWorkspace().getRoot();
	}

	/**
	 * Update view by selecting ecore files.
	 * 
	 * @param resource     EMF container.
	 * @param editPluginID plugin id of the genmodel.
	 * @param imageManager image cache.
	 */
	public void updateTree(IWorkbench workbench, Resource resource, String editPluginID, ImageManager imageManager) {
		String pathIcon = root.getLocation() + "/" + editPluginID + "/icons/full/obj16/";
		imageManager.loadImageMapByFolderPath(pathIcon);
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		EMFIconContentProvider contentProvider = new EMFIconContentProvider(composedAdapterFactory);
		EMFIconLabelProvider labelProvider = new EMFIconLabelProvider(workbench, composedAdapterFactory, pathIcon,
				imageManager);
		tree.setFilters(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof UnusedIconContainer || element instanceof EMFIcon || element instanceof EPackage
						|| (element instanceof EClass && !((EClass) element).isAbstract());
			}
		});
		this.tree.setContentProvider(contentProvider);
		this.tree.setLabelProvider(labelProvider);
		if (imageManager.getUnusedIcons(resource).size() > 0) {
			UnusedIconContainer unusedIcons = new UnusedIconContainer(imageManager.getUnusedIcons(resource));			
			this.tree.setInput(new Object[] { resource, unusedIcons });
		}else {
			this.tree.setInput(resource);
		}
		this.tree.expandAll();
		this.tree.refresh();
	}

	public TreeViewer getTree() {
		return tree;
	}

	public void setTree(TreeViewer tree) {
		this.tree = tree;
	}

	/**
	 * Get the edit plugin-id with a genmodel file.
	 * 
	 * @param genmodelFile the genmodel file.
	 * @param resource     EMF container.
	 * @return plugin id of the genmodel file.
	 */
	public String getEditByFile(File genmodelFile, Resource resource) {
		ResourceSet genModelResourceSet = new ResourceSetImpl();
		Resource genModelResource = genModelResourceSet
				.getResource(org.eclipse.emf.common.util.URI.createFileURI(genmodelFile.getAbsolutePath()), true);

		try {
			genModelResource.load(null);
			GenModel genModel = (GenModel) genModelResource.getContents().get(0);
			String editPluginID = genModel.getEditPluginID();
			return editPluginID;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Return a Map<string, File>. strings are ecore file path, and files are the
	 * genmodel file associated to the ecore file.
	 * 
	 * @return a map of ecore path as key and genmodel file as value
	 */
	public Map<String, File> getEcorePaths() {
		Map<String, File> result = new HashMap<String, File>();
		try {
			root.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					File file = resource.getLocation().removeFileExtension().addFileExtension("genmodel").toFile();
					if (resource instanceof IFile f && "ecore".equals(f.getFileExtension()) && file.exists()) {
						File fileTemp = new File(resource.getLocation().toString());
						String son = fileTemp.getName();
						String parent = fileTemp.getParentFile().getName();
						String greatParent = fileTemp.getParentFile().getParentFile().getName();
						String relativePath = "/" + greatParent + "/" + parent + "/" + son;
						result.put(relativePath, file);
					}
					return resource instanceof IContainer;
				}
			}, IResource.DEPTH_INFINITE, false);
		} catch (CoreException e) {

			e.printStackTrace();
		}
		return result;
	}
}
