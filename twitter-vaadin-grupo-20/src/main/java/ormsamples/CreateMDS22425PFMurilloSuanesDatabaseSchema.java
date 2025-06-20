/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;

public class CreateMDS22425PFMurilloSuanesDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(basededatos.MDS22425PFMurilloSuanesPersistentManager.instance());
			basededatos.MDS22425PFMurilloSuanesPersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
