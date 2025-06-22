package basededatos;


import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Hashtag {
	public BDPrincipal _bd_prin_hashtag;
	public Vector<Hashtag> _contiene_hashtag = new Vector<Hashtag>();

	public void nuevoTweetHashtag(int id_tweet, String[] hashtags) throws PersistentException {
		PersistentTransaction t = MDS12425PFMurilloSuanesPersistentManager.instance()
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
		MDS12425PFMurilloSuanesPersistentManager.instance().disposePersistentManager();
	}

	public Hashtag[] cargarHashtags() throws PersistentException {
		Hashtag[] hashtags = null;
		PersistentTransaction t = MDS12425PFMurilloSuanesPersistentManager.instance()
				.getSession().beginTransaction();
		try {
			hashtags = HashtagDAO.listHashtagByQuery(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return hashtags;
	}
}