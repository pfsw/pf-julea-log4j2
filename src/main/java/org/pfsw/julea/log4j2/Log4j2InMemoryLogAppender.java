// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 19/08/2022
// HISTORY  :
//  19/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.pfsw.julea.core.InMemoryLogAppender;
import org.pfsw.julea.core.LogLevel;
import org.pfsw.julea.core.LogRecord;

/**
 * This log4j appender collects log messages in memory.
 */
public class Log4j2InMemoryLogAppender extends AbstractAppender implements InMemoryLogAppender
{
  private static final Map<Level, LogLevel> LOG_LEVEL_MAPPING = initLogLevelMapping();

  private final List<LogRecord> logRecords = Collections.synchronizedList(new ArrayList<>());

  public static Log4j2InMemoryLogAppender createAppender(String name, Filter filter)
  {
    return new Log4j2InMemoryLogAppender(name, filter);
  }

  private static Map<Level, LogLevel> initLogLevelMapping()
  {
    Map<Level, LogLevel> mapping = new HashMap<>();

    mapping.put(Level.OFF, LogLevel.OFF);
    mapping.put(Level.TRACE, LogLevel.TRACE);
    mapping.put(Level.DEBUG, LogLevel.DEBUG);
    mapping.put(Level.INFO, LogLevel.INFO);
    mapping.put(Level.WARN, LogLevel.WARN);
    mapping.put(Level.ERROR, LogLevel.ERROR);
    mapping.put(Level.FATAL, LogLevel.FATAL);
    mapping.put(Level.ALL, LogLevel.ALL);

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
    getLogRecords().add(new LogRecord(mapLogLevel(event.getLevel()), event.getMessage().getFormattedMessage()));
  }

  @Override
  public String toString()
  {
    return String.format("%s()", getClass().getSimpleName());
  }

  @Override
  public List<LogRecord> getLogRecords()
  {
    return this.logRecords;
  }

  protected LogLevel mapLogLevel(Level level)
  {
    return LOG_LEVEL_MAPPING.getOrDefault(level, LogLevel.OFF);
  }
}
