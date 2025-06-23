package basededatos;

import java.util.Date;
import java.util.Vector;


import org.orm.PersistentException;
import org.orm.PersistentTransaction;


public class BD_Comentario {
	public BDPrincipal _bd_prin_comentario;
	public Vector<Comentario> _contiene_comentario = new Vector<Comentario>();

	public int nuevoComentario(int id_usuario, int id_tweet, String contenidoComentario, Date fechaPublicacion) throws PersistentException {
		int id_comentario = -1;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Usuario_Registrado user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuario);
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			Comentario comentario = ComentarioDAO.createComentario();		
			comentario.setPublicado_por(user);
			comentario.setPertenece(tweet);
			comentario.setContenidoComentario(contenidoComentario);
			comentario.setFechaPublicacion(fechaPublicacion);
			ComentarioDAO.save(comentario);
			id_comentario = comentario.getId_comentario();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return id_comentario;
	}
	
	public void eliminarComentario(int id_comentario) throws PersistentException {
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Comentario comentario = ComentarioDAO.getComentarioByORMID(id_comentario);
			Documento doc = comentario.getDocumento();
			if (doc != null) {
				DocumentoDAO.delete(doc);
			}
			ComentarioDAO.deleteAndDissociate(comentario);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
	}
	
	
	public Comentario obtenerComentarioByID(int id_comentario) throws PersistentException {
		Comentario comentario = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			comentario = ComentarioDAO.getComentarioByORMID(id_comentario);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return comentario;
	}
	
}
