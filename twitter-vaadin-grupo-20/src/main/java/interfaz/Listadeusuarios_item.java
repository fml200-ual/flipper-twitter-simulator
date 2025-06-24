package interfaz;

import com.vaadin.flow.component.html.Image;

import vistas.VistaListadeusuarios_item;
import basededatos.Usuario_Registrado;

public class Listadeusuarios_item extends VistaListadeusuarios_item {	public Listadeusuarios _listadeusuarios;
	public Verperfilnoregistrado _verperfilnoregistrado;
	
	public Usuario_Registrado u; // Hacer público para acceso desde otras clases
	
	public Listadeusuarios_item(Listadeusuarios _listadeusuarios, Usuario_Registrado u) {
		super();
		this._listadeusuarios = _listadeusuarios;
		this.u = u;
		
		// Poblar la interfaz con datos del usuario si están disponibles
		if (u != null) {
			actualizarDatosUsuario();
		} else {
			// Mostrar datos por defecto si no hay usuario
			mostrarDatosPorDefecto();
		}
		
		// Agregar listener para navegar al perfil
		this.getMainContainer().addClickListener(event -> VerperfildeUsuario());
	}
		private void actualizarDatosUsuario() {
		// Actualizar nickname
		if (u.getNickname() != null) {
			this.getNickName().setText(u.getNickname());
		}
		
		// Actualizar descripción
		if (u.getDescripcion() != null && !u.getDescripcion().trim().isEmpty()) {
			this.getDescriptionText().setText(u.getDescripcion());
		} else {
			this.getDescriptionText().setText("Sin descripción");
		}
		
		// Actualizar foto de perfil si hay URL
		if (u.getFotoPerfilURL() != null && !u.getFotoPerfilURL().trim().isEmpty()) {
			try {
				// Reemplazar el icono por defecto con una imagen real
				Image img = new Image(u.getFotoPerfilURL(), "Foto de perfil");
				img.setWidth("32px");
				img.setHeight("32px");
				img.getStyle().set("border-radius", "50%"); // Hacer circular
				
				// Reemplazar el icono de avatar con la imagen
				this.getAvatarIcon().getParent().ifPresent(parent -> {
					parent.getElement().removeChild(this.getAvatarIcon().getElement());
					parent.getElement().appendChild(img.getElement());
				});
			} catch (Exception e) {
				// Si hay error con la imagen, mantener el icono por defecto
				System.err.println("Error cargando imagen de perfil: " + e.getMessage());
			}
		}
		
		// Actualizar número de seguidores (si el ORM lo proporciona)
		// Nota: Esto requeriría una relación en el modelo ORM para contar seguidores
		// Por ahora, mostrar un número por defecto o calculado
		this.getFollowersCount().setText("0");
	}
	
	private void mostrarDatosPorDefecto() {
		this.getNickName().setText("Usuario");		this.getDescriptionText().setText("Sin datos disponibles");
		this.getFollowersCount().setText("0");
	}
	
	public void VerperfildeUsuario() {
		if (u != null) {
			System.out.println("Navegando al perfil del usuario: " + u.getNickname());
			
			// Determinar el tipo de vista según el usuario actual
			basededatos.Usuario_Registrado usuarioActual = mds2.MainView.Usuario.usuarioRegistrado;			if (usuarioActual != null) {
				// Usuario registrado - verificar si está bloqueado por el usuario que queremos ver
				if (verificarSiUsuarioActualEstaBloqueadoPor(usuarioActual, u)) {
					// El usuario actual está bloqueado por este usuario - mostrar perspectiva bloqueado
					System.out.println("Usuario actual bloqueado por " + u.getNickname() + " - mostrando perspectiva bloqueado");
					Perspectivabloqueado perspectivaBloqueado = new Perspectivabloqueado(u);
					
					mds2.MainView.Pantalla.Anterior = mds2.MainView.Pantalla.MainView.getComponentAt(0);
					mds2.MainView.Pantalla.MainView.removeAll();
					mds2.MainView.Pantalla.MainView.add(perspectivaBloqueado);
				} else {
					// Usuario registrado normal - usar Verperfilregistrado
					Verperfilregistrado perfilRegistrado = new Verperfilregistrado(u);
					mds2.MainView.Pantalla.Anterior = mds2.MainView.Pantalla.MainView.getComponentAt(0);
					mds2.MainView.Pantalla.MainView.removeAll();
					mds2.MainView.Pantalla.MainView.add(perfilRegistrado);
				}
			} else {
				// Usuario no registrado - usar Verperfilnoregistrado
				Verperfilnoregistrado perfilNoRegistrado = new Verperfilnoregistrado(u);
				mds2.MainView.Pantalla.Anterior = mds2.MainView.Pantalla.MainView.getComponentAt(0);
				mds2.MainView.Pantalla.MainView.removeAll();
				mds2.MainView.Pantalla.MainView.add(perfilNoRegistrado);
			}
		} else {
			System.err.println("No se puede navegar al perfil: usuario es null");
		}
	}
	
	/**
	 * Verifica si el usuario actual está bloqueado por el usuario destino
	 * Siguiendo el patrón ORM accediendo a la colección 'bloqueados' del usuario destino
	 */	@SuppressWarnings("unchecked")
	private boolean verificarSiUsuarioActualEstaBloqueadoPor(basededatos.Usuario_Registrado usuarioActual, basededatos.Usuario_Registrado usuarioDestino) {
		try {
			// Usar BDPrincipal para consultar directamente el estado de bloqueo desde la BD
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Cargar el usuario destino actualizado desde la BD
			basededatos.Usuario_Registrado usuarioDestinoActualizado = bd.cargarUsuarioPorId(usuarioDestino.getId_usuario());
			
			if (usuarioDestinoActualizado != null && usuarioDestinoActualizado.bloqueados != null) {
				// Verificar si el usuario actual está en la lista de bloqueados del usuario destino
				for(java.util.Iterator<basededatos.Usuario_Registrado> iter = usuarioDestinoActualizado.bloqueados.getIterator(); iter.hasNext();) {
					basededatos.Usuario_Registrado bloqueado = iter.next();
					if (bloqueado.getId_usuario() == usuarioActual.getId_usuario()) {
						System.out.println("Usuario actual " + usuarioActual.getNickname() + " está bloqueado por " + usuarioDestino.getNickname());
						return true; // El usuario actual está en la lista de bloqueados del usuario destino
					}
				}
			}
			
			System.out.println("Usuario actual " + usuarioActual.getNickname() + " NO está bloqueado por " + usuarioDestino.getNickname());
			return false;
		} catch (Exception e) {
			System.err.println("Error verificando si el usuario actual está bloqueado: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Deprecated
	public void Mostrarmsusuarios() {
		// Método legacy mantenido por compatibilidad
	}
}