package project.serverLogic;

import java.util.ArrayList;
import java.util.Arrays;

import project.requests.Request;
import project.requests.TutorPossibility;
import project.user.Tutor;


//TODO generate a tutoring session class, put it into schedules, and then be able to move a request into an archive + out of the list.
public class requestManager
{
	private static ArrayList<Request> requestList = new ArrayList<Request>();
	
	public static ArrayList<Request> getRequestList()
	{
		return requestList;
	}

	public static void addRequest(Request req)
	{
		for(Request inList:requestList)
		{
			if(inList.equals(req))
			{
				return;
			}
		}
		
		
		for(Tutor t:userFactory.tutorList)
		{
			TutorPossibility pos = new TutorPossibility(t, req.getRequestor());
			if(pos.commonBlocks.size() > 0)
			{
				req.addPossibleFill(pos);
			}
		}
		requestList.add(req);
	}
	
}
