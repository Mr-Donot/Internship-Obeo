package fr.obeo.emficon.models;

import java.util.List;

/**
 * Custom container for the EMFIconView. Contains a list of unusedIcons.
 * 
 * @author fdaunay
 */
public record UnusedIconContainer(List<EMFIcon> unusedIcons) {
}
