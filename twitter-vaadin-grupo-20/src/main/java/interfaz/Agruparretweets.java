package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Usuario;
import basededatos.BDPrincipal;
import basededatos.Tweet;
import basededatos.Usuario_Registrado;
import vistas.VistaAgruparretweets;

public class Agruparretweets extends VistaAgruparretweets {
	public Verperfil _verperfil;
	public Listadetweetsyretweets _listadetweetsyretweets;
	public Usuario_Registrado usuarioDelPerfil;

	public Agruparretweets(Verperfil _verperfil, basededatos.Usuario_Registrado o) {
		super();
		this._verperfil = _verperfil;

		this.getMoreTweetsButtonContainer().setVisible(false);

		Listadetweetsyretweets(o);
	}

	public void Listadetweetsyretweets(basededatos.Usuario_Registrado usuario) {
		BDPrincipal bd = new BDPrincipal();
		Tweet[] tweets = bd.cargarRetweets(usuario.getId_usuario());

		switch (Usuario.tipoUsuario) {
			case NO_REGISTRADO:
				_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(null);
				for (Tweet tweet : tweets) {
					Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
							_listadetweetsyretweets, tweet);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				}
				break;
			case REGISTRADO:
				_listadetweetsyretweets = new Listadetweetsyretweetsregistrado((ACT02UsuarioRegistrado) null);
				for (Tweet tweet : tweets) {
					Listadetweetsyretweetsregistrado_item item = new Listadetweetsyretweetsregistrado_item(
							_listadetweetsyretweets, tweet);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				}
				break;

			case ADMINISTRADOR:
				_listadetweetsyretweets = new Listadetweetsyretweetsadministrador(null);
				for (Tweet tweet : tweets) {
					Listadetweetsyretweetsadministrador_item item = new Listadetweetsyretweetsadministrador_item(
							_listadetweetsyretweets, tweet);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				}
				break;

			default:
				break;
		}

		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
}