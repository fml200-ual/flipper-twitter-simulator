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

public class PropiedadesBaneoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression duracion;
	public final DateExpression fechaInicioBaneo;
	public final IntegerExpression usuario_RegistradoId;
	public final AssociationExpression usuario_Registrado;
	public final IntegerExpression administradorId;
	public final AssociationExpression administrador;
	
	public PropiedadesBaneoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		duracion = new IntegerExpression("duracion", this);
		fechaInicioBaneo = new DateExpression("fechaInicioBaneo", this);
		usuario_RegistradoId = new IntegerExpression("usuario_Registrado.null", this);
		usuario_Registrado = new AssociationExpression("usuario_Registrado", this);
		administradorId = new IntegerExpression("ORM_Administrador.null", this);
		administrador = new AssociationExpression("ORM_Administrador", this);
	}
	
	public PropiedadesBaneoCriteria(PersistentSession session) {
		this(session.createCriteria(PropiedadesBaneo.class));
	}
	
	public PropiedadesBaneoCriteria() throws PersistentException {
		this(ProyectoMDS120242025PersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createUsuario_RegistradoCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("usuario_Registrado"));
	}
	
	public AdministradorCriteria createAdministradorCriteria() {
		return new AdministradorCriteria(createCriteria("ORM_Administrador"));
	}
	
	public PropiedadesBaneo uniquePropiedadesBaneo() {
		return (PropiedadesBaneo) super.uniqueResult();
	}
	
	public PropiedadesBaneo[] listPropiedadesBaneo() {
		java.util.List list = super.list();
		return (PropiedadesBaneo[]) list.toArray(new PropiedadesBaneo[list.size()]);
	}
}

