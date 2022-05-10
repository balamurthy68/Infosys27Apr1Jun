package junitExamples;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestCalculator.class,
   TestRegularExpressions.class
   
})

public class TestSuite {   
}  	