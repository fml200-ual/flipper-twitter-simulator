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

public class RetweetDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression tipo;
	public final DateExpression fechaPublicacion;
	public final IntegerExpression usuario_RegistradoId;
	public final AssociationExpression usuario_Registrado;
	public final IntegerExpression tweetId;
	public final AssociationExpression tweet;
	
	public RetweetDetachedCriteria() {
		super(basededatos.Retweet.class, basededatos.RetweetCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		fechaPublicacion = new DateExpression("fechaPublicacion", this.getDetachedCriteria());
		usuario_RegistradoId = new IntegerExpression("ORM_Usuario_Registrado.null", this.getDetachedCriteria());
		usuario_Registrado = new AssociationExpression("ORM_Usuario_Registrado", this.getDetachedCriteria());
		tweetId = new IntegerExpression("ORM_Tweet.null", this.getDetachedCriteria());
		tweet = new AssociationExpression("ORM_Tweet", this.getDetachedCriteria());
	}
	
	public RetweetDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.RetweetCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		fechaPublicacion = new DateExpression("fechaPublicacion", this.getDetachedCriteria());
		usuario_RegistradoId = new IntegerExpression("ORM_Usuario_Registrado.null", this.getDetachedCriteria());
		usuario_Registrado = new AssociationExpression("ORM_Usuario_Registrado", this.getDetachedCriteria());
		tweetId = new IntegerExpression("ORM_Tweet.null", this.getDetachedCriteria());
		tweet = new AssociationExpression("ORM_Tweet", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria createUsuario_RegistradoCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("usuario_Registrado"));
	}
	
	public TweetDetachedCriteria createTweetCriteria() {
		return new TweetDetachedCriteria(createCriteria("tweet"));
	}
	
	public Retweet uniqueRetweet(PersistentSession session) {
		return (Retweet) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Retweet[] listRetweet(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Retweet[]) list.toArray(new Retweet[list.size()]);
	}
}

