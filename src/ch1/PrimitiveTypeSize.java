package ch1;

public class PrimitiveTypeSize {
    
    public static void size_of_primitive_types() {
        System.out.println("Size of primitive types (in bits)...");
        System.out.println("Byte: " + Byte.SIZE);
        System.out.println("Short: " + Short.SIZE);
        System.out.println("Integer: " + Integer.SIZE);
        System.out.println("Long: " + Long.SIZE);
        System.out.println("Float: " + Float.SIZE);
        System.out.println("Double: " + Double.SIZE);
        System.out.println("Character: " + Character.SIZE);
        System.out.println("Boolean: undetermined");
    }

    public static void main(String arguments[]) {
        PrimitiveTypeSize.size_of_primitive_types();
    }
}
