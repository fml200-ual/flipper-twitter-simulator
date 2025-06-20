package interfaz;

public class Listadetweetsyretweetsnoregistrado extends Listadetweetsyretweets {
	public Verhashtagnoregistrado _verhashtagnoregistrado;

	public Listadetweetsyretweetsnoregistrado(Verhashtagnoregistrado _verhashtagnoregistrado) {
		super();
		this._verhashtagnoregistrado = _verhashtagnoregistrado;
		// Ensamblado estático y dinámico de tweets
		ListatweetsretweetsNR();
	}
	public void ListatweetsretweetsNR() {
		// Configurar el contenedor principal con estilos apropiados
		this.addAttachListener(e -> {
			if (this.getMainContainer() != null) {
				// Aplicar estilos al contenedor principal
				this.getMainContainer().getStyle()
					.set("background-color", "transparent")
					.set("padding", "0")
					.set("width", "100%")
					.set("display", "flex")
					.set("flex-direction", "column")
					.set("gap", "15px");
			}
		});
		
		// Crear tweets de ejemplo para el hashtag con navegabilidad
		createNavigableTweet("@tech_guru", "Este #Hashtag está revolucionando la tecnología! 🚀", "2h");
		createNavigableTweet("@design_pro", "Increíble diseño relacionado con #Hashtag 🎨", "4h");
		createNavigableTweet("@code_master", "Implementando nuevas funcionalidades para #Hashtag 💻", "6h");
	}
		public void addMoreTweets() {
		// Agregar más tweets dinámicamente cuando se hace clic en "Mostrar más"
		String[] newTweets = {
			"@data_scientist|Análisis de datos sobre #Hashtag es fascinante 📊|8h",
			"@ui_designer|Nueva interfaz inspirada en #Hashtag ✨|10h",
			"@fullstack_dev|Backend y frontend perfectos para #Hashtag 🔧|12h",
			"@mobile_dev|App móvil optimizada para #Hashtag 📱|14h"
		};
		
		for (String tweetData : newTweets) {
			String[] parts = tweetData.split("\\|");
			createNavigableTweet(parts[0], parts[1], parts[2]);
		}
		
		// Aplicar scroll suave hacia los nuevos elementos
		this.getElement().executeJs("this.scrollIntoView({behavior: 'smooth', block: 'end'});");
	}
		private void createNavigableTweet(String username, String content, String time) {
		// Crear item de tweet navegable
		Listadetweetsyretweetsnoregistrado_item tweetItem = new Listadetweetsyretweetsnoregistrado_item(this);
		
		// Configurar el tweet con datos específicos
		setupTweetData(tweetItem, username, content, time);
		
		// Hacer el tweet clickeable para navegar a la vista detalle
		setupTweetClickability(tweetItem, username, content);
		
		// Agregar el item al contenedor principal
		this.addAttachListener(e -> {
			if (this.getMainContainer() != null) {
				this.getMainContainer().appendChild(tweetItem.getElement());
			}
		});
		
		// También agregar al vector de items para gestión
		this._item.add(tweetItem);
	}
		private void setupTweetData(Listadetweetsyretweetsnoregistrado_item tweetItem, String username, String content, String time) {
		// Configurar datos del tweet en el item usando atributos
		tweetItem.getElement().setAttribute("data-username", username);
		tweetItem.getElement().setAttribute("data-content", content);
		tweetItem.getElement().setAttribute("data-time", time);
		
		// Actualizar el contenido visual del tweet llamando al método TypeScript
		tweetItem.updateTweetContent(username, content, time);
	}
	
	private void setupTweetClickability(Listadetweetsyretweetsnoregistrado_item tweetItem, String username, String content) {
		// Hacer el tweet clickeable
		tweetItem.getElement().addEventListener("click", e -> {
			// Navegar a la vista detalle del tweet
			navigateToTweetDetail(username, content);
		});
		
		// Aplicar estilos de interactividad
		tweetItem.getElement().getStyle()
			.set("cursor", "pointer")
			.set("transition", "all 0.2s ease")
			.set("border-radius", "8px")
			.set("padding", "12px")
			.set("margin", "8px 0")
			.set("border", "1px solid #333");
			
		// Aplicar efectos hover
		tweetItem.getElement().executeJs(
			"this.addEventListener('mouseenter', () => {" +
			"  this.style.backgroundColor = '#1a1a1a';" +
			"  this.style.borderColor = '#00FFFF';" +
			"  this.style.transform = 'translateY(-2px)';" +
			"});" +
			"this.addEventListener('mouseleave', () => {" +
			"  this.style.backgroundColor = 'transparent';" +
			"  this.style.borderColor = '#333';" +
			"  this.style.transform = 'translateY(0)';" +
			"});"
		);
	}
		private void navigateToTweetDetail(String username, String content) {
		// Navegar a la vista detalle del tweet
		// Crear instancia de vista de tweet para usuario no registrado
		if (_verhashtagnoregistrado != null) {
			// Crear nueva instancia de vista de tweet
			Listadetweetsyretweetsnoregistrado_item tweetItem = new Listadetweetsyretweetsnoregistrado_item(this);
			Vertweetnoregistrado vistaDetalleTweet = new Vertweetnoregistrado(tweetItem);
			
			// Configurar el contenido del tweet con los datos pasados
			vistaDetalleTweet.addAttachListener(e -> {
				if (vistaDetalleTweet.getNombreUsuario() != null) {
					vistaDetalleTweet.getNombreUsuario().setText("Usuario");
				}
				if (vistaDetalleTweet.getArrobaUsuario() != null) {
					vistaDetalleTweet.getArrobaUsuario().setText(username);
				}
				if (vistaDetalleTweet.getTextoPublicacion() != null) {
					vistaDetalleTweet.getTextoPublicacion().setText(content);
				}
			});
			
			// Navegar usando el contexto correcto
			if (_verhashtagnoregistrado._usuarioNoRegistrado != null && 
				_verhashtagnoregistrado._usuarioNoRegistrado._mainView != null) {
				_verhashtagnoregistrado._usuarioNoRegistrado._mainView.removeAll();
				_verhashtagnoregistrado._usuarioNoRegistrado._mainView.add(vistaDetalleTweet);
			}
		}
	}
}