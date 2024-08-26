// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 19/08/2022
// HISTORY  :
//  19/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.pfsw.julea.core.InMemoryLogAppender;
import org.pfsw.julea.core.InMemoryLogRecordsCollector;
import org.pfsw.julea.core.LogLevel;
import org.pfsw.julea.core.LogRecord;

/**
 * This log4j appender collects log messages in memory.
 */
public class Log4j2InMemoryLogAppender extends AbstractAppender implements InMemoryLogAppender
{
  private static final Map<Level, LogLevel> LOG_LEVEL_MAPPING = initLogLevelMapping();

  private final InMemoryLogRecordsCollector logRecordsCollector = InMemoryLogRecordsCollector.create();

  public static Log4j2InMemoryLogAppender createAppender(String name, Filter filter)
  {
    return new Log4j2InMemoryLogAppender(name, filter);
  }

  private static Map<Level, LogLevel> initLogLevelMapping()
  {
    Map<Level, LogLevel> mapping = new HashMap<>();

    mapping.put(Level.ALL, LogLevel.ALL);
    mapping.put(Level.TRACE, LogLevel.TRACE);
    mapping.put(Level.DEBUG, LogLevel.DEBUG);
    mapping.put(Level.INFO, LogLevel.INFO);
    mapping.put(Level.WARN, LogLevel.WARN);
    mapping.put(Level.ERROR, LogLevel.ERROR);
    mapping.put(Level.FATAL, LogLevel.FATAL);
    mapping.put(Level.OFF, LogLevel.OFF);

    return mapping;
  }

  @SuppressWarnings("deprecation")
  protected Log4j2InMemoryLogAppender(String name, Filter filter)
  {
    super(name, filter, null);
  }

  @Override
  public void append(LogEvent event)
  {
    getLogRecordsCollector().append(LogRecord.create(mapLogLevel(event.getLevel()), event.getMessage().getFormattedMessage()));
  }

  @Override
  public void clear()
  {
    getLogRecordsCollector().clear();
  }

  @Override
  public String toString()
  {
    return String.format("%s()", getClass().getSimpleName());
  }

  @Override
  public List<LogRecord> getLogRecords()
  {
    return getLogRecordsCollector().getLogRecords();
  }

  protected LogLevel mapLogLevel(Level level)
  {
    return LOG_LEVEL_MAPPING.getOrDefault(level, LogLevel.OFF);
  }

  protected InMemoryLogRecordsCollector getLogRecordsCollector()
  {
    return this.logRecordsCollector;
  }
}
