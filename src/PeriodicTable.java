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
 * Creates methods and stores instance variables in order to modify attributes of an array of objects of the 
 * Element class.
 *
 * @author Christopher Runyan
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PeriodicTable{
	private final int SIZE=120;
	private int elementCount=0;
	private Element[] element=null;
	private String data=null;
	private String[] elementData=new String[7];
	private Scanner inputFile=null;
	private int skip=0;
	
	/**
	 * Default constructor that creates a new array.
	 */
	public PeriodicTable(){
		element=new Element[SIZE];
	}
	
	/**
	 * Reads element data from a file and places the data in an array.
	 * @param filename: the name of the file that has the element data 
	 */
	public void readData(String filename){
		try{
			inputFile=new Scanner(new File(filename));
		}
		catch(FileNotFoundException e){
			System.out.print(e.getMessage()+"\nProgram terminated.");
			System.exit(1);
		}
		while(inputFile.hasNextLine()){
			data=inputFile.nextLine();
			elementData=data.split(",");
			if(skip>0){
				element[elementCount]=new Element(elementData);
				elementCount++;
			}
			else{
				skip++;
			}
		}
	}
	
	/**
	 * Searches through an array containing element information and returns the element with the highest boiling point.
	 * @return the information identifying and displaying data for the element on the periodic table with the highest
	 * boiling point
	 */
	public Element returnHighestBoiling(){
		Element highestBoiling=element[0];
		for(int i=0; i<elementCount; i++){
			if(element[i].getBoilingPoint()>highestBoiling.getBoilingPoint()&&element[i].getBoilingPoint()!=0){
				highestBoiling=element[i];
			}
		}
		return highestBoiling;
	}
	
	/**
	 * Searches through an array containing element information and returns the element with the lowest melting point.
	 * @return the information identifying and displaying data for the element on the periodic table with the lowest
	 * melting point
	 */
	public Element returnLowestMelting(){
		Element lowestMelting=element[0];
		for(int i=0; i<elementCount; i++){
			if(element[i].getMeltingPoint()<lowestMelting.getMeltingPoint()&&element[i].getBoilingPoint()!=0){
				lowestMelting=element[i];
			}
		}
		return lowestMelting;
	}
	
	/**
	 * Prints the element info for an element based on the chemical symbol.
	 * @param chemSymbol: the chemical symbol of the element
	 */
	public void printElementInfo(String chemSymbol){
		System.out.println(element[returnElementIndex(chemSymbol)]);
	}
	
	/**
	 * Returns the index in the array of elements of the element corresponding with a given chemical symbol.
	 * @param chemSymbol: the chemical symbol of the element
	 * @return the index of the element with the given chemical symbol
	 */
	private int returnElementIndex(String chemSymbol){
		int index=0;
		for(int i=0; i<elementCount; i++){
			if(element[i].getSymbol().equalsIgnoreCase(chemSymbol)){
				index=i;
			}
		}
		return index;
	}
	
	/**
	 * Prints the particle info for an element corresponding with a given chemical symbol.
	 * @param chemSymbol: the chemical symbol of the element
	 */
	public void printParticleInfo(String chemSymbol){
		System.out.println("Particle information for "+element[returnElementIndex(chemSymbol)].getChemicalName()+":");
		System.out.println("Number of Protons: "+element[returnElementIndex(chemSymbol)].getAtomicNumber());
		System.out.println("Number of Electrons: "+element[returnElementIndex(chemSymbol)].getAtomicNumber());
		System.out.println("Number of Neutrons: "+Math.round(element[returnElementIndex(chemSymbol)].getMolecularWeight()));
	}
	
	/**
	 * Returns the molecular mass of a given compound substance.
	 * @param substance: String array containing information for a compund substance
	 */
	public void returnMolecularMass(String[] substance){
		double mass=0;
		for(int i=0; i<substance.length; i+=2){
			System.out.print(substance[i]);
			if(!substance[i+1].equals("1")){
				System.out.print(substance[i+1]);
			}
			mass+=element[returnElementIndex(substance[i])].getMolecularWeight()*Integer.parseInt(substance[i+1]);
		}
		System.out.print(" = "+mass+" g/mole");
	}
	
	/**
	 * Validates that a given symbol corresponds with an element.
	 * @param symbol: the chemical symbol of the element
	 * @return either true or false depending on if the symbol is valid
	 */
	public boolean validateSymbol(String symbol){
		boolean valid=false;
		for(int i=0; i<elementCount; i++){
			if(symbol.equalsIgnoreCase(element[i].getSymbol())){
				valid=true;
			}
		}
		return valid;
	}
}
