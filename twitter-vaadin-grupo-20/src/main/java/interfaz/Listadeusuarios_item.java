package interfaz;

import com.vaadin.flow.component.html.Image;

import vistas.VistaListadeusuarios_item;
import basededatos.Usuario_Registrado;
import basededatos.BDPrincipal;

public class Listadeusuarios_item extends VistaListadeusuarios_item {
	public Listadeusuarios _listadeusuarios;
	public Verperfilnoregistrado _verperfilnoregistrado;

	public Usuario_Registrado u; // Hacer público para acceso desde otras clases

	public Listadeusuarios_item(Listadeusuarios _listadeusuarios, Usuario_Registrado u) {
		super();
		this._listadeusuarios = _listadeusuarios;
		this.u = u;

		// Poblar la interfaz con datos del usuario si están disponibles
		if (u != null) {
			actualizarDatosUsuario();
		} else {
			// Mostrar datos por defecto si no hay usuario
			mostrarDatosPorDefecto();
		}

	}

	private void actualizarDatosUsuario() {
		// Actualizar nickname
		if (u.getNickname() != null) {
			this.getNickName().setText(u.getNickname());
		}

		// Actualizar descripción
		if (u.getDescripcion() != null && !u.getDescripcion().trim().isEmpty()) {
			this.getDescriptionText().setText(u.getDescripcion());
		} else {
			this.getDescriptionText().setText("Sin descripción");
		}

		// Actualizar foto de perfil si hay URL
		if (u.getFotoPerfilURL() != null && !u.getFotoPerfilURL().trim().isEmpty()) {
			try {
				// Reemplazar el icono por defecto con una imagen real
				Image img = new Image(u.getFotoPerfilURL(), "Foto de perfil");
				img.setWidth("32px");
				img.setHeight("32px");
				img.getStyle().set("border-radius", "50%"); // Hacer circular

				// Reemplazar el icono de avatar con la imagen
				this.getAvatarIcon().getParent().ifPresent(parent -> {
					parent.getElement().removeChild(this.getAvatarIcon().getElement());
					parent.getElement().appendChild(img.getElement());
				});
			} catch (Exception e) {
				// Si hay error con la imagen, mantener el icono por defecto
				System.err.println("Error cargando imagen de perfil: " + e.getMessage());
			}
		}

		// Actualizar número de seguidores desde la base de datos
		try {
			BDPrincipal bd = new BDPrincipal();
			int numSeguidores = bd.contarSeguidores(u.getId_usuario());
			
			// Formatear el número de seguidores de manera amigable
			String seguidoresTexto;
			if (numSeguidores >= 1000000) {
				double seguidoresM = numSeguidores / 1000000.0;
				seguidoresTexto = String.format("%.1fM", seguidoresM);
			} else if (numSeguidores >= 1000) {
				double seguidoresK = numSeguidores / 1000.0;
				seguidoresTexto = String.format("%.1fK", seguidoresK);
			} else {
				seguidoresTexto = String.valueOf(numSeguidores);
			}
			
			this.getFollowersCount().setText(seguidoresTexto);
			System.out.println("Usuario " + u.getNickname() + " tiene " + numSeguidores + " seguidores");
		} catch (Exception e) {
			System.err.println("Error obteniendo número de seguidores para " + u.getNickname() + ": " + e.getMessage());
			this.getFollowersCount().setText("0");
		}
	}

	private void mostrarDatosPorDefecto() {
		this.getNickName().setText("Usuario");
		this.getDescriptionText().setText("Sin datos disponibles");
		this.getFollowersCount().setText("0");
	}

	public void Mostrarmsusuarios() {
		// TODO: POSIBLEMNTE ELIMPLENTAR ESTE MÉTODO EN LA CLASE
		// Método legacy mantenido por compatibilidad
	}
}