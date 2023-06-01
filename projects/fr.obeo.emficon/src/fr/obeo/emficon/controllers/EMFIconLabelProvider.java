package fr.obeo.emficon.controllers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

import fr.obeo.emficon.models.EMFIcon;
import fr.obeo.emficon.models.ImageManager;

//Extension of the AdapterFactoryLabelProvider supporting custom EMIcon
public class EMFIconLabelProvider extends AdapterFactoryLabelProvider{

	private String iconPath;
	private ImageManager imageManager;

	public EMFIconLabelProvider(AdapterFactory adapterFactory, String iconPath, ImageManager imageManager) {
		super(adapterFactory);
		this.iconPath = iconPath;
		this.imageManager = imageManager;
	}

	@Override
	public String getText(Object element) {	
		if (element instanceof EMFIcon) {
			EMFIcon emficon = (EMFIcon) element;
			return emficon.getPath().substring(emficon.getPath().lastIndexOf("/")+1);
		}
		return super.getText(element);
	}


	@Override
	public Image getImage(Object element) {
		if (element instanceof EMFIcon) {
			EMFIcon emficon = (EMFIcon) element;
			return emficon.getImage();
		}
		if (element instanceof ENamedElementImpl) {
			ENamedElement a = (ENamedElementImpl) element;
			String pathIcon = this.iconPath + a.getName() + ".gif";
			if (imageManager.getArrayFilesPath().contains(pathIcon)) {

				return imageManager.getImage(pathIcon);
			}	
		}
		return super.getImage(element);
	}

}
