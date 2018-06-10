/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch3;

class SuperShow {

    public String str = "SuperStr";

    public void show() {
        System.out.println("Super.show: " + str);
    }
}

class ExtendShow extends SuperShow {

    public String str = "ExtendStr";

    // if show() in SuperShow would be final, it couldn't be overridden
    @Override
    public void show() {
        System.out.println("Extend.show: " + str);
    }
}

class Base {

    protected String name = "Base";

    /**
     * return the class name
     */
    protected String getName() {
        return name;
    }
}

class More extends Base {

    protected String name = "More";

    protected String getName() {
        return name;
    }

    protected void printName() {
        Base sref = (Base) this;
        More mref;
        System.out.println("this.name() = " + this.name);
        System.out.println("sref.name() = " + sref.name);
        System.out.println("super.name() = " + super.name);
        System.out.println("this.name() = " + this.getName());
        System.out.println("sref.name() = " + sref.getName());
        System.out.println("super.name() = " + super.getName());

        //to be sure no exception will be thrown by downcasting
        if (sref instanceof More) {
            mref = (More) sref;
        }
    }
}

public class InheritedMembers {

    public static void main(String[] args) {

        // the declared type of a reference is used to access a field
        // the actual class of an object is used to access a method
        ExtendShow ext = new ExtendShow();
        SuperShow sup = ext;
        sup.show();
        ext.show();
        System.out.println("sup.str = " + sup.str);
        System.out.println("ext.str = " + ext.str);

        More m = new More();
        m.printName();
        
        System.out.println(ext.getClass());
        System.out.println(sup.getClass());
        System.out.println(m.getClass());
    }
}
