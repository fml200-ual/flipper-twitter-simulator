package interfaz;

public class Listadetweetsyretweetsnoregistrado extends Listadetweetsyretweets {

	public Verhashtagnoregistrado _verhashtagnoregistrado;

	public Listadetweetsyretweetsnoregistrado(Verhashtagnoregistrado _verhashtagnoregistrado) {
		super(); // No llamar al inicializar del padre
		this._verhashtagnoregistrado = _verhashtagnoregistrado;
	}
	
	// Constructor para contexto de visualización de perfil (sin inicialización automática)
	public Listadetweetsyretweetsnoregistrado() {
		super(); // Constructor base sin inicialización
		// No asignar _verhashtagnoregistrado
		// Este constructor se usa cuando se cargarán tweets manualmente desde otra clase
	}

}