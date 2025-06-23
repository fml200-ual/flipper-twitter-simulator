package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.Usuario_Registrado;

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
	}	public void ListadeusuariosNR() {
		// Crear la lista - la inicialización automática carga los usuarios de la BD
		Listadeusuarios listaUsuarios = new Listadeusuarios(_verlistaampliadadeusuariosnoregistrado);
		
		// Agregar ClickListener a todos los items para navegar a Verperfilnoregistrado
		for (Listadeusuarios_item item : listaUsuarios._item) {
			item.getMainContainer().addClickListener(event -> {
				// Pasar el usuario específico del item al perfil
				VerperfilnoregistradoConUsuario(item.u);
			});
		}

		this.getMainContainer().as(VerticalLayout.class).add(listaUsuarios);
	}
	
	private void VerperfilnoregistradoConUsuario(Usuario_Registrado usuario) {
		// Método mejorado que puede recibir el usuario específico
		if (usuario != null) {
			System.out.println("Navegando al perfil de: " + usuario.getNickname());
		}
		
		// Navegar a la vista de perfil (por ahora mantener la funcionalidad original)
		Verperfilnoregistrado();
	}

	public void Verperfilnoregistrado() {
		_verperfilnoregistrado = new Verperfilnoregistrado(this);
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