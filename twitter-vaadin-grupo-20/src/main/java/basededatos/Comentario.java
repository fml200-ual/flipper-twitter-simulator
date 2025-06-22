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
@Table(name="Comentario")
public class Comentario implements Serializable {
	public Comentario() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_COMENTARIO_RECIBE_ME_GUSTA) {
			return ORM_recibe_me_gusta;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_COMENTARIO_DOCUMENTO) {
			this.documento = (basededatos.Documento) owner;
		}
		
		else if (key == ORMConstants.KEY_COMENTARIO_PERTENECE) {
			this.pertenece = (basededatos.Tweet) owner;
		}
		
		else if (key == ORMConstants.KEY_COMENTARIO_PUBLICADO_POR) {
			this.publicado_por = (basededatos.Usuario_Registrado) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="Id_comentario", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDEDATOS_COMENTARIO_ID_COMENTARIO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_COMENTARIO_ID_COMENTARIO_GENERATOR", strategy="native")	
	private int id_comentario;
	
	@ManyToOne(targetEntity=basededatos.Documento.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="DocumentoId_documento", referencedColumnName="Id_documento") }, foreignKey=@ForeignKey(name="FKComentario904784"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Documento documento;
	
	@ManyToOne(targetEntity=basededatos.Usuario_Registrado.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="Usuario_RegistradoUsuario_AutentificadoId_usuario", referencedColumnName="Usuario_AutentificadoId_usuario", nullable=false) }, foreignKey=@ForeignKey(name="FKComentario147004"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Usuario_Registrado publicado_por;
	
	@ManyToOne(targetEntity=basededatos.Tweet.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TweetId_tweet", referencedColumnName="Id_tweet", nullable=false) }, foreignKey=@ForeignKey(name="FKComentario15163"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private basededatos.Tweet pertenece;
	
	@Column(name="ContenidoComentario", nullable=true, length=255)	
	private String contenidoComentario;
	
	@Column(name="FechaPublicacion", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaPublicacion;
	
	@ManyToMany(mappedBy="ORM_me_gusta_Comentarios", targetEntity=basededatos.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_recibe_me_gusta = new java.util.HashSet();
	
	private void setId_comentario(int value) {
		this.id_comentario = value;
	}
	
	public int getId_comentario() {
		return id_comentario;
	}
	
	public int getORMID() {
		return getId_comentario();
	}
	
	public void setContenidoComentario(String value) {
		this.contenidoComentario = value;
	}
	
	public String getContenidoComentario() {
		return contenidoComentario;
	}
	
	public void setFechaPublicacion(java.util.Date value) {
		this.fechaPublicacion = value;
	}
	
	public java.util.Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public void setDocumento(basededatos.Documento value) {
		if (documento != null) {
			documento.comentarios.remove(this);
		}
		if (value != null) {
			value.comentarios.add(this);
		}
	}
	
	public basededatos.Documento getDocumento() {
		return documento;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Documento(basededatos.Documento value) {
		this.documento = value;
	}
	
	private basededatos.Documento getORM_Documento() {
		return documento;
	}
	
	public void setPertenece(basededatos.Tweet value) {
		if (pertenece != null) {
			pertenece.tiene.remove(this);
		}
		if (value != null) {
			value.tiene.add(this);
		}
	}
	
	public basededatos.Tweet getPertenece() {
		return pertenece;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pertenece(basededatos.Tweet value) {
		this.pertenece = value;
	}
	
	private basededatos.Tweet getORM_Pertenece() {
		return pertenece;
	}
	
	public void setPublicado_por(basededatos.Usuario_Registrado value) {
		if (publicado_por != null) {
			publicado_por.comentarios_publicados.remove(this);
		}
		if (value != null) {
			value.comentarios_publicados.add(this);
		}
	}
	
	public basededatos.Usuario_Registrado getPublicado_por() {
		return publicado_por;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Publicado_por(basededatos.Usuario_Registrado value) {
		this.publicado_por = value;
	}
	
	private basededatos.Usuario_Registrado getORM_Publicado_por() {
		return publicado_por;
	}
	
	private void setORM_Recibe_me_gusta(java.util.Set value) {
		this.ORM_recibe_me_gusta = value;
	}
	
	private java.util.Set getORM_Recibe_me_gusta() {
		return ORM_recibe_me_gusta;
	}
	
	@Transient	
	public final basededatos.Usuario_RegistradoSetCollection recibe_me_gusta = new basededatos.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_COMENTARIO_RECIBE_ME_GUSTA, ORMConstants.KEY_USUARIO_REGISTRADO_ME_GUSTA_COMENTARIOS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_comentario());
	}
	
}
