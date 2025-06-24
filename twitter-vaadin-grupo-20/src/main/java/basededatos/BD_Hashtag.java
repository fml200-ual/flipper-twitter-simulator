package basededatos;


import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Hashtag {
	public BDPrincipal _bd_prin_hashtag;
	public Vector<Hashtag> _contiene_hashtag = new Vector<Hashtag>();

	public void nuevoTweetHashtag(int id_tweet, String[] hashtags) throws PersistentException {
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			for (int i = 0; i < hashtags.length; i++) {
				Hashtag hashtag = HashtagDAO.loadHashtagByQuery("Hashtag = '" + hashtags[i] + "'", null);
				if (hashtag == null) {
					hashtag = HashtagDAO.createHashtag();
					hashtag.setHashtag(hashtags[i]);
					HashtagDAO.save(hashtag);
				}
				hashtag.pertenece.add(tweet);
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
	}

	public Hashtag[] cargarHashtags() throws PersistentException {
		Hashtag[] hashtags = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			hashtags = HashtagDAO.listHashtagByQuery(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return hashtags;
	}
	
	public Hashtag[] buscarHashtag(String hashtag) throws PersistentException {
		Hashtag[] hashtags = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			// Buscar hashtags que coincidan exactamente o contengan el texto buscado
			String query = "Hashtag = '" + hashtag + "'";
			hashtags = HashtagDAO.listHashtagByQuery(query, null);
			
			// Si no se encuentra exactamente, buscar hashtags que contengan el texto
			if (hashtags == null || hashtags.length == 0) {
				query = "Hashtag LIKE '%" + hashtag + "%'";
				hashtags = HashtagDAO.listHashtagByQuery(query, null);
			}
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return hashtags;
	}
	
	/**
	 * Método para contar cuántos tweets usan un hashtag específico
	 */
	public int contarTweetsHashtag(int id_hashtag) {
		try {
			PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
					.getSession().beginTransaction();
			
			Hashtag hashtag = HashtagDAO.getHashtagByORMID(id_hashtag);
			int contador = 0;
			
			if (hashtag != null && hashtag.pertenece != null) {
				contador = hashtag.pertenece.size();
			}
			
			t.commit();
			ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
			return contador;
			
		} catch (Exception e) {
			System.err.println("Error contando tweets del hashtag: " + e.getMessage());
			return 0;
		}
	}
	
}
