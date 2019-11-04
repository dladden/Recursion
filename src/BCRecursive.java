import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
//imports

/*
 * This class will to compute Binomial Coefficient recursevly 
 * 
 * @author Denys Ladden
 * @version Oct 26, 2019
 * Recursion Project
 * Fall 2019
 */

public class BCRecursive {

	private static int n;//variable for n
	private static int k;//varibale for k
	private static double sTime;//start time of the duration of the calc
	private static double eTime;//end time of the calc
	private static double fTime;//variable for the time of the calc
	
	private static Scanner sc = new Scanner(System.in);//scanner input for user
	private static int result;//variable for the reslut of the Bionomial Coeficient
	
	
	/*
	 * enter N menthod prompts user to intput N
	 */
	public static void enterN(){
		System.out.print("Enter an integer value for N: ");
		if(sc.hasNextBigInteger()) {
			n = sc.nextInt();
			enterK();
		}else {
			System.out.print("Invalid Entery, please try agin: Y/N ");
			if(sc.next().equalsIgnoreCase("y")) {
				enterN();
			}
		}
		
	}//end N
	
	/*
	 * EnterK takes the input from the user for value k and makes sure it is less then N 
	 */
	public static void enterK() {
		System.out.print("Enter an integer value for K: ");
		if(sc.hasNextInt()) {
			k = sc.nextInt();
		if(k > n) {
			System.out.print("Invalid Integer value for K, try agin: Y/N ");
			if(sc.next().equalsIgnoreCase("y")) {
				enterK();
			}
		}
		}//if
		else {
			System.out.print("Invalid Entery, please try agin: Y/N ");
			if(sc.next().equalsIgnoreCase("y")) {
				enterK();
			}
		}//else
		
	}//end K
	
	/*
	 * 
	 */
	public static void calc(int n, int k) {
		if ((n == k ) || (k == 0)) {
			result++;
		
		}
		else {
			calc(n-1, k);
			calc(n-1, k-1);
		}
	}//end CALC
	
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
		}//if
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
	}//catch ex
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
	
	public static void main(String[] args) {
		master();
	}
	
	
	
	
}//end class
