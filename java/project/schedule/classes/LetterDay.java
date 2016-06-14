package project.schedule.classes;

public enum LetterDay
{
	A,B,C,D,E,F,G,H;
	
	public LetterDay getNextLetterDay()
	{
		switch(this)
		{
		case A: return B;
		case B: return C;
		case C:	return D;
		case D:	return E;
		case E:	return F;
		case F:	return G;
		case G:	return H;
		case H:	return A;
			
		}
		return null;
	}
	
	public int getIntDay()
	{
		switch(this)
		{
		case A: return 0;
		case B:	return 1;
		case C:	return 2;
		case D:	return 3;
		case E:	return 4;
		case F:	return 5;
		case G:	return 6;
		case H:	return 7;
		}
		return 0;
	}
	
	public LetterDay getDayFromInt(int x)
	{
		switch(x)
		{
		case 0: return A;
		case 1:	return B;
		case 2:	return C;
		case 3:	return D;
		case 4:	return E;
		case 5:	return F;
		case 6:	return G;
		case 7:	return H;
		}
		return A;
	}
}
