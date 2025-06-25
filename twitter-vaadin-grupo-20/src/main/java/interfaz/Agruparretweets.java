package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Tweet;
import basededatos.Usuario_Registrado;
import vistas.VistaAgruparretweets;

public class Agruparretweets extends VistaAgruparretweets {
	public Verperfil _verperfil;
	public Listadetweetsyretweets _listadetweetsyretweets;
	public Usuario_Registrado usuarioDelPerfil;

	public Agruparretweets(Verperfil _verperfil, Usuario_Registrado usuario) {
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
				cargarRetweetsManualmente(usuario);
				break;
			case 2:
				// Usuario registrado - usar constructor sin parámetros y método específico para retweets
				_listadetweetsyretweets = new Listadetweetsyretweetsregistrado();
				// Usar el método específico para cargar retweets del usuario
				((Listadetweetsyretweetsregistrado) _listadetweetsyretweets).cargarRetweetsDelUsuario(usuario);
				break;
			case 3:
				// Administrador - usar constructor sin parámetros y cargar manualmente
				_listadetweetsyretweets = new Listadetweetsyretweetsadministrador();
				cargarRetweetsManualmente(usuario);
				break;
			default:
				_listadetweetsyretweets = new Listadetweetsyretweets(this);
				break;
		}

		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
	
	/**
	 * Método auxiliar para cargar retweets manualmente (para usuarios no registrados y administradores)
	 */
	private void cargarRetweetsManualmente(Usuario_Registrado usuario) {
		BDPrincipal bd = new BDPrincipal();
		Tweet[] retweets = null;
		
		try {
			if (usuario != null) {
				// Cargar retweets específicos del usuario
				retweets = bd.cargarRetweets(usuario.getId_usuario());
			} else {
				// Fallback: cargar todos los tweets (no hay método para todos los retweets)
				retweets = bd.cargarTweets();
			}
		} catch (Exception e) {
			System.err.println("Error cargando retweets del usuario: " + e.getMessage());
			retweets = new Tweet[0]; // Array vacío como fallback
		}
		
		// Agregar los retweets a la lista manualmente
		if (retweets != null && retweets.length > 0) {
			// Mostrar máximo 10 retweets del usuario
			int maxRetweets = Math.min(10, retweets.length);
			for (int i = 0; i < maxRetweets; i++) {
				if (Pantalla.usuario == 1) {
					// Usuario no registrado
					Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
							_listadetweetsyretweets, retweets[i]);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				} else if (Pantalla.usuario == 3) {
					// Administrador
					Listadetweetsyretweetsadministrador_item item = new Listadetweetsyretweetsadministrador_item(
							_listadetweetsyretweets, retweets[i]);
					_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
				}
			}
		}
	}
}