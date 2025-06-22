/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package basededatos;

import org.orm.*;

public class Usuario_RegistradoSetCollection extends org.orm.util.ORMSet {
	public Usuario_RegistradoSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public Usuario_RegistradoSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persistent objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMSet
	 * @param value the persistent object
	 */
	public void add(Usuario_Registrado value) {
		if (value != null) {
			super.add(value, value._ormAdapter);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMSet
	 * @param value the persistent object
	 */
	public void remove(Usuario_Registrado value) {
		super.remove(value, value._ormAdapter);
	}
	
	/**
	 * Return true if ORMSet contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Usuario_Registrado value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMSet
	 * @return The persistent objects array
	 */
	public Usuario_Registrado[] toArray() {
		return (Usuario_Registrado[]) super.toArray(new Usuario_Registrado[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>descripcion</li>
	 * <li>imagenFondoURL</li>
	 * <li>fotoPerfilURL</li>
	 * <li>correoElectronico</li>
	 * <li>fechaDeRegistro</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Usuario_Registrado[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>descripcion</li>
	 * <li>imagenFondoURL</li>
	 * <li>fotoPerfilURL</li>
	 * <li>correoElectronico</li>
	 * <li>fechaDeRegistro</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Usuario_Registrado[] toArray(String propertyName, boolean ascending) {
		return (Usuario_Registrado[]) super.toArray(new Usuario_Registrado[size()], propertyName, ascending);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return MDS22425PFMurilloSuanesPersistentManager.instance();
	}
	
}

