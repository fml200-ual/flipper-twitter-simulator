package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaAgrupartweets;

public class Agrupartweets extends VistaAgrupartweets {
	public Verperfil _verperfil;
	public Listadetweetsyretweets _listadetweetsyretweets;

	public Agrupartweets(Verperfil _verperfil) {
		super();
		this._verperfil = _verperfil;

		this.getMoreTweetsButtonContainer().setVisible(false);

		Listadetweetsyretweets();
	}

	public void Listadetweetsyretweets() {
		_listadetweetsyretweets = new Listadetweetsyretweets(this);
		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
}