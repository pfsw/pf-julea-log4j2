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
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.pfsw.julea.core.InMemoryLogAppender;
import org.pfsw.julea.core.InMemoryLogEntriesTracker;

/**
 * This log entry tracker is supposed to be used as unit test rule.
 * It will collect log messages in memory and supports checking for existence or no-existence of specific log entries.
 * <p>
 * <code>
 * \@Rule public LogEntriesTracker logTracker = Log4j2Tracker.track(Service1.class, Handler3.class);
 * </code>
 */
public abstract class BaseLog4j2Tracker implements InMemoryLogEntriesTracker
{
  private final List<Logger> loggers = new ArrayList<>();
  private Log4j2InMemoryLogAppender log4jAppender;

  protected BaseLog4j2Tracker(Class<?>... classes)
  {
    for (Class<?> clazz : classes)
    {
      getLoggers().add((Logger)LogManager.getLogger(clazz));
    }
  }

  protected BaseLog4j2Tracker(String... loggerNames)
  {
    for (String name : loggerNames)
    {
      getLoggers().add((Logger)LogManager.getLogger(name));
    }
  }

  @Override
  public InMemoryLogAppender getAppender()
  {
    return getLog4jAppender();
  }

  @Override
  public String toString()
  {
    return String.format("%s()", getClass().getSimpleName());
  }

  protected void initialization()
  {
    Filter filter = new AbstractFilter()
    {
      @Override
      public Result filter(final LogEvent event)
      {
        return Result.ACCEPT;
      }
    };
    setLog4jAppender(Log4j2InMemoryLogAppender.createAppender("in-memory", filter));
    getLog4jAppender().start();
    for (Logger logger : getLoggers())
    {
      makeInheritParentAppendersIfReasonable(logger);
      logger.addAppender(getLog4jAppender());
    }
  }

  protected void makeInheritParentAppendersIfReasonable(Logger logger)
  {
    Map<String, Appender> existingAppenders;
    LoggerConfig loggerConfig;
    boolean inheritsConfigFromParent;

    loggerConfig = logger.get();
    inheritsConfigFromParent = !logger.getName().equals(loggerConfig.getName());
    existingAppenders = logger.getAppenders();
    if (inheritsConfigFromParent || (existingAppenders == null) || existingAppenders.isEmpty())
    {
      // The logger has no appenders assigned directly to it, it will be using its parent appenders.
      // Since we are adding our own appender to that logger directly, we have to ensure that
      // the inherited parent logger appenders are still used, too.
      logger.setAdditive(true);
    }
  }

  protected void cleanup()
  {
    clear();
    for (Logger logger : getLoggers())
    {
      logger.removeAppender(getLog4jAppender());
    }
    getLoggers().clear();
  }

  protected List<Logger> getLoggers()
  {
    return loggers;
  }

  protected Log4j2InMemoryLogAppender getLog4jAppender()
  {
    return log4jAppender;
  }

  protected void setLog4jAppender(Log4j2InMemoryLogAppender appender)
  {
    this.log4jAppender = appender;
  }
}
