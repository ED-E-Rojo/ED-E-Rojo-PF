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
    
    public Node() {
        data=null;
        next=null;
    }
    
    public Node(T d) {
        data=d;
        next=null;
    }
    
    public void print(){
        System.out.println(data+"->");
    }
    
    public void printS(){
        System.out.println(data +"%n"+ "↓"+"%n");
    }
    
}
