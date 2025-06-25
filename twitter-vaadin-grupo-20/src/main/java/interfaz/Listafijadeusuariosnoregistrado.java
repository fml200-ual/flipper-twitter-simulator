package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.Usuario_Registrado;
import basededatos.BDPrincipal;

public class Listafijadeusuariosnoregistrado extends Listafijadeusuarios {
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado;

	public Listafijadeusuariosnoregistrado(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		// Ensamblado de componentes fijos
		ListadeusuariosNR();
		// Ensamblado dinámico - ClickListeners para botones
	}

	public void ListadeusuariosNR() {
		try {
			System.out.println("Cargando usuarios desde la base de datos...");

			// Crear instancia de la base de datos
			BDPrincipal bd = new BDPrincipal();

			// Cargar usuarios desde la base de datos
			Usuario_Registrado[] usuariosArray = bd.cargarUsuarios();

			if (usuariosArray != null && usuariosArray.length > 0) {
				System.out.println("Cargados " + usuariosArray.length + " usuarios desde la BD");

				// Crear items de lista para cada usuario cargado
				for (Usuario_Registrado usuario : usuariosArray) {
					if (usuario != null) {
						// Crear item con el usuario real de la base de datos
						Listadeusuarios_item item = new Listadeusuarios_item(null, usuario);

						// Agregar ClickListener para navegar al perfil específico
						item.getMainContainer().addClickListener(event -> {
							VerperfilnoregistradoConUsuario(usuario);
						});

						// Agregar el item al contenedor
						this.getMainContainer().as(VerticalLayout.class).add(item);
					}
				}
				
				// Configurar el contenedor como scrolleable
				this.getMainContainer().getStyle()
					.set("height", "400px")  // Altura fija para permitir scroll
					.set("overflow-y", "auto")  // Scroll vertical
					.set("overflow-x", "hidden")  // Sin scroll horizontal
					.set("padding", "5px")
					.set("gap", "5px");
				
				System.out.println("Lista fija de usuarios configurada como scrolleable con " + usuariosArray.length + " usuarios");
			} else {
				System.out.println("No se encontraron usuarios en la base de datos");
				// Crear lista vacía o mostrar mensaje
				Listadeusuarios listaVacia = new Listadeusuarios(_verlistaampliadadeusuariosnoregistrado);
				this.getMainContainer().as(VerticalLayout.class).add(listaVacia);
			}

		} catch (Exception e) {
			System.err.println("Error al cargar usuarios desde la BD: " + e.getMessage());
			e.printStackTrace();

			// En caso de error, usar la funcionalidad original
			Listadeusuarios listaUsuarios = new Listadeusuarios(_verlistaampliadadeusuariosnoregistrado);

			// Agregar ClickListener a todos los items para navegar a Verperfilnoregistrado
			for (Listadeusuarios_item item : listaUsuarios._item) {
				item.getMainContainer().addClickListener(event -> {
					// Pasar el usuario específico del item al perfil
					VerperfilnoregistradoConUsuario(item.u);
				});
			}

			this.getMainContainer().as(VerticalLayout.class).add(listaUsuarios);
		}
	}

	private void VerperfilnoregistradoConUsuario(Usuario_Registrado usuario) {
		// Método mejorado que puede recibir el usuario específico
		if (usuario != null) {
			System.out.println("Navegando al perfil de: " + usuario.getNickname());
			_verperfilnoregistrado = new Verperfilnoregistrado(this, usuario);
		} else {
			System.out.println("Navegando al perfil sin usuario específico");
			_verperfilnoregistrado = new Verperfilnoregistrado(this);
		}

		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfilnoregistrado);
	}

	public void Verperfilnoregistrado() {
		_verperfilnoregistrado = new Verperfilnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfilnoregistrado);
	}

	public void Verlistaampliadadeusuariosnoregistrado() {
		_verlistaampliadadeusuariosnoregistrado = new Verlistaampliadadeusuariosnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaampliadadeusuariosnoregistrado);
	}
}