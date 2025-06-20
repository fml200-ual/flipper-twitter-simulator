package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
		setupClickListeners();
	}

	private void setupClickListeners() {
		// Agregar clickListeners para los botones de la lista fija
		// Estos se conectarán con los botones definidos en la vista correspondiente
	}	public void ListadeusuariosNR() {		
		// Crear lista de usuarios items para usuario no registrado
		Listadeusuarios_item item1 = new Listadeusuarios_item(null);
		Listadeusuarios_item item2 = new Listadeusuarios_item(null);
		// Agregar items al layout interno de esta lista fija
		this.getUsersListContainer().as(VerticalLayout.class).add(item1);
		this.getUsersListContainer().as(VerticalLayout.class).add(item2);
	}public void Verperfilnoregistrado() {
		_verperfilnoregistrado = new Verperfilnoregistrado(this);
		// Navegación por MainView - tú arreglas el layout específico
		_aCT01UsuarioNoRegistrado._mainView.removeAll();
		_aCT01UsuarioNoRegistrado._mainView.add(_verperfilnoregistrado);
	}

	public void Verlistaampliadadeusuariosnoregistrado() {
		_verlistaampliadadeusuariosnoregistrado = new Verlistaampliadadeusuariosnoregistrado(_aCT01UsuarioNoRegistrado);
		// Navegación por MainView - tú arreglas el layout específico
		_aCT01UsuarioNoRegistrado._mainView.removeAll();
		_aCT01UsuarioNoRegistrado._mainView.add(_verlistaampliadadeusuariosnoregistrado);
	}
}