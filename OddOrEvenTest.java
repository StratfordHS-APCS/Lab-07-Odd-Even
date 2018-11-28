import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.InputStream;

/**
 * The test class OddOrEvenTest.
 *
 * @author  Dave Avis
 * @version 11.27.2018
 */
public class OddOrEvenTest
{
    /**
     * Testing the results of the main method reading from the file.
     */
    @Test(timeout=2000)
    public void mainTest()
    {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        PrintStream origOut = System.out;
        InputStream origIn = System.in;
        String ls = System.getProperty("line.separator");
        
        String[] inputs = { "2", "11", "16", "8", "7", "11", "12", "13", "14" };
        String[] expected = { "even", "odd", "even", "even", "odd", "odd", "even", "odd", "even" };

        System.setOut(ps);
        String[] args = {};
        
        try {
            OddOrEven.main( args );
        } catch (Exception e) {
            System.out.println(e);
        }
        String output = os.toString().trim().toLowerCase();

        String[] lines = output.split("\\" + ls, -1);

        boolean passing = true;
        for( int i = 0; i < inputs.length; i++ )
        {
            if( ! ((lines[i].indexOf( inputs[i] ) >= 0) && (lines[i].indexOf( expected[i] ) >= 0 )) )
            {
                passing = false;
                assertTrue( "Failed: " + lines[i], passing );
            }
        }
    }
}
