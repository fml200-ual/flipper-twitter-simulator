/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteProyectoMDS120242025Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = basededatos.ProyectoMDS120242025PersistentManager.instance().getSession().beginTransaction();
		try {
			basededatos.Usuario_Autentificado lbasededatosUsuario_Autentificado = basededatos.Usuario_AutentificadoDAO.loadUsuario_AutentificadoByQuery(null, null);
			// Delete the persistent object
			basededatos.Usuario_AutentificadoDAO.delete(lbasededatosUsuario_Autentificado);
			basededatos.Usuario_Registrado lbasededatosUsuario_Registrado = basededatos.Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery(null, null);
			// Delete the persistent object
			basededatos.Usuario_RegistradoDAO.delete(lbasededatosUsuario_Registrado);
			basededatos.Hashtag lbasededatosHashtag = basededatos.HashtagDAO.loadHashtagByQuery(null, null);
			// Delete the persistent object
			basededatos.HashtagDAO.delete(lbasededatosHashtag);
			basededatos.Administrador lbasededatosAdministrador = basededatos.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			basededatos.AdministradorDAO.delete(lbasededatosAdministrador);
			basededatos.Tweet lbasededatosTweet = basededatos.TweetDAO.loadTweetByQuery(null, null);
			// Delete the persistent object
			basededatos.TweetDAO.delete(lbasededatosTweet);
			basededatos.Documento lbasededatosDocumento = basededatos.DocumentoDAO.loadDocumentoByQuery(null, null);
			// Delete the persistent object
			basededatos.DocumentoDAO.delete(lbasededatosDocumento);
			basededatos.PropiedadesMencion lbasededatosPropiedadesMencion = basededatos.PropiedadesMencionDAO.loadPropiedadesMencionByQuery(null, null);
			// Delete the persistent object
			basededatos.PropiedadesMencionDAO.delete(lbasededatosPropiedadesMencion);
			basededatos.PropiedadesSeguidos lbasededatosPropiedadesSeguidos = basededatos.PropiedadesSeguidosDAO.loadPropiedadesSeguidosByQuery(null, null);
			// Delete the persistent object
			basededatos.PropiedadesSeguidosDAO.delete(lbasededatosPropiedadesSeguidos);
			basededatos.Retweet lbasededatosRetweet = basededatos.RetweetDAO.loadRetweetByQuery(null, null);
			// Delete the persistent object
			basededatos.RetweetDAO.delete(lbasededatosRetweet);
			basededatos.PropiedadesBaneo lbasededatosPropiedadesBaneo = basededatos.PropiedadesBaneoDAO.loadPropiedadesBaneoByQuery(null, null);
			// Delete the persistent object
			basededatos.PropiedadesBaneoDAO.delete(lbasededatosPropiedadesBaneo);
			basededatos.Comentario lbasededatosComentario = basededatos.ComentarioDAO.loadComentarioByQuery(null, null);
			// Delete the persistent object
			basededatos.ComentarioDAO.delete(lbasededatosComentario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteProyectoMDS120242025Data deleteProyectoMDS120242025Data = new DeleteProyectoMDS120242025Data();
			try {
				deleteProyectoMDS120242025Data.deleteTestData();
			}
			finally {
				basededatos.ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
