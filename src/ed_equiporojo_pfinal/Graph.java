/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_equiporojo_pfinal;

/**
 *
 * @author Rodrigo
 */
public class Graph {
    private int v,e;
    private List<Edge> g[];
    private boolean visited[];
    private String path = "";
    int parent[];
    
    public Graph(int v){ //Constructor con el numero de vertices
        this.v=v;
        this.e=0;
        g = new List[v+1]; //El numero de vertices se aumenta en uno para evitar confusiones con tamaño de arreglo
        for(int i=1; i<v+1; i++){
            g[i]= new List<Edge>(); //Instancía una lista en cada elemento del arreglo
        }
    }
    public int getEdges(){
        return this.e;
    }
    
    public int getVertices(){
        return this.v;
    }
    
    //Determina si edge esta en el grafo
    public boolean isEdge(int s, int d){
        List<Edge> l = this.g[s];
        Node<Edge> p = l.first;
        for(int i=0;i<l.length;i++){ //Rcorremos la lista
            if (d == p.data.getDest()){ //Si d es igual al destino de p
                return true; //Regresamos verdadero
            }
            p = p.next; //Movemos p un lugar
        }
        return false; //Regresamos falso
    }
    
    //Regresamos el peso de la arista
    public double getEWeight(int s, int d){
        List<Edge> l = this.g[s];
        Node<Edge> p = l.first;
        for(int i=0;i<l.length;i++){ //Recorremos la lista
            if (d == p.data.getDest()){ //Si d es igual al destino de p
                return p.data.getWeight(); //Regresa el peso de p
            }
            p = p.next; //Movemos p un lugar
        }
        return -1.0; //Regresamos -1
    }
    
    //Insertamos una arista
    public void insertE(int s, int d, double w){
        if(!isEdge(s,d)){ //Si no exite la arista
            this.g[s].insertLast(new Edge(d,w)); //INgresamos una arista a la lista
            this.e++; //Aumentamos el tamaño de la lista
        }else{ //Si, si existe la arista
            System.out.println("No es posible insertar el elemento, ("+s+","+d+") ya se encuentra en el grafo"); //Mostramos un mensaje de que ya esta la arista en el grafo
        }
    }
    
    
    public void insertE(int s, int d){
        insertE(s,d,0.0);
    }
    
    public List<Edge> adjacentTo(int s){
        return this.g[s];
    }
    
    public String to_string(){ //Mostrar el grafo como un String
        String r="";
        for (int i=1; i<this.v+1; i++){ //Recorremos todo el vector de vertices
            r += "\nVértice "+ Integer.toString(i) +" "; //Tomamos el vertice y lo hacemos String
            List<Edge> lp = adjacentTo(i); //Obtenemos adyacencias de ese vertice
            if (lp.isEmpty()){ //Si lista de adyacencias esta vacia
                r += "sin Adyacentes.\n\n"; 
            }else{ //Si no esta vacia
                r += "con Adyacentes:\n"; 
                lp.pointer=lp.first; //Usamos puntero auxiliar desde el inicio
                for (int j=1; j<=lp.length; j++){ //Recorremos lista de adyacencias
                    r += lp.pointer.data.toString()+"\n"; //Agregamos al String del vertice, todas las adyacencias
                    lp.pointer=lp.pointer.next; //Recorremos nuestro puntero auxiliar
                }
            }
        }
        System.out.println(r); //Mostramos el grafo
        return r; //Regresamos el grafo en String
    }
    
    public String BFS(int origin){
        visited = new boolean [v+1]; //Matriz que indica los nodos visitados 
        path= "Recorrido BFS\n";
        Queue<Integer> q = new Queue<>();//Cola donde iremos guardando las visitas *ClosedList
        q.enqueue(origin); //Insertamos el primer nodo enviado
        visited[origin]=true; //Indicamos que ya fue visitado
        int aux;
        parent = new int[v+1];
        while (!q.isEmpty()){ //Mientras que la cola no esté vaía
            aux=q.dequeue();
            List<Edge> l = adjacentTo(aux); //obtenemos los adyacentes del nodo visitado y lo sacamos de la cola;
            l.pointer=l.first; //inicializamos el puntero de la lista en la primer posición.
            while(l.pointer!=null){ //Recorremos la lista de adyacencia
                if(!visited[(int)l.pointer.data.getDest()]){ //Preguntamos si ya fue visitado
                //Si no fue visitado, obtenemos el nodo adyacente
                    int a=(int) l.pointer.data.getDest();
                    visited[a]=true;
                    q.enqueue(a);
                    parent[a]=aux;
                }
                l.pointer=l.pointer.next;
            }
        }
        Stack fpath = new Stack(); //Creamos un stack para mostrar la trayectoria desde el arreglo
        fpath.push(v); 
        for(int i=v; i!=1;i=parent[i]){ //Colocaremos en la pila cada elemento, empezando en el final
            fpath.push(parent[i]);
        }while(fpath.getTop()!=null){ //Mientras que la cima no sea nula
            path+=fpath.pop(); //La trayectoria ira guardando cada valor del arreglo
            if(fpath.getTop()!=null){ //Cuando su cima sea nula
                path += "->"; //Agregaremos este simbolo para dar continuidad a la trayectoria
            }
        }
        return path; //Devolvemos la trayectoria
    }
    
    
    public String DFS(int origin){
         //Inicializamos las variables globales
        visited = new boolean [v+1];
        parent = new int[v+1];
        path = Integer.toString(origin)+"->";
        return path=("Recorrido DFS\n" + recursiveDFS(origin) +"\n");
    }
    
    private String recursiveDFS(int origin){
        if (!visited[origin]){ //Si nodo no ha sido visitado
            visited[origin]=true; //Lo marcamos como visitado
            List<Edge> l = adjacentTo(origin); //Obtenemos su lista de adyacencia
            l.pointer=l.first; //Iniciamos el recorrido de la lista
            while(l.pointer!=null){ //Mientras no lleguemos al final de la lista
                int a=(int)l.pointer.data.getDest(); //Obtenemos el adyacente
                parent[a]=origin;
                recursiveDFS(a); //Llamamos al método nuevamente con el adyacente
                l.pointer = l.pointer.next; //nos movemos al siguiente nodo
            }
        }
        if (origin==this.v){
            Stack fpath = new Stack(); //Creamos un stack para mostrar la trayectoria desde el arreglo
            fpath.push(v);
            for(int i=v; parent[i]!=1;i=parent[i]){ //Colocaremos en la pila cada elemento, empezando en el final
                fpath.push(parent[i]);
            } while(fpath.getTop()!=null){ //Mientras que la cima no sea nula
                path+=fpath.pop(); //La trayectoria ira guardando cada valor del arreglo
                if(fpath.getTop()!=null){ //Cuando su cima sea nula
                    path += "->"; //Agregaremos este simbolo para dar continuidad a la trayectoria
                }
            }
        }
        return path; //Devolvemos la trayectoria
    }
}
