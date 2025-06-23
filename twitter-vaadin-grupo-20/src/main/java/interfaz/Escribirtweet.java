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
		
		// Agregar funcionalidad de publicar tweet (asumiendo que existe un botón de publicar)
		// this.getPublishButton().addClickListener(event -> {
		//     publicarTweet();
		// });
	}
	
	public void publicarTweet() {
		try {
			// Obtener el contenido del tweet de los campos de texto
			// String contenido = this.getTweetContentField().getValue();
			String contenido = "Ejemplo de tweet"; // Por ahora usamos texto de ejemplo
			
			if (contenido == null || contenido.trim().isEmpty()) {
				System.err.println("No se puede publicar un tweet vacío");
				return;
			}
			
			// Obtener el usuario actual desde el actor
			if (_aCT02UsuarioRegistrado != null && _aCT02UsuarioRegistrado.u != null) {
				System.out.println("Publicando tweet del usuario: " + _aCT02UsuarioRegistrado.u.getNickname());
				
				// Crear instancia de la base de datos
				BDPrincipal bd = new BDPrincipal();
				
				// Publicar el tweet
				basededatos.Usuario_Registrado usuarioActualizado = bd.publicarTweet(
					_aCT02UsuarioRegistrado.u.getORMID(),
					contenido,
					new Date(),
					null, // URLDocumento
					null, // tipoDocumento
					new String[0], // hashtags (por ahora vacío)
					new String[0]  // menciones (por ahora vacío)
				);
				
				if (usuarioActualizado != null) {
					System.out.println("Tweet publicado exitosamente");
					// Actualizar el usuario en el actor
					_aCT02UsuarioRegistrado.u = usuarioActualizado;
					// Cerrar la vista de escribir tweet
					cerrarVista();
				} else {
					System.err.println("Error al publicar el tweet");
				}
			} else {
				System.err.println("No hay usuario autenticado para publicar tweet");
			}
			
		} catch (Exception e) {
			System.err.println("Error durante la publicación del tweet: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void cerrarVista() {
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_aCT02UsuarioRegistrado);
	}

}