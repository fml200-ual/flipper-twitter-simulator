package interfaz;

import com.vaadin.flow.component.button.Button;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistadeseguidosregistrado;

public class Verlistadeseguidosregistrado extends VistaVerlistadeseguidosregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;

	public Verlistadeseguidosregistrado(Verperfilregistrado verperfilregistrado) {
		this._verperfilregistrado = verperfilregistrado;
		addBackButton();
	}

	public Verlistadeseguidosregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;
		addBackButton();
	}

	public void Listadeusuarios() {
		throw new UnsupportedOperationException();
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