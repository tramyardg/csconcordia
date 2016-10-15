package queue.generic_queue;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class GenericQueue<E> implements Queue<E> {
    public static int CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int sz = 0;
    
    public GenericQueue() {
        this(CAPACITY);
    }
    
    public GenericQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public int size() {
        return sz;
    }

    @Override
    public void enqueue(E e) {
        if(sz == data.length){
            throw new IllegalStateException("Queue is full!");
        } else {
            int avail = (front + sz) % data.length;
            data[avail] = e;
            sz++;
        }
    }

    @Override
    public E first() {
        if(isEmpty()) {
            return null;
        } 
        return data[front];
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            return null;
        } 
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        sz--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return sz == 0;
    }
}
