package de.consulting.it.harder;

import org.junit.*;
import org.junit.rules.TestRule;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SystemPropertiesRecoveryTest {

    @Rule
    public TestRule restoreSystemProperties = new SystemPropertiesRecovery();

    @BeforeClass
    public static void setup(){
        System.setProperty("testProp", "test0");
        assertThat(System.getProperty("testProp"), is(equalTo("test0")));
    }

    @Test
    public void determineSearchTerms(){
        //given/when
        System.setProperty("testProp", "test1");

        //then
        assertThat(System.getProperty("testProp"), is(equalTo("test1")));
    }

    @AfterClass
    public static void verifyRules(){
        assertThat(System.getProperty("testProp"), is(equalTo("test0")));
    }

}