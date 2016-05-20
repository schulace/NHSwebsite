package project.studyGuide;
import java.util.ArrayList;

import project.schedule.classes.Subject;
import project.user.User;

public class StudyGuide 
{
	private User author;
	private Subject subject;
	private String content;
	private float rating = -1;
	private float stars; 
	private boolean isShady = false;
	private boolean isPlagiarism;
	private ArrayList<Review> reviews;
	
	public StudyGuide(User author, Subject subject, String content) 
	{
		this.author = author;
		this.subject = subject;
		this.content = content;
		reviews = new ArrayList<Review>();
	}
	
	public boolean isShady() //so the guide can be flagged as inappropriate
	{
		return isShady;
	}

	public void setShady(boolean isShady)
	{
		this.isShady = isShady;
	}
	
	public void addReview(Review re)
	{
		for(Review r: this.reviews)
		{
			if(re.getStudent().equals(r.getStudent()));
			{
				return;
			}
		}
		reviews.add(re);
	}

	public float getAndCalcStars()
	{
		calcAndSetRating();
		this.stars =  (float)this.rating/(float)2;
		return this.stars;
	}
	
	public User getAuthor()
	{
		return author;
	}

	public void setAuthor(User author)
	{
		this.author = author;
	}

	public Subject getSubject()
	{
		return subject;
	}

	public void setSubject(Subject subject) 
	{
		this.subject = subject;
	}

	public String getContent() 
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}


	public float calcAndSetRating()
	{
		float ratingSum = 0;
		for(Review r :this.reviews)
		{
			ratingSum += r.getScore();
		}
		this.rating = ratingSum / (float)this.reviews.size(); 
		return this.rating;
	}

	@Override
	public String toString()
	{
		return "StudyGuide [author=" + author + ", subject=" + subject + ", content=" + content + ", rating=" + rating
				+ "]";
	}
	
	public boolean equals(StudyGuide c)
	{
		boolean equals = false;
		if (this.content.equals(c.content))
		{
			equals = true;
			isPlagiarism = true;
		}
		return equals;
	}
	
}
