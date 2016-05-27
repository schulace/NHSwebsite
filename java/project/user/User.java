package project.user;


import java.util.ArrayList;
import project.schedule.calendar.GHSCalendar;
import project.schedule.calendar.ScheduleHistory;
import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Year;
import project.serverLogic.Reference;

/**
 * @author schulace
 * abstract class for user. extended by student and tutor.
 * contains a school calendar, name, date of birth, grade, gender.
 */
public abstract class User
{
	protected GHSCalendar userCalendar;
	protected String name;
	protected Year grade;
	protected ScheduleHistory history;
	private boolean confirm = false;
	
	
	
	/**
	 * 
	 * @param Schedule type: StudentSchedule
	 * @param name type: String
	 * @param year	type: Year (enum)
	 */
	public User(StudentSchedule Schedule, String name,  Year year)
	{
		this.userCalendar = new GHSCalendar(Reference.startDate, Reference.endDate, Schedule, Reference.breakDays);
		this.name = name;
		this.grade = year;
	}


	/**
	 * 
	 * @param name the name of the student to create
	 */
	public User(String name)
	{
		this(new StudentSchedule(), name, Year.Unknown);
	}
	
	public User(String name, int grade)
	{
		this(new StudentSchedule(), name, grade);
	}
	
	
	/**
	 * 
	 * @return arrayList of int[] that represents a student's open blocks.
	 */
	public ArrayList<int[]> getOpens()
	{
		SchoolClass[][] blockSched = this.userCalendar.studentSchedule.getBlockSchedule();
		ArrayList<int[]> toReturn = new ArrayList<int[]>();
		for(int x = 0; x < 8; x ++)
		{
			for(int y = 0; y < 6; y++)
			{
				if(blockSched[x][y] == null)
				{
					int[] arr = {x,y};
					toReturn.add(arr);
				}
			}
		}
		return toReturn;
	}
	
	/**
	 * @param sched a student schedule
	 * @param name student name
	 * @param grade school grade (int between 9 and 12)
	 */
	public User(StudentSchedule sched, String name, int grade)
	{		
		Year y;
		switch(grade)
		{
			case 9: y = Year.Freshman;
			break;
			case 10: y = Year.Sophomore;
			break;
			case 11: y = Year.Junior;
			break;
			case 12: y = Year.Senior;
			break;
			default: y = Year.Unknown;
		}
			
		this.userCalendar = new GHSCalendar(Reference.startDate, Reference.endDate, sched, Reference.breakDays);
		this.name = name;
		this.grade = y;
	}
	
	public GHSCalendar getCalendar()
	{
		return this.userCalendar;
	}
	
	/**
	 * @param sched student school schedule.
	 * Generates a new calendar schedule with the school startdate, endDate, this schedule, and all days off.
	 */
	
	public void setSchedule(StudentSchedule sched)
	{
		this.userCalendar = new GHSCalendar(Reference.startDate, Reference.endDate, sched, Reference.breakDays);
	}
	
	//TODO Google acct linkage
	
	public StudentSchedule getSchedule()
	{
		return userCalendar.getStudentSchedule();
	}
	
	public String getName()
	{
		return name;
	}
	
	protected void setName(String name)
	{
		this.name = name;
	}
	
	public Year getGrade()
	{
		return grade;
	}
	
	public int getGradeAsInt(){
		String letsHopeThisWorks = ""+this.grade;
		int intGrade = Integer.parseInt(letsHopeThisWorks);
		return intGrade;
	}
	protected void setGrade(Year grade)
	{
		this.grade = grade;
	}
	
	protected ScheduleHistory getHistory()
	{
		return history;
	}
	
	protected void setHistory(ScheduleHistory history)
	{
		this.history = history;
	}
	
	@Override
	public String toString()
	{
		return "User [cal=" + userCalendar + ", name=" + name + ", grade=" + grade + ", history=" + history + "]";
	}
	
	public String toStringMinusSchedule()
	{
		return "User [name=" + name + ", grade=" + grade + "]";
	}
	
	public void acceptSession() //TODO Josh talk to me about this when you know PHP
	{
		this.confirm = true;
	}
	
	public void denySession()
	{
		this.confirm = false;
	}
	
	public boolean confirmSession()
	{
		return this.confirm;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userCalendar == null) {
			if (other.userCalendar != null)
				return false;
		} else if (!userCalendar.equals(other.userCalendar))
			return false;
		if (grade != other.grade)
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
}
