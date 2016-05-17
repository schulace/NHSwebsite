package project.schedule.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentSchedule
{
	//TODO GEORGE make sure I did this right and that I'm not insane
	
	private ArrayList<SchoolClass> classes;
	private SchoolClass[][] blockSchedule = new SchoolClass[8][6]; //goes [day] [time] 
	public static final int[][] blocks = //an array of the block schedule. each row is a day of the schedule.
		{
			{1,2,3,4,5,6}, //a
			{4,3,6,5,7,8}, //b
			{2,1,5,6,8,7}, //etc. you're not retarded.
			{1,2,3,4,7,8},
			{2,1,4,3,6,5},
			{3,4,5,6,8,7},
			{1,2,6,5,7,8},
			{2,1,4,3,8,7}
		};
	
	public StudentSchedule(ArrayList<SchoolClass> classes)
	{
		this.classes = classes;
		
		for(SchoolClass singleClass: this.classes)
		{
			
			addClass(singleClass);
		}
	}
	
	public ArrayList<SchoolClass> getClasses()
	{
		return this.classes;
	}
	
	public void addClass(SchoolClass singleClass)
	{
		//classes is an arrayList of classes
		//each class contains an integer for block, and an arrayList of enumDays
		int[] numDays = new int[singleClass.getDays().length];
		LetterDay[] letterDays = singleClass.getDays();
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
		}
		
		for(int y:numDays)
		{
			putClassInSchedOnDay(y, singleClass);
		}
	}
	
	public void putClassInSchedOnDay(int day, SchoolClass sClass)
	{
		int block = sClass.getBlock();
		for(int x = 0; x < 6; x ++)
		{
			if(blocks[day][x] == block)
			{
				blockSchedule[day][x] = sClass;
			}
		}
		
	}
	
	public StudentSchedule()
	{
		
	}
	
	@Override
	public String toString()
	{
		return Arrays.deepToString(blockSchedule);
	}

}
