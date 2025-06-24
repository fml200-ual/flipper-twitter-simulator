package interfaz;

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

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilregistrado);
		});
	}

	public Verlistadeseguidoresregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;

		this.getNoFollowersMessage().setVisible(false);

		Listadeusuarios();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);
		});
	}	public void Listadeusuarios() {
		_listadeusuarios = new Listadeusuarios(this);
		
		// TEMPORAL: Eliminar toda la carga de usuarios para depurar
		System.out.println("=== DEPURACIÓN: No cargando usuarios (seguidores) ===");
		
		// Mostrar mensaje de no hay seguidores por ahora
		this.getNoFollowersMessage().setVisible(true);
		this.getNoFollowersMessage().setText("DEPURACIÓN: Lista vacía intencionalmente");
		
		// Agregar la lista vacía al contenedor
		this.getFollowersListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}