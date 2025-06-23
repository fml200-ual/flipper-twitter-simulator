package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import basededatos.Tweet;

public class Listadetweetsyretweetsregistrado extends Listadetweetsyretweets {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verhashtagregistrado _verhashtagregistrado;
	public Listadetweetsyretweetsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super(); // Llama al constructor padre que carga automáticamente los tweets
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
		// Reemplazar items genéricos con items específicos para usuarios registrados
		reemplazarConItemsRegistrados();
	}

	public Listadetweetsyretweetsregistrado(Verhashtagregistrado verhashtagregistrado) {
		super();
		this._verhashtagregistrado = verhashtagregistrado;
		// No llamamos a reemplazarConItemsRegistrados aquí porque se usará cargarTweetsDeHashtag
	}
	
	private void reemplazarConItemsRegistrados() {
		try {
			// Obtener los tweets que ya están cargados en _item
			if (_item != null && _item.size() > 0) {
				// Limpiar el contenedor visual pero mantener los datos
				this.getMainContainer().as(VerticalLayout.class).removeAll();
				
				// Crear nuevos items específicos para usuarios registrados
				for (int i = 0; i < _item.size(); i++) {
					Tweet tweet = _item.get(i).t; // Obtener el tweet del item genérico
					
					// Crear item específico para usuario registrado
					Listadetweetsyretweetsregistrado_item itemRegistrado = 
						new Listadetweetsyretweetsregistrado_item(this, tweet);
					
					// Reemplazar en la lista
					_item.set(i, itemRegistrado);
					
					// Agregar al contenedor visual
					this.getMainContainer().as(VerticalLayout.class).add(itemRegistrado);
				}
			}
		} catch (Exception e) {
			System.err.println("Error reemplazando items con versiones para usuarios registrados: " + e.getMessage());
			e.printStackTrace();
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

}