package fr.obeo.emficon.controllers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import fr.obeo.emficon.models.EMFIconContainer;
import fr.obeo.emficon.models.EMFIconUnusedRoot;

/**
 * Extension of the AdapterFactoryContentProvider supporting custom EMIcon.
 * 
 * @author fdaunay
 */

public class EMFIconContentProvider extends AdapterFactoryContentProvider {

	public EMFIconContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		if (object instanceof EMFIconContainer) {
			EMFIconContainer unusedIcon = (EMFIconContainer) object;
			int nbUnusedIcon = unusedIcon.unusedIconList().size();
			Object[] result = new Object[nbUnusedIcon + 2];
			Resource resource = unusedIcon.resource();
			Object obj = super.getElements(resource)[0];
			result[0] = obj;
			EMFIconUnusedRoot emficonUnusedRoot = new EMFIconUnusedRoot("? Unused icon : ");
			result[1] = emficonUnusedRoot;
			for (int i = 0; i < nbUnusedIcon; i++) {
				result[i + 2] = unusedIcon.unusedIconList().get(i);
			}
			return result;
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return !(element instanceof EClass);
	}
}
