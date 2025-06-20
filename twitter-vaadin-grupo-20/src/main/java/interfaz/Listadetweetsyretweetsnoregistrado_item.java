package interfaz;

public class Listadetweetsyretweetsnoregistrado_item extends Listadetweetsyretweets_item {

	public Verretweetnoregistrado _verretweetnoregistrado;
	public Vertweetnoregistrado _vertweetnoregistrado;
	private Listadetweetsyretweetsnoregistrado _parentList;

	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);
		if (_listadetweetsyretweets instanceof Listadetweetsyretweetsnoregistrado) {
			this._parentList = (Listadetweetsyretweetsnoregistrado) _listadetweetsyretweets;
		}
		// Ensamblado dinámico - ClickListeners para ver tweet/retweet
		setupClickListeners();
		setupTweetItemStyles();
	}

	private void setupClickListeners() {
		// Setup clickListeners para ver tweet completo
		this.getElement().addEventListener("click", e -> {
			// Navegar a la vista detalle del tweet
			Vertweetnoregistrado();
		});
	}
	
	private void setupTweetItemStyles() {
		// Configurar estilos para mostrar que el item es clickeable
		this.getElement().getStyle()
			.set("cursor", "pointer")
			.set("padding", "16px")
			.set("margin", "8px 0")
			.set("border", "1px solid #333")
			.set("border-radius", "8px")
			.set("background-color", "transparent")
			.set("transition", "all 0.2s ease")
			.set("color", "white");
			
		// Aplicar efectos hover usando JavaScript
		this.getElement().executeJs(
			"this.addEventListener('mouseenter', () => {" +
			"  this.style.backgroundColor = '#1a1a1a';" +
			"  this.style.borderColor = '#00FFFF';" +
			"  this.style.transform = 'translateY(-2px)';" +
			"  this.style.boxShadow = '0 4px 8px rgba(0, 255, 255, 0.2)';" +
			"});" +
			"this.addEventListener('mouseleave', () => {" +
			"  this.style.backgroundColor = 'transparent';" +
			"  this.style.borderColor = '#333';" +
			"  this.style.transform = 'translateY(0)';" +
			"  this.style.boxShadow = 'none';" +
			"});"
		);
	}

	public void Verretweetnoregistrado() {
		_verretweetnoregistrado = new Verretweetnoregistrado(this);
		navigateToTweetView(_verretweetnoregistrado);
	}

	public void Vertweetnoregistrado() {
		_vertweetnoregistrado = new Vertweetnoregistrado(this);
		navigateToTweetView(_vertweetnoregistrado);
	}
	
	private void navigateToTweetView(Object tweetView) {
		// Navegar a la vista de tweet usando el MainView
		if (_parentList != null && _parentList._verhashtagnoregistrado != null) {
			Verhashtagnoregistrado hashtagView = _parentList._verhashtagnoregistrado;
			
			if (hashtagView._usuarioNoRegistrado != null && 
				hashtagView._usuarioNoRegistrado._mainView != null) {
				hashtagView._usuarioNoRegistrado._mainView.removeAll();
				hashtagView._usuarioNoRegistrado._mainView.add((com.vaadin.flow.component.Component) tweetView);
			}
		}
	}
}