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
		}
		
		configurarEventos();
	}
	
	private void rellenarDatosTweet() {
		if (t != null) {
			// Rellenar contenido del tweet
			if (t.getContenidoTweet() != null) {
				// this.getTextoTweet().setText(t.getContenidoTweet());
			}
			
			// Rellenar datos del usuario
			if (t.getPublicado_por() != null) {
				// this.getNombreUsuario().setText(t.getPublicado_por().getNickname());
			}
			
			// Rellenar fecha
			if (t.getFechaPublicacion() != null) {
				// this.getFechaTweet().setText(t.getFechaPublicacion().toString());
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
