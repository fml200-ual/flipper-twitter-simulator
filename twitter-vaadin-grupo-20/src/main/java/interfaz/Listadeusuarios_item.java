package interfaz;

import vistas.VistaListadeusuarios_item;

public class Listadeusuarios_item extends VistaListadeusuarios_item{
	// private event _mostrarmsusuarios;
	public Listadeusuarios _listadeusuarios;
	private ACT01UsuarioNoRegistrado _usuarioNoRegistrado; // Referencia directa
	
	public Listadeusuarios_item(Listadeusuarios _listadeusuarios) {
		super();
		this._listadeusuarios = _listadeusuarios;
		
		// Ensamblado dinámico - Click en el usuario para ver perfil
		setupUserClickListener();
	}
	
	// Constructor con referencia directa para usuario no registrado
	public Listadeusuarios_item(Listadeusuarios _listadeusuarios, ACT01UsuarioNoRegistrado usuarioNoRegistrado) {
		super();
		this._listadeusuarios = _listadeusuarios;
		this._usuarioNoRegistrado = usuarioNoRegistrado;
		
		// Ensamblado dinámico - Click en el usuario para ver perfil
		setupUserClickListener();
	}
	
	private void setupUserClickListener() {
		// Click en el contenedor principal para ver el perfil del usuario
		this.getMainContainer().addClickListener(event -> {
			verPerfilUsuario();
		});
	}
	private void verPerfilUsuario() {
		// Usar la referencia directa si está disponible
		ACT01UsuarioNoRegistrado usuarioNoRegistrado = _usuarioNoRegistrado != null ? 
			_usuarioNoRegistrado : findUsuarioNoRegistrado();
			
		if (usuarioNoRegistrado != null) {
			// Crear vista ampliada de usuarios primero si no existe
			Verlistaampliadadeusuariosnoregistrado verListaAmpliada = new Verlistaampliadadeusuariosnoregistrado(usuarioNoRegistrado);
			// Crear perfil usando el constructor correcto
			Verperfilnoregistrado verPerfil = new Verperfilnoregistrado(verListaAmpliada);
			usuarioNoRegistrado._mainView.removeAll();
			usuarioNoRegistrado._mainView.add(verPerfil);
		}
	}
	
	private ACT01UsuarioNoRegistrado findUsuarioNoRegistrado() {
		// Buscar en la jerarquía de componentes - implementación simplificada
		// Este método será un fallback cuando no tengamos referencia directa
		return null; // Por ahora retornamos null, la referencia directa será la principal
	}

	public void Mostrarmsusuarios() {
		verPerfilUsuario();
	}
}