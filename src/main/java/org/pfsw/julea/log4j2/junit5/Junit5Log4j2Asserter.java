// ===========================================================================
// CONTENT  : CLASS Junit5Log4j2Asserter
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 20/07/2023
// HISTORY  :
//  20/07/2023  mdu  CREATED
//
// Copyright (c) 2023, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.log4j2.junit5;

import org.pfsw.julea.core.assertions.Junit5LogAssertions;
import org.pfsw.julea.core.assertions.JunitLogAsserter;

/**
 * This interface is supposed to be implemented by a JUnit 5 Test class to
 * inherit the default implementation of assertion methods for log entries checking. 
 */
public interface Junit5Log4j2Asserter extends JunitLogAsserter
{
  /**
   * Tracks all loggers with given names.
   * 
   * @param loggerNames the names of loggers to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  default Junit5Log4j2Tracker trackLogger(String... loggerNames)
  {
    return Junit5Log4j2Tracker.track(loggerNames);
  }

  /**
   * Tracks all loggers with the full qualified names of the given classes.
   * 
   * @param classes The class for which loggers with the full qualified class names are to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  default Junit5Log4j2Tracker trackLogger(Class<?>... classes)
  {
    return Junit5Log4j2Tracker.track(classes);
  }

  /**
   * Asserts that a log entry containing (all) the given text elements was captured by the log entry tracker.
   * 
   * @param enumValue A single enum value that's name is expected to be in a log message. 
   * @param textElements The expected log message text parts.
   */
  default void assertLogEntry(Enum<?> enumValue, String... textElements)
  {
    Junit5LogAssertions.assertLogEntry(getLogTracker(), enumValue, textElements);
  }

  /**
   * Asserts that no log entry containing (all) the given text elements was captured by the log entry tracker.
   * 
   * @param enumValue A single enum value that's name is expected not to be in a log message. 
   * @param textElements The log message text parts to be checked.
   */
  default void assertNoLogEntry(Enum<?> enumValue, String... textElements)
  {
    Junit5LogAssertions.assertNoLogEntry(getLogTracker(), enumValue, textElements);
  }

  /**
   * Asserts that a log entry containing (all) the given text elements was captured by the log entry tracker.
   * 
   * @param textElements The expected log message text parts.
   */
  default void assertLogEntry(String... textElements)
  {
    Junit5LogAssertions.assertLogEntry(getLogTracker(), textElements);
  }

  /**
   * Asserts that no log entry containing (all) the given text elements was captured by the log entry tracker.
   * 
   * @param textElements The log message text parts to be checked.
   */
  default void assertNoLogEntry(String... textElements)
  {
    Junit5LogAssertions.assertNoLogEntry(getLogTracker(), textElements);
  }

  /**
   * Asserts that a log entry with a message matching the given regular expression was captured by the log entry tracker.
   * 
   * @param regex The regular expression the log messages should match.
   */
  default void assertLogEntryMessage(String regex)
  {
    Junit5LogAssertions.assertLogEntryMessage(getLogTracker(), regex);
  }

  /**
   * Asserts that no log entry with a message matching the given regular expression was captured by the log entry tracker.
   * 
   * @param regex The regular expression the log messages are matched against.
   */
  default void assertNoLogEntryMessage(String regex)
  {
    Junit5LogAssertions.assertNoLogEntryMessage(getLogTracker(), regex);
  }
}
