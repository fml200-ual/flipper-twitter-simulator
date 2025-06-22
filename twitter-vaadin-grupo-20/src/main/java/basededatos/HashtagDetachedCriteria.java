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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class HashtagDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_hashtag;
	public final StringExpression hashtag;
	public final CollectionExpression pertenece;
	
	public HashtagDetachedCriteria() {
		super(basededatos.Hashtag.class, basededatos.HashtagCriteria.class);
		id_hashtag = new IntegerExpression("id_hashtag", this.getDetachedCriteria());
		hashtag = new StringExpression("hashtag", this.getDetachedCriteria());
		pertenece = new CollectionExpression("ORM_pertenece", this.getDetachedCriteria());
	}
	
	public HashtagDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.HashtagCriteria.class);
		id_hashtag = new IntegerExpression("id_hashtag", this.getDetachedCriteria());
		hashtag = new StringExpression("hashtag", this.getDetachedCriteria());
		pertenece = new CollectionExpression("ORM_pertenece", this.getDetachedCriteria());
	}
	
	public TweetDetachedCriteria createPerteneceCriteria() {
		return new TweetDetachedCriteria(createCriteria("ORM_pertenece"));
	}
	
	public Hashtag uniqueHashtag(PersistentSession session) {
		return (Hashtag) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Hashtag[] listHashtag(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Hashtag[]) list.toArray(new Hashtag[list.size()]);
	}
}

