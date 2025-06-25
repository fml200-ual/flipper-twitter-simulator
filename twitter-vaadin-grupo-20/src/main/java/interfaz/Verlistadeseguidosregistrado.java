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

		// Seguir metodología de diagramas de secuencia
		Cargar_Seguidos();

		// Configurar botón "Mostrar más seguidos"
		this.getShowMoreFollowedButton().addClickListener(event -> {
			// Navegar a la lista completa de seguidos del usuario
			Pantalla.MainView.removeAll();
			Verlistadeseguidosregistrado listaCompleta = new Verlistadeseguidosregistrado(_verperfilregistrado);
			Pantalla.MainView.add(listaCompleta);
		});

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilregistrado);		});
	}
	public Verlistadeseguidosregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;

		this.getNoFollowedMessage().setVisible(false);

		// Seguir metodología de diagramas de secuencia
		Cargar_Seguidos();

		// Configurar botón "Mostrar más seguidos"
		this.getShowMoreFollowedButton().addClickListener(event -> {
			// Navegar a la lista completa de seguidos del usuario actual
			Pantalla.MainView.removeAll();
			Verlistadeseguidosregistrado listaCompleta = new Verlistadeseguidosregistrado(_verpropioperfil);
			Pantalla.MainView.add(listaCompleta);
		});

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);		});
	}
	/**
	 * Cargar seguidos usando BDPrincipal (maneja sesiones Hibernate correctamente)
	 * Metodología: usar BDPrincipal.cargarSeguidos para evitar LazyInitializationException
	 */
	public void Cargar_Seguidos() {
		try {
			// Determinar el usuario del cual cargar seguidos
			basededatos.Usuario_Registrado usuario = null;
			if (_verperfilregistrado != null && _verperfilregistrado.u != null) {
				// Vista de perfil de otro usuario
				usuario = _verperfilregistrado.u;
			} else if (_verpropioperfil != null) {
				// Vista de propio perfil - usar usuario de la sesión
				usuario = mds2.MainView.obtenerUsuarioActual();
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
							
							// Configurar navegación al perfil del seguido
							item.getMainContainer().addClickListener(event -> {
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
							
							// Agregar item a la lista
							_listadeusuarios.getMainContainer().as(VerticalLayout.class).add(item);
						}
					}
					
					// Agregar la lista al contenedor
					this.getFollowedListContainer().as(VerticalLayout.class).add(_listadeusuarios);
					
					// Ocultar mensaje de "no hay seguidos"
					this.getNoFollowedMessage().setVisible(false);
					
				} else {
					// No hay seguidos - mostrar mensaje
					this.getNoFollowedMessage().setVisible(true);
					System.out.println("No se encontraron seguidos para el usuario " + usuario.getNickname());
				}
			} else {
				// Usuario no válido - mostrar mensaje
				this.getNoFollowedMessage().setVisible(true);
				System.err.println("Usuario no válido para cargar seguidos");
			}
			
		} catch (Exception e) {
			System.err.println("Error al cargar seguidos: " + e.getMessage());
			e.printStackTrace();
			// En caso de error, mostrar mensaje de no hay seguidos
			this.getNoFollowedMessage().setVisible(true);
		}
	}
}