package interfaz;

import com.vaadin.flow.component.html.Image;
import mds2.MainView.Pantalla;
import vistas.VistaListadetweetsyretweets_item;

public class Listadetweetsyretweets_item extends VistaListadetweetsyretweets_item {
	public Listadetweetsyretweets _listadetweetsyretweets;
	public basededatos.Tweet t;

	public Listadetweetsyretweets_item(Listadetweetsyretweets listadetweetsyretweets, basededatos.Tweet t) {
		super();
		this._listadetweetsyretweets = listadetweetsyretweets;
		this.t = t;
		
		// Cargar datos del tweet
		cargarDatosTweet();
		
		// Configurar eventos de navegación
		configurarEventosNavegacion();
	}

	private void cargarDatosTweet() {
		if (t == null) return;

		try {
			// Configurar nickname del usuario
			if (this.getNickName() != null && t.getPublicado_por() != null) {
				this.getNickName().setText(t.getPublicado_por().getNickname());
			}

			// Configurar username 
			if (this.getUsername() != null && t.getPublicado_por() != null) {
				this.getUsername().setText("@" + t.getPublicado_por().getNickname());
			}

			// Configurar contenido del tweet
			if (this.getContentText() != null) {
				String contenido = t.getContenidoTweet() != null ? t.getContenidoTweet() : "";
				this.getContentText().setText(contenido);
			}

			// Configurar fecha de publicación
			if (this.getDateLabel() != null && t.getFechaPublicacion() != null) {
				this.getDateLabel().setText(t.getFechaPublicacion().toString());
			}

			// Configurar contadores usando métodos BD para evitar LazyInitializationException
			configurarContadores();

			// Configurar foto de perfil en el avatar
			configurarAvatar();

		} catch (Exception e) {
			System.err.println("Error cargando datos del tweet: " + e.getMessage());
			// Valores por defecto en caso de error
			if (this.getContentText() != null) {
				this.getContentText().setText("Error cargando tweet");
			}
		}
	}

	private void configurarAvatar() {
		try {
			if (t.getPublicado_por() != null && t.getPublicado_por().getFotoPerfilURL() != null) {
				// Crear imagen de perfil
				Image img = new Image(t.getPublicado_por().getFotoPerfilURL(), "Foto de perfil");
				img.setWidth("40px");
				img.setHeight("40px");
				img.getStyle().set("border-radius", "50%");
				
				// Agregar la imagen al elemento avatar
				if (this.getAvatarIcon() != null) {
					this.getAvatarIcon().removeAllChildren();
					this.getAvatarIcon().appendChild(img.getElement());
				}
			}
		} catch (Exception e) {
			System.err.println("Error configurando avatar: " + e.getMessage());
		}
	}

	private void configurarContadores() {
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Contar comentarios, retweets y me gusta desde la BD
			int comentariosCount = bd.contarComentariosTweet(t.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(t.getORMID());
			int likesCount = bd.contarLikesTweet(t.getORMID());

			// Actualizar contadores en la UI usando los elementos disponibles
			if (this.getLikesCountLabel() != null) {
				this.getLikesCountLabel().setText(String.valueOf(likesCount));
			}
			if (this.getXLabel() != null) {
				this.getXLabel().setText(String.valueOf(retweetsCount));
			}
			if (this.getZLabel() != null) {
				this.getZLabel().setText(String.valueOf(comentariosCount));
			}

		} catch (Exception e) {
			System.err.println("Error configurando contadores: " + e.getMessage());
			// Valores por defecto en caso de error
			if (this.getLikesCountLabel() != null) this.getLikesCountLabel().setText("0");
			if (this.getXLabel() != null) this.getXLabel().setText("0");
			if (this.getZLabel() != null) this.getZLabel().setText("0");
		}
	}

	private void configurarEventosNavegacion() {
		// Configurar click en nickname para ver perfil
		if (this.getNickName() != null) {
			this.getNickName().addEventListener("click", event -> verPerfilUsuario());
		}

		// Configurar click en username para ver perfil
		if (this.getUsername() != null) {
			this.getUsername().addEventListener("click", event -> verPerfilUsuario());
		}

		// Configurar click en avatar para ver perfil
		if (this.getAvatarIcon() != null) {
			this.getAvatarIcon().addEventListener("click", event -> verPerfilUsuario());
		}

		// Configurar click en contenido para ver tweet
		if (this.getContentText() != null) {
			this.getContentText().addEventListener("click", event -> verTweet());
		}

		// Configurar click en el contenedor principal para ver tweet
		if (this.getMainContainer() != null) {
			this.getMainContainer().addEventListener("click", event -> verTweet());
		}
	}

	public void verTweet() {
		try {
			// Navegación directa según el tipo de usuario actual
			mds2.MainView.Usuario.usuarioRegistrado = mds2.MainView.obtenerUsuarioActual();
			
			if (mds2.MainView.Usuario.usuarioRegistrado != null) {
				// Usuario registrado - determinar si es el autor del tweet
				if (t.getPublicado_por() != null && 
					t.getPublicado_por().getId_usuario() == mds2.MainView.Usuario.usuarioRegistrado.getId_usuario()) {
					// Es su propio tweet
					Vertweetpropio verTweetPropio = new Vertweetpropio(t);
					Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
					Pantalla.MainView.removeAll();
					Pantalla.MainView.add(verTweetPropio);
				} else {
					// Tweet de otro usuario
					Vertweetregistrado verTweet = new Vertweetregistrado(t);
					Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
					Pantalla.MainView.removeAll();
					Pantalla.MainView.add(verTweet);
				}
			} else {
				// Usuario no registrado
				Vertweetnoregistrado verTweet = new Vertweetnoregistrado(t);
				Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(verTweet);
			}
		} catch (Exception e) {
			System.err.println("Error navegando a ver tweet: " + e.getMessage());
		}
	}

	public void verPerfilUsuario() {
		try {
			if (t.getPublicado_por() != null) {
				// Navegación directa al perfil del usuario
				Verperfilregistrado verPerfil = new Verperfilregistrado(t.getPublicado_por());
				Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(verPerfil);
			}
		} catch (Exception e) {
			System.err.println("Error navegando al perfil: " + e.getMessage());
		}
	}

	// Método legacy para compatibilidad (deprecado)
	@Deprecated
	public void Mostrarmstweets() {
		verTweet();
	}
}