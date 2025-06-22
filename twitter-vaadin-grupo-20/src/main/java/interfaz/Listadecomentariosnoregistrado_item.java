package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listadecomentariosnoregistrado_item extends Listadecomentarios_item {

	public Vercomentarionoregistrado _vercomentarionoregistrado;

	public Listadecomentariosnoregistrado_item(Listadecomentarios _listadecomentarios) {
		super(_listadecomentarios);

		this.getvL_listacomentarios_mainContainer().as(VerticalLayout.class).addClickListener(event -> {
			Vercomentarionoregistrado();
		});
	}

	public void Vercomentarionoregistrado() {
		_vercomentarionoregistrado = new Vercomentarionoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vercomentarionoregistrado);
	}
}