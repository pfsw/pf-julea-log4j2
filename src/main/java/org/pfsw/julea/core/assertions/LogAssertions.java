// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core.assertions;

import java.util.function.Consumer;

import org.pfsw.julea.core.LogEntriesTracker;
import org.pfsw.julea.core.LogLevel;

class LogAssertions
{
  private final Consumer<Boolean> assertTrue;
  private final Consumer<Boolean> assertFalse;

  protected LogAssertions(Consumer<Boolean> assertTrue, Consumer<Boolean> assertFalse)
  {
    this.assertTrue = assertTrue;
    this.assertFalse = assertFalse;
  }

  /**
   * Asserts that a log entry containing (all) the given text elements was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param textElements The expected log message text parts.
   */
  protected void assertLogEntry(LogEntriesTracker tracker, String... textElements)
  {
    assertTrue.accept(tracker.hasLogEntryWith(textElements));
  }

  /**
   * Asserts that no log entry containing (all) the given text elements was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param textElements The log message text parts to checked.
   */
  protected void assertNoLogEntry(LogEntriesTracker tracker, String... textElements)
  {
    assertFalse.accept(tracker.hasLogEntryWith(textElements));
  }

  /**
   * Asserts that a log entry with the specified log level and all the given text elements in the log message was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param logLevel The log level to be matched.
   * @param textElements The expected log message text parts.
   */
  protected void assertLogEntry(LogEntriesTracker tracker, LogLevel logLevel, String... textElements)
  {
    assertTrue.accept(tracker.hasLogEntryWith(logLevel, textElements));
  }

  /**
   * Asserts that no log entry with the given log level and all the given text elements in the log message was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param logLevel The log level to be matched.
   * @param textElements The log message text parts to checked.
   */
  protected void assertNoLogEntry(LogEntriesTracker tracker, LogLevel logLevel, String... textElements)
  {
    assertFalse.accept(tracker.hasLogEntryWith(logLevel, textElements));
  }

  /**
   * Asserts that a log entry with a message matching the given regular expression was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param regex The regular expression the log messages should match.
   */
  protected void assertLogEntryMessage(LogEntriesTracker tracker, String regex)
  {
    assertTrue.accept(tracker.hasLogEntryMatching(regex));
  }

  /**
   * Asserts that no log entry with a message matching the given regular expression was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param regex The regular expression the log messages are matched against.
   */
  protected void assertNoLogEntryMessage(LogEntriesTracker tracker, String regex)
  {
    assertFalse.accept(tracker.hasLogEntryMatching(regex));
  }
}
