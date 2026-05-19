/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazadacircular;

/**
 *
 * @author USUARIO
 */
public class ListaEnlazadaCircular {

    private Node L;//nodo cabecera para acceder a los elementos de la lista
          
    public ListaEnlazadaCircular(){//constructor crea una lista vacía, en la cual L (cabecera de la lista enlazada) referencia a nulo
	this.L = null;
    }
    
    public void AñadirInicio(int value)
    {//Añadir el nuevo elemento al inicio de la Lista
	//Creacion de nodo
	Node newNode = new Node(value);
	//Si la lista esta vacia
	if(L == null)
        {
		//Unico elemento, no tiene sucesor
                L = newNode;
		newNode.setNext(L);   
	}
        else//Si no esta vacia
        {		
                //El nodo final debe apuntar al nuevo nodo
                Node ptr = L;//la cabeza inicial
                while(ptr.next()!= L)
                {
                    ptr = ptr.next();
                }
                //El sucesor de newNode debe ser el primero de la lista original
		newNode.setNext(L);
                L = newNode;
                //el ultimo nodo de la lista circular apunta al primer nodo
                ptr.setNext(newNode);                
	}
    }    
    
    public void AñadirFinal(int valor){
        //verificar si la lista enlazada está vacía.
        // si vacía el nodo se convierte en la cabecera de la lista
        Node newNode = new Node(valor); //creamos el nuevo nodo a insertar
        if (vacia() == true){ //¿la lista está vacía?
          // entonces la cabeza se convierte en el Nodo que encabeza la lista enlazada
          L = newNode; 
          newNode.setNext(L);
          return;
        }
        //insertamos el nuevo nodo al final de la lista y lo enlazamos con el primero
        Node ptr = L;
        while(ptr.next()!= L)
        {
            ptr = ptr.next();
        }
        //ptr es el nodo final
        ptr.setNext(newNode);
       newNode.setNext(L);
    }
    
    public void showElements()
    {
	//Obtener referencia al primer nodo (variable ptr)
	Node ptr = L;
        if(vacia())
        {
            System.out.println("Lista enlazada circular vacía");
            return;
        }            
	//Mientras existan mas nodos por procesar
	while(ptr.next() != L)
        {
		//Procesamos la informacion del nodo actual: ptr.value()
		System.out.print(ptr.value() + " --> ");
		ptr = ptr.next();//para recorrer el sgte nodo
	}
	//El ultimo nodo no tendra null como siguiente!!!!!
	System.out.println(ptr.value()+" --> *"+ptr.next().value());
    }     
    
    public void addBefore(int ref, int item)
    {//Insertar antes de un nodo
        boolean band = false;
	Node newNode = new Node(item);  
	//ptr: nodo referencia - prev: nodo anterior a "ptr"
	Node ptr = L, prev = null;
	while(ptr.next() != L)
        {//Se detiene al encontrar el elemento "ref"
            if(ptr.value() == ref)
            {
                band = true;
                break;
            }            
	    prev = ptr; //Antes de "avanzar" dejo una referencia al elemento anterior
	    ptr = ptr.next();
	} //Luego del bucle, "ptr" apunta al nodo de valor "ref" (si existe) 
           
        //comparo el penultimo con el ref
        if(ptr.value() == ref)
            band = true;
        
        if(band == true)
        {//Solo si existe el elemento con valor "ref"
		if(prev == null){//Si el elemento encontrado es el primero
			AñadirInicio(item); //Agregar elemento al inicio
		}
                else
                {
			//El nodo anterior (prev) tendra como sucesor al nodo que hemos creado
			prev.setNext(newNode);
			//El nodo siguiente de nuevoNodo debe ser el de valor "ref" (ptr)
			newNode.setNext(ptr);
                        
		}  
                System.out.println("Los elementos de la lista enlazada circular son:");
                showElements();
	}  
        else
            System.out.println("El elemento a buscar no existe en la lista enlazada circular");
    }    
       
    public void removeFirst()
    {//Eliminar nodo inicial
	if(L != null)
        {//Si la lista no esta vacia
		L = L.next(); // L.next es el nuevo nodo inicial
                //se actualiza el ultimo nodo y se conecta con el nuevo L
                Node ptr = L;
                while(ptr.next()!= L)
                {
                    ptr = ptr.next();
                }
                ptr.setNext(L);
	}
    }
    
    
    private boolean vacia(){
        if(L == null) return true;
        else return false;
    }
               
    
    public void removeLast(){//Eliminar nodo final
	Node ptr = L;
	Node prev = null;
	if(vacia())
        {
            System.out.println("Lista vacía");
            return;
        }
         //Lista no vacia
        if(ptr.next()==L)//Si la lista tiene solo un elemento
                L = null; 
        else
        {
            while(ptr.next() != L)
            { //para encontrar el ultimo elemento
                    prev = ptr;
                    ptr = ptr.next();
            }// Al salir del bucle: ptr - ultimo nodo, prev - penultimo nodo
            //penultimo nodo ahora sera el ultimo
            prev.setNext(L);
        }           
    }
    
    public void remove(int ref)
    {//Eliminar nodo según su valor
        boolean bandera = false;
	if(L != null)
        { //Lista no vacia
		if(L.value() == ref)
                { //Si es el primer nodo
			removeFirst();
                        bandera = true;
		}
                else
                {                        
			Node ptr = L.next();//el valor del nodo a eliminar se encuentra del segundo nodo en adelante
			Node prev = L;
			//Buscar el nodo con valor ref (ptr) y su predecesor (anterior)
			while(ptr.next() != L)
                        {
                            if(ptr.value() == ref)
                            {
                                bandera = true;
                                break;
                            }
                            prev = ptr;
                            ptr = ptr.next();
			}                        
			if(ptr.value() == ref) //Si se encontro el elemento y lo tiene ptr
                        {   
                            bandera = true;                        
                            prev.setNext(ptr.next());  
                        }
		}
                if(bandera == true)
                {		
                    System.out.println("Los elementos después de eliminar el nodo ingresado de la lista son:");
                    showElements();
                }
                else
                    System.out.println("El elemento buscado no se encontró");
	}
        else
            System.out.println("La liista enlazada circular está vacía");
    }
    
        
   public void DividirLista(int valor)
   {
        //Creacion de nodo
        ListaEnlazadaCircular newList = new ListaEnlazadaCircular();
        ListaEnlazadaCircular newList2 = new ListaEnlazadaCircular();
        Node ptr = L;
        boolean band = false;
        
        while(ptr.next()!= L)
        {
            if (band == false && ptr.value() != valor){
                newList.AñadirFinal(ptr.value());                   
            } 
            else{
                 newList2.AñadirFinal(ptr.value()); 
                 band = true;
            }
            ptr = ptr.next();
        }  
        //añadimos el nodo final
        newList2.AñadirFinal(ptr.value());
        
        System.out.println("La lista dividida a partir del número: "+ valor);
        
        System.out.println("La lista1 es:");
        newList.showElements();
        
        System.out.println("La lista2 es:");
        newList2.showElements();
    }
}
