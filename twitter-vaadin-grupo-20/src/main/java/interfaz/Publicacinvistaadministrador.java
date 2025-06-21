package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaPublicacinvistaadministrador;

public class Publicacinvistaadministrador extends VistaPublicacinvistaadministrador {
	// private event _eliminarpublicacin;

	public void Eliminarpublicacin() {
		throw new UnsupportedOperationException();
	}

	public void volver() {
		this.getBotonVolver().addClickListener(event -> {
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
	}
}