package uk.ac.ucl.jsh;

import static org.junit.Assert.assertEquals;

class EchoTest extends FuncTest {

    EchoTest() throws Exception {
    }
    
    public void test() throws Exception {
        Jsh.eval("echo test", out);
        assertEquals(scn.next(), "test");
    }
}