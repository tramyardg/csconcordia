package stack.generic_stack;

import java.util.EmptyStackException;

/**
 *
 * @author RAYMARTHINKPAD
 * @param <T>
 */
public class GenericStackV2<T> implements Stack<T> {

    public static final int CAPACITY = 1000;
    private T[] s; 
    private int sz = 0;
    private int top;
    
    public GenericStackV2() {
        this(CAPACITY);
    }
    
    public GenericStackV2(int capacity) {
        s = (T[]) new Object[capacity];
        top = 0;
    }
    
    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }
    
    @Override
    public void push(T e) {
        if(top == s.length) {
            throw new IllegalStateException("Cannot push stack is full.");
        } else {
            sz++;
            s[top] = e;
            top++;  
        }
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            T retValue = s[top - 1];
            s[top - 1] = null;
            top--;
            return retValue;
        }
    }

    @Override
    public T top() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return s[top - 1];
        }
    }
    
}
