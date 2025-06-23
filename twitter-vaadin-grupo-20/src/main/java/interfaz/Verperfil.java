package interfaz;

import vistas.VistaVerperfil;

public class Verperfil extends VistaVerperfil {
	public Agrupartweets _agrupartweets;
	public Agrupartweetsgustados _agrupartweetsgustados;
	public Agruparretweets _agruparretweets;
	
	// Método para obtener el usuario del perfil desde las clases derivadas
	public basededatos.Usuario_Registrado getUsuarioPerfil() {
		// Este método será sobrescrito en las clases derivadas
		return null;
	}

	public void Agrupartweets() {
		_agrupartweets = new Agrupartweets(this);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agrupartweets);
	}

	public void Agrupartweetsgustados() {
		_agrupartweetsgustados = new Agrupartweetsgustados(this);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agrupartweetsgustados);
	}

	public void Agruparretweets() {
		_agruparretweets = new Agruparretweets(this);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agruparretweets);
	}

}