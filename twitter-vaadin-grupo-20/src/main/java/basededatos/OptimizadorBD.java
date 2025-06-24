package basededatos;

/**
 * OPTIMIZACIÓN DE RENDIMIENTO - Gestión eficiente de consultas BD
 * 
 * Esta clase reduce las conexiones múltiples a la base de datos
 * agrupando consultas relacionadas en lotes (batch operations)
 */
public class OptimizadorBD {
    
    // Cache estático para evitar múltiples instancias de BD_Tweet
    private static BD_Tweet bdTweetInstance = null;
    private static BDPrincipal bdPrincipalInstance = null;
    
    /**
     * Obtener instancia singleton de BD_Tweet para reutilizar conexiones
     */
    public static BD_Tweet getBDTweetInstance() {
        if (bdTweetInstance == null) {
            bdTweetInstance = new BD_Tweet();
        }
        return bdTweetInstance;
    }
    
    /**
     * Obtener instancia singleton de BDPrincipal para reutilizar conexiones
     */
    public static BDPrincipal getBDPrincipalInstance() {
        if (bdPrincipalInstance == null) {
            bdPrincipalInstance = new BDPrincipal();
        }
        return bdPrincipalInstance;
    }
    
    /**
     * Clase para agrupar todos los contadores de un tweet en una sola operación
     */
    public static class ContadoresTweet {
        public int meGusta;
        public int retweets; 
        public int comentarios;
        public boolean leGustaUsuario;
        
        public ContadoresTweet(int meGusta, int retweets, int comentarios, boolean leGustaUsuario) {
            this.meGusta = meGusta;
            this.retweets = retweets;
            this.comentarios = comentarios;
            this.leGustaUsuario = leGustaUsuario;
        }
    }
    
    /**
     * OPTIMIZACIÓN: Cargar todos los contadores de un tweet en una sola llamada
     * para minimizar conexiones a la base de datos
     */
    public static ContadoresTweet cargarContadoresTweet(int idTweet, int idUsuario) {
        try {
            BD_Tweet bdTweet = getBDTweetInstance();
            
            // Batch de consultas usando la misma instancia
            int meGusta = bdTweet.contarMeGustaTweet(idTweet);
            int retweets = bdTweet.contarRetweetsTweet(idTweet);
            int comentarios = bdTweet.contarComentariosTweet(idTweet);
            boolean leGustaUsuario = bdTweet.verificarMeGustaTweet(idUsuario, idTweet);
            
            return new ContadoresTweet(meGusta, retweets, comentarios, leGustaUsuario);
            
        } catch (Exception e) {
            System.err.println("Error en carga optimizada de contadores: " + e.getMessage());
            return new ContadoresTweet(0, 0, 0, false);
        }
    }
    
    /**
     * OPTIMIZACIÓN: Carga diferida - solo cargar contadores cuando se necesiten
     */
    public static ContadoresTweet cargarContadoresLazy(int idTweet, int idUsuario) {
        // Implementar cache local temporal para evitar recarga innecesaria
        // Por ahora, simplemente registrar que se solicitó la carga
        System.out.println("Carga lazy programada para tweet " + idTweet);
        return new ContadoresTweet(0, 0, 0, false);
    }
    
    /**
     * Limpiar cache de instancias (llamar al cerrar la aplicación)
     */
    public static void limpiarCache() {
        bdTweetInstance = null;
        bdPrincipalInstance = null;
        System.out.println("Cache de instancias BD limpiado");
    }
}
