import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.ArrayList;


public class DequeueTest {

    Dequeue<Student> q;

    Student s1, s2, s3, s4, s5, s6, s7, s8;


    @Before
    public void setUp() throws Exception {

        q = new Dequeue<Student> ();

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
    public void testaddFrontAddRear() {

        q.addFront(s1);
        q.addFront(s2);
        q.addFront(s3);
        assertEquals(s3, q.peekFront());
        q.addRear(s4);
        q.addRear(s5);
        q.addFront(s6);
        q.addRear(s7);
        assertEquals(s7, q.peekRear());
        assertEquals("Size should be 7", 7, q.size());

    }


    @Test
    public void testRemoveFrontRemoveRear() {

        q.addFront(s1);
        q.addFront(s2);
        q.addFront(s3);
        q.addRear(s4);
        q.addRear(s5);
        q.addFront(s6);
        q.addRear(s7);
        assertEquals(7, q.size());
        assertEquals(s6, q.removeFront());
        assertEquals(6, q.size());
        assertEquals(s7, q.removeRear());
        assertEquals(5, q.size());
        assertEquals(s3, q.removeFront() );
        assertEquals("Now size should be 4", 4, q.size());
        assertEquals(s5, q.removeRear());
        assertEquals(s2, q.removeFront());
        assertEquals("Now size should be 2", 2, q.size());
        assertEquals(s1, q.removeFront());
        assertEquals(s4, q.removeRear());
        assertTrue(!q.notEmpty());
        assertTrue(q.size() == 0);

    }


    @Test
    public void testIterator() {

        q.addFront(s1);
        q.addFront(s2);
        q.addFront(s3);
        q.addRear(s4);
        assertEquals(4, q.size() );
        q.addRear(s5);
        q.addFront(s6);
        q.addRear(s7);
        assertEquals(7, q.size() );

        Iterator <Student> iter = q.iterator();

        ArrayList<Student> list = new ArrayList<Student>();

        while (iter.hasNext()) {

            list.add(iter.next() );

        }

        assertEquals(s6, list.get(0));
        assertEquals(s3, list.get(1));
        assertEquals(s2, list.get(2));
        assertEquals(s1, list.get(3));
        assertEquals(s4, list.get(4));
        assertEquals(s5, list.get(5));
        assertEquals(s7, list.get(6));

    }

}


