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
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "Tweet")
public class Tweet implements Serializable {
	public Tweet() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == ORMConstants.KEY_TWEET_TIENE_HASHTAG) {
			return ORM_tiene_hashtag;
		} else if (key == ORMConstants.KEY_TWEET_RETWEETS_CITA) {
			return ORM_retweets_Cita;
		} else if (key == ORMConstants.KEY_TWEET_TIENE) {
			return ORM_tiene;
		} else if (key == ORMConstants.KEY_TWEET_PROPIEDADESMENCIONS) {
			return ORM_propiedadesMencions;
		} else if (key == ORMConstants.KEY_TWEET_RETWEETS) {
			return ORM_retweets;
		} else if (key == ORMConstants.KEY_TWEET_RECIBE_ME_GUSTA) {
			return ORM_recibe_me_gusta;
		}

		return null;
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_TWEET_PUBLICADO_POR) {
			this.publicado_por = (basededatos.Usuario_Registrado) owner;
		}

		else if (key == ORMConstants.KEY_TWEET_DOCUMENTO) {
			this.documento = (basededatos.Documento) owner;
		}

		else if (key == ORMConstants.KEY_TWEET_TWEET_RETWEETEADO) {
			this.tweet_retweeteado = (basededatos.Tweet) owner;
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

	@Column(name = "Id_tweet", nullable = false, length = 10)
	@Id
	@GeneratedValue(generator = "BASEDEDATOS_TWEET_ID_TWEET_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "BASEDEDATOS_TWEET_ID_TWEET_GENERATOR", strategy = "native")
	private int id_tweet;

	@ManyToOne(targetEntity = basededatos.Usuario_Registrado.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "Usuario_RegistradoUsuario_AutentificadoId_usuario", referencedColumnName = "Usuario_AutentificadoId_usuario", nullable = false) }, foreignKey = @ForeignKey(name = "FKTweet158911"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private basededatos.Usuario_Registrado publicado_por;

	@ManyToOne(targetEntity = basededatos.Documento.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "DocumentoId_documento", referencedColumnName = "Id_documento") }, foreignKey = @ForeignKey(name = "FKTweet916691"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private basededatos.Documento documento;

	@ManyToOne(targetEntity = basededatos.Tweet.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "TweetId_tweet", referencedColumnName = "Id_tweet") }, foreignKey = @ForeignKey(name = "FKTweet27070"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private basededatos.Tweet tweet_retweeteado;

	@Column(name = "ContenidoTweet", nullable = true, length = 255)
	private String contenidoTweet;

	@Column(name = "FechaPublicacion", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date fechaPublicacion;

	@ManyToMany(targetEntity = basededatos.Hashtag.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "Hashtag_Tweet2", joinColumns = { @JoinColumn(name = "TweetId_tweet") }, inverseJoinColumns = {
			@JoinColumn(name = "HashtagId_hashtag") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_tiene_hashtag = new java.util.HashSet();

	@OneToMany(mappedBy = "tweet_retweeteado", targetEntity = basededatos.Tweet.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_retweets_Cita = new java.util.HashSet();

	@OneToMany(mappedBy = "pertenece", targetEntity = basededatos.Comentario.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_tiene = new java.util.HashSet();

	@OneToMany(mappedBy = "tweet", targetEntity = basededatos.PropiedadesMencion.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_propiedadesMencions = new java.util.HashSet();

	@OneToMany(mappedBy = "tweet", targetEntity = basededatos.Retweet.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_retweets = new java.util.HashSet();

	@ManyToMany(mappedBy = "ORM_me_gusta_tweets", targetEntity = basededatos.Usuario_Registrado.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_recibe_me_gusta = new java.util.HashSet();

	private void setId_tweet(int value) {
		this.id_tweet = value;
	}

	public int getId_tweet() {
		return id_tweet;
	}

	public int getORMID() {
		return getId_tweet();
	}

	public void setContenidoTweet(String value) {
		this.contenidoTweet = value;
	}

	public String getContenidoTweet() {
		return contenidoTweet;
	}

	public void setFechaPublicacion(java.util.Date value) {
		this.fechaPublicacion = value;
	}

	public java.util.Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	private void setORM_Tiene_hashtag(java.util.Set value) {
		this.ORM_tiene_hashtag = value;
	}

	private java.util.Set getORM_Tiene_hashtag() {
		return ORM_tiene_hashtag;
	}

	@Transient
	public final basededatos.HashtagSetCollection tiene_hashtag = new basededatos.HashtagSetCollection(this,
			_ormAdapter, ORMConstants.KEY_TWEET_TIENE_HASHTAG, ORMConstants.KEY_HASHTAG_PERTENECE,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	private void setORM_Retweets_Cita(java.util.Set value) {
		this.ORM_retweets_Cita = value;
	}

	private java.util.Set getORM_Retweets_Cita() {
		return ORM_retweets_Cita;
	}

	@Transient
	public final basededatos.TweetSetCollection retweets_Cita = new basededatos.TweetSetCollection(this, _ormAdapter,
			ORMConstants.KEY_TWEET_RETWEETS_CITA, ORMConstants.KEY_TWEET_TWEET_RETWEETEADO,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	private void setORM_Tiene(java.util.Set value) {
		this.ORM_tiene = value;
	}

	private java.util.Set getORM_Tiene() {
		return ORM_tiene;
	}

	@Transient
	public final basededatos.ComentarioSetCollection tiene = new basededatos.ComentarioSetCollection(this, _ormAdapter,
			ORMConstants.KEY_TWEET_TIENE, ORMConstants.KEY_COMENTARIO_PERTENECE, ORMConstants.KEY_MUL_ONE_TO_MANY);

	public void setPublicado_por(basededatos.Usuario_Registrado value) {
		if (publicado_por != null) {
			publicado_por.tweets.remove(this);
		}
		if (value != null) {
			value.tweets.add(this);
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

	public basededatos.Usuario_Registrado[] getMencionesUsuario_registrados() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for (java.util.Iterator lIter = propiedadesMencions.getIterator(); lIter.hasNext();) {
			lValues.add(((basededatos.PropiedadesMencion) lIter.next()).getORM_Usuario_Registrado());
		}
		return (basededatos.Usuario_Registrado[]) lValues.toArray(new basededatos.Usuario_Registrado[lValues.size()]);
	}

	public void removeMencionesUsuario_registrado(basededatos.Usuario_Registrado aUsuario_registrado) {
		basededatos.PropiedadesMencion[] lPropiedadesMencions = propiedadesMencions.toArray();
		for (int i = 0; i < lPropiedadesMencions.length; i++) {
			if (lPropiedadesMencions[i].getORM_Usuario_Registrado().equals(aUsuario_registrado)) {
				propiedadesMencions.remove(lPropiedadesMencions[i]);
			}
		}
	}

	public void addMencionesUsuario_registrado(basededatos.PropiedadesMencion aPropiedadesMencion,
			basededatos.Usuario_Registrado aUsuario_registrado) {
		aPropiedadesMencion.setUsuario_Registrado(aUsuario_registrado);
		propiedadesMencions.add(aPropiedadesMencion);
	}

	public basededatos.PropiedadesMencion getPropiedadesMencionByMencionesUsuario_registrado(
			basededatos.Usuario_Registrado aUsuario_registrado) {
		basededatos.PropiedadesMencion[] lPropiedadesMencions = propiedadesMencions.toArray();
		for (int i = 0; i < lPropiedadesMencions.length; i++) {
			if (lPropiedadesMencions[i].getORM_Usuario_Registrado().equals(aUsuario_registrado)) {
				return lPropiedadesMencions[i];
			}
		}
		return null;
	}

	private void setORM_PropiedadesMencions(java.util.Set value) {
		this.ORM_propiedadesMencions = value;
	}

	private java.util.Set getORM_PropiedadesMencions() {
		return ORM_propiedadesMencions;
	}

	@Transient
	public final basededatos.PropiedadesMencionSetCollection propiedadesMencions = new basededatos.PropiedadesMencionSetCollection(
			this, _ormAdapter, ORMConstants.KEY_TWEET_PROPIEDADESMENCIONS, ORMConstants.KEY_PROPIEDADESMENCION_TWEET,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	public basededatos.Usuario_Registrado[] getRetweet_hecho_porUsuario_registrados() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for (java.util.Iterator lIter = retweets.getIterator(); lIter.hasNext();) {
			lValues.add(((basededatos.Retweet) lIter.next()).getORM_Usuario_Registrado());
		}
		return (basededatos.Usuario_Registrado[]) lValues.toArray(new basededatos.Usuario_Registrado[lValues.size()]);
	}

	public void removeRetweet_hecho_porUsuario_registrado(basededatos.Usuario_Registrado aUsuario_registrado) {
		basededatos.Retweet[] lRetweets = retweets.toArray();
		for (int i = 0; i < lRetweets.length; i++) {
			if (lRetweets[i].getORM_Usuario_Registrado().equals(aUsuario_registrado)) {
				retweets.remove(lRetweets[i]);
			}
		}
	}

	public void addRetweet_hecho_porUsuario_registrado(basededatos.Retweet aRetweet,
			basededatos.Usuario_Registrado aUsuario_registrado) {
		aRetweet.setUsuario_Registrado(aUsuario_registrado);
		retweets.add(aRetweet);
	}

	public basededatos.Retweet getRetweetByRetweet_hecho_porUsuario_registrado(
			basededatos.Usuario_Registrado aUsuario_registrado) {
		basededatos.Retweet[] lRetweets = retweets.toArray();
		for (int i = 0; i < lRetweets.length; i++) {
			if (lRetweets[i].getORM_Usuario_Registrado().equals(aUsuario_registrado)) {
				return lRetweets[i];
			}
		}
		return null;
	}

	private void setORM_Retweets(java.util.Set value) {
		this.ORM_retweets = value;
	}

	private java.util.Set getORM_Retweets() {
		return ORM_retweets;
	}

	@Transient
	public final basededatos.RetweetSetCollection retweets = new basededatos.RetweetSetCollection(this, _ormAdapter,
			ORMConstants.KEY_TWEET_RETWEETS, ORMConstants.KEY_RETWEET_TWEET, ORMConstants.KEY_MUL_ONE_TO_MANY);

	private void setORM_Recibe_me_gusta(java.util.Set value) {
		this.ORM_recibe_me_gusta = value;
	}

	private java.util.Set getORM_Recibe_me_gusta() {
		return ORM_recibe_me_gusta;
	}

	@Transient
	public final basededatos.Usuario_RegistradoSetCollection recibe_me_gusta = new basededatos.Usuario_RegistradoSetCollection(
			this, _ormAdapter, ORMConstants.KEY_TWEET_RECIBE_ME_GUSTA,
			ORMConstants.KEY_USUARIO_REGISTRADO_ME_GUSTA_TWEETS, ORMConstants.KEY_MUL_MANY_TO_MANY);

	public void setDocumento(basededatos.Documento value) {
		if (documento != null) {
			documento.tweets.remove(this);
		}
		if (value != null) {
			value.tweets.add(this);
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

	public void setTweet_retweeteado(basededatos.Tweet value) {
		if (tweet_retweeteado != null) {
			tweet_retweeteado.retweets_Cita.remove(this);
		}
		if (value != null) {
			value.retweets_Cita.add(this);
		}
	}

	public basededatos.Tweet getTweet_retweeteado() {
		return tweet_retweeteado;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Tweet_retweeteado(basededatos.Tweet value) {
		this.tweet_retweeteado = value;
	}

	private basededatos.Tweet getORM_Tweet_retweeteado() {
		return tweet_retweeteado;
	}

	public String toString() {
		return String.valueOf(getId_tweet());
	}

}
