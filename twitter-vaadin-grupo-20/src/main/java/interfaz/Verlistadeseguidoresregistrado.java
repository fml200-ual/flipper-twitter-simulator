package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistadeseguidoresregistrado;

public class Verlistadeseguidoresregistrado extends VistaVerlistadeseguidoresregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;

	public Verlistadeseguidoresregistrado(Verperfilregistrado verperfilregistrado) {
		this._verperfilregistrado = verperfilregistrado;

		this.getNoFollowersMessage().setVisible(false);

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilregistrado);
		});
	}

	public Verlistadeseguidoresregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;

		this.getNoFollowersMessage().setVisible(false);

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);
		});
	}	public void Listadeusuarios() {
		_listadeusuarios = new Listadeusuarios(this);
		
		// Cargar seguidores reales del usuario actual
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado[] seguidores = null;
			
			// Determinar el usuario del cual mostrar seguidores
			int idUsuario = -1;
			if (_verperfilregistrado != null && _verperfilregistrado.u != null) {
				// Vista de perfil de otro usuario
				idUsuario = _verperfilregistrado.u.getId_usuario();			} else if (_verpropioperfil != null) {
				// Vista de propio perfil - usar usuario de la sesión
				if (_verpropioperfil._aCT02UsuarioRegistrado != null && _verpropioperfil._aCT02UsuarioRegistrado.u != null) {
					idUsuario = _verpropioperfil._aCT02UsuarioRegistrado.u.getId_usuario();
				}
			}
			
			if (idUsuario != -1) {
				seguidores = bd.cargarSeguidores(idUsuario);
				
				if (seguidores != null && seguidores.length > 0) {
					System.out.println("Cargados " + seguidores.length + " seguidores para el usuario " + idUsuario);
					
					for (basededatos.Usuario_Registrado seguidor : seguidores) {
						if (seguidor != null) {
							Listadeusuarios_item item = new Listadeusuarios_item(_listadeusuarios, seguidor);
							
							item.getMainContainer().addClickListener(event -> {
								// Navegar al perfil del seguidor
								Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
								Pantalla.MainView.removeAll();
								
								if (_verperfilregistrado != null) {
									Verperfilregistrado nuevoPerfil = new Verperfilregistrado(
										_verperfilregistrado._listafijadeusuariosregistrado, seguidor);
									Pantalla.MainView.add(nuevoPerfil);
								} else {
									Verperfilregistrado nuevoPerfil = new Verperfilregistrado(
										_verpropioperfil._aCT02UsuarioRegistrado._listafijadeusuariosregistrado, seguidor);
									Pantalla.MainView.add(nuevoPerfil);
								}
							});
							
							_listadeusuarios.getMainContainer().as(VerticalLayout.class).add(item);
						}
					}
					
					// Ocultar el mensaje de "no hay seguidores"
					this.getNoFollowersMessage().setVisible(false);
				} else {
					// No hay seguidores - mostrar mensaje
					this.getNoFollowersMessage().setVisible(true);
					System.out.println("No se encontraron seguidores para el usuario " + idUsuario);
				}
			}
			
		} catch (Exception e) {
			System.err.println("Error al cargar seguidores: " + e.getMessage());
			e.printStackTrace();
			// En caso de error, mostrar mensaje de no hay seguidores
			this.getNoFollowersMessage().setVisible(true);
		}
		
		this.getFollowersListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}