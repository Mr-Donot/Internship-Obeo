package fr.obeo.emficon.models;

import org.eclipse.emf.ecore.resource.Resource;
import java.util.ArrayList;


//custom container for the EMFIconView. Contains a resource and a list of unusedIcons
public class EMFIconContainer {

	private Resource resource;
	private ArrayList<EMFIcon> unusedIconList;

	public EMFIconContainer(Resource resource, ArrayList<EMFIcon> unusedIconList) {
		this.resource = resource;
		this.unusedIconList = unusedIconList;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public ArrayList<EMFIcon> getUnusedIconList() {
		return unusedIconList;
	}

	public void setUnusedIconList(ArrayList<EMFIcon> unusedIconList) {
		this.unusedIconList = unusedIconList;
	}
}