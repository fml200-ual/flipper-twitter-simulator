package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidosnoregistrado;

public class Verlistaseguidosnoregistrado extends VistaVerlistaseguidosnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;	public Verlistaseguidosnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;
		
		this.getNoFollowedMessageNoReg().setVisible(false);

		// Seguir metodología de diagramas de secuencia
		Cargar_Seguidos();
		// Configurar botón "Mostrar más seguidos"
		this.getShowMoreFollowedButtonNoReg().addClickListener(event -> {
			// Navegar a la lista completa de seguidos del usuario
			Pantalla.MainView.removeAll();
			Verlistaseguidosnoregistrado listaCompleta = new Verlistaseguidosnoregistrado(_verperfilnoregistrado);
			Pantalla.MainView.add(listaCompleta);
		});

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}	public void Cargar_Seguidos() {
		// Usar la lista de usuarios con el usuario específico - mismo patrón que versión registrada
		_listadeusuarios = new Listadeusuarios(this, _verperfilnoregistrado.u);
		this.getFollowedListContainerNoReg().as(VerticalLayout.class).add(_listadeusuarios);
	}

}