/**
 */
package fr.obeo.webpage.model.webpage;

import java.util.Calendar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>webpage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.webpage.model.webpage.webpage#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.webpage.model.webpage.webpage#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @see fr.obeo.webpage.model.webpage.WebpagePackage#getwebpage()
 * @model
 * @generated
 */
public interface webpage extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.webpage.model.webpage.WebpagePackage#getwebpage_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.webpage.model.webpage.webpage#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Calendar)
	 * @see fr.obeo.webpage.model.webpage.WebpagePackage#getwebpage_Date()
	 * @model dataType="fr.obeo.webpage.model.webpage.Calendar"
	 * @generated
	 */
	Calendar getDate();

	/**
	 * Sets the value of the '{@link fr.obeo.webpage.model.webpage.webpage#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Calendar value);

} // webpage
