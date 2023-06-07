package fr.obeo.emficon.models;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;

/**
 * Image cache.
 * 
 * @author fdaunay
 */
public class ImageManager {

	private Map<String, EMFIcon> imageMap = new HashMap<String, EMFIcon>();

	private ArrayList<String> arrayFilesPath = new ArrayList<String>();
	private Resource actualResource;
	private IWorkbench workbench;

	public ImageManager(IWorkbench workbench) {
		this.workbench = workbench;
	}

	/**
	 * load all the images on the input folder, if they are already in the map,
	 * doesn't create a new image (cache).
	 * 
	 * @param folderPath the folder's path that contains the images to load.
	 */
	public void loadImageMapByFolderPath(String folderPath) {

		loadFiles(new File(folderPath));
		String pathIcon;
		for (int i = 0; i < arrayFilesPath.size(); i++) {
			pathIcon = arrayFilesPath.get(i);
			EMFIcon emficon = this.imageMap.computeIfAbsent(pathIcon, s -> createEMFIcon(s));
			this.imageMap.put(pathIcon, emficon);
		}
	}

	@SuppressWarnings("deprecation")
	public EMFIcon createEMFIcon(String pathIcon) {
		ImageData imageData = new ImageData(pathIcon);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromImageData(imageData);
		Image image = imageDescriptor.createImage();

		EMFIcon emficon = new EMFIcon(pathIcon, image);
		return emficon;
	}

	/**
	 * Recursive function that browse the input item if it's a directory, otherwise
	 * add the folder to the arrayFilesPath.
	 * 
	 * @param file to browse.
	 */
	private void loadFiles(File file) {
		if (!file.equals(null)) {
			File files[];
			if (file.isFile())
				arrayFilesPath.add(file.getAbsolutePath().replace("\\", "/"));
			else {
				files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					loadFiles(files[i]);
				}
			}
		}
	}

	public ArrayList<String> getArrayFilesPath() {
		return arrayFilesPath;
	}

	public void setArrayFilesPath(ArrayList<String> arrayFilesPath) {
		this.arrayFilesPath = arrayFilesPath;
	}

	/**
	 * get the Image associated to the input string.
	 * 
	 * @param s the image name.
	 * @return the image if it exists in the map, otherwise null.
	 */
	public Image getImage(String s) {
		for (Map.Entry<String, EMFIcon> pair : this.imageMap.entrySet()) {
			if (pair.getKey().equals(s)) {
				return imageMap.get(s).getImage();
			}
		}
		return null;
	}

	/**
	 * scrap a resource to get all namedElement's name, then return all the EMFIcon
	 * which doesn't have their name on the name list.
	 * 
	 * @param resource EMF container.
	 * @return a array list of EMFIcon.
	 */
	public ArrayList<EMFIcon> getUnusedIcons(Resource resource) {
		actualResource = resource;
		ArrayList<String> nameList = new ArrayList<String>();
		TreeIterator<EObject> eListObject = resource.getAllContents();
		while (eListObject.hasNext()) {
			EObject eObject = eListObject.next();
			if (eObject instanceof ENamedElement) {
				ENamedElementImpl eNamedElement = (ENamedElementImpl) eObject;
				nameList.add(eNamedElement.getName() + ".gif");
			}
		}

		ArrayList<EMFIcon> result = new ArrayList<EMFIcon>();
		for (Map.Entry<String, EMFIcon> pair : this.imageMap.entrySet()) {
			String iconFileName = pair.getValue().getLabel();
			boolean beUsed = false;
			for (int i = 0; i < nameList.size(); i++) {
				if (nameList.get(i).equals(iconFileName)) {
					beUsed = true;
				}
			}
			if (!beUsed && !pair.getValue().getPath().equals("UnusedIconBranch")) {
				result.add(pair.getValue());
			}
		}
		return result;
	}

	public void display() {
		System.out.println("===========DISPLAY IMAGE MANAGER===========");
		System.out.println("List of files : \n");
		for (int i = 0; i < this.arrayFilesPath.size(); i++) {
			System.out.println(i + " : " + this.arrayFilesPath.get(i));
		}
		System.out.println("-------------------------------------------");
		System.out.println("image map : \n");
		for (Map.Entry<String, EMFIcon> pair : this.imageMap.entrySet()) {
			System.out.println(pair.getKey() + " |--> " + pair.getValue());
		}
		System.out.println("===========================================");
	}

	public void deleteUnusedIcons(String actualEcorePath) {
		ArrayList<EMFIcon> unusedIconsList = this.getUnusedIcons(this.actualResource);
		for (int i = 0; i < unusedIconsList.size(); i++) {
			File myObj = new File(unusedIconsList.get(i).getPath());
			myObj.delete();
			this.imageMap.get(unusedIconsList.get(i).getPath()).getImage().dispose();
			this.imageMap.remove(unusedIconsList.get(i).getPath());
			this.arrayFilesPath.remove(unusedIconsList.get(i).getPath());
		}
	}

	public Image getUnusedIconBranch() {
		this.imageMap.put("UnusedIconBranch",
				this.imageMap.computeIfAbsent("UnusedIconBranch", s -> createUnusedIconBranch(s)));
		return imageMap.get("UnusedIconBranch").getImage();
	}

	private EMFIcon createUnusedIconBranch(String s) {
		return new EMFIcon(s,
				workbench.getSharedImages().getImageDescriptor(ISharedImages.IMG_LCL_LINKTO_HELP).createImage());
	}

	public Map<String, EMFIcon> getImageMap() {
		return imageMap;
	}

	public void setImageMap(Map<String, EMFIcon> imageMap) {
		this.imageMap = imageMap;
	}

}
