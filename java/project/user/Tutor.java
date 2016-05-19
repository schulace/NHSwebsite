package project.user;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;

public class Tutor extends User
{
	private float rating;
	private float stars; 
	private String review;
	private ArrayList<SchoolClass> strongClasses;
	private	float studentRating = -1;
	private float teacherRating = -1;
	private boolean isShady = false;
	
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
	
	public void setShady() //if the review is flagged as not being relevant to the tutor
	{
		isShady = true;
	}
	
	public void studentReview(int score, String comment)
	{
		if(comment.contains("fuck") || comment.contains("shit") || comment.contains("bitch") || comment.contains("piss") || comment.contains("dick") || comment.contains("cock") || comment.contains("pussy") || comment.contains("asshole") || comment.contains("fag") || comment.contains("bastard") || comment.contains("slut") || comment.contains("douche"))
		{
			return;
		}
		
		else 
		{
			this.review = comment;
		}
		
		if (score <= 10 && score >=0 )
		{
			setStudentRating(score);
		}
	}
	
	public void teacherReview(int score, String comment)
	{
		if(comment.contains("fuck") || comment.contains("shit") || comment.contains("bitch") || comment.contains("piss") || comment.contains("dick") || comment.contains("cock") || comment.contains("pussy") || comment.contains("asshole") || comment.contains("fag") || comment.contains("bastard") || comment.contains("slut") || comment.contains("douche"))
		{
			return;
		}
		
		else 
		{
			this.review = comment;
		}
		
		if (score <= 10 && score >=0 )
		{
			setTeacherRating(score);
		}
	}
	
	public float setStudentRating(int score)
	{
		if (score <= 10 && score >=0 )
		{
			if(this.rating != -1)
			{
				setStudentAvg(score);
			}
			else 
			{
				this.studentRating = score;
				
			}
			setRating();
			return this.studentRating;
		}
		return -1;
	}
	
	public float setTeacherRating(int score)
	{
		if (score <= 10 && score >=0 )
		{
			if(this.rating != -1)
			{
				setTeacherAvg(score);
			}
			else 
			{
				this.teacherRating = score;
			}
			setRating();
			return this.teacherRating;
		}
		return -1;
	}
	
	public void setStudentAvg(int score)
	{
		this.studentRating = (float)(this.studentRating + score) / 2; 
	}
	
	public void setTeacherAvg(int score)
	{
		this.teacherRating = (float)(this.teacherRating + score) / 2; 
	}
	
	public void setRating()
	{
		if (this.teacherRating == -1)
		{
			this.rating = this.studentRating;
		}
		else if (this.studentRating == -1)
		{
			this.rating = this.teacherRating;
		}
		else
		{
			this.rating = (this.studentRating + this.teacherRating) / 2;
		}
		setStar();
	}
	
	public void setStar()
	{
		this.stars = (float)this.rating/2;
	}
}
