// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core.assertions;

import org.junit.jupiter.api.Assertions;
import org.pfsw.julea.core.LogEntriesTracker;
import org.pfsw.julea.core.LogLevel;

/**
 * Static assertion methods for checking the existence or non-existence of log entries.
 * Requires <strong>junit-jupiter-api</strong> library to be on the classpath.
 */
public class Junit5LogAssertions
{
  private static final LogAssertions ASSERTIONS = new LogAssertions(Assertions::assertTrue, Assertions::assertFalse);

  /**
   * Asserts that a log entry containing (all) the given text elements was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param textElements The expected log message text parts.
   */
  public static void assertLogEntry(LogEntriesTracker tracker, String... textElements)
  {
    ASSERTIONS.assertLogEntry(tracker, textElements);
  }

  /**
   * Asserts that no log entry containing (all) the given text elements was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param textElements The log message text parts to be checked.
   */
  public static void assertNoLogEntry(LogEntriesTracker tracker, String... textElements)
  {
    ASSERTIONS.assertNoLogEntry(tracker, textElements);
  }

  /**
   * Asserts that a log entry containing (all) the given text elements was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param enumValue A single enum value that's name is expected to be in a log message. 
   * @param textElements The expected log message text parts.
   */
  public static void assertLogEntry(LogEntriesTracker tracker, Enum<?> enumValue, String... textElements)
  {
    ASSERTIONS.assertLogEntry(tracker, ASSERTIONS.concatenate(enumValue.name(), textElements));
  }
  
  /**
   * Asserts that no log entry containing (all) the given text elements was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param enumValue A single enum value that's name is expected not to be in a log message. 
   * @param textElements The log message text parts to be checked.
   */
  public static void assertNoLogEntry(LogEntriesTracker tracker, Enum<?> enumValue, String... textElements)
  {
    ASSERTIONS.assertNoLogEntry(tracker, ASSERTIONS.concatenate(enumValue.name(), textElements));
  }
  
  /**
   * Asserts that a log entry with the specified log level and all the given text elements in the log message was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param logLevel The log level to be matched.
   * @param textElements The expected log message text parts.
   */
  public static void assertLogEntry(LogEntriesTracker tracker, LogLevel logLevel, String... textElements)
  {
    ASSERTIONS.assertLogEntry(tracker, logLevel, textElements);
  }

  /**
   * Asserts that no log entry with the given log level and all the given text elements in the log message was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param logLevel The log level to be matched.
   * @param textElements The log message text parts to be checked.
   */
  public static void assertNoLogEntry(LogEntriesTracker tracker, LogLevel logLevel, String... textElements)
  {
    ASSERTIONS.assertNoLogEntry(tracker, logLevel, textElements);
  }

  /**
   * Asserts that a log entry with a message matching the given regular expression was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param regex The regular expression the log messages should match.
   */
  public static void assertLogEntryMessage(LogEntriesTracker tracker, String regex)
  {
    ASSERTIONS.assertLogEntryMessage(tracker, regex);
  }

  /**
   * Asserts that no log entry with a message matching the given regular expression was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param regex The regular expression the log messages are matched against.
   */
  public static void assertNoLogEntryMessage(LogEntriesTracker tracker, String regex)
  {
    ASSERTIONS.assertNoLogEntryMessage(tracker, regex);
  }
}
