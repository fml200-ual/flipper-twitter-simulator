package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.NativeButton;

@Tag("vista-verhashtag")
@JsModule("./views/vista-verhashtag.ts")
public class VistaVerhashtag extends LitTemplate {

	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public H1 getH1() {
		return h1;
	}

	public void setH1(H1 h1) {
		this.h1 = h1;
	}

	public Element getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(Element mainLayout) {
		this.mainLayout = mainLayout;
	}

	public NativeButton getShowMoreButton() {
		return showMoreButton;
	}

	public void setShowMoreButton(NativeButton showMoreButton) {
		this.showMoreButton = showMoreButton;
	}

	@Id("h1")
	private H1 h1;
	@Id("main-layout")
	private Element mainLayout;
	@Id("show-more-button")
	private NativeButton showMoreButton;

	public VistaVerhashtag() {
		// You can initialise any data required for the connected UI components here.
	}

}