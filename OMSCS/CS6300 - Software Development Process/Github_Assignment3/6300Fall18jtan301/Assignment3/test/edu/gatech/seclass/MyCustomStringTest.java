package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Junit test class created for use in Georgia Tech CS6300.
 *
 * This is an test class for a simple class that represents a string, defined
 * as a sequence of characters.
 *
 * You should implement your tests in this class.  Do not change the test names.
 */

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    //Test Purpose: This is the first instructor example test.
    /*
    *
    *  This is to check duplicates in LETTERS (uppercase or lowercase) and ELLIPSES(...)
    *  or SPECIAL CHARACTER ONLY
    *  
    *  ee = 1                                                        
    *  ... = 2                                                       
    *  zz = 1                                                        
    *  Total = 4                                                     
    *
    * */
    @Test
    public void testCountDuplicates1() {
        mycustomstring.setString("People are sleeping... Zzz.");
        assertEquals(4, mycustomstring.countDuplicates());
    }

    /*
    *
    *  This is to check duplicates in LETTERS and NUMBERS ONLY
    *
    *  ll = 1                                         
    *  111 = 2                                        
    *  pp = 1                                         
    *  Total = 4                                      
    *
    * */
    @Test
    public void testCountDuplicates2() {
        mycustomstring.setString("Billy has 111 apples");
        assertEquals(4, mycustomstring.countDuplicates());
    }

    //This checks if current string is NULL, it expects to return 0
    @Test
    public void testCountDuplicates3() {
        mycustomstring.setString(null);
        assertEquals(0, mycustomstring.countDuplicates());
    }

    //This checks if current string is EMPTY(""), it expects to returns 0
    @Test
    public void testCountDuplicates4() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countDuplicates());
    }

    /*
    *
    * This count duplicates when it has LETTERS AND WHITESPACES(" ")
    * (Whitespace counts as characters):
    *                                                        
    *   " " (WHITESPACE) = 4
    *   ee = 1
    *   Total = 5
    *
    * */
    @Test
    public void testCountDuplicates5() {
        mycustomstring.setString("I love     meem");
        assertEquals(5, mycustomstring.countDuplicates());
    }

     /*                                                                            
     *                                                                             
     * This count duplicates for ONLY UNIQUE LETTERS and SPECIAL CHARACTERS (No Duplicates)
     *                                                                             
     * */                                                                          
     @Test                                                                         
     public void testCountDuplicates6() {
         mycustomstring.setString("abcdefg,hijklmnophijklmn0pqrstuvwxyz;.!@#$%^&*`");
         assertEquals(0, mycustomstring.countDuplicates());
     }                                                                             

    //Test Purpose: This is the second instructor example test.
    /*
    *
    * This is to test addDigits to +4 on EVERY digits (from 0 to 9 or 9 to 0) because positive is true
    * when string takes NUMBERS, LETTERS, WHITESPACE, and SPECIAL CHARACTERS
    *
    * original: 1234!!! (+4)    H3y (+4)   50me (+4)   d161ts (+4) 5tr1n6!11!1 (+4)
    * expected: 5678!!!         H7y        94me        d505ts      9tr5n0!55!5
    *
    * */
    @Test
    public void testAddDigits1() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("5678!!! H7y, l7t'9 put 94me d505ts in this 9tr5n0!55!5", mycustomstring.addDigits(4, true));
    }

    //Test Purpose: This the third instructor example test.
    /*
    *
    * This is to test addDigits to -4 on EVERY digits (from 0 to 9 or 9 to 0) because positive is false
    * when string takes NUMBERS, LETTERS, WHITESPACE, and SPECIAL CHARACTERS
    *                                                                                                  
    *  original: 1234!!!(-4)     H3y(-4)     50me(-4)    d161ts(-4)  5tr1n6!11!1(-4)
    *  expected: 5678!!!         H7y         94me        d505ts       9tr5n0!55!5
    *
    * */
    @Test
    public void testAddDigits2() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("7890!!! H9y, l9t'1 put 16me d727ts in this 1tr7n2!77!7", mycustomstring.addDigits(4, false));
    }


     /*
     *
     * This is to test addDigits to +5 on EVERY digital (from 0 to 9 or 9 to 0) because position returns true
     * when string takes ONLY SPECIAL CHARACTERS
     *
     * original: !@#$%^&*()_+,` (+5)
     * expected: !@#$%^&*()_+,`
     *
     * */
     @Test
     public void testAddDigits3() {
         mycustomstring.setString("!@#$%^&*()_+,`");
         assertEquals("!@#$%^&*()_+,`", mycustomstring.addDigits(5, true));
     }



    /*
    *
    * This is to test addDigits to +4 on EVERY digits (ONLY DIGITS) (from 0 to 9 or 9 to 0) because positive is true
    * when string takes ONLY NUMBERS
    *
    *   original: 1234567890 (+4)
    *   expected: 5678901234
    *
    * */
    @Test
    public void testAddDigits4() {
        mycustomstring.setString("1234567890");
        assertEquals("5678901234", mycustomstring.addDigits(4, true));
    }

    /*
    *
    * This is to test addDigits to -4 on EVERY digits (from 0 to 9 or 9 to 0) because position returns false
    * when string takes ONLY NUMBERS
    *
    * original: 1234567890 (-4)
    * expected: 7890123456
    *
    * */
    @Test
    public void testAddDigits5() {
        mycustomstring.setString("1234567890");
        assertEquals("7890123456", mycustomstring.addDigits(4, false));
    }

    /*
    *
    * This is to test addDigits to +2 on EVERT digital (from 0 to 9 or 9 to 0) because position returns false
    * when string takes ONLY LETTERS
    *
    * original: OnlyLetters (+2)
    * expected: OnlyLetters
    * 
    * */
    @Test
    public void testAddDigits6() {
        mycustomstring.setString("OnlyLetters");
        assertEquals("OnlyLetters", mycustomstring.addDigits(2, true));
    }

    /*
    *
    * This is to test addDigits to +4 on EVERT digital (from 0 to 9 or 9 to 0) because position returns true
    * When string ONLY takes WHITESPACES(" ")
    *
    * */
    @Test
    public void testAddDigits7() {
        mycustomstring.setString(" ");
        assertEquals(" ", mycustomstring.addDigits(4, true));
    }

    /*
    *
    * This is to test addDigits to throw NullPointerException because string is null
    * for a negative number when boolean positive returns false.
    *
    * */                                                                                  
    @Test(expected = NullPointerException.class)
    public void testAddDigits8() {
        mycustomstring.addDigits(-4, false);
    }

    /*
    *
    * This is to test addDigits to throw NullPointerException because string is null
    * for a positive number when boolean positive returns true.
    *
    * */
    @Test(expected = NullPointerException.class)
    public void testAddDigits9() {
        mycustomstring.addDigits(4, true);
    }

    /*
    *
    * This is to test addDigits to throw IllegalArgumentException when n > 9 (10) and current string is NOT NULL
    * when positive returns true because it attempts to add 10 to every digit.
    *
    * */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits10() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        mycustomstring.addDigits(10, true);
    }

    /*
    *
    * This is to test addDigits to throw IllegalArgumentException when n == 0 and
    * current string is NOT NULL when positive returns true because it attempts to add 0 to every digit.
    *
    * */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits11() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        mycustomstring.addDigits(0, true);
    }

     /*
     *
     * This is to test addDigits to throw IllegalArgumentException when n < 0 (-1) and current string is NOT NULL
     * when positive is true because it tries to subtract -1 to every digit.                                     
     *
     * */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits12() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        mycustomstring.addDigits(-1, false);
    }


    //Test Purpose: This is the fourth instructor example test.
    /*
    *
    * This is the check flipLetttersInSubstring() method that take the string of LETTERS, WHITESPACE,
    * SPECIAL CHARACTER, and reverse startPosition with endPosition of ALL LETTERS ONLY (a-z and A-Z)
    *
    * original: me D161ts in                                                                              
    * expected: ni s161tD em                                                                              
    *
    * */
    @Test
    public void testFlipLetttersInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(18, 30);
        assertEquals("H3y, l3t'5 put 50ni s161tD em this 5tr1n6!11!!", mycustomstring.getString());
    }

    //Test Purpose: This is an instructor example test to demonstrate testing for an exception.
    /*
    *
    *  This is check flipLetttersInSubstring() method that throws NullPointerException
    *  if current string is null
    *
    * */
    @Test(expected = NullPointerException.class)
    public void testFlipLetttersInSubstring2() {
        mycustomstring.flipLetttersInSubstring(200, 100);
    }

    /*
    *
    *  This is check flipLetttersInSubstring() method that throws MyIndexOutOfBoundsException
    *  if current string is NOT NULL and endPosition > length of string (1 > 0)
    *
    * */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testFlipLetttersInSubstring3() {
        mycustomstring.setString("");
        mycustomstring.flipLetttersInSubstring(1, 1);
    }

     /*                                                                                       
     *                                                                                        
     *  This is check flipLetttersInSubstring() method that throws MyIndexOutOfBoundsException
     *  if current string is NOT NULL and startPosition < 0 (-8 < 0)
     *                                                                                        
     * */                                                                                     
    @Test(expected = MyIndexOutOfBoundsException.class)   
    public void testFlipLetttersInSubstring4() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(-8, 30);
    }

     /*
     *
     *  This is check flipLetttersInSubstring() method that throws MyIndexOutOfBoundsException
     *  if current string is NOT NULL and startPosition == 0 (0 = 0)
     *
     * */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testFlipLetttersInSubstring5() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(0, 31);
    }

     /*
     *
     * This is the check flipLetttersInSubstring() method that take ONLY LETTERS and
     * reverse startPosition with endPosition of ALL LETTERS ONLY (a-z and A-Z)
     *
     * original: Rat
     * expected: taR
     *
     * */
    @Test
    public void testFlipLetttersInSubstring6() {
        mycustomstring.setString("Rat");
        mycustomstring.flipLetttersInSubstring(1, 3);
        assertEquals("taR", mycustomstring.getString());
    }
    
     /*                                                                                         
     *                                                                                          
     *  This is check flipLetttersInSubstring() method that throws IllegalArgumentException
     *  if current string is NOT NULL and neither position is out of bound
     *  (startPosition > 0 and endPosition < length of string) and startPostion > endPosition (18 > 2)
     *                                                                                          
     * */                                                                                       
    @Test(expected = IllegalArgumentException.class)
    public void testFlipLetttersInSubstring7() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(18, 2);
    }

     /*
     *
     * This is the check flipLetttersInSubstring() method that takes a string of SPECIAL CHARACTERS
     * and reverse startPosition with endPosition of ALL LETTERS ONLY (a-z and A-Z)
     *
     * original: $@#!$&*^,@!#%&@
     * expected: $@#!$&*^,@!#%&@
     *
     * */
    @Test
    public void testFlipLetttersInSubstring8() {
        mycustomstring.setString("$@#!$&*^,@!#%&@");
        mycustomstring.flipLetttersInSubstring(2, 15);
        assertEquals("$@#!$&*^,@!#%&@",  mycustomstring.getString());
    }


    /*
    *
    * This is the check flipLetttersInSubstring() method that takes a string of
    * NUMBERS and reverse startPosition with endPosition of ALL LETTERS ONLY (a-z and A-Z)
    *
    * original: 1234567890
    * expected: 1234567890
    *
    * */
    @Test
    public void testFlipLetttersInSubstring9() {
        mycustomstring.setString("1234567890");
        mycustomstring.flipLetttersInSubstring(1, 10);
        assertEquals("1234567890", mycustomstring.getString());
    }

    /*
    *
    * This is the check flipLetttersInSubstring() method that takes a string of
    * WHITESPACE ONLY and reverse startPosition with endPosition of ALL LETTERS ONLY (a-z and A-Z)
    *
    * original:
    * expected:             
    *
    * */
    @Test
    public void testFlipLetttersInSubstring10() {
        mycustomstring.setString("            ");
        mycustomstring.flipLetttersInSubstring(1, 12);
        assertEquals("            ", mycustomstring.getString());
    }

}
