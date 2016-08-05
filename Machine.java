/*Enigma Machine Simulation
 * Elainea Hess
 * August 2, 2016
 * 
 * This program takes a String input from a user, places it through
 * the Enigma machine and outputs the ciphered text. 
 */

import java.lang.reflect.Array;
import java.util.*;

public class Machine {
	
	//Rotors and Reflector 
	private static String[][] rot1 =
		{{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" },
		 { "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M" }};

	private static String[][] rot2 =
		{{ "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M" },
		 { "O", "Q", "S", "U", "W", "Y", "A", "C", "E", "G", "I", "K", "M", "N", "P", "R", "T", "V", "X", "Z", "B", "D", "F", "H", "J", "L" }};

	private static String[] refle1 =
		 { "C", "F", "I", "L", "O", "R", "U", "X", "A", "D", "G", "J", "M", "P", "S", "V", "Y", "B", "E", "H", "K", "N", "Q", "T", "W", "Z" };

	
	
	//Method for rotor1
	public static String rotor1(String letter){
		boolean hasLet = false; 
		for(int i = 0; i < rot1[0].length; i++){
				if(letter.equals(rot1[0][i])){
					hasLet = true; 
					//System.out.println(rot1[1][i]);
					letter = rot1[1][i];
					break; 
				} else {
					//System.out.println("Not Found"); 
				} if(hasLet){
					break; 
				}
			}
			return letter; 
		}
	
	//Method for rotor2
	public static String rotor2(String Letter){
		boolean hasLet = false; 
		for(int i = 0; i < rot2[0].length; i++){
				if(Letter.equals(rot2[0][i])){
					hasLet = true; 
					//System.out.println(rot2[1][i]); 
					Letter = rot2[1][i]; 
					break; 
				} else {
					//System.out.println("Not Found"); 
				} if(hasLet){
					break; 
				}
			}
		return Letter; 
	}
	
	//Method for reflector 
	public static String reflector1(String Letter){
		boolean hasLet = false; 
		for(int i = 0; i < rot1[1].length; i++){
				if(Letter.equals(rot2[1][i])){
					hasLet = true; 
					//System.out.println(refle1[i]); 
					Letter = refle1[i]; 
					break; 
				} else {
					//System.out.println("Not Found"); 
				} if(hasLet){
					break; 
				}
			}
		return Letter; 
	}
	
	public static String returnMes(String Letter){
		boolean hasLet = false; 
		for(int i = 0; i < rot2[1].length; i++){
			if(Letter.equals(rot2[1][i])){
				Letter = rot2[0][i];
				for(int j = 0; j < rot1[1].length; j++){
					if(Letter.equals(rot1[1][j])){
						hasLet = true; 
						//System.out.println(rot1[0][j]);
						Letter = rot1[0][j];
						break; 
					}else{
						
					}if(hasLet){
						break; 
					}
				}
			}
		}
		return Letter; 
	}
	
	public static String[] split(String message){
		String[] encr = new String[message.length()];
		for(int i=0; i<message.length();i++){
			encr[i] = message.substring(i,i+1);
		}
		return encr;
	}
	
//Application 	
	public static void main(String args[]){
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter a sentence");  
			String letter = keyboard.nextLine();
			keyboard.close();  
			
			String en = returnMes(reflector1(rotor2(rotor1(letter.toUpperCase())))); 
			System.out.println(en);
		}
}
