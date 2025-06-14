package interfaz;

import com.vaadin.flow.component.button.Button;

import mds2.MainView.Pantalla;
import vistas.VistaVerhashtag;

public class Verhashtag extends VistaVerhashtag {
    protected void addBackButton() {
        Button backButton = new Button("← Volver", event -> {
            Pantalla.MainView.removeAll();
            Pantalla.MainView.add(Pantalla.Anterior);
        });

        this.getH1().add(backButton);
    }
}