package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Tweet;
import basededatos.Usuario_Registrado;
import vistas.VistaAgrupartweetsgustados;

public class Agrupartweetsgustados extends VistaAgrupartweetsgustados {
	public Verperfil _verperfil;
	public Listadetweetsyretweets _listadetweetsyretweets;
	public Usuario_Registrado usuarioDelPerfil;

	public Agrupartweetsgustados(Verperfil _verperfil, Usuario_Registrado usuario) {
		super();
	
		this._verperfil = _verperfil;
		this.usuarioDelPerfil = usuario;

		}

	public void Listadetweetsyretweets(Usuario_Registrado usuario) {
		// Cargar tweets que gustan al usuario desde la base de datos
		BDPrincipal bd = new BDPrincipal();
		Tweet[] tweetsQueGustan = null;
		
		try {
			if (usuario != null) {
				// Cargar tweets que le gustan al usuario específico
				System.out.println("Cargando tweets que le gustan al usuario: " + usuario.getNickname() + " (ID: " + usuario.getId_usuario() + ")");
				tweetsQueGustan = bd.cargarTweetsQueGustan(usuario.getId_usuario());
				System.out.println("Tweets gustados cargados: " + (tweetsQueGustan != null ? tweetsQueGustan.length : 0));
			} else {
				System.err.println("ERROR: Usuario es null, no se pueden cargar tweets gustados");
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets que gustan al usuario: " + e.getMessage());
			tweetsQueGustan = new Tweet[0]; // Array vacío como fallback
		}

		// Luego hay de diferenciar entre tweets de usuario o administrador
		switch (Pantalla.usuario) {
			case 1:
				_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(null);
				if (tweetsQueGustan != null && tweetsQueGustan.length > 0) {
					// Mostrar máximo 10 tweets que gustan al usuario
					int maxTweets1 = Math.min(10, tweetsQueGustan.length);
					for (int i = 0; i < maxTweets1; i++) {
						Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
								_listadetweetsyretweets, tweetsQueGustan[i]);
						_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
					}
				}
				break;
			case 2:
				_listadetweetsyretweets = new Listadetweetsyretweetsregistrado();
				if (tweetsQueGustan != null && tweetsQueGustan.length > 0) {
					// Mostrar máximo 10 tweets que gustan al usuario
					int maxTweets2 = Math.min(10, tweetsQueGustan.length);
					for (int i = 0; i < maxTweets2; i++) {
						Listadetweetsyretweetsregistrado_item item = new Listadetweetsyretweetsregistrado_item(
								_listadetweetsyretweets, tweetsQueGustan[i]);
						_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
					}
				}
				break;
			case 3:
				_listadetweetsyretweets = new Listadetweetsyretweetsadministrador();
				if (tweetsQueGustan != null && tweetsQueGustan.length > 0) {
					// Mostrar máximo 10 tweets que gustan al usuario
					int maxTweets3 = Math.min(10, tweetsQueGustan.length);
					for (int i = 0; i < maxTweets3; i++) {
						Listadetweetsyretweetsadministrador_item item = new Listadetweetsyretweetsadministrador_item(
								_listadetweetsyretweets, tweetsQueGustan[i]);
						_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
					}
				}
				break;
			default:
				_listadetweetsyretweets = new Listadetweetsyretweets(this);
				break;
		}

		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
}