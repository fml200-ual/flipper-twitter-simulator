package interfaz;


public class Vercomentarioadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador_item _listadecomentariosadministrador;

	public Vercomentarioadministrador(Listadecomentariosadministrador_item _listadecomentariosadministrador) {
		super();
		this._listadecomentariosadministrador = _listadecomentariosadministrador;

		this.getSpanContadorRetweet().setVisible(false);
		this.getIconoRetweet().setVisible(false);
		this.getSpanContadorComentarios().setVisible(false);
		this.getIconoComentar().setVisible(false);
		this.getLayoutPublicacionCitada().setVisible(false);
		this.getLinkMostrarMas().setVisible(false);
		this.getBotonEliminarTweet().setText("Eliminar comentario");

		// Añadir botón de regreso
		volver();
	}

}