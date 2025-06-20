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

public class PropiedadesSeguidosDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final DateExpression fecha;
	public final IntegerExpression seguidosUsuario_registradoId;
	public final AssociationExpression seguidosUsuario_registrado;
	public final IntegerExpression seguidoresUsuario_registradoId;
	public final AssociationExpression seguidoresUsuario_registrado;
	
	public PropiedadesSeguidosDetachedCriteria() {
		super(basededatos.PropiedadesSeguidos.class, basededatos.PropiedadesSeguidosCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		seguidosUsuario_registradoId = new IntegerExpression("ORM_SeguidosUsuario_registrado.null", this.getDetachedCriteria());
		seguidosUsuario_registrado = new AssociationExpression("ORM_SeguidosUsuario_registrado", this.getDetachedCriteria());
		seguidoresUsuario_registradoId = new IntegerExpression("ORM_SeguidoresUsuario_registrado.null", this.getDetachedCriteria());
		seguidoresUsuario_registrado = new AssociationExpression("ORM_SeguidoresUsuario_registrado", this.getDetachedCriteria());
	}
	
	public PropiedadesSeguidosDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.PropiedadesSeguidosCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		seguidosUsuario_registradoId = new IntegerExpression("ORM_SeguidosUsuario_registrado.null", this.getDetachedCriteria());
		seguidosUsuario_registrado = new AssociationExpression("ORM_SeguidosUsuario_registrado", this.getDetachedCriteria());
		seguidoresUsuario_registradoId = new IntegerExpression("ORM_SeguidoresUsuario_registrado.null", this.getDetachedCriteria());
		seguidoresUsuario_registrado = new AssociationExpression("ORM_SeguidoresUsuario_registrado", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria createSeguidosUsuario_registradoCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("seguidosUsuario_registrado"));
	}
	
	public Usuario_RegistradoDetachedCriteria createSeguidoresUsuario_registradoCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("seguidoresUsuario_registrado"));
	}
	
	public PropiedadesSeguidos uniquePropiedadesSeguidos(PersistentSession session) {
		return (PropiedadesSeguidos) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PropiedadesSeguidos[] listPropiedadesSeguidos(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PropiedadesSeguidos[]) list.toArray(new PropiedadesSeguidos[list.size()]);
	}
}

