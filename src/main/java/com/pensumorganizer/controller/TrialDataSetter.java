package com.pensumorganizer.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrialDataSetter {
	static List<Course> coursesProgram = new ArrayList<Course>();
	
	private static void addCourse(String courseID, String[] preqID, boolean preqTaken,
			boolean courseTaken, int credits, int idealTrimestrer){
		Course course = new Course();
		
		course.setId(courseID);
		course.setPreqID(Arrays.asList(preqID));
		course.setPreqTaken(preqTaken);
		course.setTaken(courseTaken);
		course.setCredits(credits);
		course.setIdealTrimestrer(idealTrimestrer);
		
		coursesProgram.add(course);
	}
		
	public void setData(){
		addCourse("MAT1", new String[] {}, true, true, 5, 1);
		addCourse("LEN1", new String[] {}, true, true, 4, 1);
		addCourse("ORI", new String[] {}, true, true, 2, 1);
		addCourse("ELE1", new String[] {}, true, true, 4, 1);
		addCourse("ING1", new String[] {}, true, false, 4, 1);
		
		addCourse("LEN2", new String[] {"LEN1"}, true, false, 4, 2);
		addCourse("QUEH", new String[] {}, true, true, 4, 2);
		addCourse("MAT2", new String[] {"MAT1"}, true, false, 5, 2);
		addCourse("ELE2", new String[] {}, true, false, 2, 2);
		addCourse("ING2", new String[] {"ING1"}, false, false, 4, 2);
		
		addCourse("MAT3", new String[] {"MAT2"}, false, false, 5, 3);
		addCourse("INTRO", new String[] {}, true, false, 3, 3);
		addCourse("FUND", new String[] {"MAT2"}, false, false, 5, 3);
		addCourse("ELE3", new String[] {}, true, true, 4, 3);
		
		addCourse("FIS1", new String[] {"MAT3"}, false, false, 5, 4);
		addCourse("MAT4", new String[] {"MAT3"}, false, false, 5, 4);
		addCourse("GRAF", new String[] {}, true, true, 4, 4);
		addCourse("LOG", new String[] {"FUND"}, false, false, 5, 4);
		
		addCourse("MAT5", new String[] {"MAT4"}, false, false, 5, 5);
		addCourse("TECO", new String[] {"LOG"}, false, false, 5, 5);
		addCourse("FIS2", new String[] {"FIS1"}, false, false, 5, 5);
		addCourse("PROB", new String[] {"MAT3"}, false, false, 4, 5);
		
		addCourse("FIS3", new String[] {"FIS2"}, false, false, 5, 6);
		addCourse("MAT6", new String[] {"MAT5"}, false, false, 5, 6);
		addCourse("INVES", new String[] {"QUEH", "PROB"}, false, false, 3, 6);
		addCourse("ALGO", new String[] {"TECO"}, false, false, 5, 6);
		
		addCourse("DIS1", new String[] {"MAT5"}, false, false, 4, 7);
		addCourse("CONT", new String[] {}, true, false, 4, 7);
		addCourse("BAS1", new String[] {"ALGO"}, false, false, 4, 7);
		addCourse("ELE4", new String[] {}, true, false, 4, 7);
		
		addCourse("DIS2", new String[] {"DIS1"}, false, false, 4, 8);
		addCourse("SIS", new String[] {"DIS1", "LOG"}, false, false, 5, 8);
		addCourse("ARQC", new String[] {"FIS3"}, false, false, 4, 8);
		addCourse("COMU", new String[] {}, true, false, 4, 8);
		
		addCourse("INFE", new String[] {"PROB"}, false, false, 4, 9);
		addCourse("CONST", new String[] {"ALGO"}, false, false, 5, 9);
		addCourse("TEC", new String[] {"TECO"}, false, false, 5, 9);
		addCourse("INCO", new String[] {"PROB"}, false, false, 4, 9);
		
		addCourse("DIS", new String[] {"CONST"}, false, false, 5, 10);
		addCourse("SQA", new String[] {"TEC"}, false, false, 5, 10);
		addCourse("PROC", new String[] {"TEC"}, false, false, 4, 10);
		addCourse("FORM", new String[] {"INCO"}, false, false, 4, 10);
		
		addCourse("ETIC", new String[] {}, true, false, 2, 11);
		addCourse("PRAC", new String[] {}, true, false, 2, 11);
		addCourse("ARQS", new String[] {"DIS"}, false, false, 4, 11);
		addCourse("REQU", new String[] {"SQA"}, false, false, 5, 11);
		addCourse("GEST", new String[] {"FORM"}, false, false, 4, 11);
		
		addCourse("ECON", new String[] {"INCO"}, false, false, 4, 12);
		addCourse("PRO1", new String[] {"GEST"}, false, false, 5, 12);
		addCourse("INFH", new String[] {"TEC"}, false, false, 4, 12);
		addCourse("ELP1", new String[] {}, true, false, 4, 12);
		
		addCourse("ADMN", new String[] {}, true, false, 4, 13);
		addCourse("PRO2", new String[] {"PRO1"}, false, false, 5, 13);
		addCourse("ELP2", new String[] {}, true, false, 4, 13);
		addCourse("ELP3", new String[] {}, true, false, 4, 13);
		
		addCourse("PRO3", new String[] {"PRO2"}, false, false, 5, 14);
		addCourse("ELP4", new String[] {}, true, false, 4, 14);
		addCourse("ELP5", new String[] {}, true, false, 4, 14);
		addCourse("ELP6", new String[] {}, true, false, 4, 14);
	}
}
