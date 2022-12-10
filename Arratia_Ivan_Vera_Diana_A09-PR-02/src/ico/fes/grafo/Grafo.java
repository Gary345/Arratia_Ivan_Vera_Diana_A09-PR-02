
package ico.fes.grafo;
import java.util.ArrayList;//importamos la paqueteria arreglos
import java.util.Collections;//importamos la paqueteria de colecciones
import java.util.List;//importamos la paqueteria listas

/**
 *
 * @author ivan_
 */
public class Grafo {
    
   public List<List<Integer>> listaAdj = null;//una lista dentro de otra para inicializar con lalistade adyacencia
   public List<List<Integer>> inversa = null;//inicializar la inversa de la lista de adyacencia

    public Grafo(List<Arista> aristas, int n) {//constructor de la clase
        listaAdj = new ArrayList<>();//se inicializan nuevos arreglos para lista adyacente y su inversa
        inversa = new ArrayList<>();

        for (int i = 0; i < n; i++) {//cicñp que recorre la lista y lo agrega a las nuevas listas
            listaAdj.add(new ArrayList<>());
            inversa.add(new ArrayList<>());
        }

      
        for (Arista arista : aristas) {//se agregan las asristas al grafo
            listaAdj.get(arista.inicio).add(arista.destino);
        }
        
        Collections.reverse(aristas);
         for (Arista edge : aristas) {//se invierte el sentido de las aristas del grafo
            inversa.get(edge.inicio).add(edge.destino);
        }
    } 
}
