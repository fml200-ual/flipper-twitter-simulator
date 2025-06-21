package mds2;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import interfaz.*;

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
		Pantalla.usuario = 1;
		ACT01UsuarioNoRegistrado test = new ACT01UsuarioNoRegistrado(this);
		add(test);
	}
}
