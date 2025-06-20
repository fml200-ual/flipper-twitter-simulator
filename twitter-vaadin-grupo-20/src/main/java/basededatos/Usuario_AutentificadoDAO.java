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

public class Usuario_AutentificadoDAO {
	public static Usuario_Autentificado loadUsuario_AutentificadoByORMID(int id_usuario) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadUsuario_AutentificadoByORMID(session, id_usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado getUsuario_AutentificadoByORMID(int id_usuario) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getUsuario_AutentificadoByORMID(session, id_usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado loadUsuario_AutentificadoByORMID(int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadUsuario_AutentificadoByORMID(session, id_usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado getUsuario_AutentificadoByORMID(int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getUsuario_AutentificadoByORMID(session, id_usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado loadUsuario_AutentificadoByORMID(PersistentSession session, int id_usuario) throws PersistentException {
		try {
			return (Usuario_Autentificado) session.load(basededatos.Usuario_Autentificado.class, Integer.valueOf(id_usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado getUsuario_AutentificadoByORMID(PersistentSession session, int id_usuario) throws PersistentException {
		try {
			return (Usuario_Autentificado) session.get(basededatos.Usuario_Autentificado.class, Integer.valueOf(id_usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado loadUsuario_AutentificadoByORMID(PersistentSession session, int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario_Autentificado) session.load(basededatos.Usuario_Autentificado.class, Integer.valueOf(id_usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado getUsuario_AutentificadoByORMID(PersistentSession session, int id_usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario_Autentificado) session.get(basededatos.Usuario_Autentificado.class, Integer.valueOf(id_usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Autentificado(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryUsuario_Autentificado(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Autentificado(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryUsuario_Autentificado(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado[] listUsuario_AutentificadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listUsuario_AutentificadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado[] listUsuario_AutentificadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listUsuario_AutentificadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Autentificado(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Usuario_Autentificado as Usuario_Autentificado");
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
	
	public static List queryUsuario_Autentificado(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Usuario_Autentificado as Usuario_Autentificado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario_Autentificado", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado[] listUsuario_AutentificadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUsuario_Autentificado(session, condition, orderBy);
			return (Usuario_Autentificado[]) list.toArray(new Usuario_Autentificado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado[] listUsuario_AutentificadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsuario_Autentificado(session, condition, orderBy, lockMode);
			return (Usuario_Autentificado[]) list.toArray(new Usuario_Autentificado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado loadUsuario_AutentificadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadUsuario_AutentificadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado loadUsuario_AutentificadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadUsuario_AutentificadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado loadUsuario_AutentificadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Usuario_Autentificado[] usuario_Autentificados = listUsuario_AutentificadoByQuery(session, condition, orderBy);
		if (usuario_Autentificados != null && usuario_Autentificados.length > 0)
			return usuario_Autentificados[0];
		else
			return null;
	}
	
	public static Usuario_Autentificado loadUsuario_AutentificadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Usuario_Autentificado[] usuario_Autentificados = listUsuario_AutentificadoByQuery(session, condition, orderBy, lockMode);
		if (usuario_Autentificados != null && usuario_Autentificados.length > 0)
			return usuario_Autentificados[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUsuario_AutentificadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iterateUsuario_AutentificadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuario_AutentificadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iterateUsuario_AutentificadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuario_AutentificadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Usuario_Autentificado as Usuario_Autentificado");
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
	
	public static java.util.Iterator iterateUsuario_AutentificadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Usuario_Autentificado as Usuario_Autentificado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario_Autentificado", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado createUsuario_Autentificado() {
		return new basededatos.Usuario_Autentificado();
	}
	
	public static boolean save(basededatos.Usuario_Autentificado usuario_Autentificado) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().saveObject(usuario_Autentificado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Usuario_Autentificado usuario_Autentificado) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().deleteObject(usuario_Autentificado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(basededatos.Usuario_Autentificado usuario_Autentificado) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().refresh(usuario_Autentificado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Usuario_Autentificado usuario_Autentificado) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().evict(usuario_Autentificado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Autentificado loadUsuario_AutentificadoByCriteria(Usuario_AutentificadoCriteria usuario_AutentificadoCriteria) {
		Usuario_Autentificado[] usuario_Autentificados = listUsuario_AutentificadoByCriteria(usuario_AutentificadoCriteria);
		if(usuario_Autentificados == null || usuario_Autentificados.length == 0) {
			return null;
		}
		return usuario_Autentificados[0];
	}
	
	public static Usuario_Autentificado[] listUsuario_AutentificadoByCriteria(Usuario_AutentificadoCriteria usuario_AutentificadoCriteria) {
		return usuario_AutentificadoCriteria.listUsuario_Autentificado();
	}
}
