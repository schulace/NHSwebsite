package project.schedule.calendar;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;
import project.schedule.classes.StudentSchedule;
import project.schedule.classes.Subject;
import project.schedule.classes.TutoringSession;

public class TutoringHistory
{
	public ArrayList<GHSCalendarDay> history = new ArrayList<GHSCalendarDay>();
	public ArrayList<GHSCalendarDay> allTutoringSessions = new ArrayList<GHSCalendarDay>();
	
	public TutoringHistory(GHSCalendar calIn)
	{
		GHSCalendarDay newDay = null;
		for(GHSCalendarDay day: calIn.cal)
		{
			for(SchoolClass c:day.classes)
			{
				if(c.getSubject() == Subject.TUTORING)
				{
					newDay = day.clone();
					break;
				}
			}
			if(newDay != null)
			{
				for(SchoolClass c : newDay.classes)
				{
					if(c !=null)
					{
						if(c.getSubject() != Subject.TUTORING)
						{
							c = null;
						}
					}
				}
				this.allTutoringSessions.add(newDay);
			}
		}
	}
	
	public void update()
	{
		this.history =  new ArrayList<GHSCalendarDay>();
		for(GHSCalendarDay day : this.allTutoringSessions) //loops through alltutoringsessions. this contains things that have and have not happened
		{
			for( SchoolClass c: day.classes) //goes through each day, checking if a tutoringSession has happened.
			{
				if(c instanceof TutoringSession)
				{
					TutoringSession sesh = (TutoringSession) c;
					if(sesh.happened)
					{
						GHSCalendarDay histDay = day.clone(); //if the session did happen, the day is cloned.
						for(SchoolClass n: histDay.classes) //loops through the cloned one, this time being destructive
						{
							if(n instanceof TutoringSession)
							{
								if(!((TutoringSession)n).happened) //if the class is a tutoring session that hasn't happened, it's set to null, effectively removing it.
								{
									n = null;
								}
							}
							else //if it's not a tutoring session, it doesn't belong in a history of them. removed as well.
							{
								n = null;
							}
						}
						this.history.add(histDay); //day gets added to history, with only null and completed tutoringsessions in it.
						break;
					}
				}
			}
		}
	}
}
