package happyNumber;

import java.util.ArrayList;


public class HappyNumber {

public static void main(String[] args)
{
	Integer number = 49;
	//System.out.println(getDigits(number));
	System.out.println(happyNumber(number));
	
}


public static boolean happyNumber(int number)
{
	var storage = new ArrayList<Integer>();
	int result = 0;
	storage.add(number);
	boolean inContainer = false;
	do {
		result = 0;
		inContainer = false;
		var imported_list = getDigits(number);
		for (int i = 0; i < imported_list.size(); i++)
		{
			result += Math.pow(imported_list.get(i), 2);
		}
		inContainer = storage.contains(result);
		
		storage.add(result);
		number = result;
	} while ((result != 1) && !inContainer);
	
	return (result == 1) ? true : false;
	
}

private static ArrayList<Integer> getDigits(int number)
{
	ArrayList<Integer> list = new ArrayList<Integer>();
	if (number < 10)
	{
		list.add(number);
		return list;
	}
	else {
	while (number>9)
	{
		list.add(number % 10);
		number /= 10;
	}
	list.add(number);
	}
	return list;
}


}
