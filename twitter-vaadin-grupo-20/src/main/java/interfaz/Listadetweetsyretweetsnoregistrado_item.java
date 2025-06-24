package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsnoregistrado_item extends Listadetweetsyretweets_item {
	public Vertweetnoregistrado _vertweetnoregistrado;
	
	// Constructor original
	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);
		configurarEventos();
	}
		// Constructor que acepta Tweet - METODOLOGÍA ACTIVIDAD 12
	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets, basededatos.Tweet t) {
		super(_listadetweetsyretweets, t);
		
		// Rellenar datos del tweet si está disponible
		if (t != null) {
			rellenarDatosTweet();
			cargarContadoresIniciales();
		}
		
		configurarEventos();
	}
		private void rellenarDatosTweet() {
		if (t != null) {
			try {
				// Rellenar contenido del tweet
				String contenido;
				if (t.getContenidoTweet() != null && !t.getContenidoTweet().trim().isEmpty()) {
					if (t.getTweet_retweeteado() != null) {
						contenido = "🔄 Retweeteado: " + t.getContenidoTweet();
					} else {
						contenido = t.getContenidoTweet();
					}
				} else {
					contenido = "Tweet sin contenido";
				}
				
				// Rellenar datos del usuario
				String usuario;
				String username;
				if (t.getPublicado_por() != null) {
					basededatos.Usuario_Registrado usuarioPublicador = t.getPublicado_por();
					if (usuarioPublicador.getNickname() != null && !usuarioPublicador.getNickname().trim().isEmpty()) {
						usuario = usuarioPublicador.getNickname();
						username = "@" + usuarioPublicador.getNickname();
					} else {
						usuario = "Usuario";
						username = "@usuario";
					}
				} else {
					usuario = "Usuario";
					username = "@usuario";
				}
				
				// Rellenar fecha
				String fecha;
				if (t.getFechaPublicacion() != null) {
					fecha = formatearFecha(t.getFechaPublicacion());
				} else {
					fecha = "Fecha";
				}
				
				// Actualizar elementos UI
				this.getContentText().setText(contenido);
				this.getNickName().setText(usuario);
				this.getUsername().setText(username);
				this.getDateLabel().setText(fecha);
				
			} catch (Exception e) {
				System.err.println("Error rellenando datos del tweet para no registrado: " + e.getMessage());
			}
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
	
	/**
	 * Cargar contadores iniciales de me gusta, retweets y comentarios para usuarios no registrados
	 */
	private void cargarContadoresIniciales() {
		if (t != null) {
			try {
				// Cargar contadores usando métodos seguros de BD_Tweet
				basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
				int numMeGusta = bdTweet.contarMeGustaTweet(t.getId_tweet());
				int numRetweets = bdTweet.contarRetweetsTweet(t.getId_tweet());
				int numComentarios = bdTweet.contarComentariosTweet(t.getId_tweet());
				
				// Actualizar los contadores en la UI
				this.getLikesCountLabel().setText(String.valueOf(numMeGusta));
				this.getXLabel().setText(String.valueOf(numRetweets));
				this.getZLabel().setText(String.valueOf(numComentarios));
				
			} catch (Exception e) {
				System.err.println("Error cargando contadores para no registrado: " + e.getMessage());
				// Valores por defecto en caso de error
				this.getLikesCountLabel().setText("0");
				this.getXLabel().setText("0");
				this.getZLabel().setText("0");
			}
		}
	}
	
	private void configurarEventos() {
		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			Vertweetnoregistrado();
		});
	}

	public void Vertweetnoregistrado() {
		// Pasar el tweet a la vista de detalle
		_vertweetnoregistrado = new Vertweetnoregistrado(this, t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetnoregistrado);
	}
}
