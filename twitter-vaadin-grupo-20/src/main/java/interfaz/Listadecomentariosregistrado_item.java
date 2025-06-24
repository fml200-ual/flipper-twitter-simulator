package interfaz;

import mds2.MainView.Pantalla;

public class Listadecomentariosregistrado_item extends Listadecomentarios_item {

	public Vercomentarioregistrado _vercomentarioregistrado;

	public Listadecomentariosregistrado_item(Listadecomentarios _listadecomentarios) {
		super(_listadecomentarios);

		// TODO: Configurar click listener cuando el componente correcto esté disponible
		// this.getvL_listacomentarios_mainContainer().as(VerticalLayout.class).addClickListener(event -> {
		//     Vercomentarioregistrado();
		// });
	}
	
	// Constructor que acepta Comentario
	public Listadecomentariosregistrado_item(Listadecomentarios _listadecomentarios, basededatos.Comentario c) {
		super(_listadecomentarios, c);
		// Los datos se rellenan en la clase padre
		
		// Configurar click listener para navegar a la vista detallada del comentario
		configurarClickListener();
	}
	private void configurarClickListener() {
		// Configurar click listener en el contenedor principal del comentario
		try {
			this.getvL_listacomentarios_mainContainer().addEventListener("click", event -> {
				Vercomentarioregistrado();
			});
		} catch (Exception e) {
			System.err.println("Error configurando click listener en item de comentario: " + e.getMessage());
		}
	}

	public void Vercomentarioregistrado() {
		// Guardar la vista anterior
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		
		// Crear la vista detallada del comentario con los datos reales
		_vercomentarioregistrado = new Vercomentarioregistrado(this);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vercomentarioregistrado);
	}
}