package project.serverLogic;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Reference
{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static GregorianCalendar startDate = new GregorianCalendar(2015, 8, 2);
	public static GregorianCalendar endDate = new GregorianCalendar(2016, 5, 13);
	public static ArrayList<GregorianCalendar> breakDays = new ArrayList<GregorianCalendar>();
	public static void addBreakDay(int yr, int month, int day)
	{
		breakDays.add(new GregorianCalendar(yr, month, day, 0, 0, 0));
	}
	public static ArrayList<GregorianCalendar> setAndGetBreakDays()
	{
		breakDays = new ArrayList<GregorianCalendar>();
		addBreakDay(2015, 8, 7);
		addBreakDay(2015, 8, 14);
		addBreakDay(2015, 8, 23);
		addBreakDay(2015,10,3);
		addBreakDay(2015, 10, 26);
		addBreakDay(2015, 10, 27);
		addBreakDay(2015, 11, 24);
		addBreakDay(2015, 11, 25);
		addBreakDay(2015, 11, 25);
		addBreakDay(2015, 11, 28);
		addBreakDay(2015, 11, 29);
		addBreakDay(2015, 11, 30);
		addBreakDay(2015, 11, 31);
		addBreakDay(2016, 0, 1);
		addBreakDay(2016, 0, 18);
		addBreakDay(2016, 0, 21);
		addBreakDay(2016, 0, 22);
		addBreakDay(2016, 0, 25);
		addBreakDay(2016, 0, 26);
		addBreakDay(2016, 1, 8);
		addBreakDay(2016, 1, 9);
		addBreakDay(2016, 1, 10);
		addBreakDay(2016, 1, 11);
		addBreakDay(2016, 1, 12);
		addBreakDay(2016, 1, 15);
		addBreakDay(2016, 2, 25);
		addBreakDay(2016, 3, 11);
		addBreakDay(2016, 3, 12);
		addBreakDay(2016, 3, 13);
		addBreakDay(2016, 3, 14);
		addBreakDay(2016, 3, 15);
		addBreakDay(2016, 3, 26);
		addBreakDay(2016, 4, 30);
		return breakDays;
	}
	
}
