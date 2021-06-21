package FirstPlay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestClassTest {
    private TestClass testClass;
    private static final String TEST_NAME = "Alex";

    @Before
    public void initializeTestObject() {
        this.testClass = new TestClass(TEST_NAME);
    }

    @Test
    public void checkIfGetterIsEqualToConstructorString() {
        Assert.assertEquals("Alex", this.testClass.getName());
    }
}