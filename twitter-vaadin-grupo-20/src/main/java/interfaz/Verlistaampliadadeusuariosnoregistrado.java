package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Verlistaampliadadeusuariosnoregistrado extends Verlistaampliadadeusuarios {
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Verperfilnoregistrado _verperfilnoregistrado;

	public Verlistaampliadadeusuariosnoregistrado(Listafijadeusuariosnoregistrado listafijadeusuariosnoregistrado) {
		super();
		this._listafijadeusuariosnoregistrado = listafijadeusuariosnoregistrado;
		// Configurar botón de retroceso
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado);
		});
		// Crear lista ampliada de usuarios
		Listadeusuarios();
	}

	@Override
	public void Listadeusuarios() {
		basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
		basededatos.Usuario_Registrado[] usuarios = bd.cargarUsuarios();
		// Crear lista ampliada de usuarios para usuario no registrado
		Listadeusuarios listaUsuarios = new Listadeusuarios(this);

		for (int i = 0; i < usuarios.length; i++) {
			basededatos.Usuario_Registrado usuario = usuarios[i];
			Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, usuario);

			item.getMainContainer().addClickListener(event -> {
				Verperfilnoregistrado(usuario);
			});
			listaUsuarios.getMainContainer().as(VerticalLayout.class).add(item);
		}
		this.getUsersContainer().add(listaUsuarios);
	}

	public void Verperfilnoregistrado(basededatos.Usuario_Registrado usuario) {
		_verperfilnoregistrado = new Verperfilnoregistrado(this, usuario);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfilnoregistrado);
	}
}