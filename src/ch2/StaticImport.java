package ch2;

// static import (imports static members of the class)
import static java.lang.Math.exp;
import static java.lang.Math.abs;

//on-demand static import
//import static java.lang.Math.*;

public class StaticImport {

    // use "strictf" keyword to 
    
    // native: a method that can be invoked in Java but is written in 
    // some other lanuguage: C, C++,...
    // cannot be abstract or strictfp
    // using JNI (for C), portability and safety are lost
    public native int getCPUID();

    public static double f1(double x) {
        return (x + 1.0);
    }

    public static double f2(double x) {
        return (exp(x) / abs(-x));
    }

    public static void main(String args[]) {
        System.out.println(StaticImport.f2(0.5));
    }
}
