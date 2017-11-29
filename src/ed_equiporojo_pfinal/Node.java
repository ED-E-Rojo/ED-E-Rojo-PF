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
public class Node<T> {
    Node next;
    T data;
    
    //Constructor por defecto
    public Node() {
        data=null;
        next=null;
    }
    
    //Consturctor con un elemento
    public Node(T d) {
        data=d; //agregamos :data(d) para indicar que utilizaremos el constructor default del t de dato que asignemos
        next=null;
    }
    
    //Imprimir Nodo
    public void print(){
        System.out.println(data+"->");
    }
    
    //Imprimir Nodo para stack
    public void printS(){
        System.out.println(data +"%n"+ "↓"+"%n");
    }
    
}
