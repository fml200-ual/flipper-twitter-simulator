package interfaz;

import java.util.Vector;

import vistas.VistaListadetweetsyretweets;

public class Listadetweetsyretweets extends VistaListadetweetsyretweets {
	public Agrupartweets _agrupartweets;
	public Agrupartweetsgustados _agrupartweetsgustados;
	public Agruparretweets _agruparretweets;
	public Vector<Listadetweetsyretweets_item> _item = new Vector<Listadetweetsyretweets_item>();

	public Listadetweetsyretweets(Agrupartweets _agrupartweets) {
		super();
		this._agrupartweets = _agrupartweets;
	}

	public Listadetweetsyretweets(Agrupartweetsgustados _agrupartweetsgustados) {
		super();
		this._agrupartweetsgustados = _agrupartweetsgustados;
	}

	public Listadetweetsyretweets(Agruparretweets _agruparretweets) {
		super();
		this._agruparretweets = _agruparretweets;
	}
}