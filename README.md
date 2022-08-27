# JUnit Log Event Assertion for log4j

The purpose of this library is to provide a simple way of tracking log events during the execution of JUnit tests
and assert the existence or non-existence of specific log events in the tests.

This is usually helpful if functionality gets tested by a unit test that does to return any result that could be directly asserted.
However, if there is some logging in the tested code it might be an option to ensure that specific log messages have been created
or have **not** been created during the execution of that code.

This library supports tracking for **log4j** loggers only!  
It can be used with **JUnit4** and **JUnit5**.    

Set the following dependencies as appropriate for your project:

## Dependencies

### JUnit 4

Maven:

````xml
<dependencies>
  <dependency>
    <groupId>org.pfsw</groupId>
    <artifactId>pf-julea-log4j2</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
	</dependency>
  <dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.18.0</version>
  </dependency>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
  </dependency>
</dependencies>
````

Gradle:

````groovy
dependencies {
  testImplementation group: 'org.pfsw', name: 'pf-julea-log4j2', version: '1.0.0'
  testImplementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.18.0'
  testImplementation group: 'junit', name: 'junit', version: '4.12'
}
````

### JUnit 5

Maven:

````xml
<dependencies>
  <dependency>
    <groupId>org.pfsw</groupId>
    <artifactId>pf-julea-log4j2</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.18.0</version>
  </dependency>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
````

Gradle:

````groovy
dependencies {
  testImplementation group: 'org.pfsw', name: 'pf-julea-log4j2', version: '1.0.0'
  testImplementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.18.0'
  testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '5.9.0'
}
````

## Usage

Have a look at the following example to learn how to use the library in your unit tests.

### JUnit4

````java
import static org.pfsw.julea.core.assertions.Junit4LogAssertions.*;
import org.junit.Rule;
import org.junit.Test;
import org.pfsw.julea.core.LogLevel;
import org.pfsw.julea.log4j2.junit4.Junit4Log4j2Tracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit4Test
{
  private static final Logger LOG = LoggerFactory.getLogger(Junit4Test.class);

  @Rule
  public Junit4Log4j2Tracker logTracker = Junit4Log4j2Tracker.track(Junit4Test.class);

  @Test
  public void test_log_entries()
  {
    LOG.info("The quick brown fox jumps over the lazy dog");
    assertLogEntry(logTracker, "quick", "fox", "dog");
    assertNoLogEntry(logTracker, "cat");
  }
}
````


### JUnit5

````java
import static org.pfsw.julea.core.assertions.Junit5LogAssertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.pfsw.julea.core.LogLevel;
import org.pfsw.julea.log4j2.junit5.Junit5Log4j2Tracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit5Test
{
  private static final Logger LOG = LoggerFactory.getLogger(Junit5Test.class);

  @RegisterExtension
  public Junit5Log4j2Tracker logTracker = Junit5Log4j2Tracker.track(Junit5Test.class);

  @Test
  public void test_log_entries()
  {
    LOG.info("The quick brown fox jumps over the lazy dog");
    assertLogEntry(logTracker, "quick", "fox", "dog");
    assertNoLogEntry(logTracker, "cat");
  }
}
````


