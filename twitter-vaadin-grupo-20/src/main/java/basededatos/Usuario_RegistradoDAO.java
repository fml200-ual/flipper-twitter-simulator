/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package basededatos;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Usuario_RegistradoDAO {
	public static Usuario_Registrado loadUsuario_RegistradoByORMID(int id_usuario) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadUsuario_RegistradoByORMID(session, id_usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado getUsuario_RegistradoByORMID(int id_usuario) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getUsuario_RegistradoByORMID(session, id_usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByORMID(int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadUsuario_RegistradoByORMID(session, id_usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado getUsuario_RegistradoByORMID(int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getUsuario_RegistradoByORMID(session, id_usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByORMID(PersistentSession session, int id_usuario) throws PersistentException {
		try {
			return (Usuario_Registrado) session.load(basededatos.Usuario_Registrado.class, Integer.valueOf(id_usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado getUsuario_RegistradoByORMID(PersistentSession session, int id_usuario) throws PersistentException {
		try {
			return (Usuario_Registrado) session.get(basededatos.Usuario_Registrado.class, Integer.valueOf(id_usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByORMID(PersistentSession session, int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario_Registrado) session.load(basededatos.Usuario_Registrado.class, Integer.valueOf(id_usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado getUsuario_RegistradoByORMID(PersistentSession session, int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario_Registrado) session.get(basededatos.Usuario_Registrado.class, Integer.valueOf(id_usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Registrado(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryUsuario_Registrado(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Registrado(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryUsuario_Registrado(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listUsuario_RegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listUsuario_RegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Registrado(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Usuario_Registrado as Usuario_Registrado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Registrado(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Usuario_Registrado as Usuario_Registrado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario_Registrado", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUsuario_Registrado(session, condition, orderBy);
			return (Usuario_Registrado[]) list.toArray(new Usuario_Registrado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsuario_Registrado(session, condition, orderBy, lockMode);
			return (Usuario_Registrado[]) list.toArray(new Usuario_Registrado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadUsuario_RegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadUsuario_RegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Usuario_Registrado[] usuario_Registrados = listUsuario_RegistradoByQuery(session, condition, orderBy);
		if (usuario_Registrados != null && usuario_Registrados.length > 0)
			return usuario_Registrados[0];
		else
			return null;
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Usuario_Registrado[] usuario_Registrados = listUsuario_RegistradoByQuery(session, condition, orderBy, lockMode);
		if (usuario_Registrados != null && usuario_Registrados.length > 0)
			return usuario_Registrados[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUsuario_RegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iterateUsuario_RegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuario_RegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iterateUsuario_RegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Usuario_Registrado as Usuario_Registrado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Usuario_Registrado as Usuario_Registrado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario_Registrado", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado createUsuario_Registrado() {
		return new basededatos.Usuario_Registrado();
	}
	
	public static boolean save(basededatos.Usuario_Registrado usuario_Registrado) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().saveObject(usuario_Registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Usuario_Registrado usuario_Registrado) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().deleteObject(usuario_Registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Usuario_Registrado usuario_Registrado)throws PersistentException {
		try {
			basededatos.Comentario[] lMe_gusta_Comentarioss = usuario_Registrado.me_gusta_Comentarios.toArray();
			for(int i = 0; i < lMe_gusta_Comentarioss.length; i++) {
				lMe_gusta_Comentarioss[i].recibe_me_gusta.remove(usuario_Registrado);
			}
			basededatos.Tweet[] lTweetss = usuario_Registrado.tweets.toArray();
			for(int i = 0; i < lTweetss.length; i++) {
				lTweetss[i].setPublicado_por(null);
			}
			basededatos.Comentario[] lComentarios_publicadoss = usuario_Registrado.comentarios_publicados.toArray();
			for(int i = 0; i < lComentarios_publicadoss.length; i++) {
				lComentarios_publicadoss[i].setPublicado_por(null);
			}
			basededatos.PropiedadesMencion[] lPropiedadesMencionss = usuario_Registrado.propiedadesMencions.toArray();
			for(int i = 0; i < lPropiedadesMencionss.length; i++) {
				lPropiedadesMencionss[i].setUsuario_Registrado(null);
			}
			basededatos.Retweet[] lRetweetss = usuario_Registrado.retweets.toArray();
			for(int i = 0; i < lRetweetss.length; i++) {
				lRetweetss[i].setUsuario_Registrado(null);
			}
			basededatos.Tweet[] lMe_gusta_tweetss = usuario_Registrado.me_gusta_tweets.toArray();
			for(int i = 0; i < lMe_gusta_tweetss.length; i++) {
				lMe_gusta_tweetss[i].recibe_me_gusta.remove(usuario_Registrado);
			}
			basededatos.PropiedadesSeguidos[] lSeguidoresPropiedadesseguidosss = usuario_Registrado.seguidoresPropiedadesseguidoss.toArray();
			for(int i = 0; i < lSeguidoresPropiedadesseguidosss.length; i++) {
				lSeguidoresPropiedadesseguidosss[i].setSeguidosUsuario_registrado(null);
			}
			if (usuario_Registrado.getPropiedadesBaneo() != null) {
				usuario_Registrado.getPropiedadesBaneo().setUsuario_Registrado(null);
			}
			
			basededatos.Usuario_Registrado[] lMeTienenBloqueados = usuario_Registrado.meTienenBloqueado.toArray();
			for(int i = 0; i < lMeTienenBloqueados.length; i++) {
				lMeTienenBloqueados[i].bloqueados.remove(usuario_Registrado);
			}
			basededatos.PropiedadesSeguidos[] lSeguidosPropiedadesseguidosss = usuario_Registrado.seguidosPropiedadesseguidoss.toArray();
			for(int i = 0; i < lSeguidosPropiedadesseguidosss.length; i++) {
				lSeguidosPropiedadesseguidosss[i].setSeguidoresUsuario_registrado(null);
			}
			basededatos.Usuario_Registrado[] lBloqueadoss = usuario_Registrado.bloqueados.toArray();
			for(int i = 0; i < lBloqueadoss.length; i++) {
				lBloqueadoss[i].meTienenBloqueado.remove(usuario_Registrado);
			}
			return delete(usuario_Registrado);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Usuario_Registrado usuario_Registrado, org.orm.PersistentSession session)throws PersistentException {
		try {
			basededatos.Comentario[] lMe_gusta_Comentarioss = usuario_Registrado.me_gusta_Comentarios.toArray();
			for(int i = 0; i < lMe_gusta_Comentarioss.length; i++) {
				lMe_gusta_Comentarioss[i].recibe_me_gusta.remove(usuario_Registrado);
			}
			basededatos.Tweet[] lTweetss = usuario_Registrado.tweets.toArray();
			for(int i = 0; i < lTweetss.length; i++) {
				lTweetss[i].setPublicado_por(null);
			}
			basededatos.Comentario[] lComentarios_publicadoss = usuario_Registrado.comentarios_publicados.toArray();
			for(int i = 0; i < lComentarios_publicadoss.length; i++) {
				lComentarios_publicadoss[i].setPublicado_por(null);
			}
			basededatos.PropiedadesMencion[] lPropiedadesMencionss = usuario_Registrado.propiedadesMencions.toArray();
			for(int i = 0; i < lPropiedadesMencionss.length; i++) {
				lPropiedadesMencionss[i].setUsuario_Registrado(null);
			}
			basededatos.Retweet[] lRetweetss = usuario_Registrado.retweets.toArray();
			for(int i = 0; i < lRetweetss.length; i++) {
				lRetweetss[i].setUsuario_Registrado(null);
			}
			basededatos.Tweet[] lMe_gusta_tweetss = usuario_Registrado.me_gusta_tweets.toArray();
			for(int i = 0; i < lMe_gusta_tweetss.length; i++) {
				lMe_gusta_tweetss[i].recibe_me_gusta.remove(usuario_Registrado);
			}
			basededatos.PropiedadesSeguidos[] lSeguidoresPropiedadesseguidosss = usuario_Registrado.seguidoresPropiedadesseguidoss.toArray();
			for(int i = 0; i < lSeguidoresPropiedadesseguidosss.length; i++) {
				lSeguidoresPropiedadesseguidosss[i].setSeguidosUsuario_registrado(null);
			}
			if (usuario_Registrado.getPropiedadesBaneo() != null) {
				usuario_Registrado.getPropiedadesBaneo().setUsuario_Registrado(null);
			}
			
			basededatos.Usuario_Registrado[] lMeTienenBloqueados = usuario_Registrado.meTienenBloqueado.toArray();
			for(int i = 0; i < lMeTienenBloqueados.length; i++) {
				lMeTienenBloqueados[i].bloqueados.remove(usuario_Registrado);
			}
			basededatos.PropiedadesSeguidos[] lSeguidosPropiedadesseguidosss = usuario_Registrado.seguidosPropiedadesseguidoss.toArray();
			for(int i = 0; i < lSeguidosPropiedadesseguidosss.length; i++) {
				lSeguidosPropiedadesseguidosss[i].setSeguidoresUsuario_registrado(null);
			}
			basededatos.Usuario_Registrado[] lBloqueadoss = usuario_Registrado.bloqueados.toArray();
			for(int i = 0; i < lBloqueadoss.length; i++) {
				lBloqueadoss[i].meTienenBloqueado.remove(usuario_Registrado);
			}
			try {
				session.delete(usuario_Registrado);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(basededatos.Usuario_Registrado usuario_Registrado) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().refresh(usuario_Registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Usuario_Registrado usuario_Registrado) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().evict(usuario_Registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByCriteria(Usuario_RegistradoCriteria usuario_RegistradoCriteria) {
		Usuario_Registrado[] usuario_Registrados = listUsuario_RegistradoByCriteria(usuario_RegistradoCriteria);
		if(usuario_Registrados == null || usuario_Registrados.length == 0) {
			return null;
		}
		return usuario_Registrados[0];
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByCriteria(Usuario_RegistradoCriteria usuario_RegistradoCriteria) {
		return usuario_RegistradoCriteria.listUsuario_Registrado();
	}
}
