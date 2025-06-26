package basededatos;

import java.util.Date;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Administrador {
	public BDPrincipal _bd_prin_admin;
	public Vector<Administrador> _contiene_admin = new Vector<Administrador>();

	public Administrador loginAdmin(String nombreUsuario, String contrasena) throws PersistentException {
		Administrador admin = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Usuario_Autentificado userAux = Usuario_AutentificadoDAO.loadUsuario_AutentificadoByQuery(
					"Nickname = '" + nombreUsuario + "' AND Contrasena = '" + contrasena + "'", null);
			if (userAux != null) {
				admin = AdministradorDAO.getAdministradorByORMID(userAux.getId_usuario());
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return admin;
	}

	public Administrador banear(int id_administrador, int id_usuarioBaneado, int duracionBaneo, Date fechaInicioBaneo) throws PersistentException {
		Administrador admin = null;
		PersistentTransaction t = ProyectoMDS120242025PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			admin = AdministradorDAO.getAdministradorByORMID(id_administrador);
			Usuario_Registrado user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(id_usuarioBaneado);
			PropiedadesBaneo baneo = PropiedadesBaneoDAO.createPropiedadesBaneo();
			baneo.setAdministrador(admin);
			baneo.setUsuario_Registrado(user);
			baneo.setDuracion(duracionBaneo);
			baneo.setFechaInicioBaneo(fechaInicioBaneo);
			PropiedadesBaneoDAO.save(baneo);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		ProyectoMDS120242025PersistentManager.instance().disposePersistentManager();
		return admin;
	}
}
