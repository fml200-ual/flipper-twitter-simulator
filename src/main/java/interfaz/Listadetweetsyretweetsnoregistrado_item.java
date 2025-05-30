package interfaz;

public class Listadetweetsyretweetsnoregistrado_item extends Listadetweetsyretweets_item {

	public Verretweetnoregistrado _verretweetnoregistrado;
	public Vertweetnoregistrado _vertweetnoregistrado;

	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);
	}

	public void Verretweetnoregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Vertweetnoregistrado() {
		throw new UnsupportedOperationException();
	}
}