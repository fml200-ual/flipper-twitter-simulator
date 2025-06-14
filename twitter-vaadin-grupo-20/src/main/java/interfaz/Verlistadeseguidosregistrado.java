package interfaz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistadeseguidosregistrado;

public class Verlistadeseguidosregistrado extends VistaVerlistadeseguidosregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;

	public Verlistadeseguidosregistrado(Verperfilregistrado verperfilregistrado) {
		this._verperfilregistrado = verperfilregistrado;

		this.getNoFollowedMessage().setVisible(false);

		addBackButton();
		Listadeusuarios();
	}

	public Verlistadeseguidosregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;

		this.getNoFollowedMessage().setVisible(false);

		addBackButton();
		Listadeusuarios();
	}

	public void Listadeusuarios() {
		_listadeusuarios = new Listadeusuarios(this);
		for (int i = 0; i < 3; i++) {
			_listadeusuarios.getMainContainer().as(VerticalLayout.class)
					.add(new Listadeusuarios_item(_listadeusuarios));
		}
		this.getFollowedListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}

	private void addBackButton() {
		Button backButton = new Button("← Volver", event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(Pantalla.Anterior);
		});
		// Agregar el botón a tu layout
		this.getHeaderContainer().add(backButton);
	}
}