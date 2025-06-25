package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Usuario_Registrado;
import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidoresnoregistrado;

public class Verlistaseguidoresnoregistrado extends VistaVerlistaseguidoresnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;

	public Verlistaseguidoresnoregistrado(Verperfilnoregistrado verperfilnoregistrado, Usuario_Registrado u) {
		super();
		this._verperfilnoregistrado = verperfilnoregistrado;

		this.getNoFollowersMessage().setVisible(false);
		this.getUsername().setText("@" + u.getNickname());

		Listadeusuarios(u);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}

	public void Listadeusuarios(basededatos.Usuario_Registrado usuario) {
		// Usar el constructor específico que maneja seguidores automáticamente (igual
		// que registrados)
		_listadeusuarios = new Listadeusuarios(this, usuario);

		this.getFollowersListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}