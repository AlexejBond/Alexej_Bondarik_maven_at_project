package day14;

import units.Number;

import static org.junit.Assert.assertEquals;


public class NumbersTests {

    public static void main(String[] args) {
        NumbersTests numbersTestsTest = new NumbersTests();
        numbersTestsTest.testCase1();
        numbersTestsTest.testCase2();
        numbersTestsTest.testCase3();
        numbersTestsTest.testCase4();


    }


    public void testCase1() {
        Number number = new Number();
        int actual = number.getNumber(-1, 5);
        if (actual == 98) {
            System.out.println("Test case 1: passed");
        } else {
            System.out.println("Test case 1: failed");
        }
    }



    public void testCase2() {
        Number number = new Number();
        int actual = number.getNumber(-1, 5);
        if (actual == 98) {
            System.out.println("Test case 2: passed");
        } else {
            System.out.println("Test case 2: failed");
        }
    }

    public void testCase3() {
        Number number = new Number();
        int actual = number.getNumber(5, -5);
        if (actual == 47) {
            System.out.println("Test case 3: passed");
        } else {
            System.out.println("Test case 3: failed");
        }
    }

    public void testCase4() {
        Number number = new Number();
        int actual = number.getNumber(-5, 15);
        if (actual == 90) {
            System.out.println("Test case 4: passed");
        } else {
            System.out.println("Test case 4: failed");
        }
    }

}





