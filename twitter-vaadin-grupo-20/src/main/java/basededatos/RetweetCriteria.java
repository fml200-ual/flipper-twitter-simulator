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

public class RetweetCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression tipo;
	public final DateExpression fechaPublicacion;
	public final IntegerExpression usuario_RegistradoId;
	public final AssociationExpression usuario_Registrado;
	public final IntegerExpression tweetId;
	public final AssociationExpression tweet;
	
	public RetweetCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		tipo = new StringExpression("tipo", this);
		fechaPublicacion = new DateExpression("fechaPublicacion", this);
		usuario_RegistradoId = new IntegerExpression("ORM_Usuario_Registrado.null", this);
		usuario_Registrado = new AssociationExpression("ORM_Usuario_Registrado", this);
		tweetId = new IntegerExpression("ORM_Tweet.null", this);
		tweet = new AssociationExpression("ORM_Tweet", this);
	}
	
	public RetweetCriteria(PersistentSession session) {
		this(session.createCriteria(Retweet.class));
	}
	
	public RetweetCriteria() throws PersistentException {
		this(ProyectoMDS120242025PersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createUsuario_RegistradoCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_Usuario_Registrado"));
	}
	
	public TweetCriteria createTweetCriteria() {
		return new TweetCriteria(createCriteria("ORM_Tweet"));
	}
	
	public Retweet uniqueRetweet() {
		return (Retweet) super.uniqueResult();
	}
	
	public Retweet[] listRetweet() {
		java.util.List list = super.list();
		return (Retweet[]) list.toArray(new Retweet[list.size()]);
	}
}

