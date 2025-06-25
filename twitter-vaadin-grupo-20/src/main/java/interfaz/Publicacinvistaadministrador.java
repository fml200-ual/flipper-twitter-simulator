package interfaz;

import mds2.MainView.Pantalla;
import mds2.MainView.Usuario;
import vistas.VistaPublicacinvistaadministrador;

public class Publicacinvistaadministrador extends VistaPublicacinvistaadministrador {
	// Variables para identificar qué eliminar

	public void Eliminarpublicacin(Object publicacionActual) {
		if (publicacionActual instanceof basededatos.Tweet) {
			basededatos.Tweet tweet = (basededatos.Tweet) publicacionActual;
			if (tweet.getTweet_retweeteado() != null) {
				System.out.println("Eliminando retweet ID: " + tweet.getId_tweet());
				Usuario.iAdministrador.eliminarTweet(tweet.getId_tweet());
			} else {
				System.out.println("Eliminando tweet ID: " + tweet.getId_tweet());
				Usuario.iAdministrador.eliminarTweet(tweet.getId_tweet());
			}
		} else if (publicacionActual instanceof basededatos.Comentario) {
			basededatos.Comentario comentario = (basededatos.Comentario) publicacionActual;
			System.out.println("Eliminando comentario ID: " + comentario.getId_comentario());
			Usuario.iAdministrador.eliminarComentario(comentario.getId_comentario());
		}
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(new ACT03Administrador(Pantalla.MainView));
	}

	public void volver() {
		this.getBotonVolver().addClickListener(event -> {
			// Navegar directamente a ACT03Administrador
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT03Administrador(Pantalla.MainView));
		});
	}
}