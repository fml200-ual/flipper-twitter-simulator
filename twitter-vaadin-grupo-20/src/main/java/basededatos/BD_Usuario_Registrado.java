package basededatos;

import java.util.Date;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Usuario_Registrado {
	public BDPrincipal _bd_prin_userR;
	public Vector<Usuario_Registrado> _contiene_userR = new Vector<Usuario_Registrado>();

	public Usuario_Registrado login(String nombreUsuario, String contrasena) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Usuario_Autentificado userAux = Usuario_AutentificadoDAO.loadUsuario_AutentificadoByQuery(
					"Nickname = '" + nombreUsuario + "' AND Contrasena = '" + contrasena + "'", null);
			if (userAux != null) {
				user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(userAux.getId_usuario());
				if (user.getPropiedadesBaneo() != null) {
					user = null;
				}
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return user;
	}

	public Usuario_Registrado validacionCorreo(String correoElectronico) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO
					.loadUsuario_RegistradoByQuery("CorreoElectronico = '" + correoElectronico + "'", null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return user;
	}

	public void cambiarContrasena(int id_usuario, String contrasena) throws PersistentException {
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Usuario_Registrado user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			user.setContrasena(contrasena);
			Usuario_RegistradoDAO.save(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
	}

	public Usuario_Registrado registrar(String nickname, String descripcion, String imagenFondoURL,
			String fotoPerfilURL, String correoElectronico, String contrasena, Date fechaRegistro)
			throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.createUsuario_Registrado();
			user.setNickname(nickname);
			user.setDescripcion(descripcion);
			user.setImagenFondoURL(imagenFondoURL);
			user.setFotoPerfilURL(fotoPerfilURL);
			user.setCorreoElectronico(correoElectronico);
			user.setContrasena(contrasena);
			user.setFechaDeRegistro(fechaRegistro);
			Usuario_RegistradoDAO.save(user);
			t.commit();
		} catch (Exception e) {
			user = null;
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	// Sobrecarga del método registrar sin fecha de registro
	public Usuario_Registrado registrar(String nickname, String descripcion, String imagenFondoURL,
			String fotoPerfilURL, String correoElectronico, String contrasena) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.createUsuario_Registrado();
			user.setNickname(nickname);
			user.setDescripcion(descripcion);
			user.setImagenFondoURL(imagenFondoURL);
			user.setFotoPerfilURL(fotoPerfilURL);
			user.setCorreoElectronico(correoElectronico);
			user.setContrasena(contrasena);
			// No se establece fecha de registro porque no existe en la base de datos
			Usuario_RegistradoDAO.save(user);
			t.commit();
		} catch (Exception e) {
			user = null;
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado modificarPerfilSimple(int id_usuario, String nickname, String descripcion,
			String imagenFondoURL, String fotoPerfilURL, String contrasena) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			user.setNickname(nickname);
			user.setDescripcion(descripcion);
			user.setImagenFondoURL(imagenFondoURL);
			user.setFotoPerfilURL(fotoPerfilURL);
			user.setContrasena(contrasena);
			Usuario_RegistradoDAO.save(user);
			t.commit();
		} catch (Exception e) {
			user = null;
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado modificarPerfilCompleto(int id_usuario, String nickname, String descripcion,
			String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena)
			throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			user.setNickname(nickname);
			user.setDescripcion(descripcion);
			user.setImagenFondoURL(imagenFondoURL);
			user.setFotoPerfilURL(fotoPerfilURL);
			user.setCorreoElectronico(correoElectronico);
			user.setContrasena(contrasena);
			Usuario_RegistradoDAO.save(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado seguir(int id_usuario, int id_usuarioSeguido, Date fechaSeguimiento)
			throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Usuario_Registrado usuario_seguido = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuarioSeguido);
			if (user != null && usuario_seguido != null && id_usuario != id_usuarioSeguido) {
				// Verificar si ya existe una relación de seguimiento
				// Simplificar la consulta usando un método alternativo
				try {
					// Buscar si ya existe la relación directamente
					boolean yaExiste = false;
					PropiedadesSeguidos[] todasLasRelaciones = PropiedadesSeguidosDAO
							.listPropiedadesSeguidosByQuery(null, null);

					if (todasLasRelaciones != null) {
						for (PropiedadesSeguidos relacion : todasLasRelaciones) {
							if (relacion.getSeguidoresUsuario_registrado() != null &&
									relacion.getSeguidosUsuario_registrado() != null &&
									relacion.getSeguidoresUsuario_registrado().getId_usuario() == id_usuario &&
									relacion.getSeguidosUsuario_registrado().getId_usuario() == id_usuarioSeguido) {
								yaExiste = true;
								break;
							}
						}
					}

					if (!yaExiste) {
						// No existe la relación, crearla
						PropiedadesSeguidos cp = PropiedadesSeguidosDAO.createPropiedadesSeguidos();
						// El usuario que sigue (user) es el seguidor
						cp.setSeguidoresUsuario_registrado(user);
						// El usuario que es seguido (usuario_seguido) es el seguido
						cp.setSeguidosUsuario_registrado(usuario_seguido);
						cp.setFecha(fechaSeguimiento);
						PropiedadesSeguidosDAO.save(cp);
						System.out.println("Relación de seguimiento creada exitosamente");
					} else {
						System.out.println("La relación de seguimiento ya existe");
					}
				} catch (Exception e) {
					System.err.println("Error al verificar relación existente: " + e.getMessage());
					// Si falla la verificación, intentar crear la relación directamente
					PropiedadesSeguidos cp = PropiedadesSeguidosDAO.createPropiedadesSeguidos();
					cp.setSeguidoresUsuario_registrado(user);
					cp.setSeguidosUsuario_registrado(usuario_seguido);
					cp.setFecha(fechaSeguimiento);
					PropiedadesSeguidosDAO.save(cp);
					System.out.println("Relación de seguimiento creada (sin verificación previa)");
				}
			} else {
				System.out.println("Error: usuarios no válidos o intentando seguirse a sí mismo");
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			System.out.println("Error en seguir: " + e.getMessage());
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public void eliminarUsuario(int id_usuario) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);

			// PASO 1: Eliminar TODAS las menciones usando SQL nativo para evitar cascadas
			// problemáticas
			// Esto evita completamente el problema de ObjectDeletedException
			org.orm.PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();

			// Eliminar menciones donde el usuario es mencionado
			session.createSQLQuery(
					"DELETE FROM propiedadesmencion WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
							+ id_usuario)
					.executeUpdate();

			// Eliminar menciones en tweets del usuario
			session.createSQLQuery("DELETE FROM propiedadesmencion WHERE TweetId_tweet IN " +
					"(SELECT Id_tweet FROM tweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
					+ id_usuario + ")")
					.executeUpdate();

			// PASO 2: Limpiar todas las asociaciones many-to-many usando SQL nativo
			// Eliminar me gustas de tweets del usuario (todos los usuarios que dieron like)
			session.createSQLQuery(
					"DELETE FROM tweet_usuario_registrado2 WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
							+ id_usuario)
					.executeUpdate();

			// Eliminar TODOS los me gustas de tweets del usuario (de cualquier usuario)
			session.createSQLQuery("DELETE FROM tweet_usuario_registrado2 WHERE TweetId_tweet IN " +
					"(SELECT Id_tweet FROM tweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
					+ id_usuario + ")")
					.executeUpdate();

			// Eliminar me gustas de comentarios del usuario (todos los usuarios que dieron
			// like)
			session.createSQLQuery(
					"DELETE FROM comentario_usuario_registrado2 WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
							+ id_usuario)
					.executeUpdate();

			// Eliminar TODOS los me gustas de comentarios del usuario (de cualquier
			// usuario)
			session.createSQLQuery("DELETE FROM comentario_usuario_registrado2 WHERE ComentarioId_comentario IN " +
					"(SELECT Id_comentario FROM comentario WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
					+ id_usuario + ")")
					.executeUpdate();

			// Eliminar usuarios bloqueados
			session.createSQLQuery(
					"DELETE FROM usuario_registrado_usuario_registrado2 WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario2 = "
							+ id_usuario +
							" OR Usuario_RegistradoUsuario_AutentificadoId_usuario = " + id_usuario)
					.executeUpdate();

			// PASO 3: Eliminar propiedades de baneo
			session.createSQLQuery(
					"DELETE FROM propiedadesbaneo WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
							+ id_usuario)
					.executeUpdate();

			// PASO 4: Eliminar relaciones de seguimiento
			session.createSQLQuery(
					"DELETE FROM propiedadesseguidos WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario2 = "
							+ id_usuario +
							" OR Usuario_RegistradoUsuario_AutentificadoId_usuario = " + id_usuario)
					.executeUpdate();

			// PASO 5: Eliminar retweets del usuario
			session.createSQLQuery(
					"DELETE FROM retweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = " + id_usuario)
					.executeUpdate();

			// PASO 6: Eliminar retweets de tweets del usuario
			session.createSQLQuery("DELETE FROM retweet WHERE TweetId_tweet IN " +
					"(SELECT Id_tweet FROM tweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
					+ id_usuario + ")")
					.executeUpdate();

			// PASO 7: Eliminar TODOS los me gustas de comentarios que están en tweets del
			// usuario
			session.createSQLQuery("DELETE FROM comentario_usuario_registrado2 WHERE ComentarioId_comentario IN " +
					"(SELECT Id_comentario FROM comentario WHERE TweetId_tweet IN " +
					"(SELECT Id_tweet FROM tweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
					+ id_usuario + "))")
					.executeUpdate();

			// PASO 8: Eliminar comentarios del usuario
			session.createSQLQuery(
					"DELETE FROM comentario WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = " + id_usuario)
					.executeUpdate();

			// PASO 9: Eliminar comentarios en tweets del usuario
			session.createSQLQuery("DELETE FROM comentario WHERE TweetId_tweet IN " +
					"(SELECT Id_tweet FROM tweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
					+ id_usuario + ")")
					.executeUpdate();

			// PASO 10: Manejar hashtags (eliminar solo los que no tienen otros tweets)
			session.createSQLQuery("DELETE FROM hashtag_tweet2 WHERE TweetId_tweet IN " +
					"(SELECT Id_tweet FROM tweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
					+ id_usuario + ")")
					.executeUpdate();

			// PASO 12: Eliminar tweets del usuario de forma segura
			// Primero, eliminar la auto-referencia (poner TweetId_tweet = NULL en tweets
			// que referencian tweets del usuario)
			session.createSQLQuery("UPDATE tweet SET TweetId_tweet = NULL WHERE TweetId_tweet IN " +
					"(SELECT Id_tweet FROM (SELECT Id_tweet FROM tweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = "
					+ id_usuario + ") AS temp)")
					.executeUpdate();

			// Ahora eliminar todos los tweets del usuario sin problemas de FK
			session.createSQLQuery(
					"DELETE FROM tweet WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = " + id_usuario)
					.executeUpdate();

			// PASO 13: Los documentos se pueden dejar (pueden ser compartidos por otros
			// tweets/comentarios)
			// O eliminar solo después de verificar que no están en uso

			// PASO 14: Eliminar usuario registrado (antes que usuario autentificado)
			session.createSQLQuery(
					"DELETE FROM usuario_registrado WHERE Usuario_AutentificadoId_usuario = " + id_usuario)
					.executeUpdate();

			// PASO 15: Eliminar usuario autentificado
			session.createSQLQuery("DELETE FROM usuario_autentificado WHERE Id_usuario = " + id_usuario)
					.executeUpdate();

			// PASO 16: Al final, hacer commit sin flush intermedio
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			throw new PersistentException("Error al eliminar usuario: " + e.getMessage(), e);
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
	}

	public Usuario_Registrado darMeGustaTweet(int id_usuario, int id_tweet) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			user.me_gusta_tweets.add(tweet);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado bloquear(int id_usuario, int id_usuarioBloqueado) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Usuario_Registrado bloqueado = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuarioBloqueado);
			user.bloqueados.add(bloqueado);
			PropiedadesSeguidos ps = PropiedadesSeguidosDAO.loadPropiedadesSeguidosByQuery(
					"Usuario_RegistradoUsuario_AutentificadoId_usuario2 = '" + id_usuario
							+ "' AND Usuario_RegistradoUsuario_AutentificadoId_usuario = '" + id_usuarioBloqueado + "'",
					null);
			if (ps != null) {
				PropiedadesSeguidosDAO.delete(ps);
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado darRetweet(int id_usuario, int id_tweet, Date fechaPublicacion)
			throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			Retweet retweet = RetweetDAO.createRetweet();
			retweet.setTipo("Simple");
			retweet.setUsuario_Registrado(user);
			retweet.setTweet(tweet);
			retweet.setFechaPublicacion(fechaPublicacion);
			RetweetDAO.save(retweet);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado[] cargarUsuarios() throws PersistentException {
		Usuario_Registrado[] usuarios = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			usuarios = Usuario_RegistradoDAO.listUsuario_RegistradoByQuery(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return usuarios;
	}

	public Usuario_Registrado obtenerUsuarioByID(int id_usuario) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return user;
	}

	public Usuario_Registrado darMeGustaComentario(int id_usuario, int id_comentario) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Comentario comentario = ComentarioDAO.getComentarioByORMID(id_comentario);
			user.me_gusta_Comentarios.add(comentario);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado eliminarMgTweet(int id_usuario, int id_tweet) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			user.me_gusta_tweets.remove(tweet);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado eliminarMgComentario(int id_usuario, int id_comentario) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Comentario comentario = ComentarioDAO.getComentarioByORMID(id_comentario);
			user.me_gusta_Comentarios.remove(comentario);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado desbloquear(int id_usuario, int id_usuario_desbloqueado) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Usuario_Registrado usuarioDesbloqueado = Usuario_RegistradoDAO
					.getUsuario_RegistradoByORMID(id_usuario_desbloqueado);
			user.bloqueados.remove(usuarioDesbloqueado);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado quitarSeguimiento(int id_usuario, int id_usuario_quitadoSeguimiento)
			throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			PropiedadesSeguidos ps = PropiedadesSeguidosDAO
					.loadPropiedadesSeguidosByQuery("Usuario_RegistradoUsuario_AutentificadoId_usuario2 = '"
							+ id_usuario + "' AND Usuario_RegistradoUsuario_AutentificadoId_usuario = '"
							+ id_usuario_quitadoSeguimiento + "'", null);
			PropiedadesSeguidosDAO.delete(ps);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}

	public Usuario_Registrado cargarUsuarioPorId(int idUsuario) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(idUsuario);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return user;
	}

	public void dejarDeSeguir(int idSeguidor, int idSeguido) throws PersistentException {
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			// Obtener los usuarios
			Usuario_Registrado seguidor = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(idSeguidor);
			Usuario_Registrado seguido = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(idSeguido);
			if (seguidor != null && seguido != null) {
				// Buscar la relación de seguimiento existente
				// Seguidor = Usuario_RegistradoUsuario_AutentificadoId_usuario2
				// Seguido = Usuario_RegistradoUsuario_AutentificadoId_usuario
				String query = "Usuario_RegistradoUsuario_AutentificadoId_usuario2 = " + idSeguidor +
						" AND Usuario_RegistradoUsuario_AutentificadoId_usuario = " + idSeguido;
				PropiedadesSeguidos[] relaciones = PropiedadesSeguidosDAO.listPropiedadesSeguidosByQuery(query, null);

				// Eliminar la relación si existe
				for (PropiedadesSeguidos relacion : relaciones) {
					PropiedadesSeguidosDAO.delete(relacion);
				}

				System.out.println("Usuario " + seguidor.getNickname() + " dejó de seguir a " + seguido.getNickname());
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		}
	}

	/**
	 * Cargar lista de seguidores de un usuario
	 */
	public Usuario_Registrado[] cargarSeguidores(int idUsuario) throws PersistentException {
		Usuario_Registrado[] seguidores = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			// Buscar todas las relaciones donde el usuario es seguido
			// En la BD: Usuario_RegistradoUsuario_AutentificadoId_usuario = usuario seguido
			String query = "Usuario_RegistradoUsuario_AutentificadoId_usuario = " + idUsuario;
			PropiedadesSeguidos[] relaciones = PropiedadesSeguidosDAO.listPropiedadesSeguidosByQuery(query, null);

			if (relaciones != null && relaciones.length > 0) {
				System.out.println(
						"Encontradas " + relaciones.length + " relaciones de seguimiento para usuario " + idUsuario);
				seguidores = new Usuario_Registrado[relaciones.length];
				for (int i = 0; i < relaciones.length; i++) {
					// El seguidor es quien tiene la relación
					// (Usuario_RegistradoUsuario_AutentificadoId_usuario2)
					seguidores[i] = relaciones[i].getSeguidoresUsuario_registrado();
				}
			} else {
				System.out.println("No se encontraron seguidores para usuario " + idUsuario);
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.err.println("Error al cargar seguidores: " + e.getMessage());
			e.printStackTrace();
		}
		return seguidores;
	}

	/**
	 * Cargar lista de usuarios seguidos por un usuario
	 */
	public Usuario_Registrado[] cargarSeguidos(int idUsuario) throws PersistentException {
		Usuario_Registrado[] seguidos = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			// Buscar todas las relaciones donde el usuario es el seguidor
			// En la BD: Usuario_RegistradoUsuario_AutentificadoId_usuario2 = usuario
			// seguidor
			String query = "Usuario_RegistradoUsuario_AutentificadoId_usuario2 = " + idUsuario;
			PropiedadesSeguidos[] relaciones = PropiedadesSeguidosDAO.listPropiedadesSeguidosByQuery(query, null);

			if (relaciones != null && relaciones.length > 0) {
				System.out.println("Encontradas " + relaciones.length + " relaciones donde usuario " + idUsuario
						+ " sigue a otros");
				seguidos = new Usuario_Registrado[relaciones.length];
				for (int i = 0; i < relaciones.length; i++) {
					// El seguido es el objetivo de la relación
					// (Usuario_RegistradoUsuario_AutentificadoId_usuario)
					seguidos[i] = relaciones[i].getSeguidosUsuario_registrado();
				}
			} else {
				System.out.println("Usuario " + idUsuario + " no sigue a nadie");
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.err.println("Error al cargar seguidos: " + e.getMessage());
			e.printStackTrace();
		}
		return seguidos;
	}

	/**
	 * Contar número de seguidores de un usuario
	 */
	public int contarSeguidores(int idUsuario) throws PersistentException {
		int numSeguidores = 0;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			String query = "Usuario_RegistradoUsuario_AutentificadoId_usuario = " + idUsuario;
			PropiedadesSeguidos[] relaciones = PropiedadesSeguidosDAO.listPropiedadesSeguidosByQuery(query, null);
			numSeguidores = relaciones != null ? relaciones.length : 0;
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.err.println("Error al contar seguidores: " + e.getMessage());
		}
		return numSeguidores;
	}

	/**
	 * Contar número de seguidos de un usuario
	 */
	public int contarSeguidos(int idUsuario) throws PersistentException {
		int numSeguidos = 0;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			String query = "Usuario_RegistradoUsuario_AutentificadoId_usuario2 = " + idUsuario;
			PropiedadesSeguidos[] relaciones = PropiedadesSeguidosDAO.listPropiedadesSeguidosByQuery(query, null);
			numSeguidos = relaciones != null ? relaciones.length : 0;
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.err.println("Error al contar seguidos: " + e.getMessage());
		}
		return numSeguidos;
	}

	/**
	 * Verifica si un usuario le dio me gusta a un tweet específico
	 * 
	 * @param idUsuario ID del usuario
	 * @param idTweet   ID del tweet
	 * @return true si le gusta, false si no
	 */
	public boolean yaLeGustaTweet(int idUsuario, int idTweet) throws PersistentException {
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			// Buscar directamente en la tabla de relación many-to-many
			String query = "SELECT COUNT(*) FROM tweet_usuario_registrado2 " +
					"WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = " + idUsuario +
					" AND TweetId_tweet = " + idTweet;

			// Usar HQL para la consulta
			org.hibernate.Query hibernateQuery = ProyectoMDS120242025PersistentManager.instance()
					.getSession().createSQLQuery(query);

			Object result = hibernateQuery.uniqueResult();
			int count = result != null ? ((Number) result).intValue() : 0;

			t.commit();
			return count > 0;
		} catch (Exception e) {
			t.rollback();
			throw new PersistentException(e);
		}
	}

	/**
	 * Verifica si un usuario le dio me gusta a un comentario específico
	 * 
	 * @param idUsuario    ID del usuario
	 * @param idComentario ID del comentario
	 * @return true si le gusta, false si no
	 */
	public boolean yaLeGustaComentario(int idUsuario, int idComentario) throws PersistentException {
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			// Buscar directamente en la tabla de relación many-to-many
			String query = "SELECT COUNT(*) FROM comentario_usuario_registrado2 " +
					"WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = " + idUsuario +
					" AND ComentarioId_comentario = " + idComentario;

			// Usar HQL para la consulta
			org.hibernate.Query hibernateQuery = ProyectoMDS120242025PersistentManager.instance()
					.getSession().createSQLQuery(query);

			Object result = hibernateQuery.uniqueResult();
			int count = result != null ? ((Number) result).intValue() : 0;

			t.commit();
			return count > 0;
		} catch (Exception e) {
			t.rollback();
			throw new PersistentException(e);
		}
	}
}
