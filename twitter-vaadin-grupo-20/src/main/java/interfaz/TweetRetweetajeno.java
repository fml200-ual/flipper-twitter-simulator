package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;

public class TweetRetweetajeno extends TweetRetweetregistrado {
	// private event _darmegusta;
	// private event _eliminarmegusta;
	public Darretweet _darretweet;
	public Escribircomentario _escribircomentario;	public TweetRetweetajeno(basededatos.Tweet tweet) {
		super(tweet);
		// METODOLOGÍA ACTIVIDAD 12: Configurar eventos de me gusta
		configurarEventosMeGusta();
		
		// Configurar eventos de interacción adicionales
		configurarEventosInteraccion();
	}
	
	/**
	 * Configurar eventos para retweet y comentario (adicionales a los heredados)
	 */
	private void configurarEventosInteraccion() {
		// Sobrescribir eventos para usar los métodos específicos de esta clase
		this.getIconoRetweet().addClickListener(event -> {
			Darretweet();
		});
		
		this.getIconoComentarios().addClickListener(event -> {
			Escribircomentario();
		});
	}

	public void Darretweet() {
		_darretweet = new Darretweet(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_darretweet);
	}

	public void Escribircomentario() {
		_escribircomentario = new Escribircomentario(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_escribircomentario);
	}

	// METODOLOGÍA ACTIVIDAD 12: Implementación siguiendo diagramas de secuencia
	public void Darmegusta() {
		try {
			System.out.println("Dando me gusta al tweet...");
			
			// Verificar estado del usuario antes de la operación
			MainView.verificarEstadoUsuario("darMeGusta - antes");
			
			// Obtener el usuario actual de forma segura
			MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
			
			if (MainView.Usuario.usuarioRegistrado == null) {
				System.err.println("Error: No se pudo obtener el usuario actual para me gusta");
				return;
			}
			
			int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
					// Obtener el tweet al que dar me gusta
			basededatos.Tweet tweet = getTweet();
			
			if (tweet == null) {
				System.err.println("Error: No se pudo obtener el tweet para me gusta");
				return;
			}
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Dar me gusta usando método ORM
			basededatos.Usuario_Registrado usuarioActualizado = bd.darMeGustaTweet(
				idUsuarioActual,
				tweet.getId_tweet()
			);
			
			if (usuarioActualizado != null) {
				System.out.println("Me gusta dado exitosamente");
				
				// Actualizar usuario actual en memoria
				MainView.Usuario.usuarioRegistrado = usuarioActualizado;
				
				// Actualizar contador de me gusta en la UI
				actualizarContadorMeGusta(tweet);
				
				// Verificar estado del usuario después de la operación
				MainView.verificarEstadoUsuario("darMeGusta - después");
			} else {
				System.err.println("Error al dar me gusta");
			}
			
		} catch (Exception e) {
			System.err.println("Error durante el me gusta: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Eliminarmegusta() {
		try {
			System.out.println("Eliminando me gusta del tweet...");
			
			// Verificar estado del usuario antes de la operación
			MainView.verificarEstadoUsuario("eliminarMeGusta - antes");
			
			// Obtener el usuario actual de forma segura
			MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
			
			if (MainView.Usuario.usuarioRegistrado == null) {
				System.err.println("Error: No se pudo obtener el usuario actual para eliminar me gusta");
				return;
			}
			
			int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
			// Obtener el tweet del que quitar me gusta
			

			if (tweet == null) {
				System.err.println("Error: No se pudo obtener el tweet para quitar me gusta");
				return;
			}
			
			// Quitar me gusta usando método ORM directo de BD_Tweet
			basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
			
			if (bdTweet.quitarMeGustaTweet(idUsuarioActual, tweet.getId_tweet())) {
				System.out.println("Me gusta eliminado exitosamente");
				
				// Actualizar contador de me gusta en la UI
				actualizarContadorMeGusta(tweet);
				
				// Verificar estado del usuario después de la operación
				MainView.verificarEstadoUsuario("eliminarMeGusta - después");
			} else {
				System.err.println("Error al eliminar me gusta");
			}
			
		} catch (Exception e) {
			System.err.println("Error durante la eliminación del me gusta: " + e.getMessage());
			e.printStackTrace();
		}
	}
		/**
	 * Configurar eventos de me gusta en la vista del tweet
	 */
	private void configurarEventosMeGusta() {
		try {
			// Buscar el icono de me gusta y configurar el evento
			// Este método se puede personalizar según la estructura específica de la vista
			if (this.getIconoMeGusta() != null) {
				this.getIconoMeGusta().addClickListener(event -> {
					toggleMeGusta();
				});
			}
		} catch (Exception e) {
			System.err.println("Error configurando eventos de me gusta: " + e.getMessage());
		}
	}
		/**
	 * Alternar estado de me gusta
	 */	public void toggleMeGusta() {
		try {
			// Obtener el tweet
			basededatos.Tweet tweet = getTweet();
			
			if (tweet == null) return;
			
			// Verificar si ya le gusta
			MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
			if (MainView.Usuario.usuarioRegistrado == null) return;
			
			int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
			basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
			
			if (bdTweet.verificarMeGustaTweet(idUsuarioActual, tweet.getId_tweet())) {
				Eliminarmegusta();
			} else {
				Darmegusta();
			}
			
		} catch (Exception e) {
			System.err.println("Error en toggle me gusta: " + e.getMessage());
		}
	}
	
	/**
	 * Actualizar el contador de me gusta en la interfaz
	 */
	private void actualizarContadorMeGusta(basededatos.Tweet tweet) {
		try {
			basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
			int contadorMeGusta = bdTweet.contarMeGustaTweet(tweet.getId_tweet());
			
			// Actualizar el elemento de la UI (método específico según la vista)
			if (this.getNumMegusta() != null) {
				this.getNumMegusta().setText(String.valueOf(contadorMeGusta));
			}
			
		} catch (Exception e) {
			System.err.println("Error actualizando contador de me gusta: " + e.getMessage());
		}
	}
}