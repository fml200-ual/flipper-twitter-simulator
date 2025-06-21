package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TweetRetweetnoregistrado extends TweetRetweet {
	public Listadecomentariosnoregistrado _listadecomentariosnoregistrado;

	public void Listadecomentariosnoregistrado() {
		_listadecomentariosnoregistrado = new Listadecomentariosnoregistrado(this);

		for (int i = 0; i < 5; i++) {
			Listadecomentariosnoregistrado_item item = new Listadecomentariosnoregistrado_item(
					_listadecomentariosnoregistrado);
			_listadecomentariosnoregistrado.getMainContainer().as(VerticalLayout.class).add(item);
		}

		this.getDiv4().add(_listadecomentariosnoregistrado);
	}

}