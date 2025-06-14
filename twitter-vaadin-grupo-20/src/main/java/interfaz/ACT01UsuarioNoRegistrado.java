package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaAct01usuarionoregistrado;
import mds2.MainView;

public class ACT01UsuarioNoRegistrado extends VistaAct01usuarionoregistrado {
	public IniciarsesinconGoogle _iniciarsesinconGoogle;
	public Registrarse _registrarse;
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Restablecercontrasea _restablecercontrasea;
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Iniciarsesin _iniciarsesin;
	public MainView _mainView;

	public ACT01UsuarioNoRegistrado(MainView mainView) {
		_mainView = mainView;
		// Ensamblado de componentes fijos para usuario no registrado
		Listafijadeusuariosnoregistrado();
		//Iniciarsesin();
		//Registrarse();
		//Listafijadehashtagsnoregistrado();
		
		// Ensamblado de componentes dinámicos - ClickListeners
		this.getBotonIniciarSesion().addClickListener(event -> Iniciarsesin());
		this.getBotonRegistrarse().addClickListener(event -> Registrarse());
		this.getBotonMasUsuarios().addClickListener(event -> VerlistaampliadadeusuariosNoRegistrado());
		this.getBotonMasHashtags().addClickListener(event -> VerlistaampliadadehashtagsNoRegistrado());
	}

	public void IniciarsesinconGoogle() {
		// Método no usado (sin botón Google)
	}

	public void Registrarse() {
		_registrarse = new Registrarse(this);
		_mainView.removeAll();
		_mainView.add(_registrarse);
	}

	public void Listafijadeusuariosnoregistrado() {
		_listafijadeusuariosnoregistrado = new Listafijadeusuariosnoregistrado(this);

		Listadeusuarios listadeusuarios = new Listadeusuarios((Verlistaampliadadeusuarios) null);
		this.getVerticalLayoutListaUsuarios().as(VerticalLayout.class).add(listadeusuarios);
	}

	public void Restablecercontrasea() {
		// Omitido por diseño
	}

	public void Listafijadehashtagsnoregistrado() {
		_listafijadehashtagsnoregistrado = new Listafijadehashtagsnoregistrado(this);
		this.getVerticalLayoutListaHashtagsNoRegistrado().as(VerticalLayout.class).add(_listafijadehashtagsnoregistrado);
	}

	public void Iniciarsesin() {
		_iniciarsesin = new Iniciarsesin(this);
		_mainView.removeAll();
		_mainView.add(_iniciarsesin);
	}

	public void VerlistaampliadadeusuariosNoRegistrado() {
		Verlistaampliadadeusuariosnoregistrado verListaUsuarios = new Verlistaampliadadeusuariosnoregistrado(this);
		_mainView.removeAll();
		_mainView.add(verListaUsuarios);
	}

	public void VerlistaampliadadehashtagsNoRegistrado() {
		Verlistaampliadadehashtagsnoregistrado verListaHashtags = new Verlistaampliadadehashtagsnoregistrado(this);
		_mainView.removeAll();
		_mainView.add(verListaHashtags);
	}
}