package interfaz;
import mds2.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ACT03Administrador extends ACT06SesinIniciada {
	

	public Listafijadetweetsadministrador _listafijadetweetsadministrador;

	public ACT03Administrador(MainView MainView) {
		super(MainView);
		this.getBotonPerfilPropioRegistrado().setVisible(false);
		this.getVerticalLayoutListaUsuarios().setVisible(false);
		this.getBotonMasUsuarios().setVisible(false);
		this.getVerticalLayoutImagenRegistrado().setVisible(false);
		this.getSpanRecomendadoParaTi().setVisible(false);
		this.getBotonEscribirTweet().setVisible(false);
		this.getVerticalLayoutDerechoSesionIniciada().setVisible(false);
		// Ensamblado de componentes fijos
		Listafijadetweetsadministrador();
	}
	
	public void Listafijadetweetsadministrador() {
		_listafijadetweetsadministrador = new Listafijadetweetsadministrador(this);
		this.getVerticalLayoutCentralSesionIniciada().as(VerticalLayout.class).add(_listafijadetweetsadministrador);
	}
}