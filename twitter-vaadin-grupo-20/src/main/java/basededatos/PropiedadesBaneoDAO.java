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

public class PropiedadesBaneoDAO {
	public static PropiedadesBaneo loadPropiedadesBaneoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadPropiedadesBaneoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo getPropiedadesBaneoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getPropiedadesBaneoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo loadPropiedadesBaneoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadPropiedadesBaneoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo getPropiedadesBaneoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getPropiedadesBaneoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo loadPropiedadesBaneoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (PropiedadesBaneo) session.load(basededatos.PropiedadesBaneo.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo getPropiedadesBaneoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (PropiedadesBaneo) session.get(basededatos.PropiedadesBaneo.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo loadPropiedadesBaneoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PropiedadesBaneo) session.load(basededatos.PropiedadesBaneo.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo getPropiedadesBaneoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PropiedadesBaneo) session.get(basededatos.PropiedadesBaneo.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesBaneo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryPropiedadesBaneo(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesBaneo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryPropiedadesBaneo(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo[] listPropiedadesBaneoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listPropiedadesBaneoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo[] listPropiedadesBaneoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listPropiedadesBaneoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesBaneo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesBaneo as PropiedadesBaneo");
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
	
	public static List queryPropiedadesBaneo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesBaneo as PropiedadesBaneo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PropiedadesBaneo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo[] listPropiedadesBaneoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPropiedadesBaneo(session, condition, orderBy);
			return (PropiedadesBaneo[]) list.toArray(new PropiedadesBaneo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo[] listPropiedadesBaneoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPropiedadesBaneo(session, condition, orderBy, lockMode);
			return (PropiedadesBaneo[]) list.toArray(new PropiedadesBaneo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo loadPropiedadesBaneoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadPropiedadesBaneoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo loadPropiedadesBaneoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadPropiedadesBaneoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo loadPropiedadesBaneoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		PropiedadesBaneo[] propiedadesBaneos = listPropiedadesBaneoByQuery(session, condition, orderBy);
		if (propiedadesBaneos != null && propiedadesBaneos.length > 0)
			return propiedadesBaneos[0];
		else
			return null;
	}
	
	public static PropiedadesBaneo loadPropiedadesBaneoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		PropiedadesBaneo[] propiedadesBaneos = listPropiedadesBaneoByQuery(session, condition, orderBy, lockMode);
		if (propiedadesBaneos != null && propiedadesBaneos.length > 0)
			return propiedadesBaneos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePropiedadesBaneoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iteratePropiedadesBaneoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropiedadesBaneoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iteratePropiedadesBaneoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropiedadesBaneoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesBaneo as PropiedadesBaneo");
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
	
	public static java.util.Iterator iteratePropiedadesBaneoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesBaneo as PropiedadesBaneo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PropiedadesBaneo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo createPropiedadesBaneo() {
		return new basededatos.PropiedadesBaneo();
	}
	
	public static boolean save(basededatos.PropiedadesBaneo propiedadesBaneo) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().saveObject(propiedadesBaneo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.PropiedadesBaneo propiedadesBaneo) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().deleteObject(propiedadesBaneo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.PropiedadesBaneo propiedadesBaneo)throws PersistentException {
		try {
			if (propiedadesBaneo.getUsuario_Registrado() != null) {
				propiedadesBaneo.getUsuario_Registrado().setPropiedadesBaneo(null);
			}
			
			if (propiedadesBaneo.getAdministrador() != null) {
				propiedadesBaneo.getAdministrador().propiedadesBaneos.remove(propiedadesBaneo);
			}
			
			return delete(propiedadesBaneo);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.PropiedadesBaneo propiedadesBaneo, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (propiedadesBaneo.getUsuario_Registrado() != null) {
				propiedadesBaneo.getUsuario_Registrado().setPropiedadesBaneo(null);
			}
			
			if (propiedadesBaneo.getAdministrador() != null) {
				propiedadesBaneo.getAdministrador().propiedadesBaneos.remove(propiedadesBaneo);
			}
			
			try {
				session.delete(propiedadesBaneo);
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
	
	public static boolean refresh(basededatos.PropiedadesBaneo propiedadesBaneo) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().refresh(propiedadesBaneo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.PropiedadesBaneo propiedadesBaneo) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().evict(propiedadesBaneo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesBaneo loadPropiedadesBaneoByCriteria(PropiedadesBaneoCriteria propiedadesBaneoCriteria) {
		PropiedadesBaneo[] propiedadesBaneos = listPropiedadesBaneoByCriteria(propiedadesBaneoCriteria);
		if(propiedadesBaneos == null || propiedadesBaneos.length == 0) {
			return null;
		}
		return propiedadesBaneos[0];
	}
	
	public static PropiedadesBaneo[] listPropiedadesBaneoByCriteria(PropiedadesBaneoCriteria propiedadesBaneoCriteria) {
		return propiedadesBaneoCriteria.listPropiedadesBaneo();
	}
}
