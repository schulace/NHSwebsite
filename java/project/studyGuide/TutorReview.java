/**
 * 
 * @author george
 * object for a review of the Tutor
 *
 */

package project.studyGuide;

import project.user.Student;
import project.user.Teacher;
import project.user.Tutor;

public class TutorReview 
{
	private Tutor reviewee;
	private float rating = -1;
	private float stars;
	private String review;
	private	float studentRating = -1;
	private float teacherRating = -1;
	private Teacher teacherReviewer;
	private Student studentReviewer;
	
	/**
	 * constructor for a student reviewer 
	 * @param reviewee (the tutor getting reviewed)
	 * @param su (the reviewer) 
	 * @param rating
	 * @param comment
	 */
	
	public TutorReview(Tutor reviewee,Student su, int rating, String comment) 
	{
		this.reviewee = reviewee;
		this.studentReviewer = su;
		studentReview(rating, comment);
	}
	
	/**
	 * constructor for a teacher reviewer
	 * @param reviewee (the tutor getting reviewed)
	 * @param su (the reviewer)
	 * @param rating
	 * @param comment
	 */
	
	public TutorReview(Tutor reviewee,Teacher su, int rating, String comment) 
	{
		this.reviewee = reviewee;
		this.teacherReviewer = su;
		teacherReview(rating, comment);
	}
	
	/**
	 * takes the parameters from the studentReview constructor and creates a score
	 * @param score
	 * @param comment
	 */
	
	private void studentReview(int score, String comment)
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
	
	/**
	 * takes the parameter from the teacherReview constructor and creates a score
	 * @param score
	 * @param comment
	 */
	
	private void teacherReview(int score, String comment)
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
	
	/**
	 * sets the student score
	 * @param score
	 * @return
	 */
	
	private float setStudentRating(int score)
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
	
	/**
	 * sets the teacher score 
	 * @param score
	 * @return
	 */
	
	private float setTeacherRating(int score)
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
	
	/**
	 * sets the student avg (if multiple students have already inputted review scores)
	 * @param score
	 */
	
	public void setStudentAvg(int score)
	{
		this.studentRating = (float)(this.studentRating + score) / 2; 
	}
	
	/**
	 * sets the teacher avg (if multiple teachers have already inputted review scores)
	 * @param score
	 */
	
	public void setTeacherAvg(int score)
	{
		this.teacherRating = (float)(this.teacherRating + score) / 2; 
	}
	
	/**
	 * calculates the avg of the teachers and the students and sets that as the final rating of the tutor
	 */
	
	private void setRating()
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
	
	/**
	 * calculates the tutor's stars based on the final rating (obtained from the above meathod)
	 */
	
	private void setStar()
	{
		this.stars = (float)this.rating/2;
	}
	
	public float getRating()
	{
		return this.rating;
	}
	
	public float getStar()
	{
		return this.stars; 
	}
	
	public String getReview()
	{
		return this.review;
	}
	
	public Student getStudent()
	{
		return this.studentReviewer;
	}
	
	public Tutor getTutor()
	{
		return this.reviewee;
	}
	
	public Teacher getTeacher()
	{
		return this.teacherReviewer;
	}

	@Override
	public String toString() 
	{
		return "TutorReview [rating=" + rating + ", stars=" + stars + ", review=" + review + "]";
	}
}
