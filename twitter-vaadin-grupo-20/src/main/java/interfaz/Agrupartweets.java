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
	}	public void Listadetweetsyretweets() {
		try {
			// Obtener el usuario del perfil
			basededatos.Usuario_Registrado usuario = _verperfil.getUsuarioPerfil();
			System.out.println("Usuario obtenido del perfil: " + (usuario != null ? usuario.getNickname() : "null"));
			
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Tweet[] tweets;
			
			if (usuario != null) {
				// Cargar tweets específicos del usuario
				tweets = bd.cargarTweetsPorUsuario(usuario.getId_usuario());
				System.out.println("Cargando " + (tweets != null ? tweets.length : 0) + " tweets del usuario: " + usuario.getNickname());
			} else {
				// Fallback: cargar todos los tweets
				tweets = bd.cargarTweets();
				System.out.println("Cargando tweets desde la base de datos...");
				System.out.println("Cargados " + (tweets != null ? tweets.length : 0) + " tweets desde la BD");
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
					break;				case 2:
					// Para usuarios registrados, intentar obtener la referencia del ACT02UsuarioRegistrado
					ACT02UsuarioRegistrado actorRegistrado = null;
					if (_verperfil instanceof Verpropioperfil) {
						actorRegistrado = ((Verpropioperfil) _verperfil)._aCT02UsuarioRegistrado;
					}
					
					// IMPORTANTE: Usar el constructor específico para tweets del usuario
					if (usuario != null) {
						System.out.println("Usando constructor específico para tweets del usuario: " + usuario.getNickname());
						_listadetweetsyretweets = new Listadetweetsyretweetsregistrado(actorRegistrado, usuario);
					} else {
						System.out.println("Usuario null, usando constructor genérico");
						_listadetweetsyretweets = new Listadetweetsyretweetsregistrado(actorRegistrado);
					}
					
					// NO agregamos tweets manualmente aquí porque el constructor ya los carga
					System.out.println("Lista de tweets creada para usuario registrado");
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
			System.err.println("Error al cargar tweets del usuario: " + e.getMessage());
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