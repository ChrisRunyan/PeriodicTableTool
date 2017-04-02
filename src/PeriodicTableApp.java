/*
 * File name: Element.java
 * 
 * Programmer: Christopher Runyan
 * ULID: caruny1
 * 
 * Date: Nov 12, 2015
 * 
 * Class: IT 168
 * Lecture Section: 04
 * Lecture Instructor: Patricia Matsuda
 * Lab Section: 06
 * Lab Instructor: Minu Sabu
 */
package edu.ilstu;

/**
 * Uses main method and methods that are used in the main method, or that are used in methods used in the main method.
 *  
 * @author Christopher Runyan
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PeriodicTableApp
{	
	private PeriodicTable pTable;

	/**
	 * Includes the code for the main method.
	 */
	private void run()
	{
		Scanner kb=new Scanner(System.in);
		pTable=new PeriodicTable();
		pTable.readData("PeriodicTableData.csv");

		int choice=getChoice(kb);
		String symbol=null;
		while(choice!=6){
			if(choice==1){
				System.out.print("Enter symbol for element: ");
				symbol=kb.next();
				while(!pTable.validateSymbol(symbol)){
					System.out.print("Invalid symbol.\nEnter symbol for element: ");
					symbol=kb.next();
				}
				pTable.printElementInfo(symbol);
				System.out.println();
				choice=getChoice(kb);
			}
			if(choice==2){
				System.out.print("Enter symbol for element: ");
				symbol=kb.next();
				while(!pTable.validateSymbol(symbol)){
					System.out.print("Invalid symbol.\nEnter symbol for element: ");
					symbol=kb.next();
				}
				pTable.printParticleInfo(symbol);
				System.out.println();
				choice=getChoice(kb);
			}
			if(choice==3){
				System.out.println("Element with the highest boiling point:\n");
				System.out.println(pTable.returnHighestBoiling());
				System.out.println();
				choice=getChoice(kb);
			}
			if(choice==4){
				System.out.println("Element with the lowest melting point:\n");
				System.out.println(pTable.returnLowestMelting());
				System.out.println();
				choice=getChoice(kb);
			}
			if(choice==5){
				System.out.println("Molecular Mass calculations:\n");
				processCompoundSubstances();
				System.out.println();
				choice=getChoice(kb);
			}
		}
		System.out.print("Thank you.");

	}

	/**
	 * Accepts a scanner object, displays the menu, obtains a choice from a user input, and validates the choice.
	 * @param kb: the Scanner object obtaining data from user input
	 * @return the choice in the form of an int
	 */
	private int getChoice(Scanner kb)
	{
		int choice=0;
		System.out.println("Periodic Table Menu");
		System.out.println("\n1 - Display element information\n2 - Display particle information (# of protons, electrons, neutrons)"+
							"\n3 - Get element with highest boiling point\n4 - Get element with lowest melting point\n"+
							"5 - Display Molecular mass calculations\n6 - Quit\n");
		System.out.print("Please enter your choice: ");
		String input=kb.next();
		while(!input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5")||input.equals("6")){
			System.out.println("Invalid option entered.");
			System.out.print("Please enter your choice: ");
			input=kb.nextLine();
			if(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5")||input.equals("6")){
				choice=Integer.parseInt(input);
			}
		}
		choice=Integer.parseInt(input);
		return choice;
	}

	/**
	 * Reads element and substance data from a .txt file and uses the returnMolecularMass class to process the data
	 * and calculate the molecular mass. 
	 */
	public void processCompoundSubstances()
	{
		pTable=new PeriodicTable();
		pTable.readData("PeriodicTableData.csv");
		String data=null;
		String[] substance=new String[10];
		Scanner input=null;
		try{
			input=new Scanner(new File("MolecularWeightInput.txt"));
		}
		catch(FileNotFoundException e){
			System.out.print(e.getMessage()+"\nProgram terminated.");
			System.exit(1);
		}
		while(input.hasNextLine()){
			data=input.nextLine();
			substance=data.split(" ");
			pTable.returnMolecularMass(substance);
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		PeriodicTableApp pt=new PeriodicTableApp();
		pt.run();
	}
}
