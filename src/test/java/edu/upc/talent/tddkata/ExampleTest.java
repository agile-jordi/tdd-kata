package edu.upc.talent.tddkata;


import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

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
