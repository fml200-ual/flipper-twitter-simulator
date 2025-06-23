package interfaz;

import vistas.VistaVerhashtag;

public class Verhashtag extends VistaVerhashtag {
	
	// Objeto ORMPersistable para el hashtag que se muestra
	public basededatos.Hashtag h;

	public Verhashtag(basededatos.Hashtag h) {
		super();
		this.h = h;
		
		// Rellenar datos del hashtag
		rellenarDatosHashtag();
	}
	
	// Constructor de compatibilidad temporal
	public Verhashtag() {
		this(null);
	}
	
	private void rellenarDatosHashtag() {
		if (h != null) {
			// Rellenar nombre del hashtag
			if (h.getHashtag() != null) {
				// Mostrar el hashtag en el título
				// this.getHashtagTitle().setText("#" + h.getHashtag());
			}
			
			// Mostrar número de tweets que usan este hashtag
			// this.getTweetCount().setText("" + h.pertenece.size() + " tweets");
			
			// Cargar y mostrar los tweets que contienen este hashtag
			// TODO: Implementar lista de tweets que contienen este hashtag
		}
	}
}