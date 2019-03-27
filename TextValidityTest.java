

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TextValidityTest.
 *
 * @author  Li Peiyao
 * @version (2019.03.27)
 */
public class TextValidityTest
{
    private TextValidity textVali1;
    private TextValidity textVali2;
    private TextValidity textVali3;
    private TextValidity textVali4;
    /**
     * Default constructor for test class TextValidityTest
     */
    public TextValidityTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        textVali1 = new TextValidity();
        textVali2 = new TextValidity();
        textVali3 = new TextValidity();
        textVali4 = new TextValidity();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test the ckeck validity method tor the name format.
     */
    @Test
    public void testNameValidity()
    {
        assertEquals(true, textVali1.validName("Jason Zhang"));
        assertEquals(false, textVali2.validName("Jackson 89"));
        assertEquals(false, textVali3.validName("3435546678"));
        assertEquals(true, textVali4.validName("Jackson Yee"));
    }
    
    /**
     * Test the ckeck validity method tor the number format.
     */
    @Test
    public void testNumberValidity()
    {
        assertEquals(true, textVali1.validNumber("34377685"));
        assertEquals(false, textVali2.validNumber("Jason Zhang"));
        assertEquals(true, textVali3.validNumber("3245 6975"));
        assertEquals(false, textVali4.validNumber("Jackson 2821"));
    }
    
    /**
     * Test the ckeck validity method tor the date format.
     */
    @Test
    public void testDateValidity()
    {
        assertEquals(true, textVali1.validDate("09/12/2019"));
        assertEquals(false, textVali2.validDate("32/12/2019"));
        assertEquals(false, textVali3.validDate("12/13/2019"));
        assertEquals(false, textVali4.validDate("25/07/1989"));
        assertEquals(true, textVali1.validDate("06/07/2020"));
        assertEquals(false, textVali2.validDate("7/8/2019"));
        assertEquals(true, textVali3.validDate("20/12/2021"));
        assertEquals(false, textVali4.validDate("28/11/2008"));
        assertEquals(false, textVali1.validDate("0912/2019"));
    }
}



