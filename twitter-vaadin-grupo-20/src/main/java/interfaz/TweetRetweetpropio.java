package interfaz;

import mds2.MainView.Pantalla;

public class TweetRetweetpropio extends TweetRetweetregistrado {
	public Darretweet _darretweet;
	public Escribircomentario _escribircomentario;
	public TweetRetweetpropio(basededatos.Tweet tweet) {
		super(tweet);
		
		// Configurar eventos de interacción
		configurarEventosInteraccion();
	}
	
	/**
	 * Configurar eventos para retweet y comentario
	 */
	private void configurarEventosInteraccion() {
		// Configurar eventos para usar los métodos específicos de esta clase
		this.getIconoRetweet().addClickListener(event -> {
			Darretweet();
		});
		
		this.getIconoComentarios().addClickListener(event -> {
			Escribircomentario();
		});
	}

	public void Darretweet() {
		_darretweet = new Darretweet(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_darretweet);
	}

	public void Escribircomentario() {
		_escribircomentario = new Escribircomentario(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_escribircomentario);
	}
}