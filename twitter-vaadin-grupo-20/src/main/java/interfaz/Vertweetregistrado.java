package interfaz;

public class Vertweetregistrado extends TweetRetweetajeno {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;

	public Vertweetregistrado(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado) {
		super();
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;

		this.getBotonEliminarTweet().setVisible(false);
		this.getContenedorPublicacionCitada().setVisible(false);

		Listadecomentarios();
	}

	public void Listadecomentarios() {
		Listadecomentariosregistrado lista = new Listadecomentariosregistrado(null);
		lista.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
				.add(new Listadecomentariosregistrado_item(lista));
		this.getDiv4().add(lista);
	}
}