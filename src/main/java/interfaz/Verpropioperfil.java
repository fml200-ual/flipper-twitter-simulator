package interfaz;

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
	}

	public void Editarcuenta() {
		throw new UnsupportedOperationException();
	}

	public void Verlistadeseguidoresregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Verlistadeseguidosregistrado() {
		throw new UnsupportedOperationException();
	}
}