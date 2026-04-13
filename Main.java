public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Secuencia de páginas a las que se accederá en la simulación
        // Números duplicados representan accesos a páginas ya cargadas
        int[] secuenciaPaginas = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        System.out.println("Secuencia de paginas creada");
        
        // Capacidad de la memoria: solo 3 páginas pueden estar cargadas simultáneamente
        int capacidadMemoria = 3;
        
        // Crear instancia del algoritmo FIFO
        FIFO algoritmoFIFO = new FIFO(capacidadMemoria);
        
        // Procesar cada página de la secuencia
        for (int pagina : secuenciaPaginas) {
            algoritmoFIFO.procesarPagina(pagina);
        }
        
        // Mostrar resultado final: total de fallos de página
        System.out.println("\nTotal de fallos de página: " + algoritmoFIFO.getFallosPagina());
    }
}
