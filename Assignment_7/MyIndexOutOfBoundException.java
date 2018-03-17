package Assignment_7;

import java.io.IOException;

public class MyIndexOutOfBoundException {
	public final int lowerBound = 0;
	public final int upperBound = 10;
	private int index;
	
	public void MyIndexOutOfBoundException(int input)throws IndexOutOfBoundsException{
		if(input < lowerBound){
			lowerBoundException lowerBoundException = new lowerBoundException(lowerBound, input);
			throw lowerBoundException;
		}else if(input > upperBound){
			upperBoundException  upperBoundException = new upperBoundException (upperBound , input);
			throw upperBoundException;
		}else {
			this.index = input;
			System.out.println("Passed test! input = " + input);
		}
	}
	

	class lowerBoundException extends IndexOutOfBoundsException{
		int lowerBound; 
		int inputIndex;
		public lowerBoundException (int lower, int input){
			this.lowerBound = lower;
			this.inputIndex = input;
			
		}
		public String toString(){
			return "Implement parameter (" + inputIndex + ") is lower than lower bound " + "(lower bound is " + lowerBound+ ")";
		}
	}
	
	class upperBoundException extends IndexOutOfBoundsException{
		int upperBound; 
		int inputIndex;
		public upperBoundException (int upper, int input){
			this.upperBound = upper;
			this.inputIndex = input;
		}
		public String toString(){
			return "Implement parameter (" + inputIndex + ") is higher than upper bound "+"(upper bound is " + upperBound+ ")";
		}
	}

	
}
