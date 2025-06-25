package interfaz;

import vistas.VistaEscribirgeneral;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;

public class Escribirgeneral extends VistaEscribirgeneral {
	
	// Variables para almacenar multimedia
	protected String urlMultimedia = "";
	protected String tipoDocumento = null;
	
	// Contenedor para mostrar preview
	protected VerticalLayout previewContainer;
	
	public Escribirgeneral() {
		super();
		inicializarComponentesMultimedia();
	}
	
	/**
	 * Inicializar componentes y eventos de multimedia
	 */
	private void inicializarComponentesMultimedia() {
		// Configurar contenedor de preview
		previewContainer = new VerticalLayout();
		previewContainer.setSpacing(true);
		previewContainer.setPadding(false);
		previewContainer.setVisible(false);
		
		// Agregar el contenedor al layout principal después del footer
		try {
			// Agregar después del área de texto
			this.getDialogContent().appendChild(previewContainer.getElement());
		} catch (Exception e) {
			System.err.println("No se pudo agregar el contenedor de preview: " + e.getMessage());
		}
		
		// Configurar eventos de los iconos
		configurarEventosIconos();
	}
	
	/**
	 * Configurar eventos para los iconos de multimedia
	 */
	private void configurarEventosIconos() {
		// Evento para agregar imagen
		this.getCameraIcon().addClickListener(event -> {
			IntroducirURLfoto();
		});
		
		// Evento para agregar video
		this.getPlayIcon().addClickListener(event -> {
			IntroducirURLvdeo();
		});
	}

	/**
	 * Método para introducir URL de imagen
	 */
	public void IntroducirURLfoto() {
		abrirDialogoURL("Agregar Imagen", 
			"URL de la imagen (JPG, PNG, GIF, WebP)", 
			"https://ejemplo.com/imagen.jpg",
			"IMAGEN");
	}

	/**
	 * Método para introducir URL de video
	 */
	public void IntroducirURLvdeo() {
		abrirDialogoURL("Agregar Video", 
			"URL del video (YouTube embed, MP4, etc.)", 
			"https://www.youtube.com/embed/VIDEO_ID",
			"VIDEO");
	}
	
	/**
	 * Método unificado para abrir diálogo de URL
	 */
	private void abrirDialogoURL(String titulo, String etiqueta, String placeholder, String tipo) {
		Dialog dialog = new Dialog();
		dialog.setWidth("500px");
		dialog.setHeight("300px");
		
		// Configurar para que aparezca en primer plano
		dialog.setModal(false);
		dialog.setDraggable(true);
		dialog.setResizable(false);
		dialog.setCloseOnEsc(true);
		dialog.setCloseOnOutsideClick(true);
		
		// Asegurar que aparezca por encima de otros elementos
		dialog.getElement().getStyle().set("z-index", "10000");
		dialog.getElement().setAttribute("aria-modal", "true");
		
		// Título
		Div titleDiv = new Div();
		titleDiv.setText(titulo);
		titleDiv.getStyle()
			.set("font-weight", "bold")
			.set("font-size", "18px")
			.set("margin-bottom", "15px")
			.set("color", "#1da1f2");
		
		// Campo de URL
		TextField urlField = new TextField(etiqueta);
		urlField.setPlaceholder(placeholder);
		urlField.setWidth("100%");
		urlField.getStyle().set("margin-bottom", "10px");
		
		// Información de ayuda
		Div helpText = new Div();
		if (tipo.equals("IMAGEN")) {
			helpText.setText("💡 Sube tu imagen a Imgur, ImageBB o usa enlaces directos (.jpg, .png, .gif, .webp)");
		} else {
			helpText.setText("💡 Para YouTube: usa el formato embed (https://www.youtube.com/embed/VIDEO_ID)");
		}
		helpText.getStyle()
			.set("font-size", "12px")
			.set("color", "#657786")
			.set("margin-bottom", "15px")
			.set("padding", "8px")
			.set("background-color", "#f7f9fa")
			.set("border-radius", "4px");
		
		// Botones
		Button agregarButton = new Button("Agregar", event -> {
			String url = urlField.getValue().trim();
			if (validarYAgregarURL(url, tipo)) {
				dialog.close();
			}
		});
		agregarButton.getStyle()
			.set("background-color", "#1da1f2")
			.set("color", "white")
			.set("border", "none")
			.set("border-radius", "20px")
			.set("padding", "8px 16px");
		
		Button cancelarButton = new Button("Cancelar", event -> dialog.close());
		cancelarButton.getStyle()
			.set("background-color", "#657786")
			.set("color", "white")
			.set("border", "none")
			.set("border-radius", "20px")
			.set("padding", "8px 16px");
		
		HorizontalLayout buttonsLayout = new HorizontalLayout(agregarButton, cancelarButton);
		buttonsLayout.setSpacing(true);
		
		VerticalLayout dialogLayout = new VerticalLayout(titleDiv, urlField, helpText, buttonsLayout);
		dialogLayout.setPadding(true);
		dialogLayout.setSpacing(true);
		
		dialog.add(dialogLayout);
		dialog.open();
	}
	
