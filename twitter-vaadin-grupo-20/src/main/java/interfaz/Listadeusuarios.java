package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.Usuario_Registrado;
import mds2.MainView.Pantalla;
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
	}

	public Listadeusuarios(Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._verlistaseguidosnoregistrado = _verlistaseguidosnoregistrado;

		BDPrincipal bd = new BDPrincipal();

		Usuario_Registrado[] seguidos = bd.cargarSeguidos(u.getId_usuario());

		for (Usuario_Registrado seguido : seguidos) {
			Listadeusuarios_item item = new Listadeusuarios_item(this, seguido);
			item.getMainContainer().addClickListener(event -> {
				Pantalla.MainView.removeAll();
				// Crear nueva vista de perfil no registrado para el seguido
				Verperfilnoregistrado nuevoPerfil = new Verperfilnoregistrado(
						_verlistaseguidosnoregistrado._verperfilnoregistrado._listafijadeusuariosnoregistrado, seguido);
				Pantalla.MainView.add(nuevoPerfil);
			});
			this.getMainContainer().as(VerticalLayout.class).add(item);
			_item.add(item);
		}

		// Configurar como scrolleable
		this.getMainContainer().getStyle()
				.set("height", "400px")
				.set("overflow-y", "auto")
				.set("overflow-x", "hidden")
				.set("padding", "5px")
				.set("gap", "5px");
	}

	public Listadeusuarios(Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado) {
		super();
		this._verlistaseguidoresnoregistrado = _verlistaseguidoresnoregistrado;
	}

	public Listadeusuarios(Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._verlistaseguidoresnoregistrado = _verlistaseguidoresnoregistrado;

		BDPrincipal bd = new BDPrincipal();

		Usuario_Registrado[] seguidores = bd.cargarSeguidores(u.getId_usuario());

		for (Usuario_Registrado seguidor : seguidores) {
			Listadeusuarios_item item = new Listadeusuarios_item(this, seguidor);
			item.getMainContainer().addClickListener(event -> {
				Pantalla.MainView.removeAll();
				// Crear nueva vista de perfil no registrado para el seguidor
				Verperfilnoregistrado nuevoPerfil = new Verperfilnoregistrado(
						_verlistaseguidoresnoregistrado._verperfilnoregistrado._listafijadeusuariosnoregistrado,
						seguidor);
				Pantalla.MainView.add(nuevoPerfil);
			});
			this.getMainContainer().as(VerticalLayout.class).add(item);
			_item.add(item);
		}

		// Configurar como scrolleable
		this.getMainContainer().getStyle()
				.set("height", "400px")
				.set("overflow-y", "auto")
				.set("overflow-x", "hidden")
				.set("padding", "5px")
				.set("gap", "5px");
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

		// Configurar como scrolleable
		this.getMainContainer().getStyle()
				.set("height", "400px")
				.set("overflow-y", "auto")
				.set("overflow-x", "hidden")
				.set("padding", "5px")
				.set("gap", "5px");
	}

	public Listadeusuarios(Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._verlistadeseguidoresregistrado = _verlistadeseguidoresregistrado;

		BDPrincipal bd = new BDPrincipal();

		Usuario_Registrado[] seguidores = bd.cargarSeguidores(u.getId_usuario());

		for (Usuario_Registrado seguidor : seguidores) {
			Listadeusuarios_item item = new Listadeusuarios_item(this, seguidor);
			item.getMainContainer().addClickListener(event -> {
				new Verperfilregistrado(
						_verlistadeseguidoresregistrado._verperfilregistrado._listafijadeusuariosregistrado, seguidor);
			});
			this.getMainContainer().as(VerticalLayout.class).add(item);
			_item.add(item);
		}

		// Configurar como scrolleable
		this.getMainContainer().getStyle()
				.set("height", "400px")
				.set("overflow-y", "auto")
				.set("overflow-x", "hidden")
				.set("padding", "5px")
				.set("gap", "5px");
	}
}