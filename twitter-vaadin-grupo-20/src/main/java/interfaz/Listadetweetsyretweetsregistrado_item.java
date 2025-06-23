package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import mds2.MainView;
import basededatos.Tweet;

public class Listadetweetsyretweetsregistrado_item extends Listadetweetsyretweets_item {
	public Vertweetregistrado _vertweetregistrado;
	public Verretweetregistrado _verretweetregistrado;
	public Vertweetpropio _vertweetpropio;
	public Verretweetpropio _verretweetpropio;
	
	// Variables para controlar el estado de "me gusta"
	private boolean leGusta = false;
	private int contadorMeGusta = 0;
	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets, Tweet t) {
		super(_listadetweetsyretweets, t);
		
		// Poblar la interfaz con datos del tweet si están disponibles
		if (t != null) {
			actualizarDatosTweet();
			cargarEstadoMeGusta();
		} else {
			mostrarDatosPorDefecto();
		}

		// Configurar click listener para navegar según el tipo
		configurarEventos();
		
		// Configurar evento para el botón de "me gusta"
		configurarEventoMeGusta();
	}
	
	// Constructor de compatibilidad temporal
	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		this(_listadetweetsyretweets, null);
	}
	
	private void configurarEventos() {
		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			// TODO: Determinar si el tweet es propio del usuario actual
			boolean esTweetPropio = false; // Por ahora asumimos que no es propio
			
			if (t != null && t.getTweet_retweeteado() != null) {
				// Es un retweet
				if (esTweetPropio) {
					Verretweetpropio();
				} else {
					Verretweetregistrado();
				}
			} else {
				// Es un tweet normal
				if (esTweetPropio) {
					Vertweetpropio();
				} else {
					Vertweetregistrado();
				}
			}
		});
	}
		private void actualizarDatosTweet() {
		try {
			// Actualizar contenido del tweet
			if (t.getContenidoTweet() != null && !t.getContenidoTweet().trim().isEmpty()) {
				this.getElement().executeJs(
					"this.shadowRoot.querySelector('#contentText').textContent = '" + 
					t.getContenidoTweet().replace("'", "\\'") + "';"
				);
			}
			
			// Actualizar información del usuario que publicó
			if (t.getPublicado_por() != null) {
				basededatos.Usuario_Registrado usuario = t.getPublicado_por();
				
				// Actualizar nickname del usuario
				if (usuario.getNickname() != null && !usuario.getNickname().trim().isEmpty()) {
					this.getElement().executeJs(
						"this.shadowRoot.querySelector('#nickName').textContent = '" + 
						usuario.getNickname().replace("'", "\\'") + "';"
					);
					this.getElement().executeJs(
						"this.shadowRoot.querySelector('#username').textContent = '@" + 
						usuario.getNickname().replace("'", "\\'") + "';"
					);
				}
			}
			
			// Actualizar fecha de publicación
			if (t.getFechaPublicacion() != null) {
				String fechaFormateada = formatearFecha(t.getFechaPublicacion());
				this.getElement().executeJs(
					"this.shadowRoot.querySelector('#dateLabel').textContent = '" + 
					fechaFormateada + "';"
				);
			}
			
			// Si es un retweet, mostrar información adicional
			if (t.getTweet_retweeteado() != null) {
				String contenidoRetweet = "🔄 Retweeteado: " + 
					(t.getContenidoTweet() != null ? t.getContenidoTweet() : "");
				this.getElement().executeJs(
					"this.shadowRoot.querySelector('#contentText').textContent = '" + 
					contenidoRetweet.replace("'", "\\'") + "';"
				);
			}
		} catch (Exception e) {
			System.err.println("Error actualizando datos del tweet: " + e.getMessage());
		}
	}
	
	// Método de utilidad para formatear fechas
	private String formatearFecha(java.util.Date fecha) {
		try {
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
			return formatter.format(fecha);
		} catch (Exception e) {
			return "Fecha";
		}
	}
	
	private void mostrarDatosPorDefecto() {
		// Mostrar datos por defecto cuando no hay tweet
		// this.getContentText().setText("Contenido del tweet");
		// this.getNickName().setText("Usuario");
		// this.getUsername().setText("@usuario");
		// this.getDateLabel().setText("Ahora");
	}

	public void Vertweetregistrado() {
		_vertweetregistrado = new Vertweetregistrado(this, t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetregistrado);
	}
	public void Verretweetregistrado() {
		// TODO: Pasar el tweet cuando se actualice el constructor
		_verretweetregistrado = new Verretweetregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetregistrado);
	}

	public void Vertweetpropio() {
		// TODO: Pasar el tweet cuando se actualice el constructor
		_vertweetpropio = new Vertweetpropio(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetpropio);
	}

	public void Verretweetpropio() {
		// TODO: Pasar el tweet cuando se actualice el constructor
		_verretweetpropio = new Verretweetpropio(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetpropio);
	}
	
	private void cargarEstadoMeGusta() {		if (t != null) {
			try {
				// Obtener el ID del usuario actual
				int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
				
				// Verificar si al usuario actual le gusta este tweet
				basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
				leGusta = bdTweet.verificarMeGustaTweet(idUsuarioActual, t.getId_tweet());
				
				// Cargar el contador de "me gusta"
				contadorMeGusta = bdTweet.contarMeGustaTweet(t.getId_tweet());
				
				// Actualizar la UI
				actualizarUImeGusta();
			} catch (Exception e) {
				System.err.println("Error cargando estado de me gusta: " + e.getMessage());
				leGusta = false;
				contadorMeGusta = 0;
			}
		}
	}
		private void configurarEventoMeGusta() {
		// Configurar click listener en el corazón (heartIcon)
		try {
			// Usar setTimeout para asegurar que el elemento esté renderizado
			this.getElement().executeJs(
				"setTimeout(() => {" +
				"  const heartIcon = this.shadowRoot.querySelector('#heartIcon');" +
				"  if (heartIcon) {" +
				"    heartIcon.addEventListener('click', function(e) {" +
				"      e.stopPropagation();" +
				"      this.dispatchEvent(new CustomEvent('heart-clicked', {bubbles: true}));" +
				"    });" +
				"  } else {" +
				"    console.log('heartIcon not found');" +
				"  }" +
				"}, 200);"
			);
			
			// Escuchar el evento personalizado
			this.getElement().addEventListener("heart-clicked", e -> {
				toggleMeGusta();
			});
		} catch (Exception e) {
			System.err.println("Error configurando evento de me gusta: " + e.getMessage());
		}
	}
		private void toggleMeGusta() {
		if (t != null) {
			try {
				int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
				basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
				
				if (leGusta) {
					// Quitar "me gusta"
					if (bdTweet.quitarMeGustaTweet(idUsuarioActual, t.getId_tweet())) {
						leGusta = false;
						contadorMeGusta--;
						actualizarUImeGusta();
					}
				} else {
					// Dar "me gusta"
					if (bdTweet.darMeGustaTweet(idUsuarioActual, t.getId_tweet())) {
						leGusta = true;
						contadorMeGusta++;
						actualizarUImeGusta();
					}
				}
			} catch (Exception e) {
				System.err.println("Error al cambiar estado de me gusta: " + e.getMessage());
			}
		}
	}
	
	private void actualizarUImeGusta() {
		try {
			// Actualizar el texto del contador
			this.getElement().executeJs(
				"this.shadowRoot.querySelector('#likesCountLabel').textContent = '" + contadorMeGusta + "';"
			);
			
			// Cambiar el color del corazón
			String color = leGusta ? "red" : "#00FFFF"; // Rojo si le gusta, turquesa si no
			this.getElement().executeJs(
				"this.shadowRoot.querySelector('#heartIcon').style.color = '" + color + "';"
			);
		} catch (Exception e) {
			System.err.println("Error actualizando UI de me gusta: " + e.getMessage());
		}
	}
}
