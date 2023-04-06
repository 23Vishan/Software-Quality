package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;

/**
 * Hello world!
 *
 */
public class App 
{
	/**
	* Main program:  The entry point of the program. The local time will be printed first,
	*      Then it will create two binary variables, add them and print the result.
	*
	* @param args: not used
	*/
    public static void main( String[] args )
    {
		System.out.println("--------------------------------------------------------------------------");

		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		System.out.println("--------------------------------------------------------------------------");

		Binary binary1 = new Binary("00010001000");
        System.out.println( "First binary number is "+ binary1.getValue());

		Binary binary2 = new Binary("111000");
        System.out.println( "Second binary number is "+ binary2.getValue());
		System.out.println("--------------------------------------------------------------------------");

		Binary or = Binary.or(binary1, binary2);
		System.out.println("Their bitwise logical OR is " + or.getValue());

		Binary and = Binary.and(binary1, binary2);
		System.out.println("Their bitwise logical AND is " + and.getValue());
		System.out.println("--------------------------------------------------------------------------");

		System.out.println("Value of first binary number in decimal is " + binary1.binToDec());
		System.out.println("Value of second binary number in decimal is " + binary2.binToDec());
		System.out.println("--------------------------------------------------------------------------");

		Binary mul = Binary.multiply(binary1, binary2);
		System.out.println("The product is " + mul.getValue() + " or " + mul.binToDec() + " in decimal");
		
		System.out.println("--------------------------------------------------------------------------");
    }
}
