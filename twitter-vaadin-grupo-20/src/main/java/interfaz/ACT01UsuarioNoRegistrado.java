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
	public MainView _mainView;	public ACT01UsuarioNoRegistrado(MainView mainView) {
		super(); // Llamar al constructor padre
		_mainView = mainView;
		// Ensamblado de componentes fijos para usuario no registrado
		Listafijadeusuariosnoregistrado();
		Listafijadehashtagsnoregistrado();
		
		// Ensamblado dinámico - ClickListeners para botones
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
		this.getVerticalLayoutCentralNoRegistrado().as(VerticalLayout.class).removeAll();
		this.getVerticalLayoutCentralNoRegistrado().as(VerticalLayout.class).add(_registrarse);
	}
	public void Listafijadeusuariosnoregistrado() {
		Listadeusuarios listadeusuarios = new Listadeusuarios((Verlistaampliadadeusuarios) null);
		listadeusuarios.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(listadeusuarios, this)); // Pasar referencia
		listadeusuarios.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(listadeusuarios, this)); // Pasar referencia
		this.getVerticalLayoutListaUsuarios().as(VerticalLayout.class)
				.add(listadeusuarios);
	}
	public void Listafijadehashtagsnoregistrado() {
		Listadehashtags listadehashtags = new Listadehashtags((Verlistaampliadadehashtagsnoregistrado) null);
		listadehashtags.getMainContainer().as(VerticalLayout.class)
				.add(new Listadehashtags_item(listadehashtags, this)); // Pasar referencia
		listadehashtags.getMainContainer().as(VerticalLayout.class)
				.add(new Listadehashtags_item(listadehashtags, this)); // Pasar referencia
		this.getVerticalLayoutListaHashtagsNoRegistrado().as(VerticalLayout.class)
				.add(listadehashtags);
	}
	public void Iniciarsesin() {
		_iniciarsesin = new Iniciarsesin(this);
		this.getVerticalLayoutCentralNoRegistrado().as(VerticalLayout.class).removeAll();
		this.getVerticalLayoutCentralNoRegistrado().as(VerticalLayout.class).add(_iniciarsesin);
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