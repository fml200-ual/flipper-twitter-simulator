package basededatos;

import java.util.Date;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;


public class BD_Tweet {
	public BDPrincipal _bd_prin_tweet;
	public Vector<Tweet> _contiene_tweet = new Vector<Tweet>();

	public int nuevoTweet(int id_usuario, String contenidoTweet, Date fechaPublicacion, String[] menciones) throws PersistentException {
		int id_tweet = -1;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Usuario_Registrado user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Tweet tweet = TweetDAO.createTweet();
			tweet.setPublicado_por(user);
			tweet.setContenidoTweet(contenidoTweet);
			tweet.setFechaPublicacion(fechaPublicacion);
			Usuario_Registrado[] usuarios = Usuario_RegistradoDAO.listUsuario_RegistradoByQuery(null, null);
			for (int i = 0; i < menciones.length; i++) {
				for (int j = 0; j < usuarios.length; j++) {
					if (usuarios[j].getNickname().equals(menciones[i])) {
						PropiedadesMencion pm = PropiedadesMencionDAO.createPropiedadesMencion();
						pm.setFecha(fechaPublicacion);
						pm.setUsuario_Registrado(usuarios[j]);
						pm.setTweet(tweet);
						PropiedadesMencionDAO.save(pm);
					}
				}	
			}
			TweetDAO.save(tweet);
			id_tweet = tweet.getId_tweet();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return id_tweet;
	}

