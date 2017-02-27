package edu.upc.talent.tddkata;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

// See https://github.com/junit-team/junit4/wiki/Matchers-and-assertthat for more on matchers
// See http://junit.org/junit4/javadoc/latest/org/hamcrest/CoreMatchers.html for the api of matchers
// See https://github.com/junit-team/junit4/wiki/Exception-testing for more on testing exceptions
public class ExampleTest {

    private String greet(String greeting, String to){
        return greeting + " " + to + "!";
    }

    @Test
    public void sampleStringTest(){
        String s1 = "Hello";
        String s2 = "World";
        String res = greet(s1,s2);
        // Some matcher examples:
        assertThat(res,endsWith("!"));
        assertThat(res, allOf(containsString(" "), endsWith("!")));
        assertThat(res, is("Hello World!"));
    }

    private Matcher<String> isLowercase = new CustomTypeSafeMatcher<String>("is lowercase") {
        @Override
        protected boolean matchesSafely(String item) {
            return item.equals(item.toLowerCase());
        }
    };

    @Test
    public void sampleIterableTest(){
        String sentence = "Nunquam est fidelis cum potente societas";
        List<String> res = asList(sentence.toLowerCase().split(" "));
        // Some matcher examples:
        assertThat(res.size(), is(6));
        assertThat(res, hasItem("nunquam"));
        assertThat(res, everyItem(isLowercase));
        assertThat(res, hasItem(endsWith("quam")));
    }

    @Test
    public void sampleExceptionsTest(){
        String s = "";
        try{
            s.substring(2);
            fail("Should have thrown an exception");
        }catch(StringIndexOutOfBoundsException e){
            assertThat(e.getMessage(),containsString("String index out of range: -2"));
        }
    }
}
