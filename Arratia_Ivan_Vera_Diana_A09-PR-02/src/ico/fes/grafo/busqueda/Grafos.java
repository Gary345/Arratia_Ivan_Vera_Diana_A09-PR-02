package ico.fes.grafo.busqueda;
import ico.fes.grafo.Arista;//importamos la clase Borde
import ico.fes.grafo.Grafo;//importamos la clase Grafo
import java.util.Arrays;//importamos la paqueteria de arreglos
import java.util.List;//importamos la paqueteria de listas
import java.util.Stack;//importamos la clase pila
import java.util.Scanner;//importamos la clase Sccaner para obtener los elementos

//Funcion que recorre el grafo 
public class Grafos {
   //Declaramos distintas variables para poder iniciar nuestro codigo(Ni = Nodo inicial, Nf=Nodo final)
public static boolean DFs(Grafo grafo, int Ni, int Nf, boolean[] recorrido, Stack<Integer> ruta, int sentido) { 

 recorrido[Ni] = true;//el nodo inicial se establece como visitado
ruta.add(Ni);//se añade el nodo inicial a la ruta       
if (sentido==1 ||sentido==2 ) {//condicional para solo aceptar 2 valores
System.out.println(" Los nodos adyacentes de "+Ni+" son: "+grafo.listaAdj.get(Ni));//se imprimen los nodos de la lista de adyacencia
 
}
    

     if (Ni == Nf) {//se verifia la existencia del nodo final
         return true;}
     
     //funcion switch para escoger el recorrido en sentido horario o antihorario
     switch(sentido){
            case 1://sentido horario
                for (int i : grafo.listaAdj.get(Ni)) //empieza a recorrer el grafo conforme a la lista de adyacencia
                {
                    if (!recorrido[i]) {//si aun no ha recorrido el nodo *
                        if (DFs(grafo, i, Nf, recorrido, ruta, sentido)) {//devuelve verdadero si se encuentra el nodo final
                            return true;
                        }
                    }
                }
            break;
            case 2:
                for (int i : grafo.inversa.get(Ni)) {//empieza a recorrer el grafo inveros a la lista de adyacencia
                    if (!recorrido[i]) {//si aun no ha recorrido el nodo *
   
                        if (DFs(grafo, i, Nf, recorrido, ruta, sentido)) {//devuelve verdadero si se encuentra el nodo final
                            return true;
                        }
                    }
                }   
            break;
            default: //si el usuario ingresa cualquier otro numero que no sea 1 0 2 se muestra este mensaje
                System.out.println("Favor de ingresar un nymero valido  (1 o 2)");
        }
        ruta.pop();//elimina el nodo inicial de la ruta
        
        return false;//regresa falso si la ruta no es accesible 
        
    }

    public static void main(String[] args) {
        

        int t = 29; //variable que indica el tamaño del arreglo
        Scanner sc = new Scanner(System.in);//funcion para escanear entrada
        
        System.out.println("Ingrese el nodo inicial: ");//Le pedimos al usuario que ingrese el nodo inicial
        int Ni = sc.nextInt();
        
        System.out.println("Ingrese el nodo final: ");//Le pedimos al usuario que ingrese el nodo final
        int Nf = sc.nextInt();
     
        System.out.println("(1)Busqueda en sentido horario \t (2) Busqueda en sentido antihorario");//Le pedimos al usuario que escoja el sentido de la busqueda 
        int sentido = sc.nextInt();
        //lista de adyacencia ordenada
        List<Arista> aristas = Arrays.asList(Arista.of(1,6),Arista.of(1,13),Arista.of(1,4),Arista.of(2,22),Arista.of(2,12),Arista.of(2,9),Arista.of(3,14),
        Arista.of(3,23),Arista.of(3,19),Arista.of(3,18),Arista.of(4,9),Arista.of(4,1),Arista.of(4,13),Arista.of(5,15),
        Arista.of(5,11),Arista.of(6,16),Arista.of(6,1),Arista.of(7,27),Arista.of(7,8),Arista.of(7,11), Arista.of(8,27), 
        Arista.of(8,15),Arista.of(8,7),Arista.of(9,28),Arista.of(9,2),Arista.of(9,17),Arista.of(9,4),Arista.of(9,24),
        Arista.of(10,16),Arista.of(10,12),Arista.of(11,7),Arista.of(11,5),Arista.of(12,10),Arista.of(12,2),Arista.of(13,4),
        Arista.of(13,1),Arista.of(13,24),Arista.of(14,23),Arista.of(14,3),Arista.of(15,8),Arista.of(15,24),Arista.of(15,5),
        Arista.of(16,19),Arista.of(16,25),Arista.of(16,20),Arista.of(16,6),Arista.of(16,26),Arista.of(16,10),Arista.of(17,26), 
        Arista.of(17,9),Arista.of(18,14),Arista.of(18,3),Arista.of(18,21),Arista.of(19,23), Arista.of(19,16),Arista.of(19,3),
        Arista.of(20,25),Arista.of(20,16),Arista.of(21,18),Arista.of(21,22),Arista.of(21,28),Arista.of(21,27),Arista.of(22,23), 
        Arista.of(22, 2),Arista.of(22,28),Arista.of(22,21),Arista.of(23,14),Arista.of(23,19),Arista.of(23,22),Arista.of(23,3),
        Arista.of(24,9),Arista.of(24,13),Arista.of(24,15),Arista.of(25,0),Arista.of(26,16),Arista.of(26,17),Arista.of(27,21), 
        Arista.of(27, 28),Arista.of(27,8),Arista.of(27,7),Arista.of(28,27),Arista.of(28,21),Arista.of(28,22), Arista.of(28,2), 
        Arista.of(28, 9),Arista.of(28, 8));
        
        Grafo grafo = new Grafo(aristas, t);//Genera un grafo sgun las aristasy el tamaño del arreglo

        boolean[] recorrido = new boolean[t];

        Stack<Integer> ruta = new Stack<>();//se guarda la informacion en la pila
        
        if (DFs(grafo, Ni, Nf, recorrido, ruta, sentido)) {
            System.out.println("La ruta del Nodo inicial al Nodo Final es" + ruta);//se impirme la ruta 
        } else {
            //si no se encuentra una ruta se imprime este mensaje
            System.out.println("No se encontro una ruta entre el Nodo Inicial" + Ni+ " y el Nodo Final " + Nf);
            
          
        }
    }
}

