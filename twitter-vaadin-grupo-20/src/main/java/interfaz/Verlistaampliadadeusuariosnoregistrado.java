package interfaz;

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
		// Crear lista ampliada de usuarios para usuario no registrado
		Listadeusuarios listaUsuarios = new Listadeusuarios(this);

		for (int i = 0; i < 5; i++) {
			Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios);
			// Agregar ClickListener personalizado para navegar a Verperfilnoregistrado
			item.getMainContainer().addClickListener(event -> {
				Verperfilnoregistrado();
			});
			listaUsuarios.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
					.add(item);
		}
		this.getUsersContainer().add(listaUsuarios);
	}

	public void Verperfilnoregistrado() {
		_verperfilnoregistrado = new Verperfilnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfilnoregistrado);
	}
}