package interfaz;

import com.vaadin.flow.component.html.Image;
import vistas.VistaListadecomentarios_item;

public class Listadecomentarios_item extends VistaListadecomentarios_item {
	// private event _mostrarmscomentarios;
	public Listadecomentarios _listadecomentarios;
	
	// Objeto ORMPersistable para el comentario
	public basededatos.Comentario c;

	public Listadecomentarios_item(Listadecomentarios _listadecomentarios) {
		super();
		this._listadecomentarios = _listadecomentarios;
	}
	
	// Constructor que acepta Comentario
	public Listadecomentarios_item(Listadecomentarios _listadecomentarios, basededatos.Comentario c) {
		super();
		this._listadecomentarios = _listadecomentarios;
		this.c = c;
		
		// Rellenar datos del comentario en los componentes gráficos
		if (c != null) {
			rellenarDatosComentario();
		}
	}
		private void rellenarDatosComentario() {
		// Rellenar contenido del comentario
		if (c.getContenidoComentario() != null) {
			this.getLabel_comentarioTexto().setText(c.getContenidoComentario());
		}
		
		// Rellenar información del usuario que comentó
		if (c.getPublicado_por() != null) {
			basededatos.Usuario_Registrado usuario = c.getPublicado_por();
			
			if (usuario.getNickname() != null) {
				this.getH4_nickUsuario().setText(usuario.getNickname());
				this.getLabel_username().setText("@" + usuario.getNickname());
			}
			
			// Agregar foto de perfil si está disponible
			if (usuario.getFotoPerfilURL() != null && !usuario.getFotoPerfilURL().trim().isEmpty()) {
				try {
					Image img = new Image(usuario.getFotoPerfilURL(), "Foto de perfil");
					img.setWidth("32px");
					img.setHeight("32px");
					img.getStyle().set("border-radius", "50%");
					
					// Reemplazar el icono con la imagen
					this.getIronIcon_avatarUsuario().getParent().ifPresent(parent -> {
						parent.getElement().removeChild(this.getIronIcon_avatarUsuario().getElement());
						parent.getElement().appendChild(img.getElement());
					});
				} catch (Exception e) {
					System.err.println("Error cargando imagen de perfil del comentario: " + e.getMessage());
				}
			}
		}
		
		// Rellenar fecha de publicación
		if (c.getFechaPublicacion() != null) {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMM yyyy");
			this.getLabel_fechaComentario().setText(sdf.format(c.getFechaPublicacion()));
		}
				// ✅ MEJORA: Reemplazar "Y" por número real de me gusta
		configurarContadorMeGusta();
		
		// ✅ MEJORA: Configurar funcionalidad de me gusta interactiva
		configurarEventoMeGusta();
				// TODO: Configurar click listener cuando esté disponible el componente adecuado
		// this.getvL_listacomentarios_mainContainer().addClickListener(event -> Mostrarmscomentarios());
	}
		/**
	 * Configura el avatar con el número real de me gusta en lugar de "Y"
	 */
	private void configurarContadorMeGusta() {
		try {
			if (c != null && this.getAvatar() != null) {
				// Obtener el número de me gusta del comentario contando la colección
				int numMeGusta = 0;
				if (c.recibe_me_gusta != null) {
					numMeGusta = c.recibe_me_gusta.size();
				}
				
				// Configurar el avatar con el número real en lugar de "Y"
				// Usar setAbbreviation en lugar de setAbbr
				this.getAvatar().setAbbreviation(String.valueOf(numMeGusta));
				
				// Configurar estilo para que sea más visible
				this.getAvatar().getStyle().set("background-color", "#1DA1F2");
				this.getAvatar().getStyle().set("color", "white");
				this.getAvatar().getStyle().set("font-weight", "bold");
				this.getAvatar().getStyle().set("font-size", "12px");
				
				System.out.println("Configurado contador de me gusta: " + numMeGusta + 
								 " para comentario de " + c.getPublicado_por().getNickname());
			}
		} catch (Exception e) {
			System.err.println("Error configurando contador de me gusta: " + e.getMessage());
			// Fallback: mostrar 0 en lugar de "Y"
			if (this.getAvatar() != null) {
				try {
					this.getAvatar().setAbbreviation("0");
				} catch (Exception e2) {
					System.err.println("Error en fallback de avatar: " + e2.getMessage());
				}
			}
		}
	}

