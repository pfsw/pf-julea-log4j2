// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.log4j2.junit5;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.pfsw.julea.core.junit5.Junit5LogEntriesTracker;
import org.pfsw.julea.log4j2.BaseLog4j2Tracker;

public class Junit5Log4j2Tracker extends BaseLog4j2Tracker implements Junit5LogEntriesTracker
{
  /**
   * Tracks all loggers with the full qualified names of the given classes.
   * 
   * @param classes The class for which loggers with the full qualified class names are to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  public static Junit5Log4j2Tracker track(Class<?>... classes)
  {
    return new Junit5Log4j2Tracker(classes);
  }

  /**
   * Tracks all loggers with given names.
   * 
   * @param loggerNames the names of loggers to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  public static Junit5Log4j2Tracker track(String... loggerNames)
  {
    return new Junit5Log4j2Tracker(loggerNames);
  }

  protected Junit5Log4j2Tracker(Class<?>[] classes)
  {
    super(classes);
  }

  protected Junit5Log4j2Tracker(String[] loggerNames)
  {
    super(loggerNames);
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception
  {
    initialization();
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception
  {
    cleanup();
  }
}
