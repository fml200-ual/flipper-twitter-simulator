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

public class DocumentoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_documento;
	public final StringExpression imagenVideoURL;
	public final StringExpression tipo;
	public final CollectionExpression tweets;
	public final CollectionExpression comentarios;
	
	public DocumentoDetachedCriteria() {
		super(basededatos.Documento.class, basededatos.DocumentoCriteria.class);
		id_documento = new IntegerExpression("id_documento", this.getDetachedCriteria());
		imagenVideoURL = new StringExpression("imagenVideoURL", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		tweets = new CollectionExpression("ORM_tweets", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
	}
	
	public DocumentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.DocumentoCriteria.class);
		id_documento = new IntegerExpression("id_documento", this.getDetachedCriteria());
		imagenVideoURL = new StringExpression("imagenVideoURL", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		tweets = new CollectionExpression("ORM_tweets", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
	}
	
	public TweetDetachedCriteria createTweetsCriteria() {
		return new TweetDetachedCriteria(createCriteria("ORM_tweets"));
	}
	
	public ComentarioDetachedCriteria createComentariosCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_comentarios"));
	}
	
	public Documento uniqueDocumento(PersistentSession session) {
		return (Documento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Documento[] listDocumento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Documento[]) list.toArray(new Documento[list.size()]);
	}
}

