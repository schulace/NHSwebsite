package project.serverLogic;

import java.util.ArrayList;
import java.util.Arrays;

import project.requests.Request;
import project.requests.TutorPossibility;
import project.user.Tutor;

public class requestManager
{
	private static ArrayList<Request> requestList = new ArrayList<Request>();
	public static ArrayList<TutorPossibility> posList = new ArrayList<TutorPossibility>();
	
	public static void addRequest(Request req)
	{
		for(Request inList:requestList)
		{
			if(inList.equals(req))
			{
				return;
			}
		}
		requestList.add(req);
		
		for(Tutor t:userFactory.tutorList)
		{
			TutorPossibility pos = new TutorPossibility(t, req.getAvailableBlocks());
			if(pos.commonBlocks.size() > 0)
			{
				posList.add(pos);
			}
		}
	}
	
	public String printPosList(int a)
	{
		TutorPossibility posb = posList.get(a);
		String s = "";
		for(int[] z:posb.commonBlocks)
		{
			s += Arrays.toString(z) + ";";
		}
		return s;
	}
}
