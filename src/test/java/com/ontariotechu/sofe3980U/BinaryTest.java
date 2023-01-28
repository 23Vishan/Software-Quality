package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{

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
