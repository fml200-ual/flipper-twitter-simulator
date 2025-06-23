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

	// Constructor que acepta Comentario
	public Listadecomentariosadministrador_item(Listadecomentarios _listadecomentarios, basededatos.Comentario c) {
		super(_listadecomentarios, c);
		// Los datos se rellenan en la clase padre

		// TODO: Configurar click listener específico para administrador cuando esté disponible
	}

	public void Vercomentarioadministrador() {
		_vercomentarioadministrador = new Vercomentarioadministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vercomentarioadministrador);
	}
}