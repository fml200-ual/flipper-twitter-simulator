package interfaz;

import mds2.MainView.Pantalla;

public class Vercomentarionoregistrado extends Vercomentario {
	public Listadecomentariosnoregistrado_item _listadecomentariosnoregistrado;

	public Vercomentarionoregistrado(Listadecomentariosnoregistrado_item _listadecomentariosnoregistrado) {
		super();
		this._listadecomentariosnoregistrado = _listadecomentariosnoregistrado;

		this.getDeleteCommentButton().setVisible(false);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
		});
	}
}