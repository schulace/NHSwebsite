package project.schedule.classes;

import java.util.ArrayList;

import project.user.Tutor;

public class TutorPossibility
{
	public Tutor tut;
	public ArrayList<int[]> commonBlocks;
	
	public TutorPossibility(Tutor tut, ArrayList<int[]> studentOpens)
	{
		SchoolClass[][] sched = tut.getSchedule().getBlockSchedule();
		ArrayList<int[]> availableBlocks = new ArrayList<int[]>();
		for(int i = 0; i< 8; i++)
		{
			for (int z = 0; z < 6; z++)
			{
				if(sched[i][z] == null)
				{
					int[] temp = {i,z};
					availableBlocks.add(temp);
				}
			}
		}
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
