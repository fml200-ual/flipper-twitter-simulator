package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView;
import mds2.MainView.Pantalla;

public class ACT02UsuarioRegistrado extends ACT06SesinIniciada {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verpropioperfil _verpropioperfil;
	public Escribirtweet _escribirtweet;
	public Vernotificaciones _vernotificaciones;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	public basededatos.Usuario_Registrado _usuarioRegistrado;
	
	// Objeto ORMPersistable para el usuario registrado
	public basededatos.Usuario_Registrado u;	public ACT02UsuarioRegistrado(MainView mainView, basededatos.Usuario_Registrado u) {
		super(mainView);
		this.u = u;
		
		// Asegurarse de que el usuario esté disponible en MainView.Usuario
		if (u != null) {
			mds2.MainView.Usuario.usuarioRegistrado = u;
			System.out.println("Usuario asignado en ACT02UsuarioRegistrado: " + u.getNickname() + " (ID: " + u.getId_usuario() + ")");
		} else {
			System.err.println("Error: Usuario null pasado a ACT02UsuarioRegistrado");
			// Intentar obtener el usuario actual
			mds2.MainView.Usuario.usuarioRegistrado = mds2.MainView.obtenerUsuarioActual();
			this.u = mds2.MainView.Usuario.usuarioRegistrado;
		}

		this.getSpanListaTweetsRecientes().setVisible(false);

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
		// Crear la lista - la inicialización automática carga los tweets de la BD
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);

		// Los tweets ya están cargados automáticamente en la lista
		// No necesitamos crear items manualmente

		this.getVerticalLayoutListaTweets().as(VerticalLayout.class).add(_listadetweetsyretweetsregistrado);
	}
	
	// Constructor sin datos (para compatibilidad temporal)
	public ACT02UsuarioRegistrado(MainView mainView) {
		this(mainView, null);
	}
}