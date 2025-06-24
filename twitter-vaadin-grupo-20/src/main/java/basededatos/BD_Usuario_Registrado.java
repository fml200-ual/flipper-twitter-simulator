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
			user = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("CorreoElectronico = '" + correoElectronico + "'", null);
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

	public Usuario_Registrado registrar(String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena, Date fechaRegistro) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();		try {
			user = Usuario_RegistradoDAO.createUsuario_Registrado();
			user.setNickname(nickname);
			user.setDescripcion(descripcion);
			user.setImagenFondoURL(imagenFondoURL);
			user.setFotoPerfilURL(fotoPerfilURL);
			user.setCorreoElectronico(correoElectronico);
			user.setContrasena(contrasena);
			// Comentado porque el campo fechaDeRegistro no existe en la base de datos
			// user.setFechaDeRegistro(fechaRegistro);
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
	public Usuario_Registrado registrar(String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena) throws PersistentException {
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

	public Usuario_Registrado modificarPerfilSimple(int id_usuario, String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String contrasena) throws PersistentException {
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

	public Usuario_Registrado modificarPerfilCompleto(int id_usuario, String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena) throws PersistentException {
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
	}	public Usuario_Registrado seguir(int id_usuario, int id_usuarioSeguido, Date fechaSeguimiento) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Usuario_Registrado usuario_seguido = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuarioSeguido);			if (user != null && usuario_seguido != null && id_usuario != id_usuarioSeguido) {
				// Verificar si ya existe una relación de seguimiento
				// Simplificar la consulta usando un método alternativo
				try {
					// Buscar si ya existe la relación directamente
					boolean yaExiste = false;
					PropiedadesSeguidos[] todasLasRelaciones = PropiedadesSeguidosDAO.listPropiedadesSeguidosByQuery(null, null);
					
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
			
			PropiedadesBaneo pb = user.getPropiedadesBaneo();
			if (pb != null) {
				PropiedadesBaneoDAO.deleteAndDissociate(pb);
			}
			
			PropiedadesSeguidos[] ps = user.seguidosPropiedadesseguidoss.toArray();
			for (int i = 0; i < ps.length; i++) {
				PropiedadesSeguidosDAO.deleteAndDissociate(ps[i]);
			}
			
			PropiedadesSeguidos[] ps2 = user.seguidoresPropiedadesseguidoss.toArray();
			for (int i = 0; i < ps2.length; i++) {
				PropiedadesSeguidosDAO.deleteAndDissociate(ps2[i]);
			}
			
			PropiedadesMencion[] pm = user.propiedadesMencions.toArray();
			for (int i = 0; i < pm.length; i++) {
				PropiedadesMencionDAO.delete(pm[i]);
			}
			
			Retweet[] rts = user.retweets.toArray();
			for (int i = 0; i < rts.length; i++) {
				RetweetDAO.delete(rts[i]);
			}
			
			Tweet[] tweets = user.tweets.toArray();
			for (int i = 0; i < tweets.length; i++) {
				Tweet tweet = tweets[i];
				Comentario[] comentarios = tweet.tiene.toArray();
				for (int j = 0; j < comentarios.length; j++) {
					Comentario comentario = comentarios[j];
					Documento doc = comentario.getDocumento();
					if (doc != null) {
						DocumentoDAO.delete(doc);
					}
					ComentarioDAO.deleteAndDissociate(comentario);
				}
				Retweet[] rts2 = tweet.retweets.toArray();
				for (int j = 0; j < rts2.length; j++) {
					RetweetDAO.delete(rts2[j]);
				}
				Hashtag[] hgs = tweet.tiene_hashtag.toArray();
				for (int j = 0; j < hgs.length; j++) {
					if (hgs[j].pertenece.size() == 1) {
						HashtagDAO.deleteAndDissociate(hgs[j]);	
					}
				}	
				PropiedadesMencion[] pm2 = tweet.propiedadesMencions.toArray();
				for (int j = 0; j < pm2.length; j++) {
					PropiedadesMencionDAO.delete(pm2[j]);
				}
				
				Documento doc = tweet.getDocumento();
				if (doc != null) {
					DocumentoDAO.delete(doc);
				}
				TweetDAO.deleteAndDissociate(tweet);
			}
			
			Comentario[] comentarios = user.comentarios_publicados.toArray();
			for (int i = 0; i < comentarios.length; i++) {
				Comentario comentario = comentarios[i];
				Documento doc = comentario.getDocumento();
				if (doc != null) {
					DocumentoDAO.delete(doc);
				}
				ComentarioDAO.deleteAndDissociate(comentario);
			}
			
			Usuario_Autentificado userAux = Usuario_AutentificadoDAO.loadUsuario_AutentificadoByQuery(
					"Nickname = '" + user.getNickname() + "' AND Contrasena = '" + user.getContrasena() + "'", null);
			
			Usuario_AutentificadoDAO.delete(userAux);
			
			Usuario_RegistradoDAO.deleteAndDissociate(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
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
			PropiedadesSeguidos ps = PropiedadesSeguidosDAO.loadPropiedadesSeguidosByQuery("Usuario_RegistradoUsuario_AutentificadoId_usuario2 = '" + id_usuario + "' AND Usuario_RegistradoUsuario_AutentificadoId_usuario = '" + id_usuarioBloqueado + "'", null);
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

	public Usuario_Registrado darRetweet(int id_usuario, int id_tweet, Date fechaPublicacion) throws PersistentException {
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
			Usuario_Registrado usuarioDesbloqueado = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario_desbloqueado);
			user.bloqueados.remove(usuarioDesbloqueado);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}
	
	public Usuario_Registrado quitarSeguimiento(int id_usuario, int id_usuario_quitadoSeguimiento) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			PropiedadesSeguidos ps = PropiedadesSeguidosDAO.loadPropiedadesSeguidosByQuery("Usuario_RegistradoUsuario_AutentificadoId_usuario2 = '" + id_usuario + "' AND Usuario_RegistradoUsuario_AutentificadoId_usuario = '" + id_usuario_quitadoSeguimiento + "'", null);
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
	}	/**
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
				System.out.println("Encontradas " + relaciones.length + " relaciones de seguimiento para usuario " + idUsuario);
				seguidores = new Usuario_Registrado[relaciones.length];
				for (int i = 0; i < relaciones.length; i++) {
					// El seguidor es quien tiene la relación (Usuario_RegistradoUsuario_AutentificadoId_usuario2)
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
			// En la BD: Usuario_RegistradoUsuario_AutentificadoId_usuario2 = usuario seguidor
			String query = "Usuario_RegistradoUsuario_AutentificadoId_usuario2 = " + idUsuario;
			PropiedadesSeguidos[] relaciones = PropiedadesSeguidosDAO.listPropiedadesSeguidosByQuery(query, null);
			
			if (relaciones != null && relaciones.length > 0) {
				System.out.println("Encontradas " + relaciones.length + " relaciones donde usuario " + idUsuario + " sigue a otros");
				seguidos = new Usuario_Registrado[relaciones.length];
				for (int i = 0; i < relaciones.length; i++) {
					// El seguido es el objetivo de la relación (Usuario_RegistradoUsuario_AutentificadoId_usuario)
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
}
