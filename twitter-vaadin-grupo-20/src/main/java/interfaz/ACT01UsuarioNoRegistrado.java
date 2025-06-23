package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaAct01usuarionoregistrado;
import mds2.MainView;
import mds2.MainView.Pantalla;

public class ACT01UsuarioNoRegistrado extends VistaAct01usuarionoregistrado {
	public IniciarsesinconGoogle _iniciarsesinconGoogle;
	public Registrarse _registrarse;
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Restablecercontrasea _restablecercontrasea;
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Iniciarsesin _iniciarsesin;
	public MainView _mainView;
	
	// Usuario no registrado no necesita objeto ORMPersistable porque no se almacena en BD

	public ACT01UsuarioNoRegistrado(MainView mainView) {
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
		
		// Verificar que hay componentes antes de acceder
		if (Pantalla.MainView.getComponentCount() > 0) {
			Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		} else {
			Pantalla.Anterior = this;
		}
		
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_registrarse);
	}

	public void Listafijadeusuariosnoregistrado() {
		_listafijadeusuariosnoregistrado = new Listafijadeusuariosnoregistrado(this);
		this.getVerticalLayoutListaUsuarios().as(VerticalLayout.class)
				.add(_listafijadeusuariosnoregistrado);
	}

	public void Listafijadehashtagsnoregistrado() {
		_listafijadehashtagsnoregistrado = new Listafijadehashtagsnoregistrado(this);
		this.getVerticalLayoutListaHashtagsNoRegistrado().as(VerticalLayout.class)
				.add(_listafijadehashtagsnoregistrado);
	}

	public void Iniciarsesin() {
		_iniciarsesin = new Iniciarsesin(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_iniciarsesin);
	}

	public void VerlistaampliadadeusuariosNoRegistrado() {
		_listafijadeusuariosnoregistrado.Verlistaampliadadeusuariosnoregistrado();
	}

	public void VerlistaampliadadehashtagsNoRegistrado() {
		_listafijadehashtagsnoregistrado.Verlistaampliadadehashtagsnoregistrado();
	}
}