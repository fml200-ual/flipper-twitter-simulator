package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import basededatos.Tweet;
import mds2.MainView;

public class Listadetweetsyretweetsnoregistrado extends Listadetweetsyretweets {

	public Verhashtagnoregistrado _verhashtagnoregistrado;

	public Listadetweetsyretweetsnoregistrado(Verhashtagnoregistrado _verhashtagnoregistrado) {
		super(); // No llamar al inicializar del padre
		this._verhashtagnoregistrado = _verhashtagnoregistrado;
<<<<<<< HEAD
		inicializarTweetsNoRegistrado();
	}
	
	private void inicializarTweetsNoRegistrado() {
		try {
			// Cargar tweets reales de la base de datos
			Tweet[] tweets = ((basededatos.BDPrincipal) MainView.Usuario.usuarioNoRegistradoInterfaz).cargarTweets();
			
			if (tweets != null && tweets.length > 0) {
				// Crear items específicos para usuarios no registrados con datos reales
				for (int i = 0; i < Math.min(tweets.length, 10); i++) { // Máximo 10 tweets
					Listadetweetsyretweetsnoregistrado_item item = 
						new Listadetweetsyretweetsnoregistrado_item(this, tweets[i]);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}			} else {
				System.out.println("No se encontraron tweets en la base de datos");
			}		} catch (Exception e) {
			System.err.println("Error cargando tweets para usuario no registrado: " + e.getMessage());
			e.printStackTrace();
		}
	}
		// Método para cargar tweets de un hashtag específico
	public void cargarTweetsDeHashtag(basededatos.Hashtag hashtag) {
		cargarTweetsDeHashtag(hashtag, false);
	}
	// Método para cargar tweets de un hashtag específico con opción de agrupación
	public void cargarTweetsDeHashtag(basededatos.Hashtag hashtag, boolean agrupar) {
		if (hashtag == null) return;
		
		try {
			// Cargar tweets directamente, sin agrupación ni sección superior
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			this._item.clear();
			VerticalLayout mainLayout = this.getMainContainer().as(VerticalLayout.class);
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			Tweet[] tweets = bd.cargarTweetsDeHashtag(hashtag.getId_hashtag());
			if (tweets != null) {
				for (Tweet tweet : tweets) {
					if (tweet != null) {
						Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(this, tweet);
						mainLayout.add(item);
						this._item.add(item);
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets del hashtag: " + e.getMessage());
			e.printStackTrace();
		}
	}
=======
	}

>>>>>>> f181314abb8f924194337209199b7bceaa2730b5
}