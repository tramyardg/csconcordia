package stack.linked_stack;

import java.util.EmptyStackException;

/**
 * Linked integer stack with constructor. 
 * With node constructor.
 * @author RAYMARTHINKPAD
 */
public class LinkedIntegerStack {
    private class Node {
        int item;
        Node next;
        
        Node(int i, Node n) {
            item = i;
            next = n;
        }
    }
    
    private Node top = null;
    private int numSize;
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public int size() {
        return numSize;
    }
    
    public void push(int i) {
        top = new Node(i, top);
        numSize++;
    }
    
    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            int retValue = top.item;
            top = top.next;
            return retValue;
        }
    }
    
    public int top() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.item;
        }
    }
            
}


