package interfaz;

public class Verlistaampliadadeusuariosnoregistrado extends Verlistaampliadadeusuarios {
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Verperfilnoregistrado _verperfilnoregistrado;
	public ACT01UsuarioNoRegistrado _usuarioNoRegistrado;
	public Verlistaampliadadeusuariosnoregistrado(ACT01UsuarioNoRegistrado usuarioNoRegistrado) {
		super();
		this._usuarioNoRegistrado = usuarioNoRegistrado;
		// Configurar botón de retroceso
		setupBackButton();
		// Crear lista ampliada de usuarios
		ListadeusuariosAmpliada();
	}
	
	private void setupBackButton() {
		this.getBackButton().addClickListener(event -> goBack());
	}

	private void goBack() {
		// Volver a la vista completa de usuario no registrado
		_usuarioNoRegistrado._mainView.removeAll();
		_usuarioNoRegistrado._mainView.add(_usuarioNoRegistrado);
	}

	private void ListadeusuariosAmpliada() {
		// Crear lista ampliada de usuarios para usuario no registrado
		Listadeusuarios listaUsuarios = new Listadeusuarios((Verlistaampliadadeusuarios) this);
		// Agregar items de usuarios con navegación
		listaUsuarios.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadeusuarios_item(listaUsuarios, _usuarioNoRegistrado));
		listaUsuarios.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadeusuarios_item(listaUsuarios, _usuarioNoRegistrado));
		listaUsuarios.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadeusuarios_item(listaUsuarios, _usuarioNoRegistrado));
		// Agregar al contenedor de la vista
		this.getDiv().add(listaUsuarios);
	}

	public void Verperfilnoregistrado() {
		_verperfilnoregistrado = new Verperfilnoregistrado(_listafijadeusuariosnoregistrado);
		// Navegación simple - usar el MainView del usuario no registrado
		_usuarioNoRegistrado._mainView.removeAll();
		_usuarioNoRegistrado._mainView.add(_verperfilnoregistrado);
	}
}