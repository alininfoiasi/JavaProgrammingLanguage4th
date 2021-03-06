package ch1;


public abstract class AbstractClass {
	// use abstract classes to define a default behavior and let the specialization behavior to be implemented by subclasses
	// use abstract classes also to create hierarchies (but only single inheritance)
	// offers generic functionality and serves as a template 
	
	// 1. abstract classes can contain "public, protected or private" and "instance and class" members
	// 2. adding new features only by modifying the abstract class code 
	// 3. uses "implements"
	// 4. cannot be instantiated
	// 5. the constructor is automatically called when a non-abstract subclass is instantiated
	// 6. cannot have "static, final, synchronized, native, or strict" methods
	
	
	/* Return the value associated with the name, or
	 * null if there is no such value */
	public abstract Object find(String name);
	public Object find_me(String name){
		return null;
	}
	
}