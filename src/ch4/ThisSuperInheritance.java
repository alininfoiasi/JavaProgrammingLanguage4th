package ch4;

public class ThisSuperInheritance {

    class A {

        // this refers to the leftmost object that calls the method
        
        public void f1(String str) {
            System.out.println("A.f1(String)");
            this.f1(1, str);
        }

        public void f1(int i, String str) {
            System.out.println("A.f1(int, String)");
        }
    }

    class B extends A {

        @Override
        public void f1(String str) {
            System.out.println("B.f1(String)");
            super.f1(str);
        }

        @Override
        public void f1(int i, String str) {
            System.out.println("B.f1(int, String)");
            super.f1(i, str);
        }
    }

    public static void main(String[] args) {
        ThisSuperInheritance tsp = new ThisSuperInheritance();
        B b = tsp.new B();
        b.f1("Hello");
    }
}
