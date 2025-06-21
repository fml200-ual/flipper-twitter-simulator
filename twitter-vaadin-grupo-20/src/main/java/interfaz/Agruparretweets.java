package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaAgruparretweets;

public class Agruparretweets extends VistaAgruparretweets {
	public Verperfil _verperfil;
	public Listadetweetsyretweets _listadetweetsyretweets;

	public Agruparretweets(Verperfil _verperfil) {
		super();
		this._verperfil = _verperfil;

		this.getMoreTweetsButtonContainer().setVisible(false);

		Listadetweetsyretweets();
	}

	public void Listadetweetsyretweets() {
		// Luego hay de diferenciar entre tweets de usuario o administrador
		switch (Pantalla.usuario) {
			case 1:
				_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(null);
				for (int i = 0; i < 5; i++) {
					Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
							_listadetweetsyretweets);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				}

				break;
			case 2:
				_listadetweetsyretweets = new Listadetweetsyretweetsregistrado((ACT02UsuarioRegistrado) null);
				for (int i = 0; i < 5; i++) {
					Listadetweetsyretweetsregistrado_item item = new Listadetweetsyretweetsregistrado_item(
							_listadetweetsyretweets);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				}
				break;
			case 3:
				_listadetweetsyretweets = new Listadetweetsyretweetsadministrador(null);
				for (int i = 0; i < 5; i++) {
					Listadetweetsyretweetsadministrador_item item = new Listadetweetsyretweetsadministrador_item(
							_listadetweetsyretweets);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				}
				break;
			default:
				_listadetweetsyretweets = new Listadetweetsyretweets(this);
				break;
		}

		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
}