package interfaz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistadeseguidoresregistrado;

public class Verlistadeseguidoresregistrado extends VistaVerlistadeseguidoresregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;

	public Verlistadeseguidoresregistrado(Verperfilregistrado verperfilregistrado) {
		this._verperfilregistrado = verperfilregistrado;

		this.getNoFollowersMessage().setVisible(false);

		addBackButton();
		Listadeusuarios();
	}

	public Verlistadeseguidoresregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;

		this.getNoFollowersMessage().setVisible(false);

		addBackButton();
		Listadeusuarios();
	}

	public void Listadeusuarios() {
		_listadeusuarios = new Listadeusuarios(this);
		for (int i = 0; i < 3; i++) {
			_listadeusuarios.getMainContainer().as(VerticalLayout.class)
					.add(new Listadeusuarios_item(_listadeusuarios));
		}
		this.getFollowersListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}

	protected void addBackButton() {
		Button backButton = new Button("← Volver", event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(Pantalla.Anterior);
		});
		this.getHeaderContainer().add(backButton);
	}
}