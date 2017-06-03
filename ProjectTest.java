

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProjectTest for student test cases.
 * Add all new test cases to this task.
 *
 * @author  Tom Copcutt 22248715, Clayton Duncan 22251348
 * @version 3/6/2017
 */
public class ProjectTest
{
    /**
     * Default constructor for test class ProjectTest
     */
    public ProjectTest()
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
     * Ensures that the lines in the string are at least the number of distinct characters + 1
     */
    @Test(timeout=1000)
    public void testSensibleToStringSize() {
        NgramAnalyser test = new NgramAnalyser(2, "aabaaabc");
        assertTrue( countLines(test.toString()) >= test.getAlphabetSize()+1); 
    }

    private static int countLines(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        int lines = 1;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0) {
            lines++;
        }
        return lines;
    }

    @Test(timeout=1000)
    public void testGetDistinctNgrams() {
         assertEquals(0,1); //TODO replace with test code
    }
    /**
     * Ensures that the returned laplace estimates are equal to what they should be given the example.
     */
    @Test(timeout=1000)
    public void testLaplaceExample() {
        //due to comparison of doubles being "deprecated", both answers had to be multiplied by 1000 and converted to ints.
        MarkovModel model = new MarkovModel(2,"aabcabaacaac");
        assertEquals((int) Math.round(model.laplaceEstimate("aac")*10000), 5000);
        assertEquals((int) Math.round(model.laplaceEstimate("aaa") * 10000), 1667);
        assertEquals((int) Math.round(model.laplaceEstimate("aab") * 10000), 3333);
    }
    /**
     * Ensures that the returned simple estimates are equal to what they should be in the given example.
     */
    @Test(timeout=1000)
    public void testSimpleExample() {
        MarkovModel model = new MarkovModel(2,"aabcabaacaac");
        assertEquals((int) Math.round(model.simpleEstimate("aac")*10000), 6667);
        assertEquals((int) Math.round(model.simpleEstimate("aaa")*10000), 0);
        assertEquals((int) Math.round(model.simpleEstimate("aab")*10000), 3333);
    }
    /**
     * Ensures that the returned average is equal to what it should be in the given example.
     */
    @Test
    public void testTask3example() {
        /*
        In this case the absolute value of the output had to be taken. This is acceptable because the output will never produce a positive number.
        The boundary case would be an ngram which only contains a single character type, like "aaaaa", then the alphabet size will be 1 and if
        looking for "aaa", the laplace estimation will be 1 and the log will be 0. Any other case will result in a laplace estimate being a
        fraction < 1, resulting in a negative log value.
        */
        MarkovModel model = new MarkovModel(2,"aabcabaacaac");
        ModelMatcher match = new ModelMatcher(model,"aabbcaac");
        assertEquals((int)Math.abs(Math.round(match.getAverageLogLikelihood()*10000)) ,3849); 
    }
}
