package interfaz;

import mds2.MainView.Pantalla;

public class Verlistaampliadadeusuariosregistrado extends Verlistaampliadadeusuarios {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Perspectivabloqueado _perspectivabloqueado;
	public Verperfilregistrado _verperfilregistrado;

	public Verlistaampliadadeusuariosregistrado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado) {
		super();
		this._listafijadeusuariosregistrado = _listafijadeusuariosregistrado;
		// Configurar botón de retroceso
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadeusuariosregistrado._aCT02UsuarioRegistrado);
		});
		// Crear lista ampliada de usuarios
		Listadeusuarios();
	}

	@Override
	public void Listadeusuarios() {
		// Crear lista ampliada de usuarios para usuario no registrado
		Listadeusuarios listaUsuarios = new Listadeusuarios(this);

		for (int i = 0; i < 50; i++) {
			Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, null);
			// Agregar ClickListener personalizado para navegar a Verperfilnoregistrado
			item.getMainContainer().addClickListener(event -> {
				// Verperfilregistrado o Perspectivabloqueado
				Verperfilregistrado();
			});
			listaUsuarios.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
					.add(item);
		}
		this.getUsersContainer().add(listaUsuarios);
	}

	public void Perspectivabloqueado() {
		_perspectivabloqueado = new Perspectivabloqueado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_perspectivabloqueado);
	}

	public void Verperfilregistrado() {
		_verperfilregistrado = new Verperfilregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfilregistrado);
	}
}