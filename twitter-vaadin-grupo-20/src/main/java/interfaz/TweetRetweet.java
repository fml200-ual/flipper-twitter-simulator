package interfaz;

import vistas.VistaTweetretweet;

public class TweetRetweet extends VistaTweetretweet {
	
	/**
	 * Configurar imagen de perfil del usuario principal usando la misma técnica exitosa de los perfiles
	 */
	public void configurarImagenPerfilPrincipal(basededatos.Usuario_Registrado usuario) {
		String fotoPerfilUrl = (usuario != null) ? usuario.getFotoPerfilURL() : null;
		boolean tieneFoto = fotoPerfilUrl != null && !fotoPerfilUrl.trim().isEmpty() &&
				!fotoPerfilUrl.equals("default-profile.jpg") && !fotoPerfilUrl.equals("null");
		if (tieneFoto) {
			this.getDivAvatar().getStyle()
				.set("background-image", "url('" + fotoPerfilUrl + "')")
				.set("background-size", "cover")
				.set("background-position", "center")
				.set("background-repeat", "no-repeat");
			this.getImg().getStyle().set("opacity", "0").set("pointer-events", "none");
		} else {
			this.getDivAvatar().getStyle().set("background-image", "none");
			this.getImg().setSrc("images/bird-avatar.svg");
			this.getImg().setAlt("Avatar por defecto");
			this.getImg().getStyle().set("opacity", "1").remove("pointer-events");
		}
	}
	
	/**
	 * Configurar imagen de perfil del usuario citado usando la misma técnica exitosa de los perfiles
	 */
	public void configurarImagenPerfilCitado(basededatos.Usuario_Registrado usuarioCitado) {
		String fotoPerfilCitadoUrl = (usuarioCitado != null) ? usuarioCitado.getFotoPerfilURL() : null;
		boolean tieneFoto = fotoPerfilCitadoUrl != null && !fotoPerfilCitadoUrl.trim().isEmpty() &&
				!fotoPerfilCitadoUrl.equals("default-profile.jpg") && !fotoPerfilCitadoUrl.equals("null");
		if (tieneFoto) {
			this.getDiv().getStyle()
				.set("background-image", "url('" + fotoPerfilCitadoUrl + "')")
				.set("background-size", "cover")
				.set("background-position", "center")
				.set("background-repeat", "no-repeat");
			this.getImg1().getStyle().set("opacity", "0").set("pointer-events", "none");
		} else {
			this.getDiv().getStyle().set("background-image", "none");
			this.getImg1().setSrc("images/bird-avatar.svg");
			this.getImg1().setAlt("Avatar por defecto citado");
			this.getImg1().getStyle().set("opacity", "1").remove("pointer-events");
		}
	}
	
	/**
	 * Configurar imagen por defecto para usuario principal
	 */
	protected void configurarImagenPorDefectoPrincipal() {
		this.getDivAvatar().getStyle().set("background-image", "none");
		this.getImg().setSrc("images/bird-avatar.svg");
		this.getImg().setAlt("Avatar por defecto");
		this.getImg().getStyle().set("opacity", "1").remove("pointer-events");
	}
	
	/**
	 * Configurar imagen por defecto para usuario citado
	 */
	protected void configurarImagenPorDefectoCitado() {
		this.getDiv().getStyle().set("background-image", "none");
		this.getImg1().setSrc("images/bird-avatar.svg");
		this.getImg1().setAlt("Avatar por defecto citado");
		this.getImg1().getStyle().set("opacity", "1").remove("pointer-events");
	}
	
