package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidoresnoregistrado;

public class Verlistaseguidoresnoregistrado extends VistaVerlistaseguidoresnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;	public Verlistaseguidoresnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;

		this.getNoFollowersMessage().setVisible(false);

		// Seguir metodología de diagramas de secuencia
		Cargar_Seguidores();

		// Configurar botón "Mostrar más seguidores"
		this.getShowMoreFollowersButton().addClickListener(event -> {
			// Navegar a la lista completa de seguidores del usuario
			Pantalla.MainView.removeAll();
			Verlistaseguidoresnoregistrado listaCompleta = new Verlistaseguidoresnoregistrado(_verperfilnoregistrado);
			Pantalla.MainView.add(listaCompleta);
		});

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}	/**
	 * Cargar seguidores usando BDPrincipal (maneja sesiones Hibernate correctamente)
	 * Metodología: usar BDPrincipal.cargarSeguidores para evitar LazyInitializationException
	 */
	public void Cargar_Seguidores() {
		try {
			// Obtener el usuario del perfil que se está viendo
			basededatos.Usuario_Registrado usuario = null;
			if (_verperfilnoregistrado != null && _verperfilnoregistrado.u != null) {
				usuario = _verperfilnoregistrado.u;
			}
			
			if (usuario != null) {
				System.out.println("Cargando seguidores para usuario: " + usuario.getNickname() + " (ID: " + usuario.getId_usuario() + ")");
				
				// Usar BDPrincipal que maneja las sesiones de Hibernate correctamente
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				basededatos.Usuario_Registrado[] seguidores = bd.cargarSeguidores(usuario.getId_usuario());
				
				if (seguidores != null && seguidores.length > 0) {
					System.out.println("Seguidores encontrados: " + seguidores.length);
					
					// Crear la lista de usuarios
					_listadeusuarios = new Listadeusuarios(this);
					
					// Crear items para cada seguidor
					for (basededatos.Usuario_Registrado seguidor : seguidores) {
						if (seguidor != null) {
							System.out.println("Creando item para seguidor: " + seguidor.getNickname());
							
							Listadeusuarios_item item = new Listadeusuarios_item(_listadeusuarios, seguidor);
							
							// Configurar navegación al perfil del seguidor (vista no registrada)
							item.getMainContainer().addClickListener(event -> {
								Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
								Pantalla.MainView.removeAll();
								
								// Crear nueva vista de perfil no registrado para el seguidor
								Verperfilnoregistrado nuevoPerfil = new Verperfilnoregistrado(
									_verperfilnoregistrado._listafijadeusuariosnoregistrado, seguidor);
								Pantalla.MainView.add(nuevoPerfil);
							});
							
							// Agregar item a la lista
							_listadeusuarios.getMainContainer().as(VerticalLayout.class).add(item);
						}
					}
					
					// Agregar la lista al contenedor
					this.getFollowersListContainer().as(VerticalLayout.class).add(_listadeusuarios);
					
					// Ocultar mensaje de "no hay seguidores"
					this.getNoFollowersMessage().setVisible(false);
					
				} else {
					// No hay seguidores - mostrar mensaje
					this.getNoFollowersMessage().setVisible(true);
					System.out.println("No se encontraron seguidores para el usuario " + usuario.getNickname());
				}
			} else {
				// Usuario no válido - mostrar mensaje
				this.getNoFollowersMessage().setVisible(true);
				System.err.println("Usuario no válido para cargar seguidores");
			}
			
		} catch (Exception e) {
			System.err.println("Error al cargar seguidores: " + e.getMessage());
			e.printStackTrace();
			// En caso de error, mostrar mensaje de no hay seguidores
			this.getNoFollowersMessage().setVisible(true);
		}
	}

}