package project.studyGuide;

import project.user.Student;
import project.user.Teacher;

public class Review
{
	private Student studentReviewer;
	private float score;
	private float stars;
	private String review;
	
	public Review(Student studentReviewer, float score, String review)
	{
		this.setStudentReviewer(studentReviewer);
		this.setScore(score);
		this.stars = score / 2;
		this.review = review;
	}
	
	public Review(Student studentReviewer, float score)
	{
		this(studentReviewer, score, "");
	}

	public float getScore()
	{
		return score;
	}

	public void setScore(float score)
	{
		this.score = score;
	}

	public Student getStudent()
	{
		return studentReviewer;
	}

	public void setStudentReviewer(Student studentReviewer) {
		this.studentReviewer = studentReviewer;
	}
	
	
}
