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

public class PropiedadesBaneoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression duracion;
	public final DateExpression fechaInicioBaneo;
	public final IntegerExpression usuario_RegistradoId;
	public final AssociationExpression usuario_Registrado;
	public final IntegerExpression administradorId;
	public final AssociationExpression administrador;
	
	public PropiedadesBaneoDetachedCriteria() {
		super(basededatos.PropiedadesBaneo.class, basededatos.PropiedadesBaneoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		duracion = new IntegerExpression("duracion", this.getDetachedCriteria());
		fechaInicioBaneo = new DateExpression("fechaInicioBaneo", this.getDetachedCriteria());
		usuario_RegistradoId = new IntegerExpression("usuario_Registrado.null", this.getDetachedCriteria());
		usuario_Registrado = new AssociationExpression("usuario_Registrado", this.getDetachedCriteria());
		administradorId = new IntegerExpression("ORM_Administrador.null", this.getDetachedCriteria());
		administrador = new AssociationExpression("ORM_Administrador", this.getDetachedCriteria());
	}
	
	public PropiedadesBaneoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basededatos.PropiedadesBaneoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		duracion = new IntegerExpression("duracion", this.getDetachedCriteria());
		fechaInicioBaneo = new DateExpression("fechaInicioBaneo", this.getDetachedCriteria());
		usuario_RegistradoId = new IntegerExpression("usuario_Registrado.null", this.getDetachedCriteria());
		usuario_Registrado = new AssociationExpression("usuario_Registrado", this.getDetachedCriteria());
		administradorId = new IntegerExpression("ORM_Administrador.null", this.getDetachedCriteria());
		administrador = new AssociationExpression("ORM_Administrador", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria createUsuario_RegistradoCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("usuario_Registrado"));
	}
	
	public AdministradorDetachedCriteria createAdministradorCriteria() {
		return new AdministradorDetachedCriteria(createCriteria("administrador"));
	}
	
	public PropiedadesBaneo uniquePropiedadesBaneo(PersistentSession session) {
		return (PropiedadesBaneo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PropiedadesBaneo[] listPropiedadesBaneo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PropiedadesBaneo[]) list.toArray(new PropiedadesBaneo[list.size()]);
	}
}

