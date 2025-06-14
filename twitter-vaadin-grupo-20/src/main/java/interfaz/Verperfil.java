package interfaz;

import com.vaadin.flow.component.button.Button;

import mds2.MainView.Pantalla;
import vistas.VistaVerperfil;

public class Verperfil extends VistaVerperfil {
	public Agrupartweets _agrupartweets;
	public Agrupartweetsgustados _agrupartweetsgustados;
	public Agruparretweets _agruparretweets;

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

	protected void addBackButton() {
		Button backButton = new Button("← Volver", event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(Pantalla.Anterior);
		});
		this.getProfileContainer().add(backButton);
	}
}