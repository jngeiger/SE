package arraySplit;

public class ArraySplit {
	 public static void main(String[] args)
	 {
	   
	   /* There are two methods to check if the array can be divided 
	    * canDivideArraySlow does it in O(n^2)
	    * 
	    * canDivideArrayFast does it in O(n) but uses the following helper methods to provide better structure:
	    *          -> _sumArray
	    *          -> _sumOdd
	    *          -> _isSplittable
	    *          -> _findMiddle
	   */
		 
		// Test Cases
 	   int[] array = new int[] {20,-20,0,20,-400,380};
 	   int[] array2 = new int[] {1,2,-3,0};
  	   System.out.println(canDivideArrayFast(array));
  	   System.out.println(canDivideArraySlow(array));
  	   System.out.println(canDivideArrayFast(array2));
	   System.out.println(canDivideArraySlow(array2));
	 }

	 public static boolean canDivideArrayFast(int[] array)
	 {
		 // Sum up all values of the integer array and save it to 'sum'
		 int sum = _sumArray(array);
		 
		 // Checks if sum is an odd number, if it is: Array can't be divided -> returns false
		 if (_sumOdd(sum))
			 return false;
		 
		// checks if both array sides have equal sums
		 return _isSplittable(_findMiddle(sum,array),sum,array);
		 
		 
	 }
	 private static int _sumArray(int[] array)
	 {
		 int sum = 0;
		 for (int i = 0; i < array.length; i++)
		 {
			 sum += array[i];
		 }
		 return sum;
	 }
	 private static boolean _sumOdd(int sum)
	 {
		 if (sum % 2 != 0)
		 {
			 return true;
		 }
		 else 
			 return false;
	 }
	 
	 private static int _findMiddle(int sum, int[] array)
	 {
		 int i = 0;
		 int compareInt = 0;
		 for (i = 0; i < array.length - 1; i++)
		 {
			 compareInt += array[i];
			 if (sum/2 == compareInt)
			 {
				 return i;
			 }
		 }
		 return 0;
		 
	 }
	 
	 private static boolean _isSplittable(int value_middle, int sum, int[] array)
	 {
		 int counter = 0;
		 for (int i = value_middle + 1; i < array.length; i++)
		 {
			 counter += array[i];
		 }
		 return (counter == sum / 2);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 public static boolean canDivideArraySlow(int[] array)
	 {
	 	int temp1 = 0;
	 	int temp2 = 0;
	 	for (int i = 0; i < array.length - 1; i++)
	 	{
	 		temp1 += array[i];
	 		for (int j = i+1; j < array.length; j++)
	 		{
	 			temp2 += array[j];
	 		}
	 		if (temp1 == temp2)
	 		{
	 			return true;
	 		}
	 		temp2 = 0;
	 	}	
	 	return false;	
	 }
}