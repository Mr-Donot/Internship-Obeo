package fr.obeo.emficon.controllers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;

import fr.obeo.emficon.models.EMFIcon;
import fr.obeo.emficon.models.ImageManager;
import fr.obeo.emficon.models.UnusedIconContainer;

/**
 * Extension of the AdapterFactoryLabelProvider supporting custom EMIcon.
 * 
 * @author fdaunay
 */
public class EMFIconLabelProvider extends AdapterFactoryLabelProvider {

	private String iconPath;
	private ImageManager imageManager;
	private IWorkbench workbench;

	public EMFIconLabelProvider(IWorkbench workbench, AdapterFactory adapterFactory, String iconPath,
			ImageManager imageManager) {
		super(adapterFactory);
		this.iconPath = iconPath;
		this.imageManager = imageManager;
		this.workbench = workbench;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof EMFIcon emficon) {
			return emficon.getLabel();
		}
		if (element instanceof UnusedIconContainer emficonUnusedRoot) {
			return "Unused icons";
		}
		return (super.getText(element));
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof EMFIcon emficon) {
			return emficon.getImage();
		}
		if (element instanceof UnusedIconContainer) {
			return workbench.getSharedImages().getImageDescriptor(ISharedImages.IMG_LCL_LINKTO_HELP).createImage();
		}
		if (element instanceof ENamedElementImpl) {
			ENamedElement a = (ENamedElementImpl) element;
			String pathIcon = this.iconPath + a.getName() + ".gif";
			if (imageManager.getArrayFilesPath().contains(pathIcon)) {
				return imageManager.getImage(pathIcon);
			}
		}
		return (element instanceof EPackage) ? super.getImage(element) : null;
	}

}
