package interfaz;

public class Verhashtagnoregistrado extends Verhashtag {
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;
	public Listadetweetsyretweetsnoregistrado _listadetweetsyretweetsnoregistrado;

	public Verhashtagnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado) {
		super();
		this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;
	}

	public Verhashtagnoregistrado(Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado) {
		super();
		this._verlistaampliadadehashtagsnoregistrado = _verlistaampliadadehashtagsnoregistrado;
	}

	public void Listadetweetsyretweetsnoregistrado() {
		throw new UnsupportedOperationException();
	}
}