package interfaz;
import mds2.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ACT02UsuarioRegistrado extends ACT06SesinIniciada {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verpropioperfil _verpropioperfil;
	public Escribirtweet _escribirtweet;
	public Vernotificaciones _vernotificaciones;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	
	
	public ACT02UsuarioRegistrado(MainView mainView) {
		super(mainView);
		this.getSpanListaTweetsRecientes().setVisible(false);
		// Ensamblado de componentes fijos
		Listafijadeusuariosregistrado();
		Listafijadehashtagsregistrado();
		Verpropioperfil();
		Escribirtweet();
		Vernotificaciones();
		Listadetweetsyretweetsregistrado();
	}

	public void Listafijadeusuariosregistrado() {
		_listafijadeusuariosregistrado = new Listafijadeusuariosregistrado(this);
		this.getVerticalLayoutListaUsuarios().as(VerticalLayout.class).add(_listafijadeusuariosregistrado);
	}

	public void Listafijadehashtagsregistrado() {
		_listafijadehashtagsregistrado = new Listafijadehashtagsregistrado(this);
		this.getVerticalLayoutListaHashtagsSesionIniciada().as(VerticalLayout.class).add(_listafijadehashtagsregistrado);
	}

	public void Verpropioperfil() {
		_verpropioperfil = new Verpropioperfil(this);
		this.getVerticalLayoutCentralSesionIniciada().as(VerticalLayout.class).add(_verpropioperfil);
	}

	public void Escribirtweet() {
		_escribirtweet = new Escribirtweet(this);
		this.getVerticalLayoutCentralSesionIniciada().as(VerticalLayout.class).add(_escribirtweet);
	}

	public void Vernotificaciones() {
		_vernotificaciones = new Vernotificaciones(this);
		this.getVerticalLayoutDerechoSesionIniciada().as(VerticalLayout.class).add(_vernotificaciones);
	}

	public void Listadetweetsyretweetsregistrado() {
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);
		this.getVerticalLayoutListaTweets().as(VerticalLayout.class).add(_listadetweetsyretweetsregistrado);
	}
}