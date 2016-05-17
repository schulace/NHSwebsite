package project.schedule.classes;

import project.schedule.LetterDay;

public class SchoolClass
{
	private String name;
	private Subject subject;
	private LetterDay[] days;
	private int block;
	
	public SchoolClass(String name, Subject subject, LetterDay[] days, int block)
	{
		this.setName(name);
		this.setSubject(subject);
		this.setDays(days);
		this.setBlock(block);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public LetterDay[] getDays() {
		return days;
	}

	public void setDays(LetterDay[] days) {
		this.days = days;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}
}
