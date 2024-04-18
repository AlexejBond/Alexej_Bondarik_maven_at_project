package tests.junit;

import org.junit.Test;
import people.Person;

import static org.junit.Assert.assertEquals;

public class PersonJUnitTest {
    @Test
    public void testPersonAge() {
        Person person = new Person(26);
        assertEquals("The age is not correct!", 26, person.getAge());
    }
}
