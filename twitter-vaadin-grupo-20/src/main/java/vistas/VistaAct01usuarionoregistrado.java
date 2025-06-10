package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;

@Tag("vista-act01usuarionoregistrado")
@JsModule("./views/vista-act01usuarionoregistrado.ts")
public class VistaAct01usuarionoregistrado extends LitTemplate {

    @Id("verticalLayoutListaUsuarios")
    private Element verticalLayoutListaUsuarios;
    @Id("verticalLayoutCentralNoRegistrado")
    private Element verticalLayoutCentralNoRegistrado;
    @Id("verticalLayoutListaHashtagsNoRegistrado")
    private Element verticalLayoutListaHashtagsNoRegistrado;

    public VistaAct01usuarionoregistrado() {
        // You can initialise any data required for the connected UI components here.
    }

    public Element getVerticalLayoutListaUsuarios() {
        return verticalLayoutListaUsuarios;
    }

    public Element getVerticalLayoutCentralNoRegistrado() {
        return verticalLayoutCentralNoRegistrado;
    }

    public Element getVerticalLayoutListaHashtagsNoRegistrado() {
        return verticalLayoutListaHashtagsNoRegistrado;
    }

    // Remove this method to render the contents of this view inside Shadow DOM
    public com.vaadin.flow.component.Component createRenderRoot() {
        return this;
    }
}