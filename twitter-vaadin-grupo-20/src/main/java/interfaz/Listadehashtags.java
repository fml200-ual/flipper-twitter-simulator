package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaListadehashtags;

public class Listadehashtags extends VistaListadehashtags {
	public Verlistaampliadadehashtags _verlistaampliadadehashtags;
	public Vector<Listadehashtags_item> _item = new Vector<Listadehashtags_item>();

	public Listadehashtags(Verlistaampliadadehashtags _verlistaampliadadehashtags) {
		super();
		this._verlistaampliadadehashtags = _verlistaampliadadehashtags;
		// Cargar hashtags reales al crear la instancia
		cargarHashtagsReales();
	}

	public void itemsHashtags() {
		// Este método ya no se usa, se reemplaza por cargarHashtagsReales()
		cargarHashtagsReales();
	}
	
	// Método para cargar hashtags reales desde la base de datos
	private void cargarHashtagsReales() {
		try {
			System.out.println("=== Cargando hashtags reales desde la BD ===");
			
			// Limpiar la lista actual
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			this._item.clear();
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Cargar hashtags reales de la base de datos
			basededatos.Hashtag[] hashtags = bd.cargarHashtags();
			
			if (hashtags != null && hashtags.length > 0) {
				System.out.println("Cargados " + hashtags.length + " hashtags desde la BD");
				
				// Crear items específicos para cada hashtag real
				for (basededatos.Hashtag hashtag : hashtags) {
					if (hashtag != null) {
						System.out.println("Creando item para hashtag: " + hashtag.getHashtag());
						Listadehashtags_item item = new Listadehashtags_item(this, hashtag);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						this._item.add(item);
					}
				}
				System.out.println("Items de hashtags creados: " + this._item.size());
			} else {
				System.out.println("No se encontraron hashtags en la base de datos");
				// Si no hay hashtags reales, mostrar mensaje o crear algunos por defecto
			}
		} catch (Exception e) {
			System.err.println("Error cargando hashtags reales: " + e.getMessage());
			e.printStackTrace();
			// En caso de error, crear algunos items vacíos como fallback
			for (int i = 0; i < 3; i++) {
				Listadehashtags_item item = new Listadehashtags_item(this, null);
				this.getMainContainer().as(VerticalLayout.class).add(item);
				this._item.add(item);
			}
		}
		System.out.println("=== Fin carga hashtags reales ===");
	}

}