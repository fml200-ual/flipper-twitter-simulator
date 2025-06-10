package interfaz;

public class Verhashtagregistrado extends Verhashtag {
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;

	public Verhashtagregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;
	}
	public void Listadetweetsyretweetsregistrado() {
		throw new UnsupportedOperationException();
	}
}