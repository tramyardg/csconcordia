package stack.array_stack;

import java.util.EmptyStackException;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class ArrayStack {

    private final int[] s; // the array to hold the stack elements
    private int top;
    private int count;

    // accepts the size of the array
    public ArrayStack(int capacity) {
        s = new int[capacity];
        top = 0;
    }

    public boolean empty() {
        return top == 0;
    }
    
    public int size() {
        return count;
    }

    /**
     *
     * @param n the input to push
     */
    public void push(int n) {
        // first check if the stack is full
        if (top == s.length) {
            throw new EmptyStackException();
        } else {
            s[top] = n; // push the element in top of the stack
            count++;
            top++; // increment the stack after push
        }
    }

    // returns the value at the top of the stack
    public int top() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            // remember top is just apointer, an empty index at top
            // of the stack therefore, the first added element is
            // s[top-1]   
            return s[top - 1];
        }
    }

    // removes (pops a value off the stack) the first element added in the stack
    public int pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            top--; // decrement the stack
            return s[top];  // top becomes the size of the array
        }
    }

}
