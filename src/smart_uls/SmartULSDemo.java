package smart_uls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class SmartULSDemo {
    public static Scanner sc;
    /** 
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        SmartULS s = new SmartULS();
        int thresholdSize;
        do {
            System.out.print("Enter test data size : ");
            sc = new Scanner(System.in);
            thresholdSize = sc.nextInt();
        } while (thresholdSize < 1);
        
        ProcessSmartULS p = new ProcessSmartULS();
        
        p.setSmartThresholdULS(thresholdSize);
        p.processSmartUlS("uls_test_file1.txt");
        System.out.println("Contents before operations");
        p.displayCurrentContents();
        System.out.println("");
        
        
        
        // insertion demo
        p.add(s, "123232", "N"); // ok add
        p.add(s, "999999", "Q"); // ok add
        p.add(s, "999999", "O"); // duplicate don't add
        
        // generate keys demo
        p.add(s, p.generate(), "P"); // ok add
        
        
        // removal demo
        p.remove("12099753"); // exists
        p.remove("3213123"); // not exists
        p.remove("999"); // not exists
        
        
        p.getValues("111111"); 
        
        
        System.out.println("");
        System.out.println("After adding and removal");
        p.displayCurrentContents();
        
        
        p.nextKey("03325725");
        p.prevKey("03325725");
        
        System.out.println(p.rangeKey("33248005", "11111"));
        
        p.sorting();
        
        
    }
    
    
}
