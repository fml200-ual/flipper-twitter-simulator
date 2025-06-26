package interfaz;

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

		// Configurar imagen de perfil/avatar
		configurarImagenPerfil();

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

	private void configurarImagenPerfil() {
		try {
			if (u != null && u.getFotoPerfilURL() != null && !u.getFotoPerfilURL().trim().isEmpty() && 
				!u.getFotoPerfilURL().equals("default-profile.jpg")) {
				
				// Configurar como imagen de perfil real usando CSS background
				this.getAvatarIcon().getStyle()
					.set("background-image", "url('" + u.getFotoPerfilURL() + "')")
					.set("background-size", "cover")
					.set("background-position", "center")
					.set("background-repeat", "no-repeat")
					.set("border-radius", "50%")
					.set("border", "2px solid #00FFFF")
					.set("width", "40px")
					.set("height", "40px");
				
				// Ocultar completamente el icono de vaadin
				this.getAvatarIcon().getElement().removeAttribute("icon");
				this.getAvatarIcon().getElement().setProperty("innerHTML", "");
				this.getAvatarIcon().getElement().getStyle()
					.set("--vaadin-icon-width", "0px")
					.set("--vaadin-icon-height", "0px")
					.set("color", "transparent");
				
				System.out.println("Imagen de perfil configurada para usuario: " + u.getNickname() + " con URL: " + u.getFotoPerfilURL());
			} else {
				// Usar icono por defecto
				this.getAvatarIcon().getElement().setAttribute("icon", "vaadin:user");
				this.getAvatarIcon().getStyle()
					.set("background-image", "none")
					.set("color", "#00FFFF")
					.set("width", "40px")
					.set("height", "40px");
				this.getAvatarIcon().getElement().getStyle()
					.set("--vaadin-icon-width", "24px")
					.set("--vaadin-icon-height", "24px");
				System.out.println("Usando icono por defecto para usuario: " + (u != null ? u.getNickname() : "desconocido"));
			}
		} catch (Exception e) {
			System.err.println("Error configurando imagen de perfil: " + e.getMessage());
			// En caso de error, usar icono por defecto
			this.getAvatarIcon().getElement().setAttribute("icon", "vaadin:user");
			this.getAvatarIcon().getStyle()
				.set("background-image", "none")
				.set("color", "#00FFFF")
				.set("width", "40px")
				.set("height", "40px");
			this.getAvatarIcon().getElement().getStyle()
				.set("--vaadin-icon-width", "24px")
				.set("--vaadin-icon-height", "24px");
		}
	}

	public void Mostrarmsusuarios() {
		// TODO: POSIBLEMNTE ELIMPLENTAR ESTE MÉTODO EN LA CLASE
		// Método legacy mantenido por compatibilidad
	}
}