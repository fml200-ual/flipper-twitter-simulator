package interfaz;

import vistas.VistaVerperfil;

public class Verperfil extends VistaVerperfil {
	public Agrupartweets _agrupartweets;
	public Agrupartweetsgustados _agrupartweetsgustados;
	public Agruparretweets _agruparretweets;

	public void Agrupartweets(basededatos.Usuario_Registrado o) {
		_agrupartweets = new Agrupartweets(this, o);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agrupartweets);
	}

	public void Agrupartweetsgustados(basededatos.Usuario_Registrado o) {
		_agrupartweetsgustados = new Agrupartweetsgustados(this, o);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agrupartweetsgustados);
	}

	public void Agruparretweets(basededatos.Usuario_Registrado o) {
		_agruparretweets = new Agruparretweets(this, o);
		this.getTweetsListLayout().removeAll();
		this.getTweetsListLayout().add(_agruparretweets);
	}

	/**
	 * Método protegido para configurar las imágenes de perfil y banner
	 * Puede ser usado por todas las clases hijas (Verperfilregistrado, Verpropioperfil, etc.)
	 */
	protected void configurarImagenesPerfil(basededatos.Usuario_Registrado usuario) {
		try {
			if (usuario != null) {
				// Configurar imagen de fondo/banner
				String imagenFondoURL = usuario.getImagenFondoURL();
				if (imagenFondoURL != null && !imagenFondoURL.trim().isEmpty() && 
					!imagenFondoURL.equals("default-background.jpg")) {
					// Configurar como imagen de fondo real
					this.getCoverPhoto().getStyle()
						.set("background-image", "url('" + imagenFondoURL + "')")
						.set("background-size", "cover")
						.set("background-position", "center")
						.set("background-repeat", "no-repeat");
					this.getCoverPhoto().setText(""); // Quitar la "X" placeholder
				} else {
					// Usar imagen por defecto o placeholder
					this.getCoverPhoto().getStyle()
						.set("background-image", "linear-gradient(135deg, #667eea 0%, #764ba2 100%)")
						.set("background-size", "cover");
					this.getCoverPhoto().setText("📷"); // Icono de cámara como placeholder
				}

				// Configurar imagen de perfil/avatar
				String fotoPerfilURL = usuario.getFotoPerfilURL();
				if (fotoPerfilURL != null && !fotoPerfilURL.trim().isEmpty() && 
					!fotoPerfilURL.equals("default-profile.jpg")) {
					// Configurar como imagen de perfil real
					this.getProfilePicture().getStyle()
						.set("background-image", "url('" + fotoPerfilURL + "')")
						.set("background-size", "cover")
						.set("background-position", "center")
						.set("background-repeat", "no-repeat")
						.set("border-radius", "50%"); // Hacer circular
					this.getProfilePicture().setText(""); // Quitar la "X" placeholder
				} else {
					// Usar avatar por defecto
					this.getProfilePicture().getStyle()
						.set("background-image", "linear-gradient(135deg, #00FFFF 0%, #0080FF 100%)")
						.set("background-size", "cover")
						.set("border-radius", "50%");
					this.getProfilePicture().setText("👤"); // Icono de usuario como placeholder
				}

				System.out.println("Imágenes de perfil configuradas para usuario: " + usuario.getNickname());
			}
		} catch (Exception e) {
			System.err.println("Error configurando imágenes de perfil: " + e.getMessage());
			// En caso de error, usar estilos por defecto
			this.getCoverPhoto().getStyle()
				.set("background-image", "linear-gradient(135deg, #667eea 0%, #764ba2 100%)")
				.set("background-size", "cover");
			this.getCoverPhoto().setText("📷");
			
			this.getProfilePicture().getStyle()
				.set("background-image", "linear-gradient(135deg, #00FFFF 0%, #0080FF 100%)")
				.set("background-size", "cover")
				.set("border-radius", "50%");
			this.getProfilePicture().setText("👤");
		}
	}

}