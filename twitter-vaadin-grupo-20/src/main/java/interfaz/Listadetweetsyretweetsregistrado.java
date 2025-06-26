package interfaz;

public class Listadetweetsyretweetsregistrado extends Listadetweetsyretweets {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verhashtagregistrado _verhashtagregistrado;

	public Listadetweetsyretweetsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
	}

	public Listadetweetsyretweetsregistrado(Verhashtagregistrado verhashtagregistrado) {
		super();
		this._verhashtagregistrado = verhashtagregistrado;
	}

	// Constructor sin parámetros para casos especiales
	public Listadetweetsyretweetsregistrado() {
		super();
	}

	public void cargarRetweetsDelUsuario(basededatos.Usuario_Registrado usuario) {
		// Método para cargar retweets del usuario específico
		System.out.println("Cargando retweets del usuario: " + usuario.getNickname());
		// Aquí se implementaría la lógica para cargar retweets desde la base de datos
	}

}