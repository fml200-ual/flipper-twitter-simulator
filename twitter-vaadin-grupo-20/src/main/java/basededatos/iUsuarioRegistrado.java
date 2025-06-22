package basededatos;

import java.util.Date;


public interface iUsuarioRegistrado {

	public Usuario_Registrado modificarPerfilSimple(int id_usuario, String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String contrasena);

	public Usuario_Registrado modificarPerfilCompleto(int id_usuario, String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena);

	public Usuario_Registrado publicarTweet(int id_usuario, String contenidoTweet, Date fechaPublicacion, String URLDocumento, String tipoDocumento, String[] hashtags, String[] menciones);

	public Usuario_Registrado publicarComentario(int id_usuario, int id_tweet, String contenidoComentario, String URLDocumento, Date fechaPublicacion, String tipoDocumento);

	public Usuario_Registrado seguir(int id_usuario, int id_usuarioSeguido, Date fechaSeguimiento);

	public void eliminarPerfil(int id_usuario);

	public Usuario_Registrado darMeGustaTweet(int id_usuario, int id_tweet);

	public Usuario_Registrado bloquear(int id_usuario, int id_usuarioBloqueado);

	public Usuario_Registrado darRetweet(int id_usuario, int id_tweet, Date fechaPublicacion);

	public Usuario_Registrado publicarRetweet(int id_usuario, int id_tweetRetweeteado, String contenidoRetweet, String URLDocumento, String tipoDocumento, Date fechaPublicacion, String[] hashtags, String[] menciones);

	public Usuario_Registrado[] cargarUsuarios();

	public Hashtag[] cargarHashtags();

	public Usuario_Registrado darMeGustaComentario(int id_usuario, int id_comentario);

	public Usuario_Registrado eliminarMgTweet(int id_usuario, int id_tweet);

	public Usuario_Registrado eliminarRetweet(int id_usuario, int id_tweet);

	public Usuario_Registrado eliminarMgComentario(int id_usuario, int id_comentario);
	
	public Tweet obtenerTweetByID(int id_tweet);
	
	public Comentario obtenerComentarioByID(int id_comentario);
	
	public Usuario_Registrado obtenerUsuarioByID(int id_usuario);
	
	public Usuario_Registrado desbloquear(int id_usuario, int id_usuario_desbloqueado);
	
	public Usuario_Registrado quitarSeguimiento(int id_usuario, int id_usuario_quitadoSeguimiento);
	
	public Usuario_Registrado validacionCorreo(String correoElectronico);
	
}