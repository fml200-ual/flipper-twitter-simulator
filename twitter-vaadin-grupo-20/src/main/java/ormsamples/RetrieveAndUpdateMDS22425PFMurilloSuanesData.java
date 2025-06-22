/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateMDS22425PFMurilloSuanesData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = basededatos.MDS22425PFMurilloSuanesPersistentManager.instance().getSession().beginTransaction();
		try {
			basededatos.Documento lbasededatosDocumento = basededatos.DocumentoDAO.loadDocumentoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.DocumentoDAO.save(lbasededatosDocumento);
			basededatos.PropiedadesBaneo lbasededatosPropiedadesBaneo = basededatos.PropiedadesBaneoDAO.loadPropiedadesBaneoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.PropiedadesBaneoDAO.save(lbasededatosPropiedadesBaneo);
			basededatos.Usuario_Autentificado lbasededatosUsuario_Autentificado = basededatos.Usuario_AutentificadoDAO.loadUsuario_AutentificadoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.Usuario_AutentificadoDAO.save(lbasededatosUsuario_Autentificado);
			basededatos.Administrador lbasededatosAdministrador = basededatos.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.AdministradorDAO.save(lbasededatosAdministrador);
			basededatos.Usuario_Registrado lbasededatosUsuario_Registrado = basededatos.Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.Usuario_RegistradoDAO.save(lbasededatosUsuario_Registrado);
			basededatos.Hashtag lbasededatosHashtag = basededatos.HashtagDAO.loadHashtagByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.HashtagDAO.save(lbasededatosHashtag);
			basededatos.Tweet lbasededatosTweet = basededatos.TweetDAO.loadTweetByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.TweetDAO.save(lbasededatosTweet);
			basededatos.Retweet lbasededatosRetweet = basededatos.RetweetDAO.loadRetweetByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.RetweetDAO.save(lbasededatosRetweet);
			basededatos.PropiedadesSeguidos lbasededatosPropiedadesSeguidos = basededatos.PropiedadesSeguidosDAO.loadPropiedadesSeguidosByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.PropiedadesSeguidosDAO.save(lbasededatosPropiedadesSeguidos);
			basededatos.Comentario lbasededatosComentario = basededatos.ComentarioDAO.loadComentarioByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.ComentarioDAO.save(lbasededatosComentario);
			basededatos.PropiedadesMencion lbasededatosPropiedadesMencion = basededatos.PropiedadesMencionDAO.loadPropiedadesMencionByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.PropiedadesMencionDAO.save(lbasededatosPropiedadesMencion);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Documento by DocumentoCriteria");
		basededatos.DocumentoCriteria lbasededatosDocumentoCriteria = new basededatos.DocumentoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosDocumentoCriteria.id_documento.eq();
		System.out.println(lbasededatosDocumentoCriteria.uniqueDocumento());
		
		System.out.println("Retrieving PropiedadesBaneo by PropiedadesBaneoCriteria");
		basededatos.PropiedadesBaneoCriteria lbasededatosPropiedadesBaneoCriteria = new basededatos.PropiedadesBaneoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosPropiedadesBaneoCriteria.ID.eq();
		System.out.println(lbasededatosPropiedadesBaneoCriteria.uniquePropiedadesBaneo());
		
		System.out.println("Retrieving Usuario_Autentificado by Usuario_AutentificadoCriteria");
		basededatos.Usuario_AutentificadoCriteria lbasededatosUsuario_AutentificadoCriteria = new basededatos.Usuario_AutentificadoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosUsuario_AutentificadoCriteria.id_usuario.eq();
		System.out.println(lbasededatosUsuario_AutentificadoCriteria.uniqueUsuario_Autentificado());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		basededatos.AdministradorCriteria lbasededatosAdministradorCriteria = new basededatos.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosAdministradorCriteria.id_usuario.eq();
		System.out.println(lbasededatosAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Usuario_Registrado by Usuario_RegistradoCriteria");
		basededatos.Usuario_RegistradoCriteria lbasededatosUsuario_RegistradoCriteria = new basededatos.Usuario_RegistradoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosUsuario_RegistradoCriteria.id_usuario.eq();
		System.out.println(lbasededatosUsuario_RegistradoCriteria.uniqueUsuario_Registrado());
		
		System.out.println("Retrieving Hashtag by HashtagCriteria");
		basededatos.HashtagCriteria lbasededatosHashtagCriteria = new basededatos.HashtagCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosHashtagCriteria.id_hashtag.eq();
		System.out.println(lbasededatosHashtagCriteria.uniqueHashtag());
		
		System.out.println("Retrieving Tweet by TweetCriteria");
		basededatos.TweetCriteria lbasededatosTweetCriteria = new basededatos.TweetCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosTweetCriteria.id_tweet.eq();
		System.out.println(lbasededatosTweetCriteria.uniqueTweet());
		
		System.out.println("Retrieving Retweet by RetweetCriteria");
		basededatos.RetweetCriteria lbasededatosRetweetCriteria = new basededatos.RetweetCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosRetweetCriteria.ID.eq();
		System.out.println(lbasededatosRetweetCriteria.uniqueRetweet());
		
		System.out.println("Retrieving PropiedadesSeguidos by PropiedadesSeguidosCriteria");
		basededatos.PropiedadesSeguidosCriteria lbasededatosPropiedadesSeguidosCriteria = new basededatos.PropiedadesSeguidosCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosPropiedadesSeguidosCriteria.ID.eq();
		System.out.println(lbasededatosPropiedadesSeguidosCriteria.uniquePropiedadesSeguidos());
		
		System.out.println("Retrieving Comentario by ComentarioCriteria");
		basededatos.ComentarioCriteria lbasededatosComentarioCriteria = new basededatos.ComentarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosComentarioCriteria.id_comentario.eq();
		System.out.println(lbasededatosComentarioCriteria.uniqueComentario());
		
		System.out.println("Retrieving PropiedadesMencion by PropiedadesMencionCriteria");
		basededatos.PropiedadesMencionCriteria lbasededatosPropiedadesMencionCriteria = new basededatos.PropiedadesMencionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosPropiedadesMencionCriteria.ID.eq();
		System.out.println(lbasededatosPropiedadesMencionCriteria.uniquePropiedadesMencion());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateMDS22425PFMurilloSuanesData retrieveAndUpdateMDS22425PFMurilloSuanesData = new RetrieveAndUpdateMDS22425PFMurilloSuanesData();
			try {
				retrieveAndUpdateMDS22425PFMurilloSuanesData.retrieveAndUpdateTestData();
				//retrieveAndUpdateMDS22425PFMurilloSuanesData.retrieveByCriteria();
			}
			finally {
				basededatos.MDS22425PFMurilloSuanesPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
