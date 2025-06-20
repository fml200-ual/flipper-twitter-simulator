package interfaz;

public class Verperfilnoregistrado extends Verperfil {
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado;
	public Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado;
	public Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado;	public Verperfilnoregistrado(Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado) {
		super();
		this._listafijadeusuariosnoregistrado = _listafijadeusuariosnoregistrado;
		// Ensamblado estático
		setupProfileForNonRegisteredUser();
		// Ensamblado dinámico - ClickListeners
		setupProfileClickListeners();
		setupBackButton();
		// Cargar contenido inicial
		initializeDefaultContent();
	}

	public Verperfilnoregistrado(Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado) {
		super();
		this._verlistaampliadadeusuariosnoregistrado = _verlistaampliadadeusuariosnoregistrado;
		// Ensamblado estático
		setupProfileForNonRegisteredUser();
		// Ensamblado dinámico - ClickListeners
		setupProfileClickListeners();
		setupBackButton();
		// Cargar contenido inicial
		initializeDefaultContent();
	}
		private void setupProfileForNonRegisteredUser() {
		// Ocultar botones de administración para usuarios no registrados
		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getEditAccountButton().setVisible(false);
		
		// Configurar información del perfil de ejemplo con datos más ricos
		this.getProfileName().setText("Usuario de Ejemplo");
		this.getProfileUsername().setText("@ejemplo_usuario");
		this.getDescription().setText("Esta es la descripción del perfil de un usuario no registrado. 🚀 Apasionado por la tecnología y el desarrollo de software. ✨ Siempre aprendiendo algo nuevo.");
		this.getFollowingCount().setText("👥 142 siguiendo");
		this.getFollowersCount().setText("👥 2.5K seguidores");
		this.getJoinDate().setText("📅 Se unió en junio de 2025");
		
		// Mejorar el aspecto visual del perfil
		this.getProfileName().getStyle()
			.set("font-size", "1.5em")
			.set("font-weight", "bold")
			.set("color", "#ffffff");
		
		this.getProfileUsername().getStyle()
			.set("color", "#888")
			.set("margin-bottom", "8px");
		
		this.getDescription().getStyle()
			.set("line-height", "1.4")
			.set("margin", "12px 0")
			.set("color", "#ffffff");
				// Estilizar los contadores para que se vean clickeables
		this.getFollowingCount().getStyle()
			.set("color", "#00ffff")
			.set("margin", "0 8px")
			.set("padding", "4px 8px")
			.set("border-radius", "4px")
			.set("transition", "background-color 0.2s");
		
		this.getFollowersCount().getStyle()
			.set("color", "#00ffff")
			.set("margin", "0 8px")
			.set("padding", "4px 8px")
			.set("border-radius", "4px")
			.set("transition", "background-color 0.2s");
		
		this.getJoinDate().getStyle().set("color", "#888");
	}
	
	private void setupBackButton() {
		this.getBackButton().addClickListener(event -> goBack());
	}
	
	private void goBack() {
		// Volver a la vista anterior (lista ampliada o vista principal)
		if (_verlistaampliadadeusuariosnoregistrado != null) {
			// Volver a la lista ampliada de usuarios
			_verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.removeAll();
			_verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.add(_verlistaampliadadeusuariosnoregistrado);
		} else if (_listafijadeusuariosnoregistrado != null && _listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado != null) {
			// Volver a la vista principal del usuario no registrado
			_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.removeAll();
			_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.add(_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado);
		}
	}	private void setupProfileClickListeners() {
		// Setup clickListeners para los tabs del perfil
		this.getUserTweetsTab().addClickListener(event -> showUserTweets());
		this.getLikedTweetsTab().addClickListener(event -> showLikedTweets());
		this.getRetweetsTab().addClickListener(event -> showRetweets());
		
		// Listener para mostrar más tweets
		this.getShowMoreButton().addClickListener(event -> showMoreTweets());
		
		// Listeners para seguidores y seguidos - usar addClickListener para mejor funcionalidad
		this.getFollowingCount().addClickListener(event -> showFollowing());
		this.getFollowersCount().addClickListener(event -> showFollowers());
		
		// Agregar estilos hover para indicar que son clickeables
		this.getFollowingCount().getStyle()
			.set("cursor", "pointer")
			.set("transition", "color 0.2s");
		this.getFollowersCount().getStyle()
			.set("cursor", "pointer")
			.set("transition", "color 0.2s");
	}
	
	private void showUserTweets() {
		// Activar tab de tweets del usuario
		setActiveTab("userTweets");
		loadUserTweetsContent();
	}
	
