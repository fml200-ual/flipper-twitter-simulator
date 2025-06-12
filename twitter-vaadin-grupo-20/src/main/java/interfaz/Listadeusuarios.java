package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
		itemsUsuarios();
	}

	public Listadeusuarios(Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado) {
		super();
		this._verlistaseguidosnoregistrado = _verlistaseguidosnoregistrado;
		itemsUsuarios();
	}

	public Listadeusuarios(Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado) {
		super();
		this._verlistaseguidoresnoregistrado = _verlistaseguidoresnoregistrado;
		itemsUsuarios();
	}

	public Listadeusuarios(Verlistadeseguidosregistrado _verlistadeseguidosregistrado) {
		super();
		this._verlistadeseguidosregistrado = _verlistadeseguidosregistrado;
		itemsUsuarios();
	}

	public Listadeusuarios(Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado) {
		super();
		this._verlistadeseguidoresregistrado = _verlistadeseguidoresregistrado;
		itemsUsuarios();
	}

	public void itemsUsuarios() {
		this.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(this));
		this.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(this));
		this.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(this));
		for (int i = 0; i < 3; i++) {

		}
	}

}