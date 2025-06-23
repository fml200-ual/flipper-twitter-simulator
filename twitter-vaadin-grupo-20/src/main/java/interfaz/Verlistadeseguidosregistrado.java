package interfaz;

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

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilregistrado);
		});
	}

	public Verlistadeseguidosregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;

		this.getNoFollowedMessage().setVisible(false);

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);
		});
	}

	public void Listadeusuarios() {
		_listadeusuarios = new Listadeusuarios(this);
		for (int i = 0; i < 5; i++) {
			Listadeusuarios_item item = new Listadeusuarios_item(_listadeusuarios, null);

			item.getMainContainer().addClickListener(event -> {
				Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
				Pantalla.MainView.removeAll();

				if (_verperfilregistrado != null) {
					Pantalla.MainView.add(_verperfilregistrado);
				} else {
					Pantalla.MainView.add(new Verperfilregistrado(
							_verpropioperfil._aCT02UsuarioRegistrado._listafijadeusuariosregistrado));
				}
			});

			_listadeusuarios.getMainContainer().as(VerticalLayout.class)
					.add(item);
		}
		this.getFollowedListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}