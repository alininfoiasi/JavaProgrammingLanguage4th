package ch1;

class StringFormatter {

    public static void runExample1() {
        // %n inserts correct line separator character
        // it depends on the curret platform
        System.out.printf("The value is %d %n", 3);
        System.out.printf("The value is %x %n", 123);
        System.out.printf("The value is %o %n", 17);
        System.out.printf("The value is %f %n", 123.4567);
        System.out.printf("The value of Math.PI is %20.3f %n", Math.PI*100);
        System.out.printf("The value of Math.PI is %20.4f %n", Math.PI*100);
        System.out.printf("The value of Math.PI is %20.5e %n", Math.PI*100);
    }
}

public class ImmutableString {

    static void compareStrings() {
        String s1 = "abc";
        String s2 = "abc";
        if (s1 == s2) {
            System.out.println("Same reference");
        }
        if (s1.equals(s2)) {
            System.out.println("Same content");
        }
    }

    static void assignStrings() {
        String s1, s2;
        s1 = s2 = "abc";
        if (s1 == s2) {
            System.out.println("Same reference");
        }
        if (s1.equals(s2)) {
            System.out.println("Same content");
        }
    }

    static void modifyStrings() {
        String s1, s2;
        s1 = s2 = "abc";
        s1.replace("a", "A");
        if (s1.equals(s2) || s1 == s2) {
            System.out.println("No modification");
        } else {
            System.out.println("Modification occured");
        }
    }

    public static void main(String args[]) {
        //ImmutableString.compareStrings();
        //ImmutableString.assignStrings();
        ImmutableString.modifyStrings();
        //StringFormatter.runExample1();
    }
}
