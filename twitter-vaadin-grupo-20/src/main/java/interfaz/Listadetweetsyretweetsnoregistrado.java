package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import basededatos.Tweet;
import mds2.MainView;

public class Listadetweetsyretweetsnoregistrado extends Listadetweetsyretweets {

	public Verhashtagnoregistrado _verhashtagnoregistrado;

	public Listadetweetsyretweetsnoregistrado(Verhashtagnoregistrado _verhashtagnoregistrado) {
		super(); // No llamar al inicializar del padre
		this._verhashtagnoregistrado = _verhashtagnoregistrado;
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
				}
			} else {
				// Fallback: crear algunos items vacíos si no hay datos
				for (int i = 0; i < 5; i++) {
					Listadetweetsyretweetsnoregistrado_item item = 
						new Listadetweetsyretweetsnoregistrado_item(this, null);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
			}
		} catch (Exception e) {
			// En caso de error, crear items vacíos
			System.err.println("Error cargando tweets para usuario no registrado: " + e.getMessage());
			for (int i = 0; i < 5; i++) {
				Listadetweetsyretweetsnoregistrado_item item = 
					new Listadetweetsyretweetsnoregistrado_item(this, null);
				this.getMainContainer().as(VerticalLayout.class).add(item);
				_item.add(item);			}
		}
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
						Listadetweetsyretweetsnoregistrado_item item = 
							new Listadetweetsyretweetsnoregistrado_item(this, tweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						this._item.add(item);
					}
				}
			} else {
				// Si no hay tweets con este hashtag, mostrar mensaje
				System.out.println("No hay tweets para el hashtag: " + hashtag.getHashtag());
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets del hashtag: " + e.getMessage());
			e.printStackTrace();
		}
	}
}