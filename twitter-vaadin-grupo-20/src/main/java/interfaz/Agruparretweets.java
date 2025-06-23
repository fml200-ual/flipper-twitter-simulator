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
		try {
			// Obtener el usuario del perfil
			basededatos.Usuario_Registrado usuario = _verperfil.getUsuarioPerfil();
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Tweet[] tweets;
			
			if (usuario != null) {
				// Cargar retweets del usuario
				tweets = bd.cargarRetweets(usuario.getId_usuario());
				System.out.println("Cargando " + tweets.length + " retweets de: " + usuario.getNickname());
			} else {
				// Fallback: cargar todos los tweets
				tweets = bd.cargarTweets();
				System.out.println("Cargando todos los tweets (usuario no especificado)");
			}
			
			// Crear la lista según el tipo de usuario
			switch (Pantalla.usuario) {
				case 1:
					_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(null);
					// Agregar tweets reales hasta un máximo de 10
					int maxTweets1 = Math.min(10, tweets.length);
					for (int i = 0; i < maxTweets1; i++) {
						Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
								_listadetweetsyretweets, tweets[i]);
						_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
					}
					break;
				case 2:
					_listadetweetsyretweets = new Listadetweetsyretweetsregistrado((ACT02UsuarioRegistrado) null);
					// Agregar tweets reales hasta un máximo de 10
					int maxTweets2 = Math.min(10, tweets.length);
					for (int i = 0; i < maxTweets2; i++) {
						Listadetweetsyretweetsregistrado_item item = new Listadetweetsyretweetsregistrado_item(
								_listadetweetsyretweets, tweets[i]);
						_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
					}
					break;
				case 3:
					_listadetweetsyretweets = new Listadetweetsyretweetsadministrador(null);
					// Agregar tweets reales hasta un máximo de 10
					int maxTweets3 = Math.min(10, tweets.length);
					for (int i = 0; i < maxTweets3; i++) {
						Listadetweetsyretweetsadministrador_item item = new Listadetweetsyretweetsadministrador_item(
								_listadetweetsyretweets, tweets[i]);
						_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
					}
					break;
				default:
					_listadetweetsyretweets = new Listadetweetsyretweets(this);
					break;
			}
			
		} catch (Exception e) {
			System.err.println("Error al cargar retweets del usuario: " + e.getMessage());
			e.printStackTrace();
			
			// Fallback: usar funcionalidad original
			switch (Pantalla.usuario) {
				case 1:
					_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(null);
					for (int i = 0; i < 5; i++) {
						Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
								_listadetweetsyretweets, null);
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
					break;				default:
					_listadetweetsyretweets = new Listadetweetsyretweets(this);
					break;
			}
		}

		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
}