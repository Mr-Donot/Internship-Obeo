package fr.obeo.emficon.models;

import java.util.ArrayList;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Custom container for the EMFIconView. Contains a resource and a list of
 * unusedIcons.
 * 
 * @author fdaunay
 */
public record EMFIconContainer(Resource resource, ArrayList<EMFIcon> unusedIconList) {
}
