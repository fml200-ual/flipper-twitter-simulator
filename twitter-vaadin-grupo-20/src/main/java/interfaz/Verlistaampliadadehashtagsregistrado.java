package interfaz;

import mds2.MainView.Pantalla;

public class Verlistaampliadadehashtagsregistrado extends Verlistaampliadadehashtags {
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verhashtagregistrado _verhashtagregistrado;
	public ACT02UsuarioRegistrado _usuarioRegistrado;

	public Verlistaampliadadehashtagsregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;

		Listadehashtags();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsregistrado._aCT02UsuarioRegistrado);
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
				Verhashtagregistrado();
			});
			listaHashtags.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
					.add(item);
		}
		this.getHashtagsListContainer().add(listaHashtags);
	}

	public void Verhashtagregistrado() {
		_verhashtagregistrado = new Verhashtagregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verhashtagregistrado);
	}
}