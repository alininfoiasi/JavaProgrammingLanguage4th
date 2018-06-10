package ch12;

import ch4.Attr;
import ch4.AttributedImplementation;
import java.util.logging.Level;
import java.util.logging.Logger;
// unchecked/runtime exceptions cannot be recovered at runtime
// reflect errors in program logic

// custom checked exceptions should extend Exception
class NoSuchAttributeException extends Exception {

    public final String attrName;

    public NoSuchAttributeException(String name) {
        super("No attribute named \"" + name + "\" found");
        attrName = name;
    }
}

public class CheckedExceptions {

    public static void replaceValue(String name, Object newValue)
            throws NoSuchAttributeException {

        AttributedImplementation attrImpl = new AttributedImplementation();
        Attr attr = attrImpl.find(name); // look up the attr
        if (attr == null) // it isn't found
        {
            throw new NoSuchAttributeException(name);
        }
        attr.setValue(newValue);
    }

    public static void main(String args[]) {
        try {
            CheckedExceptions.replaceValue("null", null);
        } catch (NoSuchAttributeException ex) {
            ex.printStackTrace();
        }
    }
}
