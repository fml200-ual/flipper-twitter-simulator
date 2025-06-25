package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Tweet;
import basededatos.Usuario_Registrado;
import vistas.VistaAgrupartweets;

public class Agrupartweets extends VistaAgrupartweets {
	public Verperfil _verperfil;
	public Listadetweetsyretweets _listadetweetsyretweets;
	public Usuario_Registrado usuarioDelPerfil;

	public Agrupartweets(Verperfil _verperfil, Usuario_Registrado usuario) {
		super();
		this._verperfil = _verperfil;
		this.usuarioDelPerfil = usuario;

		this.getMoreTweetsButtonContainer().setVisible(false);

		Listadetweetsyretweets(usuario);
	}

	public void Listadetweetsyretweets(Usuario_Registrado usuario) {
		// Diferenciamos según el tipo de usuario que está visualizando el perfil
		// y utilizamos los constructores que aprovechan la lógica de agrupación interna
		switch (Pantalla.usuario) {
			case 1:
				// Usuario no registrado - usar constructor sin parámetros y cargar manualmente
				_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado();
				cargarTweetsManualmente(usuario);
				break;
			case 2:
				// Usuario registrado - usar constructor que aprovecha la agrupación automática
				_listadetweetsyretweets = new Listadetweetsyretweetsregistrado(null, usuario);
				// La lista se encarga automáticamente de cargar y agrupar los tweets del usuario
				break;
			case 3:
				// Administrador - usar constructor sin parámetros y cargar manualmente
				_listadetweetsyretweets = new Listadetweetsyretweetsadministrador();
				cargarTweetsManualmente(usuario);
				break;
			default:
				_listadetweetsyretweets = new Listadetweetsyretweets(this);
				break;
		}

		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
	
	/**
	 * Método auxiliar para cargar tweets manualmente (para usuarios no registrados y administradores)
	 */
	private void cargarTweetsManualmente(Usuario_Registrado usuario) {
		BDPrincipal bd = new BDPrincipal();
		Tweet[] tweets = null;
		
		try {
			if (usuario != null) {
				// Cargar tweets específicos del usuario
				tweets = bd.cargarTweetsPorUsuario(usuario.getId_usuario());
			} else {
				// Fallback: cargar todos los tweets
				tweets = bd.cargarTweets();
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets del usuario: " + e.getMessage());
			tweets = new Tweet[0]; // Array vacío como fallback
		}
		
		// Agregar los tweets a la lista manualmente
		if (tweets != null && tweets.length > 0) {
			// Mostrar máximo 10 tweets del usuario
			int maxTweets = Math.min(10, tweets.length);
			for (int i = 0; i < maxTweets; i++) {
				if (Pantalla.usuario == 1) {
					// Usuario no registrado
					Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
							_listadetweetsyretweets, tweets[i]);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				} else if (Pantalla.usuario == 3) {
					// Administrador
					Listadetweetsyretweetsadministrador_item item = new Listadetweetsyretweetsadministrador_item(
							_listadetweetsyretweets, tweets[i]);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				}
			}
		}
	}
}