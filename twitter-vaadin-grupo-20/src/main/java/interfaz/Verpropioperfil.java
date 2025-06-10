package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;

public class Verpropioperfil extends Verperfil {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Editarcuenta _editarcuenta;
	public Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado;
	public Verlistadeseguidosregistrado _verlistadeseguidosregistrado;

	public Verpropioperfil(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getUserTweetsTab().setText("Mis tweets");
		this.getLikedTweetsTab().setText("Tweets que me gustan");

		VerlistatweetsRetweets();

		this.getFollowingCount().addClickListener(event -> {
			Verlistadeseguidosregistrado();
		});
		this.getFollowersCount().addClickListener(event -> {
			Verlistadeseguidoresregistrado();
		});
		this.getEditAccountButton().addClickListener(event -> {
			Editarcuenta();
		});
	}

	public void Editarcuenta() {
		_editarcuenta = new Editarcuenta(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_editarcuenta);
	}

	public void Verlistadeseguidoresregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Verlistadeseguidosregistrado() {
		throw new UnsupportedOperationException();
	}

	public void VerlistatweetsRetweets() {
		Listadetweetsyretweets listadetweetsyretweets = new Listadetweetsyretweets();
		listadetweetsyretweets.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
				.add(new Listadetweetsyretweets_item(listadetweetsyretweets));

		this.getTweetsListLayout().add(listadetweetsyretweets);
	}
}