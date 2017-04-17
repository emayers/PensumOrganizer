package com.pensumorganizer.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pensumorganizer.dao.Course;

public class TrialDataSetter {
	private static List<Course> coursesProgram;
	
	public static List<Course> getCoursesProgram() {
		coursesProgram = new ArrayList<Course>();
		setData();
		return coursesProgram;
	}

	public static void setCoursesProgram(List<Course> coursesProgram) {
		TrialDataSetter.coursesProgram = coursesProgram;
	}

	private static void addCourse(String courseID, String[] preqID, boolean preqTaken,
			boolean courseTaken, int credits, int idealTrimestrer, 
			String name, Integer trimesterTaken){
		Course course = new Course();
		
		course.setId(courseID);
		course.setPreqID(Arrays.asList(preqID));
		course.setPreqTaken(preqTaken);
		course.setTaken(courseTaken);
		course.setCredits(credits);
		course.setIdealTrimestrer(idealTrimestrer);
		course.setName(name);
		course.setTrimesterTaken(trimesterTaken);
		
		coursesProgram.add(course);
	}
		
	private static void setData(){
		addCourse("MAT1", new String[] {}, true, true, 5, 1, "Algebra y Geometria Analitica", 1);
		addCourse("LEN1", new String[] {}, true, true, 4, 1, "Comunicacion en Lengua Española I", 1);
		addCourse("ORI", new String[] {}, true, true, 2, 1, "Orientacion Academica e Institucional", 1);
		addCourse("ELE1", new String[] {}, true, true, 4, 1, "Electiva de Arte y Deporte", 1);
		addCourse("ING1", new String[] {}, true, false, 4, 1, "Ingles I", null);
		
		addCourse("LEN2", new String[] {"LEN1"}, true, false, 4, 2, "Comunicacion en Lengua Española II", null);
		addCourse("QUEH", new String[] {}, true, true, 4, 2, "Quehacer Cientifico", 2);
		addCourse("MAT2", new String[] {"MAT1"}, true, false, 5, 2, "Calculo Diferencial", null);
		addCourse("ELE2", new String[] {}, true, false, 2, 2, "Electiva Medio-Ambiental", null);
		addCourse("ING2", new String[] {"ING1"}, false, false, 4, 2, "Ingles II", null);
		
		addCourse("MAT3", new String[] {"MAT2"}, false, false, 5, 3, "test", null);
		addCourse("INTRO", new String[] {}, true, false, 3, 3, "test", null);
		addCourse("FUND", new String[] {"MAT2"}, false, false, 5, 3, "test", null);
		addCourse("ELE3", new String[] {}, true, true, 4, 3, "test", 2);
		
		addCourse("FIS1", new String[] {"MAT3"}, false, false, 5, 4, "test", null);
		addCourse("MAT4", new String[] {"MAT3"}, false, false, 5, 4, "test", null);
		addCourse("GRAF", new String[] {}, true, true, 4, 4, "test", 2);
		addCourse("LOG", new String[] {"FUND"}, false, false, 5, 4, "test", null);
		
		addCourse("MAT5", new String[] {"MAT4"}, false, false, 5, 5, "test", null);
		addCourse("TECO", new String[] {"LOG"}, false, false, 5, 5, "test", null);
		addCourse("FIS2", new String[] {"FIS1"}, false, false, 5, 5, "test", null);
		addCourse("PROB", new String[] {"MAT3"}, false, false, 4, 5, "test", null);
		
		addCourse("FIS3", new String[] {"FIS2"}, false, false, 5, 6, "test", null);
		addCourse("MAT6", new String[] {"MAT5"}, false, false, 5, 6, "test", null);
		addCourse("INVES", new String[] {"QUEH", "PROB"}, false, false, 3, 6, "test", null);
		addCourse("ALGO", new String[] {"TECO"}, false, false, 5, 6, "test", null);
		
		addCourse("DIS1", new String[] {"MAT5"}, false, false, 4, 7, "test", null);
		addCourse("CONT", new String[] {}, true, false, 4, 7, "test", null);
		addCourse("BAS1", new String[] {"ALGO"}, false, false, 4, 7, "test", null);
		addCourse("ELE4", new String[] {}, true, false, 4, 7, "test", null);
		
		addCourse("DIS2", new String[] {"DIS1"}, false, false, 4, 8, "test", null);
		addCourse("SIS", new String[] {"DIS1", "LOG"}, false, false, 5, 8, "test", null);
		addCourse("ARQC", new String[] {"FIS3"}, false, false, 4, 8, "test", null);
		addCourse("COMU", new String[] {}, true, false, 4, 8, "test", null);
		
		addCourse("INFE", new String[] {"PROB"}, false, false, 4, 9, "test", null);
		addCourse("CONST", new String[] {"ALGO"}, false, false, 5, 9, "test", null);
		addCourse("TEC", new String[] {"TECO"}, false, false, 5, 9, "test", null);
		addCourse("INCO", new String[] {"PROB"}, false, false, 4, 9, "test", null);
		
		addCourse("DIS", new String[] {"CONST"}, false, false, 5, 10, "test", null);
		addCourse("SQA", new String[] {"TEC"}, false, false, 5, 10, "test", null);
		addCourse("PROC", new String[] {"TEC"}, false, false, 4, 10, "test", null);
		addCourse("FORM", new String[] {"INCO"}, false, false, 4, 10, "test", null);
		
		addCourse("ETIC", new String[] {}, true, false, 2, 11, "test", null);
		addCourse("PRAC", new String[] {}, true, false, 2, 11, "test", null);
		addCourse("ARQS", new String[] {"DIS"}, false, false, 4, 11, "test", null);
		addCourse("REQU", new String[] {"SQA"}, false, false, 5, 11, "test", null);
		addCourse("GEST", new String[] {"FORM"}, false, false, 4, 11, "test", null);
		
		addCourse("ECON", new String[] {"INCO"}, false, false, 4, 12, "test", null);
		addCourse("PRO1", new String[] {"GEST"}, false, false, 5, 12, "test", null);
		addCourse("INFH", new String[] {"TEC"}, false, false, 4, 12, "test", null);
		addCourse("ELP1", new String[] {}, true, false, 4, 12, "test", null);
		
		addCourse("ADMN", new String[] {}, true, false, 4, 13, "test", null);
		addCourse("PRO2", new String[] {"PRO1"}, false, false, 5, 13, "test", null);
		addCourse("ELP2", new String[] {}, true, false, 4, 13, "test", null);
		addCourse("ELP3", new String[] {}, true, false, 4, 13, "test", null);
		
		addCourse("PRO3", new String[] {"PRO2"}, false, false, 5, 14, "test", null);
		addCourse("ELP4", new String[] {}, true, false, 4, 14, "test", null);
		addCourse("ELP5", new String[] {}, true, false, 4, 14, "test", null);
		addCourse("ELP6", new String[] {}, true, false, 4, 14, "test", null);
	}
}
