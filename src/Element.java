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
 * Creates methods and stores variables pertaining to different elements of the periodic table. Utilized by the class
 * PeriodicTable.
 *
 * @author Christopher Runyan
 *
 */
public class Element{
	private String chemicalName;
	private int atomicNumber;
	private String symbol;
	private double boilingPoint;
	private double meltingPoint;
	private double density;
	private double molecularWeight;
	
	/**
	 * Default constructor accepting a String array containing information from one row of a .csv document.
	 * @param data: a String array containing a row of information for an element
	 */
	public Element(String[] data){
		chemicalName=data[0].substring(0, 1).toUpperCase()+data[0].substring(1, data[0].length());
		atomicNumber=Integer.parseInt(data[1]);
		symbol=data[2];
		if(!data[3].equals("")){
			boilingPoint=Double.parseDouble(data[3]);
		}
		else{
			boilingPoint=0;
		}
		if(!data[4].equals("")){
			meltingPoint=Double.parseDouble(data[4]);
		}
		else{
			meltingPoint=0;
		}
		if(!data[5].equals("")){
			density=Double.parseDouble(data[5]);
		}
		else{
			density=0;
		}
		molecularWeight=Double.parseDouble(data[6]);
	}
	
	/**
	 * Returns the value of the instance variable chemicalName.
	 * @return the name of the element
	 */
	public String getChemicalName(){
		return chemicalName;
	}
	
	/**
	 * Returns the value of the instance variable atomicNumber.
	 * @return the atomic number of the element
	 */
	public int getAtomicNumber(){
		return atomicNumber;
	}
	
	/**
	 * Returns the value of the instance variable symbol.
	 * @return the symbol of the element
	 */
	public String getSymbol(){
		return symbol;
	}
	
	/**
	 * Returns the value of the instance variable boilingPoint.
	 * @return the boiling point of the element
	 */
	public double getBoilingPoint(){
		return boilingPoint;
	}
	
	/**
	 * Returns the value of the instance variable meltingPoint.
	 * @return the melting point of the element
	 */
	public double getMeltingPoint(){
		return meltingPoint;
	}
	
	/**
	 * Returns the value of the instance variable density.
	 * @return the density of the element
	 */
	public double getDensity(){
		return density;
	}
	
	/**
	 * Returns the value of the instance variable molecularWeight.
	 * @return the molecular weight of the element 
	 */
	public double getMolecularWeight(){
		return molecularWeight;
	}
	
	//Overrides the default toString method to a formatted output.
	@Override
	public String toString(){
		return "Element name: "+chemicalName+"\nSymbol: "+symbol+"\nAtomic Number: "+atomicNumber+ "\nBoiling Point: "+
				boilingPoint+" K"+"\nMelting Point: "+meltingPoint+" K"+"\nDensity: "+density+" g/L"+ 
				"\nMolecular Weight: "+molecularWeight+" g/mole";
	}
}
