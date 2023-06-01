/**
 */
package fr.obeo.webpage.model.webpage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>web</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.webpage.model.webpage.web#getWebpage <em>Webpage</em>}</li>
 *   <li>{@link fr.obeo.webpage.model.webpage.web#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.webpage.model.webpage.web#getTitle <em>Title</em>}</li>
 * </ul>
 *
 * @see fr.obeo.webpage.model.webpage.WebpagePackage#getweb()
 * @model
 * @generated
 */
public interface web extends EObject {
	/**
	 * Returns the value of the '<em><b>Webpage</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.webpage.model.webpage.webpage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Webpage</em>' containment reference list.
	 * @see fr.obeo.webpage.model.webpage.WebpagePackage#getweb_Webpage()
	 * @model containment="true"
	 * @generated
	 */
	EList<webpage> getWebpage();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.webpage.model.webpage.WebpagePackage#getweb_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.webpage.model.webpage.web#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see fr.obeo.webpage.model.webpage.WebpagePackage#getweb_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link fr.obeo.webpage.model.webpage.web#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

} // web
