package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
    Tweet[] tweetsMockup = crearTweetsMockup();

    // Configurar el layout principal como scrolleable
    this.getMainLayout().getStyle()
        .set("height", "500px")
        .set("overflow-y", "auto")
        .set("overflow-x", "hidden")
        .set("padding", "10px")
        .set("gap", "10px");

    for (Tweet tweet : tweetsMockup) {
        System.out.println("Tweet mockup cargado: " + tweet.getContenidoTweet());
        // Crear elementos de texto simples para mostrar los tweets
        com.vaadin.flow.component.html.Div tweetDiv = new com.vaadin.flow.component.html.Div();
        tweetDiv.getStyle()
            .set("border", "1px solid #333")
            .set("border-radius", "8px")
            .set("padding", "15px")
            .set("margin-bottom", "10px")
            .set("background-color", "#1a1a1a")
            .set("color", "#ffffff");
        
        // Contenido del tweet
        com.vaadin.flow.component.html.Paragraph contenido = new com.vaadin.flow.component.html.Paragraph(tweet.getContenidoTweet());
        contenido.getStyle().set("margin", "0 0 10px 0");
        
        // Usuario y fecha
        String usuario = tweet.getPublicado_por() != null ? "@" + tweet.getPublicado_por().getNickname() : "@usuario";
        String fecha = tweet.getFechaPublicacion() != null ? tweet.getFechaPublicacion().toString() : "Ahora";
        com.vaadin.flow.component.html.Div meta = new com.vaadin.flow.component.html.Div();
        meta.setText(usuario + " • " + fecha);
        meta.getStyle()
            .set("font-size", "12px")
            .set("color", "#888")
            .set("margin", "0");
        
        tweetDiv.add(contenido, meta);
        this.getMainLayout().as(VerticalLayout.class).add(tweetDiv);
    }
}

private Tweet[] crearTweetsMockup() {
    // Crear tweets de ejemplo para mostrar en el hashtag
    Tweet[] tweets = new Tweet[5];
    
    try {
        // Tweet 1
        tweets[0] = new Tweet();
        tweets[0].setContenidoTweet("¡Explorando nuevas tecnologías con " + _hashtag.getHashtag() + "! 🚀 #innovacion #tech");
        tweets[0].setFechaPublicacion(new java.util.Date());
        
        // Tweet 2
        tweets[1] = new Tweet();
        tweets[1].setContenidoTweet("Increíble cómo " + _hashtag.getHashtag() + " está cambiando el mundo 🌍 ¡El futuro es ahora!");
        tweets[1].setFechaPublicacion(new java.util.Date(System.currentTimeMillis() - 3600000)); // 1 hora atrás
        
        // Tweet 3
        tweets[2] = new Tweet();
        tweets[2].setContenidoTweet("Tutorial completo sobre " + _hashtag.getHashtag() + " disponible en mi blog 📚 ¡No te lo pierdas!");
        tweets[2].setFechaPublicacion(new java.util.Date(System.currentTimeMillis() - 7200000)); // 2 horas atrás
        
        // Tweet 4
        tweets[3] = new Tweet();
        tweets[3].setContenidoTweet("Debate interesante: ¿Es " + _hashtag.getHashtag() + " realmente el futuro? 🤔 ¿Qué opinas?");
        tweets[3].setFechaPublicacion(new java.util.Date(System.currentTimeMillis() - 14400000)); // 4 horas atrás
        
        // Tweet 5
        tweets[4] = new Tweet();
        tweets[4].setContenidoTweet("Mi experiencia personal con " + _hashtag.getHashtag() + " ha sido increíble 💡 Recomendado 100%");
        tweets[4].setFechaPublicacion(new java.util.Date(System.currentTimeMillis() - 21600000)); // 6 horas atrás
        
        // Crear usuarios mockup
        basededatos.Usuario_Registrado[] usuariosMockup = crearUsuariosMockup();
        
        // Asignar usuarios a los tweets
        for (int i = 0; i < tweets.length; i++) {
            tweets[i].setPublicado_por(usuariosMockup[i % usuariosMockup.length]);
        }
        
    } catch (Exception e) {
        System.err.println("Error creando tweets mockup: " + e.getMessage());
    }
    
    return tweets;
}

private basededatos.Usuario_Registrado[] crearUsuariosMockup() {
    basededatos.Usuario_Registrado[] usuarios = new basededatos.Usuario_Registrado[3];
    
    try {
        // Usuario 1
        usuarios[0] = new basededatos.Usuario_Registrado();
        usuarios[0].setNickname("tech_guru");
        usuarios[0].setDescripcion("Desarrolladora apasionada por la tecnología");
        
        // Usuario 2
        usuarios[1] = new basededatos.Usuario_Registrado();
        usuarios[1].setNickname("innovator_2024");
        usuarios[1].setDescripcion("Especialista en innovación digital");
        
        // Usuario 3
        usuarios[2] = new basededatos.Usuario_Registrado();
        usuarios[2].setNickname("future_dev");
        usuarios[2].setDescripcion("Frontend developer & UI/UX designer");
        
    } catch (Exception e) {
        System.err.println("Error creando usuarios mockup: " + e.getMessage());
    }
    
    return usuarios;
}
}