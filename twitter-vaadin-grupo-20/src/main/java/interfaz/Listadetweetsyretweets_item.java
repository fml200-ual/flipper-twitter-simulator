package interfaz;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.IFrame;
import vistas.VistaListadetweetsyretweets_item;
import mds2.MainView.Pantalla;

public class Listadetweetsyretweets_item extends VistaListadetweetsyretweets_item {
    // private event _mostrarmstweets;
    public Listadetweetsyretweets _listadetweetsyretweets;
    public TweetRetweet tweetRetweet;
    public Verperfilnoregistrado _verperfilnoregistrado;
    
    public basededatos.Tweet t;

    public Listadetweetsyretweets_item(Listadetweetsyretweets _listadetweetsyretweets) {
        super();
        this._listadetweetsyretweets = _listadetweetsyretweets;
    }
    
    // Constructor que acepta Tweet - implementación completa
    public Listadetweetsyretweets_item(Listadetweetsyretweets _listadetweetsyretweets, basededatos.Tweet t) {
        super();
        this._listadetweetsyretweets = _listadetweetsyretweets;
        this.t = t;
        
        // Configuración inicial
        this.getDocumentoContent_LY().setVisible(false);
        this.getRetweetContent_LY().setMaxWidth("600px");
        this.getRetweetContent_LY().setMaxHeight("400px");
        this.getRetweetContent_LY().setVisible(false);
        
        // Foto de perfil del usuario que publicó
        Image img = new Image(this.t.getPublicado_por().getFotoPerfilURL(), null);
        img.setWidth("50px");
        img.setHeight("50px");
        this.getFotoPerfil_LY().add(img);
        
        // Información del tweet
        this.getNickBT().setText(this.t.getPublicado_por().getNickname());
        this.getFechaPublicacion().setText(this.t.getFechaPublicacion().toString());
        this.getContenidoTweet().setText(this.t.getContenidoTweet());
        
        // Ocultar contenido si está vacío
        if (this.getContenidoTweet().getText().isBlank()) {
            this.getContenidoTweet().setVisible(false);
        }
        
        // Contadores
        this.getNumCom().setText("" + this.t.tiene.size());
        this.getNumRT().setText("" + this.t.retweets.size());
        this.getNumMG().setText("" + this.t.recibe_me_gusta.size());
        
        // Manejo de documentos (imágenes/videos)
        String tipoDocumento = null;
        basededatos.Documento doc = this.t.getDocumento();
        if (doc != null) {
            tipoDocumento = doc.getTipo();
        }
        
        if (tipoDocumento != null) {
            if (tipoDocumento.equals("IMAGEN")) {
                Image imgDocumento = new Image(this.t.getDocumento().getImagenVideoURL(), null);
                imgDocumento.setMaxWidth("400px");
                imgDocumento.setMaxHeight("200px");
                this.getDocumentoContent_LY().add(imgDocumento);
            } else if (tipoDocumento.equals("VIDEO")) {
                IFrame videoFrame = new IFrame(this.t.getDocumento().getImagenVideoURL());
                videoFrame.setMaxWidth("400px");
                videoFrame.setMaxHeight("200px");
                this.getDocumentoContent_LY().add(videoFrame);
            }
            this.getDocumentoContent_LY().setVisible(true);
        }
        
        // Event listeners
        this.getNickBT().addClickListener(event -> VerperfildeUsuario());
        this.getComentariosBT().addClickListener(event -> Vertweet());
    }
    
    public void Vertweet() {
        this._vertweet = new Vertweet(this);
        Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
        Pantalla.MainView.removeAll();
        Pantalla.MainView.add(this._vertweet);
    }

    public void VerperfildeUsuario() {
        this._verperfilnoregistrado = new Verperfilnoregistrado(this, this.t.getPublicado_por());
        Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
        Pantalla.MainView.removeAll();
        Pantalla.MainView.add(this._verperfilnoregistrado);
    }

    public void Mostrarmstweets() {
        throw new UnsupportedOperationException();
    }
}