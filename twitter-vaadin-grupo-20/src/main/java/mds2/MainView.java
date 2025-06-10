package mds2;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import interfaz.ACT03Administrador;
import interfaz.ACT02UsuarioRegistrado;
import interfaz.ACT01UsuarioNoRegistrado;


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

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public MainView(@Autowired GreetService service) {

    	/* 
    	 * List l = new Lista(this);
    	 * Lista_item l1 = new Lista_item(l);
    	 * Lista_item l2 = new Lista_item(l);
    	 * l.getLista().add(l1);
    	 * l.getLista().add(l2); 
    	 * add(l); pa que se vea en el main view
    	 * para meterlo en un vertical layout es .as(VerticalLayout.class).removeAll(); o el metodo q sea
    	 */
    	

    	
	/*
		// ListaHastags
    	ListaHashtagsNR lista = new ListaHashtagsNR();
    	ListaHashtagsNR_item item1 = new ListaHashtagsNR_item(lista);
    	ListaHashtagsNR_item item2 = new ListaHashtagsNR_item(lista);
    	lista.getLayoutHastags_item1().as(VerticalLayout.class).add(item1);
    	lista.getLayoutHastags_item1().as(VerticalLayout.class).add(item2);
    	add(lista);
    */
    /*
    	ListaComentariosA lista = new ListaComentariosA();
    	ListaComentariosA_item item1 = new ListaComentariosA_item(lista);
    	ListaComentariosA_item item2 = new ListaComentariosA_item(lista);
    	lista.getvL_listacomentarios_items().as(VerticalLayout.class).add(item1);
    	lista.getvL_listacomentarios_items().as(VerticalLayout.class).add(item2);
    	add(lista);
    */
    /*
    	ListaNotificaciones lista = new ListaNotificaciones();
    	ListaNotificaciones_item item1 = new ListaNotificaciones_item(lista);
    	ListaNotificaciones_item item2 = new ListaNotificaciones_item(lista);
    	lista.getvL_listanotificaciones_item().as(VerticalLayout.class).add(item1);
    	lista.getvL_listanotificaciones_item().as(VerticalLayout.class).add(item2);
    	add(lista);
    */

    
//    	ListaUsuariosNR lista = new ListaUsuariosNR();
////    	ListaUsuariosNR_item item1 = new ListaUsuariosNR_item(lista);
////    	ListaUsuariosNR_item item2 = new ListaUsuariosNR_item(lista);
////    	lista.getVerticalLayoutListaUsuarios().as(VerticalLayout.class).add(item1);
////    	lista.getVerticalLayoutListaUsuarios().as(VerticalLayout.class).add(item2);
//    	add(lista);
    	
    	// Estancia fija para administrador
    	ACT01UsuarioNoRegistrado administradorUsuarioRegistrado = new ACT01UsuarioNoRegistrado(this);
    	add(administradorUsuarioRegistrado);
    }
}
