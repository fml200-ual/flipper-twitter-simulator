/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;

public class ListProyectoMDS120242025Data {
	private static final int ROW_COUNT = 100;

	public void listTestData() throws PersistentException {
		System.out.println("Listing Usuario_Autentificado...");
		basededatos.Usuario_Autentificado[] basededatosUsuario_Autentificados = basededatos.Usuario_AutentificadoDAO
				.listUsuario_AutentificadoByQuery(null, null);
		int length = Math.min(basededatosUsuario_Autentificados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosUsuario_Autentificados[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Usuario_Registrado...");
		basededatos.Usuario_Registrado[] basededatosUsuario_Registrados = basededatos.Usuario_RegistradoDAO
				.listUsuario_RegistradoByQuery(null, null);
		length = Math.min(basededatosUsuario_Registrados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosUsuario_Registrados[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Hashtag...");
		basededatos.Hashtag[] basededatosHashtags = basededatos.HashtagDAO.listHashtagByQuery(null, null);
		length = Math.min(basededatosHashtags.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosHashtags[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Administrador...");
		basededatos.Administrador[] basededatosAdministradors = basededatos.AdministradorDAO
				.listAdministradorByQuery(null, null);
		length = Math.min(basededatosAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Tweet...");
		basededatos.Tweet[] basededatosTweets = basededatos.TweetDAO.listTweetByQuery(null, null);
		length = Math.min(basededatosTweets.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosTweets[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Documento...");
		basededatos.Documento[] basededatosDocumentos = basededatos.DocumentoDAO.listDocumentoByQuery(null, null);
		length = Math.min(basededatosDocumentos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosDocumentos[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing PropiedadesMencion...");
		basededatos.PropiedadesMencion[] basededatosPropiedadesMencions = basededatos.PropiedadesMencionDAO
				.listPropiedadesMencionByQuery(null, null);
		length = Math.min(basededatosPropiedadesMencions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosPropiedadesMencions[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing PropiedadesSeguidos...");
		basededatos.PropiedadesSeguidos[] basededatosPropiedadesSeguidoses = basededatos.PropiedadesSeguidosDAO
				.listPropiedadesSeguidosByQuery(null, null);
		length = Math.min(basededatosPropiedadesSeguidoses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosPropiedadesSeguidoses[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Retweet...");
		basededatos.Retweet[] basededatosRetweets = basededatos.RetweetDAO.listRetweetByQuery(null, null);
		length = Math.min(basededatosRetweets.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosRetweets[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing PropiedadesBaneo...");
		basededatos.PropiedadesBaneo[] basededatosPropiedadesBaneos = basededatos.PropiedadesBaneoDAO
				.listPropiedadesBaneoByQuery(null, null);
		length = Math.min(basededatosPropiedadesBaneos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosPropiedadesBaneos[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Comentario...");
		basededatos.Comentario[] basededatosComentarios = basededatos.ComentarioDAO.listComentarioByQuery(null, null);
		length = Math.min(basededatosComentarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosComentarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");

	}

	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Usuario_Autentificado by Criteria...");
		basededatos.Usuario_AutentificadoCriteria lbasededatosUsuario_AutentificadoCriteria = new basededatos.Usuario_AutentificadoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosUsuario_AutentificadoCriteria.id_usuario.eq();
		lbasededatosUsuario_AutentificadoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Usuario_Autentificado[] basededatosUsuario_Autentificados = lbasededatosUsuario_AutentificadoCriteria
				.listUsuario_Autentificado();
		int length = basededatosUsuario_Autentificados == null ? 0
				: Math.min(basededatosUsuario_Autentificados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosUsuario_Autentificados[i]);
		}
		System.out.println(length + " Usuario_Autentificado record(s) retrieved.");

		System.out.println("Listing Usuario_Registrado by Criteria...");
		basededatos.Usuario_RegistradoCriteria lbasededatosUsuario_RegistradoCriteria = new basededatos.Usuario_RegistradoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosUsuario_RegistradoCriteria.id_usuario.eq();
		lbasededatosUsuario_RegistradoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Usuario_Registrado[] basededatosUsuario_Registrados = lbasededatosUsuario_RegistradoCriteria
				.listUsuario_Registrado();
		length = basededatosUsuario_Registrados == null ? 0
				: Math.min(basededatosUsuario_Registrados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosUsuario_Registrados[i]);
		}
		System.out.println(length + " Usuario_Registrado record(s) retrieved.");

		System.out.println("Listing Hashtag by Criteria...");
		basededatos.HashtagCriteria lbasededatosHashtagCriteria = new basededatos.HashtagCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosHashtagCriteria.id_hashtag.eq();
		lbasededatosHashtagCriteria.setMaxResults(ROW_COUNT);
		basededatos.Hashtag[] basededatosHashtags = lbasededatosHashtagCriteria.listHashtag();
		length = basededatosHashtags == null ? 0 : Math.min(basededatosHashtags.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosHashtags[i]);
		}
		System.out.println(length + " Hashtag record(s) retrieved.");

		System.out.println("Listing Administrador by Criteria...");
		basededatos.AdministradorCriteria lbasededatosAdministradorCriteria = new basededatos.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosAdministradorCriteria.id_usuario.eq();
		lbasededatosAdministradorCriteria.setMaxResults(ROW_COUNT);
		basededatos.Administrador[] basededatosAdministradors = lbasededatosAdministradorCriteria.listAdministrador();
		length = basededatosAdministradors == null ? 0 : Math.min(basededatosAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved.");

		System.out.println("Listing Tweet by Criteria...");
		basededatos.TweetCriteria lbasededatosTweetCriteria = new basededatos.TweetCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosTweetCriteria.id_tweet.eq();
		lbasededatosTweetCriteria.setMaxResults(ROW_COUNT);
		basededatos.Tweet[] basededatosTweets = lbasededatosTweetCriteria.listTweet();
		length = basededatosTweets == null ? 0 : Math.min(basededatosTweets.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosTweets[i]);
		}
		System.out.println(length + " Tweet record(s) retrieved.");

		System.out.println("Listing Documento by Criteria...");
		basededatos.DocumentoCriteria lbasededatosDocumentoCriteria = new basededatos.DocumentoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosDocumentoCriteria.id_documento.eq();
		lbasededatosDocumentoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Documento[] basededatosDocumentos = lbasededatosDocumentoCriteria.listDocumento();
		length = basededatosDocumentos == null ? 0 : Math.min(basededatosDocumentos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosDocumentos[i]);
		}
		System.out.println(length + " Documento record(s) retrieved.");

		System.out.println("Listing PropiedadesMencion by Criteria...");
		basededatos.PropiedadesMencionCriteria lbasededatosPropiedadesMencionCriteria = new basededatos.PropiedadesMencionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosPropiedadesMencionCriteria.ID.eq();
		lbasededatosPropiedadesMencionCriteria.setMaxResults(ROW_COUNT);
		basededatos.PropiedadesMencion[] basededatosPropiedadesMencions = lbasededatosPropiedadesMencionCriteria
				.listPropiedadesMencion();
		length = basededatosPropiedadesMencions == null ? 0
				: Math.min(basededatosPropiedadesMencions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosPropiedadesMencions[i]);
		}
		System.out.println(length + " PropiedadesMencion record(s) retrieved.");

		System.out.println("Listing PropiedadesSeguidos by Criteria...");
		basededatos.PropiedadesSeguidosCriteria lbasededatosPropiedadesSeguidosCriteria = new basededatos.PropiedadesSeguidosCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosPropiedadesSeguidosCriteria.ID.eq();
		lbasededatosPropiedadesSeguidosCriteria.setMaxResults(ROW_COUNT);
		basededatos.PropiedadesSeguidos[] basededatosPropiedadesSeguidoses = lbasededatosPropiedadesSeguidosCriteria
				.listPropiedadesSeguidos();
		length = basededatosPropiedadesSeguidoses == null ? 0
				: Math.min(basededatosPropiedadesSeguidoses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosPropiedadesSeguidoses[i]);
		}
		System.out.println(length + " PropiedadesSeguidos record(s) retrieved.");

		System.out.println("Listing Retweet by Criteria...");
		basededatos.RetweetCriteria lbasededatosRetweetCriteria = new basededatos.RetweetCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosRetweetCriteria.ID.eq();
		lbasededatosRetweetCriteria.setMaxResults(ROW_COUNT);
		basededatos.Retweet[] basededatosRetweets = lbasededatosRetweetCriteria.listRetweet();
		length = basededatosRetweets == null ? 0 : Math.min(basededatosRetweets.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosRetweets[i]);
		}
		System.out.println(length + " Retweet record(s) retrieved.");

		System.out.println("Listing PropiedadesBaneo by Criteria...");
		basededatos.PropiedadesBaneoCriteria lbasededatosPropiedadesBaneoCriteria = new basededatos.PropiedadesBaneoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosPropiedadesBaneoCriteria.ID.eq();
		lbasededatosPropiedadesBaneoCriteria.setMaxResults(ROW_COUNT);
		basededatos.PropiedadesBaneo[] basededatosPropiedadesBaneos = lbasededatosPropiedadesBaneoCriteria
				.listPropiedadesBaneo();
		length = basededatosPropiedadesBaneos == null ? 0 : Math.min(basededatosPropiedadesBaneos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosPropiedadesBaneos[i]);
		}
		System.out.println(length + " PropiedadesBaneo record(s) retrieved.");

		System.out.println("Listing Comentario by Criteria...");
		basededatos.ComentarioCriteria lbasededatosComentarioCriteria = new basededatos.ComentarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lbasededatosComentarioCriteria.id_comentario.eq();
		lbasededatosComentarioCriteria.setMaxResults(ROW_COUNT);
		basededatos.Comentario[] basededatosComentarios = lbasededatosComentarioCriteria.listComentario();
		length = basededatosComentarios == null ? 0 : Math.min(basededatosComentarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosComentarios[i]);
		}
		System.out.println(length + " Comentario record(s) retrieved.");

	}

	public static void main(String[] args) {
		try {
			ListProyectoMDS120242025Data listProyectoMDS120242025Data = new ListProyectoMDS120242025Data();
			try {
				listProyectoMDS120242025Data.listTestData();
				// listProyectoMDS120242025Data.listByCriteria();
			} finally {
				basededatos.ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
