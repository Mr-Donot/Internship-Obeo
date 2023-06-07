package fr.obeo.emficon.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import fr.obeo.emficon.models.UnusedIconContainer;

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
		if (object instanceof Object[]) {
			Object[] roots = (Object[]) object;
			List<Object> res = new ArrayList<>();
			for (Object root : roots) {
				if (root instanceof Resource) {
					res.addAll(Arrays.asList(super.getElements(root)));
				} else if (root instanceof UnusedIconContainer) {
					res.add(((UnusedIconContainer) root));
				}
			}
			return res.toArray();
		}
		return super.getElements(object);
	}

	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof UnusedIconContainer) {
			return ((UnusedIconContainer) object).unusedIcons().toArray();
		}
		return super.getChildren(object);
	}

	@Override
	public boolean hasChildren(Object element) {
		return element instanceof EPackage || element instanceof UnusedIconContainer;
	}
}
