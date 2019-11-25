package uk.ac.ucl.jsh;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class EchoTest extends FuncTest {

    EchoTest() throws Exception {
    }
    
    @Test
    public void test() throws Exception {
        Jsh.eval("echo test", out);
        //assertEquals(scn.next(), "test");
    }
}