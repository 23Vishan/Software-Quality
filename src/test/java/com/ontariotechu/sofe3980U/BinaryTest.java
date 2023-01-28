package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
	/**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    // OR Test Cases
    //--------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test the OR function with binary numbers of equal length and binary numbers that are both 0000
     */
    @Test
    public void orZero()
    {
		Binary binary1 = new Binary("0000");
		Binary binary2 = new Binary("0000");
		Binary binary3 = Binary.or(binary1,binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    /**
     * Test the OR function with binary numbers of equal length and binary numbers that are both 1111
     */
    @Test
    public void orOne()
    {
		Binary binary1 = new Binary("1111");
		Binary binary2 = new Binary("1111");
		Binary binary3 = Binary.or(binary1,binary2);
        assertTrue(binary3.getValue().equals("1111"));
    }

    /**
     * Test the OR function with binary numbers of the same lengths but different values
     */
    @Test
    public void orDiffLength()
    {
		Binary binary1 = new Binary("10101010");
		Binary binary2 = new Binary("00101010");
		Binary binary3 = Binary.or(binary1,binary2);
        assertTrue(binary3.getValue().equals("10101010"));
    }

    /**
     * Test the OR function with binary numbers of different lengths but different values
     */
    @Test
    public void orSameLength()
    {
		Binary binary1 = new Binary("10101");
		Binary binary2 = new Binary("00101010");
		Binary binary3 = Binary.or(binary1,binary2);
        assertTrue(binary3.getValue().equals("111111"));
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    // AND Test Cases
    //--------------------------------------------------------------------------------------------------------------------------------------------
    
    /**
     * Test the AND function with binary numbers of equal length and binary numbers that are both 0000
     */
    @Test
    public void andZero()
    {
		Binary binary1 = new Binary("0000");
		Binary binary2 = new Binary("0000");
		Binary binary3 = Binary.and(binary1,binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    /**
     * Test the AND function with binary numbers of equal length and binary numbers that are both 1111
     */
    @Test
    public void andOne()
    {
		Binary binary1 = new Binary("1111");
		Binary binary2 = new Binary("1111");
		Binary binary3 = Binary.and(binary1,binary2);
        assertTrue(binary3.getValue().equals("1111"));
    }

    /**
     * Test the AND function with binary numbers of the same lengths but different values
     */
    @Test
    public void andDiffLength()
    {
		Binary binary1 = new Binary("101010");
		Binary binary2 = new Binary("001010");
		Binary binary3 = Binary.and(binary1,binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test the AND function with binary numbers of different lengths but different values
     */
    @Test
    public void andSameLength()
    {
		Binary binary1 = new Binary("10101010");
		Binary binary2 = new Binary("001010");
		Binary binary3 = Binary.and(binary1,binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    // Multiplication Test Cases
    //--------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test the multiply function when variable1 equals zero
     */
    @Test
    public void mulVar1EqualsZero()
    {
		Binary binary1 = new Binary("0000");
		Binary binary2 = new Binary("1111");
		Binary binary3 = Binary.multiply(binary1,binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    /**
     * Test the multiply function when vsriable2 equals zero
     */
    @Test
    public void mulVar2EqualsZero()
    {
		Binary binary1 = new Binary("1111");
		Binary binary2 = new Binary("0000");
		Binary binary3 = Binary.multiply(binary1,binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    /**
     * Test the multiply function when both variables contain only 1's of equal length
     */
    @Test
    public void mulOnlyOnes()
    {
		Binary binary1 = new Binary("111");
		Binary binary2 = new Binary("111");
		Binary binary3 = Binary.multiply(binary1,binary2);
        assertTrue(binary3.getValue().equals("110001"));
    }

    /**
     * Test the multiply function with binary numbers of different values but equal length
     */
    @Test
    public void mulDifferentValueSameLength()
    {
		Binary binary1 = new Binary("101");
		Binary binary2 = new Binary("110");
		Binary binary3 = Binary.multiply(binary1,binary2);
        assertTrue(binary3.getValue().equals("11110"));
    }

    /**
     * Test the multiply function with binary numbers of different values and lengths
     */
    @Test
    public void mulDifferentLengths()
    {
		Binary binary1 = new Binary("1011");
		Binary binary2 = new Binary("110");
		Binary binary3 = Binary.multiply(binary1,binary2);
        assertTrue(binary3.getValue().equals("1000010"));
    }
}
