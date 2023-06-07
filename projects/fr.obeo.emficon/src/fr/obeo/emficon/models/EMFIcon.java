package fr.obeo.emficon.models;

import org.eclipse.swt.graphics.Image;

/**
 * Class container of an image and it's path.
 * 
 * @author fdaunay
 *
 */
public class EMFIcon {

	private String path;
	private Image image;
	private String label;

	public EMFIcon(String path, Image image) {
		this.path = path;
		this.image = image;
		this.label = this.path.substring(this.path.lastIndexOf("/") + 1);
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "path : " + path.toString() + " | Image : " + image.toString();
	}
}
