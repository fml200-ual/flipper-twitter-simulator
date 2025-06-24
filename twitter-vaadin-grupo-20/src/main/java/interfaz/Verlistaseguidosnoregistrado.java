package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidosnoregistrado;

public class Verlistaseguidosnoregistrado extends VistaVerlistaseguidosnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;

	public Verlistaseguidosnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;
		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}
	private void Listadeusuarios() {
		_listadeusuarios = new Listadeusuarios(this);
		
		// Cargar seguidos reales del usuario
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado[] seguidos = null;
			
			// Obtener el usuario del perfil que se está viendo
			if (_verperfilnoregistrado != null && _verperfilnoregistrado.u != null) {
				int idUsuario = _verperfilnoregistrado.u.getId_usuario();
				seguidos = bd.cargarSeguidos(idUsuario);
				
				if (seguidos != null && seguidos.length > 0) {
					System.out.println("Cargados " + seguidos.length + " seguidos para el usuario " + idUsuario);
					
					for (basededatos.Usuario_Registrado seguido : seguidos) {
						if (seguido != null) {
							Listadeusuarios_item item = new Listadeusuarios_item(_listadeusuarios, seguido);
							
							// Navegar al perfil del usuario seguido (vista no registrada)
							item.getMainContainer().addClickListener(event -> {
								Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
								Pantalla.MainView.removeAll();
								
								// Crear nueva vista de perfil no registrado para el seguido
								Verperfilnoregistrado nuevoPerfil = new Verperfilnoregistrado(
									_verperfilnoregistrado._listafijadeusuariosnoregistrado, seguido);
								Pantalla.MainView.add(nuevoPerfil);
							});
							
							_listadeusuarios.getMainContainer().as(VerticalLayout.class).add(item);
						}
					}
					
					// Ocultar mensaje de "no hay seguidos"
					this.getNoFollowedMessageNoReg().setVisible(false);
				} else {
					// No hay seguidos - mostrar mensaje
					this.getNoFollowedMessageNoReg().setVisible(true);
					System.out.println("No se encontraron seguidos para el usuario " + idUsuario);
				}
			}
			
		} catch (Exception e) {
			System.err.println("Error al cargar seguidos: " + e.getMessage());
			e.printStackTrace();
			// En caso de error, mostrar mensaje de no hay seguidos
			this.getNoFollowedMessageNoReg().setVisible(true);
		}
		
		this.getFollowedListContainerNoReg().as(VerticalLayout.class).add(_listadeusuarios);
	}

}