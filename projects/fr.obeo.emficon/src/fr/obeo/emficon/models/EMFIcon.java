package fr.obeo.emficon.models;

import org.eclipse.swt.graphics.Image;

public class EMFIcon {

	private String path;
	private Image image;
	private Boolean used;
	
	public EMFIcon(String path, Image image, Boolean used) {
		this.path = path;
		this.image = image;
		this.used = used;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}
	
	@Override
	public String toString() {
		return "path : " + path.toString() + " | Image : " + image.toString() + " | used ? " + (used ? "Yes" : "No");
	}
}
