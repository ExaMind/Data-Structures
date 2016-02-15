import java.util.NoSuchElementException;

/**
 * This is a singly linked data structure. It has a constant time insertion at the first spot in the list.
 * @author Sudarshan
 * @param <E>
 *
 */
public class SinglyLinkedList<E> {
	
	 private Node<E> head;
     
     /** Constructs an empty list */
     // Complexity O(1)
     public SinglyLinkedList() {
         head = null;
     }
     
     /** Inserts the specified element at the beginning of this list
      *  @param dataItem the element to add
      */
     // Complexity O(1)
     public void addFirst(E dataItem) {
 
         head = new Node<E>(dataItem, head);
 
     }
     
     
     /**
      * Inserts the specified element at the end of the list.
      * @param dataItem to add
      */
     //Complexity O(n)
     public void addLast(E dataItem) {
         if(isEmpty()) {
             head = new Node<E>(dataItem, head);
         } else {
             Node<E> temp = head;
             while(temp.next != null) {
                 temp = temp.next;
             }
             
             temp.next = new Node<E>(dataItem);
         }
     }
 
 
     /**
      * Checks to see if the linkedList is empty.
      * @return boolean - either true or false depending on the
      */
     // Complexity O(1)
     public boolean isEmpty() {
         return head==null;
     }
 
  
     /**
      * Returns the data field of the first node
      * @return E - whatever is in the data field of the first node
      */
     // Complexity O(1)
     public E getFirst(){
         if(isEmpty()) {
             throw new NoSuchElementException();
         } else {
             return head.data;
         }
     }
     
     /**
      * Returns the data field of the last node
      * @return E - Whatever is in the data field of the last node
      */
     // Complexity O(n)
     public E getLast() {
         if(isEmpty()) {
             throw new NoSuchElementException();
         }else {
             Node<E> temp = head;
             while(temp.next != null) {
                 temp = temp.next;
             }
             
             return temp.data;
         }
     }
     
     /**
      * Removes the first node of the LinkedList and returns a reference to it.
      * @return E - the removed item.
      */
     //Complexity O(1)
     public Node<E> removeFirst() {
    	 
    	Node<E> temp;
    	
         if(isEmpty()) {
             throw new NoSuchElementException();
         } else {
             temp = head;
             head = head.next;
         }

		return temp;
     }
     
     /**
      * Removes the last node of the linkedList and returns a reference to it.
      * @return E - the removed item
      */
     // Complexity O(n)
     public E removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}else if (size() == 1) {
			E lastData = head.data;
			head = null;
			return lastData;
			
		} else {
			Node<E> temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			E lastData = temp.next.data;
			temp.next = null;
			return lastData;
		}
		
	}
	
     /**
      * Returns the length of the linked list.
      * @return length of the linked list.
      */
     // Complexity O(n)
		public int size() {

			Node<E> temp;
			int size = 1;
			
			if(head == null)      //If the head points to null, then the list must be 0 (empty);
				return 0;         
			else if(head.next == null) // If head.next is null then, there is only one item in the list.
				return 1;
			else {
				temp = head;
				
				while(temp.next != null){ // I keep incrementing the size until I find an element whose next field is null.
					temp = temp.next;
					size++;
				}
			}
			return size;
		}

	
	/**
	 * Removes node of specific index
	 * @return E - returns the data of the removed node
	 */
	public E removeAtIndex(int index) {
		
		Node<E> temp = head;
		E data;
		int count = 1;
		
		if(index == 1){         //The index of the list starts at 1
			data = head.data;
			head = head.next;
			return temp.data;
		} else {
			
			while(count != index-1) {
				temp = temp.next;
				count++;
			}
			data = temp.next.data;
			temp.next = temp.next.next;
		}
		
		return data;
	}
	
	
	
	/**
	 * Returns the data of the element at the specified index.
	 */
	public E get(int index) {
		
		E data;
		int count = 1;
		Node<E> temp = head;
		
		if(index == 0)     //If the user asks for the element at index 0, an exception would be thrown since the index of a 
			throw new NoSuchElementException("The index of the list starts at 1 not 0"); // singly linked list starts at 1.
		
		if(index == 1) {
			data = head.data;
		}else {
			
			while(count != index){        //I'll keep increasing the value of count until I find the index I'm looking for.
				temp = temp.next;
				count++;
			}
			data = temp.data;
		}
		
		
		return data;
	}
		
	/**
	 * 	
	 * @author sudarshan
	 *
	 * @param <E>
	 */
	 private static class Node <E> {
		 private E data;
		 private Node<E> next;
	
		 /** constructor
	      	@param dataItem - item to be inserted
		  */
		 private Node(E dataItem) {
			 data= dataItem;
			 next = null;
		 }
	
		 /** creates a new node that references another node
	      	@param dataItem The data stored
	      	@param aNode The node referenced by new node
		  */
		 private Node(E dataItem, Node<E> nodeRef) {
			 data = dataItem;
			 next = nodeRef;
		 }
	
	 }
 

}
