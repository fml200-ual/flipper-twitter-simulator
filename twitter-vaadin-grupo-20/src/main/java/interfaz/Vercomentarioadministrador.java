package interfaz;

import basededatos.Comentario;

public class Vercomentarioadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador_item _listadecomentariosadministrador;

	public Vercomentarioadministrador(Listadecomentariosadministrador_item _listadecomentariosadministrador,
			Comentario c) {
		super();
		this._listadecomentariosadministrador = _listadecomentariosadministrador;

		// Rellenar los datos del comentario
		rellenarDatosComentario(c);
		volver();

		this.getSpanContadorRetweet().setVisible(false);
		this.getIconoRetweet().setVisible(false);
		this.getSpanContadorComentarios().setVisible(false);
		this.getIconoComentar().setVisible(false);
		this.getLayoutPublicacionCitada().setVisible(false);
		this.getLinkMostrarMas().setVisible(false);
		this.getBotonEliminarTweet().setText("Eliminar comentario");

		this.getBotonEliminarTweet().addClickListener(event -> {
			this.Eliminarpublicacin(c);
		});
	}

	private void rellenarDatosComentario(Comentario c) {
		if (c == null)
			return;

		try {
			// Obtener datos del usuario que publicó el comentario
			basededatos.Usuario_Registrado usuario = c.getPublicado_por();
			if (usuario != null) {
				// Establecer nombre y handle del usuario
				this.getSpanNombreUsuario().setText(usuario.getNickname());
				this.getSpanHandleUsuario().setText("@" + usuario.getNickname());
			}

			// Establecer contenido del comentario
			String contenido = c.getContenidoComentario() != null ? c.getContenidoComentario() : "";
			this.getPTextoPublicacion().setText(contenido);

			// Establecer fecha de publicación
			if (c.getFechaPublicacion() != null) {
				this.getSpanFecha().setText(c.getFechaPublicacion().toString());
			}

			// Contar likes (me gusta) del comentario
			int likesCount = c.recibe_me_gusta != null ? c.recibe_me_gusta.size() : 0;
			this.getSpanContadorMeGusta().setText(String.valueOf(likesCount));

		} catch (Exception e) {
			// En caso de error, mostrar información básica
			this.getPTextoPublicacion().setText("Error al cargar comentario");
			this.getSpanNombreUsuario().setText("Usuario desconocido");
			this.getSpanHandleUsuario().setText("@desconocido");
		}
	}

}