import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
//imports

/*
 * This class will to compute Catalan Numbers recursevly 
 * 
 * @author Denys Ladden
 * @version Oct 26, 2019
 * Recursion Project
 * Fall 2019
 */
public class CatalanRecursive {

	private static int n;//varibale for Catalan number calculation
	
	private static double sTime;//start time of the duration of the calc
	private static double eTime;//end time of the calc
	private static double fTime;//variable for the time of the calc
	
	private static Scanner sc = new Scanner(System.in);//scanner input for user
	private static int result;//variable for the reslut of the Catalan number calulation
	
	
	/*
	 * enter N menthod prompts user to intput N
	 */
	public static void enterN(){
		result = 0;
		System.out.print("Enter an integer value for N: ");
		if(sc.hasNextBigInteger()) {
			n = sc.nextInt();
		}else {
			System.out.print("Invalid Entery, please try agin: Y/N ");
			if(sc.next().equalsIgnoreCase("y")) {
				enterN();
			}
		}
		
	}//end N
	
	
	/*
	 * The Calc mathod takes in the value n provided by the user and calulates the Catalan numbear recursevly
	 */
	public static int calc(int n) {
		
		int value = 0;
		if(n <= 1) {
			return 1;
		}
		for(int i = 0; i < n; i++) {
			value += calc(i) * calc(n-(i+1));
		}//end for
		return value;
		
	}//end CALC
	
	/*
	 * Master Method that calcultes the time and outputs the calulation in appropriate format
	 */
	public static void master() {
		
		enterN();
		sTime = System.nanoTime();
		result = calc(n);
		eTime = System.nanoTime();
		fTime = ((eTime - sTime)/1000000000);
		
		if(fTime < 1) {
			fTime = 1;
		}//if
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
			System.out.print("Catalan Numbers Recursive End");
			
		}
		
	}//end restart
	
	public static void main(String[] args) {
		master();
	}
	
	
	
	
}//end class
	

