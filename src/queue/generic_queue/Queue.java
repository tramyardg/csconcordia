package queue.generic_queue;

/**
 *
 * @author RAYMARTHINKPAD
 * @param <E>
 */
public interface Queue<E> {
    int size();
    void enqueue(E e);
    E first();
    E dequeue();
    boolean isEmpty();
}
