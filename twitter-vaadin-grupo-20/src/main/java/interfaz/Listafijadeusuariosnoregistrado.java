package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listafijadeusuariosnoregistrado extends Listafijadeusuarios {
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado;

	public Listafijadeusuariosnoregistrado(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		// Ensamblado de componentes fijos
		ListadeusuariosNR();
		// Ensamblado dinámico - ClickListeners para botones
	}

	public void ListadeusuariosNR() {
		basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
		basededatos.Usuario_Registrado[] usuarios = bd.cargarUsuarios();
		Listadeusuarios listaUsuarios = new Listadeusuarios(_verlistaampliadadeusuariosnoregistrado);

		for (int i = 0; i < Math.min(5, usuarios.length); i++) {
			basededatos.Usuario_Registrado usuario = usuarios[i];
			Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, usuario);

			// Agregar ClickListener personalizado para navegar al perfil con el usuario
			// correcto
			item.getMainContainer().addClickListener(event -> {
				Verperfilnoregistrado(usuario);
			});
			listaUsuarios.getMainContainer().as(VerticalLayout.class).add(item);
		}

		this.getMainContainer().as(VerticalLayout.class).add(listaUsuarios);
	}

	public void Verperfilnoregistrado(basededatos.Usuario_Registrado usuario) {
		_verperfilnoregistrado = new Verperfilnoregistrado(this, usuario);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfilnoregistrado);
	}

	public void Verlistaampliadadeusuariosnoregistrado() {
		_verlistaampliadadeusuariosnoregistrado = new Verlistaampliadadeusuariosnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaampliadadeusuariosnoregistrado);
	}
}