import java.util.*;

/**
 * Clase FIFO
 * 
 * Implementa el algoritmo de reemplazo de páginas FIFO (First In, First Out).
 * Este algoritmo simula la gestión de memoria virtual, donde las páginas que
 * se cargaron primero son las primeras en ser reemplazadas cuando la memoria está llena.
 */
public class FIFO {
    // Cola que mantiene el orden FIFO de las páginas en memoria
    private Queue<Integer> memoriaOrdenada = new LinkedList<>();
    
    // Conjunto para búsqueda rápida de páginas en memoria (O(1))
    private Set<Integer> enMemoria = new HashSet<>();
    
    private int capacidadMemoria;
    
    private int fallosPagina;
    
    /**
     * Constructor del algoritmo FIFO
     * @param capacidadMemoria Número máximo de páginas que pueden estar en memoria
     */
    public FIFO(int capacidadMemoria) {
        this.capacidadMemoria = capacidadMemoria;
    }
    
    /**
     * @param pagina Número de página a acceder
     */
    public void procesarPagina(int pagina) {
        System.out.println("\nAccediendo a página " + pagina);
        
        // Verificar si la página ya está cargada en memoria
        if (!enMemoria.contains(pagina)) {
            System.out.println("La pagina aun no esta en memoria");
            fallosPagina++;
            
            // Si la memoria está llena, aplicar política FIFO: eliminar la más antigua
            if (memoriaOrdenada.size() == capacidadMemoria) {
                int eliminada = memoriaOrdenada.poll();
                enMemoria.remove(eliminada);
                System.out.println("Reemplazo: se elimina página " + eliminada);
            }
            
            // Cargar la nueva página
            memoriaOrdenada.add(pagina);
            enMemoria.add(pagina);
            System.out.println("Se carga página " + pagina);
        } else {
            System.out.println("Página " + pagina + " ya está en memoria");
        }
        
        System.out.println("Memoria actual: " + memoriaOrdenada);
    }
    
    /**
     * Retorna el número total de fallos de página que ocurrieron.
     * @return Total de fallos de página
     */
    public int getFallosPagina() {
        return fallosPagina;
    }
}
