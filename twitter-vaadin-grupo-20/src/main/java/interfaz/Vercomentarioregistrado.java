package interfaz;

import mds2.MainView.Pantalla;

public class Vercomentarioregistrado extends Vercomentario {
	// private event _darmegusta;
	// private event _eliminarmegusta;
	public Listadecomentariosregistrado_item _listadecomentariosregistrado;

	public Vercomentarioregistrado(Listadecomentariosregistrado_item _listadecomentariosregistrado) {
		super();
		this._listadecomentariosregistrado = _listadecomentariosregistrado;

		this.getDeleteCommentButton().setVisible(false);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT02UsuarioRegistrado(Pantalla.MainView));
		});
	}

	public void Darmegusta() {
		throw new UnsupportedOperationException();
	}

	public void Eliminarmegusta() {
		throw new UnsupportedOperationException();
	}
}