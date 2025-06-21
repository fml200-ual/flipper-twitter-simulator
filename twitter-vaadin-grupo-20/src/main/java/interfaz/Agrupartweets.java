package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
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
		// Luego hay de diferenciar entre tweets de usuario o administrador
		switch (Pantalla.usuario) {
			case 1:
				_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(this);
				break;
		case 2:
				// Aquí se pueden agregar tweets de administrador
				break;
			case 3:
				// Aquí se pueden agregar tweets de usuario
				break;
			default:
				break;
		}
		_listadetweetsyretweets = new Listadetweetsyretweets(this);
		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
}