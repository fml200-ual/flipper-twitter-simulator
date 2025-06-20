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

public class Usuario_RegistradoDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Usuario_RegistradoDetachedCriteria() {
		super(basededatos.Usuario_Registrado.class, basededatos.Usuario_RegistradoCriteria.class);
		id_usuario = new IntegerExpression("id_usuario", this.getDetachedCriteria());
		nickname = new StringExpression("nickname", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		imagenFondoURL = new StringExpression("imagenFondoURL", this.getDetachedCriteria());
		fotoPerfilURL = new StringExpression("fotoPerfilURL", this.getDetachedCriteria());
		correoElectronico = new StringExpression("correoElectronico", this.getDetachedCriteria());
		fechaDeRegistro = new DateExpression("fechaDeRegistro", this.getDetachedCriteria());
		me_gusta_Comentarios = new CollectionExpression("ORM_me_gusta_Comentarios", this.getDetachedCriteria());
		tweets = new CollectionExpression("ORM_tweets", this.getDetachedCriteria());
		comentarios_publicados = new CollectionExpression("ORM_comentarios_publicados", this.getDetachedCriteria());
		propiedadesMencions = new CollectionExpression("ORM_propiedadesMencions", this.getDetachedCriteria());
		retweets = new CollectionExpression("ORM_retweets", this.getDetachedCriteria());
		me_gusta_tweets = new CollectionExpression("ORM_me_gusta_tweets", this.getDetachedCriteria());
		seguidoresPropiedadesseguidoss = new CollectionExpression("ORM_seguidoresPropiedadesseguidoss", this.getDetachedCriteria());
		propiedadesBaneoId = new IntegerExpression("propiedadesBaneo.null", this.getDetachedCriteria());
		propiedadesBaneo = new AssociationExpression("propiedadesBaneo", this.getDetachedCriteria());
		meTienenBloqueado = new CollectionExpression("ORM_meTienenBloqueado", this.getDetachedCriteria());
		seguidosPropiedadesseguidoss = new CollectionExpression("ORM_seguidosPropiedadesseguidoss", this.getDetachedCriteria());
		bloqueados = new CollectionExpression("ORM_bloqueados", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.Usuario_RegistradoCriteria.class);
		id_usuario = new IntegerExpression("id_usuario", this.getDetachedCriteria());
		nickname = new StringExpression("nickname", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		imagenFondoURL = new StringExpression("imagenFondoURL", this.getDetachedCriteria());
		fotoPerfilURL = new StringExpression("fotoPerfilURL", this.getDetachedCriteria());
		correoElectronico = new StringExpression("correoElectronico", this.getDetachedCriteria());
		fechaDeRegistro = new DateExpression("fechaDeRegistro", this.getDetachedCriteria());
		me_gusta_Comentarios = new CollectionExpression("ORM_me_gusta_Comentarios", this.getDetachedCriteria());
		tweets = new CollectionExpression("ORM_tweets", this.getDetachedCriteria());
		comentarios_publicados = new CollectionExpression("ORM_comentarios_publicados", this.getDetachedCriteria());
		propiedadesMencions = new CollectionExpression("ORM_propiedadesMencions", this.getDetachedCriteria());
		retweets = new CollectionExpression("ORM_retweets", this.getDetachedCriteria());
		me_gusta_tweets = new CollectionExpression("ORM_me_gusta_tweets", this.getDetachedCriteria());
		seguidoresPropiedadesseguidoss = new CollectionExpression("ORM_seguidoresPropiedadesseguidoss", this.getDetachedCriteria());
		propiedadesBaneoId = new IntegerExpression("propiedadesBaneo.null", this.getDetachedCriteria());
		propiedadesBaneo = new AssociationExpression("propiedadesBaneo", this.getDetachedCriteria());
		meTienenBloqueado = new CollectionExpression("ORM_meTienenBloqueado", this.getDetachedCriteria());
		seguidosPropiedadesseguidoss = new CollectionExpression("ORM_seguidosPropiedadesseguidoss", this.getDetachedCriteria());
		bloqueados = new CollectionExpression("ORM_bloqueados", this.getDetachedCriteria());
	}
	
	public ComentarioDetachedCriteria createMe_gusta_ComentariosCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_me_gusta_Comentarios"));
	}
	
	public TweetDetachedCriteria createTweetsCriteria() {
		return new TweetDetachedCriteria(createCriteria("ORM_tweets"));
	}
	
	public ComentarioDetachedCriteria createComentarios_publicadosCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_comentarios_publicados"));
	}
	
	public PropiedadesMencionDetachedCriteria createPropiedadesMencionsCriteria() {
		return new PropiedadesMencionDetachedCriteria(createCriteria("ORM_propiedadesMencions"));
	}
	
	public RetweetDetachedCriteria createRetweetsCriteria() {
		return new RetweetDetachedCriteria(createCriteria("ORM_retweets"));
	}
	
	public TweetDetachedCriteria createMe_gusta_tweetsCriteria() {
		return new TweetDetachedCriteria(createCriteria("ORM_me_gusta_tweets"));
	}
	
	public PropiedadesSeguidosDetachedCriteria createSeguidoresPropiedadesseguidossCriteria() {
		return new PropiedadesSeguidosDetachedCriteria(createCriteria("ORM_seguidoresPropiedadesseguidoss"));
	}
	
	public PropiedadesBaneoDetachedCriteria createPropiedadesBaneoCriteria() {
		return new PropiedadesBaneoDetachedCriteria(createCriteria("propiedadesBaneo"));
	}
	
	public Usuario_RegistradoDetachedCriteria createMeTienenBloqueadoCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_meTienenBloqueado"));
	}
	
	public PropiedadesSeguidosDetachedCriteria createSeguidosPropiedadesseguidossCriteria() {
		return new PropiedadesSeguidosDetachedCriteria(createCriteria("ORM_seguidosPropiedadesseguidoss"));
	}
	
	public Usuario_RegistradoDetachedCriteria createBloqueadosCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_bloqueados"));
	}
	
	public Usuario_Registrado uniqueUsuario_Registrado(PersistentSession session) {
		return (Usuario_Registrado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Usuario_Registrado[] listUsuario_Registrado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Usuario_Registrado[]) list.toArray(new Usuario_Registrado[list.size()]);
	}
}

