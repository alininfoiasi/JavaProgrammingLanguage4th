package ch4;

import java.util.*;
import ch2.Body;

public class AttributedImplementation implements Attributed, Iterable<Attr> {

    protected Map<String, Attr> attrTable =
            new HashMap<String, Attr>();

    public void add(Attr newAttr) {
        attrTable.put(newAttr.getName(), newAttr);
    }

    public Attr find(String name) {
        return attrTable.get(name);
    }

    public Attr remove(String name) {
        return attrTable.remove(name);
    }

    public Iterator<Attr> attrs() {
        return attrTable.values().iterator();
    }

    public Iterator<Attr> iterator() {
        return attrs();
    }
}
class AttributedBody extends Body
        implements Attributed {

    // composition and forwarding of an AttributedImplementation to avoid
    //double inheritance impossibility
    private AttributedImplementation attrImpl = new AttributedImplementation();

    public AttributedBody() {
        super();
    }

    public AttributedBody(String name, Body orbits) {
        super(name, orbits);
    }
    
    // forward all Attributed methods to the attrImpl object
    public void add(Attr newAttr) {
        attrImpl.add(newAttr);
    }

    public Attr find(String name) {
        return attrImpl.find(name);
    }

    public Attr remove(String name) {
        return attrImpl.remove(name);
    }

    public Iterator<Attr> attrs() {
        return attrImpl.attrs();
    }
}