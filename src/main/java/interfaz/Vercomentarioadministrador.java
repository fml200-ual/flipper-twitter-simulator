package interfaz;

public class Vercomentarioadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador_item _listadecomentariosadministrador;

	public Vercomentarioadministrador(Listadecomentariosadministrador_item _listadecomentariosadministrador) {
		super();
		this._listadecomentariosadministrador = _listadecomentariosadministrador;
		this.getBotonAccionY().setVisible(false);
		this.getBotonAccionComentario().setVisible(false);
		this.getBotonEliminarInferior().setText("Eliminar comentario");
		this.getPublicacionCitadaContenedor().setVisible(false);
	}

}