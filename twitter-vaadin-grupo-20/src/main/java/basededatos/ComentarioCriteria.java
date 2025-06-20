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

public class ComentarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_comentario;
	public final IntegerExpression documentoId;
	public final AssociationExpression documento;
	public final IntegerExpression publicado_porId;
	public final AssociationExpression publicado_por;
	public final IntegerExpression perteneceId;
	public final AssociationExpression pertenece;
	public final StringExpression contenidoComentario;
	public final DateExpression fechaPublicacion;
	public final CollectionExpression recibe_me_gusta;
	
	public ComentarioCriteria(Criteria criteria) {
		super(criteria);
		id_comentario = new IntegerExpression("id_comentario", this);
		documentoId = new IntegerExpression("documento.id_documento", this);
		documento = new AssociationExpression("documento", this);
		publicado_porId = new IntegerExpression("publicado_por.", this);
		publicado_por = new AssociationExpression("publicado_por", this);
		perteneceId = new IntegerExpression("pertenece.id_tweet", this);
		pertenece = new AssociationExpression("pertenece", this);
		contenidoComentario = new StringExpression("contenidoComentario", this);
		fechaPublicacion = new DateExpression("fechaPublicacion", this);
		recibe_me_gusta = new CollectionExpression("ORM_recibe_me_gusta", this);
	}
	
	public ComentarioCriteria(PersistentSession session) {
		this(session.createCriteria(Comentario.class));
	}
	
	public ComentarioCriteria() throws PersistentException {
		this(MDS22425PFMurilloSuanesPersistentManager.instance().getSession());
	}
	
	public DocumentoCriteria createDocumentoCriteria() {
		return new DocumentoCriteria(createCriteria("documento"));
	}
	
	public Usuario_RegistradoCriteria createPublicado_porCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("publicado_por"));
	}
	
	public TweetCriteria createPerteneceCriteria() {
		return new TweetCriteria(createCriteria("pertenece"));
	}
	
	public Usuario_RegistradoCriteria createRecibe_me_gustaCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_recibe_me_gusta"));
	}
	
	public Comentario uniqueComentario() {
		return (Comentario) super.uniqueResult();
	}
	
	public Comentario[] listComentario() {
		java.util.List list = super.list();
		return (Comentario[]) list.toArray(new Comentario[list.size()]);
	}
}

