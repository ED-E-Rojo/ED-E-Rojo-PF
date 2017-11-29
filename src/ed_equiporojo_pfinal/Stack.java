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

public class Stack<T> {
    private Node<T> top;
    private int size;
    
    //Constructor por defecto
    public Stack(){
        top = null;
        size = 0;
    }
    
    //Constructor con primer elemento
    public Stack(T d){
        Node<T> node = new Node<T>(d);
        top=node; 
        size=1;
    }
    
    //Devuelve el tamaño de la pila
    public int getSize(){
        return size;
    }
    
    //Inserta un nuevo nodo en la cima de la pila
    public void push(T d){
        Node<T> node = new Node<T>(d);
        node.next=top; //El apuntador next de node es igual a top
        top=node; // Top ahora apunta a nodo
        size++; // Se incrementa el tamaño de la pila
    }
    
    //Elimina un valor de la cima de la pila y lo devuelve.
    public T pop(){
         T d;
        if (!isEmpty()){ //Si no esta vacia
            d = top.data; //Guardamos el valor de top en d
            top=top.next; //Movemos el apuntador de top
            size--; //Se reduce el tamaño de la fila
            return d; // Regresamos el anterior dato de top
        }else{ //Si esta vacia
            return null; //regresa nulo
        }
    }
    
    //Devuelve el valor de la cima
    public T getTop(){
         if (!isEmpty()){ //Si no esta vacio
            return top.data;} //Regresasoms el valor de top
        else{ //Si esta vacio
            return null; //NO regresamos nada
        }
    }
    
    //Muestra el contenido de la pil
    public void showStack(){
        Node<T> t = top;
        while (t!=null){ //Mientras que t sea null
            t.printS(); //imprimimos t
            t=t.next; // t se mueve 
        }
        System.out.println("Null"+"/n");
    }
    
    //Está vacía?
    public boolean isEmpty(){
        return size==0;
    }
    
    //Vaciar Pila
    public void deleteStack(){
        top=null; //top ahora apunta a nulo
        size=0; // El tamaño de la pila se vuelve 0
    }
    
}
