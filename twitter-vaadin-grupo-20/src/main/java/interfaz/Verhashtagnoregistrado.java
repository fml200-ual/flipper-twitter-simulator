package interfaz;

public class Verhashtagnoregistrado extends Verhashtag {
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;
	public Listadetweetsyretweetsnoregistrado _listadetweetsyretweetsnoregistrado;
	public ACT01UsuarioNoRegistrado _usuarioNoRegistrado;
	public Verhashtagnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado, ACT01UsuarioNoRegistrado usuarioNoRegistrado) {
		super();
		this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;
		this._usuarioNoRegistrado = usuarioNoRegistrado;
		// Ensamblado estático de componentes fijos
		setupStaticHashtagView();
		// Ensamblado dinámico de contenido
		Listadetweetsyretweetsnoregistrado();
		setupHashtagView();
		setupShowMoreButton();
	}
	public Verhashtagnoregistrado(Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado, ACT01UsuarioNoRegistrado usuarioNoRegistrado) {
		super();
		this._verlistaampliadadehashtagsnoregistrado = _verlistaampliadadehashtagsnoregistrado;
		this._usuarioNoRegistrado = usuarioNoRegistrado;
		// Ensamblado estático de componentes fijos
		setupStaticHashtagView();
		// Ensamblado dinámico de contenido
		Listadetweetsyretweetsnoregistrado();
		setupHashtagView();
		setupShowMoreButton();
	}
		private void setupStaticHashtagView() {
		// Configurar elementos estáticos de la vista hashtag
		this.addAttachListener(e -> {
			// Configurar título del hashtag
			if (this.getH1() != null) {
				this.getH1().setText("#Hashtag");
				this.getH1().getStyle()
					.set("color", "#00FFFF")
					.set("font-size", "2em")
					.set("font-weight", "bold")
					.set("text-align", "center")
					.set("margin", "20px 0");
			}
			
			// Configurar botón "Mostrar más" si existe
			if (this.getShowMoreButton() != null) {
				this.getShowMoreButton().getStyle()
					.set("background-color", "#00FFFF")
					.set("color", "black")
					.set("border-radius", "20px")
					.set("padding", "10px 20px")
					.set("font-weight", "bold")
					.set("cursor", "pointer")
					.set("border", "none")
					.set("transition", "all 0.2s ease");
			}
		});
	}
	
	private void setupShowMoreButton() {
		// Configurar botón "Mostrar más" para cargar más tweets dinámicamente
		this.addAttachListener(e -> {
			if (this.getShowMoreButton() != null) {
				this.getShowMoreButton().addClickListener(event -> loadMoreTweets());
			}
		});
	}
	
	private void loadMoreTweets() {
		// Cargar más tweets dinámicamente
		if (_listadetweetsyretweetsnoregistrado != null) {
			_listadetweetsyretweetsnoregistrado.addMoreTweets();
		}
	}private void setupHashtagView() {
		// Configurar vista de hashtag para usuario no registrado
		// Ocultar acciones que requieren login
		
		// Configurar botón de volver - usar addAttachListener para asegurar que el botón esté disponible
		this.addAttachListener(e -> {
			if (this.getVolverButton() != null && _usuarioNoRegistrado != null) {
				this.getVolverButton().addClickListener(event -> goBack());
			}
		});
	}
	
	private void goBack() {
		// Volver a la vista principal de usuario no registrado
		if (_usuarioNoRegistrado != null && _usuarioNoRegistrado._mainView != null) {
			_usuarioNoRegistrado._mainView.removeAll();
			_usuarioNoRegistrado._mainView.add(_usuarioNoRegistrado);
		}
	}
	public void Listadetweetsyretweetsnoregistrado() {
		_listadetweetsyretweetsnoregistrado = new Listadetweetsyretweetsnoregistrado(this);
		
		// Agregar lista al layout cuando esté disponible
		this.addAttachListener(e -> {
			if (this.getMainLayout() != null) {
				// Agregar la lista de tweets al main layout
				this.getMainLayout().appendChild(_listadetweetsyretweetsnoregistrado.getElement());
			}
		});
	}
}