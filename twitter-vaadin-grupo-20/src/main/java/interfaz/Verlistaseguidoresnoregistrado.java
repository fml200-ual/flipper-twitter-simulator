package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidoresnoregistrado;

public class Verlistaseguidoresnoregistrado extends VistaVerlistaseguidoresnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;

	public Verlistaseguidoresnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}

	public void Listadeusuarios() {
		// Ocultar mensaje de "no hay seguidores"
		this.getNoFollowersMessage().setVisible(false);

		// Crear lista de usuarios seguidores para usuario no registrado
		_listadeusuarios = new Listadeusuarios(this);

		for (int i = 0; i < 5; i++) {
			Listadeusuarios_item item = new Listadeusuarios_item(_listadeusuarios);
			// Agregar ClickListener personalizado para navegar a Verperfilnoregistrado
			item.getMainContainer().addClickListener(event -> {
				Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(_verperfilnoregistrado);
			});
			_listadeusuarios.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
					.add(item);
		}

		// Agregar la lista al contenedor de seguidores de la vista
		this.getFollowersListContainer().as(VerticalLayout.class)
				.add(_listadeusuarios);
	}

}