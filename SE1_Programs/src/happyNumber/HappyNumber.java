package happyNumber;

import java.util.ArrayList;


public class HappyNumber {

public static void main(String[] args)
{
	int[] happyNumbers = new int[] {1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100};
	int[] notSoHappyNumbers = new int[] {2,8,9,11,16,24,30,54,67,77,83,87,92,98,99,22,3,4,83,12};
	
	for (int i = 0; i < happyNumbers.length; i++)
	{
		System.out.println(happyNumber(happyNumbers[i]));
		System.out.println(happyNumber(notSoHappyNumbers[i]));
	}
	
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
