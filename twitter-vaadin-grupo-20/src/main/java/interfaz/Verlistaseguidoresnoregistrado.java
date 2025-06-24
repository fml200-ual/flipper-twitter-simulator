package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidoresnoregistrado;

public class Verlistaseguidoresnoregistrado extends VistaVerlistaseguidoresnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;

	public Verlistaseguidoresnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}
	public void Listadeusuarios() {
		// Crear lista de usuarios seguidores para usuario no registrado
		_listadeusuarios = new Listadeusuarios(this);

		// Cargar seguidores reales del usuario
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado[] seguidores = null;
			
			// Obtener el usuario del perfil que se está viendo
			if (_verperfilnoregistrado != null && _verperfilnoregistrado.u != null) {
				int idUsuario = _verperfilnoregistrado.u.getId_usuario();
				seguidores = bd.cargarSeguidores(idUsuario);
				
				if (seguidores != null && seguidores.length > 0) {
					System.out.println("Cargados " + seguidores.length + " seguidores para el usuario " + idUsuario);
					
					for (basededatos.Usuario_Registrado seguidor : seguidores) {
						if (seguidor != null) {
							Listadeusuarios_item item = new Listadeusuarios_item(_listadeusuarios, seguidor);
									// Navegar al perfil del seguidor (vista no registrada)
							item.getMainContainer().addClickListener(event -> {
								Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
								Pantalla.MainView.removeAll();
								
								// Crear nueva vista de perfil no registrado para el seguidor
								Verperfilnoregistrado nuevoPerfil = new Verperfilnoregistrado(
									_verperfilnoregistrado._listafijadeusuariosnoregistrado, seguidor);
								Pantalla.MainView.add(nuevoPerfil);
							});
							
							_listadeusuarios.getMainContainer().as(VerticalLayout.class).add(item);
						}
					}
					
					// Ocultar mensaje de "no hay seguidores"
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

		// Agregar la lista al contenedor de seguidores de la vista
		this.getFollowersListContainer().as(VerticalLayout.class)
				.add(_listadeusuarios);
	}

}