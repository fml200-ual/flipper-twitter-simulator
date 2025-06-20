package interfaz;

public class Listadecomentariosnoregistrado_item extends Listadecomentarios_item {

	public Vercomentarionoregistrado _vercomentarionoregistrado;

	public Listadecomentariosnoregistrado_item(Listadecomentarios _listadecomentarios) {
		super(_listadecomentarios);
		// Ensamblado dinámico - ClickListener para ver comentario
		setupCommentClickListener();
	}

	private void setupCommentClickListener() {
		// Setup clickListener para ver comentario específico
		// Se conectará cuando tengamos acceso al botón de la vista
	}
	public void Vercomentarionoregistrado() {
		_vercomentarionoregistrado = new Vercomentarionoregistrado(this);
		// Navegación usando el layout padre - tú arreglas el layout específico
		// Necesitaremos acceso al MainView a través de la jerarquía de TweetRetweet
	}
}