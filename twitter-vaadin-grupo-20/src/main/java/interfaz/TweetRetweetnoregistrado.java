package interfaz;

public class TweetRetweetnoregistrado extends TweetRetweet {
	public Listadecomentariosnoregistrado _listadecomentariosnoregistrado;
	
	public TweetRetweetnoregistrado() {
		
	}

	public TweetRetweetnoregistrado(Listadecomentariosnoregistrado listadecomentariosnoregistrado) {
		super();
		this._listadecomentariosnoregistrado = listadecomentariosnoregistrado;

	}
	public void Listadecomentariosnoregistrado() {
		throw new UnsupportedOperationException();
	}
}