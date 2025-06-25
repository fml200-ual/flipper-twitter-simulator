package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaAgrupartweetsgustados;

public class Agrupartweetsgustados extends VistaAgrupartweetsgustados {
	public Verperfil _verperfil;
	public Listadetweetsyretweets _listadetweetsyretweets;

	public Agrupartweetsgustados(Verperfil _verperfil) {
		super();
		this._verperfil = _verperfil;

		this.getMoreTweetsButtonContainer().setVisible(false);

		Listadetweetsyretweets();
	}	public void Listadetweetsyretweets() {
		basededatos.Tweet[] tweets = null; // Declarar fuera del try
		
		try {
			// Obtener el usuario del perfil
			basededatos.Usuario_Registrado usuario = _verperfil.getUsuarioPerfil();
			System.out.println("Usuario obtenido del perfil: " + (usuario != null ? usuario.getNickname() : "null"));
			
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			if (usuario != null) {
				// Cargar tweets que le gustan al usuario específico del perfil
				tweets = bd.cargarTweetsQueGustan(usuario.getId_usuario());
				System.out.println("Cargando " + (tweets != null ? tweets.length : 0) + " tweets que le gustan a: " + usuario.getNickname());
			} else {
				// Fallback: usar tweets gustados del usuario actual si está logueado
				basededatos.Usuario_Registrado usuarioActual = mds2.MainView.obtenerUsuarioActual();
				if (usuarioActual != null) {
					tweets = bd.cargarTweetsQueGustan(usuarioActual.getId_usuario());
					System.out.println("Cargando tweets que le gustan al usuario actual: " + usuarioActual.getNickname());
				} else {
					tweets = new basededatos.Tweet[0]; // Array vacío
					System.out.println("No hay usuario especificado, mostrando lista vacía");
				}
			}
			
			// Crear la lista según el tipo de usuario
			switch (Pantalla.usuario) {
				case 1:
					_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(null);
					// Agregar tweets gustados hasta un máximo de 10
					if (tweets != null && tweets.length > 0) {
						int maxTweets1 = Math.min(10, tweets.length);
						for (int i = 0; i < maxTweets1; i++) {
							if (tweets[i] != null) {
								Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
										_listadetweetsyretweets, tweets[i]);
								_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
							}
						}
					}
					break;				case 2:
					_listadetweetsyretweets = new Listadetweetsyretweetsregistrado((ACT02UsuarioRegistrado) null);
					// Agregar tweets gustados hasta un máximo de 10
					if (tweets != null && tweets.length > 0) {
						int maxTweets2 = Math.min(10, tweets.length);
						for (int i = 0; i < maxTweets2; i++) {
							if (tweets[i] != null) {
								Listadetweetsyretweetsregistrado_item item = new Listadetweetsyretweetsregistrado_item(
										_listadetweetsyretweets, tweets[i]);
								_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
							}
						}
					}
					break;				case 3:
					_listadetweetsyretweets = new Listadetweetsyretweetsadministrador(null);
					// Agregar tweets gustados hasta un máximo de 10
					if (tweets != null && tweets.length > 0) {
						int maxTweets3 = Math.min(10, tweets.length);
						for (int i = 0; i < maxTweets3; i++) {
							if (tweets[i] != null) {
								Listadetweetsyretweetsadministrador_item item = new Listadetweetsyretweetsadministrador_item(
										_listadetweetsyretweets, tweets[i]);
								_listadetweetsyretweets.getMainContainer().as(VerticalLayout.class).add(item);
							}
						}
					}
					break;
				default:
					_listadetweetsyretweets = new Listadetweetsyretweets(this);
					break;
			}			
		} catch (Exception e) {
			System.err.println("Error al cargar tweets que gustan al usuario: " + e.getMessage());
			e.printStackTrace();
			
			// Fallback: crear listas vacías
			switch (Pantalla.usuario) {
				case 1:
					_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(null);
					break;
				case 2:
					_listadetweetsyretweets = new Listadetweetsyretweetsregistrado((ACT02UsuarioRegistrado) null);
					break;
				case 3:
					_listadetweetsyretweets = new Listadetweetsyretweetsadministrador(null);
					break;
				default:
					_listadetweetsyretweets = new Listadetweetsyretweets(this);
					break;
			}
		}

		this.getTweetsContainer().as(VerticalLayout.class).add(_listadetweetsyretweets);
	}
}