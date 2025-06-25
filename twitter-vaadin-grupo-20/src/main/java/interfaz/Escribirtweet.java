package interfaz;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import java.util.Date;

public class Escribirtweet extends Escribirtweetretweet {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Escribirtweet(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		// Configurar eventos de los botones
		this.getCloseButton().addClickListener(event -> {
			cerrarVista();
		});
		
		// Agregar funcionalidad de publicar tweet
		this.getPublishButton().addClickListener(event -> {
			publicarTweet();
		});
		
		System.out.println("Vista Escribir Tweet iniciada para usuario: " + 
			(_aCT02UsuarioRegistrado.u != null ? _aCT02UsuarioRegistrado.u.getNickname() : "null"));
	}
	public void publicarTweet() {
		try {
			// Declaración del atributo IActor como en el patrón del diagrama de secuencia
			BDPrincipal iactor = new BDPrincipal();
			
			// Obtener el contenido del tweet del campo de texto
			String contenido = this.getTweetTextArea().getValue();
			
			if (contenido == null || contenido.trim().isEmpty()) {
				System.err.println("No se puede publicar un tweet vacío");
				com.vaadin.flow.component.notification.Notification.show("El tweet no puede estar vacío");
				return;
			}
			
			// Obtener el usuario actual desde el contexto
			if (_aCT02UsuarioRegistrado != null && _aCT02UsuarioRegistrado.u != null) {
				System.out.println("Publicando tweet siguiendo patrón ORM...");
				System.out.println("Usuario: " + _aCT02UsuarioRegistrado.u.getNickname());
				System.out.println("Contenido: " + contenido);
				
				// Extraer hashtags y menciones del contenido
				String[] hashtags = extraerHashtags(contenido);
				String[] menciones = extraerMenciones(contenido);
				
				// Seguir el patrón del diagrama: iactor.Send(padre.usuario.getID(), this.getMessage().getText())
				iactor.publicarTweet(
					_aCT02UsuarioRegistrado.u.getORMID(),
					contenido,
					new Date(),
					null, // URLDocumento
					null, // tipoDocumento
					hashtags,
					menciones
				);
				
				// Seguir el patrón: actor a = iactor.LoadUserById(padre.logueado.getId())
				basededatos.Usuario_Registrado usuarioActualizado = iactor.cargarUsuarioPorId(
					_aCT02UsuarioRegistrado.u.getORMID()
				);
				
				if (usuarioActualizado != null) {
					System.out.println("Tweet publicado exitosamente");
					
					// Actualizar el usuario en el contexto global siguiendo el patrón
					_aCT02UsuarioRegistrado.u = usuarioActualizado;
					mds2.MainView.Usuario.usuarioRegistrado = usuarioActualizado;
					
					// Mostrar notificación de éxito
					com.vaadin.flow.component.notification.Notification.show("Tweet publicado exitosamente!");
					
					// Limpiar el campo de texto
					this.getTweetTextArea().clear();
					
					// Cerrar la vista de escribir tweet y volver a la vista principal
					cerrarVista();
				} else {
					System.err.println("Error al recargar el usuario después de publicar");
					com.vaadin.flow.component.notification.Notification.show("Error al actualizar los datos");
				}
			} else {
				System.err.println("No hay usuario autenticado para publicar tweet");
				com.vaadin.flow.component.notification.Notification.show("Error: No hay usuario autenticado");
			}
			
		} catch (Exception e) {
			System.err.println("Error durante la publicación del tweet: " + e.getMessage());
			e.printStackTrace();
			com.vaadin.flow.component.notification.Notification.show("Error durante la publicación: " + e.getMessage());
		}
	}
	private void cerrarVista() {
		try {
			// Volver a la vista principal del usuario registrado
			Pantalla.MainView.removeAll();
			
			// Crear una nueva instancia del ACT02UsuarioRegistrado para refrescar los datos
			// Usar Pantalla.MainView como referencia del MainView
			ACT02UsuarioRegistrado nuevoACT02 = new ACT02UsuarioRegistrado(
				(mds2.MainView) Pantalla.MainView, 
				_aCT02UsuarioRegistrado.u
			);
			Pantalla.MainView.add(nuevoACT02);
			
			System.out.println("Vista cerrada y datos refrescados");
		} catch (Exception e) {
			System.err.println("Error al cerrar vista: " + e.getMessage());
			// Fallback: usar la instancia actual
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_aCT02UsuarioRegistrado);
		}
	}
	
	/**
	 * Extrae hashtags del contenido del tweet
	 * @param contenido El contenido del tweet
	 * @return Array de hashtags encontrados (sin el símbolo #)
	 */
	private String[] extraerHashtags(String contenido) {
		if (contenido == null || contenido.trim().isEmpty()) {
			return new String[0];
		}
		
		try {
			java.util.List<String> hashtags = new java.util.ArrayList<>();
			String[] palabras = contenido.split("\\s+");
			
			for (String palabra : palabras) {
				if (palabra.startsWith("#") && palabra.length() > 1) {
					// Remover el # y limpiar caracteres especiales al final
					String hashtag = palabra.substring(1).replaceAll("[^a-zA-Z0-9_]$", "");
					if (!hashtag.isEmpty() && !hashtags.contains(hashtag)) {
						hashtags.add(hashtag);
					}
				}
			}
			
			return hashtags.toArray(new String[0]);
		} catch (Exception e) {
			System.err.println("Error extrayendo hashtags: " + e.getMessage());
			return new String[0];
		}
	}
	
	/**
	 * Extrae menciones del contenido del tweet
	 * @param contenido El contenido del tweet
	 * @return Array de menciones encontradas (sin el símbolo @)
	 */
	private String[] extraerMenciones(String contenido) {
		if (contenido == null || contenido.trim().isEmpty()) {
			return new String[0];
		}
		
		try {
			java.util.List<String> menciones = new java.util.ArrayList<>();
			String[] palabras = contenido.split("\\s+");
			
			for (String palabra : palabras) {
				if (palabra.startsWith("@") && palabra.length() > 1) {
					// Remover el @ y limpiar caracteres especiales al final
					String mencion = palabra.substring(1).replaceAll("[^a-zA-Z0-9_]$", "");
					if (!mencion.isEmpty() && !menciones.contains(mencion)) {
						menciones.add(mencion);
					}
				}
			}
			
			return menciones.toArray(new String[0]);
		} catch (Exception e) {
			System.err.println("Error extrayendo menciones: " + e.getMessage());
			return new String[0];
		}
	}

}