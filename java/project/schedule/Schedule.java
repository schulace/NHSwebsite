package project.schedule;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;

public class Schedule
{
	private ArrayList<SchoolClass> classes;
	private SchoolClass[][] blockSchedule = new SchoolClass[8][6]; //goes [day] [block]
	
	
	public ArrayList<SchoolClass> getClasses()
	{
		return this.classes;
	}
	
	
	
	public Schedule(ArrayList<SchoolClass> classes)
	{
		this.classes = classes;
		
		for(SchoolClass C: this.classes)
		{
			int[] numDays = new int[C.getDays().length];
			LetterDay[] letterDays = C.getDays();
			for(int x = 0; x < letterDays.length; x++)
			{
				switch(letterDays[x])
				{
					case A: numDays[x] = 0;
						break;
					case B: numDays[x] = 1;
						break;
					case C: numDays[x] = 2;
						break;
					case D: numDays[x] = 3;
						break;
					case E: numDays[x] = 4;
						break;
					case F: numDays[x] = 5;
						break;
					case G: numDays[x] = 6;
						break;
					case H: numDays[x] = 7;
						break;
					default: numDays[x] = 0;
						break;	
				}
				
				//TODO finish the parser for a class list into a schedule
			}
			
		}
		
		
	}
	
	public Schedule()
	{
		
	}

}
