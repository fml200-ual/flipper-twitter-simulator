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

public class Usuario_AutentificadoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_usuario;
	public final StringExpression nickname;
	public final StringExpression contrasena;
	
	public Usuario_AutentificadoDetachedCriteria() {
		super(basededatos.Usuario_Autentificado.class, basededatos.Usuario_AutentificadoCriteria.class);
		id_usuario = new IntegerExpression("id_usuario", this.getDetachedCriteria());
		nickname = new StringExpression("nickname", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
	}
	
	public Usuario_AutentificadoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.Usuario_AutentificadoCriteria.class);
		id_usuario = new IntegerExpression("id_usuario", this.getDetachedCriteria());
		nickname = new StringExpression("nickname", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
	}
	
	public Usuario_Autentificado uniqueUsuario_Autentificado(PersistentSession session) {
		return (Usuario_Autentificado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Usuario_Autentificado[] listUsuario_Autentificado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Usuario_Autentificado[]) list.toArray(new Usuario_Autentificado[list.size()]);
	}
}

