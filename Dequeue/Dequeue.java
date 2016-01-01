import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Dequeue is a special kind of a Queue where additions and deletions can be done at both ends.
 * This class implements Dequeue using a circular array.
 *
 * @author Sudarshan
 */

public class Dequeue<E> {

    int rear,front;
    private E elements[];
    private static final int DEFAULT_CAPACITY = 5;

    /**
     * Creates an empty Queue
     */
    // Complexity O(1)
    public Dequeue () {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
    }

    /**
     * Add an item to the front of the queue
     * @return boolean - true if the operation was successful
     * @param data - the item to be added to the front of the queue
     */
    //Complexity: Worst Case: O(n) , on average performance would be O(1)
    public boolean addFront(E data) {
        if(notEmpty())
            reallocate();

        if (front - 1 < 0)                         //if front is in position 0, front is set to the last array position;
            front = elements.length - 1;          // I have to do this because Java computes -1 % some integer wrongly.
        else
            front = (front - 1) % elements.length;

        elements[front] = data;
        return true;
    }

    /**
     * Returns the object at the front of the queue without removing it from the queue
     * @return the object at the front of the queue
     */
    //Complexity O(1)
    public E peekFront() {
        E data = elements[front];
        return data;
    }

    /**
     * Removes the object at the front of the queue
     * @return the front item of the queue
     */
    //Complexity O(1)
    public E removeFront() {

        E data = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        return data;
    }

    /**
     * Adds an item to the rear of the queue
     * @return boolean - true if the operation was successful
     * @param data - the item to be added to the rear of the queue
     */
    //Complexity: Worst Case: O(n) , on average performance would be O(1)
    public boolean addRear(E data) {
        if(notEmpty())
            reallocate();
        rear = (rear + 1) % elements.length;
        elements[rear] = data;
        return true;
    }

    /**
     * Returns the object at the rear of the queue without removing it from the queue
     * @return the object at the rar of the queue
     */
    //Complexity O(1)
    public E peekRear() {
        E data = elements[rear];
        return data;
    }

    /**
     * Removes the object at the rear of the queue
     * @return the rear item of the queue
     */
    //Complexity O(1)
    public E removeRear() {
        E data = elements[rear];
        elements[rear] = null;

        int i = rear -1;
        if (i < 0)
            rear = elements.length - 1;
        else
            rear = (rear - 1) % elements.length;
        return data;
    }

    /**
     * Tells us whether the queue has any empty space left or not
     * @return boolean - true if the queue has no empty spaces left
     */
    //Complexity O(1)
    public boolean notEmpty() {

        return (front == (rear + 1) % elements.length) && (elements[0] != null);
    }

    /**
     * Returns the current number of items in the array
     * @return the number of items in the array
     */
    //Complexity O(1)
    public int size() {
        int size;

        if (elements[rear] ==  null && elements[front] == null)
            size = 0;
        else if (rear >= front)
            size = (rear + 1) - front;
        else
            size = (elements.length - front) + (rear + 1);

        return size;
    }

    /**
     * Add more space to the array.
     * @return the new array with more space
     */
    //Complexity O(n)
    private E[] reallocate() {
        int currentCapacity = elements.length;
        int newCapacity = currentCapacity * 2;
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < currentCapacity; i++)
            newData[i] = elements[(front + i) % currentCapacity];

        front = 0;
        rear = currentCapacity - 1;
        elements = newData;
        return elements;
    }

    /**
     *Returns a list-iterator of the elements in this list
     * (in proper sequence), starting at the beginning
     * of the list.
     * @return iterator for this list
     */
    public Iterator<E> iterator() {
        return new myIterator ();
    }


    /**
     * private inner class to implement the Iterator<E> interface
     **/
    private class myIterator implements Iterator <E> {
        private int index;
        private int elementsAccessed = 0;

        /**
         * Initializes the myIterator object to reference the
         * first queue element
         */
        public myIterator() {
            index = front;
        }

        /**
         * Returns true if there are more elements in the queue
         * to access
         */
        @Override
        public boolean hasNext() {
            return (elementsAccessed <= size());
        }

        /** Returns the next element in the queue
         *  pre: index references the next element to access
         *  post: index and elementsAccessed are incremented
         *  @return The element with subscript index
         */
        @Override
        public E next() {
            if (!hasNext() )
                throw new NoSuchElementException();
            E returnValue = elements[index];
            index = (index + 1) % elements.length;
            ++elementsAccessed;
            return returnValue;
        }

    }

}