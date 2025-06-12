package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Vertweetpropio extends TweetRetweetpropio {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;

	public Vertweetpropio(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado) {
		super();
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;
		this.getContenedorPublicacionCitada().setVisible(false);
		this.getBotonEliminarTweet().setVisible(false);

		Listacomentarios();

	}

	public void Listacomentarios() {
		Listadecomentariosregistrado lista = new Listadecomentariosregistrado(null);
		lista.getMainContainer().as(VerticalLayout.class)
				.add(new Listadecomentariosregistrado_item(lista));
		lista.getMainContainer().as(VerticalLayout.class)
				.add(new Listadecomentariosregistrado_item(lista));
		lista.getMainContainer().as(VerticalLayout.class)
				.add(new Listadecomentariosregistrado_item(lista));

		this.getDiv4()
				.add(lista);
	}
}