	/**
	 * Configura eventos de me gusta para comentarios
	 */
	private void configurarEventoMeGusta() {
		try {
			if (this.getIronIcon_meGusta() != null) {
				this.getIronIcon_meGusta().addClickListener(event -> {
					toggleMeGustaComentario();
				});
				
				// Agregar estilo hover para indicar que es clickeable
				this.getIronIcon_meGusta().getStyle().set("cursor", "pointer");
				this.getIronIcon_meGusta().getStyle().set("color", "#999");
				
				// Verificar si el usuario actual ya le dio me gusta
				verificarEstadoMeGusta();
			}
		} catch (Exception e) {
			System.err.println("Error configurando evento de me gusta: " + e.getMessage());
		}
	}
	
	/**
	 * Verifica si el usuario actual ya le dio me gusta a este comentario
	 */
	private void verificarEstadoMeGusta() {
		try {
			basededatos.Usuario_Registrado usuarioActual = mds2.MainView.obtenerUsuarioActual();
			if (usuarioActual != null && c != null && c.recibe_me_gusta != null) {
				// Verificar si el usuario actual está en la colección de me gusta
				boolean yaLeDioMeGusta = false;
				for (Object usuario : c.recibe_me_gusta.toArray()) {
					if (usuario instanceof basededatos.Usuario_Registrado) {
						basededatos.Usuario_Registrado u = (basededatos.Usuario_Registrado) usuario;
						if (u.getId_usuario() == usuarioActual.getId_usuario()) {
							yaLeDioMeGusta = true;
							break;
						}
					}
				}
				
				// Cambiar color del icono según el estado
				if (yaLeDioMeGusta) {
					this.getIronIcon_meGusta().getStyle().set("color", "#ff6b6b"); // Rojo si ya le dio me gusta
				} else {
					this.getIronIcon_meGusta().getStyle().set("color", "#999"); // Gris si no le ha dado me gusta
				}
			}
		} catch (Exception e) {
			System.err.println("Error verificando estado de me gusta: " + e.getMessage());
		}
	}
	
	/**
	 * Toggle me gusta en comentario
	 */
	private void toggleMeGustaComentario() {
		try {
			basededatos.Usuario_Registrado usuarioActual = mds2.MainView.obtenerUsuarioActual();
			
			if (usuarioActual == null) {
				System.err.println("Usuario no logueado - no puede dar me gusta");
				return;
			}
			
			if (c == null) {
				System.err.println("Comentario nulo - no se puede dar me gusta");
				return;
			}
			
			// Verificar estado actual
			boolean yaLeDioMeGusta = false;
			if (c.recibe_me_gusta != null) {
				for (Object usuario : c.recibe_me_gusta.toArray()) {
					if (usuario instanceof basededatos.Usuario_Registrado) {
						basededatos.Usuario_Registrado u = (basededatos.Usuario_Registrado) usuario;
						if (u.getId_usuario() == usuarioActual.getId_usuario()) {
							yaLeDioMeGusta = true;
							break;
						}
					}
				}
			}
			
			// Usar BDPrincipal para manejar me gusta
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
					if (yaLeDioMeGusta) {
				// Quitar me gusta
				bd.eliminarMgComentario(usuarioActual.getId_usuario(), c.getORMID());
				c.recibe_me_gusta.remove(usuarioActual);
				System.out.println("Me gusta eliminado del comentario");
			} else {
				// Dar me gusta
				bd.darMeGustaComentario(usuarioActual.getId_usuario(), c.getORMID());
				c.recibe_me_gusta.add(usuarioActual);
				System.out.println("Me gusta agregado al comentario");
			}
			
			// Actualizar UI
			configurarContadorMeGusta();
			verificarEstadoMeGusta();
			
		} catch (Exception e) {
			System.err.println("Error en toggle me gusta comentario: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Mostrarmscomentarios() {
		// TODO: Implementar navegación a vista detallada del comentario
		throw new UnsupportedOperationException();
	}
}