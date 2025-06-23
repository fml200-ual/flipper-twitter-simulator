package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsadministrador_item extends Listadetweetsyretweets_item {
	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;

	public Listadetweetsyretweetsadministrador_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);

		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			// Luego hay que diferenciar entre tweet y retweet
			// Llamar a la vista de ver tweet administrador por defecto
			Vertweetadministrador();
		});
	}
		// Constructor que acepta Tweet - METODOLOGÍA ACTIVIDAD 12
	public Listadetweetsyretweetsadministrador_item(Listadetweetsyretweets _listadetweetsyretweets, basededatos.Tweet t) {
		super(_listadetweetsyretweets, t);
		
		// Rellenar datos del tweet si está disponible
		if (t != null) {
			rellenarDatosTweet();
		}
		
		// Configurar click listener específico para administrador
		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			if (t != null && t.getTweet_retweeteado() != null) {
				// Es un retweet
				Verretweetadministrador();
			} else {
				// Es un tweet normal
				Vertweetadministrador();
			}
		});
	}
	
	// Constructor que solo acepta Tweet (para llamadas desde listas fijas)
	public Listadetweetsyretweetsadministrador_item(basededatos.Tweet t) {
		this(null, t);
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
	public void Vertweetadministrador() {
		// Pasar el tweet a la vista de detalle - METODOLOGÍA ACTIVIDAD 12
		_vertweetadministrador = new Vertweetadministrador(this, t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetadministrador);
	}

	public void Verretweetadministrador() {
		// Pasar el retweet a la vista de detalle - METODOLOGÍA ACTIVIDAD 12
		_verretweetadministrador = new Verretweetadministrador(this, t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetadministrador);
	}
}