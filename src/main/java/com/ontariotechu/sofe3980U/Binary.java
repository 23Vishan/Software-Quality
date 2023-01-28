package com.ontariotechu.sofe3980U;

/**
* Unsigned integer Binary variable
*/
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'

	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored. Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number)
	{
		// check each character if it's not 0 or 1
		for (int i = 0; i < number.length(); i++)
		{
			char ch = number.charAt(i);

			// if not store "0" and end the function
			if (ch != '0' && ch != '1')
			{
				number = "0";
				return;
			}
		}

		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++)
		{
			if (number.charAt(beg) != '0')
			break;
		}
		
		// beg has the index of the first non zero digit in the number
		if (beg == number.length())
		{
			// replace strings with only zeros with a single zero
			this.number = "0";		
		}
		else
		{
			// exclude the trailing zeros if any
			this.number = number.substring(beg);
		}
    }

	/**
	* Returns the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}

	/**
	* Adds two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1, Binary num2)
	{
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;

		int carry = 0;     // initial variable
		String num3 = "";  // the binary value of the sum

		// loop until all digits are processed
		while (ind1 >= 0 ||  ind2 >= 0 || carry != 0)
		{
			int sum = carry; // previous carry

			// if num1 has a digit to add
			if (ind1 >= 0)
			{
				sum += (num1.number.charAt(ind1) == '1') ? 1:0; // convert the digit to int and add it to sum
				ind1--;                                         // update ind1
			}

			// if num2 has a digit to add
			if (ind2 >= 0)
			{
				sum += (num2.number.charAt(ind2) == '1') ? 1:0; // convert the digit to int and add it to sum
				ind2--;                                         // update ind2
			}

			carry = sum / 2;                       // the new carry
			sum = sum % 2;                         // the resultant digit
			num3 = ((sum == 0) ? "0":"1") + num3;  // convert sum to string and append it to num3
		}

		Binary result = new Binary(num3);  // create a binary object with the calculated value.
		return result;
	}

	/**
	* Calculates the bitwise logical OR of two binary numbers
	*
	* @param num1 The first binary variable
	* @param num2 The second binary variable
	* @return A binary variable with a value of <i>num1 OR num2</i>.
	*/
	public static Binary or(Binary num1, Binary num2)
	{
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;

		String num3 = "";  // the binary value of the bitwise logical OR
		int or = 0;        // bitwise logical OR of the nth index

		// loop until all digits are processed
		while (ind1 >= 0 ||  ind2 >= 0)
		{
			or = 0; // reset

			// if num1 has a digit
			if (ind1 >= 0)
			{
				or = (num1.number.charAt(ind1) == '1') ? 1 : or;
				ind1--;
			}

			// if num2 has a digit
			if (ind2 >= 0)
			{
				or = (num2.number.charAt(ind2) == '1') ? 1 : or;
				ind2--;
			}

			// append result to num3}
			num3 = (or == 1) ? ("1" + num3) : ("0" + num3);
		}

		// create a binary object with the calculated value
		Binary result = new Binary(num3);
 
		return result;
	}

	/**
	* Calculates the bitwise logical AND of two binary numbers
	*
	* @param num1 The first binary variable
	* @param num2 The second binary variable
	* @return A binary variable with a value of <i>num1 AND num2</i>.
	*/
	public static Binary and(Binary num1, Binary num2)
	{
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;

		String num3 = "";  // the binary value of the bitwise logical OR
		int and = 0;       // bitwise logical OR of the nth index

		// loop until all digits are processed
		while (ind1 >= 0 ||  ind2 >= 0)
		{
			and = 0; // reset

			// if num1 has a digit
			if (ind1 >= 0)
			{
				// if num2 has a digit in the same index
				if (ind2 >= 0)
				{
					and = (num1.number.charAt(ind1) == '1') ? 1 : 0;
				}
				ind1--;
			}

			// if num2 has a digit
			if (ind2 >= 0)
			{
				// if num1 has a '1' in the same index
				if (and == 1)
				{
					and = (num2.number.charAt(ind2) == '1') ? 1 : 0;
				}
				ind2--;
			}

			// append result to num3
			num3 = (and == 1) ? ("1" + num3) : ("0" + num3);
		}

		// create a binary object with the calculated value
		Binary result = new Binary(num3);
 
		return result;
	}

	/**
	* Multiples the two binary variables
	*
	* @param num1 The first binary variable
	* @param num2 The second binary variable
	* @return A binary variable with a value of <i>num1 x num2</i>.
	*/
	public static Binary multiply(Binary num1, Binary num2)
	{
		// holds the current sum after each iteration of addition 
		Binary product = new Binary("0");

		// performs multiplication by repeated addition
		for (int count = 0; count < (num2.binToDec()); count++)
		{
			product = Binary.add(product, num1);
		}

		return product;
	}

	/**
	* Returns the decimal value of the binary object
	*
	* @return A int variable with a value of <i>the binary variable in decimal</i>.
	*/
	public int binToDec()
	{
		// the index of the first digit
		int ind1 = number.length() - 1;
		
		int power = 1; //number to multiply by to convert bin to dec
		int num2 = 0;  // value of num1 in decimal

		// loop until all digits are processed
		while (ind1 >= 0)
		{
			if (number.charAt(ind1) == '1')
			{
				num2 += (power * 1);
			}

			power *= 2;
			ind1--;
		}
		return num2;
	}
}	
