/**
 * 
 */
package com.pensumorganizer.controller;

public enum Trimester {

	AGO_OCT {
		public int number() {
			return 1;
		}

		public String description() {
			return "Agosto - Octubre";
		}

	},

	NOV_ENE {

		public int number() {
			return 2;
		}

		public String description() {
			return "Noviembre - Enero";
		}

	},

	FEB_ABR {
		public int number() {
			return 3;
		}

		public String description() {
			return "Febrero - Abril";
		}
	},

	MAY_JUL {

		public int number() {
			return 4;
		}

		public String description() {
			return "Mayo - Julio";
		}

	};

	public abstract String description();

	public abstract int number();

	public String getTrimester(int trimester) {

		switch (trimester) {

		case 1:
			AGO_OCT.description();
		case 2:
			NOV_ENE.description();
		case 3:
			FEB_ABR.description();
		case 4:
			MAY_JUL.description();
		default:
			return null;

		}

	}

	public static Trimester getTrimesterName(String trimester) {
		
		trimester.toUpperCase();
		
		if(trimester.equals("AGO - OCT"))
			return AGO_OCT;
		else if(trimester.equals("NOV - ENE"))
			return NOV_ENE;
		else if(trimester.equals("FEB - ABR"))
			return FEB_ABR;
		else if(trimester.equals("MAY - JUL"))
			return MAY_JUL;
		else
			return null;
	}
	

	public static Trimester getTrimesterID(int trimester) {

		switch (trimester) {

		case 1:
			return AGO_OCT;
		case 2:
			return NOV_ENE;
		case 3:
			return FEB_ABR;
		case 4:
			return MAY_JUL;
		default:
			return null;
		}

	}

}
