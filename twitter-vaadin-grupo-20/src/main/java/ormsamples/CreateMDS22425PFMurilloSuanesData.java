/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateMDS22425PFMurilloSuanesData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = basededatos.MDS22425PFMurilloSuanesPersistentManager.instance().getSession().beginTransaction();
		try {
			basededatos.Documento lbasededatosDocumento = basededatos.DocumentoDAO.createDocumento();
			// Initialize the properties of the persistent object here
			basededatos.DocumentoDAO.save(lbasededatosDocumento);
			basededatos.PropiedadesBaneo lbasededatosPropiedadesBaneo = basededatos.PropiedadesBaneoDAO.createPropiedadesBaneo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : administrador, usuario_Registrado, duracion
			basededatos.PropiedadesBaneoDAO.save(lbasededatosPropiedadesBaneo);
			basededatos.Usuario_Autentificado lbasededatosUsuario_Autentificado = basededatos.Usuario_AutentificadoDAO.createUsuario_Autentificado();
			// Initialize the properties of the persistent object here
			basededatos.Usuario_AutentificadoDAO.save(lbasededatosUsuario_Autentificado);
			basededatos.Administrador lbasededatosAdministrador = basededatos.AdministradorDAO.createAdministrador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : propiedadesBaneos
			basededatos.AdministradorDAO.save(lbasededatosAdministrador);
			basededatos.Usuario_Registrado lbasededatosUsuario_Registrado = basededatos.Usuario_RegistradoDAO.createUsuario_Registrado();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : bloqueados, seguidosPropiedadesseguidoss, meTienenBloqueado, propiedadesBaneo, seguidoresPropiedadesseguidoss, me_gusta_tweets, retweets, propiedadesMencions, comentarios_publicados, tweets, me_gusta_Comentarios
			basededatos.Usuario_RegistradoDAO.save(lbasededatosUsuario_Registrado);
			basededatos.Hashtag lbasededatosHashtag = basededatos.HashtagDAO.createHashtag();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pertenece
			basededatos.HashtagDAO.save(lbasededatosHashtag);
			basededatos.Tweet lbasededatosTweet = basededatos.TweetDAO.createTweet();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : recibe_me_gusta, retweets, propiedadesMencions, tiene, tiene_hashtag, publicado_por
			basededatos.TweetDAO.save(lbasededatosTweet);
			basededatos.Retweet lbasededatosRetweet = basededatos.RetweetDAO.createRetweet();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : tweet, usuario_Registrado
			basededatos.RetweetDAO.save(lbasededatosRetweet);
			basededatos.PropiedadesSeguidos lbasededatosPropiedadesSeguidos = basededatos.PropiedadesSeguidosDAO.createPropiedadesSeguidos();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : seguidoresUsuario_registrado, seguidosUsuario_registrado
			basededatos.PropiedadesSeguidosDAO.save(lbasededatosPropiedadesSeguidos);
			basededatos.Comentario lbasededatosComentario = basededatos.ComentarioDAO.createComentario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : recibe_me_gusta, pertenece, publicado_por
			basededatos.ComentarioDAO.save(lbasededatosComentario);
			basededatos.PropiedadesMencion lbasededatosPropiedadesMencion = basededatos.PropiedadesMencionDAO.createPropiedadesMencion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : tweet, usuario_Registrado
			basededatos.PropiedadesMencionDAO.save(lbasededatosPropiedadesMencion);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateMDS22425PFMurilloSuanesData createMDS22425PFMurilloSuanesData = new CreateMDS22425PFMurilloSuanesData();
			try {
				createMDS22425PFMurilloSuanesData.createTestData();
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
