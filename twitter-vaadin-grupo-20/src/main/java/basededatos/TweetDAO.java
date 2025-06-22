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

public class TweetDAO {
	public static Tweet loadTweetByORMID(int id_tweet) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return loadTweetByORMID(session, id_tweet);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet getTweetByORMID(int id_tweet) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return getTweetByORMID(session, id_tweet);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet loadTweetByORMID(int id_tweet, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return loadTweetByORMID(session, id_tweet, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet getTweetByORMID(int id_tweet, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return getTweetByORMID(session, id_tweet, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet loadTweetByORMID(PersistentSession session, int id_tweet) throws PersistentException {
		try {
			return (Tweet) session.load(basededatos.Tweet.class, Integer.valueOf(id_tweet));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet getTweetByORMID(PersistentSession session, int id_tweet) throws PersistentException {
		try {
			return (Tweet) session.get(basededatos.Tweet.class, Integer.valueOf(id_tweet));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet loadTweetByORMID(PersistentSession session, int id_tweet, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Tweet) session.load(basededatos.Tweet.class, Integer.valueOf(id_tweet), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet getTweetByORMID(PersistentSession session, int id_tweet, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Tweet) session.get(basededatos.Tweet.class, Integer.valueOf(id_tweet), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTweet(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return queryTweet(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTweet(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return queryTweet(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet[] listTweetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return listTweetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet[] listTweetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return listTweetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTweet(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Tweet as Tweet");
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
	
	public static List queryTweet(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Tweet as Tweet");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Tweet", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet[] listTweetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTweet(session, condition, orderBy);
			return (Tweet[]) list.toArray(new Tweet[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet[] listTweetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTweet(session, condition, orderBy, lockMode);
			return (Tweet[]) list.toArray(new Tweet[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet loadTweetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return loadTweetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet loadTweetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return loadTweetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet loadTweetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Tweet[] tweets = listTweetByQuery(session, condition, orderBy);
		if (tweets != null && tweets.length > 0)
			return tweets[0];
		else
			return null;
	}
	
	public static Tweet loadTweetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Tweet[] tweets = listTweetByQuery(session, condition, orderBy, lockMode);
		if (tweets != null && tweets.length > 0)
			return tweets[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTweetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return iterateTweetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTweetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoMDS120242025PersistentManager.instance().getSession();
			return iterateTweetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTweetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Tweet as Tweet");
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
	
	public static java.util.Iterator iterateTweetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From basededatos.Tweet as Tweet");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Tweet", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet createTweet() {
		return new basededatos.Tweet();
	}
	
	public static boolean save(basededatos.Tweet tweet) throws PersistentException {
		try {
			ProyectoMDS120242025PersistentManager.instance().saveObject(tweet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(basededatos.Tweet tweet) throws PersistentException {
		try {
			ProyectoMDS120242025PersistentManager.instance().deleteObject(tweet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Tweet tweet)throws PersistentException {
		try {
			if (tweet.getPublicado_por() != null) {
				tweet.getPublicado_por().tweets.remove(tweet);
			}
			
			if (tweet.getDocumento() != null) {
				tweet.getDocumento().tweets.remove(tweet);
			}
			
			if (tweet.getTweet_retweeteado() != null) {
				tweet.getTweet_retweeteado().retweets_Cita.remove(tweet);
			}
			
			basededatos.Tweet[] lRetweets_Citas = tweet.retweets_Cita.toArray();
			for(int i = 0; i < lRetweets_Citas.length; i++) {
				lRetweets_Citas[i].setTweet_retweeteado(null);
			}
			basededatos.Hashtag[] lTiene_hashtags = tweet.tiene_hashtag.toArray();
			for(int i = 0; i < lTiene_hashtags.length; i++) {
				lTiene_hashtags[i].pertenece.remove(tweet);
			}
			basededatos.PropiedadesMencion[] lPropiedadesMencionss = tweet.propiedadesMencions.toArray();
			for(int i = 0; i < lPropiedadesMencionss.length; i++) {
				lPropiedadesMencionss[i].setTweet(null);
			}
			basededatos.Retweet[] lRetweetss = tweet.retweets.toArray();
			for(int i = 0; i < lRetweetss.length; i++) {
				lRetweetss[i].setTweet(null);
			}
			basededatos.Comentario[] lTienes = tweet.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setPertenece(null);
			}
			basededatos.Usuario_Registrado[] lRecibe_me_gustas = tweet.recibe_me_gusta.toArray();
			for(int i = 0; i < lRecibe_me_gustas.length; i++) {
				lRecibe_me_gustas[i].me_gusta_tweets.remove(tweet);
			}
			return delete(tweet);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(basededatos.Tweet tweet, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (tweet.getPublicado_por() != null) {
				tweet.getPublicado_por().tweets.remove(tweet);
			}
			
			if (tweet.getDocumento() != null) {
				tweet.getDocumento().tweets.remove(tweet);
			}
			
			if (tweet.getTweet_retweeteado() != null) {
				tweet.getTweet_retweeteado().retweets_Cita.remove(tweet);
			}
			
			basededatos.Tweet[] lRetweets_Citas = tweet.retweets_Cita.toArray();
			for(int i = 0; i < lRetweets_Citas.length; i++) {
				lRetweets_Citas[i].setTweet_retweeteado(null);
			}
			basededatos.Hashtag[] lTiene_hashtags = tweet.tiene_hashtag.toArray();
			for(int i = 0; i < lTiene_hashtags.length; i++) {
				lTiene_hashtags[i].pertenece.remove(tweet);
			}
			basededatos.PropiedadesMencion[] lPropiedadesMencionss = tweet.propiedadesMencions.toArray();
			for(int i = 0; i < lPropiedadesMencionss.length; i++) {
				lPropiedadesMencionss[i].setTweet(null);
			}
			basededatos.Retweet[] lRetweetss = tweet.retweets.toArray();
			for(int i = 0; i < lRetweetss.length; i++) {
				lRetweetss[i].setTweet(null);
			}
			basededatos.Comentario[] lTienes = tweet.tiene.toArray();
			for(int i = 0; i < lTienes.length; i++) {
				lTienes[i].setPertenece(null);
			}
			basededatos.Usuario_Registrado[] lRecibe_me_gustas = tweet.recibe_me_gusta.toArray();
			for(int i = 0; i < lRecibe_me_gustas.length; i++) {
				lRecibe_me_gustas[i].me_gusta_tweets.remove(tweet);
			}
			try {
				session.delete(tweet);
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
	
	public static boolean refresh(basededatos.Tweet tweet) throws PersistentException {
		try {
			ProyectoMDS120242025PersistentManager.instance().getSession().refresh(tweet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(basededatos.Tweet tweet) throws PersistentException {
		try {
			ProyectoMDS120242025PersistentManager.instance().getSession().evict(tweet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tweet loadTweetByCriteria(TweetCriteria tweetCriteria) {
		Tweet[] tweets = listTweetByCriteria(tweetCriteria);
		if(tweets == null || tweets.length == 0) {
			return null;
		}
		return tweets[0];
	}
	
	public static Tweet[] listTweetByCriteria(TweetCriteria tweetCriteria) {
		return tweetCriteria.listTweet();
	}
}
