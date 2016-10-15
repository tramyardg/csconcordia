package stack.linked_stack;

import java.util.EmptyStackException;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class LinkedStringStack {
    private class Node {
        String value;
        Node next;
        
        /**
         * 
         * @param val the value to push
         * @param n points to the top
         */
        Node(String val, Node n) {
            value = val;
            next = n;   
        }
    }
	
    private Node top = null;
    private int count;
	
    /**
     * checks for an empty stacks
     * @return 
     */
    public boolean empty() {
        return top == null;
    }
    
    public int size() {
        return count;
    }
    
    /**
     * Adds new item to the stack
     * @param s the value to be pushed onto the stack
     */
    public void push(String s) {
        top = new Node(s, top);
        count++;
    }
    
    /**
     * Removes the value at the top of the stack
     * @return 
     */
    public String pop() {
        if(empty()) {
            throw new EmptyStackException();
        } else {
            // get the value after top
            String retValue = top.value;
            // move the top
            top = top.next;
            return retValue;
        }
    }
    
    public String peek() {
        if(empty()) {
            throw new EmptyStackException();
        } else {
            return top.value;
        }
    }

}
