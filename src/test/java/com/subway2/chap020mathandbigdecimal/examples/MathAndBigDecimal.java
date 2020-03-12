package com.subway2.chap020mathandbigdecimal.examples;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.jupiter.api.Assertions.*;

public class MathAndBigDecimal {
    @Test
    public void verifyBigDecimal() {
        BigDecimal bdtotal = new BigDecimal("0.1").add(new BigDecimal("0.73"));
//        assertEquals(bdtotal, is(new BigDecimal("0.83")));
        assertEquals(bdtotal, new BigDecimal("0.83"));
    }

    //............................
    //EXERCISE: Convince Yourself of BigDecimal or int
    @Test
    public void bigDecimalOrInt() {
        BigDecimal uah = new BigDecimal("5");
        BigDecimal purchase1 = new BigDecimal("0.43");
        BigDecimal purchase2 = new BigDecimal("0.73");
        BigDecimal purchase3 = new BigDecimal("1.73");
//        uah = uah.subtract(purchase1);
//        assertEquals(uah, new BigDecimal("4.57"));
//        uah = uah.subtract(purchase2);
//        assertEquals(uah, new BigDecimal("3.84"));
//        uah = uah.subtract(purchase3);
//        assertEquals(uah, new BigDecimal("2.11"));
        uah = uah.subtract(purchase1).subtract(purchase2).subtract(purchase3);
        System.out.println(uah);
        assertEquals(uah, new BigDecimal("2.11"));

        int uahInt = 500;
        int purchaseInt1 = 43;
        int purchaseInt2 = 73;
        int purchaseInt3 = 173;
        uahInt = uahInt - purchaseInt1 - purchaseInt2 - purchaseInt3;
        assertEquals(uahInt, 211);

        try {
            double dob;
            dob = 5.00 - purchase1.doubleValue() - purchase2.doubleValue() - purchase3.doubleValue();
            System.out.println("2.11 != " + dob);
            assertEquals(dob, 2.11);
            fail("Expected the assert to fail");
        } catch (AssertionError e) {
        }
    }

    //......................................................
    @Test
    public void verifyConstructToBDecimal() {
        BigDecimal fromInt = new BigDecimal(5);
        BigDecimal fromLong = new BigDecimal(5L);
        BigDecimal fromString = new BigDecimal("5");
        BigDecimal fromDouble = new BigDecimal(5.0);
        BigDecimal fromBigInteger = new BigDecimal(BigInteger.valueOf(5L));

        System.out.println(fromInt);
        System.out.println(fromLong);
        System.out.println(fromString);
        System.out.println(fromDouble);
        System.out.println(fromBigInteger);

        BigDecimal bd0 = BigDecimal.ZERO;
        BigDecimal bd1 = BigDecimal.ONE;
        BigDecimal bd10 = BigDecimal.TEN;
        BigDecimal bdVal = BigDecimal.valueOf(5.0);
        System.out.println(bd0);
        System.out.println(bd1);
        System.out.println(bd10);
        System.out.println(bdVal);
    }
    //.........................................
    //Exercise: Basic Arithmetic with BigDecimal
    @Test
    public void basicArithmetic(){
        BigDecimal aBig = (((new BigDecimal(5L)
                .add(new BigDecimal(5L)))
                .multiply(new BigDecimal(2L)))
                .subtract(new BigDecimal(10L)))
                .divide(new BigDecimal(2L));
        System.out.println(aBig);
        assertEquals(aBig, BigDecimal.valueOf(5L));
        assertEquals(aBig, new BigDecimal(5L));

        assertEquals(aBig.equals(new BigDecimal(5L)), true);
        assertEquals(aBig.compareTo(new BigDecimal(5L)), 0);
        assertEquals(aBig.compareTo(new BigDecimal(6L)), -1);
        assertEquals(aBig.compareTo(new BigDecimal(4L)), 1);

        assertEquals(aBig.compareTo(new BigDecimal(4L)) > 0, true);
    }
    //...........................................
    //Exercise: Compare TEN and ONE
    @Test
    public void compareTenOne(){
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal one = BigDecimal.ONE;

        assertEquals(ten.compareTo(one) > 0, true);
        assertEquals(one.compareTo(ten) < 0, true);
        assertEquals(one.equals(ten), false);
        assertEquals(!one.equals(ten), true);
        assertEquals(one.compareTo(ten) <= 0, true);
        assertEquals(ten.compareTo(one) >= 0, true);

        assertTrue(one.compareTo(ten) < 0);
    }
    //......................................................
    @Test
    public void mathTest(){
        int a = 10;
        int b = 110;
        assertEquals(Math.max(a, b), b);
        assertEquals(Math.min(a, b), a);
        assertEquals(Math.abs(a), 10);
        System.out.println(Math.random());
        double x = Math.random();
        System.out.println(x + "\n" + Math.asin(x));
    }
}
