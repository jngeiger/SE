package test49;

import java.util.ArrayList;

public class TestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(test(1));
		
	}
	
	public static boolean test(int number)
	{
		ArrayList<Integer> storage = new ArrayList<Integer>();
		if (number == 1)
		{
			return true;
		}
		
		
		int temp = 0;
		while (temp != 1 || storage.contains(temp))
		{
			temp = 0;
			for (int i = 0; i < getNumbers(number).size(); i++)
			{
			temp += Math.pow(getNumbers(number).get(i),2);
			}
			storage.add(temp);
			number = temp;
		}
		
		if (temp == 1)
		{
			return true;
		}
		else {
			return false;
		}
		
	
		
	}
	
	public static ArrayList<Integer> getNumbers(int number)
	{
		ArrayList<Integer> results = new ArrayList<Integer>();
		Integer lastResult = number;
		
		while (lastResult > 0)
		{
			results.add(lastResult % 10);
			lastResult /= 10;
		}
		return results;
	}

}
