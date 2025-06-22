package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listadecomentariosregistrado_item extends Listadecomentarios_item {

	public Vercomentarioregistrado _vercomentarioregistrado;

	public Listadecomentariosregistrado_item(Listadecomentarios _listadecomentarios) {
		super(_listadecomentarios);

		this.getvL_listacomentarios_mainContainer().as(VerticalLayout.class).addClickListener(event -> {
			Vercomentarioregistrado();
		});
	}

	public void Vercomentarioregistrado() {
		_vercomentarioregistrado = new Vercomentarioregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vercomentarioregistrado);
	}
}