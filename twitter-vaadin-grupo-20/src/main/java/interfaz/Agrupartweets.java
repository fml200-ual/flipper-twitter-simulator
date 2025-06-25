package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaAgrupartweets;

public class Agrupartweets extends VistaAgrupartweets {
	public Verperfil _verperfil;
	public Listadetweetsyretweets _listadetweetsyretweets;
	basededatos.Usuario_Registrado _usuario;

	public Agrupartweets(Verperfil _verperfil, basededatos.Usuario_Registrado usuario) {
		super();
		this._verperfil = _verperfil;
		this._usuario = usuario;

		
		Listadetweetsyretweets(usuario);
		this.getMoreTweetsButtonContainer().setVisible(false);

	}	
	
	public void Listadetweetsyretweets(basededatos.Usuario_Registrado usuario) {
		basededatos.Tweet[] tweets = null; // Declarar fuera del try
		
		try {
			// Obtener el usuario del perfil
			System.out.println("Usuario obtenido del perfil: " + (usuario != null ? usuario.getNickname() : "null"));
			
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Cargar tweets específicos del usuario (filtrar por ID y nombre de usuario)
			tweets = bd.cargarTweetsPorUsuario(usuario.getId_usuario());
			System.out.println("Cargando " + (tweets != null ? tweets.length : 0) + " tweets del usuario: " + usuario.getNickname());
			
			// Crear la lista según el tipo de usuario
			switch (Pantalla.usuario) {
				case 1:
					_listadetweetsyretweets = new Listadetweetsyretweetsnoregistrado(null);
					// Agregar tweets del usuario específico hasta un máximo de 10
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
					break;
				case 2:
					_listadetweetsyretweets = new Listadetweetsyretweetsregistrado((ACT02UsuarioRegistrado) null);
					// Agregar tweets del usuario específico hasta un máximo de 10
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
					break;
				case 3:
					_listadetweetsyretweets = new Listadetweetsyretweetsadministrador(null);
					// Agregar tweets del usuario específico hasta un máximo de 10
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
			System.err.println("Error al cargar tweets del usuario: " + e.getMessage());
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