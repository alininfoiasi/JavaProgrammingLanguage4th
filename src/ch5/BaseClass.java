package ch5;

public class BaseClass {

    interface HelloWorld {

        public void greet();

        public void greetSomeone(String someone);
    }
    private static int x = 1;
    private int y = 2;
    private final int z = 3;

    /**
     * 1. static inner class: - has access to static private members of the
     * BaseClass
     */
    public static class StaticInnerClass {

        public void method1() {
            System.out.println("private member x:" + x);
            //System.out.println("private member y:" + x);
        }
    }

    /**
     * 2. instance inner class: - every instance of InstanceInnerClass is tied
     * to a particular instance of BaseClass
     */
    public class InstanceInnerClass {

        public void method1() {
            System.out.println("private member x:" + x);
            System.out.println("private member y:" + x);
        }
    }

    public void method1(int var, final int finalVar) {
        final int t = 10;
        int v = 100;
        /**
         * 3. local inner class: - has access to any final variable from the
         * method where it is declared
         */
        class LocalInnerClass {

            int licX = x;
            int licY = y;
            int licZ = z;
            int licT = t;
            //int licV = v;
            //int licVar = var;
            int licFinalVar = finalVar;
        }
        LocalInnerClass lic = new LocalInnerClass();
        System.out.println(lic.licX + " " + lic.licY + " " + lic.licZ + " " + lic.licT + " "
                + lic.licFinalVar + " ");
    }

    @SuppressWarnings("empty-statement")
    public void sayHello() {
        
        class EnglishGreeting implements HelloWorld {

            String name = "world";

            @Override
            public void greet() {
                greetSomeone(name);
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name + "!");
            }
        };
        
        /**
         * 4. anonymous inner class: - basically a local inner class with only
         * one instance
         */
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            @Override
            public void greet() {
                greetSomeone(name);
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name + "!");
            }
        };

        EnglishGreeting englishGreeting = new EnglishGreeting();
        englishGreeting.greet();
        frenchGreeting.greet();
        englishGreeting.greetSomeone("Fifi");
        frenchGreeting.greetSomeone("Fifi");
    }

    public static void main(String args[]) {
        BaseClass baseClass = new BaseClass();
        
        // 1. static inner class
        BaseClass.StaticInnerClass sic = new BaseClass.StaticInnerClass();
        sic.method1();
        
        // 2. instance inner class
        BaseClass.InstanceInnerClass iic = baseClass.new InstanceInnerClass();
        iic.method1();
        
        // 3. local inner class
        baseClass.method1(10, 100);
        
        // 4. anonymous inner class
        baseClass.sayHello();
    }
}
