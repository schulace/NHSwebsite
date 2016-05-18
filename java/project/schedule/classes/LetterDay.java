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
}
