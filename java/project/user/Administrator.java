package project.user;

import java.util.ArrayList;

import project.serverLogic.userFactory;
import project.studyGuide.StudyGuide;
import project.studyGuide.TutorReview;

public class Administrator extends User
{
	private String name;
	private String school;
	private ArrayList<StudyGuide> profaneStudyGuides;
	private userFactory master;
	private ArrayList<Tutor> badboyzbadboyz;
	
	public Administrator(String name)
	{
		super(name);
		updateList();
	}
	
	public void updateList()
	{
		master.updateList();
		profaneStudyGuides = userFactory.getProfaneGuides();
		badboyzbadboyz = userFactory.badBoyz;
	}
	
	public void rateTutor(Tutor placeholder, int score, String review)
	{
		placeholder.addReview(new TutorReview(placeholder,this, score, review));
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
