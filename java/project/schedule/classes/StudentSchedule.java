package project.schedule.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentSchedule
{
	
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
	
	public SchoolClass[][] getBlockSchedule()
	{
		return this.blockSchedule;
	}
	
	/**
	 * generates an empty schedule
	 */
	public StudentSchedule()
	{
		this.classes = new ArrayList<SchoolClass>();
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
			numDays[x] = letterDays[x].getIntDay();
		}
		
		for(int y:numDays)
		{
			putClassInSchedOnDay(y, singleClass);
		}
	}
	
	public void putClassInSchedOnDay(int day, SchoolClass sClass) //magic. this one takes classes + their block and puts it into blockSchedule based off of the ints representing blocks in
	//the blocks[][] double array.
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
	
	@Override
	public String toString()
	{
//		String s = "";
//		s += Arrays.toString(blockSchedule[0]);
//		return s;
		String s = "";
		for(int x = 0; x < 8; x ++)
		{
			for(int y = 0; y < 6; y ++)
			{
				if(blockSchedule[x][y] == null)
				{
					s += "\t\t,";
				}
				else
				{
					s += blockSchedule[x][y].getSubject() + "\t,";
				}
				
			}
			s += "\n";
		}
		return s;
		
		
	}
	
	public boolean equals(StudentSchedule obj) 
	{
		if (Arrays.deepEquals(this.blockSchedule, obj.blockSchedule) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
