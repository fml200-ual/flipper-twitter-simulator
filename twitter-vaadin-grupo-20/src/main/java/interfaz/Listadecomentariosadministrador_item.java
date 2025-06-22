package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listadecomentariosadministrador_item extends Listadecomentarios_item {

	public Vercomentarioadministrador _vercomentarioadministrador;

	public Listadecomentariosadministrador_item(Listadecomentariosadministrador _listadecomentariosadministrador) {
		super(_listadecomentariosadministrador);

		this.getvL_listacomentarios_mainContainer().as(VerticalLayout.class).addClickListener(event -> {
			Vercomentarioadministrador();
		});
	}

	public void Vercomentarioadministrador() {
		_vercomentarioadministrador = new Vercomentarioadministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vercomentarioadministrador);
	}
}