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
		for(GHSCalendarDay day : this.allTutoringSessions)
		{
			for( SchoolClass c: day.classes)
			{
				TutoringSession sesh = (TutoringSession) c;
				if(sesh.happened)
				{
					GHSCalendarDay histDay = day.clone();
					for(SchoolClass n: histDay.classes)
					{
						TutoringSession histSesh = (TutoringSession)n;
						if(!histSesh.happened)
						{
							n = null;
						}
					}
					this.history.add(histDay);
					
				}
			}
		}
	}
	
	
}
