package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistadeseguidoresregistrado;

public class Verlistadeseguidoresregistrado extends VistaVerlistadeseguidoresregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;

	public Verlistadeseguidoresregistrado(Verperfilregistrado verperfilregistrado, basededatos.Usuario_Registrado u) {
		this._verperfilregistrado = verperfilregistrado;

		this.getNoFollowersMessage().setVisible(false);
		this.getUsername().setText("@" + u.getNickname());

		Listadeusuarios(u);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilregistrado);
		});
	}

	public Verlistadeseguidoresregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;
		basededatos.Usuario_Registrado usuarioActual = mds2.MainView.obtenerUsuarioActual();

		this.getNoFollowersMessage().setVisible(false);
		this.getUsername().setText("@" + usuarioActual.getNickname());

		Listadeusuarios(usuarioActual);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);
		});
	}

	public void Listadeusuarios(basededatos.Usuario_Registrado usuario) {
		_listadeusuarios = new Listadeusuarios(this, usuario);

		this.getFollowersListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}