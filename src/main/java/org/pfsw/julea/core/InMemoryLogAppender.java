// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public interface InMemoryLogAppender
{
  /**
   * Returns true if this appender contains a log message that matches the given regex pattern.
   * 
   * @param regexPattern The regular expression pattern the log message must match. 
   * @return true if at least one log entry with a matching message was found.
   */
  default boolean hasLogEntryMatching(Pattern regexPattern)
  {
    Predicate<LogRecord> matcher = (logRecord) -> regexPattern.matcher(logRecord.getMessage()).matches();
    return hasLogEntry(matcher);
  }

  /**
   * Returns true if this appender contains a log message that contains all the given text snippets.
   * 
   * @param textSnippets An arbitrary number of text elements that are supposed to be included in a single log message.
   * @return true if all given test snippets are found in a single log message.
   */
  default boolean hasLogEntryWith(String... textSnippets)
  {
    return hasLogEntryWith(LogLevel.ALL, textSnippets);
  }

  /**
   * Returns true if this appender contains an entry with the given log level and a log message that contains all the given text snippets.
   * 
   * @param logLevel The expected log level. If this value is null the log level of log entries will be ignored.
   * @param textSnippets An arbitrary number of text elements that are supposed to be included in a single log message.
   * @return true if all given test snippets are found in a single log message.
   */
  default boolean hasLogEntryWith(LogLevel logLevel, String... textSnippets)
  {
    Predicate<LogRecord> matcher = (logRecord) -> isMatchingLogLevel(logRecord, logLevel) && containsAll(logRecord.getMessage(), textSnippets);
    return hasLogEntry(matcher);
  }

  /**
   * Returns true if this appender contains a log entry that matches the given matcher.
   * 
   * @param matcher The matcher to check the log records.
   * @return true if at least one captured log record matches the given matcher.
   */
  default boolean hasLogEntry(Predicate<LogRecord> matcher)
  {
    return getLogRecords().stream().anyMatch(matcher);
  }

  default boolean containsAll(String message, String... textSnippets)
  {
    for (String text : textSnippets)
    {
      if (!message.contains(text))
      {
        return false;
      }
    }
    return true;
  }

  default boolean isMatchingLogLevel(LogRecord logRecord, LogLevel logLevel)
  {
    return (logLevel == null) || (logLevel == LogLevel.ALL) || (logLevel == logRecord.getLevel());
  }

  default void clear()
  {
    getLogRecords().clear();
  }

  List<LogRecord> getLogRecords();
}
