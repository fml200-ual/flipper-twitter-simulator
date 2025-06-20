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

public class TweetCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_tweet;
	public final IntegerExpression publicado_porId;
	public final AssociationExpression publicado_por;
	public final IntegerExpression documentoId;
	public final AssociationExpression documento;
	public final IntegerExpression tweet_retweeteadoId;
	public final AssociationExpression tweet_retweeteado;
	public final StringExpression contenidoTweet;
	public final DateExpression fechaPublicacion;
	public final CollectionExpression tiene_hashtag;
	public final CollectionExpression retweets_Cita;
	public final CollectionExpression tiene;
	public final CollectionExpression propiedadesMencions;
	public final CollectionExpression retweets;
	public final CollectionExpression recibe_me_gusta;
	
	public TweetCriteria(Criteria criteria) {
		super(criteria);
		id_tweet = new IntegerExpression("id_tweet", this);
		publicado_porId = new IntegerExpression("publicado_por.", this);
		publicado_por = new AssociationExpression("publicado_por", this);
		documentoId = new IntegerExpression("documento.id_documento", this);
		documento = new AssociationExpression("documento", this);
		tweet_retweeteadoId = new IntegerExpression("tweet_retweeteado.id_tweet", this);
		tweet_retweeteado = new AssociationExpression("tweet_retweeteado", this);
		contenidoTweet = new StringExpression("contenidoTweet", this);
		fechaPublicacion = new DateExpression("fechaPublicacion", this);
		tiene_hashtag = new CollectionExpression("ORM_tiene_hashtag", this);
		retweets_Cita = new CollectionExpression("ORM_retweets_Cita", this);
		tiene = new CollectionExpression("ORM_tiene", this);
		propiedadesMencions = new CollectionExpression("ORM_propiedadesMencions", this);
		retweets = new CollectionExpression("ORM_retweets", this);
		recibe_me_gusta = new CollectionExpression("ORM_recibe_me_gusta", this);
	}
	
	public TweetCriteria(PersistentSession session) {
		this(session.createCriteria(Tweet.class));
	}
	
	public TweetCriteria() throws PersistentException {
		this(MDS22425PFMurilloSuanesPersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createPublicado_porCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("publicado_por"));
	}
	
	public DocumentoCriteria createDocumentoCriteria() {
		return new DocumentoCriteria(createCriteria("documento"));
	}
	
	public TweetCriteria createTweet_retweeteadoCriteria() {
		return new TweetCriteria(createCriteria("tweet_retweeteado"));
	}
	
	public HashtagCriteria createTiene_hashtagCriteria() {
		return new HashtagCriteria(createCriteria("ORM_tiene_hashtag"));
	}
	
	public TweetCriteria createRetweets_CitaCriteria() {
		return new TweetCriteria(createCriteria("ORM_retweets_Cita"));
	}
	
	public ComentarioCriteria createTieneCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_tiene"));
	}
	
	public PropiedadesMencionCriteria createPropiedadesMencionsCriteria() {
		return new PropiedadesMencionCriteria(createCriteria("ORM_propiedadesMencions"));
	}
	
	public RetweetCriteria createRetweetsCriteria() {
		return new RetweetCriteria(createCriteria("ORM_retweets"));
	}
	
	public Usuario_RegistradoCriteria createRecibe_me_gustaCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_recibe_me_gusta"));
	}
	
	public Tweet uniqueTweet() {
		return (Tweet) super.uniqueResult();
	}
	
	public Tweet[] listTweet() {
		java.util.List list = super.list();
		return (Tweet[]) list.toArray(new Tweet[list.size()]);
	}
}

