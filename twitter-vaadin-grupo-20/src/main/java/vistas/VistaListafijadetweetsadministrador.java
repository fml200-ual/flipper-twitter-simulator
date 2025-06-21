package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;

@Tag("vista-listafijadetweetsadministrador")
@JsModule("./views/vista-listafijadetweetsadministrador.ts")
public class VistaListafijadetweetsadministrador extends LitTemplate {

	@Id("tweetsListContainer")
	private Element tweetsListContainer;

	public VistaListafijadetweetsadministrador() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getTweetsListContainer() {
		return tweetsListContainer;
	}

	public void setTweetsListContainer(Element tweetsListContainer) {
		this.tweetsListContainer = tweetsListContainer;
	}

}