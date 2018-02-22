
public class PatternTricks {
	public static void main(String args[]) {
		
		// This is to show case how to print certain patterns, like to draw a rectangle shape like below
		/*
		 *     * * * * *
		 *     * * * * *
		 *     * * * * *
		 *     
		 * */
		
		int i = 0;
		int j = 0;
		// i will be the number of rows you want to print
		for(i = 0; i < 3; i++) {
			for(j = 0; j < 5; j++) {
				System.out.print("* ");
			}
			System.out.println(""); // bring to new line
		}
		
		
		System.out.println("------------------");
		
		// for getting same rows and columns; i &j will be same
		for(i = 0; i < 3; i++) {
			for(j = 0; j < 3; j++) {
				System.out.print("* ");
			}
			System.out.println(""); // bring to new line
		}
		
		System.out.println("------------------");
		
		// Trick for building a triangular output like, use j <= i as the conditional
		//
		for(i = 0; i < 3; i++) {
			for(j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println(""); // bring to new line
		}
				
		System.out.println("------------------");
		
		// Print numbers
		/*  this combines printing row numbers 1,2,3 etc combined with above logic.
		 
		  	1 
			2 2 
			3 3 3 
		 
		 * */
		for(i = 1; i <= 3; i++) {
			for(j = 1; j <= i; j++) {
				System.out.print(i+ " ");
			}
			System.out.println(""); // bring to new line
		}
		
		// combining other smaller tricks like for i+j, if odd number print x and 
		// for even print y in a specific way can give rise to many such pattern problems
		
	}
	
}
