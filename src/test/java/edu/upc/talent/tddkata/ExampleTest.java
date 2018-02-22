package edu.upc.talent.tddkata;


import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {


    @Test
    void testSumaCeros(){
      int a= 0;
      int b = 0;
      int res = suma(a, b);
      assertEquals(0, res);
    }

    @Test
    void testSumaPositivos(){
        int res = suma(2,3);
        assertEquals(5, res);
    }

    @Test
    void testSumOverflow(){
        RuntimeException e =
                assertThrows(RuntimeException.class,
                        () -> suma(Integer.MAX_VALUE, 3));
        assertEquals("Sum overflow", e.getMessage());
    }

    @Test
    void testSumUnderflow(){
        RuntimeException e =
                assertThrows(RuntimeException.class,
                        () -> suma(Integer.MIN_VALUE, -3));
        assertEquals("Sum underflow", e.getMessage());
    }


    @Test
    void testSumBigNumbers(){
        assertEquals(-1, suma(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private int suma(int a, int b) {
        int res = a + b;
        if(a > 0 && b > 0 && res < 0)
            throw new RuntimeException("Sum overflow");
        if(a < 0 && b < 0 && res > 0)
            throw new RuntimeException("Sum underflow");

        return res;
    }


    private String greet(String greeting, String to){
        return greeting + " " + to + "!";
    }

    @Test
    void sampleStringTest(){
        String s1 = "Hello";
        String s2 = "World";
        String res = greet(s1,s2);
        assertTrue(res.endsWith("!"));
        assertEquals("Hello World!", res);
    }

    @Test
    void sampleIterableTest(){
        String sentence = "Nunquam est fidelis cum potente societas";
        List<String> res = asList(sentence.toLowerCase().split(" "));
        assertEquals(6, res.size());
        assertTrue(res.contains("nunquam"));
    }

    @Test
    void sampleExceptionsTest(){
        String s = "";
        StringIndexOutOfBoundsException e = assertThrows(StringIndexOutOfBoundsException.class, () -> s.substring(2));
        assertTrue(e.getMessage().contains("String index out of range: -2"));
    }
}
