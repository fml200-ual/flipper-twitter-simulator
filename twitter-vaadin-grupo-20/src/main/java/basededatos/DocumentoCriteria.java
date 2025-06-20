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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DocumentoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_documento;
	public final StringExpression imagenVideoURL;
	public final StringExpression tipo;
	public final CollectionExpression tweets;
	public final CollectionExpression comentarios;
	
	public DocumentoCriteria(Criteria criteria) {
		super(criteria);
		id_documento = new IntegerExpression("id_documento", this);
		imagenVideoURL = new StringExpression("imagenVideoURL", this);
		tipo = new StringExpression("tipo", this);
		tweets = new CollectionExpression("ORM_tweets", this);
		comentarios = new CollectionExpression("ORM_comentarios", this);
	}
	
	public DocumentoCriteria(PersistentSession session) {
		this(session.createCriteria(Documento.class));
	}
	
	public DocumentoCriteria() throws PersistentException {
		this(MDS22425PFMurilloSuanesPersistentManager.instance().getSession());
	}
	
	public TweetCriteria createTweetsCriteria() {
		return new TweetCriteria(createCriteria("ORM_tweets"));
	}
	
	public ComentarioCriteria createComentariosCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_comentarios"));
	}
	
	public Documento uniqueDocumento() {
		return (Documento) super.uniqueResult();
	}
	
	public Documento[] listDocumento() {
		java.util.List list = super.list();
		return (Documento[]) list.toArray(new Documento[list.size()]);
	}
}

