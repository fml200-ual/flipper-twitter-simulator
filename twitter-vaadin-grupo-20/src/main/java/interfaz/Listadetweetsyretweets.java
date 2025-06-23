package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import basededatos.Tweet;
import mds2.MainView;
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
		try {
			// Cargar tweets reales de la base de datos
			Tweet[] tweets = ((basededatos.BDPrincipal) MainView.Usuario.usuarioNoRegistradoInterfaz).cargarTweets();
			
			if (tweets != null && tweets.length > 0) {
				// Crear items con datos reales
				for (int i = 0; i < tweets.length; i++) {
					Listadetweetsyretweets_item item = new Listadetweetsyretweets_item(this, tweets[i]);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
			} else {
				// Fallback: crear algunos items vacíos si no hay datos
				for (int i = 0; i < 3; i++) {
					Listadetweetsyretweets_item item = new Listadetweetsyretweets_item(this, null);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
			}
		} catch (Exception e) {
			// En caso de error, crear items vacíos
			System.err.println("Error cargando tweets: " + e.getMessage());
			for (int i = 0; i < 3; i++) {
				Listadetweetsyretweets_item item = new Listadetweetsyretweets_item(this, null);
				this.getMainContainer().as(VerticalLayout.class).add(item);
				_item.add(item);
			}
		}
	}
}