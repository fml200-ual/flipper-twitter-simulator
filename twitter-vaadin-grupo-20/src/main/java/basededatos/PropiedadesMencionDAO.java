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

public class PropiedadesMencionDAO {
	public static PropiedadesMencion loadPropiedadesMencionByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return loadPropiedadesMencionByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion getPropiedadesMencionByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return getPropiedadesMencionByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion loadPropiedadesMencionByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return loadPropiedadesMencionByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion getPropiedadesMencionByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return getPropiedadesMencionByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion loadPropiedadesMencionByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (PropiedadesMencion) session.load(basededatos.PropiedadesMencion.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion getPropiedadesMencionByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (PropiedadesMencion) session.get(basededatos.PropiedadesMencion.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion loadPropiedadesMencionByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PropiedadesMencion) session.load(basededatos.PropiedadesMencion.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion getPropiedadesMencionByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PropiedadesMencion) session.get(basededatos.PropiedadesMencion.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesMencion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return queryPropiedadesMencion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesMencion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return queryPropiedadesMencion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion[] listPropiedadesMencionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return listPropiedadesMencionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion[] listPropiedadesMencionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return listPropiedadesMencionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropiedadesMencion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesMencion as PropiedadesMencion");
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
	
	public static List queryPropiedadesMencion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesMencion as PropiedadesMencion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PropiedadesMencion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion[] listPropiedadesMencionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPropiedadesMencion(session, condition, orderBy);
			return (PropiedadesMencion[]) list.toArray(new PropiedadesMencion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion[] listPropiedadesMencionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPropiedadesMencion(session, condition, orderBy, lockMode);
			return (PropiedadesMencion[]) list.toArray(new PropiedadesMencion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion loadPropiedadesMencionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return loadPropiedadesMencionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion loadPropiedadesMencionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return loadPropiedadesMencionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion loadPropiedadesMencionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		PropiedadesMencion[] propiedadesMencions = listPropiedadesMencionByQuery(session, condition, orderBy);
		if (propiedadesMencions != null && propiedadesMencions.length > 0)
			return propiedadesMencions[0];
		else
			return null;
	}
	
	public static PropiedadesMencion loadPropiedadesMencionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		PropiedadesMencion[] propiedadesMencions = listPropiedadesMencionByQuery(session, condition, orderBy, lockMode);
		if (propiedadesMencions != null && propiedadesMencions.length > 0)
			return propiedadesMencions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePropiedadesMencionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return iteratePropiedadesMencionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropiedadesMencionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return iteratePropiedadesMencionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropiedadesMencionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesMencion as PropiedadesMencion");
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
	
	public static java.util.Iterator iteratePropiedadesMencionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.PropiedadesMencion as PropiedadesMencion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PropiedadesMencion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion createPropiedadesMencion() {
		return new basededatos.PropiedadesMencion();
	}
	
	public static boolean save(basededatos.PropiedadesMencion propiedadesMencion) throws PersistentException {
		try {
			ProyectoMDS120242025PersistentManager.instance().saveObject(propiedadesMencion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.PropiedadesMencion propiedadesMencion) throws PersistentException {
		try {
			ProyectoMDS120242025PersistentManager.instance().deleteObject(propiedadesMencion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.PropiedadesMencion propiedadesMencion)throws PersistentException {
		try {
			if (propiedadesMencion.getUsuario_Registrado() != null) {
				propiedadesMencion.getUsuario_Registrado().propiedadesMencions.remove(propiedadesMencion);
			}
			
			if (propiedadesMencion.getTweet() != null) {
				propiedadesMencion.getTweet().propiedadesMencions.remove(propiedadesMencion);
			}
			
			return delete(propiedadesMencion);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.PropiedadesMencion propiedadesMencion, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (propiedadesMencion.getUsuario_Registrado() != null) {
				propiedadesMencion.getUsuario_Registrado().propiedadesMencions.remove(propiedadesMencion);
			}
			
			if (propiedadesMencion.getTweet() != null) {
				propiedadesMencion.getTweet().propiedadesMencions.remove(propiedadesMencion);
			}
			
			try {
				session.delete(propiedadesMencion);
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
	
	public static boolean refresh(basededatos.PropiedadesMencion propiedadesMencion) throws PersistentException {
		try {
			ProyectoMDS120242025PersistentManager.instance().getSession().refresh(propiedadesMencion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.PropiedadesMencion propiedadesMencion) throws PersistentException {
		try {
			ProyectoMDS120242025PersistentManager.instance().getSession().evict(propiedadesMencion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropiedadesMencion loadPropiedadesMencionByCriteria(PropiedadesMencionCriteria propiedadesMencionCriteria) {
		PropiedadesMencion[] propiedadesMencions = listPropiedadesMencionByCriteria(propiedadesMencionCriteria);
		if(propiedadesMencions == null || propiedadesMencions.length == 0) {
			return null;
		}
		return propiedadesMencions[0];
	}
	
	public static PropiedadesMencion[] listPropiedadesMencionByCriteria(PropiedadesMencionCriteria propiedadesMencionCriteria) {
		return propiedadesMencionCriteria.listPropiedadesMencion();
	}
}
