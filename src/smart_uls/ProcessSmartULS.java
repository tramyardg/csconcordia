package smart_uls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class ProcessSmartULS {
    
    private final int MAX_DIGIT_SIZE = 99999999;
    private int size;
    private final Random rand = new Random();
    List<SmartULS> smartULSList = new ArrayList<>();
    // hashtable is obsolete, use treemap or hashmap
    Map<String, String> ulsEntrySet = new HashMap<>();

    /**
     * Scan the file, if the file do not exist then print no such file.
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public void processSmartUlS(String fileName) throws FileNotFoundException, IOException {
        boolean isFileExist = false;
        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            isFileExist = true;
        }
        if (!isFileExist) {
            System.out.println("This file does not exists.");
        } else {
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            SmartULS out;
            int i = 0;
            while ((strLine = br.readLine()) != null && i < size) {
                // generate a key value pair
                out = storeProcessedSmartULSData(strLine);

                // add the generated list to SmartULS list object
                smartULSList.add(out);

                // System.out.println(strLine);
                ulsEntrySet.put(strLine, randomCharValue());

                i++;
            }
            br.close();
        }
    }
    
    /**
     * Using radix sort we can sort the keys  if the input
     * as a sorted sequence 
     * @return  
     */
    public int[] allKeys() {
        int[] radixInput = new int[ulsEntrySet.keySet().toArray().length];
        for(int i = 0; i < ulsEntrySet.keySet().toArray().length; i++) {
            radixInput[i] = Integer.parseInt((String) ulsEntrySet.keySet().toArray()[i]);
        }
        RadixSort.radixsort(radixInput);
        System.out.println("The list of keys sorted with radix sort.");
        return radixInput;
    }
    
    public void allkeysSortedByTree() {
        System.out.println("Sorted by tree map: ");
        ulsEntrySet.keySet().stream().forEach((str) -> {
            System.out.println(str);
        });
    }
    
    public void add(SmartULS s, String k, String v) {
        if(this.validateKeyLength(k)) {
            System.out.println("Trying to INSERT: '[" + k + ", "+ v + "]'");
            System.out.println("  > Invalid key length!");
        } else if(ulsEntrySet.containsKey(k)){            
            System.out.println("Trying to INSERT: '[" + k + ", "+ v + "]'");
            System.out.println("  > This key already exists!");  
        } else {
            ulsEntrySet.put(k, v);
            System.out.println("Trying to INSERT: '[" + k + ", "+ v + "]'");
            System.out.println("  > Added!");
        }
        
        s.setUlsKey(k);
        s.setUlsValue(v);
        smartULSList.add(s);
    }
    
    public void remove(String k) {
        if(this.validateKeyLength(k)) {
            System.out.println("Trying to REMOVE: '[" + k + "]'");
            System.out.println("  > Invalid key length!");
        } else if(ulsEntrySet.containsKey(k)){            
            ulsEntrySet.remove(k);
            System.out.println("Trying to REMOVE: '[" + k + "]'");
            System.out.println("  > Removed!"); 
        } else {
            System.out.println("Trying to REMOVE: '[" + k + "]'");
            System.out.println("  > This key does not exists");
        }
    }

    public String getValues(String k) {
        String tempVal = "";
        if(this.validateKeyLength(k)) {
            System.out.println("Trying to SEARCH: '[" + k + "]'");
            System.out.println("  > Invalid key length!");
        } else if (ulsEntrySet.containsKey(k)) {
            for (int i = 0; i < ulsEntrySet.keySet().toArray().length; i++) {
                if (k.equals(ulsEntrySet.keySet().toArray()[i])) {
                    tempVal = (String) ulsEntrySet.values().toArray()[i];
                    break;
                }
            }
            System.out.println("Trying to SEARCH: '[" + k + "]'");
            System.out.println("  > Found! " + "The key = '" + k + "'" + " has value a = '" + tempVal + "'");
        } else {
            System.out.println("Trying to SEARCH: '[" + k + "]'");
            System.out.println("  > This key does not exists");
        }
        
        return tempVal;
    }
    
    /**
     * @param k
     * @return the next element after k
     */
    public String nextKey(String k) {
        String nextK = null;
        if(this.validateKeyLength(k)) {
            System.out.println("Trying to FIND the NEXT key afer: '[" + k + "]'");
            System.out.println("  > Invalid key length!");
        } else if(ulsEntrySet.containsKey(k)){       
            for (int i = 0; i < ulsEntrySet.keySet().toArray().length-1; i++) {
                if (k.equals(ulsEntrySet.keySet().toArray()[i])) {
                    nextK = (String) ulsEntrySet.keySet().toArray()[i + 1];
                    break;
                }
            }
            System.out.println("Trying to FIND the NEXT key afer: '[" + k + "]'");
            System.out.println("  > Found! " + "The key after = '" + k + "'" + " is = '" + nextK + "'");
        } else {
            System.out.println("Trying to FIND the NEXT key after: '[" + k + "]'");
            System.out.println("  > This key does not exists");
        }
        return nextK; // returns the last element of the list
    }
    
    /**
     * @param k
     * @return get the previous key before k
     */
    public String prevKey(String k) {
        String prevK = null;
        if(this.validateKeyLength(k)) {
            System.out.println("Trying to FIND the PREV key before: '[" + k + "]'");
            System.out.println(" > Invalid key length:");
        } else if(ulsEntrySet.containsKey(k)){   
            for (int i = 0; i < ulsEntrySet.keySet().toArray().length; i++) {
//                if (k.equals(ulsEntrySet.keySet().toArray()[i]) && i == 0) {
//                    prevK = null;
//                }
                if (k.equals(ulsEntrySet.keySet().toArray()[i]) && i > 0) {
                    prevK = (String) ulsEntrySet.keySet().toArray()[i - 1];
                    break;
                }
            }
            System.out.println("Trying to FIND the PREV key before: '[" + k + "]'");
            System.out.println("  > Found! " + "The key before = '" + k + "'" + " is = '" + prevK + "'");
        } else {
            System.out.println("Trying to FIND the PREV key before: '[" + k + "]'");
            System.out.println("  > This key does not exists");
        }
        return prevK;
    }
    
    /**
     * @param key1 fromKey
     * @param key2 toKey
     * @return the number of keys that are within the specified key range
     */
    public String rangeKey(String key1, String key2) {
        boolean isIntheRange = false;
        List<String> keysInRange = new ArrayList<>();
        if(this.validateKeyLength(key1) || this.validateKeyLength(key2)) {
            System.out.println("Trying to find the RANGE of keys between: '[" + key1 + "]' and '[" + key2 + "]'");
            System.out.println("   > Fail! Invalid key length.");
        } else if(ulsEntrySet.containsKey(key1) && ulsEntrySet.containsKey(key2)) {
            for (Map.Entry<String, String> entry : ulsEntrySet.entrySet()) {
                if (entry.getKey().equals(key1)) { // first get the position of first key
                    isIntheRange = true;
                }
                if (isIntheRange) { // keep adding entry
                    keysInRange.add(entry.getKey());
                }
                // until you get to second key you stop
                if (entry.getKey().equals(key2)) {
                    break;
                }
            }
            System.out.println("Trying to find the RANGE of keys between: '[" + key1 + "]' and '[" + key2 + "]'");
            System.out.println("   > Found! The keys between the range: '[" + key1 + "]' and '[" + key2 + "]' are:");
        } else {
            System.out.println("Trying to find the RANGE of keys between: '[" + key1 + "]' and '[" + key2 + "]'");
        }
        return keysInRange.toString();
    }
    
    /**
     * rangeKey(key1, key2): returns the number of keys that are within the
     * specified range of the two keys key1 and key2.
     * @param s
     */
    public void setSmartThresholdULS(int s) {
        size = s;
    }

    public SmartULS storeProcessedSmartULSData(String dataFile) throws IOException {
        SmartULS s = new SmartULS();
        for (int i = 0; i < this.size; i++) {
            String randomVal  = randomCharValue();
            s.setUlsKey(dataFile);
            s.setUlsValue(randomVal);
        }
        return s;
    }
    
    /**
     * @return assign a random char for keys
     */
    public String randomCharValue() {
        String alpb = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int ranNum = rand.nextInt(alpb.length());
        return String.valueOf(alpb.charAt(ranNum));
    }

    /**
     * @return Generate a non-existing key 8 digits key
     */
    public String generate() {
        int ranNum = rand.nextInt(MAX_DIGIT_SIZE);
        String oldNum = String.valueOf(ranNum);
        // use a do while loop to guarantee that the gerated
        // key will never exists
        do {
            // check if the generated key exists
            if (ulsEntrySet.containsKey(oldNum)) {
                // generate a new one
                System.out.println("This key already exists!");
                System.out.println("Genating a new one.");
                ranNum = rand.nextInt(MAX_DIGIT_SIZE);
            }
            // keep generating a new one if the next key exists again
        } while (ulsEntrySet.containsKey(String.valueOf(ranNum)));
        return String.valueOf(ranNum);
    }
    
    public void displayCurrentContents() {
        ulsEntrySet.entrySet().stream().forEach((str) -> {
            System.out.println(str);
        });
    }
    
    /**
     * @param k key to be processed
     * @return true if key is > 8
     */
    public boolean validateKeyLength(String k) {
        return k.length() > 8;
    }
}
