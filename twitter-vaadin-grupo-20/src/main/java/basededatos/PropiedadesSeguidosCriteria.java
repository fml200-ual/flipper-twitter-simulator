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

public class PropiedadesSeguidosCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DateExpression fecha;
	public final IntegerExpression seguidosUsuario_registradoId;
	public final AssociationExpression seguidosUsuario_registrado;
	public final IntegerExpression seguidoresUsuario_registradoId;
	public final AssociationExpression seguidoresUsuario_registrado;
	
	public PropiedadesSeguidosCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		fecha = new DateExpression("fecha", this);
		seguidosUsuario_registradoId = new IntegerExpression("ORM_SeguidosUsuario_registrado.null", this);
		seguidosUsuario_registrado = new AssociationExpression("ORM_SeguidosUsuario_registrado", this);
		seguidoresUsuario_registradoId = new IntegerExpression("ORM_SeguidoresUsuario_registrado.null", this);
		seguidoresUsuario_registrado = new AssociationExpression("ORM_SeguidoresUsuario_registrado", this);
	}
	
	public PropiedadesSeguidosCriteria(PersistentSession session) {
		this(session.createCriteria(PropiedadesSeguidos.class));
	}
	
	public PropiedadesSeguidosCriteria() throws PersistentException {
		this(ProyectoMDS120242025PersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createSeguidosUsuario_registradoCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_SeguidosUsuario_registrado"));
	}
	
	public Usuario_RegistradoCriteria createSeguidoresUsuario_registradoCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_SeguidoresUsuario_registrado"));
	}
	
	public PropiedadesSeguidos uniquePropiedadesSeguidos() {
		return (PropiedadesSeguidos) super.uniqueResult();
	}
	
	public PropiedadesSeguidos[] listPropiedadesSeguidos() {
		java.util.List list = super.list();
		return (PropiedadesSeguidos[]) list.toArray(new PropiedadesSeguidos[list.size()]);
	}
}

