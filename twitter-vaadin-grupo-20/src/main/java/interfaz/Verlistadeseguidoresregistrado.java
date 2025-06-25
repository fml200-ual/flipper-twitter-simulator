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

		// Seguir metodología de diagramas de secuencia
		Cargar_Seguidores();

		// Configurar botón "Mostrar más seguidores"
		this.getShowMoreFollowersButton().addClickListener(event -> {
			// Navegar a la lista completa de seguidores del usuario
			Pantalla.MainView.removeAll();
			Verlistadeseguidoresregistrado listaCompleta = new Verlistadeseguidoresregistrado(_verperfilregistrado);
			Pantalla.MainView.add(listaCompleta);
		});

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilregistrado);		});
	}
	public Verlistadeseguidoresregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;

		this.getNoFollowersMessage().setVisible(false);

		// Seguir metodología de diagramas de secuencia
		Cargar_Seguidores();

		// Configurar botón "Mostrar más seguidores"
		this.getShowMoreFollowersButton().addClickListener(event -> {
			// Navegar a la lista completa de seguidores del usuario actual
			Pantalla.MainView.removeAll();
			Verlistadeseguidoresregistrado listaCompleta = new Verlistadeseguidoresregistrado(_verpropioperfil);
			Pantalla.MainView.add(listaCompleta);
		});

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);		});
	}	/**
	 * Cargar seguidores usando BDPrincipal (maneja sesiones Hibernate correctamente)
	 * Metodología: usar BDPrincipal.cargarSeguidores para evitar LazyInitializationException
	 */
	public void Cargar_Seguidores() {
		try {
			// Determinar el usuario del cual cargar seguidores
			basededatos.Usuario_Registrado usuario = null;
			if (_verperfilregistrado != null && _verperfilregistrado.u != null) {
				// Vista de perfil de otro usuario
				usuario = _verperfilregistrado.u;
			} else if (_verpropioperfil != null) {
				// Vista de propio perfil - usar usuario de la sesión
				usuario = mds2.MainView.obtenerUsuarioActual();
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
							
							// Configurar navegación al perfil del seguidor
							item.getMainContainer().addClickListener(event -> {
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