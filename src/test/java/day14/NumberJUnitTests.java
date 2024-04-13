package day14;

import org.junit.Test;
import units.Number;

import static org.junit.Assert.assertEquals;

public class NumberJUnitTests {

    @Test
    public void testNumberJUnitTests1() {
        Number number = new Number();
        assertEquals("JUnit: testNumberJUnitTests1 - Failed !", 42, number.getNumber(-5, 5));
        System.out.println("JUnit: testNumberJUnitTests1: Passed !");

    }
    @Test
    public void testNumberJUnitTests2() {
        Number number = new Number();
        assertEquals("JUnit: testNumberJUnitTests2 - Failed !", 65, number.getNumber(10, -20));
        System.out.println("JUnit: testNumberJUnitTests2: Passed !");

    }
    @Test
    public void testNumberJUnitTests3() {
        Number number = new Number();
        assertEquals("JUnit: testNumberJUnitTests3 - Failed !", 102, number.getNumber(1, 100));
        System.out.println("JUnit: testNumberJUnitTests3: Passed !");

    }
    @Test
    public void testNumberJUnitTests4() {
        Number number = new Number();
        assertEquals("JUnit: testNumberJUnitTests4 - Failed !", 42, number.getNumber(-5, 9));
        System.out.println("JUnit: testNumberJUnitTests4: Passed !");

    }
    @Test
    public void testNumberJUnitTests5() {
        Number number = new Number();
        assertEquals("JUnit: testNumberJUnitTests5 - Failed !", 50, number.getNumber(0, 0));
        System.out.println("JUnit: testNumberJUnitTests5: Passed !");

    }

}
