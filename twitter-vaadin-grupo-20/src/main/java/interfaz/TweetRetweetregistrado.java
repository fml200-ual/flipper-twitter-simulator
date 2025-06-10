package interfaz;

public class TweetRetweetregistrado extends TweetRetweet {
	public Listadecomentariosregistrado _listadecomentariosregistrado;

	public TweetRetweetregistrado() {

	}

	public TweetRetweetregistrado(Listadecomentariosregistrado listadecomentariosregistrado) {
		super();
		this._listadecomentariosregistrado = listadecomentariosregistrado;
	}

	public void Listadecomentariosregistrado() {
		throw new UnsupportedOperationException();
	}
}