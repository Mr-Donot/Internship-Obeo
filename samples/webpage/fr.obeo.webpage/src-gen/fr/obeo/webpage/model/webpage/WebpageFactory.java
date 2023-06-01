/**
 */
package fr.obeo.webpage.model.webpage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.webpage.model.webpage.WebpagePackage
 * @generated
 */
public interface WebpageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WebpageFactory eINSTANCE = fr.obeo.webpage.model.webpage.impl.WebpageFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>web</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>web</em>'.
	 * @generated
	 */
	web createweb();

	/**
	 * Returns a new object of class '<em>webpage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>webpage</em>'.
	 * @generated
	 */
	webpage createwebpage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WebpagePackage getWebpagePackage();

} //WebpageFactory
