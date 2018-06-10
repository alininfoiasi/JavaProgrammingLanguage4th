package ch2;

public class MethodOverloading {

    // overloaded methods have different parameter type and/or arity
    
    public static void print(String title) {
        System.out.println("first");
    }

    public static void print(String title, String... messages) {
        System.out.println("second");
    }

    public static void print(String... messages) {
        System.out.println("third");
    }

    public static void main(String args[]) {
        // a fixed-argument method will always be selected 
        //over a varargs method
        print("Hello");
        // INVALID: ambiguous invocation
        //print("Hello", "World");
        print("Hello", new String[]{"World"});
        print(new String[]{"Hello", "World"});
    }
}