	/**
	 * Validar y agregar URL multimedia
	 */
	private boolean validarYAgregarURL(String url, String tipoEsperado) {
		if (url == null || url.trim().isEmpty()) {
			mostrarNotificacion("Por favor ingresa una URL", "error");
			return false;
		}
		
		// Detectar tipo automáticamente basado en la URL
		String tipoDetectado = detectarTipoDocumento(url);
		
		if (tipoDetectado == null) {
			mostrarNotificacion("URL no válida. Verifica el formato del enlace", "error");
			return false;
		}
		
		// Limpiar multimedia anterior si existe
		limpiarMultimedia();
		
		// Guardar nueva multimedia
		this.urlMultimedia = url;
		this.tipoDocumento = tipoDetectado;
		
		// Mostrar preview
		mostrarPreview(url, tipoDetectado);
		
		String tipoTexto = tipoDetectado.equals("VIDEO") ? "video" : "imagen";
		mostrarNotificacion(tipoTexto.substring(0,1).toUpperCase() + tipoTexto.substring(1) + " agregada exitosamente", "success");
		
		return true;
	}
	
	/**
	 * Detectar tipo de documento basado en la URL (siguiendo la lógica del proyecto)
	 */
	private String detectarTipoDocumento(String url) {
		if (url == null || url.trim().isEmpty()) {
			return null;
		}
		
		url = url.toLowerCase();
		
		// Si contiene "embed" es un video (YouTube, Vimeo embebido)
		if (url.contains("embed")) {
			return "VIDEO";
		}
		
		// Videos por extensión
		if (url.endsWith(".mp4") || url.endsWith(".avi") || url.endsWith(".mov") || 
			url.endsWith(".webm") || url.endsWith(".mkv") || url.endsWith(".wmv")) {
			return "VIDEO";
		}
		
		// Videos de plataformas conocidas
		if (url.contains("youtube.com") || url.contains("youtu.be") || 
			url.contains("vimeo.com") || url.contains("dailymotion.com")) {
			return "VIDEO";
		}
		
		// Imágenes por extensión
		if (url.endsWith(".jpg") || url.endsWith(".jpeg") || url.endsWith(".png") || 
			url.endsWith(".gif") || url.endsWith(".webp") || url.endsWith(".bmp")) {
			return "IMAGEN";
		}
		
		// URLs que probablemente sean imágenes
		if (url.contains("imgur.com") || url.contains("imagebb.com") || 
			url.contains("unsplash.com") || url.contains("images.")) {
			return "IMAGEN";
		}
		
		// Por defecto, asumir que es imagen si empieza con http
		if (url.startsWith("http")) {
			return "IMAGEN";
		}
		
		return null;
	}
	
	/**
	 * Mostrar preview del multimedia
	 */
	private void mostrarPreview(String url, String tipo) {
		previewContainer.removeAll();
		
		// Asegurar que el contenedor esté agregado al DOM
		try {
			if (previewContainer.getParent().isEmpty()) {
				this.getDialogContent().appendChild(previewContainer.getElement());
			}
		} catch (Exception e) {
			System.err.println("Error agregando contenedor de preview: " + e.getMessage());
		}
		
		if (tipo.equals("IMAGEN")) {
			mostrarPreviewImagen(url);
		} else if (tipo.equals("VIDEO")) {
			mostrarPreviewVideo(url);
		}
		
		previewContainer.setVisible(true);
	}
	
