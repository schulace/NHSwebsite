package project.schedule.classes;

import project.user.Teacher;

public class TutoringSession extends SchoolClass
{
	public boolean happened = false;
	
	public TutoringSession(String name, LetterDay[] days, int block, Teacher teacher)
	{
		super(name, Subject.TUTORING, days, block, teacher);
	}

}
