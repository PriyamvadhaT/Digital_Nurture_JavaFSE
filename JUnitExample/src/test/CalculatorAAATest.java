package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorAAATest {

    private int num1;
    private int num2;

    @Before
    public void setUp() {

        // Arrange
        num1 = 10;
        num2 = 20;

        System.out.println("Setup completed.");

    }

    @Test
    public void testAddition() {

        // Act
        int result = num1 + num2;

        // Assert
        assertEquals(30, result);

    }

    @After
    public void tearDown() {

        System.out.println("Teardown completed.");

    }

}