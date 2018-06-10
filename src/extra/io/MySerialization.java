package extra.io;

import java.io.*;

class B implements Serializable {
	int y = 2;
}

class C implements Serializable {
	A a = new A();
	B b = new B();
	
	public String toString(){
		return a.x + ", " + b.y; 
	}
}

class D implements Serializable {
	int x = 1;
	transient int y = 2;
	transient static int z = 3;
	static int t = 4;
	
	public String toString(){
		return x + ", " + y + ", " + z + ", " + t; 
	}
}

class A {
	int x = 100;
	// no args constructor is needed to be able to serialize, because A is the superclass for E
	public A (){
	}
	
	public A (int xx){
		x = xx;
	}
}

class E extends A implements Serializable {
	int y = 0;
}

class F extends E{
	public F() {
		x = 1;
		y = 2;
	}
	public String toString(){
		return x + ", " + y; 
	}
	
}

public class MySerialization {

	public static void testSerialize1(Object obj){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			// save the given object
			fos = new FileOutputStream("inout/file.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();
			System.out.println("Saved object:" + obj.toString());
			// restore the saved object
			obj = null;
			fis = new FileInputStream("inout/file.ser");
			ois = new ObjectInputStream(fis);
			obj = ois.readObject();
			System.out.println("Restored object:" + obj.toString());
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(fos!=null) {
					fos.close();
				}
				if(oos!=null) {
					oos.close();
				}
				if(fis!=null) {
					fis.close();
				}
				if(ois!=null) {
					ois.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		//MySerialization.testSerialize1(new C());
		//MySerialization.testSerialize1(new D());
		MySerialization.testSerialize1(new F());
	}
}
