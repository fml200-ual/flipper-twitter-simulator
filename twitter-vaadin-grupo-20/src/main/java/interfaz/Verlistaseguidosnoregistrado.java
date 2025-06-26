package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Usuario_Registrado;
import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidosnoregistrado;

public class Verlistaseguidosnoregistrado extends VistaVerlistaseguidosnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;

	public Verlistaseguidosnoregistrado(Verperfilnoregistrado verperfilnoregistrado, Usuario_Registrado u) {
		this._verperfilnoregistrado = verperfilnoregistrado;

		this.getNoFollowedMessageNoReg().setVisible(false);
		this.getUsername().setText("@" + u.getNickname());

		Listadeusuarios(u);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}

	public void Listadeusuarios(basededatos.Usuario_Registrado u) {
		_listadeusuarios = new Listadeusuarios(this, u);

		// Agregar la lista vacía al contenedor
		this.getFollowedListContainerNoReg().as(VerticalLayout.class).add(_listadeusuarios);
	}

}