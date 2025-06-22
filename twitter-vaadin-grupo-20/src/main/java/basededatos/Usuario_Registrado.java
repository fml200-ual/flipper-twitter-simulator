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
@Table(name="Usuario_Registrado")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="Usuario_AutentificadoId_usuario", referencedColumnName="Id_usuario")
public class Usuario_Registrado extends basededatos.Usuario_Autentificado implements Serializable {
	public Usuario_Registrado() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USUARIO_REGISTRADO_ME_GUSTA_COMENTARIOS) {
			return ORM_me_gusta_Comentarios;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_TWEETS) {
			return ORM_tweets;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_COMENTARIOS_PUBLICADOS) {
			return ORM_comentarios_publicados;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_PROPIEDADESMENCIONS) {
			return ORM_propiedadesMencions;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_RETWEETS) {
			return ORM_retweets;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_ME_GUSTA_TWEETS) {
			return ORM_me_gusta_tweets;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_SEGUIDORESPROPIEDADESSEGUIDOSS) {
			return ORM_seguidoresPropiedadesseguidoss;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_METIENENBLOQUEADO) {
			return ORM_meTienenBloqueado;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_SEGUIDOSPROPIEDADESSEGUIDOSS) {
			return ORM_seguidosPropiedadesseguidoss;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEADOS) {
			return ORM_bloqueados;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_USUARIO_REGISTRADO_PROPIEDADESBANEO) {
			this.propiedadesBaneo = (basededatos.PropiedadesBaneo) owner;
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
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="ImagenFondoURL", nullable=true, length=255)	
	private String imagenFondoURL;
	
	@Column(name="FotoPerfilURL", nullable=true, length=255)	
	private String fotoPerfilURL;
	
	@Column(name="CorreoElectronico", nullable=true, length=255)	
	private String correoElectronico;
	
	@Column(name="FechaDeRegistro", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaDeRegistro;
	
	@ManyToMany(targetEntity=basededatos.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Comentario_Usuario_Registrado2", joinColumns={ @JoinColumn(name="Usuario_RegistradoUsuario_AutentificadoId_usuario") }, inverseJoinColumns={ @JoinColumn(name="ComentarioId_comentario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_me_gusta_Comentarios = new java.util.HashSet();
	
	@OneToMany(mappedBy="publicado_por", targetEntity=basededatos.Tweet.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_tweets = new java.util.HashSet();
	
	@OneToMany(mappedBy="publicado_por", targetEntity=basededatos.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_comentarios_publicados = new java.util.HashSet();
	
	@OneToMany(mappedBy="usuario_Registrado", targetEntity=basededatos.PropiedadesMencion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_propiedadesMencions = new java.util.HashSet();
	
	@OneToMany(mappedBy="usuario_Registrado", targetEntity=basededatos.Retweet.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_retweets = new java.util.HashSet();
	
	@ManyToMany(targetEntity=basededatos.Tweet.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Tweet_Usuario_Registrado2", joinColumns={ @JoinColumn(name="Usuario_RegistradoUsuario_AutentificadoId_usuario") }, inverseJoinColumns={ @JoinColumn(name="TweetId_tweet") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_me_gusta_tweets = new java.util.HashSet();
	
	@OneToMany(mappedBy="seguidosUsuario_registrado", targetEntity=basededatos.PropiedadesSeguidos.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_seguidoresPropiedadesseguidoss = new java.util.HashSet();
	
	@OneToOne(mappedBy="usuario_Registrado", targetEntity=basededatos.PropiedadesBaneo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private basededatos.PropiedadesBaneo propiedadesBaneo;
	
	@ManyToMany(targetEntity=basededatos.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Registrado_Usuario_Registrado2", joinColumns={ @JoinColumn(name="Usuario_RegistradoUsuario_AutentificadoId_usuario2") }, inverseJoinColumns={ @JoinColumn(name="Usuario_RegistradoUsuario_AutentificadoId_usuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_meTienenBloqueado = new java.util.HashSet();
	
	@OneToMany(mappedBy="seguidoresUsuario_registrado", targetEntity=basededatos.PropiedadesSeguidos.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_seguidosPropiedadesseguidoss = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_meTienenBloqueado", targetEntity=basededatos.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_bloqueados = new java.util.HashSet();
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setImagenFondoURL(String value) {
		this.imagenFondoURL = value;
	}
	
	public String getImagenFondoURL() {
		return imagenFondoURL;
	}
	
	public void setFotoPerfilURL(String value) {
		this.fotoPerfilURL = value;
	}
	
	public String getFotoPerfilURL() {
		return fotoPerfilURL;
	}
	
	public void setCorreoElectronico(String value) {
		this.correoElectronico = value;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setFechaDeRegistro(java.util.Date value) {
		this.fechaDeRegistro = value;
	}
	
	public java.util.Date getFechaDeRegistro() {
		return fechaDeRegistro;
	}
	
	private void setORM_Me_gusta_Comentarios(java.util.Set value) {
		this.ORM_me_gusta_Comentarios = value;
	}
	
	private java.util.Set getORM_Me_gusta_Comentarios() {
		return ORM_me_gusta_Comentarios;
	}
	
	@Transient	
	public final basededatos.ComentarioSetCollection me_gusta_Comentarios = new basededatos.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_ME_GUSTA_COMENTARIOS, ORMConstants.KEY_COMENTARIO_RECIBE_ME_GUSTA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Tweets(java.util.Set value) {
		this.ORM_tweets = value;
	}
	
	private java.util.Set getORM_Tweets() {
		return ORM_tweets;
	}
	
	@Transient	
	public final basededatos.TweetSetCollection tweets = new basededatos.TweetSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_TWEETS, ORMConstants.KEY_TWEET_PUBLICADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Comentarios_publicados(java.util.Set value) {
		this.ORM_comentarios_publicados = value;
	}
	
	private java.util.Set getORM_Comentarios_publicados() {
		return ORM_comentarios_publicados;
	}
	
	@Transient	
	public final basededatos.ComentarioSetCollection comentarios_publicados = new basededatos.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_COMENTARIOS_PUBLICADOS, ORMConstants.KEY_COMENTARIO_PUBLICADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public basededatos.Tweet[] getMencionado_enTweets() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = propiedadesMencions.getIterator();lIter.hasNext();) {
			lValues.add(((basededatos.PropiedadesMencion)lIter.next()).getTweet());
		}
		return (basededatos.Tweet[])lValues.toArray(new basededatos.Tweet[lValues.size()]);
	}
	
	public void removeMencionado_enTweet(basededatos.Tweet aTweet) {
		basededatos.PropiedadesMencion[] lPropiedadesMencions = propiedadesMencions.toArray();
		for(int i = 0; i < lPropiedadesMencions.length; i++) {
			if(lPropiedadesMencions[i].getTweet().equals(aTweet)) {
				propiedadesMencions.remove(lPropiedadesMencions[i]);
			}
		}
	}
	
	public void addMencionado_enTweet(basededatos.PropiedadesMencion aPropiedadesMencion, basededatos.Tweet aTweet) {
		aPropiedadesMencion.setTweet(aTweet);
		propiedadesMencions.add(aPropiedadesMencion);
	}
	
	public basededatos.PropiedadesMencion getPropiedadesMencionByMencionado_enTweet(basededatos.Tweet aTweet) {
		basededatos.PropiedadesMencion[] lPropiedadesMencions = propiedadesMencions.toArray();
		for(int i = 0; i < lPropiedadesMencions.length; i++) {
			if(lPropiedadesMencions[i].getTweet().equals(aTweet)) {
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
	public final basededatos.PropiedadesMencionSetCollection propiedadesMencions = new basededatos.PropiedadesMencionSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_PROPIEDADESMENCIONS, ORMConstants.KEY_PROPIEDADESMENCION_USUARIO_REGISTRADO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public basededatos.Tweet[] getRetweet_hechosTweets() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = retweets.getIterator();lIter.hasNext();) {
			lValues.add(((basededatos.Retweet)lIter.next()).getTweet());
		}
		return (basededatos.Tweet[])lValues.toArray(new basededatos.Tweet[lValues.size()]);
	}
	
	public void removeRetweet_hechosTweet(basededatos.Tweet aTweet) {
		basededatos.Retweet[] lRetweets = retweets.toArray();
		for(int i = 0; i < lRetweets.length; i++) {
			if(lRetweets[i].getTweet().equals(aTweet)) {
				retweets.remove(lRetweets[i]);
			}
		}
	}
	
	public void addRetweet_hechosTweet(basededatos.Retweet aRetweet, basededatos.Tweet aTweet) {
		aRetweet.setTweet(aTweet);
		retweets.add(aRetweet);
	}
	
	public basededatos.Retweet getRetweetByRetweet_hechosTweet(basededatos.Tweet aTweet) {
		basededatos.Retweet[] lRetweets = retweets.toArray();
		for(int i = 0; i < lRetweets.length; i++) {
			if(lRetweets[i].getTweet().equals(aTweet)) {
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
	public final basededatos.RetweetSetCollection retweets = new basededatos.RetweetSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_RETWEETS, ORMConstants.KEY_RETWEET_USUARIO_REGISTRADO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Me_gusta_tweets(java.util.Set value) {
		this.ORM_me_gusta_tweets = value;
	}
	
	private java.util.Set getORM_Me_gusta_tweets() {
		return ORM_me_gusta_tweets;
	}
	
	@Transient	
	public final basededatos.TweetSetCollection me_gusta_tweets = new basededatos.TweetSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_ME_GUSTA_TWEETS, ORMConstants.KEY_TWEET_RECIBE_ME_GUSTA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public basededatos.Usuario_Registrado[] getSeguidoresUsuario_registrados() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = seguidoresPropiedadesseguidoss.getIterator();lIter.hasNext();) {
			lValues.add(((basededatos.PropiedadesSeguidos)lIter.next()).getSeguidoresUsuario_registrado());
		}
		return (basededatos.Usuario_Registrado[])lValues.toArray(new basededatos.Usuario_Registrado[lValues.size()]);
	}
	
	public void removeSeguidoresUsuario_registrado(basededatos.Usuario_Registrado aSeguidoresUsuario_registrado) {
		basededatos.PropiedadesSeguidos[] lSeguidoresPropiedadesseguidoss = seguidoresPropiedadesseguidoss.toArray();
		for(int i = 0; i < lSeguidoresPropiedadesseguidoss.length; i++) {
			if(lSeguidoresPropiedadesseguidoss[i].getSeguidoresUsuario_registrado().equals(aSeguidoresUsuario_registrado)) {
				seguidoresPropiedadesseguidoss.remove(lSeguidoresPropiedadesseguidoss[i]);
			}
		}
	}
	
	public void addSeguidoresUsuario_registrado(basededatos.PropiedadesSeguidos aPropiedadesSeguidos, basededatos.Usuario_Registrado aSeguidoresUsuario_registrado) {
		aPropiedadesSeguidos.setSeguidoresUsuario_registrado(aSeguidoresUsuario_registrado);
		seguidoresPropiedadesseguidoss.add(aPropiedadesSeguidos);
	}
	
	public basededatos.PropiedadesSeguidos getPropiedadesSeguidosBySeguidoresUsuario_registrado(basededatos.Usuario_Registrado aSeguidoresUsuario_registrado) {
		basededatos.PropiedadesSeguidos[] lSeguidoresPropiedadesseguidoss = seguidoresPropiedadesseguidoss.toArray();
		for(int i = 0; i < lSeguidoresPropiedadesseguidoss.length; i++) {
			if(lSeguidoresPropiedadesseguidoss[i].getSeguidoresUsuario_registrado().equals(aSeguidoresUsuario_registrado)) {
				return lSeguidoresPropiedadesseguidoss[i];
			}
		}
		return null;
	}
	
	private void setORM_SeguidoresPropiedadesseguidoss(java.util.Set value) {
		this.ORM_seguidoresPropiedadesseguidoss = value;
	}
	
	private java.util.Set getORM_SeguidoresPropiedadesseguidoss() {
		return ORM_seguidoresPropiedadesseguidoss;
	}
	
	@Transient	
	public final basededatos.PropiedadesSeguidosSetCollection seguidoresPropiedadesseguidoss = new basededatos.PropiedadesSeguidosSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_SEGUIDORESPROPIEDADESSEGUIDOSS, ORMConstants.KEY_PROPIEDADESSEGUIDOS_SEGUIDOSUSUARIO_REGISTRADO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public basededatos.Administrador getAdministrador() {
		if(propiedadesBaneo != null) {
			return propiedadesBaneo.getAdministrador();
		}
		else {
			return null;
		}
	}
	
	public void removeAdministrador() {
		if(propiedadesBaneo!= null) {
			propiedadesBaneo.setAdministrador(null);
			this.setPropiedadesBaneo(null);
		}
	}
	
	public void addAdministrador(basededatos.PropiedadesBaneo aPropiedadesBaneo, basededatos.Administrador aAdministrador) {
		this.setPropiedadesBaneo(aPropiedadesBaneo);
		aPropiedadesBaneo.setAdministrador(aAdministrador);
	}
	
	public void setPropiedadesBaneo(basededatos.PropiedadesBaneo value) {
		if (this.propiedadesBaneo != value) {
			basededatos.PropiedadesBaneo lpropiedadesBaneo = this.propiedadesBaneo;
			this.propiedadesBaneo = value;
			if (value != null) {
				propiedadesBaneo.setUsuario_Registrado(this);
			}
			if (lpropiedadesBaneo != null && lpropiedadesBaneo.getUsuario_Registrado() == this) {
				lpropiedadesBaneo.setUsuario_Registrado(null);
			}
		}
	}
	
	public basededatos.PropiedadesBaneo getPropiedadesBaneo() {
		return propiedadesBaneo;
	}
	
	private void setORM_MeTienenBloqueado(java.util.Set value) {
		this.ORM_meTienenBloqueado = value;
	}
	
	private java.util.Set getORM_MeTienenBloqueado() {
		return ORM_meTienenBloqueado;
	}
	
	@Transient	
	public final basededatos.Usuario_RegistradoSetCollection meTienenBloqueado = new basededatos.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_METIENENBLOQUEADO, ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEADOS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public basededatos.Usuario_Registrado[] getSeguidosUsuario_registrados() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = seguidosPropiedadesseguidoss.getIterator();lIter.hasNext();) {
			lValues.add(((basededatos.PropiedadesSeguidos)lIter.next()).getSeguidosUsuario_registrado());
		}
		return (basededatos.Usuario_Registrado[])lValues.toArray(new basededatos.Usuario_Registrado[lValues.size()]);
	}
	
	public void removeSeguidosUsuario_registrado(basededatos.Usuario_Registrado aSeguidosUsuario_registrado) {
		basededatos.PropiedadesSeguidos[] lSeguidosPropiedadesseguidoss = seguidosPropiedadesseguidoss.toArray();
		for(int i = 0; i < lSeguidosPropiedadesseguidoss.length; i++) {
			if(lSeguidosPropiedadesseguidoss[i].getSeguidosUsuario_registrado().equals(aSeguidosUsuario_registrado)) {
				seguidosPropiedadesseguidoss.remove(lSeguidosPropiedadesseguidoss[i]);
			}
		}
	}
	
	public void addSeguidosUsuario_registrado(basededatos.PropiedadesSeguidos aPropiedadesSeguidos, basededatos.Usuario_Registrado aSeguidosUsuario_registrado) {
		aPropiedadesSeguidos.setSeguidosUsuario_registrado(aSeguidosUsuario_registrado);
		seguidosPropiedadesseguidoss.add(aPropiedadesSeguidos);
	}
	
	public basededatos.PropiedadesSeguidos getPropiedadesSeguidosBySeguidosUsuario_registrado(basededatos.Usuario_Registrado aSeguidosUsuario_registrado) {
		basededatos.PropiedadesSeguidos[] lSeguidosPropiedadesseguidoss = seguidosPropiedadesseguidoss.toArray();
		for(int i = 0; i < lSeguidosPropiedadesseguidoss.length; i++) {
			if(lSeguidosPropiedadesseguidoss[i].getSeguidosUsuario_registrado().equals(aSeguidosUsuario_registrado)) {
				return lSeguidosPropiedadesseguidoss[i];
			}
		}
		return null;
	}
	
	private void setORM_SeguidosPropiedadesseguidoss(java.util.Set value) {
		this.ORM_seguidosPropiedadesseguidoss = value;
	}
	
	private java.util.Set getORM_SeguidosPropiedadesseguidoss() {
		return ORM_seguidosPropiedadesseguidoss;
	}
	
	@Transient	
	public final basededatos.PropiedadesSeguidosSetCollection seguidosPropiedadesseguidoss = new basededatos.PropiedadesSeguidosSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_SEGUIDOSPROPIEDADESSEGUIDOSS, ORMConstants.KEY_PROPIEDADESSEGUIDOS_SEGUIDORESUSUARIO_REGISTRADO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Bloqueados(java.util.Set value) {
		this.ORM_bloqueados = value;
	}
	
	private java.util.Set getORM_Bloqueados() {
		return ORM_bloqueados;
	}
	
	@Transient	
	public final basededatos.Usuario_RegistradoSetCollection bloqueados = new basededatos.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEADOS, ORMConstants.KEY_USUARIO_REGISTRADO_METIENENBLOQUEADO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
