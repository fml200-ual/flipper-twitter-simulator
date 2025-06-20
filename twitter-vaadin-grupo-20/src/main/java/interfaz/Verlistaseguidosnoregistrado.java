package interfaz;

import vistas.VistaVerlistaseguidosnoregistrado;

public class Verlistaseguidosnoregistrado extends VistaVerlistaseguidosnoregistrado{
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;
	public Verlistaseguidosnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;
		// Ensamblado estático de componentes fijos
		setupStaticView();
		// Ensamblado dinámico de contenido
		Listadeusuarios();
		setupSeguidosView();
		setupBackButton();
		setupShowMoreButton();
	}
		private void setupStaticView() {
		// Configurar elementos estáticos de la vista
		this.getListTitle().setText("Lista de seguidos de");
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
			
		// Aplicar estilos al botón show more
		this.getShowMoreFollowedButtonNoReg().getStyle()
			.set("background-color", "#00FFFF")
			.set("color", "black")
			.set("border-radius", "20px")
			.set("padding", "10px 20px")
			.set("font-weight", "bold")
			.set("cursor", "pointer")
			.set("border", "none")
			.set("transition", "all 0.2s ease");
	}

	private void setupSeguidosView() {
		// Configurar vista de seguidos para usuario no registrado
	}	public void Listadeusuarios() {
		// Ocultar mensaje de "no hay seguidos"
		this.getNoFollowedMessageNoReg().setVisible(false);
		
		// Crear lista de usuarios seguidos para usuario no registrado
		_listadeusuarios = new Listadeusuarios(this);
		
		// Agregar algunos items de ejemplo de seguidos con navegabilidad
		createNavigableFollowedItem("@tech_guru", "Experto en tecnología");
		createNavigableFollowedItem("@design_pro", "Diseñador profesional");  
		createNavigableFollowedItem("@code_master", "Desarrollador senior");
		
		// Agregar la lista al contenedor de seguidos de la vista
		this.getFollowedListContainerNoReg().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(_listadeusuarios);
	}
		private void createNavigableFollowedItem(String username, String description) {
		// Crear item navegable de seguido
		Listadeusuarios_item seguidoItem = new Listadeusuarios_item(_listadeusuarios, null);
		
		// Configurar navegabilidad del item (al hacer clic navegar al perfil)
		seguidoItem.getElement().addEventListener("click", e -> {
			// Navegar al perfil del usuario clickeado
			navigateToUserProfile(username);
		});
		
		// Aplicar estilos de interactividad para indicar que es clickeable
		seguidoItem.getElement().getStyle()
			.set("cursor", "pointer")
			.set("transition", "all 0.2s ease")
			.set("border-radius", "8px")
			.set("padding", "8px")
			.set("margin", "4px 0");
			
		// Aplicar efectos hover usando JavaScript
		seguidoItem.getElement().executeJs(
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
			.add(seguidoItem);
	}
		private void navigateToUserProfile(String username) {
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
		// Configurar el botón "Mostrar más seguidos" para cargar más contenido dinámicamente
		this.getShowMoreFollowedButtonNoReg().addClickListener(event -> loadMoreFollowed());
	}
	
	private void loadMoreFollowed() {
		// Cargar más seguidos dinámicamente
		if (_listadeusuarios != null) {
			// Agregar más items de ejemplo
			createNavigableFollowedItem("@nuevo_seguido1", "Desarrollador Full Stack");
			createNavigableFollowedItem("@nuevo_seguido2", "Diseñador UX/UI");
			createNavigableFollowedItem("@nuevo_seguido3", "Data Scientist");
			
			// Scroll suave hacia los nuevos elementos
			getElement().executeJs("this.scrollIntoView({behavior: 'smooth', block: 'end'});");
		}
	}
}