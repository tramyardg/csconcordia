package stack.generic_stack;

/**
 *
 * @author RAYMARTHINKPAD
 * @param <E> type of stack e.g. String, int
 */
public interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E e);
    E pop();
    E top();
}
