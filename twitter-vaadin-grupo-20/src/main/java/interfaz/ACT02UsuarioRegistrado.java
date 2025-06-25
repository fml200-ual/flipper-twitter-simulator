package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Tweet;
import mds2.MainView;
import mds2.MainView.Pantalla;
import mds2.MainView.Usuario;

public class ACT02UsuarioRegistrado extends ACT06SesinIniciada {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verpropioperfil _verpropioperfil;
	public Escribirtweet _escribirtweet;
	public Vernotificaciones _vernotificaciones;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	public basededatos.Usuario_Registrado _usuarioRegistrado;

	// Objeto ORMPersistable para el usuario registrado
	public basededatos.Usuario_Registrado u;

	public ACT02UsuarioRegistrado(MainView mainView, basededatos.Usuario_Registrado u) {
		super(mainView);
		this.u = u;

		// Asegurarse de que el usuario esté disponible en MainView.Usuario
		if (u != null) {
			mds2.MainView.Usuario.usuarioRegistrado = u;
			System.out.println("Usuario asignado en ACT02UsuarioRegistrado: " + u.getNickname() + " (ID: "
					+ u.getId_usuario() + ")");
		} else {
			System.err.println("Error: Usuario null pasado a ACT02UsuarioRegistrado");
			// Intentar obtener el usuario actual
			mds2.MainView.Usuario.usuarioRegistrado = mds2.MainView.obtenerUsuarioActual();
			this.u = mds2.MainView.Usuario.usuarioRegistrado;
		}

		this.getSpanListaTweetsRecientes().setVisible(false);

		        // Configurar el avatar superior con la imagen del usuario
        configurarAvatarSuperior();

		Listafijadeusuariosregistrado();
		Listafijadehashtagsregistrado();
		Listadetweetsyretweetsregistrado();

		this.getBotonPerfilPropioRegistrado()
				.addClickListener(event -> Verpropioperfil());
		this.getBotonEscribirTweet()
				.addClickListener(event -> Escribirtweet());
		this.getBotonNotificacionesRegistrado()
				.addClickListener(event -> Vernotificaciones());
		this.getBotonMasUsuarios()
				.addClickListener(event -> _listafijadeusuariosregistrado.Verlistaampliadadeusuariosregistrado());
		this.getBotonMasHashtags()
				.addClickListener(event -> _listafijadehashtagsregistrado.Verlistaampliadadehashtagsregistrado());
		this.getBotonCerrarSesionPrimerBoton().addClickListener(event -> {
			this.Cerrarsesin();
		});
		this.getBotonEscribirTweet().addClickListener(event -> {
			Escribirtweet();
		});

	}

	public void Listafijadeusuariosregistrado() {
		_listafijadeusuariosregistrado = new Listafijadeusuariosregistrado(this);
		this.getVerticalLayoutListaUsuarios().as(VerticalLayout.class)
				.add(_listafijadeusuariosregistrado);
	}

	public void Listafijadehashtagsregistrado() {
		_listafijadehashtagsregistrado = new Listafijadehashtagsregistrado(this);
		this.getVerticalLayoutListaHashtagsSesionIniciada().as(VerticalLayout.class)
				.add(_listafijadehashtagsregistrado);
	}

	public void Verpropioperfil() {
		_verpropioperfil = new Verpropioperfil(this);

		// Verificar que hay componentes antes de acceder
		if (Pantalla.MainView.getComponentCount() > 0) {
			Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		} else {
			Pantalla.Anterior = this;
		}

		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verpropioperfil);
	}

	public void Escribirtweet() {
		_escribirtweet = new Escribirtweet(this);

		// Verificar que hay componentes antes de acceder
		if (Pantalla.MainView.getComponentCount() > 0) {
			Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		} else {
			Pantalla.Anterior = this;
		}

		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_escribirtweet);
	}

	public void Vernotificaciones() {
		_vernotificaciones = new Vernotificaciones(this);

		// Verificar que hay componentes antes de acceder
		if (Pantalla.MainView.getComponentCount() > 0) {
			Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		} else {
			Pantalla.Anterior = this;
		}

		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vernotificaciones);
	}

	public void Listadetweetsyretweetsregistrado() {
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);
		Tweet[] tweets = Usuario.iAdministrador.cargarTweets();

		for (int i = 0; i < Math.min(5, tweets.length); i++) {
			Tweet tweet = tweets[i];
			if (tweet != null) {
				Listadetweetsyretweetsregistrado_item item = new Listadetweetsyretweetsregistrado_item(
						_listadetweetsyretweetsregistrado, tweet);
				_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class).add(item);
			} else {
				System.out.println("Tweet nulo encontrado en la lista de tweets");
			}
		}

		this.getVerticalLayoutListaTweets().as(VerticalLayout.class).add(_listadetweetsyretweetsregistrado);
	}
	
	// Constructor sin datos (para compatibilidad temporal)
	public ACT02UsuarioRegistrado(MainView mainView) {
		this(mainView, null);
	}

	    /**
     * Configurar el avatar superior con la imagen de perfil del usuario logueado
     */
    private void configurarAvatarSuperior() {
        if (u != null && u.getFotoPerfilURL() != null && !u.getFotoPerfilURL().isEmpty() 
            && !u.getFotoPerfilURL().equals("default-profile.jpg")) {
            // Configurar el avatar con la imagen de perfil del usuario
            this.getImagenAdministrador().setSrc(u.getFotoPerfilURL());
            this.getImagenAdministrador().setAlt("Avatar de " + u.getNickname());
            System.out.println("Avatar superior configurado para: " + u.getNickname());
        } else {
            // Usar imagen por defecto
            this.getImagenAdministrador().setSrc("https://icons.getbootstrap.com/assets/icons/person.svg");
            this.getImagenAdministrador().setAlt("Avatar por defecto");
        }
    }
    
    /**
     * Método público para actualizar el avatar superior tras cambios de perfil
     */
    public void actualizarAvatarSuperior() {
        try {
            configurarAvatarSuperior();
            System.out.println("Avatar superior actualizado");
        } catch (Exception e) {
            System.err.println("Error actualizando avatar superior: " + e.getMessage());
        }
    }
}