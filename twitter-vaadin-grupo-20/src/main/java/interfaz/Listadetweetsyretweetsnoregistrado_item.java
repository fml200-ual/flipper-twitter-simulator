package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.Image;

import mds2.MainView.Pantalla;
import basededatos.Tweet;

public class Listadetweetsyretweetsnoregistrado_item extends Listadetweetsyretweets_item {
	public Verretweetnoregistrado _verretweetnoregistrado;
	public Vertweetnoregistrado _vertweetnoregistrado;
	
	public Tweet t; // Tweet asociado a este item

	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets, Tweet t) {
		super(_listadetweetsyretweets);
		this.t = t;
		
		// Poblar la interfaz con datos del tweet si están disponibles
		if (t != null) {
			actualizarDatosTweet();
		} else {
			mostrarDatosPorDefecto();
		}

		// Configurar click listener para navegar según el tipo
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
	}	private void actualizarDatosTweet() {
		// Actualizar contenido del tweet
		if (t.getContenidoTweet() != null && !t.getContenidoTweet().trim().isEmpty()) {
			this.getContentText().setText(t.getContenidoTweet());
		}
		
		// Actualizar información del usuario que publicó
		if (t.getPublicado_por() != null) {
			basededatos.Usuario_Registrado usuario = t.getPublicado_por();
			
			// Actualizar nickname del usuario
			if (usuario.getNickname() != null && !usuario.getNickname().trim().isEmpty()) {
				this.getNickName().setText(usuario.getNickname());
				// Actualizar username (el @nickname)
				this.getUsername().setText("@" + usuario.getNickname());
			}
			
			// Para la foto de perfil, por ahora mantenemos el icono por defecto
			// TODO: Implementar carga de imagen real cuando esté disponible
		}
		
		// Actualizar fecha de publicación
		if (t.getFechaPublicacion() != null) {
			String fechaFormateada = formatearFecha(t.getFechaPublicacion());
			this.getDateLabel().setText(fechaFormateada);
		}
		
		// Actualizar contador de likes (por ahora 0 hasta que tengamos esa funcionalidad)
		this.getLikesCountLabel().setText("0");
		
		// Si es un retweet, mostrar información adicional
		if (t.getTweet_retweeteado() != null) {
			// Agregar indicador de que es un retweet
			String contenidoConIndicador = "🔄 Retweeteado: " + (t.getContenidoTweet() != null ? t.getContenidoTweet() : "");
			this.getContentText().setText(contenidoConIndicador);
		}
	}
		
		// Si es un retweet, mostrar el tweet original
		if (t.getTweet_retweeteado() != null) {
			Tweet tweetOriginal = t.getTweet_retweeteado();
			// Crear un item para el tweet original (sin botones de interacción)
			Listadetweetsyretweetsnoregistrado_item itemOriginal = 
				new Listadetweetsyretweetsnoregistrado_item(this._listadetweetsyretweets, tweetOriginal);
			
			// Ocultar botones de interacción en el tweet original
			ocultarBotonesInteraccion(itemOriginal);
			
			// Agregar al contenedor principal después del contenido
			this.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
				.add(itemOriginal);
		}
		
		// Actualizar contadores (por ahora valores por defecto)
		this.getLikesCountLabel().setText("0");
		// Los botones X, Z ya están configurados en la vista
	}
	
	private String formatearFecha(java.util.Date fecha) {
		// Formatear fecha de manera simple
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMM yyyy");
		return sdf.format(fecha);
	}
	
	private void mostrarDatosPorDefecto() {
		// Mostrar datos por defecto cuando no hay tweet
		// this.getContenidoTweet().setText("Contenido no disponible");
		// this.getNickUsuario().setText("Usuario");
		// this.getFechaPublicacion().setText("Fecha no disponible");
	}
	
	private void ocultarBotonesInteraccion(Listadetweetsyretweetsnoregistrado_item item) {
		// Ocultar botones de interacción para tweets anidados (como retweets originales)
		// item.getBotonRetweet().setVisible(false);
		// item.getBotonMeGusta().setVisible(false);
		// item.getBotonComentario().setVisible(false);
	}

	public void Verretweetnoregistrado() {
		_verretweetnoregistrado = new Verretweetnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetnoregistrado);
	}

	public void Vertweetnoregistrado() {
		_vertweetnoregistrado = new Vertweetnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetnoregistrado);
	}
}