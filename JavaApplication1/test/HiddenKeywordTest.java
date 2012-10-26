/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javaapplication1.HiddenKeyword;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class HiddenKeywordTest {

    public HiddenKeywordTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        HiddenKeyword h = new HiddenKeyword();
        String rword = h.getRword();
        assertNotNull(rword);
    }

    @Test
    public void testGuess() {
        HiddenKeyword h = new HiddenKeyword();
        h.rword = "cat";
        boolean result = h.guess('c');
        assertEquals(true, result);
        assertEquals(1, h.lfoundNumber);
    }
    
    @Test
    public void testCorrectGuessDuplicateLetters() {
        HiddenKeyword h = new HiddenKeyword();
        h.rword = "banana";
        boolean result = h.guess('a');
        assertEquals(true, result);
        assertEquals(3, h.lfoundNumber);
    }
    
    @Test
    public void testWrongGuess() {
        HiddenKeyword h = new HiddenKeyword();
        h.rword = "cat";
        boolean result = h.guess('d');
        assertEquals(false, result);
        assertEquals(0, h.lfoundNumber);
    }

    @Test
    public void testNotYetFound() {
        HiddenKeyword h = new HiddenKeyword();
        h.rword = "cat";
        h.guess('c');
        assertEquals(false, h.found());
    }

    @Test
    public void testFound() {
        HiddenKeyword h = new HiddenKeyword();
        h.rword = "cat";
        h.guess('c');
    
        h.guess('a');
        h.guess('t');
        assertEquals(true, h.found());
    }
     public void testFound2() {
        HiddenKeyword h = new HiddenKeyword();
        h.rword = "cat";
        h.guess('c');
        h.guess('m');
        h.guess('a');
        h.guess('t');
        assertEquals(true, h.found());
     }
        public void testFound3() {
        HiddenKeyword h = new HiddenKeyword();
        h.rword = "cat";
        h.guess('c');
        h.guess('m');
        h.guess('n');
        h.guess('a');
        h.guess('t');
        assertEquals(true, h.found());
    }
    
   @Test
    public void testToString() {
        HiddenKeyword h = new HiddenKeyword();
        h.setRword("cat");
        h.guess('c');
        h.guess('a');
        assertEquals("ca-", h.toString());
    }
    
//   public 
}
