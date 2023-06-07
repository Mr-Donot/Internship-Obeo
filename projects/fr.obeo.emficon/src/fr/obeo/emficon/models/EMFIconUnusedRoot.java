package fr.obeo.emficon.models;

import java.util.ArrayList;

public class EMFIconUnusedRoot {
	private ArrayList<EMFIcon> children;
	private String name;

	public EMFIconUnusedRoot(String name) {
		this.name = name;
		children = new ArrayList<EMFIcon>();
	}

	public void addChild(EMFIcon child) {
		children.add(child);
	}

	public EMFIcon[] getChildren() {
		return (EMFIcon[]) children.toArray(new EMFIcon[children.size()]);
	}

	public boolean hasChildren() {
		return children.size() > 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
