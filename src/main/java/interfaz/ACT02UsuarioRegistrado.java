package interfaz;

public class ACT02UsuarioRegistrado extends ACT06SesinIniciada {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verpropioperfil _verpropioperfil;
	public Escribirtweet _escribirtweet;
	public Vernotificaciones _vernotificaciones;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	
	
	public ACT02UsuarioRegistrado(org.vaadin.example.MainView mainView) {
		super(mainView);
		this.getSpanListaTweetsRecientes().setVisible(false);
		
	}

	public void Listafijadeusuariosregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Listafijadehashtagsregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Verpropioperfil() {
		throw new UnsupportedOperationException();
	}

	public void Escribirtweet() {
		throw new UnsupportedOperationException();
	}

	public void Vernotificaciones() {
		throw new UnsupportedOperationException();
	}

	public void Listadetweetsyretweetsregistrado() {
		throw new UnsupportedOperationException();
	}
}