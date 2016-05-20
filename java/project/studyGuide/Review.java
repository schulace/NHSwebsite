package project.studyGuide;

import project.user.Student;

public class Review
{
	private Student studentReviewer;
	private float score;
	private float stars;
	private String review;
	private boolean profanty;
	
	public Review(Student studentReviewer, float score, String review)
	{
		setReview(review);
		if (profanty == false)
		{
			this.setStudentReviewer(studentReviewer);
			this.setScore(score);
			setStars(score);
		}
		else
		{
			return;
		}
	}
	
	public Review(Student studentReviewer, float score)
	{
		this(studentReviewer, score, "");
	}
	
	public void setReview(String comment)
	{
		if(comment.contains("fuck") || comment.contains("shit") || comment.contains("bitch") || comment.contains("piss") || comment.contains("dick") || comment.contains("cock") || comment.contains("pussy") || comment.contains("asshole") || comment.contains("fag") || comment.contains("bastard") || comment.contains("slut") || comment.contains("douche"))
		{
			profanty = true;
			return;
		}
		else 
		{
			this.review = comment;
		}
	}
	
	public String review(){
		return this.review;
	}

	public float getScore()
	{
		return this.score;
	}

	public void setScore(float score)
	{
		this.score = score;
	}
	
	public void setStars(float s)
	{
		this.stars = s / 2;
	}
	
	public float stars()
	{
		return this.stars;
	}
	
	public Student getStudent()
	{
		return this.studentReviewer;
	}

	public void setStudentReviewer(Student studentReviewer) {
		this.studentReviewer = studentReviewer;
	}

	@Override
	public String toString() {
		return "Review [studentReviewer=" + studentReviewer + ", score=" + score + ", stars=" + stars + ", review="
				+ review + ", profanty=" + profanty + "]";
	}
}
