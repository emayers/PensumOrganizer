/**
 * 
 */
package com.pensumorganizer.controller;

public class Student {
	private String name, last_name;
	private int ID;
	private Trimester trimesterEntry;
	private int yearEntry;
	private String pensumID;
	private int pensumYear; //FIXME That's not necesary but if u see, now we have two pensums per career
	
	public Student(String name, String last_name, int iD,
			String trimesterEntry, int yearEntry, String pensumID, int pensumYear) {
		
		this.name = name;
		this.last_name = last_name;
		ID = iD;
		this.trimesterEntry = Trimester.getTrimesterName(trimesterEntry);
		this.yearEntry = yearEntry;
		this.pensumID = pensumID;
		this.pensumYear = pensumYear;
	}
	
	/*
	public static void main(String[] args) {
		Student Nicole = new Student("Nicole", "Guzman Cleto", 1060781, "AGO - OCT", 2014, "IDS", 2010);
		
		System.out.println(Nicole.trimesterEntry.description());

	}
	*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Trimester getTrimesterEntry() {
		return trimesterEntry;
	}

	public void setTrimesterEntry(Trimester trimesterEntry) {
		this.trimesterEntry = trimesterEntry;
	}

	public int getYearEntry() {
		return yearEntry;
	}

	public void setYearEntry(int yearEntry) {
		this.yearEntry = yearEntry;
	}

	public String getPensumID() {
		return pensumID;
	}

	public void setPensumID(String pensumID) {
		this.pensumID = pensumID;
	}

	public int getPensumYear() {
		return pensumYear;
	}

	public void setPensumYear(int pensumYear) {
		this.pensumYear = pensumYear;
	}
	
	
	

}