// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core;

import java.util.regex.Pattern;

public interface InMemoryLogEntriesTracker extends LogEntriesTracker
{
  InMemoryLogAppender getAppender();

  /**
   * Returns true if the associated appender contains a log entry with a message that matches the given regular expression.
   * 
   * @param regex A regular expression to match the log messages.
   * @return true if at least one log entry with a matching message has been captured.
   */
  @Override
  default boolean hasLogEntryMatching(String regex)
  {
    return getAppender().hasLogEntryMatching(Pattern.compile(regex));
  }

  /**
   * Returns true if the associated appender contains a log message that contains all the given text snippets.
   * 
   * @param textSnippets An arbitrary number of text elements that are supposed to be included in a single log message.
   * @return true if all given test snippets are found in a single log message.
   */
  @Override
  default boolean hasLogEntryWith(String... textSnippets)
  {
    return getAppender().hasLogEntryWith(textSnippets);
  }

  /**
   * Returns true if this appender contains an entry with the given log level and a log message that contains all the given text snippets.
   * 
   * @param logLevel The expected log level. If this value is null the log level of log entries will be ignored.
   * @param textSnippets An arbitrary number of text elements that are supposed to be included in a single log message.
   * @return true if all given test snippets are found in a single log message.
   */
  @Override
  default boolean hasLogEntryWith(LogLevel logLevel, String... textSnippets)
  {
    return getAppender().hasLogEntryWith(logLevel, textSnippets);
  }

  @Override
  default void clear()
  {
    getAppender().clear();
  }
}
