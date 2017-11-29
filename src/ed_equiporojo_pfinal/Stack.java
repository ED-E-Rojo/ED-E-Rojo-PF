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
    
    public Stack(){
        top = null;
        size = 0;
    }
    
    public Stack(T d){
        Node<T> node = new Node<T>(d);
        top=node;
        size=1;
    }
    
    public int getSize(){
        return size;
    }
    
    public void push(T d){
        Node<T> node = new Node<T>(d);
        node.next=top;
        top=node;
        size++;
    }
    
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
    
    public T getTop(){
         if (!isEmpty()){
            return top.data;}
        else{
            return null;
        }
    }
    
    public void showStack(){
        Node<T> t = top;
        while (t!=null){
            t.printS();
            t=t.next;
        }
        System.out.println("Null"+"/n");
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public void deleteStack(){
        top=null;
        size=0;
    }
    
}
