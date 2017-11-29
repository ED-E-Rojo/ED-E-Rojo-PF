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
    
    //Devuelve el tamaño de la pila
    public void push(T d){
        Node<T> node = new Node<T>(d);
        node.next=top;
        top=node;
        size++;
    }
    
    //Elimina un valor de la cima de la pila y lo devuelve.
    public T pop(){
         T d;
        if (!isEmpty()){
            d = top.data;
            top=top.next;
            size--;
            return d;
        }else{
            return null;
        }
    }
    
    //Devuelve el valor de la cima
    public T getTop(){
         if (!isEmpty()){
            return top.data;}
        else{
            return null;
        }
    }
    
    //Muestra el contenido de la pil
    public void showStack(){
        Node<T> t = top;
        while (t!=null){
            t.printS();
            t=t.next;
        }
        System.out.println("Null"+"/n");
    }
    
    //Está vacía?
    public boolean isEmpty(){
        return size==0;
    }
    
    //Vaciar Pila
    public void deleteStack(){
        top=null;
        size=0;
    }
    
}
