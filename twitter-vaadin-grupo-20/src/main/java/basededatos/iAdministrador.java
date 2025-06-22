package basededatos;

import java.util.Date;


public interface iAdministrador {

	public Administrador banear(int id_administrador, int id_usuarioBaneado, int duracionBaneo, Date fechaInicioBaneo);

	public void eliminarUsuario(int id_usuario);

	public Usuario_Registrado[] cargarUsuarios();

	public Tweet[] cargarTweets();

	public void eliminarTweet(int id_tweet);
	
	public void eliminarComentario(int id_comentario);
}