	private void showLikedTweets() {
		// Activar tab de tweets que le gustan
		setActiveTab("likedTweets");
		loadLikedTweetsContent();
	}
	
	private void showRetweets() {
		// Activar tab de retweets
		setActiveTab("retweets");
		loadRetweetsContent();
	}
	
	private void setActiveTab(String activeTab) {
		// Remover clase active de todos los tabs
		this.getUserTweetsTab().getElement().getClassList().remove("active");
		this.getLikedTweetsTab().getElement().getClassList().remove("active");
		this.getRetweetsTab().getElement().getClassList().remove("active");
		
		// Agregar clase active al tab seleccionado
		switch(activeTab) {
			case "userTweets":
				this.getUserTweetsTab().getElement().getClassList().add("active");
				break;
			case "likedTweets":
				this.getLikedTweetsTab().getElement().getClassList().add("active");
				break;
			case "retweets":
				this.getRetweetsTab().getElement().getClassList().add("active");
				break;
		}
	}
		private void loadUserTweetsContent() {
		// Limpiar contenido anterior
		this.getTweetsListLayout().removeAll();
		
		// Crear tweets de ejemplo del usuario
		createSampleTweet("Este es mi primer tweet desde mi perfil de ejemplo! 🎉", "2h");
		createSampleTweet("Explorando las funcionalidades de esta plataforma similar a Twitter 🚀", "5h");
		createSampleTweet("¡Qué buen día para compartir contenido! #BuenDia #Contenido", "1d");
		createSampleTweet("Trabajando en nuevos proyectos. ¿Alguna recomendación? 💻", "2d");
	}
	
	private void loadLikedTweetsContent() {
		// Limpiar contenido anterior
		this.getTweetsListLayout().removeAll();
		
		// Crear tweets que le gustan de ejemplo
		createSampleTweet("Me encanta este post sobre tecnología! 🤖 (Tweet que le gusta)", "3h");
		createSampleTweet("Excelente reflexión sobre el desarrollo de software 👨‍💻 (Tweet que le gusta)", "1d");
		createSampleTweet("Muy inspirador este mensaje motivacional ✨ (Tweet que le gusta)", "3d");
	}
	
	private void loadRetweetsContent() {
		// Limpiar contenido anterior
		this.getTweetsListLayout().removeAll();
		
		// Crear retweets de ejemplo
		createSampleTweet("🔄 RT: Increíble noticia sobre inteligencia artificial", "4h");
		createSampleTweet("🔄 RT: Tutorial muy útil sobre programación en Java", "1d");
		createSampleTweet("🔄 RT: Reflexiones sobre el futuro de la tecnología", "2d");
	}
	
	private void createSampleTweet(String content, String timeAgo) {
		// Crear un div contenedor para el tweet
		com.vaadin.flow.component.html.Div tweetContainer = new com.vaadin.flow.component.html.Div();
		tweetContainer.addClassName("tweet-container");
		tweetContainer.getStyle()
			.set("background-color", "#1a1a1a")
			.set("border", "1px solid #333")
			.set("border-radius", "12px")
			.set("padding", "16px")
			.set("margin-bottom", "12px")
			.set("color", "white");
		
		// Header del tweet (usuario y tiempo)
		com.vaadin.flow.component.html.Div tweetHeader = new com.vaadin.flow.component.html.Div();
		tweetHeader.getStyle()
			.set("display", "flex")
			.set("align-items", "center")
			.set("margin-bottom", "8px");
		
		com.vaadin.flow.component.html.Span userName = new com.vaadin.flow.component.html.Span("Usuario de Ejemplo");
		userName.getStyle()
			.set("font-weight", "bold")
			.set("color", "#00ffff")
			.set("margin-right", "8px");
		
		com.vaadin.flow.component.html.Span userHandle = new com.vaadin.flow.component.html.Span("@ejemplo_usuario");
		userHandle.getStyle()
			.set("color", "#888")
			.set("margin-right", "8px");
		
		com.vaadin.flow.component.html.Span tweetTime = new com.vaadin.flow.component.html.Span("· " + timeAgo);
		tweetTime.getStyle().set("color", "#888");
		
		tweetHeader.add(userName, userHandle, tweetTime);
		
		// Contenido del tweet
		com.vaadin.flow.component.html.Div tweetContent = new com.vaadin.flow.component.html.Div();
		tweetContent.setText(content);
		tweetContent.getStyle()
			.set("line-height", "1.4")
			.set("margin-bottom", "12px");
		
		// Acciones del tweet (like, retweet, etc.)
		com.vaadin.flow.component.html.Div tweetActions = new com.vaadin.flow.component.html.Div();
		tweetActions.getStyle()
			.set("display", "flex")
			.set("justify-content", "space-around")
			.set("color", "#888")
			.set("font-size", "14px");
		
		com.vaadin.flow.component.html.Span commentAction = new com.vaadin.flow.component.html.Span("💬 12");
		com.vaadin.flow.component.html.Span retweetAction = new com.vaadin.flow.component.html.Span("🔄 8");
		com.vaadin.flow.component.html.Span likeAction = new com.vaadin.flow.component.html.Span("❤️ 45");
		com.vaadin.flow.component.html.Span shareAction = new com.vaadin.flow.component.html.Span("📤");
		
		tweetActions.add(commentAction, retweetAction, likeAction, shareAction);
		
		// Ensamblar el tweet completo
		tweetContainer.add(tweetHeader, tweetContent, tweetActions);
		
		// Agregar al layout de tweets
		this.getTweetsListLayout().add(tweetContainer);
	}
		private void showMoreTweets() {
		// Determinar qué tipo de contenido cargar basado en el tab activo
		if (this.getUserTweetsTab().getElement().getClassList().contains("active")) {
			loadMoreUserTweets();
		} else if (this.getLikedTweetsTab().getElement().getClassList().contains("active")) {
			loadMoreLikedTweets();
		} else if (this.getRetweetsTab().getElement().getClassList().contains("active")) {
			loadMoreRetweets();
		} else {
			// Por defecto, cargar más tweets del usuario
			loadMoreUserTweets();
		}
	}
	
