package project.schedule.classes;

import java.util.Arrays;

import project.user.Teacher;

public class SchoolClass
{
	private String name;
	private Subject subject;
	private LetterDay[] days;
	private int block;
	private Teacher prof;
	
	public SchoolClass(String name, Subject subject, LetterDay[] days, int block, Teacher teacher)
	{
		this.setName(name);
		this.setSubject(subject);
		this.setDays(days);
		this.setBlock(block);
		this.setProf(teacher);
	}

	public Teacher getProf() {
		return prof;
	}

	public void setProf(Teacher prof) {
		this.prof = prof;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Subject getSubject()
	{
		return subject;
	}

	public void setSubject(Subject subject)
	{
		this.subject = subject;
	}

	public LetterDay[] getDays()
	{
		return days;
	}

	public void setDays(LetterDay[] days)
	{
		this.days = days;
	}

	public int getBlock()
	{
		return block;
	}

	public void setBlock(int block)
	{
		this.block = block;
	}
	
	@Override
	public String toString()
	{
		return "[name=" + name + ", subject=" + subject + "]";
	}

	public boolean equals(SchoolClass obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolClass other = (SchoolClass) obj;
		if (block != other.block)
			return false;
		if (!Arrays.equals(days, other.days))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subject != other.subject)
			return false;
		return true;
	}
}
