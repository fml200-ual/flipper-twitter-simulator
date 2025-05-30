package interfaz;

import java.util.Vector;

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
	}

	public Listadeusuarios(Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado) {
		super();
		this._verlistaseguidosnoregistrado = _verlistaseguidosnoregistrado;
	}

	public Listadeusuarios(Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado) {
		super();
		this._verlistaseguidoresnoregistrado = _verlistaseguidoresnoregistrado;
	}

	public Listadeusuarios(Verlistadeseguidosregistrado _verlistadeseguidosregistrado) {
		super();
		this._verlistadeseguidosregistrado = _verlistadeseguidosregistrado;
	}

	public Listadeusuarios(Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado) {
		super();
		this._verlistadeseguidoresregistrado = _verlistadeseguidoresregistrado;
	}
}