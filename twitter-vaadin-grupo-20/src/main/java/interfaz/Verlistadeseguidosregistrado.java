package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistadeseguidosregistrado;

public class Verlistadeseguidosregistrado extends VistaVerlistadeseguidosregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;

	public Verlistadeseguidosregistrado(Verperfilregistrado verperfilregistrado) {
		this._verperfilregistrado = verperfilregistrado;

		this.getNoFollowedMessage().setVisible(false);

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilregistrado);
		});
	}

	public Verlistadeseguidosregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;

		this.getNoFollowedMessage().setVisible(false);

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);
		});
	}
	public void Listadeusuarios() {
		_listadeusuarios = new Listadeusuarios(this);
		
		// Cargar seguidos reales del usuario actual
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado[] seguidos = null;
			
			// Determinar el usuario del cual mostrar seguidos
			int idUsuario = -1;
			if (_verperfilregistrado != null && _verperfilregistrado.u != null) {
				// Vista de perfil de otro usuario
				idUsuario = _verperfilregistrado.u.getId_usuario();
			} else if (_verpropioperfil != null) {
				// Vista de propio perfil - usar usuario de la sesión
				if (_verpropioperfil._aCT02UsuarioRegistrado != null && _verpropioperfil._aCT02UsuarioRegistrado.u != null) {
					idUsuario = _verpropioperfil._aCT02UsuarioRegistrado.u.getId_usuario();
				}
			}
			
			if (idUsuario != -1) {
				seguidos = bd.cargarSeguidos(idUsuario);
				
				if (seguidos != null && seguidos.length > 0) {
					System.out.println("Cargados " + seguidos.length + " seguidos para el usuario " + idUsuario);
					
					for (basededatos.Usuario_Registrado seguido : seguidos) {
						if (seguido != null) {
							Listadeusuarios_item item = new Listadeusuarios_item(_listadeusuarios, seguido);
							
							item.getMainContainer().addClickListener(event -> {
								// Navegar al perfil del usuario seguido
								Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
								Pantalla.MainView.removeAll();
								
								if (_verperfilregistrado != null) {
									Verperfilregistrado nuevoPerfil = new Verperfilregistrado(
										_verperfilregistrado._listafijadeusuariosregistrado, seguido);
									Pantalla.MainView.add(nuevoPerfil);
								} else {
									Verperfilregistrado nuevoPerfil = new Verperfilregistrado(
										_verpropioperfil._aCT02UsuarioRegistrado._listafijadeusuariosregistrado, seguido);
									Pantalla.MainView.add(nuevoPerfil);
								}
							});
							
							_listadeusuarios.getMainContainer().as(VerticalLayout.class).add(item);
						}
					}
					
					// Ocultar el mensaje de "no hay seguidos"
					this.getNoFollowedMessage().setVisible(false);
				} else {
					// No hay seguidos - mostrar mensaje
					this.getNoFollowedMessage().setVisible(true);
					System.out.println("No se encontraron seguidos para el usuario " + idUsuario);
				}
			}
			
		} catch (Exception e) {
			System.err.println("Error al cargar seguidos: " + e.getMessage());
			e.printStackTrace();
			// En caso de error, mostrar mensaje de no hay seguidos
			this.getNoFollowedMessage().setVisible(true);
		}
		
		this.getFollowedListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}