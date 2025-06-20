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

public class HashtagDAO {
	public static Hashtag loadHashtagByORMID(int id_hashtag) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadHashtagByORMID(session, id_hashtag);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag getHashtagByORMID(int id_hashtag) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getHashtagByORMID(session, id_hashtag);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag loadHashtagByORMID(int id_hashtag, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadHashtagByORMID(session, id_hashtag, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag getHashtagByORMID(int id_hashtag, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return getHashtagByORMID(session, id_hashtag, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag loadHashtagByORMID(PersistentSession session, int id_hashtag) throws PersistentException {
		try {
			return (Hashtag) session.load(basededatos.Hashtag.class, Integer.valueOf(id_hashtag));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag getHashtagByORMID(PersistentSession session, int id_hashtag) throws PersistentException {
		try {
			return (Hashtag) session.get(basededatos.Hashtag.class, Integer.valueOf(id_hashtag));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag loadHashtagByORMID(PersistentSession session, int id_hashtag, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hashtag) session.load(basededatos.Hashtag.class, Integer.valueOf(id_hashtag), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag getHashtagByORMID(PersistentSession session, int id_hashtag, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hashtag) session.get(basededatos.Hashtag.class, Integer.valueOf(id_hashtag), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHashtag(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryHashtag(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHashtag(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return queryHashtag(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag[] listHashtagByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listHashtagByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag[] listHashtagByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return listHashtagByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHashtag(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Hashtag as Hashtag");
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
	
	public static List queryHashtag(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Hashtag as Hashtag");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hashtag", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag[] listHashtagByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHashtag(session, condition, orderBy);
			return (Hashtag[]) list.toArray(new Hashtag[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag[] listHashtagByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHashtag(session, condition, orderBy, lockMode);
			return (Hashtag[]) list.toArray(new Hashtag[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag loadHashtagByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadHashtagByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag loadHashtagByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return loadHashtagByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag loadHashtagByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Hashtag[] hashtags = listHashtagByQuery(session, condition, orderBy);
		if (hashtags != null && hashtags.length > 0)
			return hashtags[0];
		else
			return null;
	}
	
	public static Hashtag loadHashtagByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Hashtag[] hashtags = listHashtagByQuery(session, condition, orderBy, lockMode);
		if (hashtags != null && hashtags.length > 0)
			return hashtags[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHashtagByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iterateHashtagByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHashtagByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDS22425PFMurilloSuanesPersistentManager.instance().getSession();
			return iterateHashtagByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHashtagByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Hashtag as Hashtag");
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
	
	public static java.util.Iterator iterateHashtagByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Hashtag as Hashtag");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hashtag", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag createHashtag() {
		return new basededatos.Hashtag();
	}
	
	public static boolean save(basededatos.Hashtag hashtag) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().saveObject(hashtag);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Hashtag hashtag) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().deleteObject(hashtag);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Hashtag hashtag)throws PersistentException {
		try {
			basededatos.Tweet[] lPerteneces = hashtag.pertenece.toArray();
			for(int i = 0; i < lPerteneces.length; i++) {
				lPerteneces[i].tiene_hashtag.remove(hashtag);
			}
			return delete(hashtag);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Hashtag hashtag, org.orm.PersistentSession session)throws PersistentException {
		try {
			basededatos.Tweet[] lPerteneces = hashtag.pertenece.toArray();
			for(int i = 0; i < lPerteneces.length; i++) {
				lPerteneces[i].tiene_hashtag.remove(hashtag);
			}
			try {
				session.delete(hashtag);
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
	
	public static boolean refresh(basededatos.Hashtag hashtag) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().refresh(hashtag);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Hashtag hashtag) throws PersistentException {
		try {
			MDS22425PFMurilloSuanesPersistentManager.instance().getSession().evict(hashtag);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hashtag loadHashtagByCriteria(HashtagCriteria hashtagCriteria) {
		Hashtag[] hashtags = listHashtagByCriteria(hashtagCriteria);
		if(hashtags == null || hashtags.length == 0) {
			return null;
		}
		return hashtags[0];
	}
	
	public static Hashtag[] listHashtagByCriteria(HashtagCriteria hashtagCriteria) {
		return hashtagCriteria.listHashtag();
	}
}
