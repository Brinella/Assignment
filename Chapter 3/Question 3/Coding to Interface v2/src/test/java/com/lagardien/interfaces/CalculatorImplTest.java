package com.lagardien.interfaces;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12/03/2016
 */
public class CalculatorImplTest extends TestCase
{
    private  Calculator calc;

    @Override
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        calc = (Calculator)ctx.getBean("calc");
    }

    public void testAddition() throws Exception {
        float result = calc.add(27, 93);
        assertEquals(result,120.0f);
    }

    public void testSubtraction() throws Exception {
        float result = calc.subtract(93, 27);
        assertEquals(result,66.0f);
    }

    public void testMultiplication() throws Exception {
        float result = calc.multiply(27, 93);
        assertEquals(result,2511.0f);
    }


    public void testDivision() throws Exception {
        float result = calc.divide(4, 2);
        assertEquals(result,2.0f);
    }
}
