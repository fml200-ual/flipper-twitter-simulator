package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TweetRetwetadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador _listadecomentariosadministrador;
	public void Listadecomentariosadministrador() {
		_listadecomentariosadministrador = new Listadecomentariosadministrador(this);
		// Solo crear el contenedor, los comentarios reales se cargarán según el tweet seleccionado
		this.getContenedorComentarios().add(_listadecomentariosadministrador);
	}
}