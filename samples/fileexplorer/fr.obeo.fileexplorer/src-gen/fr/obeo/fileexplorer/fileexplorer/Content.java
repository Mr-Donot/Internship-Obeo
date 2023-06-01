/**
 */
package fr.obeo.fileexplorer.fileexplorer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.fileexplorer.fileexplorer.Content#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.fileexplorer.fileexplorer.Content#getType <em>Type</em>}</li>
 *   <li>{@link fr.obeo.fileexplorer.fileexplorer.Content#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getContent()
 * @model
 * @generated
 */
public interface Content extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getContent_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.fileexplorer.fileexplorer.Content#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getContent_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link fr.obeo.fileexplorer.fileexplorer.Content#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(String)
	 * @see fr.obeo.fileexplorer.fileexplorer.FileexplorerPackage#getContent_Container()
	 * @model
	 * @generated
	 */
	String getContainer();

	/**
	 * Sets the value of the '{@link fr.obeo.fileexplorer.fileexplorer.Content#getContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(String value);

} // Content
