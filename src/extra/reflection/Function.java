package extra.reflection;

public class Function {
	public static double data[];
	
	public void setData(double input[]){
		data = new double[input.length];
		for(int i=0; i<input.length; i++){
			data[i] = input[i];
		}
	}
	
	public static double getMax(){
		double max = data[0];
		for (int i=1; i<data.length; i++){
			System.out.println(data[i]);
			if(data[i]>max){
				max = data[i];
			}
		}
		return max;
	}
	
	public static double getMin(){
		double min = data[0];
		for (int i=1; i<data.length; i++){
			System.out.println(data[i]);
			if(data[i]<min){
				min = data[i];
			}
		}
		return min;
	}
	
	public static double getPartialSum (int from, int to) throws IndexOutOfBoundsException{
		double sum = 0;
		for (int i=0; i<data.length; i++){
			System.out.println(data[i]);
		}
		System.out.println("Sum:");
		if(from>to || from<0 || to > data.length){
			throw new IndexOutOfBoundsException();
		}
		else{
			for (int i=from; i<to; i++){
				sum+=data[i];
				System.out.println(sum);
			}
		}
		return sum;
	}
	
}
