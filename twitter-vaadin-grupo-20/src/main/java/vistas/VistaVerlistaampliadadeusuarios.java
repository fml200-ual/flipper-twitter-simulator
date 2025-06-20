package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.button.Button;

@Tag("vista-verlistaampliadadeusuarios")
@JsModule("./views/vista-verlistaampliadadeusuarios.ts")
public class VistaVerlistaampliadadeusuarios extends LitTemplate {

	@Id("backButton")
	private Button backButton;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("div")
	private Div div;
	public VistaVerlistaampliadadeusuarios() {
		// You can initialise any data required for the connected UI components here.
	}

	public Button getBackButton() {
		return backButton;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Div getDiv() {
		return div;
	}
	public void setDiv(Div div) {
		this.div = div;
	}

}