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

public class Usuario_RegistradoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_usuario;
	public final StringExpression nickname;
	public final StringExpression contrasena;
	public final StringExpression descripcion;
	public final StringExpression imagenFondoURL;
	public final StringExpression fotoPerfilURL;
	public final StringExpression correoElectronico;
	public final DateExpression fechaDeRegistro;
	public final CollectionExpression me_gusta_Comentarios;
	public final CollectionExpression tweets;
	public final CollectionExpression comentarios_publicados;
	public final CollectionExpression propiedadesMencions;
	public final CollectionExpression retweets;
	public final CollectionExpression me_gusta_tweets;
	public final CollectionExpression seguidoresPropiedadesseguidoss;
	public final IntegerExpression propiedadesBaneoId;
	public final AssociationExpression propiedadesBaneo;
	public final CollectionExpression meTienenBloqueado;
	public final CollectionExpression seguidosPropiedadesseguidoss;
	public final CollectionExpression bloqueados;
	
	public Usuario_RegistradoCriteria(Criteria criteria) {
		super(criteria);
		id_usuario = new IntegerExpression("id_usuario", this);
		nickname = new StringExpression("nickname", this);
		contrasena = new StringExpression("contrasena", this);
		descripcion = new StringExpression("descripcion", this);
		imagenFondoURL = new StringExpression("imagenFondoURL", this);
		fotoPerfilURL = new StringExpression("fotoPerfilURL", this);
		correoElectronico = new StringExpression("correoElectronico", this);
		fechaDeRegistro = new DateExpression("fechaDeRegistro", this);
		me_gusta_Comentarios = new CollectionExpression("ORM_me_gusta_Comentarios", this);
		tweets = new CollectionExpression("ORM_tweets", this);
		comentarios_publicados = new CollectionExpression("ORM_comentarios_publicados", this);
		propiedadesMencions = new CollectionExpression("ORM_propiedadesMencions", this);
		retweets = new CollectionExpression("ORM_retweets", this);
		me_gusta_tweets = new CollectionExpression("ORM_me_gusta_tweets", this);
		seguidoresPropiedadesseguidoss = new CollectionExpression("ORM_seguidoresPropiedadesseguidoss", this);
		propiedadesBaneoId = new IntegerExpression("propiedadesBaneo.null", this);
		propiedadesBaneo = new AssociationExpression("propiedadesBaneo", this);
		meTienenBloqueado = new CollectionExpression("ORM_meTienenBloqueado", this);
		seguidosPropiedadesseguidoss = new CollectionExpression("ORM_seguidosPropiedadesseguidoss", this);
		bloqueados = new CollectionExpression("ORM_bloqueados", this);
	}
	
	public Usuario_RegistradoCriteria(PersistentSession session) {
		this(session.createCriteria(Usuario_Registrado.class));
	}
	
	public Usuario_RegistradoCriteria() throws PersistentException {
		this(MDS22425PFMurilloSuanesPersistentManager.instance().getSession());
	}
	
	public ComentarioCriteria createMe_gusta_ComentariosCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_me_gusta_Comentarios"));
	}
	
	public TweetCriteria createTweetsCriteria() {
		return new TweetCriteria(createCriteria("ORM_tweets"));
	}
	
	public ComentarioCriteria createComentarios_publicadosCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_comentarios_publicados"));
	}
	
	public PropiedadesMencionCriteria createPropiedadesMencionsCriteria() {
		return new PropiedadesMencionCriteria(createCriteria("ORM_propiedadesMencions"));
	}
	
	public RetweetCriteria createRetweetsCriteria() {
		return new RetweetCriteria(createCriteria("ORM_retweets"));
	}
	
	public TweetCriteria createMe_gusta_tweetsCriteria() {
		return new TweetCriteria(createCriteria("ORM_me_gusta_tweets"));
	}
	
	public PropiedadesSeguidosCriteria createSeguidoresPropiedadesseguidossCriteria() {
		return new PropiedadesSeguidosCriteria(createCriteria("ORM_seguidoresPropiedadesseguidoss"));
	}
	
	public PropiedadesBaneoCriteria createPropiedadesBaneoCriteria() {
		return new PropiedadesBaneoCriteria(createCriteria("propiedadesBaneo"));
	}
	
	public Usuario_RegistradoCriteria createMeTienenBloqueadoCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_meTienenBloqueado"));
	}
	
	public PropiedadesSeguidosCriteria createSeguidosPropiedadesseguidossCriteria() {
		return new PropiedadesSeguidosCriteria(createCriteria("ORM_seguidosPropiedadesseguidoss"));
	}
	
	public Usuario_RegistradoCriteria createBloqueadosCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_bloqueados"));
	}
	
	public Usuario_Registrado uniqueUsuario_Registrado() {
		return (Usuario_Registrado) super.uniqueResult();
	}
	
	public Usuario_Registrado[] listUsuario_Registrado() {
		java.util.List list = super.list();
		return (Usuario_Registrado[]) list.toArray(new Usuario_Registrado[list.size()]);
	}
}

