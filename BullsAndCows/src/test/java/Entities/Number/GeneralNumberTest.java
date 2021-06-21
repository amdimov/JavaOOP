package Entities.Number;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class GeneralNumberTest {
    private GeneralNumber generalNumber;
    private String generatedNumber;
    private String playersNumber;

    @Before
    public void setUp() {
        generalNumber = new GeneralNumber("hard");
        this.generatedNumber = generalNumber.generateNumber();
        playersNumber = "5231";
    }

    @Test
    public void testIfRandomNumberIsSettledToField() {
        Assert.assertEquals(generalNumber.getNumber(), generatedNumber);
    }

    @Test(expected = IllegalStateException.class)
    public void testIfItThrowsExceptionIfGenerateNewNumber() {
        generalNumber.generateNumber();
    }

    @Test
    public void testIfThrowCowsWillThrowTheRightNumber() {
        Assert.assertEquals(4, generalNumber.throwCows(playersNumber));
    }
    @Test
    public void testIfThrowBullsWillThrowTheRightNumber() {
        Assert.assertEquals(4, generalNumber.throwBulls(playersNumber));
    }
}