package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TweetRetwetadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador _listadecomentariosadministrador;

	public void Listadecomentariosadministrador() {
		_listadecomentariosadministrador = new Listadecomentariosadministrador(this);
		for (int i = 0; i < 3; i++) {
			_listadecomentariosadministrador.getMainContainer().as(VerticalLayout.class)
					.add(new Listadecomentariosadministrador_item(_listadecomentariosadministrador));
		}
		this.getContenedorComentarios().add(_listadecomentariosadministrador);
	}
}