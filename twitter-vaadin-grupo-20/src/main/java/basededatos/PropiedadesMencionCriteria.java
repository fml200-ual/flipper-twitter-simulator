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

public class PropiedadesMencionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DateExpression fecha;
	public final IntegerExpression usuario_RegistradoId;
	public final AssociationExpression usuario_Registrado;
	public final IntegerExpression tweetId;
	public final AssociationExpression tweet;
	
	public PropiedadesMencionCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		fecha = new DateExpression("fecha", this);
		usuario_RegistradoId = new IntegerExpression("ORM_Usuario_Registrado.null", this);
		usuario_Registrado = new AssociationExpression("ORM_Usuario_Registrado", this);
		tweetId = new IntegerExpression("ORM_Tweet.null", this);
		tweet = new AssociationExpression("ORM_Tweet", this);
	}
	
	public PropiedadesMencionCriteria(PersistentSession session) {
		this(session.createCriteria(PropiedadesMencion.class));
	}
	
	public PropiedadesMencionCriteria() throws PersistentException {
		this(MDS22425PFMurilloSuanesPersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createUsuario_RegistradoCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_Usuario_Registrado"));
	}
	
	public TweetCriteria createTweetCriteria() {
		return new TweetCriteria(createCriteria("ORM_Tweet"));
	}
	
	public PropiedadesMencion uniquePropiedadesMencion() {
		return (PropiedadesMencion) super.uniqueResult();
	}
	
	public PropiedadesMencion[] listPropiedadesMencion() {
		java.util.List list = super.list();
		return (PropiedadesMencion[]) list.toArray(new PropiedadesMencion[list.size()]);
	}
}

