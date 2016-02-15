import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SinglyLinkedListTest {

	SinglyLinkedList<Student> list;

    Student s1, s2, s3, s4, s5, s6, s7, s8;


    @Before
    public void setUp() throws Exception {

        list = new SinglyLinkedList<Student> ();

        s1 = new Student("John", "Doe");
        s2 = new Student ("Jane", "Smith");
        s3 = new Student ("Bob", "Taylor");
        s4 = new Student ("Anne", "Frank");
        s5 = new Student("Frank", "Gauvin");
        s6 = new Student("Kevin", "Austin");
        s7 = new Student ("Cindy", "Bryant");
        s8 = new Student ("Peter", "Lander");

    }
    
    @Test
    public void testAddFirst() {
    	
    	list.addFirst(s1);
    	list.addFirst(s2);
    	list.addFirst(s3);
    	list.addLast(s8);
    	list.addFirst(s4);
    	
    	assertEquals(s4, list.getFirst());
    }
    
    @Test
    public void testAddLast() {
    	
    	list.addLast(s1);
    	list.addLast(s2);
    	list.addLast(s3);
    	list.addLast(s8);
    	list.addFirst(s4);
    	
    	assertEquals(s8, list.getLast());
    }
    
    @Test
    public void testRemoveFirst() {
    	
    	list.addFirst(s1);
    	list.addFirst(s2);        //This is the first element after two removeFirst() operations.
    	list.addFirst(s3);
    	list.addLast(s8);
    	list.addFirst(s4);        //This is the first element.
    	list.addLast(s6);
    	list.addLast(s7);
    	list.addLast(s5);
    	
    	list.removeFirst();
    	list.removeFirst();
    	
    	assertEquals(s2, list.getFirst());
    	assertEquals(s5, list.getLast());
    	
    }
    
    @Test
    public void testRemoveLast() {
    	
    	list.addFirst(s1);
    	list.addFirst(s2);        
    	list.addFirst(s3);
    	list.addLast(s8);
    	list.addFirst(s4);        //This is the first element.
    	list.addLast(s6);			//This is the first element after two removeLast() operations.
    	list.addLast(s7);
    	list.addLast(s5);
    	
    	list.removeLast();
    	list.removeLast();
    	
    	assertEquals(s4, list.getFirst());
    	assertEquals(s6, list.getLast());
    }
    
    @Test
    public void testRemoveAtIndex() {
    	
    	list.addFirst(s1);
    	list.addFirst(s2);        
    	list.addFirst(s3);
    	list.addLast(s8);
    	list.addFirst(s4);        //This is the first element.
    	list.addLast(s6);		
    	list.addLast(s7);
    	list.addLast(s5);
    	
    	list.removeAtIndex(3);
    	
    	assertEquals(s1, list.get(3));
    	
    }
    
    
    
    @Test
    public void testSize() {
    	
    	list.addLast(s1);
    	list.addLast(s2);
    	list.addLast(s3);
    	list.addLast(s8);
    	list.addFirst(s4);
    	
    	assertEquals(5, list.size());
    	
    }

}
