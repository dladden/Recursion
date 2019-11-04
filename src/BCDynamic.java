import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
//imports
/*
 * This class will compute Bionomial Coefficient with Dynamic Programing 
 * 
 * @author Denys Ladden
 * @version Oct 26, 2019
 * Recursion Project
 * Fall 2019
 */
public class BCDynamic {

	private static int k;//variable for number of outcomes for Bionomial Coefficient
	private static int n;//variable for number of posibilities for Bionomial Coefficient 
	private static int array[];//array to store the prevous values! 
	private static double sTime;//start time of the duration of the calc
	private static double eTime;//end time of the calc
	private static double fTime;//variable for the time of the calc
	
	
	private static Scanner sc = new Scanner(System.in);//scanner input for user
	private static int result;//variable for the reslut of the Bionomial Coeficient
	
	/*
	 * Enter N method will take in the value from the user
	 */
	public static void enterN() {
		result = 0;
		System.out.print("Enter an integer value for N: ");
		if(sc.hasNextInt()) {
			n = sc.nextInt();
			enterK();
		}//if
		else {
			System.out.print("Invalid Entery, please try agin: Y/N ");
			if(sc.next().equalsIgnoreCase("y")) {
				enterN();
			}
		}
		
	}//enter N end 
		
	/*
	 * Enter K method will take the value for k from the user
	 */
	public static void enterK(){
		
		System.out.print("Enter an integer value for K: ");
		if(sc.hasNextInt()) {
			k = sc.nextInt();
			if(k > n) {
				System.out.println("Invalid Value for K try again: Y/N ");
				enterK();
			}
		}//if
		else {
			System.out.print("Invalid Entery, please try agin: Y/N ");
			if(sc.next().equalsIgnoreCase("y")) {
				enterK();
			}
		}
		
	}//end K
	
	/*
	 * Calulation method takes the values of K and N to compute combinatorial number and store it in the result
	 */
	public static void calc(int n, int k) {
		
		array = new int [k + 1];
		array[0] = 1;
		for(int i = 1; i <= k; i++ ) {
			array[i] = 0;
		}
		for(int i = 1; i <= n; i++ ) {
			for(int x = Math.min(i, k); x > 0; x--)
			array[x] = array[x] + array[x-1];
			
		}//for
		result = array[k];
				
	}//end clac
	
	
/*
 * Master Method that calcultes the time and outputs the calulation in appropriate format	
 */
public static void master() {
	
		enterN();
		sTime = System.nanoTime();
		calc(n, k);
		eTime = System.nanoTime();
		fTime = ((eTime - sTime)/1000000000);
		
		if(fTime < 1) {
			fTime = 1;
			}
		
		System.out.println("There are "+result+ " to choose subsets of "+k+" from "+n+" items");	
			toText();
			restart();
		
			
			
			
		}//end master

/*
 * Method taht will out put the date into a file located in the eclipse workspace
 */
public static void toText() {
	try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("BCRecursionFile.txt", true));
		writer.append(n+", "+k+", "+result+", "+fTime+"seconds");
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
	System.out.println("Would you like to enter K & N agin? Y/N ");
	if(sc.next().equalsIgnoreCase("y")) {
		master();
	}//end if
	else if(sc.next().equalsIgnoreCase("n")) {
		System.out.print("BC end");
		
	}
	
}//end restart


/*
 * Main apllication to excute the program
 */
public static void main(String[] args) {
	master();
	
	
}//main
	
	
	
}//end class
