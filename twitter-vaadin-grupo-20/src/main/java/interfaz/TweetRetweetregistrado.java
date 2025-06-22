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
		_listadecomentariosregistrado = new Listadecomentariosregistrado(null);

		for (int i = 0; i < 5; i++) {
			Listadecomentariosregistrado_item item = new Listadecomentariosregistrado_item(
					_listadecomentariosregistrado);
			_listadecomentariosregistrado.getMainContainer().as(VerticalLayout.class)
					.add(item);
		}

		this.getDiv4().add(_listadecomentariosregistrado);
	}
}