package project.user;
import java.util.ArrayList;
import project.schedule.classes.SchoolClass;
public class Student 
{
	public ArrayList<SchoolClass> StrugglingClasses;

	public void requestHelp(SchoolClass thing)
	{
		//TODO finish requestHelp when SchoolClass works 
	}
	
	public boolean setStruggle (SchoolClass thing)
	{
		boolean found = false;
		for(int i = 0; i < this.StrugglingClasses.size(); i++)
		{
			if(thing.equals(this.StrugglingClasses.get(i)))
			{
				found = true;
				
			}
		}
		if(found == false)
		{
			StrugglingClasses.add(thing);
			return found;
		}
		else
		{
			return found;
		}
	}
	
	public ArrayList<SchoolClass> returnStruggle()
	{
		if(StrugglingClasses.isEmpty())
		{
			System.out.println("This Student is not currently Struggling");
			return StrugglingClasses;
		}
		else
		{
			System.out.println("This student is currently Struggling");
			return StrugglingClasses;
		}
	}
	
	public void rateGuide()
	{
		//TODO finish rateGuide() when ReviewGuides works/is set up
	}
	
	public void rateGuide(Tutor placeholder, String review)
	{
		//TODO finish rateGuide(tutor, review) when tutor is set up
	}
}
