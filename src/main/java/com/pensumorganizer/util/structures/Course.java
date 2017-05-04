package com.pensumorganizer.util.structures;

import java.util.List;

public class Course {
	private String name, id, trimesterDescription, grade;
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getHistYear() {
		return yearTaken;
	}

	public void setHistYear(int histYear) {
		this.yearTaken = histYear;
	}

	private List<String> preqID, coReqID;
	private boolean preqTaken, taken, coReqTaken, creditsReqReached, approved;
	private int creditsReq, credits, idealTrimestrer, weight, term, reorganizationTrimester, yearTaken;
	private Integer trimesterTaken;
	
	public Course(){
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getPreqID() {
		return preqID;
	}

	public void setPreqID(List<String> preqID) {
		this.preqID = preqID;
	}

	public List<String> getCoReqID() {
		return coReqID;
	}

	public void setCoReqID(List<String> coReqID) {
		this.coReqID = coReqID;
	}

	public boolean isPreqTaken() {
		return preqTaken;
	}

	public void setPreqTaken(boolean preqTaken) {
		this.preqTaken = preqTaken;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public boolean isCoReqTaken() {
		return coReqTaken;
	}

	public void setCoReqTaken(boolean coReqTaken) {
		this.coReqTaken = coReqTaken;
	}

	public boolean isCreditsReqReached() {
		return creditsReqReached;
	}

	public void setCreditsReqReached(boolean creditsReqReached) {
		this.creditsReqReached = creditsReqReached;
	}

	public int getCreditsReq() {
		return creditsReq;
	}

	public void setCreditsReq(int creditsReq) {
		this.creditsReq = creditsReq;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getIdealTrimestrer() {
		return idealTrimestrer;
	}

	public void setIdealTrimestrer(int idealTrimestrer) {
		this.idealTrimestrer = idealTrimestrer;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Integer getTrimesterTaken() {
		return trimesterTaken;
	}

	public void setTrimesterTaken(Integer trimesterTaken) {
		this.trimesterTaken = trimesterTaken;
	}
	
	//Termino (1-4) y descripción de los trimestres, numero de trimestre
	public void setTerm(int term){
		this.term=term;
	}
	
	public int getTerm(){
		return this.term;
	}
	
	public void setTrimesterDescription(String desc){
		this.trimesterDescription=desc;
	}
	
	public String getTrimesterDescription(){
		return this.trimesterDescription;
	}

	public int getTrimNum() {
		return reorganizationTrimester;
	}

	public void setTrimNum(int trimNum) {
		this.reorganizationTrimester = trimNum;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
}
