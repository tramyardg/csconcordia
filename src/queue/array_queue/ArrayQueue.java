package queue.array_queue;

/**
 * Array implementation of queue.
 * @author RAYMARTHINKPAD
 */
public class ArrayQueue {

    private final String[] q;
    private int front;
    private int rear;
    private int size;

    // Constructor
    ArrayQueue(int capacity) {
        q = new String[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public int capacity() {
        return q.length;
    }

    public void enqueue(String s) {
        if (size == q.length) {
            throw new IllegalStateException();
        } else {
            size++;
            // add at the rear
            q[rear] = s;
            // move the rear after adding new element
            rear++;
            // wraps around
            if (rear == q.length) {
                rear = 0;
            }
        }
    }

    public String top() {
        if (empty()) {
            throw new IllegalStateException();
        } else {
            return q[front];
        }
    }

    public String dequeue() {
        if (empty()) {
            throw new IllegalStateException();
        } else {
            size--;
            // get the value first before removing
            String value = q[front];
            q[front] = null;
            front++;
            if (front == q.length) {
                front = 0;
            }
            return value;
        }
    }
}
