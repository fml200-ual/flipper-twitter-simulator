package interfaz;

public class Listadetweetsyretweetsadministrador extends Listadetweetsyretweets {

	public Verlistaampliadadetweetsadministrador _verlistaampliadadetweetsadministrador;

	public Listadetweetsyretweetsadministrador(Verlistaampliadadetweetsadministrador _verlistaampliadadetweetsadministrador) {
		super();
		this._verlistaampliadadetweetsadministrador = _verlistaampliadadetweetsadministrador;
	}
	
	// Constructor para contexto de visualización de perfil (sin inicialización automática)
	public Listadetweetsyretweetsadministrador() {
		super(); // Constructor base sin inicialización
		// No asignar _verlistaampliadadetweetsadministrador
		// Este constructor se usa cuando se cargarán tweets manualmente desde otra clase
	}

}