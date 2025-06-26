package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;
import basededatos.BD_Usuario_Registrado;
import basededatos.Usuario_Registrado;
import org.orm.PersistentException;
import com.vaadin.flow.component.notification.Notification;

public class Vercomentarioregistrado extends Vercomentario {
	public Listadecomentariosregistrado_item _listadecomentariosregistrado;
	private BD_Usuario_Registrado bdUsuario = new BD_Usuario_Registrado();
	private boolean yaLeGusta = false;

	public Vercomentarioregistrado(Listadecomentariosregistrado_item _listadecomentariosregistrado) {
		super(_listadecomentariosregistrado != null ? _listadecomentariosregistrado.c : null);
		this._listadecomentariosregistrado = _listadecomentariosregistrado;

		this.getDeleteCommentButton().setVisible(false);

		// Configurar botón de volver
		this.getBackButton().addClickListener(event -> {
			if (Pantalla.Anterior != null) {
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(Pantalla.Anterior);
			} else {
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(new ACT02UsuarioRegistrado(Pantalla.MainView, MainView.Usuario.usuarioRegistrado));
			}
		});

		// Configurar botón de me gusta
		this.getCommentLikeButton().addClickListener(event -> {
			if (yaLeGusta) {
				Eliminarmegusta();
			} else {
				Darmegusta();
			}
		});

		// Verificar si ya le gusta este comentario y actualizar datos
		actualizarEstadoMeGusta();
		actualizarContadores();
	}

	public void Darmegusta() {
		try {
			Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();
			if (usuarioActual != null && c != null) {
				bdUsuario.darMeGustaComentario(usuarioActual.getId_usuario(), c.getId_comentario());
				yaLeGusta = true;
				actualizarUIBotonMeGusta();
				actualizarContadores();
				
				// Notificar éxito
				Notification.show("¡Te gusta este comentario!", 2000, Notification.Position.BOTTOM_CENTER);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
			Notification.show("Error al dar me gusta", 3000, Notification.Position.BOTTOM_CENTER);
		}
	}

	public void Eliminarmegusta() {
		try {
			Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();
			if (usuarioActual != null && c != null) {
				bdUsuario.eliminarMgComentario(usuarioActual.getId_usuario(), c.getId_comentario());
				yaLeGusta = false;
				actualizarUIBotonMeGusta();
				actualizarContadores();
				
				// Notificar éxito
				Notification.show("Ya no te gusta este comentario", 2000, Notification.Position.BOTTOM_CENTER);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
			Notification.show("Error al eliminar me gusta", 3000, Notification.Position.BOTTOM_CENTER);
		}
	}
	private void actualizarEstadoMeGusta() {
		try {
			Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();
			if (usuarioActual != null && c != null) {
				// Verificar usando método que no depende de colecciones lazy
				yaLeGusta = bdUsuario.yaLeGustaComentario(usuarioActual.getId_usuario(), c.getId_comentario());
				actualizarUIBotonMeGusta();
			}
		} catch (Exception e) {
			e.printStackTrace();
			yaLeGusta = false; // Valor por defecto en caso de error
			actualizarUIBotonMeGusta();
		}
	}

	private void actualizarUIBotonMeGusta() {
		if (yaLeGusta) {
			this.getCommentLikeButton().getStyle().set("color", "#e0245e"); // Rojo filled
		} else {
			this.getCommentLikeButton().getStyle().set("color", "#8899a6"); // Gris outline
		}
	}
	private void actualizarContadores() {
		if (c != null) {
			try {
				// Usar BD para obtener los contadores de forma segura
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				int numMeGusta = bd.contarLikesComentario(c.getId_comentario());
				this.getCommentLikeCount().setText(String.valueOf(numMeGusta));
				
				// Actualizar también en el item padre si existe
				if (_listadecomentariosregistrado != null) {
					// TODO: Implementar actualizarContadores en el item padre
					// _listadecomentariosregistrado.actualizarContadores();
				}
			} catch (Exception e) {
				System.err.println("Error actualizando contadores del comentario: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}