package interfaz;

public class Vertweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;

	public Vertweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador) {
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;
		this.getPublicacionCitadaContenedor().setVisible(false);
	}

	public void Verperfiladministrador() {
		throw new UnsupportedOperationException();
	}
}