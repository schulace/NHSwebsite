package project.user;

import java.sql.Date;
import java.util.ArrayList;

import project.schedule.classes.SchoolClass;


public class Teacher extends User { //we may not even need this, but its nice to have (just in case)
	private ArrayList<SchoolClass> teachClasses;
	
	public Teacher(String n, Date d, String school, Gender g, ArrayList<SchoolClass> t){
		super(n, d, school, g);
		this.teachClasses = t;
	}

	public ArrayList<SchoolClass> getTeachClasses() {
		return teachClasses;
	}

	public void setTeachClasses(ArrayList<SchoolClass> teachClasses) {
		this.teachClasses = teachClasses;
	}
	
}
