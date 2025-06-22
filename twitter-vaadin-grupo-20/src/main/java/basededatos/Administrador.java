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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Administrador")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="Usuario_AutentificadoId_usuario", referencedColumnName="Id_usuario")
public class Administrador extends basededatos.Usuario_Autentificado implements Serializable {
	public Administrador() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_ADMINISTRADOR_PROPIEDADESBANEOS) {
			return ORM_propiedadesBaneos;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@OneToMany(mappedBy="administrador", targetEntity=basededatos.PropiedadesBaneo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_propiedadesBaneos = new java.util.HashSet();
	
	public basededatos.Usuario_Registrado[] getUsuario_Registrados() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = propiedadesBaneos.getIterator();lIter.hasNext();) {
			lValues.add(((basededatos.PropiedadesBaneo)lIter.next()).getUsuario_Registrado());
		}
		return (basededatos.Usuario_Registrado[])lValues.toArray(new basededatos.Usuario_Registrado[lValues.size()]);
	}
	
	public void removeUsuario_Registrado(basededatos.Usuario_Registrado aUsuario_Registrado) {
		basededatos.PropiedadesBaneo[] lPropiedadesBaneos = propiedadesBaneos.toArray();
		for(int i = 0; i < lPropiedadesBaneos.length; i++) {
			if(lPropiedadesBaneos[i].getUsuario_Registrado().equals(aUsuario_Registrado)) {
				propiedadesBaneos.remove(lPropiedadesBaneos[i]);
			}
		}
	}
	
	public void addUsuario_Registrado(basededatos.PropiedadesBaneo aPropiedadesBaneo, basededatos.Usuario_Registrado aUsuario_Registrado) {
		aPropiedadesBaneo.setUsuario_Registrado(aUsuario_Registrado);
		propiedadesBaneos.add(aPropiedadesBaneo);
	}
	
	public basededatos.PropiedadesBaneo getPropiedadesBaneoByUsuario_Registrado(basededatos.Usuario_Registrado aUsuario_Registrado) {
		basededatos.PropiedadesBaneo[] lPropiedadesBaneos = propiedadesBaneos.toArray();
		for(int i = 0; i < lPropiedadesBaneos.length; i++) {
			if(lPropiedadesBaneos[i].getUsuario_Registrado().equals(aUsuario_Registrado)) {
				return lPropiedadesBaneos[i];
			}
		}
		return null;
	}
	
	private void setORM_PropiedadesBaneos(java.util.Set value) {
		this.ORM_propiedadesBaneos = value;
	}
	
	private java.util.Set getORM_PropiedadesBaneos() {
		return ORM_propiedadesBaneos;
	}
	
	@Transient	
	public final basededatos.PropiedadesBaneoSetCollection propiedadesBaneos = new basededatos.PropiedadesBaneoSetCollection(this, _ormAdapter, ORMConstants.KEY_ADMINISTRADOR_PROPIEDADESBANEOS, ORMConstants.KEY_PROPIEDADESBANEO_ADMINISTRADOR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