	/**
	 * Mostrar multimedia (imagen/video) si el tweet lo contiene
	 * Basado en la implementación exitosa de Listadetweetsyretweets_item
	 */
	protected void mostrarMultimediaTweet(basededatos.Tweet tweet) {
		try {
			// Verificar si el tweet tiene un documento asociado con multimedia
			if (tweet.getDocumento() != null && 
				tweet.getDocumento().getTipo() != null && 
				tweet.getDocumento().getImagenVideoURL() != null && 
				!tweet.getDocumento().getImagenVideoURL().trim().isEmpty()) {
				
				String tipoDocumento = tweet.getDocumento().getTipo();
				String url = tweet.getDocumento().getImagenVideoURL();
				
				System.out.println("Mostrando multimedia en tweet - Tipo: " + tipoDocumento + ", URL: " + url);
				
				// Crear contenedor para el multimedia
				com.vaadin.flow.component.html.Div multimediaContainer = new com.vaadin.flow.component.html.Div();
				multimediaContainer.getStyle()
					.set("margin-top", "10px")
					.set("border-radius", "12px")
					.set("overflow", "hidden")
					.set("border", "1px solid #444")
					.set("background-color", "#2D2D2D");
				
				if ("IMAGEN".equals(tipoDocumento)) {
					// Mostrar imagen
					com.vaadin.flow.component.html.Image imagen = new com.vaadin.flow.component.html.Image(url, "Imagen del tweet");
					imagen.getStyle()
						.set("width", "100%")
						.set("max-width", "500px")
						.set("height", "auto")
						.set("border-radius", "12px")
						.set("cursor", "pointer");
					
					// Hacer clic para ver imagen en grande (opcional)
					imagen.addClickListener(event -> {
						System.out.println("Clic en imagen: " + url);
					});
					
					multimediaContainer.add(imagen);
					
				} else if ("VIDEO".equals(tipoDocumento)) {
					// Mostrar video
					if (url.contains("embed")) {
						// Video embebido (YouTube, Vimeo, etc.)
						com.vaadin.flow.component.html.IFrame videoFrame = new com.vaadin.flow.component.html.IFrame(url);
						videoFrame.getStyle()
							.set("width", "100%")
							.set("max-width", "500px")
							.set("height", "280px")
							.set("border", "none")
							.set("border-radius", "12px");
						multimediaContainer.add(videoFrame);
					} else {
						// Video directo (MP4, etc.)
						com.vaadin.flow.component.html.Div videoContainer = new com.vaadin.flow.component.html.Div();
						videoContainer.getElement().setProperty("innerHTML", 
							"<video controls style='width: 100%; max-width: 500px; border-radius: 12px;'>" +
							"<source src='" + url + "' type='video/mp4'>" +
							"Tu navegador no soporta el elemento video." +
							"</video>");
						multimediaContainer.add(videoContainer);
					}
				}
				
				// Agregar el contenedor de multimedia al contenido del tweet
				try {
					this.getContenidoTweet().add(multimediaContainer);
				} catch (Exception e) {
					System.err.println("Error agregando multimedia al contenedor del tweet: " + e.getMessage());
				}
			} else {
				System.out.println("⚠️ Tweet sin multimedia o datos incompletos");
			}
		} catch (Exception e) {
			System.err.println("❌ Error mostrando multimedia del tweet: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Mostrar multimedia (imagen/video) si el comentario lo contiene
	 */
	public static void mostrarMultimediaComentario(com.vaadin.flow.component.Component contenedor, basededatos.Comentario comentario) {
		try {
			if (comentario.getDocumento() != null &&
				comentario.getDocumento().getTipo() != null &&
				comentario.getDocumento().getImagenVideoURL() != null &&
				!comentario.getDocumento().getImagenVideoURL().trim().isEmpty()) {

				String tipoDocumento = comentario.getDocumento().getTipo();
				String url = comentario.getDocumento().getImagenVideoURL();

				System.out.println("Mostrando multimedia en comentario - Tipo: " + tipoDocumento + ", URL: " + url);

				com.vaadin.flow.component.html.Div multimediaContainer = new com.vaadin.flow.component.html.Div();
				multimediaContainer.getStyle()
					.set("margin-top", "10px")
					.set("border-radius", "12px")
					.set("overflow", "hidden")
					.set("border", "1px solid #444")
					.set("background-color", "#2D2D2D");

				if ("IMAGEN".equals(tipoDocumento)) {
					com.vaadin.flow.component.html.Image imagen = new com.vaadin.flow.component.html.Image(url, "Imagen del comentario");
					imagen.getStyle()
						.set("width", "100%")
						.set("max-width", "500px")
						.set("height", "auto")
						.set("border-radius", "12px")
						.set("cursor", "pointer");
					imagen.addClickListener(event -> {
						System.out.println("Clic en imagen: " + url);
					});
					multimediaContainer.add(imagen);
				} else if ("VIDEO".equals(tipoDocumento)) {
					if (url.contains("embed")) {
						com.vaadin.flow.component.html.IFrame videoFrame = new com.vaadin.flow.component.html.IFrame(url);
						videoFrame.getStyle()
							.set("width", "100%")
							.set("max-width", "500px")
							.set("height", "280px")
							.set("border", "none")
							.set("border-radius", "12px");
						multimediaContainer.add(videoFrame);
					} else {
						com.vaadin.flow.component.html.Div videoContainer = new com.vaadin.flow.component.html.Div();
						videoContainer.getElement().setProperty("innerHTML",
							"<video controls style='width: 100%; max-width: 500px; border-radius: 12px;'>" +
							"<source src='" + url + "' type='video/mp4'>" +
							"Tu navegador no soporta el elemento video." +
							"</video>");
						multimediaContainer.add(videoContainer);
					}
				}
				// Agregar el contenedor de multimedia al contenedor del comentario
				if (contenedor instanceof com.vaadin.flow.component.orderedlayout.VerticalLayout) {
					((com.vaadin.flow.component.orderedlayout.VerticalLayout) contenedor).add(multimediaContainer);
				} else if (contenedor instanceof com.vaadin.flow.component.html.Div) {
					((com.vaadin.flow.component.html.Div) contenedor).add(multimediaContainer);
				} else {
					contenedor.getElement().appendChild(multimediaContainer.getElement());
				}
			} else {
				System.out.println("⚠️ Comentario sin multimedia o datos incompletos");
			}
		} catch (Exception e) {
			System.err.println("❌ Error mostrando multimedia del comentario: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
