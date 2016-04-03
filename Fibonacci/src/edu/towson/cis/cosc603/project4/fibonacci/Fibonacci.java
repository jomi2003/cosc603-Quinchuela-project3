
package edu.towson.cis.cosc603.project4.fibonacci;

/**
 * The Class Fibonacci to simply calculates the nth Fibonacci number given the input n.
 */
public class Fibonacci {
	
	/**
	 * Calculates and returns the nth Fibonacci number.
	 *
	 * @param n the index
	 * @return the nth Fibonacci number
	 */
	public int fibonacci(int n) {
		
		switch (n) {
			case 0: return 0;
			case 1: return 1;
			default: return (fibonacci(n - 1) + fibonacci(n - 2));
			
	
		}
	}
	
	/* Try to use print out statements to see where the error was.
	
	public static void main (String[] args){
	Fibonacci fibonacci = new Fibonacci();
	System.out.println("for n=0, the fibonacci number is:" + fibonacci.fibonacci(0));
	System.out.println("for n=1, the fibonacci number is:" + fibonacci.fibonacci(1));
	System.out.println("for n=2, the fibonacci number is:" + fibonacci.fibonacci(2));
	System.out.println("for n=3, the fibonacci number is:" + fibonacci.fibonacci(3));
	System.out.println("for n=4, the fibonacci number is:" + fibonacci.fibonacci(4));
	System.out.println("for n=5, the fibonacci number is:" + fibonacci.fibonacci(5));
	System.out.println("for n=6, the fibonacci number is:" + fibonacci.fibonacci(6));
	System.out.println("for n=7, the fibonacci number is:" + fibonacci.fibonacci(7));
	}
	*/
}
