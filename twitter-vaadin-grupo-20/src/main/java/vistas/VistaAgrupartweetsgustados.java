package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;

@Tag("vista-agrupartweetsgustados")
@JsModule("./views/vista-agrupartweetsgustados.ts")
public class VistaAgrupartweetsgustados extends LitTemplate {

	@Id("mainContainer")
	private Element mainContainer;
	@Id("tweetsContainer")
	private Element tweetsContainer;
	@Id("moreTweetsButtonContainer")
	private HorizontalLayout moreTweetsButtonContainer;
	@Id("mostrarMasTweetsButton")
	private Button mostrarMasTweetsButton;

	public VistaAgrupartweetsgustados() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}

	public Element getTweetsContainer() {
		return tweetsContainer;
	}

	public void setTweetsContainer(Element tweetsContainer) {
		this.tweetsContainer = tweetsContainer;
	}

	public HorizontalLayout getMoreTweetsButtonContainer() {
		return moreTweetsButtonContainer;
	}

	public void setMoreTweetsButtonContainer(HorizontalLayout moreTweetsButtonContainer) {
		this.moreTweetsButtonContainer = moreTweetsButtonContainer;
	}

	public Button getMostrarMasTweetsButton() {
		return mostrarMasTweetsButton;
	}

	public void setMostrarMasTweetsButton(Button mostrarMasTweetsButton) {
		this.mostrarMasTweetsButton = mostrarMasTweetsButton;
	}

}