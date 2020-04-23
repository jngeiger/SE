package naughtyNine;

public class NaughtyNine {

	public static void main(String[] args) throws Exception
	{
		// Aufgabe 1.3 
		// Boolean "True" equals "following number has to be skipped"
		// test value:
		int x = 206;
		
		// Check iteration implementation
		try {
			System.out.println(checkFor9_iteration(x));
			}
			catch (Exception e)
			{
				System.err.println(e.getMessage());
			}
		// Check string implementation
		try {
			System.out.println(checkFor9_string(x));
			}
			catch (Exception e)
			{
				System.err.println(e.getMessage());
			}
		// Check iteration implementation
		try {
			System.out.println(checkFor9_recursion(x));
			}
			catch (Exception e)
			{
				System.err.println(e.getMessage());
			}
		
		
	}
	// iterative solution
	private static boolean checkFor9_iteration (int value) throws Exception
	{
		// Exception Handling
		if (value <= 0)
		{
			throw new Exception("The value: " + value + " is not a natural number");
		}
		else if (value == 2147483647)
		{
			throw new Exception("Integer overflow, use different datatype");
		}
		
		// Logic
		++value;
		if ((value) % 9 == 0)
		{
			return true;
		}
		while (value > 10)
		{
			if (value % 10 == 9)
			{
				return true;
			}
			value = value/10;
		}
		return false;
	}
	
	// Method increments value by 1 and calls actual recursion implementation. Returns value given by called method.
	private static boolean checkFor9_recursion (int value) throws Exception
	{
		// Exception Handling
		if (value <= 0)
		{
			throw new Exception("The value: " + value + " is not a natural number");
		}
		else if (value == 2147483647)
		{
			throw new Exception("Integer overflow, use different datatype");
		}
		// Logic
		value++;
		return _checkFor9_recursion_helper(value);
	}
	
	// returns true if value either contains a 9 OR is divisible by 9
	private static boolean _checkFor9_recursion_helper(int value)
	{
	if (value < 9)
		return false;
	
	if (value % 9 == 0 || value % 10 == 9)
		return true;
	
	return _checkFor9_recursion_helper((value) / 10);
	}
	
	
	private static boolean checkFor9_string (int value) throws Exception
	{
		// Exception Handling
		if (value <= 0)
		{
			throw new Exception("The value: " + value + " is not a natural number");
		}
		else if (value == 2147483647)
		{
			throw new Exception("Integer overflow, use different datatype");
		}
		// Logic
		return ((Integer.toString(++value).contains("9")) || (value % 9 == 0));
	}
	
}
