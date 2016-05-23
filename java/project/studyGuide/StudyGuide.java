/**
 * 
 * @author george
 * object for StudyGuide
 *
 */

package project.studyGuide;
import java.util.ArrayList;

import project.schedule.classes.Subject;
import project.serverLogic.userFactory;
import project.user.Tutor;
import project.user.User;

public class StudyGuide 
{
	private Tutor author;
	private Subject subject;
	private String content;
	private float rating = -1;
	private float stars; 
	private boolean isShady = false;
	private boolean isPlagiarism;
	private ArrayList<Review> reviews;
	private boolean profanity  = false;
	private userFactory master;
	
	/**
	 * 
	 * @param author
	 * @param subject
	 * @param content
	 */
	
	
	public StudyGuide(Tutor author, Subject subject, String comment) 
	{
		if(comment.contains("fuck") || comment.contains("shit") || comment.contains("bitch") || comment.contains("piss") || comment.contains("dick") || comment.contains("cock") || comment.contains("pussy") || comment.contains("asshole") || comment.contains("fag") || comment.contains("bastard") || comment.contains("slut") || comment.contains("douche"))
		{
			profanity = true;
			sendGuide(author, subject, comment);
			return;
		}
		else 
		{
			this.content = comment;
		}
		this.author = author;
		this.subject = subject;
		reviews = new ArrayList<Review>();
	}
	
	/**
	 * adds a review to reviews (not after checking it first)
	 * @param re
	 */
	
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
	
	public void sendGuide(Tutor u, Subject subj, String s)
	{
		this.author = u;
		this.subject = subj;
		this.content = s;
		master.addProfaneGuide(this);
	}
	
	public boolean profanity()
	{
		return this.profanity;
	}
	
	public boolean isShady() //so the guide can be flagged as inappropriate
	{
		return isShady;
	}

	public void setShady(boolean isShady)
	{
		this.isShady = isShady;
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

	public void setAuthor(Tutor author)
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
	
	public boolean isPlagiarism()
	{
		return this.isPlagiarism;
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
