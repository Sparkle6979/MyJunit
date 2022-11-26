import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyCalculateTest {

    @MyJunit.MyBefore
    public void begin(){
        System.out.println("Calculate Begin");
    }

    @MyJunit.MyTest
    public void testadd(){
        assertEquals(2,new MyCalculate().sum(1,1));
    }

    @MyJunit.MyTest
    public void testdiff(){
        assertEquals(4,new MyCalculate().diff(5,1));
    }

    @MyJunit.MyAfter
    public void end(){
        System.out.println("Calculate End");
    }

}
