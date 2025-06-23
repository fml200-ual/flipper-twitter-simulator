package basededatos;

import java.util.Date;


public class BDPrincipal implements iUsuarioNoRegistrado, iUsuarioRegistrado, iAdministrador {
	public BD_Hashtag bd_hashtag = new BD_Hashtag();
	public BD_Tweet bd_tweet = new BD_Tweet();
	public BD_Documento bd_documento = new BD_Documento();
	public BD_Comentario bd_comentario = new BD_Comentario();
	public BD_Usuario_Registrado bd_userR = new BD_Usuario_Registrado();
	public BD_Administrador bd_admin = new BD_Administrador();

	public Usuario_Registrado login(String nombreUsuario, String contrasena) {
		try {
			return this.bd_userR.login(nombreUsuario, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Administrador loginAdmin(String nombreUsuario, String contrasena) {
		try {
			return this.bd_admin.loginAdmin(nombreUsuario, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado validacionCorreo(String correoElectronico) {
		try {
			return this.bd_userR.validacionCorreo(correoElectronico);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void cambiarContrasena(int id_usuario, String contrasena) {
	try {
			this.bd_userR.cambiarContrasena(id_usuario, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario_Registrado registrar(String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena, Date fechaRegistro) {
		try {
			return this.bd_userR.registrar(nickname, descripcion, imagenFondoURL, fotoPerfilURL, correoElectronico, contrasena, fechaRegistro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado[] cargarUsuarios() {
		try {
			return this.bd_userR.cargarUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Hashtag[] cargarHashtags() {
		try {
			return this.bd_hashtag.cargarHashtags();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado modificarPerfilSimple(int id_usuario, String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String contrasena) {
		try {
			return this.bd_userR.modificarPerfilSimple(id_usuario, nickname, descripcion, imagenFondoURL, fotoPerfilURL, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado modificarPerfilCompleto(int id_usuario, String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena) {
		try {
			return this.bd_userR.modificarPerfilCompleto(id_usuario, nickname, descripcion, imagenFondoURL, fotoPerfilURL, correoElectronico, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado publicarTweet(int id_usuario, String contenidoTweet, Date fechaPublicacion, String URLDocumento, String tipoDocumento, String[] hashtags, String[] menciones) {
		try {
			int id_tweet = this.bd_tweet.nuevoTweet(id_usuario, contenidoTweet, fechaPublicacion, menciones);
			if (tipoDocumento != null) {
				this.bd_documento.nuevoDocumentoTweet(id_tweet, URLDocumento, tipoDocumento);
			}
			if (hashtags != null) {
				this.bd_hashtag.nuevoTweetHashtag(id_tweet, hashtags);
			}			
			return this.bd_userR.obtenerUsuarioByID(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado publicarComentario(int id_usuario, int id_tweet, String contenidoComentario, String URLDocumento, Date fechaPublicacion, String tipoDocumento) {
		try {
			int id_comentario = this.bd_comentario.nuevoComentario(id_usuario, id_tweet, contenidoComentario, fechaPublicacion);
			if (tipoDocumento != null) {
				this.bd_documento.nuevoDocumentoComentario(id_comentario, URLDocumento, tipoDocumento);
			}
			return this.bd_userR.obtenerUsuarioByID(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado seguir(int id_usuario, int id_usuarioSeguido, Date fechaSeguimiento) {
		try {
			this.bd_userR.seguir(id_usuario, id_usuarioSeguido, fechaSeguimiento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void eliminarPerfil(int id_usuario) {
		try {
			this.bd_userR.eliminarUsuario(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario_Registrado darMeGustaTweet(int id_usuario, int id_tweet) {
		try {
			return this.bd_userR.darMeGustaTweet(id_usuario, id_tweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado bloquear(int id_usuario, int id_usuarioBloqueado) {
		try {
			return this.bd_userR.bloquear(id_usuario, id_usuarioBloqueado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado darRetweet(int id_usuario, int id_tweet, Date fechaPublicacion) {
		try {
			return this.bd_userR.darRetweet(id_usuario, id_tweet, fechaPublicacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado publicarRetweet(int id_usuario, int id_tweetRetweeteado, String contenidoRetweet, String URLDocumento, String tipoDocumento, Date fechaPublicacion, String[] hashtags, String[] menciones) {
		try {
			int id_tweet = this.bd_tweet.nuevoRetweet(id_usuario, id_tweetRetweeteado, contenidoRetweet, fechaPublicacion, menciones);
			if (tipoDocumento != null) {
				this.bd_documento.nuevoDocumentoTweet(id_tweet, URLDocumento, tipoDocumento);
			}
			if (hashtags != null) {
				this.bd_hashtag.nuevoTweetHashtag(id_tweet, hashtags);
			}
			return this.bd_userR.obtenerUsuarioByID(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado darMeGustaComentario(int id_usuario, int id_comentario) {
		try {
			return this.bd_userR.darMeGustaComentario(id_usuario, id_comentario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado eliminarMgTweet(int id_usuario, int id_tweet) {
		try {
			return this.bd_userR.eliminarMgTweet(id_usuario, id_tweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado eliminarRetweet(int id_usuario, int id_tweet) {
		try {
			return this.bd_tweet.eliminarRetweet(id_usuario, id_tweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado eliminarMgComentario(int id_usuario, int id_comentario) {
		try {
			return this.bd_userR.eliminarMgComentario(id_usuario, id_comentario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Administrador banear(int id_administrador, int id_usuarioBaneado, int duracionBaneo, Date fechaInicioBaneo) {
		try {
			return this.bd_admin.banear(id_administrador, id_usuarioBaneado, duracionBaneo, fechaInicioBaneo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void eliminarUsuario(int id_usuario) {
		try {
			this.bd_userR.eliminarUsuario(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Tweet[] cargarTweets() {
		try {
			return this.bd_tweet.cargarTweets();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Tweet[0];
	}
	
	public Tweet[] cargarTweetsPorUsuario(int id_usuario) {
		try {
			return this.bd_tweet.cargarTweetsPorUsuario(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Tweet[0];
	}
	
	public Tweet[] cargarTweetsQueGustan(int id_usuario) {
		try {
			return this.bd_tweet.cargarTweetsQueGustan(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Tweet[0];
	}
	
	public Tweet[] cargarRetweets(int id_usuario) {
		try {
			return this.bd_tweet.cargarRetweets(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Tweet[0];
	}
	
	public void eliminarTweet(int id_tweet) {
		try {
			this.bd_tweet.eliminarTweet(id_tweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarComentario(int id_comentario) {
		try {
			this.bd_comentario.eliminarComentario(id_comentario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Tweet obtenerTweetByID(int id_tweet) {
		try {
			return this.bd_tweet.obtenerTweetByID(id_tweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Comentario obtenerComentarioByID(int id_comentario) {
		try {
			return this.bd_comentario.obtenerComentarioByID(id_comentario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado obtenerUsuarioByID(int id_usuario) {
		try {
			return this.bd_userR.obtenerUsuarioByID(id_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado desbloquear(int id_usuario, int id_usuario_desbloqueado) {
		try {
			return this.bd_userR.desbloquear(id_usuario, id_usuario_desbloqueado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario_Registrado quitarSeguimiento(int id_usuario, int id_usuario_quitadoSeguimiento) {
		try {
			return this.bd_userR.quitarSeguimiento(id_usuario, id_usuario_quitadoSeguimiento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}