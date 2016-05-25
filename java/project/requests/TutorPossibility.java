package project.requests;

import java.util.ArrayList;
import java.util.Arrays;

import project.schedule.classes.SchoolClass;
import project.user.Student;
import project.user.Tutor;

public class TutorPossibility
{
	public Tutor tut;
	public ArrayList<int[]> commonBlocks = new ArrayList<int[]>();
	public Student stu;
	
	public TutorPossibility(Tutor tut, ArrayList<int[]> studentOpens, Student stu)
	{
		this.tut = tut;
		this.stu = stu;
		ArrayList<int[]> availableBlocks = tut.getOpens();
		for(int[] stArr:studentOpens)
		{
			for(int[] tArr:availableBlocks)
			{
				if(Arrays.equals(stArr, tArr))
				{
					this.commonBlocks.add(stArr);
				}
			}
		}
	}
	@Override
	public String toString()
	{
		return "TutorPossibility [tutor=" + tut.toStringMinusSchedule() +", requestor=" +stu.toStringMinusSchedule()+ ", commonBlocks=" + Arrays.deepToString(commonBlocks.toArray()) + "]";
	}
	
	
	
}
