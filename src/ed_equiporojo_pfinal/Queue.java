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
public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    //Constructor por defecto
    public Queue(){
        front = rear = null;
        size = 0;
    }
    
    //Constructor con primer elemento
    public Queue(T d){
        Node<T> node = new Node(d);
        front = rear = node;
        size = 1;
    }
    
    //Inserta un nuevo nodo al final de la fila
    public void enqueue(T d){
        Node node = new Node(d);
        if(isEmpty()){ //Si esta vacio
            front=rear=node; //Los apuntadores front y rear apuntan al nuevo nodo
            size=1; //El tamaño de la fila se vuelve 1
        }else{ //Si no esta vacia
            rear.next=node; //El apuntador next de rear señalara al nuevo nodo
            rear=node; //Rear se recorre y apunta al nuevo nodo
            size++; //Se incrementa el tamaño de la pila
        }
    }
    
    //Elimina el primer valor de la fila
    public T dequeue(){
        if (isEmpty()){ //Si esta vacio
            return null // regresamos nulo
        }else{ // Si no esta vacio
            Node<T> fd = front;
            front=front.next; //recorremos front
            size--; //Se reduce el tamaño de la pila
            return fd.data; //Regresamos el dato de front
        }
    }
   
    //Devuelve el valor del frente de la fila
    public T getFront(){
        if (isEmpty()){ //Si esta vacio
        return null; //Regresamos nulo
        }else{ // Si no esta vacio
            return front.data; //Regresamos el valor de front
        }
    }
    
    //Devuelve el tamaño de la fila
    public int getSize(){
        return size;
    }
    
    //Está vacía?
    public boolean isEmpty(){
        return size==0;
    }
    
    //Vaciar fila
    public void clearQueue(){
        front=rear=null; //Apuntamos front y rear a nulo
        size=0; //El tamaño de la pila se vuelve 0
    }
    
    //Muestra el contenido de la fila
    public void showQueue(){
        System.out.println("front->");
        Node<T> p = front;
        if (p==null) System.out.println("null"); //Si p es nulo imprimimos nuelo
        while(p!=null){ //Mientras que p sea nulo
            p.print(); //Imprimimos p
            p=p.next; //Movemos p un lugar
        }
        System.out.println("<-rear" + "/n");
    }
    
}
