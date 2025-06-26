package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;
import basededatos.BD_Usuario_Registrado;
import basededatos.Tweet;
import basededatos.Usuario_Registrado;
import org.orm.PersistentException;
import com.vaadin.flow.component.notification.Notification;

public class Verretweetregistrado extends TweetRetweetajeno {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;

	// Objeto ORMPersistable para el retweet que se muestra
	public basededatos.Retweet r;
	public Tweet tweetRetweet; // Tweet que es un retweet
	private BD_Usuario_Registrado bdUsuario = new BD_Usuario_Registrado();
	private boolean yaLeGusta = false;

	// Constructor directo que acepta un Tweet que es un retweet
	public Verretweetregistrado(Tweet tweetRetweet) {
		super(tweetRetweet);
		this.tweetRetweet = tweetRetweet;

		// Rellenar datos del tweet retweet
		cargarDatosRetweet();
		configurarEventos();
	}

	// Constructor legacy para compatibilidad (deprecado)
	@Deprecated
	public Verretweetregistrado(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado,
			basededatos.Retweet r) {
		super(r != null ? r.getTweet() : null);
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;
		this.r = r;

		// Rellenar datos del retweet
		rellenarDatosRetweet();
		configurarEventos();
	}

	public Verretweetregistrado(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado,
			Tweet tweetRetweet) {
		super(tweetRetweet);
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;
		this.tweetRetweet = tweetRetweet;

		// Rellenar datos del tweet retweet
		cargarDatosRetweet();
		configurarEventos();
	}

	// Constructor de compatibilidad temporal
	public Verretweetregistrado(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado) {
		this(_listadetweetsyretweetsregistrado, (basededatos.Retweet) null);
	}

	private void configurarEventos() {
		this.Listadecomentariosregistrado();

		this.getBotonVolver().addClickListener(event -> {
			if (Pantalla.Anterior != null) {
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(Pantalla.Anterior);
			} else {
				Pantalla.MainView.removeAll();
				Pantalla.MainView
						.add(new ACT02UsuarioRegistrado(Pantalla.MainView, MainView.Usuario.usuarioRegistrado));
			}
		});

		this.getIconoRetweet().addClickListener(event -> {
			this.Darretweet();
		});

		this.getIconoComentarios().addClickListener(event -> {
			this.Escribircomentario();
		});
		// Configurar me gusta para el tweet original
		this.getIconoMeGusta().addClickListener(event -> {
			if (yaLeGusta) {
				eliminarMeGusta();
			} else {
				darMeGusta();
			}
		});

		actualizarEstadoMeGusta();
		actualizarContadores();
	}

