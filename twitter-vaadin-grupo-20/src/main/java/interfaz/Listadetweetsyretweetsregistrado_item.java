package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;

import mds2.MainView.Pantalla;
import basededatos.Tweet;

public class Listadetweetsyretweetsregistrado_item extends Listadetweetsyretweets_item {
	public Vertweetregistrado _vertweetregistrado;
	public Verretweetregistrado _verretweetregistrado;
	public Vertweetpropio _vertweetpropio;
	public Verretweetpropio _verretweetpropio;
	
	public Tweet t; // Tweet asociado a este item

	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);

		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			// Luego hay que diferenciar entre tweet y retweet. Tambien si es propio o no
			// Llamar a la vista de ver tweet registrado por defecto
			Vertweetregistrado();
		});
	}

	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets, Tweet t) {
		super(_listadetweetsyretweets, t);
		this.t = t;
		
		// Configurar visibilidad de botones según el contexto
		// TODO: Implementar lógica de botones cuando estén disponibles en la vista
		
		// Si es un retweet, mostrar el tweet original
		if (this.t.getTweet_retweeteado() != null) {
			Tweet tweetOriginal = this.t.getTweet_retweeteado();
			Listadetweetsyretweetsregistrado_item itemOriginal = 
				new Listadetweetsyretweetsregistrado_item(this._listadetweetsyretweets, tweetOriginal);
			
			// Ocultar botones en el tweet original anidado
			// TODO: Implementar cuando los getters de botones estén disponibles
			
			// Agregar al contenedor de retweet
			// TODO: Agregar al contenedor cuando esté disponible
		}
		
		// Configurar click listener para navegar según el tipo y propietario
		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			if (t != null && t.getTweet_retweeteado() != null) {
				// Es un retweet
				if (esPropio()) {
					Verretweetpropio();
				} else {
					Verretweetregistrado();
				}
			} else {
				// Es un tweet normal
				if (esPropio()) {
					Vertweetpropio();
				} else {
					Vertweetregistrado();
				}
			}
		});
	}
	
	private boolean esPropio() {
		// TODO: Implementar lógica para determinar si el tweet es del usuario actual
		// return this.t.getPublicado_por().equals(Usuario.user);
		return false; // Por ahora siempre false hasta que tengamos acceso al usuario actual
	}

	public void Vertweetregistrado() {
		_vertweetregistrado = new Vertweetregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetregistrado);
	}

	public void Verretweetregistrado() {
		_verretweetregistrado = new Verretweetregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetregistrado);
	}

	public void Vertweetpropio() {
		_vertweetpropio = new Vertweetpropio(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetpropio);
	}

	public void Verretweetpropio() {
		_verretweetpropio = new Verretweetpropio(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetpropio);
	}
}