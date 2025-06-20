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
@Table(name="PropiedadesBaneo")
public class PropiedadesBaneo implements Serializable {
	public PropiedadesBaneo() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PROPIEDADESBANEO_ADMINISTRADOR) {
			this.administrador = (basededatos.Administrador) owner;
		}
		
		else if (key == ORMConstants.KEY_PROPIEDADESBANEO_USUARIO_REGISTRADO) {
			this.usuario_Registrado = (basededatos.Usuario_Registrado) owner;
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
	@GeneratedValue(generator="BASEDEDATOS_PROPIEDADESBANEO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_PROPIEDADESBANEO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Duracion", nullable=false, length=10)	
	private int duracion;
	
	@Column(name="FechaInicioBaneo", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaInicioBaneo;
	
	@OneToOne(targetEntity=basededatos.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Usuario_RegistradoUsuario_AutentificadoId_usuario", referencedColumnName="Usuario_AutentificadoId_usuario", nullable=false) })	
	private basededatos.Usuario_Registrado usuario_Registrado;
	
	@ManyToOne(targetEntity=basededatos.Administrador.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="AdministradorUsuario_AutentificadoId_usuario", referencedColumnName="Usuario_AutentificadoId_usuario", nullable=false) })	
	private basededatos.Administrador administrador;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDuracion(int value) {
		this.duracion = value;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setFechaInicioBaneo(java.util.Date value) {
		this.fechaInicioBaneo = value;
	}
	
	public java.util.Date getFechaInicioBaneo() {
		return fechaInicioBaneo;
	}
	
	public void setAdministrador(basededatos.Administrador value) {
		if (administrador != null) {
			administrador.propiedadesBaneos.remove(this);
		}
		if (value != null) {
			value.propiedadesBaneos.add(this);
		}
	}
	
	public basededatos.Administrador getAdministrador() {
		return administrador;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Administrador(basededatos.Administrador value) {
		this.administrador = value;
	}
	
	private basededatos.Administrador getORM_Administrador() {
		return administrador;
	}
	
	public void setUsuario_Registrado(basededatos.Usuario_Registrado value) {
		if (this.usuario_Registrado != value) {
			basededatos.Usuario_Registrado lusuario_Registrado = this.usuario_Registrado;
			this.usuario_Registrado = value;
			if (value != null) {
				usuario_Registrado.setPropiedadesBaneo(this);
			}
			if (lusuario_Registrado != null && lusuario_Registrado.getPropiedadesBaneo() == this) {
				lusuario_Registrado.setPropiedadesBaneo(null);
			}
		}
	}
	
	public basededatos.Usuario_Registrado getUsuario_Registrado() {
		return usuario_Registrado;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
