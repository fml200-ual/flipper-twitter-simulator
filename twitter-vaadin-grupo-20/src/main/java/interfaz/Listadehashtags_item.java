package interfaz;

import basededatos.Hashtag;
import vistas.VistaListadehashtags_item;

public class Listadehashtags_item extends VistaListadehashtags_item {
	public Listadehashtags _listadehashtags;

	Hashtag h;

	public Listadehashtags_item(Listadehashtags listadehashtags, Hashtag h) {
		super();
		this._listadehashtags = listadehashtags;
		this.h = h;

		// Configurar el texto del hashtag
		if (h != null && h.getHashtag() != null) {
			String hashtagText = h.getHashtag();
			if (!hashtagText.startsWith("#")) {
				hashtagText = "#" + hashtagText;
			}
			this.getHashtagText().setText(hashtagText);

			// Configurar el conteo de posts
			try {
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				int numTweets = bd.contarTweetsHashtag(h.getORMID());
				this.getPostCount().setText(numTweets + " posts");
			} catch (Exception e) {
				this.getPostCount().setText("0 posts");
			}
		}
	}
}
