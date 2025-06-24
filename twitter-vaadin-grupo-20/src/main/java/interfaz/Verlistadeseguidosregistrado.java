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
	}	public void Listadeusuarios() {
		_listadeusuarios = new Listadeusuarios(this);
		
		// TEMPORAL: Eliminar toda la carga de usuarios para depurar
		System.out.println("=== DEPURACIÓN: No cargando usuarios ===");
		
		// Mostrar mensaje de no hay seguidos por ahora
		this.getNoFollowedMessage().setVisible(true);
		this.getNoFollowedMessage().setText("DEPURACIÓN: Lista vacía intencionalmente");
		
		// Agregar la lista vacía al contenedor
		this.getFollowedListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}