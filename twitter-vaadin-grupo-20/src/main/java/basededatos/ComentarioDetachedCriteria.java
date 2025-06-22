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

public class ComentarioDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public ComentarioDetachedCriteria() {
		super(basededatos.Comentario.class, basededatos.ComentarioCriteria.class);
		id_comentario = new IntegerExpression("id_comentario", this.getDetachedCriteria());
		documentoId = new IntegerExpression("documento.id_documento", this.getDetachedCriteria());
		documento = new AssociationExpression("documento", this.getDetachedCriteria());
		publicado_porId = new IntegerExpression("publicado_por.", this.getDetachedCriteria());
		publicado_por = new AssociationExpression("publicado_por", this.getDetachedCriteria());
		perteneceId = new IntegerExpression("pertenece.id_tweet", this.getDetachedCriteria());
		pertenece = new AssociationExpression("pertenece", this.getDetachedCriteria());
		contenidoComentario = new StringExpression("contenidoComentario", this.getDetachedCriteria());
		fechaPublicacion = new DateExpression("fechaPublicacion", this.getDetachedCriteria());
		recibe_me_gusta = new CollectionExpression("ORM_recibe_me_gusta", this.getDetachedCriteria());
	}
	
	public ComentarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.ComentarioCriteria.class);
		id_comentario = new IntegerExpression("id_comentario", this.getDetachedCriteria());
		documentoId = new IntegerExpression("documento.id_documento", this.getDetachedCriteria());
		documento = new AssociationExpression("documento", this.getDetachedCriteria());
		publicado_porId = new IntegerExpression("publicado_por.", this.getDetachedCriteria());
		publicado_por = new AssociationExpression("publicado_por", this.getDetachedCriteria());
		perteneceId = new IntegerExpression("pertenece.id_tweet", this.getDetachedCriteria());
		pertenece = new AssociationExpression("pertenece", this.getDetachedCriteria());
		contenidoComentario = new StringExpression("contenidoComentario", this.getDetachedCriteria());
		fechaPublicacion = new DateExpression("fechaPublicacion", this.getDetachedCriteria());
		recibe_me_gusta = new CollectionExpression("ORM_recibe_me_gusta", this.getDetachedCriteria());
	}
	
	public DocumentoDetachedCriteria createDocumentoCriteria() {
		return new DocumentoDetachedCriteria(createCriteria("documento"));
	}
	
	public Usuario_RegistradoDetachedCriteria createPublicado_porCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("publicado_por"));
	}
	
	public TweetDetachedCriteria createPerteneceCriteria() {
		return new TweetDetachedCriteria(createCriteria("pertenece"));
	}
	
	public Usuario_RegistradoDetachedCriteria createRecibe_me_gustaCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_recibe_me_gusta"));
	}
	
	public Comentario uniqueComentario(PersistentSession session) {
		return (Comentario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Comentario[] listComentario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Comentario[]) list.toArray(new Comentario[list.size()]);
	}
}

