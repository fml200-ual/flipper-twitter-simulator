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
				_item.add(item);
			}
		}
	}
}