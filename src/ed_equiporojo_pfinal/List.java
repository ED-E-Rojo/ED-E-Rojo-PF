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

    //Constructor
    public List() {
        first=null;
        last=null;
        pointer=null;
        length=0;
    }
    
    //Insertar al inicio
    public void insertFirst(T n){
        Node<T> node = new Node(n);
        if (isEmpty()){ //Si la lista está vacía
            first=last=node; //Apuntadores last y first apuntan a Nodo
        } else{ //Si la lista tiene elementos
            node.next=last; //Apuntador next del nuevo nodo apunta al primer nodo
            first = node; //Apuntador first apunta al nuevo nodo
        }
        length++; //Incrementamos el contador de nodos
    }
    
    //Insertar al final
    public void insertLast(T n){
        Node<T> node =new Node(n);
        if (isEmpty()){ //Si la lista está vacía
            first=last=node; //Apuntadores last y first apuntan a Nodo
        } else { //Si la lista tiene elementos
            last.next = node;  //El apuntador next del último nodo apunta al nuevo nodo
            last = node; // El apuntador last apunta al nuevo nodo
        } 
        length++; //Incrementamos el contador de nodos;
    }
    
    //Eliminar la lista
    public void deleteList(){ 
        first = last= pointer = null;
        length = 0;
    }
    
    //Eliminar el primer nado
    public void deleteFirst(){
        if (!isEmpty()){ //Si la lista no está vacía
            if (first==last){ //Si la lista tiene solo un elemento
                deleteList();
            } else { //Lista tiene mas de un elemento
                first=first.next; //El apuntador first  apunta a su siguente nodo 
                length--; //Decrementamos el contador de nodos;
            }
        } 
    }
    
    public void deleteLast(){
        if (!isEmpty()){ //Si la lista no está vacía
            if (first==last){ //Si la lista tiene solo un elemento
                deleteList();
            } else {
                pointer = first; //pointer apunta al primer nodo
                while(pointer.next!=last){ //Mientras que el nodo siugiente de pointer sea diferente al último
                    pointer=pointer.next; //avanzamos pointer a la siguiente posición
                }
                pointer.next=null; //el epuntador next de pinter apunta a null
                last = pointer; // el apuntador last ahora apunta a pointer
                length--; //Decrementamos el contador de nodos;
            }
        } 
    }
    
    //Eliminar un nodo
    public void deleteNode(T d){
        if(!isEmpty()){ //Si la lista no está vacía
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
    
    //Mostrar lista
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
