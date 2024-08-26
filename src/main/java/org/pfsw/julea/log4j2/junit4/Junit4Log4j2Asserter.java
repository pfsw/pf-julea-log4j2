// ===========================================================================
// CONTENT  : CLASS Junit5Log4j2Asserter
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 20/07/2023
// HISTORY  :
//  20/07/2023  mdu  CREATED
//
// Copyright (c) 2023, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.log4j2.junit4;

import org.pfsw.julea.core.junit4.Junit4LogAsserter;

/**
 * This interface is supposed to be implemented by a JUnit 4 Test class to
 * inherit the default implementation of assertion methods for log entries checking. 
 */
public interface Junit4Log4j2Asserter extends Junit4LogAsserter<Junit4Log4j2Tracker>
{
  /**
   * Tracks all loggers with given names.
   * 
   * @param loggerNames the names of loggers to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  @Override
  default Junit4Log4j2Tracker trackLogger(String... loggerNames)
  {
    return Junit4Log4j2Tracker.track(loggerNames);
  }
}
