package test_data;

import project.user.Student;
import project.user.Tutor;

public class test_user
{
	public static Student Idontknow = new Student(test_schedules.getStudent1Schedule(),"newStudent", 10);
	public static Tutor newTut = new Tutor(test_schedules.getStudent2Schedule(), "newTutor", 12);
}
