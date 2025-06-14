package interfaz;

import com.vaadin.flow.component.button.Button;

import mds2.MainView.Pantalla;
import vistas.VistaTweetretweet;

public class TweetRetweet extends VistaTweetretweet {
    protected void addBackButton() {
        Button backButton = new Button("← Volver", event -> {
            Pantalla.MainView.removeAll();
            Pantalla.MainView.add(Pantalla.Anterior);
        });
        this.getMainLayout().add(backButton);
    }
}