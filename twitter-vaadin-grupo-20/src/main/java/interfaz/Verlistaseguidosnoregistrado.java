package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidosnoregistrado;

public class Verlistaseguidosnoregistrado extends VistaVerlistaseguidosnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;	public Verlistaseguidosnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;
		
		this.getNoFollowedMessageNoReg().setVisible(false);

		// Seguir metodología de diagramas de secuencia
		Cargar_Seguidos();
		// Configurar botón "Mostrar más seguidos"
		this.getShowMoreFollowedButtonNoReg().addClickListener(event -> {
			// Navegar a la lista completa de seguidos del usuario
			Pantalla.MainView.removeAll();
			Verlistaseguidosnoregistrado listaCompleta = new Verlistaseguidosnoregistrado(_verperfilnoregistrado);
			Pantalla.MainView.add(listaCompleta);
		});

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}	/**
	 * Cargar seguidos usando BDPrincipal (maneja sesiones Hibernate correctamente)
	 * Metodología: usar BDPrincipal.cargarSeguidos para evitar LazyInitializationException
	 */
	public void Cargar_Seguidos() {
		try {
			// Obtener el usuario del perfil que se está viendo
			basededatos.Usuario_Registrado usuario = null;
			if (_verperfilnoregistrado != null && _verperfilnoregistrado.u != null) {
				usuario = _verperfilnoregistrado.u;
			}
			
			if (usuario != null) {
				System.out.println("Cargando seguidos para usuario: " + usuario.getNickname() + " (ID: " + usuario.getId_usuario() + ")");
				
				// Usar BDPrincipal que maneja las sesiones de Hibernate correctamente
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				basededatos.Usuario_Registrado[] seguidos = bd.cargarSeguidos(usuario.getId_usuario());
				
				if (seguidos != null && seguidos.length > 0) {
					System.out.println("Seguidos encontrados: " + seguidos.length);
					
					// Crear la lista de usuarios
					_listadeusuarios = new Listadeusuarios(this);
					
					// Crear items para cada usuario seguido
					for (basededatos.Usuario_Registrado seguido : seguidos) {
						if (seguido != null) {
							System.out.println("Creando item para seguido: " + seguido.getNickname());
							
							Listadeusuarios_item item = new Listadeusuarios_item(_listadeusuarios, seguido);
							
							// Configurar navegación al perfil del seguido (vista no registrada)
							item.getMainContainer().addClickListener(event -> {
								Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
								Pantalla.MainView.removeAll();
								
								// Crear nueva vista de perfil no registrado para el seguido
								Verperfilnoregistrado nuevoPerfil = new Verperfilnoregistrado(
									_verperfilnoregistrado._listafijadeusuariosnoregistrado, seguido);
								Pantalla.MainView.add(nuevoPerfil);
							});
							
							// Agregar item a la lista
							_listadeusuarios.getMainContainer().as(VerticalLayout.class).add(item);
						}
					}
					
					// Agregar la lista al contenedor
					this.getFollowedListContainerNoReg().as(VerticalLayout.class).add(_listadeusuarios);
					
					// Ocultar mensaje de "no hay seguidos"
					this.getNoFollowedMessageNoReg().setVisible(false);
					
				} else {
					// No hay seguidos - mostrar mensaje
					this.getNoFollowedMessageNoReg().setVisible(true);
					System.out.println("No se encontraron seguidos para el usuario " + usuario.getNickname());
				}
			} else {
				// Usuario no válido - mostrar mensaje
				this.getNoFollowedMessageNoReg().setVisible(true);
				System.err.println("Usuario no válido para cargar seguidos");
			}
			
		} catch (Exception e) {
			System.err.println("Error al cargar seguidos: " + e.getMessage());
			e.printStackTrace();
			// En caso de error, mostrar mensaje de no hay seguidos
			this.getNoFollowedMessageNoReg().setVisible(true);
		}
	}

}