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

import org.orm.*;
import org.orm.cfg.JDBCConnectionSetting;
import org.hibernate.*;
import java.util.Properties;
import org.hibernate.cfg.*;
import org.hibernate.boot.MetadataSources;

public class ProyectoMDS120242025PersistentManager extends PersistentManager {
	private static final String PROJECT_NAME = "ProyectoMDS120242025";
	private static PersistentManager _instance = null;
	private static SessionType _sessionType = SessionType.THREAD_BASE;
	private static int _timeToAlive = 60000;
	private static JDBCConnectionSetting _connectionSetting = null;
	private static Properties _extraProperties = null;
	private static String _configurationFile = null;
	
	private ProyectoMDS120242025PersistentManager() throws PersistentException {
		super(_connectionSetting, _sessionType, _timeToAlive, new String[] {}, _extraProperties, _configurationFile);
		setFlushMode(FlushMode.AUTO);
	}
	
	@Override
	protected void configureMetadataSources(MetadataSources aMetadataSources) {
		super.configureMetadataSources(aMetadataSources);
		aMetadataSources.addAnnotatedClass(basededatos.Usuario_Autentificado.class);
		aMetadataSources.addAnnotatedClass(basededatos.Usuario_Registrado.class);
		aMetadataSources.addAnnotatedClass(basededatos.Hashtag.class);
		aMetadataSources.addAnnotatedClass(basededatos.Administrador.class);
		aMetadataSources.addAnnotatedClass(basededatos.Tweet.class);
		aMetadataSources.addAnnotatedClass(basededatos.Documento.class);
		aMetadataSources.addAnnotatedClass(basededatos.PropiedadesMencion.class);
		aMetadataSources.addAnnotatedClass(basededatos.PropiedadesSeguidos.class);
		aMetadataSources.addAnnotatedClass(basededatos.Retweet.class);
		aMetadataSources.addAnnotatedClass(basededatos.PropiedadesBaneo.class);
		aMetadataSources.addAnnotatedClass(basededatos.Comentario.class);
	}
	
	public String getProjectName() {
		return PROJECT_NAME;
	}
	
	public static synchronized final PersistentManager instance() throws PersistentException {
		if (_instance == null) {
			_instance = new ProyectoMDS120242025PersistentManager();
		}
		
		return _instance;
	}
	
	public void disposePersistentManager() throws PersistentException {
		_instance = null;
		super.disposePersistentManager();
	}
	
	public static void setSessionType(SessionType sessionType) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session type after create PersistentManager instance");
		}
		else {
			_sessionType = sessionType;
		}
		
	}
	
	public static void setAppBaseSessionTimeToAlive(int timeInMs) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session time to alive after create PersistentManager instance");
		}
		else {
			_timeToAlive = timeInMs;
		}
		
	}
	
	public static void setJDBCConnectionSetting(JDBCConnectionSetting aConnectionSetting) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set connection setting after create PersistentManager instance");
		}
		else {
			_connectionSetting = aConnectionSetting;
		}
		
	}
	
	public static void setHibernateProperties(Properties aProperties) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set hibernate properties after create PersistentManager instance");
		}
		else {
			_extraProperties = aProperties;
		}
		
	}
	
	public static void setConfigurationFile(String aConfigurationFile) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set configuration file after create PersistentManager instance");
		}
		else {
			_configurationFile = aConfigurationFile;
		}
		
	}
	
	public static void saveJDBCConnectionSetting() {
		PersistentManager.saveJDBCConnectionSetting(PROJECT_NAME, _connectionSetting);
	}
}
