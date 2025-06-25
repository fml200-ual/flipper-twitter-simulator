package interfaz;

import java.util.Arrays;
import java.util.Vector;
import java.util.Comparator;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.PropiedadesSeguidos;
import basededatos.Retweet;
import basededatos.Tweet;
import mds2.MainView.Usuario;
import vistas.VistaListadenotificaciones;

public class Listadenotificaciones extends VistaListadenotificaciones {
	public Vernotificacionesderetweets _vernotificacionesderetweets;
	public Vernotificacionesdemenciones _vernotificacionesdemenciones;
	public Vernotificacionesseguimiento _vernotificacionesseguimiento;
	public Vector<Listadenotificaciones_item> _item = new Vector<Listadenotificaciones_item>();

	public Listadenotificaciones(Vernotificacionesderetweets _vernotificacionesderetweets) {
		super();
		this._vernotificacionesderetweets = _vernotificacionesderetweets;

		try {
			// Usar la base de datos para obtener los tweets con los retweets cargados
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado usuarioActualizado = bd
					.obtenerUsuarioByID(Usuario.usuarioRegistrado.getId_usuario());

			// Usar el usuario actualizado en lugar del usuario estático para acceder a
			// tweets
			Tweet[] tweets = usuarioActualizado.tweets.toArray();
			for (int i = 0; i < tweets.length; i++) {
				Retweet[] rt = tweets[i].retweets.toArray();
				Arrays.sort(rt, Comparator.comparing(Retweet::getFechaPublicacion));
				for (int j = 0; j < rt.length; j++) {
					basededatos.Usuario_Registrado usuarioQueHaceRT = rt[j].getUsuario_Registrado(); // Corregido:
					// rt[j] en
					// lugar de
					// rt[i]
					Listadenotificaciones_item item = new Listadenotificaciones_item(this);
					item.getDescriptionLabel()
							.setText("@" + usuarioQueHaceRT.getNickname() + " ha hecho retweet a uno de tus tweets");

					this.getMainContainer().as(VerticalLayout.class).add(item);
				}
			}
		} catch (Exception e) {
			System.err.println("Error al cargar notificaciones de retweets: " +
					e.getMessage());
			e.printStackTrace();
		}
	}

	public Listadenotificaciones(Vernotificacionesdemenciones _vernotificacionesdemenciones) {
		super();
		this._vernotificacionesdemenciones = _vernotificacionesdemenciones;

		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado usuarioActualizado = bd
					.obtenerUsuarioByID(Usuario.usuarioRegistrado.getId_usuario());

			Tweet[] menciones = usuarioActualizado.getMencionado_enTweets();
			Arrays.sort(menciones, Comparator.comparing(Tweet::getFechaPublicacion));
			for (int i = 0; i < menciones.length; i++) {
				Listadenotificaciones_item item = new Listadenotificaciones_item(this);
				item.getDescriptionLabel().setText("@" + menciones[i].getPublicado_por().getNickname() +
						" te ha mencionado en un tweet: " + menciones[i].getContenidoTweet());
				this.getMainContainer().as(VerticalLayout.class).add(item);
			}
		} catch (Exception e) {
			System.err.println("Error al cargar notificaciones de menciones: " +
					e.getMessage());
			e.printStackTrace();
		}

	}

	public Listadenotificaciones(Vernotificacionesseguimiento _vernotificacionesseguimiento) {
		super();
		this._vernotificacionesseguimiento = _vernotificacionesseguimiento;

		basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
		basededatos.Usuario_Registrado usuarioActualizado = bd
				.obtenerUsuarioByID(Usuario.usuarioRegistrado.getId_usuario());

		PropiedadesSeguidos[] seguidos = usuarioActualizado.seguidoresPropiedadesseguidoss.toArray();
		Arrays.sort(seguidos, Comparator.comparing(PropiedadesSeguidos::getFecha));
		for (int i = 0; i < seguidos.length; i++) {
			basededatos.Usuario_Registrado usuarioQueSigue = seguidos[i].getSeguidoresUsuario_registrado();
			Listadenotificaciones_item item = new Listadenotificaciones_item(this);
			item.getDescriptionLabel().setText("@" + usuarioQueSigue.getNickname() +
					" ha comenzado a seguirte el " + seguidos[i].getFecha());
			this.getMainContainer().as(VerticalLayout.class).add(item);
		}

	}

}