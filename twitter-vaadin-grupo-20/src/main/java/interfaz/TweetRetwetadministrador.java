package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Comentario;
import basededatos.Tweet;

public class TweetRetwetadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador _listadecomentariosadministrador;

	public void Listadecomentariosadministrador(Tweet tweet) {
		_listadecomentariosadministrador = new Listadecomentariosadministrador(this);

		Comentario[] comentarios = tweet.tiene.toArray("fechaPublicacion", false);
		for (Comentario comentario : comentarios) {
			Listadecomentariosadministrador_item item = new Listadecomentariosadministrador_item(
					_listadecomentariosadministrador, comentario);
			_listadecomentariosadministrador.getMainContainer().as(VerticalLayout.class).add(item);
		}

		this.getContenedorComentarios().add(_listadecomentariosadministrador);
	}
}