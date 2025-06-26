package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Comentario;
import basededatos.Tweet;

public class TweetRetwetadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador _listadecomentariosadministrador;

	public void Listadecomentariosadministrador(Tweet tweet) {
		_listadecomentariosadministrador = new Listadecomentariosadministrador(this);

		Comentario[] comentarios = tweet.tiene.toArray("fechaPublicacion", false);
		for (Comentario comentario : comentarios) {
			Listadecomentariosadministrador_item item = new Listadecomentariosadministrador_item(
					_listadecomentariosadministrador, comentario);
			_listadecomentariosadministrador.getMainContainer().as(VerticalLayout.class).add(item);
		}

		this.getContenedorComentarios().add(_listadecomentariosadministrador);
	}

	// ...dentro de TweetRetwetadministrador...

protected void configurarImagenPerfilPrincipal(basededatos.Usuario_Registrado usuario) {
    String fotoPerfilUrl = (usuario != null) ? usuario.getFotoPerfilURL() : null;
    boolean tieneFoto = fotoPerfilUrl != null && !fotoPerfilUrl.trim().isEmpty() &&
            !fotoPerfilUrl.equals("default-profile.jpg") && !fotoPerfilUrl.equals("null");
    if (tieneFoto) {
        this.getAvatarDivPrincipal().getStyle()
            .set("background-image", "url('" + fotoPerfilUrl + "')")
            .set("background-size", "cover")
            .set("background-position", "center")
            .set("background-repeat", "no-repeat");
        this.getImgAvatarPrincipal().getStyle().set("opacity", "0").set("pointer-events", "none");
    } else {
        this.getAvatarDivPrincipal().getStyle().set("background-image", "none");
        this.getImgAvatarPrincipal().setSrc("images/bird-avatar.svg");
        this.getImgAvatarPrincipal().setAlt("Avatar por defecto");
        this.getImgAvatarPrincipal().getStyle().set("opacity", "1").remove("pointer-events");
    }
}

protected void mostrarMultimediaTweet(basededatos.Tweet tweet) {
    try {
        if (tweet.getDocumento() != null &&
            tweet.getDocumento().getTipo() != null &&
            tweet.getDocumento().getImagenVideoURL() != null &&
            !tweet.getDocumento().getImagenVideoURL().trim().isEmpty()) {

            String tipoDocumento = tweet.getDocumento().getTipo();
            String url = tweet.getDocumento().getImagenVideoURL();

            System.out.println("Mostrando multimedia en tweet (admin) - Tipo: " + tipoDocumento + ", URL: " + url);

            com.vaadin.flow.component.html.Div multimediaContainer = new com.vaadin.flow.component.html.Div();
            multimediaContainer.getStyle()
                .set("margin-top", "10px")
                .set("border-radius", "12px")
                .set("overflow", "hidden")
                .set("border", "1px solid #444")
                .set("background-color", "#2D2D2D");

            if ("IMAGEN".equals(tipoDocumento)) {
                com.vaadin.flow.component.html.Image imagen = new com.vaadin.flow.component.html.Image(url, "Imagen del tweet");
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
            // Agregar el contenedor de multimedia al contenido del tweet principal
            try {
                this.getDivContenido().add(multimediaContainer);
            } catch (Exception e) {
                System.err.println("Error agregando multimedia al contenedor del tweet (admin): " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ Tweet sin multimedia o datos incompletos (admin)");
        }
    } catch (Exception e) {
        System.err.println("❌ Error mostrando multimedia del tweet (admin): " + e.getMessage());
        e.printStackTrace();
    }
}
}