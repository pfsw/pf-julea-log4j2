// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core;

public class LogRecord
{
  private final LogLevel level;
  private final String message;

  public LogRecord(LogLevel level, String message)
  {
    this.level = level;
    this.message = message;
  }

  public LogLevel getLevel()
  {
    return level;
  }

  public String getMessage()
  {
    return message;
  }

  @Override
  public String toString()
  {
    return String.format("%s(%s, '%s')", getClass().getSimpleName(), getLevel().name(), getMessage());
  }
}
