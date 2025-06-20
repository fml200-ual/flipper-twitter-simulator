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
@Table(name="PropiedadesSeguidos")
public class PropiedadesSeguidos implements Serializable {
	public PropiedadesSeguidos() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PROPIEDADESSEGUIDOS_SEGUIDORESUSUARIO_REGISTRADO) {
			this.seguidoresUsuario_registrado = (basededatos.Usuario_Registrado) owner;
		}
		
		else if (key == ORMConstants.KEY_PROPIEDADESSEGUIDOS_SEGUIDOSUSUARIO_REGISTRADO) {
			this.seguidosUsuario_registrado = (basededatos.Usuario_Registrado) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDEDATOS_PROPIEDADESSEGUIDOS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_PROPIEDADESSEGUIDOS_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Fecha", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fecha;
	
	@ManyToOne(targetEntity=basededatos.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Usuario_RegistradoUsuario_AutentificadoId_usuario", referencedColumnName="Usuario_AutentificadoId_usuario", nullable=false) })	
	private basededatos.Usuario_Registrado seguidosUsuario_registrado;
	
	@ManyToOne(targetEntity=basededatos.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Usuario_RegistradoUsuario_AutentificadoId_usuario2", referencedColumnName="Usuario_AutentificadoId_usuario", nullable=false) })	
	private basededatos.Usuario_Registrado seguidoresUsuario_registrado;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setFecha(java.util.Date value) {
		this.fecha = value;
	}
	
	public java.util.Date getFecha() {
		return fecha;
	}
	
	public void setSeguidoresUsuario_registrado(basededatos.Usuario_Registrado value) {
		if (seguidoresUsuario_registrado != null) {
			seguidoresUsuario_registrado.seguidosPropiedadesseguidoss.remove(this);
		}
		if (value != null) {
			value.seguidosPropiedadesseguidoss.add(this);
		}
	}
	
	public basededatos.Usuario_Registrado getSeguidoresUsuario_registrado() {
		return seguidoresUsuario_registrado;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_SeguidoresUsuario_registrado(basededatos.Usuario_Registrado value) {
		this.seguidoresUsuario_registrado = value;
	}
	
	private basededatos.Usuario_Registrado getORM_SeguidoresUsuario_registrado() {
		return seguidoresUsuario_registrado;
	}
	
	public void setSeguidosUsuario_registrado(basededatos.Usuario_Registrado value) {
		if (seguidosUsuario_registrado != null) {
			seguidosUsuario_registrado.seguidoresPropiedadesseguidoss.remove(this);
		}
		if (value != null) {
			value.seguidoresPropiedadesseguidoss.add(this);
		}
	}
	
	public basededatos.Usuario_Registrado getSeguidosUsuario_registrado() {
		return seguidosUsuario_registrado;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_SeguidosUsuario_registrado(basededatos.Usuario_Registrado value) {
		this.seguidosUsuario_registrado = value;
	}
	
	private basededatos.Usuario_Registrado getORM_SeguidosUsuario_registrado() {
		return seguidosUsuario_registrado;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
