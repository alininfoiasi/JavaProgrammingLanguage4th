package ch1;

import java.util.*;

interface Lookup<T> {
    // use interfaces to provide different designs
    // use interfaces for peripheral abilities of a class, and not its 
    //central identity

    // specify WHAT the class is doing, but not HOW
    // 1. all variable declaration are implicitly "public static final"
    // 2. all methods are implicitly "public abstract"
    // 3. uses "implements"
    // 4. can extend only other interfaces
    // 5. cannot be instantiated
    // 6. all methods of an interface must be defined (all properties needs 
    //to be implemented by subclasses)
    // 7. interfaces contain no method implementation
    // 8. can contain nested class and interface declarations
    // 9. cannot have constructors
    /* Return the value associated with the name, or
     * null if there is no such value */
    T find(String name);
    T clear(String name);
}

interface Lookdown<T> {
    // use interfaces to provide different designs
    // use interfaces for peripheral abilities of a class, and not its central identity

    // specify WHAT the class is doing, but not HOW
    // 1. all variable declaration are implicitly "public static final"
    // 2. all methods are implicitly "public abstract"
    // 3. uses "implements"
    // 4. can extend only other interfaces
    // 5. cannot be instantiated
    // 6. all methods of an interface must be defined (all properties needs to be implemented by subclasses)
    // 7. interfaces contain no method implementation 
    // 8. can contain nested class and interface declarations
    // 9. cannot have constructors
    /* Return the value associated with the name, or
     * null if there is no such value */
    T find(String name);
    T clear(String name);
}

class ArrayLookup implements Lookup<Integer>, Lookdown<Integer> {

    private String[] names;
    private Integer[] values;
    private int dimension;

    public ArrayLookup() {
        dimension = 3;
        names = new String[dimension];
        names[0] = "one";
        names[1] = "two";
        names[2] = "three";

        values = new Integer[dimension];
        values[0] = 1;
        values[1] = 2;
        values[2] = 3;
    }

    @Override
    public Integer find(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return values[i];
            }
        }
        // not found
        return null;
    }

    @Override
    public Integer clear(String name) {
        Integer value = null;
        Integer v[] = new Integer[dimension - 1];
        String n[] = new String[dimension - 1];
        int i, j = 0;
        for (i = 0; i < names.length; i++) {
            if (names[i].equals(name) && value==null) {
                value = values[i];
            } else {
                v[j] = values[i];
                n[j] = names[i];
                j++;
            }
        }
        // resize original arrays if the value was found, after deleting the
        // found element
        if (value != null) {
            dimension--;
            values = new Integer[dimension];
            names = new String[dimension];
            values = Arrays.copyOf(v, dimension);
            names = Arrays.copyOf(n, dimension);
        }
        return value;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            sb.append(names[i]);
            sb.append(" ");
            sb.append(values[i]);
            sb.append("\n");
        }
        return sb.toString();
    }
    
}

class ListLookup implements Lookup<Integer>, Lookdown<Integer> {

    private List<String> names;
    private List<Integer> values;

    public ListLookup() {
        names = new ArrayList<String>();
        names.add("one");
        names.add("two");
        names.add("three");

        values = new ArrayList<Integer>();
        values.add(1);
        values.add(2);
        values.add(3);
    }

    public Integer find(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(name)) {
                return values.get(i);
            }
        }
        // not found
        return null;
    }

    public Integer clear(String name) {
        Integer value = null;
        int pozition = -1;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(name)) {
                value = values.get(i);
                pozition = i;
                break;
            }
        }
        // resize original arrays if the value was found, after deleting the
        // found element
        if (pozition!=-1) {
            names.remove(pozition);
            values.remove(pozition);
        }
        return value;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            sb.append(names.get(i));
            sb.append(" ");
            sb.append(values.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class GenericInterface {
    // public static void processValues(String[] names, 
    //                                      Lookup<Object> table) {
    // won't compile because Lookup<Integer> is not subtype of Lookup<Object>
    // usage of a wildcard: "?" = of unspecified type, of some type
    // limit usage of objects type to Number:
    //      public static void processValues(String[] names, 
    //                                      Lookup<? extends Number> table) {
    // Number value = table.find(names[i]);

    public static void processValues(String[] names, Lookup<?> table) {
        for (int i = 0; i < names.length; i++) {
            Object value = table.find(names[i]);
            if (value != null) {
                System.out.println(value);
            }
        }
    }

    public static void main(String args[]) {
        Lookup<Integer> al = new ArrayLookup();
        Lookup<Integer> ll = new ListLookup();
        
        al.clear("three");
        ll.clear("three");
        System.out.println(al.toString());
        System.out.println(ll.toString());
        
        String[] names = new String[1];
        names[0] = "two";
        System.out.println("First:");
        GenericInterface.processValues(names, al);
        System.out.println("Second:");
        GenericInterface.processValues(names, ll);
    }
}
