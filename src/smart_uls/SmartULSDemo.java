package smart_uls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
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
        ProcessSmartULS p = new ProcessSmartULS();
        SmartULS s = new SmartULS();
        String fileName = "uls_test_file2.txt";
        System.out.println("File in use: " + fileName);
        int thresholdSize;
        do {
            System.out.print("Enter test data size : ");
            sc = new Scanner(System.in);
            thresholdSize = sc.nextInt();
        } while (thresholdSize < 1);
        p.setSmartThresholdULS(thresholdSize);
        p.processSmartUlS(fileName);
        
        System.out.println("Contents of the file before operations:");
        p.displayCurrentContents();
        System.out.println("");
        
        System.out.println("\nTesting generate() method: ");
        System.out.println(p.generate());
        
        System.out.println("\nTesting add(SmartULS,key,value) method: ");
        p.add(s, p.generate(), "D");
        p.add(s, "2121212121212", "C");
        p.add(s, "69894475", "E");
        
        System.out.println("\nTesting remove(SmartULS,key) method: ");
        p.remove("04124349");
        p.remove("80463726");
        p.remove("35998989896726");
        
        System.out.println("\nTesting getValues(SmartULS,key) method: ");
        p.getValues("21212121");
        p.getValues("70160448");
        
        System.out.println("\nTesting nextKey(SmartULS,key) method: ");
        p.nextKey("42670685");
        p.nextKey("21212121");
        
        System.out.println("\nTesting prevKey(SmartULS,key) method: ");
        p.prevKey("72727272");
        p.prevKey("70120611");
        
        System.out.println("\nTesting rangeKey(key1, key2) method: ");
        System.out.println(p.rangeKey("46346726", "97209251"));
        
        System.out.println("\nTesting allKeys(SmartULS) method: ");
        System.out.println(Arrays.toString(p.allKeys()));
        
        System.out.println("\nContents AFTER operations:");
        p.displayCurrentContents();
        
        
    }
    
    
}
