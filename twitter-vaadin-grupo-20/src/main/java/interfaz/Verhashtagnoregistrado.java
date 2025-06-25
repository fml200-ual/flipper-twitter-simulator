package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.Hashtag;
import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Verhashtagnoregistrado extends Verhashtag {
    public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
    public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;
    public Listadetweetsyretweetsnoregistrado _listadetweetsyretweetsnoregistrado;
    public basededatos.Hashtag _hashtag;

    public Verhashtagnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado, Hashtag hashtag) {
        super();
        this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;
        this._hashtag = hashtag;

        this.getH1().setText(hashtag.getHashtag());

        Listadetweetsyretweetsnoregistrado();

        this.getVolverButton().addClickListener(event -> {
            Pantalla.MainView.removeAll();
            Pantalla.MainView.add(_listafijadehashtagsnoregistrado._aCT01UsuarioNoRegistrado);
        });

    }

    public Verhashtagnoregistrado(Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado,
            Hashtag hashtag) {
        super();
        this._verlistaampliadadehashtagsnoregistrado = _verlistaampliadadehashtagsnoregistrado;
        this._hashtag = hashtag;

        this.getH1().setText(hashtag.getHashtag());

        Listadetweetsyretweetsnoregistrado();

        this.getVolverButton().addClickListener(event -> {
            Pantalla.MainView.removeAll();
            Pantalla.MainView.add(_verlistaampliadadehashtagsnoregistrado);
        });
    }

    public void Listadetweetsyretweetsnoregistrado() {
        // Crear tweets mockup directamente en el layout principal
        BDPrincipal bdPrincipal = new BDPrincipal();
        Tweet[] tweets = bdPrincipal.cargarTweetsDeHashtag(this._hashtag.getId_hashtag());
        _listadetweetsyretweetsnoregistrado = new Listadetweetsyretweetsnoregistrado(this);

        for (Tweet tweet : tweets) {
            Listadetweetsyretweetsregistrado_item tweetDiv = new Listadetweetsyretweetsregistrado_item(
                    _listadetweetsyretweetsnoregistrado, tweet);

            _listadetweetsyretweetsnoregistrado.getMainContainer()
                    .as(VerticalLayout.class).add(tweetDiv);
        }

        this.getMainLayout().as(VerticalLayout.class).add(_listadetweetsyretweetsnoregistrado);
    }
}