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
    
    public Queue(){
        front = rear = null;
        size = 0;
    }
    
    public Queue(T d){
        Node<T> node = new Node(d);
        front = rear = node;
        size = 0;
    }
    
    public void enqueue(T d){
        Node node = new Node(d);
        if(isEmpty()){
            front=rear=node;
            size=1;
        }else{
            rear.next=node;
            rear=node;
            size++;
        }
    }
    public T dequeue(){
        if (isEmpty()){
            return null;
        }else{
            Node<T> fd = front;
            front=front.next;
            size--;
            return fd.data;
        }
    }
   
    public T getFront(){
        if (isEmpty()){
        return null;
        }else{
            return front.data;
        }
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public void clearQueue(){
        front=rear=null;
        size=0;
    }
    
    public void showQueue(){
        System.out.println("front->");
        Node<T> p = front;
        if (p==null) System.out.println("null");
        while(p!=null){
            p.print();
            p=p.next;
        }
        System.out.println("<-rear" + "/n");
    }
    
}
