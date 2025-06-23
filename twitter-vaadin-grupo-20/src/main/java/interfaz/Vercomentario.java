package interfaz;

import vistas.VistaVercomentario;

public class Vercomentario extends VistaVercomentario {
	
	// Objeto ORMPersistable para el comentario que se muestra
	public basededatos.Comentario c;

	public Vercomentario(basededatos.Comentario c) {
		super();
		this.c = c;
		
		// Rellenar datos del comentario
		rellenarDatosComentario();
	}
	
	// Constructor de compatibilidad temporal
	public Vercomentario() {
		this(null);
	}
	
	private void rellenarDatosComentario() {
		if (c != null) {
			// Rellenar contenido del comentario
			if (c.getContenidoComentario() != null) {
				// this.getCommentText().setText(c.getContenidoComentario());
			}
			
			// Rellenar datos del usuario
			if (c.getPublicado_por() != null) {
				// this.getUsername().setText(c.getPublicado_por().getNombre());
				// this.getUserHandle().setText("@" + c.getPublicado_por().getNickname());
			}
			
			// Rellenar fecha
			if (c.getFechaPublicacion() != null) {
				// this.getCommentDate().setText(c.getFechaPublicacion().toString());
			}
			
			// Rellenar contadores de me gusta
			// this.getCommentLikeCount().setText("" + c.recibe_me_gusta.size());
		}
	}
}