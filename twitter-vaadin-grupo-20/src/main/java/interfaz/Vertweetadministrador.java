package interfaz;

import mds2.MainView.Pantalla;

public class Vertweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;

	public Vertweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador) {
		super();
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;

		this.getLayoutPublicacionCitada().setVisible(false);

		// Añadir botón de regreso
		volver();
		this.Listadecomentariosadministrador();

		this.getAvatarDivPrincipal().addClickListener(event -> {
			Verperfiladministrador();
		});
	}

	public void Verperfiladministrador() {
		_verperfiladministrador = new Verperfiladministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfiladministrador);
	}
}