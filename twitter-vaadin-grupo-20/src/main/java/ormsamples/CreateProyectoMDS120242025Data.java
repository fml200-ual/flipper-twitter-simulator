/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateProyectoMDS120242025Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = basededatos.ProyectoMDS120242025PersistentManager.instance().getSession().beginTransaction();
		try {
			basededatos.Usuario_Autentificado lbasededatosUsuario_Autentificado = basededatos.Usuario_AutentificadoDAO.createUsuario_Autentificado();
			// Initialize the properties of the persistent object here
			basededatos.Usuario_AutentificadoDAO.save(lbasededatosUsuario_Autentificado);
			basededatos.Usuario_Registrado lbasededatosUsuario_Registrado = basededatos.Usuario_RegistradoDAO.createUsuario_Registrado();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : bloqueados, seguidosPropiedadesseguidoss, me_gusta_Comentarios, meTienenBloqueado, me_gusta_tweets, comentarios_publicados, propiedadesBaneo, retweets, seguidoresPropiedadesseguidoss, propiedadesMencions, tweets
			basededatos.Usuario_RegistradoDAO.save(lbasededatosUsuario_Registrado);
			basededatos.Hashtag lbasededatosHashtag = basededatos.HashtagDAO.createHashtag();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pertenece
			basededatos.HashtagDAO.save(lbasededatosHashtag);
			basededatos.Administrador lbasededatosAdministrador = basededatos.AdministradorDAO.createAdministrador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : propiedadesBaneos
			basededatos.AdministradorDAO.save(lbasededatosAdministrador);
			basededatos.Tweet lbasededatosTweet = basededatos.TweetDAO.createTweet();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : recibe_me_gusta, tiene, retweets, propiedadesMencions, tiene_hashtag, publicado_por
			basededatos.TweetDAO.save(lbasededatosTweet);
			basededatos.Documento lbasededatosDocumento = basededatos.DocumentoDAO.createDocumento();
			// Initialize the properties of the persistent object here
			basededatos.DocumentoDAO.save(lbasededatosDocumento);
			basededatos.PropiedadesMencion lbasededatosPropiedadesMencion = basededatos.PropiedadesMencionDAO.createPropiedadesMencion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : tweet, usuario_Registrado
			basededatos.PropiedadesMencionDAO.save(lbasededatosPropiedadesMencion);
			basededatos.PropiedadesSeguidos lbasededatosPropiedadesSeguidos = basededatos.PropiedadesSeguidosDAO.createPropiedadesSeguidos();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : seguidoresUsuario_registrado, seguidosUsuario_registrado
			basededatos.PropiedadesSeguidosDAO.save(lbasededatosPropiedadesSeguidos);
			basededatos.Retweet lbasededatosRetweet = basededatos.RetweetDAO.createRetweet();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : tweet, usuario_Registrado
			basededatos.RetweetDAO.save(lbasededatosRetweet);
			basededatos.PropiedadesBaneo lbasededatosPropiedadesBaneo = basededatos.PropiedadesBaneoDAO.createPropiedadesBaneo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : administrador, usuario_Registrado, duracion
			basededatos.PropiedadesBaneoDAO.save(lbasededatosPropiedadesBaneo);
			basededatos.Comentario lbasededatosComentario = basededatos.ComentarioDAO.createComentario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : recibe_me_gusta, pertenece, publicado_por
			basededatos.ComentarioDAO.save(lbasededatosComentario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateProyectoMDS120242025Data createProyectoMDS120242025Data = new CreateProyectoMDS120242025Data();
			try {
				createProyectoMDS120242025Data.createTestData();
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
