package pangramm;

public class Pangramm {

public static void main(String[] args)
{
	String str = "Jeder wackere Bayer vertilgt bequem zwo Pfund Kalbshaxen";
	System.out.println(testPangramm(str));
	System.out.println(testPangramm2(str));
}

public static boolean testPangramm(String str)
{
	str = str.toUpperCase();
	var array = new char[26];
	var boolArray = new boolean[26];
	int initAsciiValue = 65;
	for (int i = 0; i < array.length; i++)
	{
		array[i] = (char)initAsciiValue++;
		boolArray[i] = false;
	}
	
	initAsciiValue = 65;
	for (int i = 0; i < str.length(); i++)
	{
		if (((int)str.charAt(i) >= 65) && ((int)str.charAt(i) <= 90))
			boolArray[(int)str.charAt(i) - 65] = true;
	}
	
	boolean check = true;
	for (int i = 0; i < boolArray.length; i++)
	{
		if (boolArray[i] == false)
			check = false;
			
	}
	return check;
	
}

public static boolean testPangramm2(String str) {
    String buchstaben = "abcdefghijklmnopqrstuvwxyz";
    boolean rueckgabe = true;
    str = str.toLowerCase();
    for(int i = 0; i < buchstaben.length(); i++) {
        if((str.indexOf(buchstaben.charAt(i)) == -1)) {
            rueckgabe = false;
            break;
        }
    }
    return rueckgabe;
}
}
