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
@Table(name="Documento")
public class Documento implements Serializable {
	public Documento() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_DOCUMENTO_TWEETS) {
			return ORM_tweets;
		}
		else if (key == ORMConstants.KEY_DOCUMENTO_COMENTARIOS) {
			return ORM_comentarios;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="Id_documento", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDEDATOS_DOCUMENTO_ID_DOCUMENTO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_DOCUMENTO_ID_DOCUMENTO_GENERATOR", strategy="native")	
	private int id_documento;
	
	@Column(name="ImagenVideoURL", nullable=true, length=255)	
	private String imagenVideoURL;
	
	@Column(name="Tipo", nullable=true, length=255)	
	private String tipo;
	
	@OneToMany(mappedBy="documento", targetEntity=basededatos.Tweet.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_tweets = new java.util.HashSet();
	
	@OneToMany(mappedBy="documento", targetEntity=basededatos.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_comentarios = new java.util.HashSet();
	
	private void setId_documento(int value) {
		this.id_documento = value;
	}
	
	public int getId_documento() {
		return id_documento;
	}
	
	public int getORMID() {
		return getId_documento();
	}
	
	public void setImagenVideoURL(String value) {
		this.imagenVideoURL = value;
	}
	
	public String getImagenVideoURL() {
		return imagenVideoURL;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	private void setORM_Tweets(java.util.Set value) {
		this.ORM_tweets = value;
	}
	
	private java.util.Set getORM_Tweets() {
		return ORM_tweets;
	}
	
	@Transient	
	public final basededatos.TweetSetCollection tweets = new basededatos.TweetSetCollection(this, _ormAdapter, ORMConstants.KEY_DOCUMENTO_TWEETS, ORMConstants.KEY_TWEET_DOCUMENTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Comentarios(java.util.Set value) {
		this.ORM_comentarios = value;
	}
	
	private java.util.Set getORM_Comentarios() {
		return ORM_comentarios;
	}
	
	@Transient	
	public final basededatos.ComentarioSetCollection comentarios = new basededatos.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_DOCUMENTO_COMENTARIOS, ORMConstants.KEY_COMENTARIO_DOCUMENTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_documento());
	}
	
}
