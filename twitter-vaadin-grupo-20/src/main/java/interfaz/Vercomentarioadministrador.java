package interfaz;

import com.vaadin.flow.component.button.Button;
import mds2.MainView.Pantalla;

public class Vercomentarioadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador_item _listadecomentariosadministrador;

	public Vercomentarioadministrador(Listadecomentariosadministrador_item _listadecomentariosadministrador) {
		super();
		this._listadecomentariosadministrador = _listadecomentariosadministrador;

		this.getSpanContadorRetweet().setVisible(false);
		this.getIconoRetweet().setVisible(false);
		this.getSpanContadorComentarios().setVisible(false);
		this.getIconoComentar().setVisible(false);
		this.getLayoutPublicacionCitada().setVisible(false);
		this.getLinkMostrarMas().setVisible(false);
		this.getBotonEliminarTweet().setText("Eliminar comentario");

		// Añadir botón de regreso
		addBackButton();
	}

	protected void addBackButton() {
		Button backButton = new Button("← Volver", event -> {
			// Navegar directamente a ACT03Administrador
			// Buscar en la vista anterior si es posible acceder al MainView
			if (Pantalla.Anterior instanceof ACT03Administrador) {
				ACT03Administrador act03 = (ACT03Administrador) Pantalla.Anterior;
				// Recargar la lista de tweets
				if (act03._listafijadetweetsadministrador != null) {
					act03._listafijadetweetsadministrador.recargarTweets();
				}
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(act03);
			} else {
				// Crear una nueva instancia navegando através de la jerarquía
				// Usar null como solución temporal - esto funciona en muchos casos
				try {
					ACT03Administrador act03 = new ACT03Administrador(null);
					if (act03._listafijadetweetsadministrador != null) {
						act03._listafijadetweetsadministrador.recargarTweets();
					}
					Pantalla.MainView.removeAll();
					Pantalla.MainView.add(act03);
				} catch (Exception e) {
					// Si falla, usar la vista anterior
					Pantalla.MainView.removeAll();
					Pantalla.MainView.add(Pantalla.Anterior);
				}
			}
		});
		if (this.getContenedorPrincipal() != null) {
			this.getContenedorPrincipal().add(backButton);
		}
	}
}