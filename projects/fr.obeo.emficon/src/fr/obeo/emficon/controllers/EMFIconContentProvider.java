package fr.obeo.emficon.controllers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import fr.obeo.emficon.models.EMFIconContainer;

//Extension of the AdapterFactoryContentProvider supporting custom EMIcon
public class EMFIconContentProvider extends AdapterFactoryContentProvider{

	public EMFIconContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public Object[] getElements(Object object) {
	
		if (object instanceof EMFIconContainer) {

			EMFIconContainer unusedIcon = (EMFIconContainer) object;
			int nbUnusedIcon = unusedIcon.getUnusedIconList().size();
			Object[] result = new Object[nbUnusedIcon + 1];
			result[0] = super.getElements(unusedIcon.getResource())[0];
			for (int i = 0 ; i < nbUnusedIcon ; i++) {
				result[i+1] = unusedIcon.getUnusedIconList().get(i);
			}
			return result;
		}
		return super.getElements(object);
	}

	
	

}


