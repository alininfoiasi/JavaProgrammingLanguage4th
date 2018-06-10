package extra.reflection;

import java.lang.reflect.*;
import java.lang.ClassLoader;
import java.net.URLClassLoader;
import java.util.*;
import java.io.*;

public class MyReflection {
	private static final int DIMENSION = 10;
	private static double myData[];
	static{
		myData = new double[DIMENSION];
		for(int i=0;i<DIMENSION;i++){
			myData[i] = Math.random();
		}
	}
	public static void run1(String fileName){
		BufferedReader br = null;
		String myFunctionImplementation;
		try{
			// 
			URLClassLoader myLoader = (URLClassLoader) MyReflection.class.getClassLoader();
			for (int i=0; i<myLoader.getURLs().length; i++){
				System.out.println(myLoader.getURLs()[i]);
			}
			// read class name
			br = new BufferedReader(new FileReader(fileName));
			myFunctionImplementation = br.readLine();
			// load class
			Class myClass = Class.forName(myFunctionImplementation);
			// create an object instance
			Object myObject = myClass.newInstance();
			// get the field that has to be initialized
			Field myField = myClass.getField("data");
			// set/initialize the field
			myField.set(myObject, myData);
			// call a specific function
			Method myMethod = myClass.getMethod("getMax", null);
			Double result = (Double) myMethod.invoke(myObject, null);
			System.out.println("result:"+result);
		} catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(br!=null){
					br.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void run2(String fileName){
		BufferedReader br = null;
		String myFunctionImplementation;
		try{
			// 
			URLClassLoader myLoader = (URLClassLoader) MyReflection.class.getClassLoader();
			for (int i=0; i<myLoader.getURLs().length; i++){
				System.out.println(myLoader.getURLs()[i]);
			}
			// read class name
			br = new BufferedReader(new FileReader(fileName));
			myFunctionImplementation = br.readLine();
			// load class
			Class myClass = Class.forName(myFunctionImplementation);
			// create an object instance
			Object myObject = myClass.newInstance();
			// get the field that has to be initialized
			Field myField = myClass.getField("data");
			// set/initialize the field
			myField.set(myObject, myData);
			// specify the method parameters
			Class<? extends Number>[] myMethodArgs = new Class[2];
			myMethodArgs[0] = Integer.TYPE;
			myMethodArgs[1] = Integer.TYPE;
			// call a specific function
			Method myMethod = myClass.getMethod("getPartialSum", myMethodArgs);
			Double result = (Double) myMethod.invoke(myObject, new Integer(1), new Integer(3));
			System.out.println("result:"+result);
		} catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(br!=null){
					br.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		MyReflection.run2("inout/MyClassName.txt");
	}
}
