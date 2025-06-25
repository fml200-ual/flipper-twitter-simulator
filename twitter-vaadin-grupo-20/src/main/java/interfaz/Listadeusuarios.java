package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
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
		// inicializar();
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

	public Listadeusuarios(Verlistadeseguidosregistrado _verlistadeseguidosregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._verlistadeseguidosregistrado = _verlistadeseguidosregistrado;

		BDPrincipal bd = new BDPrincipal();

		Usuario_Registrado[] seguidos = bd.cargarSeguidos(u.getId_usuario());

		for (Usuario_Registrado seguido : seguidos) {
			Listadeusuarios_item item = new Listadeusuarios_item(this, seguido);
			item.getMainContainer().addClickListener(event -> {
				new Verperfilregistrado(
						_verlistadeseguidosregistrado._verperfilregistrado._listafijadeusuariosregistrado, seguido);
			});
			this.getMainContainer().as(VerticalLayout.class).add(item);
			_item.add(item);
		}

	}

	public Listadeusuarios(Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._verlistadeseguidoresregistrado = _verlistadeseguidoresregistrado;

		BDPrincipal bd = new BDPrincipal();

		Usuario_Registrado[] seguidores = bd.cargarSeguidos(u.getId_usuario());

		for (Usuario_Registrado seguidor : seguidores) {
			Listadeusuarios_item item = new Listadeusuarios_item(this, seguidor);
			item.getMainContainer().addClickListener(event -> {
				new Verperfilregistrado(
						_verlistadeseguidoresregistrado._verperfilregistrado._listafijadeusuariosregistrado, seguidor);
			});
			this.getMainContainer().as(VerticalLayout.class).add(item);
			_item.add(item);
		}
	}

	private void inicializar() {
		try {
			// Cargar usuarios reales de la base de datos
			Usuario_Registrado[] usuarios = ((basededatos.BDPrincipal) MainView.Usuario.usuarioNoRegistradoInterfaz)
					.cargarUsuarios();

			if (usuarios != null && usuarios.length > 0) {
				// Crear items con datos reales
				for (int i = 0; i < usuarios.length; i++) {
					Listadeusuarios_item item = new Listadeusuarios_item(this, usuarios[i]);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
			} else {
				System.out.println("No se encontraron usuarios en la base de datos");
			}
		} catch (Exception e) {
			System.err.println("Error cargando usuarios: " + e.getMessage());
			e.printStackTrace();
		}
	}
}