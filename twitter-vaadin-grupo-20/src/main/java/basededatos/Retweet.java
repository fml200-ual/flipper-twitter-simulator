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
@Table(name = "Retweet")
public class Retweet implements Serializable {
	public Retweet() {
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_RETWEET_TWEET) {
			this.tweet = (basededatos.Tweet) owner;
		}

		else if (key == ORMConstants.KEY_RETWEET_USUARIO_REGISTRADO) {
			this.usuario_Registrado = (basededatos.Usuario_Registrado) owner;
		}
	}

	@Transient
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};

	@Column(name = "ID", nullable = false, length = 10)
	@Id
	@GeneratedValue(generator = "BASEDEDATOS_RETWEET_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "BASEDEDATOS_RETWEET_ID_GENERATOR", strategy = "native")
	private int ID;

	@Column(name = "Tipo", nullable = true, length = 255)
	private String tipo;

	@Column(name = "FechaPublicacion", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date fechaPublicacion;

	@ManyToOne(targetEntity = basededatos.Usuario_Registrado.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns({
			@JoinColumn(name = "Usuario_RegistradoUsuario_AutentificadoId_usuario", referencedColumnName = "Usuario_AutentificadoId_usuario", nullable = false) })
	private basededatos.Usuario_Registrado usuario_Registrado;

	@ManyToOne(targetEntity = basededatos.Tweet.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns({ @JoinColumn(name = "TweetId_tweet", referencedColumnName = "Id_tweet", nullable = false) })
	private basededatos.Tweet tweet;

	private void setID(int value) {
		this.ID = value;
	}

	public int getID() {
		return ID;
	}

	public int getORMID() {
		return getID();
	}

	public void setTipo(String value) {
		this.tipo = value;
	}

	public String getTipo() {
		return tipo;
	}

	public void setFechaPublicacion(java.util.Date value) {
		this.fechaPublicacion = value;
	}

	public java.util.Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setTweet(basededatos.Tweet value) {
		if (tweet != null) {
			tweet.retweets.remove(this);
		}
		if (value != null) {
			value.retweets.add(this);
		}
	}

	public basededatos.Tweet getTweet() {
		return tweet;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Tweet(basededatos.Tweet value) {
		this.tweet = value;
	}

	private basededatos.Tweet getORM_Tweet() {
		return tweet;
	}

	public void setUsuario_Registrado(basededatos.Usuario_Registrado value) {
		if (usuario_Registrado != null) {
			usuario_Registrado.retweets.remove(this);
		}
		if (value != null) {
			value.retweets.add(this);
		}
	}

	public basededatos.Usuario_Registrado getUsuario_Registrado() {
		return usuario_Registrado;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Usuario_Registrado(basededatos.Usuario_Registrado value) {
		this.usuario_Registrado = value;
	}

	basededatos.Usuario_Registrado getORM_Usuario_Registrado() {
		return usuario_Registrado;
	}

	public String toString() {
		return String.valueOf(getID());
	}
}
