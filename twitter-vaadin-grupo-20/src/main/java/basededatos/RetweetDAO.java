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

public class RetweetDAO {
	public static Retweet loadRetweetByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadRetweetByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet getRetweetByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getRetweetByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet loadRetweetByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadRetweetByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet getRetweetByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getRetweetByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet loadRetweetByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Retweet) session.load(basededatos.Retweet.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet getRetweetByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Retweet) session.get(basededatos.Retweet.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet loadRetweetByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Retweet) session.load(basededatos.Retweet.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet getRetweetByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Retweet) session.get(basededatos.Retweet.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRetweet(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryRetweet(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRetweet(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryRetweet(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet[] listRetweetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listRetweetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet[] listRetweetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listRetweetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRetweet(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Retweet as Retweet");
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
	
	public static List queryRetweet(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Retweet as Retweet");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Retweet", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet[] listRetweetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRetweet(session, condition, orderBy);
			return (Retweet[]) list.toArray(new Retweet[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet[] listRetweetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRetweet(session, condition, orderBy, lockMode);
			return (Retweet[]) list.toArray(new Retweet[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet loadRetweetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadRetweetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet loadRetweetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadRetweetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet loadRetweetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Retweet[] retweets = listRetweetByQuery(session, condition, orderBy);
		if (retweets != null && retweets.length > 0)
			return retweets[0];
		else
			return null;
	}
	
	public static Retweet loadRetweetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Retweet[] retweets = listRetweetByQuery(session, condition, orderBy, lockMode);
		if (retweets != null && retweets.length > 0)
			return retweets[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRetweetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iterateRetweetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRetweetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iterateRetweetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRetweetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Retweet as Retweet");
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
	
	public static java.util.Iterator iterateRetweetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Retweet as Retweet");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Retweet", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet createRetweet() {
		return new basededatos.Retweet();
	}
	
	public static boolean save(basededatos.Retweet retweet) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().saveObject(retweet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Retweet retweet) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().deleteObject(retweet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Retweet retweet)throws PersistentException {
		try {
			if (retweet.getUsuario_Registrado() != null) {
				retweet.getUsuario_Registrado().retweets.remove(retweet);
			}
			
			if (retweet.getTweet() != null) {
				retweet.getTweet().retweets.remove(retweet);
			}
			
			return delete(retweet);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Retweet retweet, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (retweet.getUsuario_Registrado() != null) {
				retweet.getUsuario_Registrado().retweets.remove(retweet);
			}
			
			if (retweet.getTweet() != null) {
				retweet.getTweet().retweets.remove(retweet);
			}
			
			try {
				session.delete(retweet);
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
	
	public static boolean refresh(basededatos.Retweet retweet) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().refresh(retweet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Retweet retweet) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().evict(retweet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Retweet loadRetweetByCriteria(RetweetCriteria retweetCriteria) {
		Retweet[] retweets = listRetweetByCriteria(retweetCriteria);
		if(retweets == null || retweets.length == 0) {
			return null;
		}
		return retweets[0];
	}
	
	public static Retweet[] listRetweetByCriteria(RetweetCriteria retweetCriteria) {
		return retweetCriteria.listRetweet();
	}
}
