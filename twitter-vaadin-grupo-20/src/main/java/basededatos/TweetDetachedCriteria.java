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

public class TweetDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_tweet;
	public final IntegerExpression publicado_porId;
	public final AssociationExpression publicado_por;
	public final IntegerExpression documentoId;
	public final AssociationExpression documento;
	public final IntegerExpression tweet_retweeteadoId;
	public final AssociationExpression tweet_retweeteado;
	public final StringExpression contenidoTweet;
	public final DateExpression fechaPublicacion;
	public final CollectionExpression retweets_Cita;
	public final CollectionExpression tiene_hashtag;
	public final CollectionExpression propiedadesMencions;
	public final CollectionExpression retweets;
	public final CollectionExpression tiene;
	public final CollectionExpression recibe_me_gusta;
	
	public TweetDetachedCriteria() {
		super(basededatos.Tweet.class, basededatos.TweetCriteria.class);
		id_tweet = new IntegerExpression("id_tweet", this.getDetachedCriteria());
		publicado_porId = new IntegerExpression("publicado_por.", this.getDetachedCriteria());
		publicado_por = new AssociationExpression("publicado_por", this.getDetachedCriteria());
		documentoId = new IntegerExpression("documento.id_documento", this.getDetachedCriteria());
		documento = new AssociationExpression("documento", this.getDetachedCriteria());
		tweet_retweeteadoId = new IntegerExpression("tweet_retweeteado.id_tweet", this.getDetachedCriteria());
		tweet_retweeteado = new AssociationExpression("tweet_retweeteado", this.getDetachedCriteria());
		contenidoTweet = new StringExpression("contenidoTweet", this.getDetachedCriteria());
		fechaPublicacion = new DateExpression("fechaPublicacion", this.getDetachedCriteria());
		retweets_Cita = new CollectionExpression("ORM_retweets_Cita", this.getDetachedCriteria());
		tiene_hashtag = new CollectionExpression("ORM_tiene_hashtag", this.getDetachedCriteria());
		propiedadesMencions = new CollectionExpression("ORM_propiedadesMencions", this.getDetachedCriteria());
		retweets = new CollectionExpression("ORM_retweets", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		recibe_me_gusta = new CollectionExpression("ORM_recibe_me_gusta", this.getDetachedCriteria());
	}
	
	public TweetDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.TweetCriteria.class);
		id_tweet = new IntegerExpression("id_tweet", this.getDetachedCriteria());
		publicado_porId = new IntegerExpression("publicado_por.", this.getDetachedCriteria());
		publicado_por = new AssociationExpression("publicado_por", this.getDetachedCriteria());
		documentoId = new IntegerExpression("documento.id_documento", this.getDetachedCriteria());
		documento = new AssociationExpression("documento", this.getDetachedCriteria());
		tweet_retweeteadoId = new IntegerExpression("tweet_retweeteado.id_tweet", this.getDetachedCriteria());
		tweet_retweeteado = new AssociationExpression("tweet_retweeteado", this.getDetachedCriteria());
		contenidoTweet = new StringExpression("contenidoTweet", this.getDetachedCriteria());
		fechaPublicacion = new DateExpression("fechaPublicacion", this.getDetachedCriteria());
		retweets_Cita = new CollectionExpression("ORM_retweets_Cita", this.getDetachedCriteria());
		tiene_hashtag = new CollectionExpression("ORM_tiene_hashtag", this.getDetachedCriteria());
		propiedadesMencions = new CollectionExpression("ORM_propiedadesMencions", this.getDetachedCriteria());
		retweets = new CollectionExpression("ORM_retweets", this.getDetachedCriteria());
		tiene = new CollectionExpression("ORM_tiene", this.getDetachedCriteria());
		recibe_me_gusta = new CollectionExpression("ORM_recibe_me_gusta", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria createPublicado_porCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("publicado_por"));
	}
	
	public DocumentoDetachedCriteria createDocumentoCriteria() {
		return new DocumentoDetachedCriteria(createCriteria("documento"));
	}
	
	public TweetDetachedCriteria createTweet_retweeteadoCriteria() {
		return new TweetDetachedCriteria(createCriteria("tweet_retweeteado"));
	}
	
	public TweetDetachedCriteria createRetweets_CitaCriteria() {
		return new TweetDetachedCriteria(createCriteria("ORM_retweets_Cita"));
	}
	
	public HashtagDetachedCriteria createTiene_hashtagCriteria() {
		return new HashtagDetachedCriteria(createCriteria("ORM_tiene_hashtag"));
	}
	
	public PropiedadesMencionDetachedCriteria createPropiedadesMencionsCriteria() {
		return new PropiedadesMencionDetachedCriteria(createCriteria("ORM_propiedadesMencions"));
	}
	
	public RetweetDetachedCriteria createRetweetsCriteria() {
		return new RetweetDetachedCriteria(createCriteria("ORM_retweets"));
	}
	
	public ComentarioDetachedCriteria createTieneCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_tiene"));
	}
	
	public Usuario_RegistradoDetachedCriteria createRecibe_me_gustaCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_recibe_me_gusta"));
	}
	
	public Tweet uniqueTweet(PersistentSession session) {
		return (Tweet) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Tweet[] listTweet(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Tweet[]) list.toArray(new Tweet[list.size()]);
	}
}

