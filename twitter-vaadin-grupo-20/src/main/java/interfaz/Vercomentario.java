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
				this.getCommentText().setText(c.getContenidoComentario());
			}
			
			// Rellenar datos del usuario
			if (c.getPublicado_por() != null) {
				this.getCommenterUsername().setText(c.getPublicado_por().getNickname());
				this.getCommenterHandle().setText("@" + c.getPublicado_por().getNickname());
			}
			
			// Rellenar fecha
			if (c.getFechaPublicacion() != null) {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMM yyyy");
				this.getCommentDate().setText(sdf.format(c.getFechaPublicacion()));
			}
					// Rellenar contadores de me gusta usando BD para evitar LazyInitializationException
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			int likesCount = bd.contarLikesComentario(c.getORMID());
			this.getCommentLikeCount().setText("" + likesCount);
		} catch (Exception e) {
			System.err.println("Error obteniendo likes del comentario: " + e.getMessage());
			this.getCommentLikeCount().setText("0");
		}
		}
	}
}