package doubleConverter;

public class DoubleConverter {

	public static void main(String[] args) throws Exception
	{
		String s = "-5.232E2"; 
		double d = 2340000000000.0;
		
		
		System.out.println(convert(s));
		System.out.println(d);

	}
	
	public static double convert(String s) throws Exception
	{
		double value = 0.0;
		int pointIndex = 0; boolean pointFound = false; boolean exponential = false;
		int multiplikator = 0;
		
		for (int i = 0; i < s.length() - 1; i++)
		{
			if (s.charAt(i) == 'E' || s.charAt(i) == 'e')
			{
				exponential = true;
				int j = s.length()-1;
				int lokalerStellenWert = 1;
				do {
					 multiplikator += mapAscii(s.charAt(j)) * lokalerStellenWert;
					 lokalerStellenWert *= 10;
					 j--;
				} while (j > i);
				s = s.substring(0,i);
				break;
			}
		}
		
		
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '.')
			{
				pointFound = true;
				pointIndex = i;
				break;
			}
			
		}
		
		if (pointFound) {
		double stellenWert = 1.0;
		for (int i = pointIndex-1; i >= 0; i--)
		{
			value += (mapAscii(s.charAt(i))) * stellenWert;
			stellenWert *= 10.0;
		}
		stellenWert = 0.1;
		for (int i = pointIndex+1; i < s.length(); i++)
		{
			value += (mapAscii(s.charAt(i))) * stellenWert;
			stellenWert /= 10.0;
		}
		}
		
		if (!pointFound)
		{
			double stellenWert = 1;
			for (int i = s.length()-1; i >= 0 ; i--)
			{
				value += (mapAscii(s.charAt(i))) * stellenWert;
				stellenWert *= 10.0;
			}
		}
		if (exponential)
		{
			value = value * Math.pow(10.0, multiplikator);
		}
		
		return value;
	}
	
	public static int mapAscii(int value) throws Exception
	{
		switch (value) {
		case 48: return 0;
		case 49: return 1;
		case 50: return 2;
		case 51: return 3;
		case 52: return 4;
		case 53: return 5;
		case 54: return 6;
		case 55: return 7;
		case 56: return 8;
		case 57: return 9;
		default: throw new Exception ("NO VALID ASCII NUMBER");
		}
	}
}
