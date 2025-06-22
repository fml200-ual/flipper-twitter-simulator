package interfaz;

import mds2.MainView.Pantalla;

public class Verlistaampliadadehashtagsnoregistrado extends Verlistaampliadadehashtags {
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Verhashtagnoregistrado _verhashtagnoregistrado;

	public Verlistaampliadadehashtagsnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado) {
		super();
		this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;
		// Ensamblado de componentes fijos
		Listadehashtags();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsnoregistrado._aCT01UsuarioNoRegistrado);
		});
	}

	@Override
	public void Listadehashtags() {
		// Crear lista ampliada de hashtags para usuario no registrado
		Listadehashtags listaHashtags = new Listadehashtags(this);

		for (int i = 0; i < 5; i++) {
			Listadehashtags_item item = new Listadehashtags_item(listaHashtags);
			// Agregar ClickListener personalizado para navegar a Verhashtagnoregistrado
			item.getHashtagContainer().addClickListener(event -> {
				Verhashtagnoregistrado();
			});
			listaHashtags.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
					.add(item);
		}
		this.getHashtagsListContainer().add(listaHashtags);
	}

	public void Verhashtagnoregistrado() {
		_verhashtagnoregistrado = new Verhashtagnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verhashtagnoregistrado);
	}
}