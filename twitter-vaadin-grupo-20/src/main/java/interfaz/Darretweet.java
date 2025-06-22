package interfaz;

import mds2.MainView.Pantalla;

public class Darretweet extends Escribirtweetretweet {
	public TweetRetweetajeno _tweetRetweetajeno;
	public TweetRetweetpropio _tweetRetweetpropio;

	public Darretweet(TweetRetweetajeno _tweetRetweetajeno) {
		super();
		this._tweetRetweetajeno = _tweetRetweetajeno;

		this.getCloseButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			// Puedes ser tweet o retweet
			Pantalla.MainView.add((Vertweetregistrado) _tweetRetweetajeno);
		});
	}

	public Darretweet(TweetRetweetpropio _tweetRetweetpropio) {
		super();
		this._tweetRetweetpropio = _tweetRetweetpropio;

		this.getCloseButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			// Puedes ser tweet o retweet
			Pantalla.MainView.add((Vertweetpropio) _tweetRetweetpropio);
		});
	}
}