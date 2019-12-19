package uk.ac.ucl.jsh;

import org.junit.Test;

public class JshTest {
    public JshTest() {
    }

    @Test
    public void testJsh() throws Exception {
        Jsh.eval("echo mama a\"m\"a", System.out);
        //Jsh.eval("echo jas", System.out);
        assert(true);
    }

}
