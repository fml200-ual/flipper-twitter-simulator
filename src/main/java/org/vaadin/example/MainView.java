package org.vaadin.example;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import interfaz.ACT01UsuarioNoRegistrado;
import interfaz.ACT02UsuarioRegistrado;
import interfaz.ACT03Administrador;
import interfaz.Agrupartweets;
import interfaz.Agrupartweetsgustados;
import interfaz.Listadecomentarios_item;
import interfaz.Listadecomentariosadministrador;
import interfaz.Listadecomentariosadministrador_item;
import interfaz.Listadecomentariosnoregistrado;
import interfaz.Listadecomentariosnoregistrado_item;
import interfaz.Listadehashtags;
import interfaz.Listadehashtags_item;
import interfaz.Listadenotificaciones;
import interfaz.Listadenotificaciones_item;
import interfaz.Listadetweetsyretweets;
import interfaz.Listadetweetsyretweetsadministrador;
import interfaz.Listadetweetsyretweetsadministrador_item;
import interfaz.Listadetweetsyretweetsnoregistrado;
import interfaz.Listadetweetsyretweetsnoregistrado_item;
import interfaz.Listadeusuarios;
import interfaz.Listadeusuarios_item;
import interfaz.Test;
import interfaz.Verlistaampliadadeusuarios;
import interfaz.Vernotificacionesderetweets;
import vistas.VistaListadecomentarios;
import vistas.VistaListadecomentarios_item;
import vistas.VistaListadehashtags;
import vistas.VistaListadehashtags_item;
import vistas.VistaListadenotificaciones;
import vistas.VistaListadenotificaciones_item;
import vistas.VistaListadetweetsyretweets;
import vistas.VistaListadetweetsyretweets_item;
import vistas.VistaListadeusuarios;
import vistas.VistaListadeusuarios_item;

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
     *                The message service. Automatically injected Spring managed  
     *                bean.
     */
    public MainView(@Autowired GreetService service) {
        // Use custom CSS classes to apply styling. This is defined in
        // shared-styles.css. 
        // addClassName("centered-content"); 
//    	Test test = new Test();
//        add(test);
    	Listadeusuarios test = new Listadeusuarios((Verlistaampliadadeusuarios) null);
    	test.getMainContainer().as(VerticalLayout.class).add(new Listadeusuarios_item(null));
    	test.getMainContainer().as(VerticalLayout.class).add(new Listadeusuarios_item(null));
    	test.getMainContainer().as(VerticalLayout.class).add(new Listadeusuarios_item(null));
    	test.getMainContainer().as(VerticalLayout.class).add(new Listadeusuarios_item(null));
    	
    	add(test);
    }

}
