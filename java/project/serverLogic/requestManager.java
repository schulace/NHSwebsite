package project.serverLogic;

import java.util.ArrayList;

import project.schedule.classes.Request;

public class requestManager
{
	private static ArrayList<Request> requestList = new ArrayList<Request>();
	
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
	}
	
}