	private void loadMoreUserTweets() {
		// Agregar más tweets del usuario
		createSampleTweet("Compartiendo una reflexión del día de hoy 🤔", "3d");
		createSampleTweet("¿Alguien más está emocionado por las nuevas tecnologías? 🔥", "4d");
		createSampleTweet("Recordatorio: siempre hay que seguir aprendiendo 📚", "5d");
		createSampleTweet("Buen fin de semana para todos! 🌟", "1w");
	}
	
	private void loadMoreLikedTweets() {
		// Agregar más tweets que le gustan
		createSampleTweet("Increíble artículo sobre innovación 🚀 (Tweet que le gusta)", "4d");
		createSampleTweet("Muy buena explicación sobre algoritmos 🧮 (Tweet que le gusta)", "5d");
		createSampleTweet("Post motivacional que alegra el día ☀️ (Tweet que le gusta)", "1w");
	}
	
	private void loadMoreRetweets() {
		// Agregar más retweets
		createSampleTweet("🔄 RT: Excelente hilo sobre buenas prácticas de programación", "4d");
		createSampleTweet("🔄 RT: Datos interesantes sobre el crecimiento tecnológico", "6d");
		createSampleTweet("🔄 RT: Reflexión profunda sobre el trabajo en equipo", "1w");
	}
	
	private void showFollowing() {
		// Navegar a la lista de seguidos
		Verlistaseguidosnoregistrado();
	}
	
	private void showFollowers() {
		// Navegar a la lista de seguidores
		Verlistaseguidoresnoregistrado();
	}	public void Verlistaseguidoresnoregistrado() {
		_verlistaseguidoresnoregistrado = new Verlistaseguidoresnoregistrado(this);
		// Navegación by MainView - considerar múltiples contextos
		if (_listafijadeusuariosnoregistrado != null && _listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado != null) {
			_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.removeAll();
			_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.add(_verlistaseguidoresnoregistrado);
		} else if (_verlistaampliadadeusuariosnoregistrado != null && _verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado != null) {
			_verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.removeAll();
			_verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.add(_verlistaseguidoresnoregistrado);
		}
	}

	public void Verlistaseguidosnoregistrado() {
		_verlistaseguidosnoregistrado = new Verlistaseguidosnoregistrado(this);
		// Navegación by MainView - considerar múltiples contextos
		if (_listafijadeusuariosnoregistrado != null && _listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado != null) {
			_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.removeAll();
			_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.add(_verlistaseguidosnoregistrado);
		} else if (_verlistaampliadadeusuariosnoregistrado != null && _verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado != null) {
			_verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.removeAll();
			_verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.add(_verlistaseguidosnoregistrado);
		}
	}
	
	private void initializeDefaultContent() {
		// Configurar el tab de tweets del usuario como activo por defecto
		setActiveTab("userTweets");
		// Cargar contenido inicial de tweets del usuario
		loadUserTweetsContent();
	}
}