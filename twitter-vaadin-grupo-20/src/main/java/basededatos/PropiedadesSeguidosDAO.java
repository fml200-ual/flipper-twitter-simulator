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

public class PropiedadesSeguidosDAO {
	public static PropiedadesSeguidos loadPropiedadesSeguidosByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadPropiedadesSeguidosByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos getPropiedadesSeguidosByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getPropiedadesSeguidosByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos loadPropiedadesSeguidosByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadPropiedadesSeguidosByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos getPropiedadesSeguidosByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getPropiedadesSeguidosByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos loadPropiedadesSeguidosByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (PropiedadesSeguidos) session.load(basededatos.PropiedadesSeguidos.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos getPropiedadesSeguidosByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (PropiedadesSeguidos) session.get(basededatos.PropiedadesSeguidos.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos loadPropiedadesSeguidosByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PropiedadesSeguidos) session.load(basededatos.PropiedadesSeguidos.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos getPropiedadesSeguidosByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PropiedadesSeguidos) session.get(basededatos.PropiedadesSeguidos.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesSeguidos(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryPropiedadesSeguidos(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesSeguidos(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryPropiedadesSeguidos(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos[] listPropiedadesSeguidosByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listPropiedadesSeguidosByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos[] listPropiedadesSeguidosByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listPropiedadesSeguidosByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesSeguidos(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesSeguidos as PropiedadesSeguidos");
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
	
	public static List queryPropiedadesSeguidos(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesSeguidos as PropiedadesSeguidos");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PropiedadesSeguidos", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos[] listPropiedadesSeguidosByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPropiedadesSeguidos(session, condition, orderBy);
			return (PropiedadesSeguidos[]) list.toArray(new PropiedadesSeguidos[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos[] listPropiedadesSeguidosByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPropiedadesSeguidos(session, condition, orderBy, lockMode);
			return (PropiedadesSeguidos[]) list.toArray(new PropiedadesSeguidos[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos loadPropiedadesSeguidosByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadPropiedadesSeguidosByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos loadPropiedadesSeguidosByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadPropiedadesSeguidosByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos loadPropiedadesSeguidosByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		PropiedadesSeguidos[] propiedadesSeguidoses = listPropiedadesSeguidosByQuery(session, condition, orderBy);
		if (propiedadesSeguidoses != null && propiedadesSeguidoses.length > 0)
			return propiedadesSeguidoses[0];
		else
			return null;
	}
	
	public static PropiedadesSeguidos loadPropiedadesSeguidosByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		PropiedadesSeguidos[] propiedadesSeguidoses = listPropiedadesSeguidosByQuery(session, condition, orderBy, lockMode);
		if (propiedadesSeguidoses != null && propiedadesSeguidoses.length > 0)
			return propiedadesSeguidoses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePropiedadesSeguidosByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iteratePropiedadesSeguidosByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropiedadesSeguidosByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iteratePropiedadesSeguidosByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropiedadesSeguidosByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesSeguidos as PropiedadesSeguidos");
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
	
	public static java.util.Iterator iteratePropiedadesSeguidosByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesSeguidos as PropiedadesSeguidos");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PropiedadesSeguidos", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos createPropiedadesSeguidos() {
		return new basededatos.PropiedadesSeguidos();
	}
	
	public static boolean save(basededatos.PropiedadesSeguidos propiedadesSeguidos) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().saveObject(propiedadesSeguidos);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.PropiedadesSeguidos propiedadesSeguidos) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().deleteObject(propiedadesSeguidos);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.PropiedadesSeguidos propiedadesSeguidos)throws PersistentException {
		try {
			if (propiedadesSeguidos.getSeguidosUsuario_registrado() != null) {
				propiedadesSeguidos.getSeguidosUsuario_registrado().seguidoresPropiedadesseguidoss.remove(propiedadesSeguidos);
			}
			
			if (propiedadesSeguidos.getSeguidoresUsuario_registrado() != null) {
				propiedadesSeguidos.getSeguidoresUsuario_registrado().seguidosPropiedadesseguidoss.remove(propiedadesSeguidos);
			}
			
			return delete(propiedadesSeguidos);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.PropiedadesSeguidos propiedadesSeguidos, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (propiedadesSeguidos.getSeguidosUsuario_registrado() != null) {
				propiedadesSeguidos.getSeguidosUsuario_registrado().seguidoresPropiedadesseguidoss.remove(propiedadesSeguidos);
			}
			
			if (propiedadesSeguidos.getSeguidoresUsuario_registrado() != null) {
				propiedadesSeguidos.getSeguidoresUsuario_registrado().seguidosPropiedadesseguidoss.remove(propiedadesSeguidos);
			}
			
			try {
				session.delete(propiedadesSeguidos);
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
	
	public static boolean refresh(basededatos.PropiedadesSeguidos propiedadesSeguidos) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().refresh(propiedadesSeguidos);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.PropiedadesSeguidos propiedadesSeguidos) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().evict(propiedadesSeguidos);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesSeguidos loadPropiedadesSeguidosByCriteria(PropiedadesSeguidosCriteria propiedadesSeguidosCriteria) {
		PropiedadesSeguidos[] propiedadesSeguidoses = listPropiedadesSeguidosByCriteria(propiedadesSeguidosCriteria);
		if(propiedadesSeguidoses == null || propiedadesSeguidoses.length == 0) {
			return null;
		}
		return propiedadesSeguidoses[0];
	}
	
	public static PropiedadesSeguidos[] listPropiedadesSeguidosByCriteria(PropiedadesSeguidosCriteria propiedadesSeguidosCriteria) {
		return propiedadesSeguidosCriteria.listPropiedadesSeguidos();
	}
}