	/**
	 * Mostrar preview de imagen
	 */
	private void mostrarPreviewImagen(String url) {
		Div container = crearContenedorPreview("🖼️ Imagen agregada");
		
		try {
			Image image = new Image(url, "Preview imagen");
			image.getStyle()
				.set("max-width", "200px")
				.set("max-height", "150px")
				.set("border-radius", "8px")
				.set("margin-top", "10px");
			container.add(image);
		} catch (Exception e) {
			Div urlInfo = new Div();
			urlInfo.setText("URL: " + url);
			urlInfo.getStyle().set("font-size", "12px").set("color", "#657786");
			container.add(urlInfo);
		}
		
		previewContainer.add(container);
	}
	
	/**
	 * Mostrar preview de video
	 */
	private void mostrarPreviewVideo(String url) {
		Div container = crearContenedorPreview("🎥 Video agregado");
		
		if (url.contains("embed")) {
			try {
				IFrame videoFrame = new IFrame(url);
				videoFrame.getStyle()
					.set("width", "300px")
					.set("height", "200px")
					.set("border-radius", "8px")
					.set("margin-top", "10px");
				container.add(videoFrame);
			} catch (Exception e) {
				Div urlInfo = new Div();
				urlInfo.setText("URL: " + url);
				urlInfo.getStyle().set("font-size", "12px").set("color", "#657786");
				container.add(urlInfo);
			}
		} else {
			Div urlInfo = new Div();
			urlInfo.setText("URL: " + url);
			urlInfo.getStyle().set("font-size", "12px").set("color", "#657786");
			container.add(urlInfo);
		}
		
		previewContainer.add(container);
	}
	
	/**
	 * Crear contenedor base para preview
	 */
	private Div crearContenedorPreview(String titulo) {
		Div container = new Div();
		container.getStyle()
			.set("border", "1px solid #e1e8ed")
			.set("border-radius", "12px")
			.set("padding", "15px")
			.set("background-color", "#f7f9fa")
			.set("margin", "10px 0");
		
		Div header = new Div();
		header.getStyle()
			.set("display", "flex")
			.set("justify-content", "space-between")
			.set("align-items", "center")
			.set("margin-bottom", "5px");
		
		Div titleDiv = new Div();
		titleDiv.setText(titulo);
		titleDiv.getStyle()
			.set("font-weight", "bold")
			.set("color", "#1da1f2");
		
		Button removeButton = new Button("×");
		removeButton.getStyle()
			.set("background", "#ff4444")
			.set("color", "white")
			.set("border", "none")
			.set("border-radius", "50%")
			.set("width", "25px")
			.set("height", "25px")
			.set("cursor", "pointer")
			.set("font-weight", "bold");
		
		removeButton.addClickListener(event -> limpiarMultimedia());
		
		header.add(titleDiv, removeButton);
		container.add(header);
		
		return container;
	}

	/**
	 * Método para previsualizar multimedia (mantener compatibilidad)
	 */
	public void Previsualizarmultimedia() {
		if (urlMultimedia != null && !urlMultimedia.trim().isEmpty()) {
			mostrarPreview(urlMultimedia, tipoDocumento);
		} else {
			mostrarNotificacion("No hay multimedia para previsualizar", "info");
		}
	}
	
	/**
	 * Limpiar multimedia
	 */
	protected void limpiarMultimedia() {
		urlMultimedia = "";
		tipoDocumento = null;
		previewContainer.removeAll();
		previewContainer.setVisible(false);
	}
	
	/**
	 * Obtener URL de multimedia para usar en publicación
	 */
	public String getURLMultimedia() {
		return urlMultimedia != null && !urlMultimedia.trim().isEmpty() ? urlMultimedia : null;
	}
	
	/**
	 * Obtener tipo de documento para usar en publicación
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	/**
	 * Verificar si hay multimedia agregada
	 */
	public boolean tieneMultimedia() {
		return urlMultimedia != null && !urlMultimedia.trim().isEmpty();
	}
	
	/**
	 * Mostrar notificación
	 */
	private void mostrarNotificacion(String mensaje, String tipo) {
		Notification.Position position = Notification.Position.BOTTOM_CENTER;
		int duration = 3000;
		
		if (tipo.equals("error")) {
			duration = 4000;
			position = Notification.Position.MIDDLE;
		}
		
		Notification.show(mensaje, duration, position);
	}
}