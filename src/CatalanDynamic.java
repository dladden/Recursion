import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//imports
/*
* This class will compute Catalan number with Dynamic Programing 
* 
* @author Denys Ladden
* @version Oct 26, 2019
* Recursion Project
* Fall 2019
*/
public class CatalanDynamic {
	
	
	private static int n;//varibale for number of expressions
	
	private static int array[];//array to store the prevous values! 
	private static double sTime;//start time of the duration of the calc
	private static double eTime;//end time of the calc
	private static double fTime;//variable for the time of the calc
	
	
	private static Scanner sc = new Scanner(System.in);//scanner input for user
	private static int result;//variable for the reslut of the Catalan number calulation
	
	/*
	 * Enter N method will take in the value from the user
	 */
	public static void enterN() {
		result = 0;
		System.out.print("Enter an integer value for N: ");
		if(sc.hasNextInt()) {
			n = sc.nextInt();
		
		}//if
		else {
			System.out.print("Invalid Entery, please try agin: Y/N ");
			if(sc.next().equalsIgnoreCase("y")) {
				enterN();
			}
		}
		
	}//enter N end 
		
	
	/*
	 * Calulation method takes the values of K and N to compute combinatorial number and store it in the result
	 */
	public static void calc(int n) {
		
		array = new int [n + 1];
		if(n > 1) {
			
	
		array[0] = 1;
		array[1] = 1;
		for(int i = 2; i <= n; i++ ) {
			array[i] = 0;
			for(int x = 0; x < i; x++) {
				array[i] += array[x] * array[i - x - 1];
			}
		}//for
		result = array[n];
		}
		else {
			result = 1;
		}
	}//end clac
	
	
/*
 * Master Method that calcultes the time and outputs the calulation in appropriate format	
 */
public static void master() {
	
		enterN();
		sTime = System.nanoTime();
		calc(n);
		eTime = System.nanoTime();
		fTime = ((eTime - sTime)/1000000000);
		
		if(fTime < 1) {
			fTime = 1;
			}
		
		System.out.println("C(" +n+ ") = " +result);	
			toText();
			restart();
		
			
		}//end master
	
/*
 * Method taht will out put the date into a file located in the eclipse workspace
 */
public static void toText() {
	try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("BCRecursionFile.txt", true));
		writer.append(n+", "+", "+result+", "+fTime+"seconds");
		writer.newLine();
		writer.close();
	} catch (IOException ex) {
		System.out.print("To Text Failed");
	}
}//end to text

/*
 * Restart method will prompt user to run the clulatin again or quit
 */
public static void restart() {
	System.out.println("Would you like to enter N agin? Y/N ");
	if(sc.next().equalsIgnoreCase("y")) {
		master();
	}//end if
	else if(sc.next().equalsIgnoreCase("n")) {
		System.out.print("Catalan Numbers Dynamic End");
		
	}
	
}//end restart


	
public static void main(String[] args) {
	master();
	
	
}//main
	
	
	
}//end class
