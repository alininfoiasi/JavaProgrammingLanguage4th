package extra.io;

import java.io.*;

class A1 implements Serializable {
	int x = 1;
}

class A2 implements Serializable {
	int y = 2;
}

class A3 implements Serializable {
	A1 a1 = new A1();
	A2 a2 = new A2();
	public String toString(){
		return a1.x + ", " + a2.y; 
	}
}

public class ComplexClone {
	public static Object clone(Object obj){
		Object clone = null;
		try{
			// save the object 
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream ous = new ObjectOutputStream(baos);
			ous.writeObject(obj);
			ous.close();
			// create a clone of the saved object
			byte[] buffer = baos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
			ObjectInputStream ois = new ObjectInputStream(bais);
			clone = ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clone;
	}
	
	public static void main(String args[]){
		A3 a3 = (A3) ComplexClone.clone(new A3());
		System.out.println("a3: " + a3.toString());
	}
}
