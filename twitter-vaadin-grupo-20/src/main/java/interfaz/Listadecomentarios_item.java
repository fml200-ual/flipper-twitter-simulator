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
				// TODO: Configurar click listener cuando esté disponible el componente adecuado
		// this.getvL_listacomentarios_mainContainer().addClickListener(event -> Mostrarmscomentarios());
	}

	public void Mostrarmscomentarios() {
		// TODO: Implementar navegación a vista detallada del comentario
		throw new UnsupportedOperationException();
	}
}