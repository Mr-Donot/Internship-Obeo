/**
 */
package fr.obeo.webpage.model.webpage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.obeo.webpage.model.webpage.WebpageFactory
 * @model kind="package"
 * @generated
 */
public interface WebpagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "webpage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/webpage";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "webpage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WebpagePackage eINSTANCE = fr.obeo.webpage.model.webpage.impl.WebpagePackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.webpage.model.webpage.impl.webImpl <em>web</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.webpage.model.webpage.impl.webImpl
	 * @see fr.obeo.webpage.model.webpage.impl.WebpagePackageImpl#getweb()
	 * @generated
	 */
	int WEB = 0;

	/**
	 * The feature id for the '<em><b>Webpage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB__WEBPAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB__NAME = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB__TITLE = 2;

	/**
	 * The number of structural features of the '<em>web</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>web</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.obeo.webpage.model.webpage.impl.webpageImpl <em>webpage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.webpage.model.webpage.impl.webpageImpl
	 * @see fr.obeo.webpage.model.webpage.impl.WebpagePackageImpl#getwebpage()
	 * @generated
	 */
	int WEBPAGE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBPAGE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBPAGE__DATE = 1;

	/**
	 * The number of structural features of the '<em>webpage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBPAGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>webpage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBPAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Calendar</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Calendar
	 * @see fr.obeo.webpage.model.webpage.impl.WebpagePackageImpl#getCalendar()
	 * @generated
	 */
	int CALENDAR = 2;

	/**
	 * Returns the meta object for class '{@link fr.obeo.webpage.model.webpage.web <em>web</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>web</em>'.
	 * @see fr.obeo.webpage.model.webpage.web
	 * @generated
	 */
	EClass getweb();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.webpage.model.webpage.web#getWebpage <em>Webpage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Webpage</em>'.
	 * @see fr.obeo.webpage.model.webpage.web#getWebpage()
	 * @see #getweb()
	 * @generated
	 */
	EReference getweb_Webpage();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.webpage.model.webpage.web#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.webpage.model.webpage.web#getName()
	 * @see #getweb()
	 * @generated
	 */
	EAttribute getweb_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.webpage.model.webpage.web#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see fr.obeo.webpage.model.webpage.web#getTitle()
	 * @see #getweb()
	 * @generated
	 */
	EAttribute getweb_Title();

	/**
	 * Returns the meta object for class '{@link fr.obeo.webpage.model.webpage.webpage <em>webpage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>webpage</em>'.
	 * @see fr.obeo.webpage.model.webpage.webpage
	 * @generated
	 */
	EClass getwebpage();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.webpage.model.webpage.webpage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.webpage.model.webpage.webpage#getName()
	 * @see #getwebpage()
	 * @generated
	 */
	EAttribute getwebpage_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.webpage.model.webpage.webpage#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see fr.obeo.webpage.model.webpage.webpage#getDate()
	 * @see #getwebpage()
	 * @generated
	 */
	EAttribute getwebpage_Date();

	/**
	 * Returns the meta object for data type '{@link java.util.Calendar <em>Calendar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Calendar</em>'.
	 * @see java.util.Calendar
	 * @model instanceClass="java.util.Calendar"
	 * @generated
	 */
	EDataType getCalendar();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WebpageFactory getWebpageFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.obeo.webpage.model.webpage.impl.webImpl <em>web</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.webpage.model.webpage.impl.webImpl
		 * @see fr.obeo.webpage.model.webpage.impl.WebpagePackageImpl#getweb()
		 * @generated
		 */
		EClass WEB = eINSTANCE.getweb();

		/**
		 * The meta object literal for the '<em><b>Webpage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB__WEBPAGE = eINSTANCE.getweb_Webpage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB__NAME = eINSTANCE.getweb_Name();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB__TITLE = eINSTANCE.getweb_Title();

		/**
		 * The meta object literal for the '{@link fr.obeo.webpage.model.webpage.impl.webpageImpl <em>webpage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.webpage.model.webpage.impl.webpageImpl
		 * @see fr.obeo.webpage.model.webpage.impl.WebpagePackageImpl#getwebpage()
		 * @generated
		 */
		EClass WEBPAGE = eINSTANCE.getwebpage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEBPAGE__NAME = eINSTANCE.getwebpage_Name();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEBPAGE__DATE = eINSTANCE.getwebpage_Date();

		/**
		 * The meta object literal for the '<em>Calendar</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Calendar
		 * @see fr.obeo.webpage.model.webpage.impl.WebpagePackageImpl#getCalendar()
		 * @generated
		 */
		EDataType CALENDAR = eINSTANCE.getCalendar();

	}

} //WebpagePackage
