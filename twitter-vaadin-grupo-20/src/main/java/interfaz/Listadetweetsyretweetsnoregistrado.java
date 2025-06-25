package interfaz;

public class Listadetweetsyretweetsnoregistrado extends Listadetweetsyretweets {

	public Verhashtagnoregistrado _verhashtagnoregistrado;

	public Listadetweetsyretweetsnoregistrado(Verhashtagnoregistrado _verhashtagnoregistrado) {
		super(); // No llamar al inicializar del padre
		this._verhashtagnoregistrado = _verhashtagnoregistrado;
	}

}