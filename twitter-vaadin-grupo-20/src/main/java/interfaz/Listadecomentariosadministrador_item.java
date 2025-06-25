package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Comentario;
import mds2.MainView.Pantalla;

public class Listadecomentariosadministrador_item extends Listadecomentarios_item {

	public Vercomentarioadministrador _vercomentarioadministrador;

	// Constructor que acepta Comentario
	public Listadecomentariosadministrador_item(Listadecomentarios _listadecomentarios, basededatos.Comentario c) {
		super(_listadecomentarios, c);
		// Los datos se rellenan en la clase padre

		// TODO: Configurar click listener específico para administrador cuando esté
		// disponible
		this.getvL_listacomentarios_mainContainer().as(VerticalLayout.class).addClickListener(event -> {
			Vercomentarioadministrador(c);
		});

	}

	public void Vercomentarioadministrador(Comentario c) {
		_vercomentarioadministrador = new Vercomentarioadministrador(this, c);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vercomentarioadministrador);
	}
}