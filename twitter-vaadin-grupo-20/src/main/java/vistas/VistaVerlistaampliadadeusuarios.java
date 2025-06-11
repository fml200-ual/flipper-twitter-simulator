package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Div;

@Tag("vista-verlistaampliadadeusuarios")
@JsModule("./views/vista-verlistaampliadadeusuarios.ts")
public class VistaVerlistaampliadadeusuarios extends LitTemplate {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("div")
	private Div div;

	public VistaVerlistaampliadadeusuarios() {
        // You can initialise any data required for the connected UI components here.
    }

}