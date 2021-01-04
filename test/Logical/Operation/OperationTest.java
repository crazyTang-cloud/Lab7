package Logical.Operation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {
    @Test
    public void testAccumulation(){
        Operator operator = new Operation();
        assertEquals(-1,operator.Accumulation(-3));
        assertEquals(-1,operator.Accumulation(-1));
        assertEquals(-1,operator.Accumulation(0));
        assertEquals(1,operator.Accumulation(1));
        assertEquals(6,operator.Accumulation(3));
    }

    @Test
    public void testCirculation(){
        Operator operator = new Operation();
        assertEquals(13,operator.Circulation(13));
        assertEquals(10,operator.Circulation(10));
        assertEquals(19,operator.Circulation(9));
        assertEquals(27,operator.Circulation(8));
        assertEquals(45,operator.Circulation(5));
        assertEquals(54,operator.Circulation(2));
        assertEquals(55,operator.Circulation(1));
        assertEquals(0,operator.Circulation(0));
    }


    @Test
    public void testRole(){
        Operator operator = new Operation();
        assertEquals(11,operator.Role(5));
        assertEquals(6,operator.Role(0));
        assertEquals(3,operator.Role(-3));
    }

}
