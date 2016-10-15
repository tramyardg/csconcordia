package stack.array_stack;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        String str;
        ArrayStack st = new ArrayStack(5);
        str = "Pushing 10 and 20 onto the stack.";
        System.out.println(str);
        st.push(10);
        st.push(20);
        str = "Popping and printing all values";
        System.out.println(str);
        while(!st.empty()) {
            System.out.println(st.pop() + " ");
        }
//        System.out.println(st.peek());
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
