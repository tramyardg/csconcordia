package stack.generic_stack;


/**
 *
 * @author RAYMARTHINKPAD
 */
public class GenericStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;
    
    public GenericStack() {
        this(CAPACITY);
    }
    
    public GenericStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) {
        if(size() == data.length) {
            throw new IllegalStateException("Stack is full");
        } else {
            data[++t] = e;
        }
    }
    
    @Override
    public E pop() {
        if(isEmpty()) {
            return null;
        } else {
            E answer = data[t];
            data[t] = null;
            t--;
            return answer;
        }
    }

    @Override
    public E top() {
        if(isEmpty()) {
            return null;
        } else {
            return data[t];
        }
    }
    
}
