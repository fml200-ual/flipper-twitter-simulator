package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.button.Button;

@Tag("vista-listafijadetweetsadministrador")
@JsModule("./views/vista-listafijadetweetsadministrador.ts")
public class VistaListafijadetweetsadministrador extends LitTemplate {

	@Id("mainContainer")
	private Element mainContainer;
	@Id("tweetsListContainer")
	private Element tweetsListContainer;
	@Id("showMoreButton")
	private Button showMoreButton;

	public VistaListafijadetweetsadministrador() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}

	public Element getTweetsListContainer() {
		return tweetsListContainer;
	}

	public void setTweetsListContainer(Element tweetsListContainer) {
		this.tweetsListContainer = tweetsListContainer;
	}

	public Button getShowMoreButton() {
		return showMoreButton;
	}

	public void setShowMoreButton(Button showMoreButton) {
		this.showMoreButton = showMoreButton;
	}

}