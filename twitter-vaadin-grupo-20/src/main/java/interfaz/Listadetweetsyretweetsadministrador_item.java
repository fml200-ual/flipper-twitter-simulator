package interfaz;

import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsadministrador_item extends Listadetweetsyretweets_item {
	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;

	public Listadetweetsyretweetsadministrador_item(Listadetweetsyretweets listadetweetsyretweets, basededatos.Tweet t) {
		super(listadetweetsyretweets, t);
		
		// Configurar elementos específicos para administrador
		configurarVisibilidadAdministrador();
		
		// Configurar retweets anidados
		configurarRetweetAnidado();
		
		// Configurar eventos de navegación específicos para administrador
		configurarEventosAdministrador();
	}

	private void configurarVisibilidadAdministrador() {
		// Ocultar botones de interacción no disponibles para administradores
		// Los administradores pueden ver pero no interactuar con tweets
		try {
			// Ocultar elementos de interacción si existen
			if (this.getElement().getChildren().anyMatch(child -> 
				child.getAttribute("id") != null && child.getAttribute("id").contains("retweet"))) {
				// Ocultar botones de retweet
			}
			if (this.getElement().getChildren().anyMatch(child -> 
				child.getAttribute("id") != null && child.getAttribute("id").contains("megusta"))) {
				// Ocultar botones de me gusta
			}
		} catch (Exception e) {
			System.err.println("Error configurando visibilidad administrador: " + e.getMessage());
		}
	}

	private void configurarRetweetAnidado() {
		// Configurar retweets anidados como en el patrón de Lista_de_tweets_Administrador_item
		try {
			basededatos.Tweet tweetRT = this.t.getTweet_retweeteado();
			if (tweetRT != null) {
				// Crear item anidado para el tweet retweeteado
				Listadetweetsyretweetsadministrador_item itemAnidado = 
					new Listadetweetsyretweetsadministrador_item(this._listadetweetsyretweets, tweetRT);
				
				// Ocultar elementos de interacción en el item anidado
				ocultarElementosInteraccionAnidado(itemAnidado);
				
				// Agregar al contenedor de retweet si existe
				if (this.getElement().getChildren().anyMatch(child -> 
					child.getAttribute("class") != null && child.getAttribute("class").contains("retweet"))) {
					// Agregar el item anidado al contenedor de retweet
					this.getElement().appendChild(itemAnidado.getElement());
				}
			}
		} catch (Exception e) {
			System.err.println("Error configurando retweet anidado: " + e.getMessage());
		}
	}

	private void ocultarElementosInteraccionAnidado(Listadetweetsyretweetsadministrador_item itemAnidado) {
		// Ocultar elementos de interacción en el item anidado
		try {
			// Los items anidados no deben mostrar botones de interacción
			itemAnidado.getElement().getChildren().forEach(child -> {
				String className = child.getAttribute("class");
				if (className != null && (className.contains("button") || className.contains("icon"))) {
					child.setVisible(false);
				}
			});
		} catch (Exception e) {
			System.err.println("Error ocultando elementos de interacción: " + e.getMessage());
		}
	}

	private void configurarEventosAdministrador() {
		// Configurar eventos específicos para administrador
		if (this.getMainContainer() != null) {
			this.getMainContainer().addEventListener("click", event -> {
				if (t != null && t.getTweet_retweeteado() != null) {
					// Es un retweet
					Verretweetadministrador();
				} else {
					// Es un tweet normal
					Vertweetadministrador();
				}
			});
		}
	}

	public void Vertweetadministrador() {
		// Navegación directa pasando solo el tweet
		_vertweetadministrador = new Vertweetadministrador(t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetadministrador);
	}

	public void Verretweetadministrador() {
		// Navegación directa pasando solo el tweet (que es un retweet)
		_verretweetadministrador = new Verretweetadministrador(t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetadministrador);
	}

	// Sobrescribir métodos de navegación de la clase padre para usar vistas de administrador
	@Override
	public void verTweet() {
		if (t != null && t.getTweet_retweeteado() != null) {
			Verretweetadministrador();
		} else {
			Vertweetadministrador();
		}
	}

	@Override
	public void verPerfilUsuario() {
		try {
			if (t.getPublicado_por() != null) {
				// Los administradores pueden ver perfiles pero con vista especial
				// Por ahora usar la vista estándar
				Verperfilregistrado verPerfil = new Verperfilregistrado(t.getPublicado_por());
				Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(verPerfil);
			}
		} catch (Exception e) {
			System.err.println("Error navegando al perfil desde administrador: " + e.getMessage());
		}
	}
}