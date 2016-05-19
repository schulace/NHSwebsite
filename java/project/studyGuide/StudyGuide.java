package project.studyGuide;
import project.schedule.classes.SchoolClass;
import project.user.User;

public class StudyGuide 
{
	private User author;
	private SchoolClass subject;
	private String content;
	private float rating = -1;
	private float stars; 
	private boolean isPlagiarism; 
	
	public StudyGuide(User author, SchoolClass subject, String content, int rating) 
	{
		this.author = author;
		this.subject = subject;
		this.content = content;
		this.rating = setRating(rating);
	}
	
	public float getStars()
	{
		return stars;
	}
	
	public User getAuthor()
	{
		return author;
	}

	public void setAuthor(User author)
	{
		this.author = author;
	}

	public SchoolClass getSubject()
	{
		return subject;
	}

	public void setSubject(SchoolClass subject) 
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

	public float getRating()
	{
		return rating;
	}

	public float setRating(int score)
	{
		if (score <= 10 && score >=0 )
		{
			if(this.rating != -1)
			{
				setAvg(score);
			}
			else 
			{
				this.rating = score;
			}
			setStar(score);
			return this.rating;	
		}
		return -1;
	}
	
	public void setAvg(int score)
	{
		this.rating = (float)(this.rating + score) / 2; 
	}
	
	public void setStar(int score)
	{
		this.stars = (float)score/2;
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
