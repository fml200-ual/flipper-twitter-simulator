package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.Image;

import mds2.MainView.Pantalla;
import basededatos.Tweet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listadetweetsyretweetsnoregistrado_item extends Listadetweetsyretweets_item {
	public Verretweetnoregistrado _verretweetnoregistrado;
	public Vertweetnoregistrado _vertweetnoregistrado;
	
	// Tweet asociado a este item (heredado de la clase padre)

	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets, Tweet t) {
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
	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		this(_listadetweetsyretweets, null);
	}
	
	private void configurarEventos() {
		this.getMainContainer().as(VerticalLayout.class)
				.addClickListener(event -> {
					if (t != null && t.getTweet_retweeteado() != null) {
						// Es un retweet
						Verretweetnoregistrado();
					} else {
						// Es un tweet normal
						Vertweetnoregistrado();
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
			String fechaFormateada = formatearFecha(t.getFechaPublicacion());
			// this.getDateLabel().setText(fechaFormateada);
		}
		
		// Si es un retweet, mostrar información adicional
		if (t.getTweet_retweeteado() != null) {
			// Agregar indicador de que es un retweet
			String contenidoConIndicador = "🔄 Retweeteado: " + (t.getContenidoTweet() != null ? t.getContenidoTweet() : "");
			// this.getContentText().setText(contenidoConIndicador);
		}
	}
	
	private String formatearFecha(java.util.Date fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return formatter.format(fecha);
	}
	
	private void mostrarDatosPorDefecto() {
		// Mostrar datos por defecto cuando no hay tweet
		// this.getContentText().setText("Contenido del tweet");
		// this.getNickName().setText("Usuario");
		// this.getUsername().setText("@usuario");
		// this.getDateLabel().setText("Ahora");
	}
	
	public void Verretweetnoregistrado() {
		_verretweetnoregistrado = new Verretweetnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetnoregistrado);
	}
	
	public void Vertweetnoregistrado() {
		_vertweetnoregistrado = new Vertweetnoregistrado(this, t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetnoregistrado);
	}
}
