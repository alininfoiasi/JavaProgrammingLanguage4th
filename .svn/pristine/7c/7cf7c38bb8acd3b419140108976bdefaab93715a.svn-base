/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch20;

import java.io.*;

class Serializable implements java.io.Serializable {

    private String name;
    private long id;
    private transient boolean hashSet = false;
    private transient int hash;
    private static long nextID = 0;

    public Serializable(String name) {
        this.name = name;
        synchronized (Serializable.class) {
            id = nextID++;
        }
    }
    
     public String toString() {
        return name+" "+id+" "+hashSet+" "+hash+" "+nextID;
    }
    
}

public class Serialization {

    public static void serialize(String outFile, Object serializableObject)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(outFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(serializableObject);
    }

    public static Object deSerialize(String serializedObject)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(serializedObject);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }

    public static void main(String args[]) throws Exception {
        Serializable sc1 = new Serializable(("a"));
        Serializable sc3 = new Serializable(("b"));
        Serialization.serialize("D:\\workspace_nb\\Java4th\\inout\\file.ser", sc1);
        Serializable sc2 = (Serializable) Serialization.deSerialize("D:\\workspace_nb\\Java4th\\inout\\file.ser");
        System.out.println(sc1.toString());
        System.out.println(sc2.toString());
        System.out.println(sc1.equals(sc2));
    }
}
