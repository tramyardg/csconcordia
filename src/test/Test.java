package test;

import java.util.Arrays;
import stack.generic_stack.Stack;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Test {

    public static void main(String[] args) {
        int x = 2;
        int n = 13;
//        System.out.println(powerRecursion2(x, n));
        int[] arr1 = {2,4,6};
        int[] arr2 = {-2,8,6};
        System.out.println(isEqualElem(arr1, arr2));
    }
    
    public static boolean isEqualElem(int[] list1, int[] list2)
    {
        Arrays.sort(list1);
        Arrays.sort(list2);
        if(list1.length != list2.length) {
            return false;
        }
        int diff = 0;
        for(int i = 0; i < list1.length; i ++) {
            diff += (list1[i]-list2[i]);
        }
        System.out.println(diff);
        return diff == 0;
    }

    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j <= i; j++) {
                System.out.println(" index: j> " + j);

//                total += x[j];
                
            }
            a[i] = total / (i + 1);
        }
        return a;
    }

    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double total = 0;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            total += x[i];
            a[i] = total / (i + 1);
        }
        return a;
    }

    public static void reverseArrayRecursion(int[] A, int i, int j) { // tail recursion
        if (i < j) {
            int temp = A[i];    // storing values of i
            A[i] = A[j];
            A[j] = temp;
            reverseArrayRecursion(A, i + 1, j - 1);
        }
    }

    // remember this is a void method
    public static void reverseArrayRecursion2(int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low]; // cannot A[j] = A[i] since the value of A[i] has changed when you do this
            data[low] = data[high];
            data[high] = temp;
            reverseArrayRecursion2(data, low + 1, high - 1); // increment low and decrement high so that they meet and finish 
        }
    }

    public static void reverseArrayIteration(int[] data, int low, int high) {
        // you need to define low and high when
        // using iterative methods
        low = 0;
        high = data.length - 1;
        while (low <= high) {
            int temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }

    public static void reverseArrayIteration2(int[] data, int low, int high) {
        low = 0;
        high = data.length - 1;
        while (low <= high) {
            int temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }

    public static boolean binarySearchRecursion(int[] data, int target, int low, int high) {
        boolean cond = false;
        if (low > high) {
            cond = false;
        } else {
            int mid = (low + high) / 2;
            if (target == mid) {
                cond = true;
            } else if (target < data[mid]) {
                cond = binarySearchRecursion(data, target, low, mid - 1);
            } else {
                cond = binarySearchRecursion(data, target, mid + 1, high);
            }
        }
        return cond;
    }

    // array must be sorted
    public static boolean binarySearchRecursion2(int[] data, int target, int low, int high) {
        boolean cond = false;
        if (low > high) {
            cond = false;
        } else {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true; // target is at the middle
            } else if (target < data[mid]) { // scan the left hand side
                cond = binarySearchRecursion2(data, target, low, mid - 1);
            } else { // must be in the right hand side
                cond = binarySearchRecursion2(data, target, mid + 1, high);
            }
        }
        return cond;
    }

    public static boolean binarySearchIteration(int[] data, int target, int low, int high) {
        // you have to define your low and high in this case
        // usually the first element and the last element of data
        low = 0;
        high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true;
            } else if (target < data[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static boolean binarySearchIteration2(int[] data, int target, int low, int high) {
        low = 0;
        high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true;
            } else if (target < data[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    // the Big-O: O(log n)
    public static int binarySum(int[] data, int low, int high) {
        if (low > high) {
            return 0;
        } else if (low == high) {
            return data[low];
        } else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    public static int binarySum2(int[] data, int low, int high) {
        if (low > high) {
            return 0;
        } else if (low == high) {
            return data[low];
        } else {
            int mid = (low + high) / 2;
            return binarySum2(data, low, mid) + binarySum2(data, mid + 1, high);
        }
    }

    // the Big-O: O(n)
    public static int linearSum(int[] data, int n) {
        if (n == 0) {
            return 0;
        } else {
            return linearSum(data, n - 1) + data[n - 1];
        }
    }

    public static int linearSum2(int[] data, int n) {
        if (n == 0) {
            return 0;
        } else {
            return linearSum2(data, n - 1) + data[n - 1];
        }

    }

    /*
	reversing an Array Using a Stack
	public static <E> void reverse(E[] a) {
		Stack<E> buffer = new ArrayStack<>(a.length);
		for(int i = 0; i < a.length; i++) {
			buffer.push(a[i]);
		}
		// using the same array size and index
		// pop the stack and store the pop values in the same array
		for(int j = 0; j < a.length; j++) {
			a[j] = buffer.pop();
		}
	}
     */
    
    // Recursion version
    public static int findGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return findGCD(num2, num1 % num2);
        }
    }
    
    // Iteration version
    public static int findGCDIteration(int num1, int num2) {
        if(num2 == 0) return num1;
        int max = Math.max(num1, num2); // larger number between the two
        int min = Math.min(num1, num2); // smallest number between the two
        int r; // remainder
        do {
            r = max % min; 
            max = min; // max becomes min
            min = r;   // min becomes remainder of max and min
        } while (r != 0);   
        // do this until reach 0 and return max the last num
        return max;
    }
    
    public static boolean isMatched(String expression) {
        // define opening char
        final String opening = "({[";
        // define closing char
        final String closing = ")}]";
        // create an object of stack of type character
        Stack<Character> buffer = null;
        // convert the expression to char and make that char as array
        for(char c : expression.toCharArray()) {
            if(opening.indexOf(c)!=-1) {
                buffer.push(c);
            } else if(closing.indexOf(c)!=-1) {
                if(buffer.isEmpty()) {
                    return false;
                }
                if(closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false;
                }
            }
        }
        // scan the char array for opening char and push those opening in the stack
        
        return buffer.isEmpty();
    }
    
    public static int factorialIteration(int n) {
        int temp = 1;
        if(n == 0) {
            return 1;
        } else {
            for(int i = 1; i <= n; i++) {
               temp = temp * i;
            }
        }
        return temp;   
    }
    
    public static int factorialRecursion(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorialRecursion(n - 1);
        }
    }

    
    public static int fibonacciIteration(int n) {
        int i, prev, curr, temp;
        if(n <= 2) {
            return 1;
        } else {
            prev = 1;
            curr = 1;
            i = n;
            do {
                temp = prev + curr;
                prev = curr;
                curr = temp;
                i--;
            } while (i > 2);
            return curr; // curr holds the value we want
        }
    }
	
    public static int fibonacciRecurion(int n) {
        if(n <= 2) {
            return 1;
        } else {
            return fibonacciRecurion(n - 1) + fibonacciRecurion(n - 2);
        }
    }
    
    // complexity: O(n)
    public static int powerRecursion(int x, int n) {
        // x^n
        if(n == 0) {
            return 1;
        } else {
            return x * powerRecursion(x, n-1);
        }
    }
    
    // complexity: O(log n)
    public static double powerRecursion2(int x, int n) {
        if(n == 0) {
            return 1;
        } else {
            double partial = powerRecursion(x, n/2); // if n is even
            double result = partial * partial; // e.g. 2^(12) = 2^(6) * 2^(6)
            if(n % 2 == 1) {
                result = result * x; // e.g. 2^(13) = (2^(6) * 2^(6)) * 2
            }
            return result;    
        }
    }
    

}
