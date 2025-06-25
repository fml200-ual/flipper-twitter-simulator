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
			// Rellenar nombre del hashtag en el título
			if (h.getHashtag() != null) {
				// Mostrar el hashtag en el título H1
				this.getH1().setText("#" + h.getHashtag());
			}
			
			// TODO: Si necesitas mostrar el número de tweets, se puede agregar aquí
			// Ejemplo: this.getTweetCount().setText("" + conteo + " tweets");
		} else {
			// Si no hay hashtag específico, mostrar título genérico
			this.getH1().setText("#Hashtag");
		}
	}
}