	private void rellenarDatosRetweet() {
		if (r != null) {
			try {
				// TWEET EXTERIOR (RETWEET): Datos del usuario que hizo el retweet
				if (r.getUsuario_Registrado() != null) {
					this.getArrobaUsuario().setText("@" + r.getUsuario_Registrado().getNickname());
					this.getNombreUsuario().setText(r.getUsuario_Registrado().getNickname());
				}

				// TWEET EXTERIOR: Fecha del retweet
				if (r.getFechaPublicacion() != null) {
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMM yyyy");
					this.getFechaPublicacion().setText(sdf.format(r.getFechaPublicacion()));
				}

				// TWEET EXTERIOR: Contenido del retweet
				// Los retweets simples no tienen contenido adicional
				this.getTextoPublicacion().setText("Retweeteó:");

				// TWEET INTERIOR (CITADO): Datos del tweet original
				if (r.getTweet() != null) {
					basededatos.Tweet tweetOriginal = r.getTweet();

					// Tweet citado: Contenido del tweet original
					if (tweetOriginal.getContenidoTweet() != null) {
						this.getTextoPublicacionCitada().setText(tweetOriginal.getContenidoTweet());
					}

					// Tweet citado: Usuario original
					if (tweetOriginal.getPublicado_por() != null) {
						this.getArrobaUsuarioCitado().setText("@" + tweetOriginal.getPublicado_por().getNickname());
						this.getNombreUsuarioCitado().setText(tweetOriginal.getPublicado_por().getNickname());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error rellenando datos del retweet: " + e.getMessage());
			}
		}
	}

	private void cargarDatosRetweet() {
		if (tweet == null)
			return;

		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// DATOS DEL RETWEET (quien retweeteó y cuándo)
			// Configurar datos del usuario que hizo el retweet
			if (tweet.getPublicado_por() != null) {
				if (this.getArrobaUsuario() != null) {
					this.getArrobaUsuario().setText("@" + tweet.getPublicado_por().getNickname());
				}
				if (this.getNombreUsuario() != null) {
					this.getNombreUsuario().setText(tweet.getPublicado_por().getNickname());
				}
			}

			// Configurar fecha del retweet
			if (tweet.getFechaPublicacion() != null && this.getFechaPublicacion() != null) {
				this.getFechaPublicacion().setText(tweet.getFechaPublicacion().toString());
			}

			// Configurar contenido del retweet (si tiene texto adicional)
			if (this.getTextoPublicacion() != null) {
				String contenidoRetweet = tweet.getContenidoTweet() != null ? tweet.getContenidoTweet() : "";
				this.getTextoPublicacion().setText(contenidoRetweet);
			}

			// DATOS DE LA PUBLICACIÓN CITADA (tweet original)
			basededatos.Tweet tweetOriginal = tweet.getTweet_retweeteado();
			if (tweetOriginal != null) {
				// Configurar layout de publicación citada
				if (this.getContenedorPublicacionCitada() != null) {
					this.getContenedorPublicacionCitada().setVisible(true);

					// Datos del usuario original en la sección citada
					if (tweetOriginal.getPublicado_por() != null) {
						if (this.getArrobaUsuarioCitado() != null) {
							this.getArrobaUsuarioCitado().setText("@" + tweetOriginal.getPublicado_por().getNickname());
						}
						if (this.getNombreUsuarioCitado() != null) {
							this.getNombreUsuarioCitado().setText(tweetOriginal.getPublicado_por().getNickname());
						}
					}

					// Contenido del tweet original citado
					if (this.getTextoPublicacionCitada() != null) {
						String contenidoOriginal = tweetOriginal.getContenidoTweet() != null
								? tweetOriginal.getContenidoTweet()
								: "";
						this.getTextoPublicacionCitada().setText(contenidoOriginal);
					}
				}
			}

			// Contadores del retweet (siempre se muestran)
			int likesCount = bd.contarLikesTweet(tweet.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(tweet.getORMID());
			int comentariosCount = bd.contarComentariosTweet(tweet.getORMID());

			if (this.getNumMegusta() != null) {
				this.getNumMegusta().setText(String.valueOf(likesCount));
			}
			if (this.getNumeroRetweets() != null) {
				this.getNumeroRetweets().setText(String.valueOf(retweetsCount));
			}
			if (this.getNumeroRetweets1() != null) {
				this.getNumeroRetweets1().setText(String.valueOf(comentariosCount));
			}

		} catch (Exception e) {
			System.err.println("Error cargando datos del retweet: " + e.getMessage());
			e.printStackTrace();
			// Valores por defecto en caso de error
			if (this.getTextoPublicacion() != null) {
				this.getTextoPublicacion().setText("Error cargando retweet");
			}
		}
	}

	public void darMeGusta() {
		try {
			Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();
			Tweet tweetParaMeGusta = obtenerTweetParaMeGusta();

			if (usuarioActual != null && tweetParaMeGusta != null) {
				bdUsuario.darMeGustaTweet(usuarioActual.getId_usuario(), tweetParaMeGusta.getId_tweet());
				yaLeGusta = true;
				actualizarUIBotonMeGusta();
				actualizarContadores();

				Notification.show("¡Te gusta este tweet!", 2000, Notification.Position.BOTTOM_CENTER);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
			Notification.show("Error al dar me gusta", 3000, Notification.Position.BOTTOM_CENTER);
		}
	}

	public void eliminarMeGusta() {
		try {
			Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();
			Tweet tweetParaMeGusta = obtenerTweetParaMeGusta();

			if (usuarioActual != null && tweetParaMeGusta != null) {
				bdUsuario.eliminarMgTweet(usuarioActual.getId_usuario(), tweetParaMeGusta.getId_tweet());
				yaLeGusta = false;
				actualizarUIBotonMeGusta();
				actualizarContadores();

				Notification.show("Ya no te gusta este tweet", 2000, Notification.Position.BOTTOM_CENTER);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
			Notification.show("Error al eliminar me gusta", 3000, Notification.Position.BOTTOM_CENTER);
		}
	}

	private Tweet obtenerTweetParaMeGusta() {
		// Determinar qué tweet usar para me gusta (el original, no el retweet)
		if (r != null && r.getTweet() != null) {
			return r.getTweet();
		} else if (tweetRetweet != null && tweetRetweet.getTweet_retweeteado() != null) {
			return tweetRetweet.getTweet_retweeteado();
		}
		return null;
	}

	private void actualizarEstadoMeGusta() {
		try {
			Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();
			Tweet tweetParaMeGusta = obtenerTweetParaMeGusta();

			if (usuarioActual != null && tweetParaMeGusta != null) {
				// Usar método seguro de BD_Tweet que no depende de colecciones lazy
				basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
				yaLeGusta = bdTweet.verificarMeGustaTweet(usuarioActual.getId_usuario(),
						tweetParaMeGusta.getId_tweet());
				actualizarUIBotonMeGusta();
			}
		} catch (Exception e) {
			e.printStackTrace();
			yaLeGusta = false; // Valor por defecto en caso de error
			actualizarUIBotonMeGusta();
		}
	}

	private void actualizarUIBotonMeGusta() {
		if (yaLeGusta) {
			this.getIconoMeGusta().getStyle().set("color", "#e0245e"); // Rojo filled
		} else {
			this.getIconoMeGusta().getStyle().set("color", "#8899a6"); // Gris outline
		}
	}

	private void actualizarContadores() {
		Tweet tweetParaMeGusta = obtenerTweetParaMeGusta();
		if (tweetParaMeGusta != null) {
			try { // Usar métodos seguros de BD_Tweet para evitar LazyInitializationException
				basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
				int numMeGusta = bdTweet.contarMeGustaTweet(tweetParaMeGusta.getId_tweet());
				int numRetweets = bdTweet.contarRetweetsTweet(tweetParaMeGusta.getId_tweet());
				// int numComentarios =
				// bdTweet.contarComentariosTweet(tweetParaMeGusta.getId_tweet()); // Para uso
				// futuro

				// Actualizar contadores en la UI
				this.getNumMegusta().setText(String.valueOf(numMeGusta));
				this.getNumeroRetweets().setText(String.valueOf(numRetweets));
				// TODO: Actualizar contador de comentarios cuando esté disponible el elemento
				// UI

				// Actualizar también en el item padre si existe
				if (_listadetweetsyretweetsregistrado != null) {
					// TODO: Implementar actualizarContadores en el item padre
					// _listadetweetsyretweetsregistrado.actualizarContadores();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error actualizando contadores: " + e.getMessage());
			}
		}
	}
}