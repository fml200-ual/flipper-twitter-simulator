package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistadeseguidosregistrado;

public class Verlistadeseguidosregistrado extends VistaVerlistadeseguidosregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;
	basededatos.Usuario_Registrado u;

	public Verlistadeseguidosregistrado(Verperfilregistrado verperfilregistrado, basededatos.Usuario_Registrado u) {
		this._verperfilregistrado = verperfilregistrado;
		this.u = u;

		this.getNoFollowedMessage().setVisible(false);
		this.getUsername().setText("@" + u.getNickname());

		Listadeusuarios(u);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilregistrado);
		});

	}

	public Verlistadeseguidosregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;
		basededatos.Usuario_Registrado usuarioActual = mds2.MainView.obtenerUsuarioActual();

		this.getNoFollowedMessage().setVisible(false);
		this.getUsername().setText("@" + usuarioActual.getNickname());

		Listadeusuarios(usuarioActual);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);
		});
	}

	public void Listadeusuarios(basededatos.Usuario_Registrado u) {
		_listadeusuarios = new Listadeusuarios(this, u);

		// Agregar la lista vacía al contenedor
		this.getFollowedListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}