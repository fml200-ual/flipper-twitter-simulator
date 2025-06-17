package interfaz;

import com.vaadin.flow.component.button.Button;
import mds2.MainView.Pantalla;

public class Vertweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;

	public Vertweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador) {
		super();
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;

		this.getLayoutPublicacionCitada().setVisible(false);

		// Añadir botón de regreso
		addBackButton();
		this.Listadecomentariosadministrador();

		this.getAvatarDivPrincipal().addClickListener(event -> {
			Verperfiladministrador();
		});
	}

	protected void addBackButton() {
		Button backButton = new Button("← Volver", event -> {
			// Navegar directamente a ACT03Administrador
			Pantalla.MainView.removeAll();

			// Verificar si la vista anterior es ACT03Administrador para reutilizarla
			if (Pantalla.Anterior instanceof ACT03Administrador) {
				ACT03Administrador admin = (ACT03Administrador) Pantalla.Anterior;
				// Recargar la lista de tweets para reflejar posibles cambios
				if (admin._listafijadetweetsadministrador != null) {
					admin._listafijadetweetsadministrador.recargarTweets();
				}
				Pantalla.MainView.add(admin);
			} else if (Pantalla.Anterior instanceof Verlistaampliadadetweetsadministrador) {
				// Si venimos de la vista ampliada, también recargar
				Verlistaampliadadetweetsadministrador vistaAmpliada = (Verlistaampliadadetweetsadministrador) Pantalla.Anterior;
				vistaAmpliada.Listadetweetsyretweetsadministrador();
				Pantalla.MainView.add(vistaAmpliada);
			} else {
				// En cualquier otro caso, crear nueva instancia de ACT03Administrador
				try {
					ACT03Administrador admin = new ACT03Administrador(null);
					if (admin._listafijadetweetsadministrador != null) {
						admin._listafijadetweetsadministrador.recargarTweets();
					}
					Pantalla.MainView.add(admin);
				} catch (Exception e) {
					// Si falla, usar la vista anterior como respaldo
					Pantalla.MainView.add(Pantalla.Anterior != null ? Pantalla.Anterior : new ACT03Administrador(null));
				}
			}
		});
		if (this.getContenedorPrincipal() != null) {
			this.getContenedorPrincipal().add(backButton);
		}
	}

	public void Verperfiladministrador() {
		_verperfiladministrador = new Verperfiladministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfiladministrador);
	}
}