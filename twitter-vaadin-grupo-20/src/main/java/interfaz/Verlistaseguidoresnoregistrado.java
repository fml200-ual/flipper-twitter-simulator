package interfaz;

import vistas.VistaVerlistaseguidoresnoregistrado;

public class Verlistaseguidoresnoregistrado extends VistaVerlistaseguidoresnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;
	public Verlistaseguidoresnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;
		// Ensamblado estático de componentes fijos
		setupStaticView();
		// Ensamblado dinámico de contenido
		Listadeusuarios();
		setupSeguidoresView();
		setupBackButton();
		setupShowMoreButton();
	}
	
	private void setupStaticView() {
		// Configurar elementos estáticos de la vista
		this.getListTitle().setText("Lista de seguidores de");
		this.getUsername().setText("@" + (_verperfilnoregistrado != null ? "usuario" : "usuario"));
		
		// Aplicar estilos para mejorar la navegabilidad
		this.getBackButton().getStyle()
			.set("background-color", "#1da1f2")
			.set("color", "white")
			.set("border-radius", "20px")
			.set("padding", "8px 16px")
			.set("font-weight", "bold")
			.set("cursor", "pointer")
			.set("border", "none");
			
		this.getShowMoreFollowersButton().getStyle()
			.set("background-color", "#00FFFF")
			.set("color", "black")
			.set("border-radius", "20px")
			.set("padding", "10px 20px")
			.set("font-weight", "bold")
			.set("cursor", "pointer")
			.set("border", "none")
			.set("transition", "all 0.2s ease");
	}
	private void setupSeguidoresView() {
		// Configurar vista de seguidores para usuario no registrado
		// Ocultar acciones de seguimiento que requieren login
	}
		public void Listadeusuarios() {
		// Ocultar mensaje de "no hay seguidores"
		this.getNoFollowersMessage().setVisible(false);
		
		// Crear lista de usuarios seguidores para usuario no registrado
		_listadeusuarios = new Listadeusuarios(this);
		
		// Agregar algunos items de ejemplo de seguidores con navegabilidad
		createNavigableFollowerItem("@nic_951", "Descripción del usuario 1");
		createNavigableFollowerItem("@ana_martinez", "Descripción del usuario 2");  
		createNavigableFollowerItem("@juan_dev", "Descripción del usuario 3");
		
		// Agregar la lista al contenedor de seguidores de la vista
		this.getFollowersListContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(_listadeusuarios);
	}
		private void createNavigableFollowerItem(String username, String description) {
		// Crear item navegable de seguidor
		Listadeusuarios_item seguidorItem = new Listadeusuarios_item(_listadeusuarios, null);
		
		// Configurar navegabilidad del item (al hacer clic navegar al perfil)
		seguidorItem.getElement().addEventListener("click", e -> {
			// Navegar al perfil del usuario clickeado
			navigateToUserProfile(username);
		});
		
		// Aplicar estilos de interactividad para indicar que es clickeable
		seguidorItem.getElement().getStyle()
			.set("cursor", "pointer")
			.set("transition", "all 0.2s ease")
			.set("border-radius", "8px")
			.set("padding", "8px")
			.set("margin", "4px 0");
			
		// Aplicar efectos hover usando JavaScript
		seguidorItem.getElement().executeJs(
			"this.addEventListener('mouseenter', () => {" +
			"  this.style.backgroundColor = '#444';" +
			"  this.style.transform = 'translateX(5px)';" +
			"});" +
			"this.addEventListener('mouseleave', () => {" +
			"  this.style.backgroundColor = 'transparent';" +
			"  this.style.transform = 'translateX(0)';" +
			"});"
		);
		
		// Agregar item al contenedor de la lista
		_listadeusuarios.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(seguidorItem);
	}private void navigateToUserProfile(String username) {
		// Navegar al perfil del usuario seleccionado
		if (_verperfilnoregistrado != null) {
			// Crear un nuevo perfil para el usuario clickeado usando el constructor apropiado
			if (_verperfilnoregistrado._listafijadeusuariosnoregistrado != null && 
				_verperfilnoregistrado._listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado != null) {
				
				// Crear nueva instancia del perfil
				Verperfilnoregistrado perfilClickeado = new Verperfilnoregistrado(_verperfilnoregistrado._listafijadeusuariosnoregistrado);
				
				// Navegar al nuevo perfil
				_verperfilnoregistrado._listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.removeAll();
				_verperfilnoregistrado._listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.add(perfilClickeado);
				
			} else if (_verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado != null && 
					   _verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado != null) {
				
				// Crear nueva instancia para contexto de lista ampliada
				Verperfilnoregistrado perfilClickeado = new Verperfilnoregistrado(_verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado);
				
				// Navegar al nuevo perfil
				_verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.removeAll();
				_verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.add(perfilClickeado);
			}
		}
	}
	
	private void setupBackButton() {
		this.getBackButton().addClickListener(event -> goBack());
	}
		private void goBack() {
		// Volver al perfil de usuario no registrado usando el mismo patrón de navegación
		if (_verperfilnoregistrado != null) {
			// Navegación by MainView - considerar múltiples contextos
			if (_verperfilnoregistrado._listafijadeusuariosnoregistrado != null && 
				_verperfilnoregistrado._listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado != null) {
				_verperfilnoregistrado._listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.removeAll();
				_verperfilnoregistrado._listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado._mainView.add(_verperfilnoregistrado);
			} else if (_verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado != null && 
					   _verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado != null) {
				_verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.removeAll();
				_verperfilnoregistrado._verlistaampliadadeusuariosnoregistrado._usuarioNoRegistrado._mainView.add(_verperfilnoregistrado);
			}
		}
	}
	private void setupShowMoreButton() {
		// Configurar el botón "Mostrar más seguidores" para cargar más contenido dinámicamente
		this.getShowMoreFollowersButton().addClickListener(event -> loadMoreFollowers());
	}
	
	private void loadMoreFollowers() {
		// Cargar más seguidores dinámicamente
		if (_listadeusuarios != null) {
			// Agregar más items de ejemplo
			Listadeusuarios_item nuevoSeguidor1 = new Listadeusuarios_item(_listadeusuarios, null);
			Listadeusuarios_item nuevoSeguidor2 = new Listadeusuarios_item(_listadeusuarios, null);
			Listadeusuarios_item nuevoSeguidor3 = new Listadeusuarios_item(_listadeusuarios, null);
			
			// Agregar items al contenedor de la lista
			_listadeusuarios.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
				.add(nuevoSeguidor1, nuevoSeguidor2, nuevoSeguidor3);
				
			// Scroll suave hacia los nuevos elementos
			getElement().executeJs("this.scrollIntoView({behavior: 'smooth', block: 'end'});");
		}
	}
}