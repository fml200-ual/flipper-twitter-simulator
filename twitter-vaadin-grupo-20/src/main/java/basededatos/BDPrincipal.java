package basededatos;

import java.util.Date;
import org.orm.PersistentTransaction;

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

	public Usuario_Registrado registrar(String nickname, String descripcion, String imagenFondoURL,
			String fotoPerfilURL, String correoElectronico, String contrasena, Date fechaRegistro) {
		try {
			return this.bd_userR.registrar(nickname, descripcion, imagenFondoURL, fotoPerfilURL, correoElectronico,
					contrasena, fechaRegistro);
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

	public Usuario_Registrado modificarPerfilSimple(int id_usuario, String nickname, String descripcion,
			String imagenFondoURL, String fotoPerfilURL, String contrasena) {
		try {
			return this.bd_userR.modificarPerfilSimple(id_usuario, nickname, descripcion, imagenFondoURL, fotoPerfilURL,
					contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado modificarPerfilCompleto(int id_usuario, String nickname, String descripcion,
			String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena) {
		try {
			return this.bd_userR.modificarPerfilCompleto(id_usuario, nickname, descripcion, imagenFondoURL,
					fotoPerfilURL, correoElectronico, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario_Registrado publicarTweet(int id_usuario, String contenidoTweet, Date fechaPublicacion,
			String URLDocumento, String tipoDocumento, String[] hashtags, String[] menciones) {
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

	public Usuario_Registrado publicarComentario(int id_usuario, int id_tweet, String contenidoComentario,
			String URLDocumento, Date fechaPublicacion, String tipoDocumento) {
		try {
			int id_comentario = this.bd_comentario.nuevoComentario(id_usuario, id_tweet, contenidoComentario,
					fechaPublicacion);
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

	public Usuario_Registrado publicarRetweet(int id_usuario, int id_tweetRetweeteado, String contenidoRetweet,
			String URLDocumento, String tipoDocumento, Date fechaPublicacion, String[] hashtags, String[] menciones) {
		try {
			int id_tweet = this.bd_tweet.nuevoRetweet(id_usuario, id_tweetRetweeteado, contenidoRetweet,
					fechaPublicacion, menciones);
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

	// METODOLOGÍA ACTIVIDAD 12: Cargar comentarios de un tweet específico
	public Comentario[] cargarComentariosDeTweet(int id_tweet) {
		try {
			System.out.println("Cargando comentarios del tweet ID: " + id_tweet);

			// Obtener el tweet primero
			Tweet tweet = this.obtenerTweetByID(id_tweet);

			if (tweet != null && tweet.tiene != null) {
				// Convertir la colección de comentarios a array
				basededatos.Comentario[] comentarios = tweet.tiene.toArray();
				System.out.println("Encontrados " + comentarios.length + " comentarios para el tweet");
				return comentarios;
			} else {
				System.out.println("No se encontraron comentarios para el tweet ID: " + id_tweet);
				return new Comentario[0];
			}

		} catch (Exception e) {
			System.err.println("Error cargando comentarios del tweet: " + e.getMessage());
			e.printStackTrace();
			return new Comentario[0];
		}
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

	public Usuario_Registrado activarCuenta(String correoElectronico, String nickname) {
		try {
			System.out.println("Activando cuenta para email: " + correoElectronico + ", nickname: " + nickname);

			// Buscar el usuario por correo electrónico
			Usuario_Registrado usuario = this.bd_userR.validacionCorreo(correoElectronico);
			System.out.println("Usuario encontrado por email: " + (usuario != null ? usuario.getNickname() : "NULL"));

			if (usuario != null) {
				// Verificar que coincida el nickname
				if (usuario.getNickname().equals(nickname)) {
					System.out.println("Cuenta activada exitosamente para usuario: " + nickname + " (ID: "
							+ usuario.getId_usuario() + ")");
					return usuario;
				} else {
					System.err.println("Error: Nickname no coincide. Esperado: " + nickname + ", Encontrado: "
							+ usuario.getNickname());
					return null;
				}
			} else {
				System.err.println("Error: No se encontró usuario con email: " + correoElectronico);

				// Como fallback, intentar buscar por nickname directamente
				try {
					PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
							.getSession().beginTransaction();
					Usuario_Registrado usuarioPorNick = Usuario_RegistradoDAO
							.loadUsuario_RegistradoByQuery("Nickname = '" + nickname + "'", null);
					t.commit();

					if (usuarioPorNick != null) {
						System.out.println("Usuario encontrado por nickname: " + usuarioPorNick.getNickname() +
								" con email: " + usuarioPorNick.getCorreoElectronico());

						// Verificar si los emails coinciden (case insensitive)
						if (usuarioPorNick.getCorreoElectronico().equalsIgnoreCase(correoElectronico)) {
							System.out.println("Cuenta activada exitosamente (fallback) para usuario: " + nickname);
							return usuarioPorNick;
						}
					}
				} catch (Exception fallbackEx) {
					System.err.println("Error en búsqueda fallback: " + fallbackEx.getMessage());
				}

				return null;
			}
		} catch (Exception e) {
			System.err.println("Error general en activarCuenta: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Usuario_Registrado cargarUsuarioPorId(int idUsuario) {
		try {
			return this.bd_userR.cargarUsuarioPorId(idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void dejarDeSeguir(int idSeguidor, int idSeguido) {
		try {
			this.bd_userR.dejarDeSeguir(idSeguidor, idSeguido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Hashtag[] buscarHashtag(String hashtag) {
		try {
			return this.bd_hashtag.buscarHashtag(hashtag);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Cargar lista de seguidores de un usuario
	 */
	public Usuario_Registrado[] cargarSeguidores(int idUsuario) {
		try {
			return this.bd_userR.cargarSeguidores(idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Cargar lista de usuarios seguidos por un usuario
	 */
	public Usuario_Registrado[] cargarSeguidos(int idUsuario) {
		try {
			return this.bd_userR.cargarSeguidos(idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Contar número de seguidores de un usuario
	 */
	public int contarSeguidores(int idUsuario) {
		try {
			return this.bd_userR.contarSeguidores(idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Contar número de seguidos de un usuario
	 */
	public int contarSeguidos(int idUsuario) {
		try {
			return this.bd_userR.contarSeguidos(idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Contar número de likes de un tweet
	 */
	public int contarLikesTweet(int idTweet) {
		try {
			return this.bd_tweet.contarMeGustaTweet(idTweet);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Contar número de retweets de un tweet
	 */
	public int contarRetweetsTweet(int idTweet) {
		try {
			return this.bd_tweet.contarRetweetsTweet(idTweet);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Contar número de comentarios de un tweet
	 */
	public int contarComentariosTweet(int idTweet) {
		try {
			return this.bd_tweet.contarComentariosTweet(idTweet);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Contar número de likes de un comentario
	 */
	public int contarLikesComentario(int idComentario) {
		try {
			return this.bd_comentario.contarLikesComentario(idComentario);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Contar número de tweets que usan un hashtag
	 */
	public int contarTweetsHashtag(int idHashtag) {
		try {
			return this.bd_hashtag.contarTweetsHashtag(idHashtag);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Cargar tweets de un hashtag específico
	 */
	public Tweet[] cargarTweetsDeHashtag(int id_hashtag) {
		try {
			return this.bd_hashtag.cargarTweetsDeHashtag(id_hashtag);
		} catch (Exception e) {
			System.err.println("Error en BDPrincipal.cargarTweetsDeHashtag: " + e.getMessage());
			return new Tweet[0];
		}
	}

}