package interfaz;

import mds2.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ACT03Administrador extends ACT06SesinIniciada {

	public Listafijadetweetsadministrador _listafijadetweetsadministrador;

	// Administrador no necesita objeto ORMPersistable porque no tiene relaciones
	// con otros datos en BD

	public ACT03Administrador(MainView MainView) {
		super(MainView);
		this.getBotonPerfilPropioRegistrado().setVisible(false);
		this.getVerticalLayoutListaUsuarios().setVisible(false);
		this.getBotonMasUsuarios().setVisible(false);
		this.getVerticalLayoutImagenRegistrado().setVisible(false);
		this.getSpanRecomendadoParaTi().setVisible(false);
		this.getBotonEscribirTweet().setVisible(false);
		this.getVerticalLayoutCentralSesionIniciada().setVisible(false);
		this.getBotonNotificacionesRegistrado().setVisible(false);

		this.getBotonMasHashtags().setText("Mostrar mas");

		Listafijadetweetsadministrador();

		this.getBotonMasHashtags().addClickListener(event -> {
			_listafijadetweetsadministrador.Verlistaampliadadetweetsadministrador();
		});

		this.getBotonCerrarSesionPrimerBoton().addClickListener(event -> {
			this.Cerrarsesin();
		});
	}

	public void Listafijadetweetsadministrador() {
		_listafijadetweetsadministrador = new Listafijadetweetsadministrador(this);
		this.getVerticalLayoutListaHashtagsSesionIniciada().as(VerticalLayout.class)
				.add(_listafijadetweetsadministrador);
	}
}