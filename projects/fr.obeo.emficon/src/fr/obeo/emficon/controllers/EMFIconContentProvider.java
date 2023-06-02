package fr.obeo.emficon.controllers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import fr.obeo.emficon.models.EMFIconContainer;

/**
 * Extension of the AdapterFactoryContentProvider supporting custom EMIcon.
 * 
 * @author fdaunay
 */

public class EMFIconContentProvider extends AdapterFactoryContentProvider{

	public EMFIconContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {

		if (object instanceof EMFIconContainer) {

			EMFIconContainer unusedIcon = (EMFIconContainer) object;
			int nbUnusedIcon = unusedIcon.unusedIconList().size();
			Object[] result = new Object[nbUnusedIcon + 1];
			result[0] = super.getElements(unusedIcon.resource())[0];
			for (int i = 0 ; i < nbUnusedIcon ; i++) {
				result[i+1] = unusedIcon.unusedIconList().get(i);
			}
			return result;
		}
		else if (object instanceof EPackage ep) {
	        return ep.getEClassifiers().stream().filter(ec -> ec instanceof EClass && !((EClass) ec).isAbstract()).toArray();
	    }
		return null;
	}
}


