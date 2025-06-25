package mds2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import interfaz.*;
import basededatos.*;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

	public static class Pantalla {
		public static MainView MainView;
		public static Component Anterior;
		// Usuario no registrado: 1, Usuario registrado: 2, Administrador: 3
		public static int usuario;
		public static boolean esPropio;
	}

	public enum TipoUser {
		NO_REGISTRADO, REGISTRADO, ADMINISTRADOR
	}

	public static class Usuario {
		public static basededatos.Usuario_Registrado usuarioRegistrado;
		public static basededatos.Administrador administrador;

		public static TipoUser tipoUsuario = TipoUser.NO_REGISTRADO;
		public static iAdministrador administradorInterfaz = new BDPrincipal();
		public static iUsuarioRegistrado usuarioRegistradoInterfaz = new BDPrincipal();
		public static iUsuarioNoRegistrado usuarioNoRegistradoInterfaz = new BDPrincipal();
	}

	public static class Credenciales {
		public static String user;
		public static String pass;
	}

	private static boolean leerCredenciales() {

		String rutaProyecto = System.getProperty("user.dir");
		String rutaArchivo = Paths.get(rutaProyecto, "/src/main/resources/sesion.txt").toString();
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String primeraLinea = br.readLine(); // Leer 0 o 1
			if (primeraLinea == null || !primeraLinea.equals("1")) {
				System.out.println("No hay datos que cargar.");
				return false;
			}

			String usuario = br.readLine(); // Leer usuario
			String password = br.readLine(); // Leer contraseña

			if (usuario != null && password != null) {
				Credenciales.user = usuario;
				Credenciales.pass = password;
				return true;
			} else {
				System.out.println("Formato de archivo incorrecto.");
				return false;
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
			return false;
		}
	}

	private boolean inicioSesion() {
		if (!leerCredenciales()) {
			return false;
		}

		System.out.println("Intentando login con usuario: " + Credenciales.user);
		Usuario.usuarioRegistrado = Usuario.usuarioNoRegistradoInterfaz.login(Credenciales.user, Credenciales.pass);
		Usuario.administrador = Usuario.usuarioNoRegistradoInterfaz.loginAdmin(Credenciales.user, Credenciales.pass);

		if (Usuario.usuarioRegistrado != null) {
			Usuario.tipoUsuario = TipoUser.REGISTRADO;
			Pantalla.usuario = 2; // Usuario registrado
			System.out.println("Login exitoso como usuario registrado: " + Usuario.usuarioRegistrado.getNickname());
			System.out.println("ID usuario: " + Usuario.usuarioRegistrado.getId_usuario());
			ACT02UsuarioRegistrado inicioRegistrado = new ACT02UsuarioRegistrado(this, Usuario.usuarioRegistrado);
			add(inicioRegistrado);
		} else if (Usuario.administrador != null) {
			Usuario.tipoUsuario = TipoUser.ADMINISTRADOR;
			Pantalla.usuario = 3; // Administrador
			System.out.println("Login exitoso como administrador");
			ACT03Administrador inicioAdministrador = new ACT03Administrador(this);
			add(inicioAdministrador);
		} else {
			System.out.println("Login fallido para usuario: " + Credenciales.user);
			return false;
		}
		return true;
	}

	/**
	 * Construct a new Vaadin view.
	 * <p>
	 * Build the initial UI state for the user accessing the application.
	 *
	 * @param service
	 *                The message service. Automatically injected Spring managed
	 *                bean.
	 */
	public MainView(@Autowired GreetService service) {
		Pantalla.MainView = this;

		if (!inicioSesion()) {
			// Si no hay sesión válida, mostrar interfaz de usuario no registrado
			ACT01UsuarioNoRegistrado inicioNoRegistrado = new ACT01UsuarioNoRegistrado(this);
			add(inicioNoRegistrado);
		}
	}

	/**
	 * Método utilitario para obtener el usuario actual de forma segura
	 * Refresca el usuario desde la base de datos si es necesario
	 */
	public static Usuario_Registrado obtenerUsuarioActual() {
		try {
			// Si el usuario es null, intentar relogin
			if (Usuario.usuarioRegistrado == null) {
				System.out.println("Usuario null, intentando relogin...");
				if (Credenciales.user != null && Credenciales.pass != null) {
					Usuario.usuarioRegistrado = Usuario.usuarioNoRegistradoInterfaz.login(
							Credenciales.user, Credenciales.pass);
					System.out.println(
							"Relogin resultado: " + (Usuario.usuarioRegistrado != null ? "exitoso" : "fallido"));
					if (Usuario.usuarioRegistrado != null) {
						System.out.println("Usuario recuperado: " + Usuario.usuarioRegistrado.getNickname() + " (ID: "
								+ Usuario.usuarioRegistrado.getId_usuario() + ")");
					}
				} else {
					System.err.println("No hay credenciales disponibles para relogin");
					return null;
				}
			} else {
				// Verificar que el usuario siga siendo válido
				try {
					// Intentar acceder a una propiedad para verificar si el objeto está "detached"
					String nickname = Usuario.usuarioRegistrado.getNickname();
					if (nickname == null) {
						throw new Exception("Usuario detached");
					}
				} catch (Exception e) {
					System.out.println("Usuario detached, relogueando...");
					if (Credenciales.user != null && Credenciales.pass != null) {
						Usuario.usuarioRegistrado = Usuario.usuarioNoRegistradoInterfaz.login(
								Credenciales.user, Credenciales.pass);
						System.out.println("Relogin por detached resultado: "
								+ (Usuario.usuarioRegistrado != null ? "exitoso" : "fallido"));
					}
				}
			}

			return Usuario.usuarioRegistrado;
		} catch (Exception e) {
			System.err.println("Error obteniendo usuario actual: " + e.getMessage());
			e.printStackTrace();
			// Intentar un último relogin
			if (Credenciales.user != null && Credenciales.pass != null) {
				try {
					Usuario.usuarioRegistrado = Usuario.usuarioNoRegistradoInterfaz.login(
							Credenciales.user, Credenciales.pass);
					System.out.println("Relogin de emergencia resultado: "
							+ (Usuario.usuarioRegistrado != null ? "exitoso" : "fallido"));
					return Usuario.usuarioRegistrado;
				} catch (Exception e2) {
					System.err.println("Error en relogin de emergencia: " + e2.getMessage());
				}
			}
			return null;
		}
	}

	/**
	 * Método para verificar el estado del usuario actual
	 */
	public static void verificarEstadoUsuario(String contexto) {
		try {
			if (Usuario.usuarioRegistrado != null) {
				System.out.println("[" + contexto + "] Usuario OK: " + Usuario.usuarioRegistrado.getNickname()
						+ " (ID: " + Usuario.usuarioRegistrado.getId_usuario() + ")");
			} else {
				System.err.println("[" + contexto + "] ERROR: Usuario es NULL");
			}
		} catch (Exception e) {
			System.err.println("[" + contexto + "] ERROR verificando usuario: " + e.getMessage());
		}
	}
}
