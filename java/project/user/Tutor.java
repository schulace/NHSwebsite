package project.user;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;
import project.studyGuide.Review;
import project.studyGuide.TutorReview;

public class Tutor extends User
{
	private ArrayList<SchoolClass> strongClasses;
	private ArrayList<TutorReview> reviews;
	
	public Tutor(String name, int year, int month, int date, int grade, String gender)
	{
		super(name, year, month, date, grade, gender);
	}
	
	public boolean addStrongClass(SchoolClass newClass)
	{
		for(SchoolClass c:this.strongClasses)
		{
			if(c.equals(newClass)) 
			{
				return false;
			}
		}
		strongClasses.add(newClass);
		return true;	
	}
	
	public void addReview(TutorReview re)
	{
		for(TutorReview r: this.reviews)
		{
			if(re.getStudent().equals(r.getStudent()));
			{
				return;
			}
		}
		reviews.add(re);
	}
}
