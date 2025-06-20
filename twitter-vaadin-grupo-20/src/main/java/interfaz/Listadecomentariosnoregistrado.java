package interfaz;

public class Listadecomentariosnoregistrado extends Listadecomentarios {
	public TweetRetweetnoregistrado _tweetRetweetnoregistrado;

	public Listadecomentariosnoregistrado(TweetRetweetnoregistrado _tweetRetweetnoregistrado) {
		super();
		this._tweetRetweetnoregistrado = _tweetRetweetnoregistrado;
		// Ensamblado de componentes fijos
		ListacomentariosNR();
	}

	public void ListacomentariosNR() {
		// Crear lista de comentarios items para usuario no registrado
		createInitialComments();
	}
	
	private void createInitialComments() {
		// Crear comentarios de ejemplo
		createComment("@user1", "¡Excelente tweet! Me encanta este tema. 👍", "5m");
		createComment("@developer", "Totalmente de acuerdo, muy interesante análisis.", "10m");
		createComment("@tech_fan", "Gracias por compartir esta información tan valiosa.", "15m");
	}
	
	private void createComment(String username, String content, String time) {
		// Crear un comentario individual
		Listadecomentariosnoregistrado_item commentItem = new Listadecomentariosnoregistrado_item(this);
		
		// Configurar el contenido del comentario
		commentItem.addAttachListener(e -> {
			// Aplicar estilos y contenido al comentario
			commentItem.getElement().getStyle()
				.set("background-color", "#1a1a1a")
				.set("border", "1px solid #333")
				.set("border-radius", "8px")
				.set("padding", "12px")
				.set("margin", "8px 0")
				.set("color", "white");
				
			// Configurar el contenido usando executeJs
			commentItem.getElement().executeJs(
				"this.querySelector('.username').textContent = $0;" +
				"this.querySelector('.content').textContent = $1;" +
				"this.querySelector('.time').textContent = $2;",
				username, content, time
			);
		});
				// Agregar al layout cuando esté disponible
		this.addAttachListener(e -> {
			if (this.getMainContainer() != null) {
				this.getMainContainer().appendChild(commentItem.getElement());
			}
		});
	}
	
	public void addMoreComments() {
		// Agregar más comentarios dinámicamente
		createComment("@new_user", "Muy buen punto de vista, no lo había pensado así.", "2m");
		createComment("@expert", "Esto debería ser tendencia. Compartiendo! 🔄", "4m");
		createComment("@reader", "Me ayudó mucho este tweet, gracias por la explicación.", "6m");
	}
}