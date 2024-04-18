package tests.testng;
import org.testng.annotations.Test;
import units.Number;

import static org.testng.Assert.assertEquals;

public class NumberTestNGTests {

    @Test
    public void testNumberTestNGTests1() {
        Number number = new Number();
        assertEquals(number.getNumber(-5, 5), 42, "TestNG: testNumberTestNGTests1 - Failed !");
        System.out.println("TestNG: testNumberTestNGTests1: Passed !");
    }

    @Test
    public void testNumberTestNGTests2() {
        Number number = new Number();
        assertEquals(number.getNumber(10, -20), 65, "TestNG: testNumberTestNGTests2 - Failed !");
        System.out.println("TestNG: testNumberTestNGTests2: Passed !");
    }

    @Test
    public void testNumberTestNGTests3() {
        Number number = new Number();
        assertEquals(number.getNumber(1, 100), 102, "TestNG: testNumberTestNGTests3 - Failed !");
        System.out.println("TestNG: testNumberTestNGTests3: Passed !");
    }

    @Test
    public void testNumberTestNGTests4() {
        Number number = new Number();
        assertEquals(number.getNumber(-5, 9), 42, "TestNG: testNumberTestNGTests4 - Failed !");
        System.out.println("TestNG: testNumberTestNGTests4: Passed !");
    }

    @Test
    public void testNumberTestNGTests5() {
        Number number = new Number();
        assertEquals(number.getNumber(0, 0), 50, "TestNG: testNumberTestNGTests5 - Failed !");
        System.out.println("TestNG: testNumberTestNGTests5: Passed !");
    }
}
