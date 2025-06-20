package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Listafijadehashtagsnoregistrado extends Listafijadehashtags {
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Verhashtagnoregistrado _verhashtagnoregistrado;
	public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;

	public Listafijadehashtagsnoregistrado(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		// Ensamblado de componentes fijos
		ListadehashtagsNR();
		// Ensamblado dinámico - ClickListeners
		setupClickListeners();
	}

	private void setupClickListeners() {
		// Setup clickListeners para hashtags
	}	public void ListadehashtagsNR() {
		// Crear lista de hashtags items
		Listadehashtags_item item1 = new Listadehashtags_item(null);
		Listadehashtags_item item2 = new Listadehashtags_item(null);
		// Agregar items al layout interno de esta lista fija
		this.getHashtagsListContainer().as(VerticalLayout.class).add(item1);
		this.getHashtagsListContainer().as(VerticalLayout.class).add(item2);
	}	public void Verhashtagnoregistrado() {
		_verhashtagnoregistrado = new Verhashtagnoregistrado(this, _aCT01UsuarioNoRegistrado);
		// Navegación por MainView - tú arreglas el layout específico
		_aCT01UsuarioNoRegistrado._mainView.removeAll();
		_aCT01UsuarioNoRegistrado._mainView.add(_verhashtagnoregistrado);
	}

	public void Verlistaampliadadehashtagsnoregistrado() {
		// Constructor temporal comentado hasta resolver dependencias
		// _verlistaampliadadehashtagsnoregistrado = new Verlistaampliadadehashtagsnoregistrado(_aCT01UsuarioNoRegistrado);
		// Navegación por MainView - tú arreglas el layout específico
		// _aCT01UsuarioNoRegistrado._mainView.removeAll();
		// _aCT01UsuarioNoRegistrado._mainView.add(_verlistaampliadadehashtagsnoregistrado);
	}
}