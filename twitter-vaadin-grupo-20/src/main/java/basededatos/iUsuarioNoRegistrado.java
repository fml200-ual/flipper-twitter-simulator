package basededatos;

import java.util.Date;

public interface iUsuarioNoRegistrado {

	public Usuario_Registrado login(String nombreUsuario, String contrasena);

	public Administrador loginAdmin(String nombreUsuario, String contrasena);

	public Usuario_Registrado validacionCorreo(String correoElectronico);

	public void cambiarContrasena(int id_usuario, String contrasena);

	public Usuario_Registrado registrar(String nickname, String descripcion, String imagenFondoURL, String fotoPerfilURL, String correoElectronico, String contrasena, Date fechaRegistro);

	public Usuario_Registrado[] cargarUsuarios();

	public Hashtag[] cargarHashtags();
}