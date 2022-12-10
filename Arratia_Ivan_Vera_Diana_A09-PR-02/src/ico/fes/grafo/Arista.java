package ico.fes.grafo;
/**
 *
 * @author ivan_
 */
public class Arista {
    
    public final int inicio, destino;//declaramos las variables inicio y destino 
    

    private Arista(int inicio, int destino) {//se inicializan las variables  
        this.inicio = inicio;
        this.destino = destino;
    }

    public static Arista of(int x, int y) {//metodo para obtener la instancia de arista
        return new Arista(x, y);//retorna las nuevas aristas        
    }
    
}
