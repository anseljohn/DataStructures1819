import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test methods for the StringUtilities class
 * @author AnselmJA20
 * @version 9.13.18
 */
public class StringUtilitiesTest
{
    private StringUtilities nullString;
    private StringUtilities helloWorld;
    private StringUtilities singleChar;
    private StringUtilities doubleSame;
    private StringUtilities diffChars;
    private StringUtilities allUpper;
    private StringUtilities allLower;
    private StringUtilities allNums;
    private StringUtilities shhhh;
    private StringUtilities shhs;
    private StringUtilities shsh;

    /**
     * supercalifragilisticexpialidocious
     */
    @Before
    public void setUp()
    {
        nullString = new StringUtilities();
        helloWorld = new StringUtilities( "Hello, World!" );
        singleChar = new StringUtilities( "z" );
        doubleSame = new StringUtilities( "zz" );
        diffChars = new StringUtilities( "az" );
        allUpper = new StringUtilities( "UPPER" );
        allLower = new StringUtilities( "lower" );
        allNums = new StringUtilities( "124356" );
        shhhh = new StringUtilities( "shhhh!" );
        shhs = new StringUtilities( "shhs" );
        shsh = new StringUtilities( "shsh" );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @After
    public void tearDown()
    {
        nullString = null;
        helloWorld = null;
        singleChar = null;
        doubleSame = null;
        diffChars = null;
        allNums = null;
        shhhh = null;
        shhs = null;
        shsh = null;
    }

    // Reverse tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testReverseWithNull()
    {
        assertNull( nullString.toString() );
        nullString.reverse();
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testReverseWithSingleChar()
    {
        assertEquals( "z", singleChar.reverse() );

    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testReverseWithDoubleSameChar()
    {
        assertEquals( "zz", doubleSame.reverse() );

    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testReverseWithDoubleDifferentChar()
    {
        assertEquals( "za", diffChars.reverse() );

    }

    // Reverse with indices tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testReverseIndicesWithDiffChar()
    {
        assertEquals( "za", diffChars.reverse( 0, 2 ) );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testReverseIndicesWithHelloWorld()
    {
        assertEquals( "eH", helloWorld.reverse( 0, 2 ) );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testReverseIndicesHelloWorldMid()
    {
        assertEquals( "ol", helloWorld.reverse( 3, 5 ) );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = IllegalArgumentException.class )
    public void testReverseIndicesIllegalIndices()
    {
        assertEquals( singleChar.toString(), singleChar.toString() );
        singleChar.reverse( 1, 0 );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testReverseIndicesWithNull()
    {
        assertNull( nullString.toString() );
        nullString.reverse( 0, 1 );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = IllegalArgumentException.class )
    public void testReverseIndicesWithNegFrom()
    {
        assertEquals( "Hello, World!", helloWorld.toString() );
        helloWorld.reverse( -1, 0 );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = IllegalArgumentException.class )
    public void testReverseIndicesWithBigTo()
    {
        assertEquals( "Hello, World!", helloWorld.toString() );
        helloWorld.reverse( 0, 123812 );
    }

    // toString tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testToStringWithNull()
    {
        assertNull( nullString.toString() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testToStringWithChars()
    {
        assertEquals( "Hello, World!", helloWorld.toString() );
    }

    // isAllUpper tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testAllUpperWithUpper()
    {
        assertTrue( allUpper.isAllUpper() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testAllUpperWithNumbers()
    {
        assertTrue( allNums.isAllUpper() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testAllUpperWithNull()
    {
        assertNull( nullString.toString() );
        nullString.isAllUpper();
    }

    // isAllLower tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testAllLowerWithLower()
    {
        assertTrue( allLower.isAllLower() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testAllLowerWithNums()
    {
        assertTrue( allNums.isAllLower() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testAllLowerWithNull()
    {
        assertNull( nullString.toString() );
        nullString.isAllLower();
    }

    // containsNumbers tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testContainsNumbersNoNums()
    {
        assertFalse( helloWorld.containsNumbers() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testContainsNumbersAllNums()
    {
        assertTrue( allNums.containsNumbers() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testContainsNumbersWithNull()
    {
        assertNull( nullString.toString() );
        nullString.containsNumbers();
    }

    // isNumber tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testIsNumberWithNumber()
    {
        assertTrue( allNums.isNumber() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testIsNumberWithString()
    {
        assertFalse( helloWorld.isNumber() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testIsNumberWithNegative()
    {
        StringUtilities negNum = new StringUtilities( "-1" );
        assertTrue( negNum.isNumber() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testIsNumberWithDecimal()
    {
        StringUtilities decNum = new StringUtilities( ".1" );
        assertTrue( decNum.isNumber() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testIsNumberWithRandomDecimal()
    {
        StringUtilities ranDec = new StringUtilities( "1.1" );
        assertTrue( ranDec.isNumber() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testIsNumberWithNotNegative()
    {
        StringUtilities notNegNum = new StringUtilities( "1-2" );
        assertFalse( notNegNum.isNumber() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testIsNumberWithNull()
    {
        assertNull( nullString.toString() );
        nullString.isNumber();
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testIsNumberWithTwoDecimals()
    {
        StringUtilities twoDec = new StringUtilities( "2.3.2" );
        assertFalse( twoDec.isNumber() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testIsNumberWithStrings()
    {
        assertFalse( helloWorld.isNumber() );
    }

    // setString tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testSetStringWithString()
    {
        StringUtilities ran = new StringUtilities( "abc" );
        ran.setString( "cba" );
        assertEquals( "cba", ran.toString() );
    }

    // numConsecutiveDuplicates tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testNumConsecutiveDuplicatesWithNull()
    {
        assertNull( nullString.toString() );
        nullString.numConsecutiveDuplicates();
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testNumConsecutiveDuplicatesWithThree()
    {
        assertEquals( 3, shhhh.numConsecutiveDuplicates() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testNumConsecutiveDuplicatesWithNonConsec()
    {
        assertEquals( 0, shsh.numConsecutiveDuplicates() );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testNumConsecutiveDuplicatesWithTwo()
    {
        assertEquals( 1, shhs.numConsecutiveDuplicates() );
    }

    // numMatches(  char c  ) tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testNumMatchesWithNull()
    {
        assertNull( nullString.toString() );
        nullString.numMatches( 'c' );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testNumMatchesWithShhhh()
    {
        assertEquals( 4, shhhh.numMatches( 'h' ) );
        assertEquals( 1, shhhh.numMatches( 's' ) );
        assertEquals( 0, shhhh.numMatches( 'z' ) );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testNumMatchesWithShhs()
    {
        assertEquals( 2, shhs.numMatches( 's' ) );
        assertEquals( 2, shhs.numMatches( 'h' ) );
    }

    // numMatches(  String other  ) tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testNumMatchesStrWithNull()
    {
        assertNull( nullString.toString() );
        nullString.numMatches( "String" );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testNumMatchesStrParamNull()
    {
        assertNull( nullString.toString() );
        helloWorld.numMatches( null );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testNumMatchesStrWithShsh()
    {
        assertEquals( 2, shsh.numMatches( "sh" ) );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testNumMatchesStrWithShhs()
    {
        assertEquals( 1, shhs.numMatches( "sh" ) );
        assertEquals( 2, shhs.numMatches( "s" ) );
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testNumMatchesStrWithShhsNada()
    {
        assertEquals( 0, shsh.numMatches( "asjdklasjdlkjwdqhwoidn" ) );
    }

    // asArray tests
    /**
     * supercalifragilisticexpialidocious
     */
    @Test( expected = NullPointerException.class )
    public void testAsArrayNull()
    {
        assertNull( nullString.toString() );
        nullString.asArray();
    }

    /**
     * supercalifragilisticexpialidocious
     */
    @Test
    public void testAsArrayLower()
    {
        assertArrayEquals( new char[] { 'l', 'o', 'w', 'e', 'r' }, 
                allLower.asArray() );
    }
}
