package m;

import java.util.Scanner;
/**
 * This class was designed as the controller of the program<br>
 * It calls the menu, ask for the user inputs and calls the correct methods.
 * @author ClinioMarcelino
 * @date 03/28/2024
 * @version 1.0
 */
public class Driver {
	
	/**
	 * Menu of options for the class Driver
	 */
	private static void menu() {
		System.out.println("\n Choose one of the numbers for an action:");
		System.out.println("----------------------------------------------------------------");
		System.out.println("1. Fill");
		System.out.println("2. Clear");
		System.out.println("3. Count Nodes");
		System.out.println("4. Count ThreeDNodes");
		System.out.println("5. Sort");
		System.out.println("6. Display");
		System.out.println("7. Exit");
		System.out.println("----------------------------------------------------------------");

		
	}
	
	/**
	 * This method was built to get the input and verify if its a number
	 * @return int, number
	 * @throws Exception
	 */
	private static int getNumber() throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		int number;
		try {
			number = Integer.parseInt(choice);
		}catch(Exception e) {
			throw new Exception("String typed is not a number");
		}
		return number;
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Nodes nd = new Nodes();
		boolean stay = true;
		int chances = 0;
		
		do {
			menu();
			int option;
			try {
				option = getNumber();
				switch(option) {
				case 1:
					System.out.println("size?");
					nd.fill(getNumber());
					break;
				case 2:
					nd.clear();
					break;
				case 3:
					System.out.println(nd.countNodes());
					break;
				case 4:
					System.out.println(nd.countThreeDNodeS());
					break;
				case 5:
					nd.sort();
					break;
				case 6:
					System.out.println(nd.toString());
					break;
				case 7:
					stay=false;
					break;
				default:
					throw new Exception();
				
				}
			}catch(Exception e){
				System.out.println("Error wrong input");
				if(++chances > 2) {
					System.out.println("Three mistakes in sequence...");
					break;
				}
				continue;
			}
			chances=0;
		}while (stay);
		
		System.out.println("Program ended");
	}

}
