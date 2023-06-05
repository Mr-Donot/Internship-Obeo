package fr.obeo.emficon.controllers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
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
	        Resource resource = unusedIcon.resource();
	        Object obj = super.getElements(resource)[0];
	        result[0] = obj;
	        for (int i = 0; i < nbUnusedIcon; i++) {
	            result[i + 1] = unusedIcon.unusedIconList().get(i);
	        }
	        return result;
	    }
	    return null;
	}

	@Override
	public Object[] getChildren(Object object) {
	    if (object instanceof EClass) {
	        return new Object[0]; 
	    }
	    return super.getChildren(object);
	}
	
	@Override
	public boolean hasChildren(Object element) {
	    return !(element instanceof EClass);
	}
}


