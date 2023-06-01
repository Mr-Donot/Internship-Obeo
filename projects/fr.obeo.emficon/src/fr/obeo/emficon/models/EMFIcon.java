package fr.obeo.emficon.models;

import org.eclipse.swt.graphics.Image;

public class EMFIcon {

	private String path;
	private Image image;


	public EMFIcon(String path, Image image) {
		this.path = path;
		this.image = image;
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

	@Override
	public String toString() {
		return "path : " + path.toString() + " | Image : " + image.toString();
	}
}
