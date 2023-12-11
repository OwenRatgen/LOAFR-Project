package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AnalyzeTest.class,
        // BatchDirectoryTest.class,
        OptionsLoopTest.class,
        OutputTest.class,
        ReadCsvTest.class,
        // RunLoafrTest.class, //This needs to be updated once RunLoafrTest is finaized
         // Add more test classes if needed
})

public class TestSuite {
    // No code here just run TestFile and it will run all the unit tests in the test package
}

