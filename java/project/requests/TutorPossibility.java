package project.requests;

import java.util.ArrayList;
import java.util.Arrays;

import project.user.Student;
import project.user.Tutor;
/**
 * 
 * @author schulace
 * representative of the possibility of a particular tutor teaching a student.
 * contains the tutor, the student, and which opens are shared between the 2.
 */
public class TutorPossibility
{
	public Tutor tut;
	public ArrayList<int[]> commonBlocks = new ArrayList<int[]>();
	public Student stu;
	
	public TutorPossibility(Tutor tut, Student stu)
	{
		this.tut = tut;
		this.stu = stu;
		ArrayList<int[]> availableBlocks = tut.getOpens();
		ArrayList<int[]> studentAvailableBlocks = stu.getOpens();
		for(int[] stArr:studentAvailableBlocks)
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
