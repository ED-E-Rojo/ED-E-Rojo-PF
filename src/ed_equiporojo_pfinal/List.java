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
public class List<T> {
    Node<T> first;
    Node<T> last;
    Node<T> pointer;
    int length;

    public List() {
        first=null;
        last=null;
        pointer=null;
        length=0;
    }
    
    public void insertFirst(T n){
        Node<T> node = new Node(n);
        if (isEmpty()){
            first=last=node;
        } else{
            node.next=last;
            first = node;
        }
        length++;
    }
    
    public void insertLast(T n){
        Node<T> node =new Node(n);
        if (isEmpty()){
            first=last=node;
        } else {
            last.next = node;
            last = node;
        }
        length++;
    }
    
    public void deleteList(){
        first = last= pointer = null;
        length = 0;
    }
    
    public void deleteFirst(){
        if (!isEmpty()){
            if (first==last){
                deleteList();
            } else {
                first=first.next;
                length--;
            }
        } 
    }
    
    public void deleteLast(){
        if (!isEmpty()){
            if (first==last){
                deleteList();
            } else {
                pointer = first;
                while(pointer.next!=last){
                    pointer=pointer.next;
                }
                pointer.next=null;
                last = pointer;
                length--;
            }
        } 
    }
    
    public void deleteNode(T d){
        if(!isEmpty()){
        pointer=first;
        if (pointer.data==d){//Si el elemento buscado es el primero
            deleteFirst();
        }else{
            do{
                if(pointer.next.data==d){//Si el dato del nodo siguiente es el elemento buscado
                    pointer.next=pointer.next.next;
                    length--;
                    pointer=last;
                }else{
                    pointer=pointer.next;
                }
            }while(pointer!=last);
        }
    }
    }
    
    public void showList(){
        if (!isEmpty()){//Si la lista no está vacía
            pointer=first; //Colocamos pointer en el primer nodo
            do{
                pointer.print(); //Imprime el contenido del nodo
                pointer=pointer.next; //Avanza al siguiente nodo
            } while(pointer!=null); //Mientras que pointer no sea NULL
            System.out.println("Null /n");
        }else{
            System.out.println("Lista vacia /n");
        }
    }
    
    public void showListByAddress(){
        if (!isEmpty()){//Si la lista no está vacía
            pointer=first; //Colocamos pointer en el primer nodo
            do{
                System.out.println(pointer+"->"); //Imprime el contenido del nodo
                pointer=pointer.next; //Avanza al siguiente nodo
            } while(pointer!=null); //Mientras que pointer no sea NULL
            System.out.println("Null /n");
        }else{
            System.out.println("Lista vacia /n");
        }
    }
    
    public boolean isEmpty(){
        return length==0;
    }
    
}
