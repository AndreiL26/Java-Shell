package uk.ac.ucl.jsh;
 
import org.junit.Test;
 
 
public class JshTest {
    public JshTest() {
    }
 
    @Test
    public void testJsh() throws Exception {
       Jsh.eval("eCHo `echo mama | cat`", System.out);

    }
}

