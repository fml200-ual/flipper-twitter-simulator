package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;
import mds2.MainView.TipoUser;
import mds2.MainView.Usuario;
import vistas.VistaAct06sesininiciada;

public class ACT06SesinIniciada extends VistaAct06sesininiciada {
	// private event _cerrarsesin;
	public MainView MainView;

	public ACT06SesinIniciada(MainView MainView) {
		this.MainView = MainView;
	}

	public void Cerrarsesin() {
		Usuario.tipoUsuario = TipoUser.NO_REGISTRADO;
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(MainView));
	}
}