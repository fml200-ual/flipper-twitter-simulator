package interfaz;

public class Listadetweetsyretweetsregistrado extends Listadetweetsyretweets {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verhashtagregistrado _verhashtagregistrado;

	public Listadetweetsyretweetsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
	}

	public Verhashtagregistrado get_verhashtagregistrado() {
		return _verhashtagregistrado;
	}

	public void set_verhashtagregistrado(Verhashtagregistrado _verhashtagregistrado) {
		this._verhashtagregistrado = _verhashtagregistrado;
	}

}