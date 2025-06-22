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
@Table(name="Usuario_Autentificado")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario_Autentificado implements Serializable {
	public Usuario_Autentificado() {
	}
	
	@Column(name="Id_usuario", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDEDATOS_USUARIO_AUTENTIFICADO_ID_USUARIO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_USUARIO_AUTENTIFICADO_ID_USUARIO_GENERATOR", strategy="native")	
	private int id_usuario;
	
	@Column(name="Nickname", nullable=true, length=255)	
	private String nickname;
	
	@Column(name="Contrasena", nullable=true, length=255)	
	private String contrasena;
	
	private void setId_usuario(int value) {
		this.id_usuario = value;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public int getORMID() {
		return getId_usuario();
	}
	
	public void setNickname(String value) {
		this.nickname = value;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setContrasena(String value) {
		this.contrasena = value;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public String toString() {
		return String.valueOf(getId_usuario());
	}
	
}
