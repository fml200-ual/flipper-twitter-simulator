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

public class Usuario_AutentificadoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_usuario;
	public final StringExpression nickname;
	public final StringExpression contrasena;
	
	public Usuario_AutentificadoCriteria(Criteria criteria) {
		super(criteria);
		id_usuario = new IntegerExpression("id_usuario", this);
		nickname = new StringExpression("nickname", this);
		contrasena = new StringExpression("contrasena", this);
	}
	
	public Usuario_AutentificadoCriteria(PersistentSession session) {
		this(session.createCriteria(Usuario_Autentificado.class));
	}
	
	public Usuario_AutentificadoCriteria() throws PersistentException {
		this(ProyectoMDS120242025PersistentManager.instance().getSession());
	}
	
	public Usuario_Autentificado uniqueUsuario_Autentificado() {
		return (Usuario_Autentificado) super.uniqueResult();
	}
	
	public Usuario_Autentificado[] listUsuario_Autentificado() {
		java.util.List list = super.list();
		return (Usuario_Autentificado[]) list.toArray(new Usuario_Autentificado[list.size()]);
	}
}

