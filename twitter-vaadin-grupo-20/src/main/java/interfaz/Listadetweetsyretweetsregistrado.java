package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import basededatos.Tweet;

public class Listadetweetsyretweetsregistrado extends Listadetweetsyretweets {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verhashtagregistrado _verhashtagregistrado;	public Listadetweetsyretweetsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super(); // Constructor base sin inicialización
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
		// Inicializar manualmente para usuarios registrados
		inicializarTweetsRegistrado();
	}
	
	// Constructor específico para cargar tweets de un usuario específico (Mis tweets)
	public Listadetweetsyretweetsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado, basededatos.Usuario_Registrado usuario) {
		super(); // Constructor base sin inicialización
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
		// NO llamar a inicializarTweetsRegistrado(), usar método específico
		cargarTweetsDeUsuario(usuario);
	}
	
	public Listadetweetsyretweetsregistrado(Verhashtagregistrado verhashtagregistrado) {
		super();
		this._verhashtagregistrado = verhashtagregistrado;
		// No llamamos a inicializarTweetsRegistrado aquí porque se usará cargarTweetsDeHashtag
	}
		// Método para cargar tweets de un hashtag específico
	public void cargarTweetsDeHashtag(basededatos.Hashtag hashtag) {
		if (hashtag == null) return;
		
		try {
			// Limpiar la lista actual
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			this._item.clear();
			
			// Cargar tweets que contienen este hashtag
			// Los tweets están relacionados con el hashtag a través de la relación "pertenece"
			if (hashtag.pertenece != null && hashtag.pertenece.size() > 0) {
				Tweet[] tweets = hashtag.pertenece.toArray();
				for (Tweet tweet : tweets) {
					if (tweet != null) {
						Listadetweetsyretweetsregistrado_item item = 
							new Listadetweetsyretweetsregistrado_item(this, tweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						this._item.add(item);
					}
				}
			} else {
				// Si no hay tweets con este hashtag, mostrar mensaje
				// Podríamos agregar un label indicativo
				System.out.println("No hay tweets para el hashtag: " + hashtag.getHashtag());
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets del hashtag: " + e.getMessage());
			e.printStackTrace();
		}
	}
		private void inicializarTweetsRegistrado() {
		// Cargar tweets reales desde la base de datos específicamente para usuarios registrados
		try {
			System.out.println("=== Cargando tweets para usuario registrado ===");
			
			// Verificar el estado del usuario antes de cargar tweets
			mds2.MainView.verificarEstadoUsuario("inicializarTweetsRegistrado - inicio");
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Cargar tweets reales de la base de datos
			Tweet[] tweets = bd.cargarTweets();
			
			if (tweets != null && tweets.length > 0) {
				System.out.println("Cargados " + tweets.length + " tweets desde la BD para usuario registrado");
				
				// Crear items específicos para usuarios registrados con datos reales
				for (Tweet tweet : tweets) {
					if (tweet != null) {
						System.out.println("Creando item para tweet: " + tweet.getId_tweet());
						Listadetweetsyretweetsregistrado_item item = 
							new Listadetweetsyretweetsregistrado_item(this, tweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						_item.add(item);
					}
				}
				System.out.println("Items de tweets creados: " + _item.size());			} else {
				System.out.println("No se encontraron tweets en la base de datos");
			}		} catch (Exception e) {
			System.err.println("Error cargando tweets para usuario registrado: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("=== Fin carga tweets para usuario registrado ===");
	}
	
	// Método para cargar tweets específicos de un usuario (para "Mis tweets") 
	// usando los métodos ORM definidos en BDPrincipal
	public void cargarTweetsDeUsuario(basededatos.Usuario_Registrado usuario) {
		if (usuario == null) {
			System.err.println("No se puede cargar tweets: usuario es null");
			return;
		}
		
		try {
			System.out.println("=== Cargando tweets específicos del usuario: " + usuario.getNickname() + " ===");
			
			// Limpiar la lista actual
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			this._item.clear();
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Usar el método ORM definido para cargar solo los tweets de este usuario específico
			Tweet[] tweetsUsuario = bd.cargarTweetsPorUsuario(usuario.getId_usuario());
			
			if (tweetsUsuario != null && tweetsUsuario.length > 0) {
				System.out.println("Cargados " + tweetsUsuario.length + " tweets del usuario: " + usuario.getNickname());
				
				// Crear items específicos para los tweets del usuario
				for (Tweet tweet : tweetsUsuario) {
					if (tweet != null) {
						System.out.println("Creando item para tweet del usuario: " + tweet.getId_tweet() + " - " + tweet.getContenidoTweet());
						Listadetweetsyretweetsregistrado_item item = 
							new Listadetweetsyretweetsregistrado_item(this, tweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						this._item.add(item);
					}
				}
				System.out.println("Items de tweets del usuario creados: " + this._item.size());
			} else {
				System.out.println("El usuario " + usuario.getNickname() + " no tiene tweets publicados");
				// Opcional: agregar un mensaje indicativo
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets del usuario: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("=== Fin carga tweets del usuario ===");
	}
	
	
}