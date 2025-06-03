package interfaz;

public class Verperfiladministrador extends Verperfil {
	// private event _eliminarperfil;
	// private event _banearusuario;
	// private event _detallarlongitudbaneo;
	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;

	public Verperfiladministrador(Vertweetadministrador _vertweetadministrador) {
		super();
		this._vertweetadministrador = _vertweetadministrador;
		this.getEditAccountButton().setVisible(false);
	}

	public Verperfiladministrador(Verretweetadministrador _verretweetadministrador) {
		super();
		this._verretweetadministrador = _verretweetadministrador;
		this.getEditAccountButton().setVisible(false);
	}

	public void Eliminarperfil() {
		throw new UnsupportedOperationException();
	}

	public void Banearusuario() {
		throw new UnsupportedOperationException();
	}

	public void Detallarlongitudbaneo() {
		throw new UnsupportedOperationException();
	}
}