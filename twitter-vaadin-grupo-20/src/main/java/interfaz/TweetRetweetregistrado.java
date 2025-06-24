package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TweetRetweetregistrado extends TweetRetweet {
	public Listadecomentariosregistrado _listadecomentariosregistrado;

	public TweetRetweetregistrado() {
	}

	public TweetRetweetregistrado(Listadecomentariosregistrado listadecomentariosregistrado) {
		super();
		this._listadecomentariosregistrado = listadecomentariosregistrado;
	}
	public void Listadecomentariosregistrado() {
		// METODOLOGÍA ACTIVIDAD 12: Cargar comentarios reales desde la base de datos
		try {
			System.out.println("Cargando comentarios desde la base de datos...");
			
			// Obtener el tweet del que cargar comentarios
			basededatos.Tweet tweet = null;
			if (this instanceof Vertweetregistrado) {
				tweet = ((Vertweetregistrado) this).t;
			}
			
			if (tweet != null) {
				// Crear instancia de la base de datos
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				
				// Cargar comentarios reales del tweet
				basededatos.Comentario[] comentarios = bd.cargarComentariosDeTweet(tweet.getId_tweet());
				
				_listadecomentariosregistrado = new Listadecomentariosregistrado(null);
				
				if (comentarios != null && comentarios.length > 0) {
					System.out.println("Cargados " + comentarios.length + " comentarios desde la BD");
					
					// Crear items con datos reales
					for (basededatos.Comentario comentario : comentarios) {
						if (comentario != null) {
							Listadecomentariosregistrado_item item = new Listadecomentariosregistrado_item(
								_listadecomentariosregistrado, comentario);
							_listadecomentariosregistrado.getMainContainer().as(VerticalLayout.class)
								.add(item);
						}
					}
				} else {
					System.out.println("No se encontraron comentarios para este tweet");
					// No agregar items vacíos, dejar la lista vacía
				}
			} else {
				System.out.println("Tweet es null, creando lista vacía de comentarios");
				_listadecomentariosregistrado = new Listadecomentariosregistrado(null);
			}
			
			this.getDiv4().add(_listadecomentariosregistrado);
			
		} catch (Exception e) {
			System.err.println("Error cargando comentarios desde la BD: " + e.getMessage());
			e.printStackTrace();
			
			// Fallback: crear lista vacía
			_listadecomentariosregistrado = new Listadecomentariosregistrado(null);
			this.getDiv4().add(_listadecomentariosregistrado);
		}
	}
}