package smart_uls;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class ProcessSmartULS {
    
    private final int MAX_DIGIT_SIZE = 99999999;
    private int size;
    private Scanner dataFile;
    private final Random rand = new Random();
    List<SmartULS> smartULSobj = new ArrayList<>();
    Map<String, String> ULSmapping = new HashMap<>();

    /**
     * Scan the file, if the file do not exist then print no such file.
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public void processSmartUlS(String fileName) throws FileNotFoundException, IOException {
        dataFile = null;

        try {
            // read the content and store it here
            dataFile = new Scanner(new BufferedReader(new FileReader(fileName)));
            SmartULS out;
            int i = 0;
            while (dataFile.hasNext() && i < size) {
                // generate a key value pair
                out = storeProcessedSmartULSData(dataFile);
                
                // add the generated list to SmartULS list object
                smartULSobj.add(out);
                
                // insert keys in the hash table
                ULSmapping.put(dataFile.nextLine(), randomCharValue());

                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not exists " + ex);
        } finally {
            if (dataFile != null) {
                dataFile.close();
            }
        }
    }
    
    /**
     * Using radix sort we can sort the keys  if the input
     * is too large
     * as a sorted sequence 
     * @return  
     */
    public int[] allKeys() {
        
        int[] radixInput = new int[ULSmapping.keySet().toArray().length];
        for(int i = 0; i < ULSmapping.keySet().toArray().length; i++) {
            radixInput[i] = Integer.parseInt((String) ULSmapping.keySet().toArray()[i]);
        }
        RadixSort.radixsort(radixInput);
        System.out.println("");
        System.out.println("The list of keys sorted with radix sort.");
        return radixInput;
    }
    
    public void allkeysSortedTreemap() {
        Map<String, String> treeMap = new TreeMap<>(ULSmapping);
        //show hashmap after the sort
        treeMap.keySet().stream().forEach((str) -> {
            System.out.println(str);
        });
    }
    
    
    
    public void add(SmartULS s, String k, String v) {
        boolean isKeyExists = false; 
        
        // check key length before adding
        validKeyLength(k);
        
        // check for existing key before adding
        Iterator<Map.Entry<String, String>> iter = ULSmapping.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if (k.equalsIgnoreCase(entry.getKey())) {
                isKeyExists = true;
            }
        }
        
        s.setUlsKey(k);
        s.setUlsValue(v);
        
        // add in the list
//        smartULSobj.add(s);
        
        // add in the hash table
        ULSmapping.put(k, v);
        
        if(!isKeyExists) {
            System.out.println("Trying to INSERT: '[" + k + ", "+ v + "]'");
            System.out.println("  Added!");
        } else {
            System.out.println("Trying to INSERT: '[" + k + ", "+ v + "]'");
            System.out.println("  This key does not exists!");
        }
        
       
    }
    
    public void remove(String k) {
        boolean isKeyExists = false; 
        
        // check key length before adding
        validKeyLength(k);
        
        // remove from the hashtable
        Iterator<Map.Entry<String, String>> iter = ULSmapping.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if (k.equalsIgnoreCase(entry.getKey())) {
                isKeyExists = true;
                iter.remove();
            }
        }
        
        
        if(isKeyExists) {
            System.out.println("Trying to REMOVE: '[" + k + "]'");
            System.out.println("  Removed!");
        } else {
            System.out.println("Trying to REMOVE: '[" + k + "]'");
            System.out.println("  This key does not exists");
        }
    }

    public void getValues(String k) {
        boolean isKeyExists = false; 
        String tempVal = "";
        Iterator<Map.Entry<String, String>> iter = ULSmapping.entrySet().iterator();
        while (iter.hasNext()) {
            
            Map.Entry<String, String> entry = iter.next();
            if (k.equalsIgnoreCase(entry.getKey())) {
                tempVal = entry.getValue();
                isKeyExists = true;
            }
        }
        
        if(!isKeyExists) {
            System.out.println("Trying to SEARCH: '[" + k + "]'");
            System.out.println("  This key does not exists");
        } else {
            System.out.println("Trying to SEARCH: '[" + k + "]'");
            System.out.println("  Found! " + "The key = '" + k + "'" + " has value a = '" + tempVal + "'");
        }
    }
    
    public String nextKey(String k) {
        boolean isKeyExists = false; 
        String nextK = "";
        for(int i = 0; i < ULSmapping.keySet().toArray().length; i++) {
            if(k.equals(ULSmapping.keySet().toArray()[i])) {
                isKeyExists = true;
                nextK = (String) ULSmapping.keySet().toArray()[i+1];
                break;
            }
        }
        if(!isKeyExists) {
            System.out.println("Trying to FIND the NEXT key after: '[" + k + "]'");
            System.out.println("  This key does not exists");
        } else {
            System.out.println("Trying to FIND the NEXT key afer: '[" + k + "]'");
            System.out.println("  Found! " + "The key after = '" + k + "'" + " is = '" + nextK + "'");
        }
        return nextK;
    }
    
    public String prevKey(String k) {
        boolean isKeyExists = false; 
        String prevK = "";
        for(int i = 0; i < ULSmapping.keySet().toArray().length; i++) {
            if(k.equals(ULSmapping.keySet().toArray()[i])) {
                isKeyExists = true;
                prevK = (String) ULSmapping.keySet().toArray()[i-1];
                break;
            }
        }
        if(!isKeyExists) {
            System.out.println("Trying to FIND the PREV key before: '[" + k + "]'");
            System.out.println("  This key does not exists");
        } else {
            System.out.println("Trying to FIND the PREV key before: '[" + k + "]'");
            System.out.println("  Found! " + "The key after = '" + k + "'" + " is = '" + prevK + "'");
        }
        return prevK;
    }
    /**
     * returns the number of keys that are within the specified range
     * of the two keys key1 and key2 inclusive
     * @param key1
     * @param key2
     * @return 
     */
    public List<String> rangeKey(String key1, String key2) {
        boolean isIntheRange = false;
        boolean isKeyExists = false;
        List<String> keysInRange = new ArrayList<>();
        for(Map.Entry<String, String> entry : ULSmapping.entrySet()) {
            if (!ULSmapping.containsKey(key1) || !ULSmapping.containsKey(key2)) {
                break;
            } else {
                isKeyExists = true;
                // first get the position of first key
                if (entry.getKey().equals(key1)) {
                    isIntheRange = true;
                }
                // keep adding entry
                if (isIntheRange) {
                    keysInRange.add(entry.getKey());
                }
                // until you get to second key you stop
                if (entry.getKey().equals(key2)) {
                    break;
                }
            }
        }
        if (!isKeyExists) {
            System.out.println("Trying to find the RANGE of keys between: '[" + key1 + "]' and '[" + key2 + "]'");
            System.out.println("   Fail! At least one of the keys does not exists.");
        } else {
            System.out.println("Trying to find the RANGE of keys between: '[" + key1 + "]' and '[" + key2 + "]'");
            System.out.println("   Found! The keys between the range: '[" + key1 + "]' and '[" + key2 + "]' are:");
        }
        return keysInRange;
    }
    
    /**
     * rangeKey(key1, key2): returns the number of keys that are within the
     * specified range of the two keys key1 and key2.
     * @param s
     */
    public void setSmartThresholdULS(int s) {
        size = s;
    }

    public SmartULS storeProcessedSmartULSData(Scanner dataFile) throws IOException {
        SmartULS s = new SmartULS();
        String k = dataFile.nextLine();
        
        for (int i = 0; i < this.size; i++) {
            String randomVal  = randomCharValue();
            s.setUlsKey(k);
            s.setUlsValue(randomVal);
            
        }
        return s;
    }
    
    public String randomCharValue() {
        String alpb = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int ranNum = rand.nextInt(alpb.length());
        return String.valueOf(alpb.charAt(ranNum));
    }

    /**
     * Generate a non-existing key.
     * 
     * @return 8 digits key
     */
    public String  generate() {
        int ranNum = rand.nextInt(MAX_DIGIT_SIZE);
        
        Iterator<Map.Entry<String, String>> iter = ULSmapping.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if (String.valueOf(ranNum).equalsIgnoreCase(entry.getKey())) {
                ranNum = rand.nextInt(MAX_DIGIT_SIZE);
            }
        }
        return String.valueOf(ranNum);
    }
    
    public void displayCurrentContents() {
        
        ULSmapping.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });//        System.out.println("");
        

    }
    
    public void validKeyLength(String keyLengh) {
        if(keyLengh.length() > 8) {
            System.out.println("Please enter a key <= 8 digits.");
            System.out.println("Current key length " + keyLengh.length() + " digits.");
            System.exit(0);
        } 
    }
    
    /**
     * Determines which method of sorting to run
     * base on the number of inputs.
     */
    public void sorting() {
        // radix sort is faster for smaller inputs
        if (size <= 1000) {
            // sort by radix sort
            System.out.println(Arrays.toString(allKeys()));
        } else {
            // sort by generics
            allkeysSortedTreemap();
        }
    }

}
