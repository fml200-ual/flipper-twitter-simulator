package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import basededatos.Tweet;
import vistas.VistaListadetweetsyretweets;

public class Listadetweetsyretweets extends VistaListadetweetsyretweets {
	public Agrupartweets _agrupartweets;
	public Agrupartweetsgustados _agrupartweetsgustados;
	public Agruparretweets _agruparretweets;
	public Vector<Listadetweetsyretweets_item> _item = new Vector<Listadetweetsyretweets_item>();

	public Listadetweetsyretweets() {
		super();
	}

	public Listadetweetsyretweets(Agrupartweets _agrupartweets) {
		super();
		this._agrupartweets = _agrupartweets;
		inicializar();
	}

	public Listadetweetsyretweets(Agrupartweetsgustados _agrupartweetsgustados) {
		super();
		this._agrupartweetsgustados = _agrupartweetsgustados;
		inicializar();
	}

	public Listadetweetsyretweets(Agruparretweets _agruparretweets) {
		super();
		this._agruparretweets = _agruparretweets;
		inicializar();
	}
	private void inicializar() {
		// METODOLOGÍA ACTIVIDAD 12: Cargar tweets reales desde la base de datos
		try {
			System.out.println("Cargando tweets desde la base de datos...");
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Cargar tweets reales de la base de datos
			Tweet[] tweets = bd.cargarTweets();
			
			if (tweets != null && tweets.length > 0) {
				System.out.println("Cargados " + tweets.length + " tweets desde la BD");
				
				// Crear items con datos reales
				for (Tweet tweet : tweets) {
					if (tweet != null) {
						Listadetweetsyretweets_item item = new Listadetweetsyretweets_item(this, tweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						_item.add(item);
					}
				}			} else {
				System.out.println("No se encontraron tweets en la base de datos");
			}		} catch (Exception e) {
			System.err.println("Error cargando tweets desde la BD: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// METODOLOGÍA ACTIVIDAD 12: Operaciones CRUD para tweets
	
	/**
	 * Añadir un nuevo tweet y actualizar la lista
	 */
	public void anadirTweet(int id_usuario, String contenido) {
		try {
			System.out.println("Añadiendo nuevo tweet...");
			
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Publicar nuevo tweet
			basededatos.Usuario_Registrado usuarioActualizado = bd.publicarTweet(
				id_usuario, 
				contenido, 
				new java.util.Date(), 
				null, null, 
				new String[0], 
				new String[0]
			);
			
			if (usuarioActualizado != null) {
				System.out.println("Tweet añadido exitosamente");
				// Recargar la lista
				recargarTweets();
			} else {
				System.err.println("Error al añadir tweet");
			}
			
		} catch (Exception e) {
			System.err.println("Error durante la adición del tweet: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Modificar un tweet existente
	 */
	public void modificarTweet(int id_tweet, String nuevoContenido) {
		try {
			System.out.println("Modificando tweet con ID: " + id_tweet);
			
			// TODO: Implementar cuando esté disponible el método en BDPrincipal
			System.out.println("Funcionalidad de modificar tweet no implementada aún en la BD");
			
		} catch (Exception e) {
			System.err.println("Error durante la modificación del tweet: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Borrar tweets seleccionados
	 */
	public void borrarTweetsSeleccionados(Vector<Listadetweetsyretweets_item> itemsSeleccionados) {
		try {
			System.out.println("Borrando " + itemsSeleccionados.size() + " tweets...");
			
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			for (Listadetweetsyretweets_item item : itemsSeleccionados) {
				if (item.t != null) {
					bd.eliminarTweet(item.t.getORMID());
					System.out.println("Tweet eliminado: " + item.t.getORMID());
				}
			}
			
			System.out.println("Tweets eliminados exitosamente");
			// Recargar la lista
			recargarTweets();
			
		} catch (Exception e) {
			System.err.println("Error durante la eliminación de tweets: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Recargar todos los tweets desde la base de datos
	 */
	public void recargarTweets() {
		try {
			// Limpiar la lista actual
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			_item.clear();
			
			// Reinicializar con datos frescos
			inicializar();
			
		} catch (Exception e) {
			System.err.println("Error recargando tweets: " + e.getMessage());
			e.printStackTrace();
		}
	}
}