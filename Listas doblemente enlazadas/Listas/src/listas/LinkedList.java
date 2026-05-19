/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author USUARIO
 */
public class LinkedList {

    private Node L;//nodo cabecera para acceder a los elementos de la lista
    private Node ultimo; //nodo final para acceder de fin a inicio en la lista doblemente enlazada
        
    public LinkedList(){//constructor crea una lista vacía, en la cual L (cabecera de la lista enlazada) referencia a nulo
	this.L = null;
        this.ultimo = null;
    }
    
    //método para añadir nodos al final
    
    public void AñadirFinal(int valor){
        //verificar si la lista enlazada está vacía.
        // si vacía el nodo se convierte en la cabecera de la lista     
        if (vacia() == true){ //¿la lista está vacía?
          // entonces la cabeza se convierte en el Nodo que encabeza la lista enlazada
          L = new Node(valor); 
          return;
        }        
        Node newNode = new Node(valor); //creamos el nuevo nodo a insertar
        ultimo.setNext(newNode);//recuerda que ptr es el nodoFinalActual y le referencias
        //el nuevo nodo, por lo que a este nuevo nodo se configura su nodo sgte NULO
        newNode.setPrev(ultimo);
        newNode.setNext(null);
        ultimo=newNode;
    }
       
    private boolean vacia(){
        if(L == null) return true;
        else return false;
    }
    
    public void showElements(){
	//Obtener referencia al primer nodo (variable ptr)
        System.out.println("*** Elementos de la lista doblemente enlazada ****");
        System.out.println("[a] Lectura de elementos inicio -> fin");
	Node ptr = L;
	//Mientras existan mas nodos por procesar
	while(ptr != null){
		//Procesamos la informacion del nodo actual: ptr.value()
		System.out.print(ptr.value() + " --> ");
		ptr = ptr.next();//para recorrer el sgte nodo
	}
	             
        System.out.println("\n[b]Letura de elementos fin -> inicio");
        ptr = ultimo;
	//Mientras existan mas nodos por procesar
	while(ptr != null){
		//Procesamos la informacion del nodo actual: ptr.value()
		System.out.print(ptr.value() + " <-- ");
		ptr = ptr.prev();//para recorrer al nodo previo
	}
        System.out.println("\n");
    }        
    public void removeFirst(){//Eliminar nodo inicial
	if(L != null){//Si la lista no esta vacia
		L = L.next(); // L.next es el nuevo nodo inicial
                L.setPrev(null);
	}
        else
            System.out.println("La lista doblemente enlazada está vacía.");
    }
    
    public void removeLast(){//Eliminar nodo final
	if(L != null)
        {
           Node prev = ultimo.prev(); 
           ultimo = prev;
           prev.setNext(null);            
        }
        else
            System.out.println("La lista doblemente enlazada está vacía.");
    }
    
    public void remove(int ref){//Eliminar nodo según su valor
        boolean band = false;
	if(L != null)
        { //Lista no vacia
		if(L.value() == ref)
                { //Si es el primer nodo
			removeFirst();
                        band = true;
		}
                else
                {
                    //el elemento a eliminar puede estar ubicado desde el segundo nodo en adelante
			Node ptr = L.next();//segundo nodo
			//Buscar el nodo con valor ref (ptr) y su predecesor (anterior)
			while(ptr != null && ptr.value() != ref)
                        {
				ptr = ptr.next();
			}
			if(ptr != null)
                        { //Si se encontro el elemento
                            ptr.prev().setNext(ptr.next());
			    ptr.next().setPrev(ptr.prev());
                            band = true;
			}
		}
                if(band == true)
                {
                    System.out.println("Los elementos después de eliminar el nodo ingresado de la lista son:");
                    showElements();
                }
                else
                   System.out.println("El elemento no fue encontrado en la lista");
	}
        else
            System.out.println("La lista doblemente enlazada está vacía.");
    }
    
    public void AñadirInicio(int value){//Añadir el nuevo elemento al inicio de la Lista
	//Creacion de nodo
	Node newNode = new Node(value);
	//Si la lista esta vacia
	if(L == null){
		//Unico elemento, no tiene sucesor
		newNode.setNext(null);
                ultimo = newNode;
	//Si no esta vacia
	}else{
		//El sucesor newNode debe ser el primero de la lista original
		newNode.setNext(L);
                L.setPrev(newNode);
	}
	//El nodo inicial (L) de la lista enlazada ahora debe ser nuevoNodo
	L = newNode;
    }
    
    public void addBefore(int ref, int item)
    {//Insertar antes de un valor
        boolean band = false;
	Node newNode = new Node(item);  
	//ptr: nodo referencia - prev: nodo anterior a "ptr"
	Node ptr = L;
	while(ptr != null && ptr.value() != ref){//Se detiene al encontrar el elemento "ref"
		ptr = ptr.next();
	} //Luego del bucle, "ptr" apunta al nodo de valor "ref" (si existe) 

	if(ptr != null)
        {//Solo si existe el elemento con valor "ref"
		if(ptr.prev() == null)                
                {      //Si el elemento encontrado es el primero
			AñadirInicio(item); //Agregar elemento al inicio
		}
                else
                {   //El nodo anterior (prev) tendra como sucesor al nodo que hemos creado
                    ptr.prev().setNext(newNode);
                    //El nodo siguiente de nuevoNodo debe ser el de valor "ref" (ptr)
                    newNode.setNext(ptr);   
                    newNode.setPrev(ptr.prev());
                    ptr.setPrev(newNode);
		} 
                band = true;
	}  
        if(band == false)
            System.out.println("El elmento no se insertó porque no existe en la lista doblemente enlazada");
        else
            showElements();
    }    
    
    public void InvertirLista()
    {//Se recorre la lista enlazada cambiando las referencias de los nodos    
        Node nodoActual = L, next, prev;  
        if(L == null){
            System.out.println("Lista vacía");      
        }
        else
        {         
            while (nodoActual != null) 
            {
                //El print es para mostrar en pantalla cómo se invierte la lista
                System.out.println("Nodo_actual:"+nodoActual.value());
                next = nodoActual.next();   //1. guarda el siguiente original                
                if(next == null)
                    System.out.println("next = null");
                else
                    System.out.println("next:"+next.value());
                
                prev = nodoActual.prev();  //2. guarda el anterior original
                if(prev == null)
                    System.out.println("prev = null");
                else
                System.out.println("prev:"+prev.value());
                
                // ******3. intercambio de punteros***********
                nodoActual.setNext(prev);//   3.1            
                if(nodoActual.next() == null)
                    System.out.println("nodoActual.setNext:null");
                else
                    System.out.println("nodoActual.setNext:"+nodoActual.next().value());
                
                nodoActual.setPrev(next); //   3.2  
                if(nodoActual.prev() == null)
                    System.out.println("nodoActual.setPrev:null");
                else    
                    System.out.println("nodoActual.setPrev:"+nodoActual.prev().value());
                
                nodoActual = next; //3.3 avanza usando el "siguiente" original
                if(nodoActual == null)
                    System.out.println("nodoActual = next:null");
                else    
                    System.out.println("nodoActual = next:"+nodoActual.value());
               
            } 
            Node oldHead = L;
            L = ultimo;
            ultimo = oldHead;     
       }        
    }
    
       

   
}
