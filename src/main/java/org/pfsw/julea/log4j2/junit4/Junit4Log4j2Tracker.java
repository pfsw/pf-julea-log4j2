// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.log4j2.junit4;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.pfsw.julea.log4j2.BaseLog4j2Tracker;

public class Junit4Log4j2Tracker extends BaseLog4j2Tracker implements Junit4LogEntriesTracker
{
  /**
   * Tracks all loggers with the full qualified names of the given classes.
   * 
   * @param classes The class for which loggers with the full qualified class names are to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  public static Junit4Log4j2Tracker track(Class<?>... classes)
  {
    return new Junit4Log4j2Tracker(classes);
  }

  /**
   * Tracks all loggers with given names.
   * 
   * @param loggerNames the names of loggers to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  public static Junit4Log4j2Tracker track(String... loggerNames)
  {
    return new Junit4Log4j2Tracker(loggerNames);
  }

  protected Junit4Log4j2Tracker(Class<?>[] classes)
  {
    super(classes);
  }

  protected Junit4Log4j2Tracker(String[] loggerNames)
  {
    super(loggerNames);
  }

  @Override
  public Statement apply(Statement base, Description description)
  {
    return createStatement(base);
  }

  protected Statement createStatement(final Statement base)
  {
    return new Statement()
    {
      @Override
      public void evaluate() throws Throwable
      {
        initialization();
        try
        {
          base.evaluate();
        }
        finally
        {
          cleanup();
        }
      }
    };
  }
  
  @Override
  protected void initialization()
  {
    super.initialization();
  }
  
  @Override
  protected void cleanup()
  {
    super.cleanup();
  }
}
