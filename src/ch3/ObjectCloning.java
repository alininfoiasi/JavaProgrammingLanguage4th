package ch3;

/**
 *
 * @author alin
 */
class IntegerStack implements Cloneable { // dangerous

    private int[] buffer;
    private int top;

    public IntegerStack(int maxContents) {
        buffer = new int[maxContents];
        top = -1;
    }

    public void push(int val) {
        buffer[++top] = val;
    }

    public int pop() {
        return buffer[top--];
    }

    // reference duplication case
    // default clone method (shallow clone) will provide a buffer that 
    //references the same buffer from the original object
    public IntegerStack badCloning() {
        try {
            return (IntegerStack) super.clone();
        } catch (CloneNotSupportedException e) {
            // Cannot happen -- we support clone
            throw new InternalError(e.toString());
        }
    }

    public IntegerStack clone() {
        try {
            IntegerStack nObj = (IntegerStack) super.clone();
            nObj.buffer = buffer.clone();
            return nObj;
        } catch (CloneNotSupportedException e) {
            // Cannot happen -- we support clone, and so do arrays
            throw new InternalError(e.toString());
        }
    }
}

public class ObjectCloning {

    public static void main(String args[]) {
        IntegerStack first = new IntegerStack(3);
        first.push(2);
        first.push(3);
        IntegerStack second = first.clone();
        first.push(10);
        System.out.println(first.pop());
        System.out.println(second.pop());
    }
}