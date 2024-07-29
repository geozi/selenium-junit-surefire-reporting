package my.project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ActionSimulatorTest.class, HovererTest.class, ClickerTest.class, TyperTest.class})
public class OrderedTestSuite {
}
