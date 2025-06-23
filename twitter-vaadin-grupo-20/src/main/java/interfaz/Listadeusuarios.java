package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Usuario_Registrado;
import mds2.MainView;
import vistas.VistaListadeusuarios;

public class Listadeusuarios extends VistaListadeusuarios {
	public Verlistaampliadadeusuarios _verlistaampliadadeusuarios;
	public Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado;
	public Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado;
	public Verlistadeseguidosregistrado _verlistadeseguidosregistrado;
	public Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado;
	public Vector<Listadeusuarios_item> _item = new Vector<Listadeusuarios_item>();

	public Listadeusuarios(Verlistaampliadadeusuarios _verlistaampliadadeusuarios) {
		super();
		this._verlistaampliadadeusuarios = _verlistaampliadadeusuarios;
		inicializar();
	}

	public Listadeusuarios(Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado) {
		super();
		this._verlistaseguidosnoregistrado = _verlistaseguidosnoregistrado;
		inicializar();
	}

	public Listadeusuarios(Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado) {
		super();
		this._verlistaseguidoresnoregistrado = _verlistaseguidoresnoregistrado;
		inicializar();
	}

	public Listadeusuarios(Verlistadeseguidosregistrado _verlistadeseguidosregistrado) {
		super();
		this._verlistadeseguidosregistrado = _verlistadeseguidosregistrado;
		inicializar();
	}

	public Listadeusuarios(Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado) {
		super();
		this._verlistadeseguidoresregistrado = _verlistadeseguidoresregistrado;
		inicializar();
	}

	private void inicializar() {
		try {
			// Cargar usuarios reales de la base de datos
			Usuario_Registrado[] usuarios = ((basededatos.BDPrincipal) MainView.Usuario.usuarioNoRegistradoInterfaz).cargarUsuarios();
			
			if (usuarios != null && usuarios.length > 0) {
				// Crear items con datos reales
				for (int i = 0; i < usuarios.length; i++) {
					Listadeusuarios_item item = new Listadeusuarios_item(this, usuarios[i]);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
			} else {
				// Fallback: crear algunos items vacíos si no hay datos
				for (int i = 0; i < 3; i++) {
					Listadeusuarios_item item = new Listadeusuarios_item(this, null);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
			}
		} catch (Exception e) {
			// En caso de error, crear items vacíos
			System.err.println("Error cargando usuarios: " + e.getMessage());
			for (int i = 0; i < 3; i++) {
				Listadeusuarios_item item = new Listadeusuarios_item(this, null);
				this.getMainContainer().as(VerticalLayout.class).add(item);
				_item.add(item);
			}
		}
	}

	// Método legacy mantenido por compatibilidad (ya no se usa)
	@Deprecated
	public void itemsUsuarios() {
		// Este método ya no se usa, la inicialización se hace en el constructor
	}
}