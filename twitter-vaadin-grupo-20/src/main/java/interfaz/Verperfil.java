package interfaz;

import vistas.VistaVerperfil;

public class Verperfil extends VistaVerperfil {
	public Agrupartweets _agrupartweets;
	public Agrupartweetsgustados _agrupartweetsgustados;
	public Agruparretweets _agruparretweets;

	public void Agrupartweets(basededatos.Usuario_Registrado o) {
		_agrupartweets = new Agrupartweets(this, o);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agrupartweets);
	}

	public void Agrupartweetsgustados(basededatos.Usuario_Registrado o) {
		_agrupartweetsgustados = new Agrupartweetsgustados(this, o);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agrupartweetsgustados);
	}

	public void Agruparretweets(basededatos.Usuario_Registrado o) {
		_agruparretweets = new Agruparretweets(this, o);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agruparretweets);
	}

}