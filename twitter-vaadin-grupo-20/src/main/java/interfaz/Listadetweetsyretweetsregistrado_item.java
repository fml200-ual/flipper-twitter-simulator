package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.Tweet;

public class Listadetweetsyretweetsregistrado_item extends Listadetweetsyretweets_item {
	public Vertweetregistrado _vertweetregistrado;
	public Verretweetregistrado _verretweetregistrado;
	public Vertweetpropio _vertweetpropio;
	public Verretweetpropio _verretweetpropio;
	
	// Tweet asociado a este item (heredado de la clase padre)

	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets, Tweet t) {
		super(_listadetweetsyretweets, t);
		
		// Poblar la interfaz con datos del tweet si están disponibles
		if (t != null) {
			actualizarDatosTweet();
		} else {
			mostrarDatosPorDefecto();
		}

		// Configurar click listener para navegar según el tipo
		configurarEventos();
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
		// Actualizar contenido del tweet
		if (t.getContenidoTweet() != null && !t.getContenidoTweet().trim().isEmpty()) {
			// this.getContentText().setText(t.getContenidoTweet());
		}
		
		// Actualizar información del usuario que publicó
		if (t.getPublicado_por() != null) {
			basededatos.Usuario_Registrado usuario = t.getPublicado_por();
			
			// Actualizar nickname del usuario
			if (usuario.getNickname() != null && !usuario.getNickname().trim().isEmpty()) {
				// this.getNickName().setText(usuario.getNickname());
				// this.getUsername().setText("@" + usuario.getNickname());
			}
		}
				// Actualizar fecha de publicación
		if (t.getFechaPublicacion() != null) {
			// this.getDateLabel().setText(formatearFecha(t.getFechaPublicacion()));
		}
		
		// Si es un retweet, mostrar información adicional
		if (t.getTweet_retweeteado() != null) {
			// Agregar indicador de que es un retweet
			// this.getContentText().setText("🔄 Retweeteado: " + (t.getContenidoTweet() != null ? t.getContenidoTweet() : ""));
		}
	}
		// Método de utilidad para formatear fechas (comentado temporalmente)
	/*
	private String formatearFecha(java.util.Date fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return formatter.format(fecha);
	}
	*/
	
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
}