	public int nuevoRetweet(int id_usuario, int id_tweetRetweeteado, String contenidoRetweet, Date fechaPublicacion, String[] menciones) throws PersistentException {
		int id_tweet = -1;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		boolean committed = false;
		try {
			id_tweet = nuevoTweet(id_usuario, contenidoRetweet, fechaPublicacion, menciones);
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweetRetweeteado);
			tweet.retweets_Cita.add(TweetDAO.getTweetByORMID(id_tweet));
			Retweet retweet = RetweetDAO.createRetweet();
			retweet.setTipo("Cita");
			retweet.setUsuario_Registrado(Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario));
			retweet.setTweet(tweet);
			retweet.setFechaPublicacion(fechaPublicacion);
			RetweetDAO.save(retweet);
			t.commit();
			committed = true;
		} catch (Exception e) {
			if (!committed) {
				try {
					t.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return id_tweet;
	}

	public Tweet[] cargarTweets() throws PersistentException {
		Tweet[] tweets = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			tweets = TweetDAO.listTweetByQuery(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return tweets;
	}
		public Tweet[] cargarTweetsPorUsuario(int id_usuario) throws PersistentException {
		Tweet[] tweets = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			String query = "Usuario_RegistradoUsuario_AutentificadoId_usuario = " + id_usuario;
			System.out.println("Buscando tweets para usuario ID: " + id_usuario + " con query: " + query);
			tweets = TweetDAO.listTweetByQuery(query, "FechaPublicacion DESC");
			System.out.println("Tweets encontrados: " + (tweets != null ? tweets.length : 0));
			if (tweets != null) {
				for (int i = 0; i < tweets.length; i++) {
					System.out.println("Tweet " + i + ": ID=" + tweets[i].getId_tweet() + 
						", Contenido=" + tweets[i].getContenidoTweet() + 
						", Usuario=" + (tweets[i].getPublicado_por() != null ? tweets[i].getPublicado_por().getNickname() : "null"));
				}
			}
			t.commit();
		} catch (Exception e) {
			System.err.println("Error cargando tweets por usuario: " + e.getMessage());
			t.rollback();
		}
		return tweets != null ? tweets : new Tweet[0];
	}
		public Tweet[] cargarTweetsQueGustan(int id_usuario) throws PersistentException {
		Tweet[] tweets = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			// Buscar tweets que le gustan al usuario a través de la relación Me_Gusta_Tweet
			Usuario_Registrado usuario = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			if (usuario != null) {
				tweets = usuario.me_gusta_tweets.toArray("FechaPublicacion", false);
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return tweets != null ? tweets : new Tweet[0];
	}
	
	public Tweet[] cargarRetweets(int id_usuario) throws PersistentException {
		Tweet[] tweets = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			// Buscar retweets del usuario a través de la relación Retweet
			Usuario_Registrado usuario = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			if (usuario != null) {
				Retweet[] retweets = usuario.retweets.toArray("FechaPublicacion", false);
				java.util.List<Tweet> tweetsList = new java.util.ArrayList<>();
				for (Retweet retweet : retweets) {
					if (retweet.getTweet() != null) {
						tweetsList.add(retweet.getTweet());
					}
				}
				tweets = tweetsList.toArray(new Tweet[tweetsList.size()]);
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return tweets != null ? tweets : new Tweet[0];
	}
	
	public void eliminarTweet(int id_tweet) throws PersistentException {
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			Comentario[] comentarios = tweet.tiene.toArray();
			for (int i = 0; i < comentarios.length; i++) {
				Comentario comentario = comentarios[i];
				Documento doc = comentario.getDocumento();
				if (doc != null) {
					DocumentoDAO.delete(doc);
				}
				ComentarioDAO.deleteAndDissociate(comentario);
			}
			Retweet[] rts = tweet.retweets.toArray();
			for (int i = 0; i < rts.length; i++) {
				RetweetDAO.delete(rts[i]);
			}
			Hashtag[] hgs = tweet.tiene_hashtag.toArray();
			for (int i = 0; i < hgs.length; i++) {
				if (hgs[i].pertenece.size() == 1) {
					HashtagDAO.deleteAndDissociate(hgs[i]);	
				}
			}	
			PropiedadesMencion[] pm = tweet.propiedadesMencions.toArray();
			for (int i = 0; i < pm.length; i++) {
				PropiedadesMencionDAO.delete(pm[i]);
			}
			
			Documento doc = tweet.getDocumento();
			if (doc != null) {
				DocumentoDAO.delete(doc);
			}
			TweetDAO.deleteAndDissociate(tweet);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
	}
	
	public Usuario_Registrado eliminarRetweet(int id_usuario, int id_tweet) throws PersistentException {
		Usuario_Registrado user = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Retweet retweet = RetweetDAO.loadRetweetByQuery(
					"Usuario_RegistradoUsuario_AutentificadoId_usuario = '" + id_usuario + "' AND TweetId_tweet = '" + id_tweet + "'", null);
			if(retweet.getTipo().equals("Cita")) {
				Tweet tweetAux = retweet.getTweet();
				Tweet[] citas = tweetAux.retweets_Cita.toArray();
				for (int i = 0; i < citas.length; i++) {
					Tweet tweet = citas[i];
					if (tweet.getPublicado_por().equals(user) && tweet.getFechaPublicacion().equals(retweet.getFechaPublicacion())) {
						Comentario[] comentarios = tweet.tiene.toArray();
						for (int j = 0; j < comentarios.length; j++) {
							Comentario comentario = comentarios[j];
							Documento doc = comentario.getDocumento();
							if (doc != null) {
								DocumentoDAO.delete(doc);
							}
							ComentarioDAO.deleteAndDissociate(comentario);
						}
						Retweet[] rts = tweet.retweets.toArray();
						for (int j = 0; j < rts.length; j++) {
							RetweetDAO.delete(rts[j]);
						}
						Hashtag[] hgs = tweet.tiene_hashtag.toArray();
						for (int j = 0; j < hgs.length; j++) {
							if (hgs[j].pertenece.size() == 1) {
								HashtagDAO.deleteAndDissociate(hgs[j]);	
							}
						}	
						PropiedadesMencion[] pm = tweet.propiedadesMencions.toArray();
						for (int j = 0; j < pm.length; j++) {
							PropiedadesMencionDAO.delete(pm[j]);
						}
						
						Documento doc = tweet.getDocumento();
						if (doc != null) {
							DocumentoDAO.delete(doc);
						}
						TweetDAO.deleteAndDissociate(tweet);
						break;
					}
				}
			}
			RetweetDAO.delete(retweet);	
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return user;
	}
	
	public Tweet obtenerTweetByID(int id_tweet) throws PersistentException {
		Tweet tweet = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			tweet = TweetDAO.getTweetByORMID(id_tweet);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return tweet;
	} 
	
	public boolean darMeGustaTweet(int id_usuario, int id_tweet) throws PersistentException {
		boolean exito = false;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Usuario_Registrado usuario = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			
			if (usuario != null && tweet != null) {
				// Verificar si ya le ha dado me gusta
				if (!usuario.me_gusta_tweets.contains(tweet)) {
					// Agregar el tweet a la lista de me gusta del usuario
					usuario.me_gusta_tweets.add(tweet);
					Usuario_RegistradoDAO.save(usuario);
					exito = true;
				}
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return exito;
	}
	
	public boolean quitarMeGustaTweet(int id_usuario, int id_tweet) throws PersistentException {
		boolean exito = false;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Usuario_Registrado usuario = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			
			if (usuario != null && tweet != null) {
				// Remover el tweet de la lista de me gusta del usuario
				if (usuario.me_gusta_tweets.contains(tweet)) {
					usuario.me_gusta_tweets.remove(tweet);
					Usuario_RegistradoDAO.save(usuario);
					exito = true;
				}
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return exito;
	}
	
	/**
	 * Verifica si un usuario le dio me gusta a un tweet específico
	 * @param idUsuario ID del usuario
	 * @param idTweet ID del tweet
	 * @return true si le gusta, false si no
	 */
	public boolean verificarMeGustaTweet(int idUsuario, int idTweet) {
		try {
			PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
					.getSession().beginTransaction();
			try {
				// Buscar directamente en la tabla de relación many-to-many
				String query = "SELECT COUNT(*) FROM Tweet_Usuario_Registrado " +
							   "WHERE Usuario_RegistradoUsuario_AutentificadoId_usuario = " + idUsuario + 
							   " AND TweetId_tweet = " + idTweet;
				
				// Usar SQL para la consulta
				org.hibernate.Query hibernateQuery = ProyectoMDS120242025PersistentManager.instance()
					.getSession().createSQLQuery(query);
				
				Object result = hibernateQuery.uniqueResult();
				int count = result != null ? ((Number) result).intValue() : 0;
				
				t.commit();
				return count > 0;
			} catch (Exception e) {
				t.rollback();
				System.err.println("Error verificando me gusta: " + e.getMessage());
				return false;
			}
		} catch (Exception e) {
			System.err.println("Error en verificarMeGustaTweet: " + e.getMessage());
			return false;
		}
	}
	/**
	 * Método para obtener el contador de "me gusta" de un tweet de forma segura
	 */
	public int contarMeGustaTweet(int id_tweet) {
		int contador = 0;
		try {
			PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
					.getSession().beginTransaction();
			try {
				Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
				if (tweet != null && tweet.recibe_me_gusta != null) {
					contador = tweet.recibe_me_gusta.size();
				}
				t.commit();
			} catch (Exception e) {
				t.rollback();
				System.err.println("Error contando me gusta: " + e.getMessage());
			}
			ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			System.err.println("Error en contarMeGustaTweet: " + e.getMessage());
		}
		return contador;
	}
	
	/**
	 * Método para obtener el contador de retweets de un tweet de forma segura
	 */
	public int contarRetweetsTweet(int id_tweet) {
		int contador = 0;
		try {
			PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
					.getSession().beginTransaction();
			try {
				Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
				if (tweet != null && tweet.retweets != null) {
					contador = tweet.retweets.size();
				}
				t.commit();
			} catch (Exception e) {
				t.rollback();
				System.err.println("Error contando retweets: " + e.getMessage());
			}
			ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			System.err.println("Error en contarRetweetsTweet: " + e.getMessage());
		}
		return contador;
	}
	
	/**
	 * Método para obtener el contador de comentarios de un tweet de forma segura
	 */
	public int contarComentariosTweet(int id_tweet) {
		int contador = 0;
		try {
			PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
					.getSession().beginTransaction();
			try {
				Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
				if (tweet != null && tweet.tiene != null) {
					contador = tweet.tiene.size();
				}
				t.commit();
			} catch (Exception e) {
				t.rollback();
				System.err.println("Error contando comentarios: " + e.getMessage());
			}
			ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			System.err.println("Error en contarComentariosTweet: " + e.getMessage());
		}
		return contador;
	}
}
