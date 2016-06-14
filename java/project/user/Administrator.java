package project.user;

import java.util.ArrayList;

import project.serverLogic.userFactory;
import project.studyGuide.StudyGuide;
import project.studyGuide.TutorReview;

public class Administrator extends User
{
	private String school;
	private ArrayList<StudyGuide> profaneStudyGuides;
	private ArrayList<Tutor> badboyzbadboyz;
	
	public Administrator(String name)
	{
		super(name);
		updateList();
	}
	
	public void updateList()
	{
		userFactory.updateList();
		profaneStudyGuides = userFactory.getProfaneGuides();
		badboyzbadboyz = userFactory.badBoyz;
	}
	
	public void rateTutor(Tutor placeholder, int score, String review)
	{
		placeholder.addReview(new TutorReview(placeholder,this, score, review));
	}
	
	public void removeStudent(Student s)
	{
		userFactory.removeStudent(s);
	}
	
	public void removeTeacher(Teacher Meyers)
	{
		userFactory.removeTeacher(Meyers);
	}
	
	public void removeTutor(Tutor t)
	{
		userFactory.removeTutor(t);
	}
	
	public void removeAdministrator(Administrator a)
	{
		userFactory.removeAdministrator(a);
	}
	
	public void removeMyself(){
		userFactory.removeAdministrator(this);
	}
	
	public void logIn()
	{
		this.updateList();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSchool()
	{
		return school;
	}
	
	public void setSchool(String school)
	{
		this.school = school;
	}
}
