package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaListadetweetsyretweets;

public class Listadetweetsyretweets extends VistaListadetweetsyretweets {
	public Agrupartweets _agrupartweets;
	public Agrupartweetsgustados _agrupartweetsgustados;
	public Agruparretweets _agruparretweets;
	public Vector<Listadetweetsyretweets_item> _item = new Vector<Listadetweetsyretweets_item>();

	public Listadetweetsyretweets() {
	}

	public Listadetweetsyretweets(Agrupartweets _agrupartweets) {
		super();
		this._agrupartweets = _agrupartweets;

		tweetsRetweets();
	}

	public Listadetweetsyretweets(Agrupartweetsgustados _agrupartweetsgustados) {
		super();
		this._agrupartweetsgustados = _agrupartweetsgustados;

		tweetsRetweets();
	}

	public Listadetweetsyretweets(Agruparretweets _agruparretweets) {
		super();
		this._agruparretweets = _agruparretweets;

		tweetsRetweets();
	}

	public void tweetsRetweets() {
		for (int i = 0; i < 3; i++) {
			this.getMainContainer().as(VerticalLayout.class).add(new Listadetweetsyretweets_item(this));
		}
	}
}