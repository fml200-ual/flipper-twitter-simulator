package interfaz;

import vistas.VistaVerperfil;

public class Verperfil extends VistaVerperfil {
	public Agrupartweets _agrupartweets;
	public Agrupartweetsgustados _agrupartweetsgustados;
	public Agruparretweets _agruparretweets;

	basededatos.Usuario_Registrado _usuario;
	
	// Método para obtener el usuario del perfil desde las clases derivadas
	public basededatos.Usuario_Registrado getUsuarioPerfil() {
		// Retornar el usuario almacenado en el campo _usuario
		return this._usuario;
	}

	public void Agrupartweets() {
		System.out.println("=== Método Agrupartweets() llamado ===");
		System.out.println("Usuario del perfil desde getUsuarioPerfil(): " + (getUsuarioPerfil() != null ? getUsuarioPerfil().toString() : "NULL"));
		
		try {
			System.out.println("=== Creando nuevo Agrupartweets ===");
			_agrupartweets = new Agrupartweets(this, getUsuarioPerfil());
			System.out.println("=== Agrupartweets creado exitosamente ===");
			
			System.out.println("=== Limpiando layout ===");
			this.getTweetsListLayout().removeAll();
			
			System.out.println("=== Agregando componente al layout ===");
			this.getTweetsListLayout().add(_agrupartweets);
			System.out.println("=== Componente Agrupartweets agregado al layout ===");
		} catch (Exception e) {
			System.err.println("ERROR en Agrupartweets(): " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Agrupartweetsgustados() {
		System.err.println("\n\n💖💖💖 MÉTODO AGRUPARTWEETSGUSTADOS LLAMADO 💖💖💖");
		System.err.println("💖💖💖 MÉTODO AGRUPARTWEETSGUSTADOS LLAMADO 💖💖💖");
		System.err.println("Usuario del perfil desde getUsuarioPerfil(): " + (getUsuarioPerfil() != null ? getUsuarioPerfil().toString() : "NULL"));
		
		try {
			System.err.println("💖 Creando nuevo Agrupartweetsgustados...");
			_agrupartweetsgustados = new Agrupartweetsgustados(this, getUsuarioPerfil());
			System.err.println("💖 Agrupartweetsgustados creado exitosamente");
			
			System.err.println("💖 Limpiando layout...");
			this.getTweetsListLayout().removeAll();
			
			System.err.println("💖 Agregando componente al layout...");
			this.getTweetsListLayout().add(_agrupartweetsgustados);
			System.err.println("💖💖💖 COMPONENTE AGRUPARTWEETSGUSTADOS AGREGADO 💖💖💖\n");
		} catch (Exception e) {
			System.err.println("❌❌❌ ERROR EN AGRUPARTWEETSGUSTADOS: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Agruparretweets() {
		System.err.println("\n\n🔄🔄🔄 MÉTODO AGRUPARRETWEETS LLAMADO 🔄🔄🔄");
		System.err.println("🔄🔄🔄 MÉTODO AGRUPARRETWEETS LLAMADO 🔄🔄🔄");
		System.err.println("Usuario del perfil desde getUsuarioPerfil(): " + (getUsuarioPerfil() != null ? getUsuarioPerfil().toString() : "NULL"));
		
		try {
			System.err.println("🔄 Creando nuevo Agruparretweets...");
			_agruparretweets = new Agruparretweets(this, getUsuarioPerfil());
			System.err.println("🔄 Agruparretweets creado exitosamente");
			
			System.err.println("🔄 Limpiando layout...");
			this.getTweetsListLayout().removeAll();
			
			System.err.println("🔄 Agregando componente al layout...");
			this.getTweetsListLayout().add(_agruparretweets);
			System.err.println("🔄🔄🔄 COMPONENTE AGRUPARRETWEETS AGREGADO 🔄🔄🔄\n");
		} catch (Exception e) {
			System.err.println("❌❌❌ ERROR EN AGRUPARRETWEETS: " + e.getMessage());
			e.printStackTrace();
		}
	}

}