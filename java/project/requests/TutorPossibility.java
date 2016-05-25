package project.requests;

import java.util.ArrayList;

import project.schedule.classes.SchoolClass;
import project.user.Tutor;

public class TutorPossibility
{
	public Tutor tut;
	public ArrayList<int[]> commonBlocks;
	
	public TutorPossibility(Tutor tut, ArrayList<int[]> studentOpens)
	{
		ArrayList<int[]> availableBlocks = tut.getOpens();
		for(int[] stArr:studentOpens)
		{
			for(int[] tArr:availableBlocks)
			{
				if(stArr.equals(tArr))
				{
					this.commonBlocks.add(stArr);
				}
			}
		}
	}
}
