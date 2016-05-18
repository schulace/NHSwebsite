package studyGuide;
//TODO Alex take a look at this/see if I need to add anything more to it
import project.schedule.classes.SchoolClass;
import project.user.User;

public class StudyGuide 
{
	private User author;
	private SchoolClass subject;
	private String content;
	private int rating;
	
	public StudyGuide(User author, SchoolClass subject, String content, int rating) 
	{
		this.author = author;
		this.subject = subject;
		this.content = content;
		this.rating = rating;
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

	public int getRating()
	{
		return rating;
	}

	public void setRating(int rating)
	{
		this.rating = rating;
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
		}
		return equals;
	}
	
}
