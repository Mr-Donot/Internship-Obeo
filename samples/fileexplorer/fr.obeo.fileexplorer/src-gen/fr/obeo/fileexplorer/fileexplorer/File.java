/**
 */
package fr.obeo.fileexplorer.fileexplorer;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.fileexplorer.fileexplorer.File#getParent <em>Parent</em>}</li>
 *   <li>{@link fr.obeo.fileexplorer.fileexplorer.File#getContent <em>Content</em>}</li>
 *   <li>{@link fr.obeo.fileexplorer.fileexplorer.File#getExtension <em>Extension</em>}</li>
 *   <li>{@link fr.obeo.fileexplorer.fileexplorer.File#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getFile()
 * @model
 * @generated
 */
public interface File extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.fileexplorer.fileexplorer.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' containment reference list.
	 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getFile_Parent()
	 * @model containment="true"
	 * @generated
	 */
	EList<File> getParent();

	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.fileexplorer.fileexplorer.Content}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference list.
	 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getFile_Content()
	 * @model containment="true"
	 * @generated
	 */
	EList<Content> getContent();

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.fileexplorer.fileexplorer.Extension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference list.
	 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getFile_Extension()
	 * @model containment="true"
	 * @generated
	 */
	EList<Extension> getExtension();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getFile_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.fileexplorer.fileexplorer.File#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // File
