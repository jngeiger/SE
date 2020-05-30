package doubleAutomat;


//Test Cases
/* 12.232E-4 -> OK : RESULT -> OK
* 12.0 -> OK : RESULT -> OK
* 1.23232E -> NOK : RESULT -> NOK
* 1.234424E2 -> -> OK : RESULT -> OK
* 0.232 -> OK : RESULT -> OK
* 0.232E-2 -> OK : RESULT -> OK
* HALLO -> -> NOK : RESULT -> NOK
* 0,232 -> NOK : RESULT -> NOK
* 12F232 -> -> NOK : RESULT -> NOK
* 12.434e1 -> OK : RESULT -> OK
*/


enum State { 
	ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN;
}; 

public class DoubleAutomat {
State currentState = State.ONE;
private String value;
private boolean isValid;


public static void main(String[] args)
{
	DoubleAutomat automat = new DoubleAutomat("12.434e1");
	System.out.println(automat.checkValue());
}


public DoubleAutomat(String s)
{
	this.value = s;
}

public boolean checkValue()
{
	isValid = true;
	currentState = State.ONE;
	int i = 0;
	while (i < value.length() && isValid)
	{
		enter(value.charAt(i++));
	}
	return isValid && checkValidState();
}

public double convert() throws Exception
{
	if (!checkValue()) throw new Exception("Keine valider Doublewert eingegeben!");
	
	else {
		return -1D;
	}
}


private boolean checkValidState()
{
	switch (currentState)
	{
	case THREE: return true;
	case FOUR: return true;
	case FIVE: return true;
	case SIX: return true;
	case NINE: return true;
	case TEN: return true;
	default: return false;
	}
}


private void enter(char x)
{
	switch (currentState)
	{
	case ONE: _fromState1(x); break;
	case TWO: _fromState2(x); break;
	case THREE: _fromState3(x); break;
	case FOUR: _fromState4(x); break;
	case FIVE: _fromState5(x); break;
	case SIX: _fromState6(x); break;
	case SEVEN: _fromState7(x); break;
	case EIGHT: _fromState8(x); break;
	case NINE: _fromState9(x); break;
	case TEN: _fromState10(x); break;
	}
}

private void _fromState1 (char x)
{
	if (_isNumber(x))
	{
		currentState = State.FOUR;
		return;
	}
	else if (x == '0')
	{
		currentState = State.THREE;
		return;
	}
	else if (x == '+' || x == '-')
	{
		return;
	}
	else {
		isValid = false; return;
	}
}

private void _fromState2(char x)
{
	if (_isNumber(x))
	{
		currentState = State.FOUR;
		return;
	}
	else {
		isValid = false;
		return;
	}
}

private void _fromState3(char x)
{
	switch (x)
	{
	case '.': currentState = State.FIVE; return;
	case 'e': currentState = State.SEVEN; return;
	case 'E': currentState = State.SEVEN; return;
	default: isValid = false; return;
	}
}

private void _fromState4(char x)
{
	if (_isNumberPlus0(x))
	{
		return;
	}
	else if (x == '.')
	{
		currentState = State.FIVE;
	}
	else if (x == 'e' || x == 'E')
	{
		currentState = State.SEVEN;
	}
	else {
		isValid = false; return;
	}
}

private void _fromState5(char x)
{
	if (_isNumberPlus0(x))
	{
		currentState = State.SIX;
	}
	else {
		isValid = false; return;
	}
}

private void _fromState6(char x)
{
	if (_isNumberPlus0(x))
		return;
	else if (x == 'e' || x == 'E')
	{	
		currentState = State.SEVEN;
		return;
	}
	else {
		isValid = false;
		return;
	}
}

private void _fromState7(char x)
{
	if (_isNumber(x))
	{
		currentState = State.NINE;
		return;
	}
	else if (x == '+' || x == '-')
	{
		currentState = State.EIGHT;
		return;
	}
	else if (x == '0') {
		currentState = State.TEN;
		return;
	}
	else {
		isValid = false;
		return;
	}
	
}

private void _fromState8(char x)
{
	if (_isNumber(x))
	{
		currentState = State.NINE;
		return;
	}
	else {
		isValid = false;
		return;
	}
}

private void _fromState9(char x)
{
	if (_isNumberPlus0(x))
	{
		return;
	}
	else {
		isValid = false; return;
	}
}

private void _fromState10(char x)
{
	isValid = false; return;
}


// checkt ob ziffer zwischen 1 und 9
private boolean _isNumber(char x)
{
	switch (x)
	{
	case '1': return true;
	case '2': return true;
	case '3': return true;
	case '4': return true;
	case '5': return true;
	case '6': return true;
	case '7': return true;
	case '8': return true;
	case '9': return true;
	default: return false;
	}
}

//checkt ob ziffer zwischen 0 und 9
private boolean _isNumberPlus0(char x)
{
	switch (x)
	{
	case '0': return true;
	case '1': return true;
	case '2': return true;
	case '3': return true;
	case '4': return true;
	case '5': return true;
	case '6': return true;
	case '7': return true;
	case '8': return true;
	case '9': return true;
	default: return false;
	}
}

	
}
