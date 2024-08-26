// ===========================================================================
// CONTENT  : CLASS Junit5Log4j2Asserter
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 20/07/2023
// HISTORY  :
//  20/07/2023  mdu  CREATED
//
// Copyright (c) 2023, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.log4j2.junit5;

import org.pfsw.julea.core.junit5.Junit5LogAsserter;

/**
 * This interface is supposed to be implemented by a JUnit 5 Test class to
 * inherit the default implementation of assertion methods for log entries checking. 
 */
public interface Junit5Log4j2Asserter extends Junit5LogAsserter<Junit5Log4j2Tracker>
{
  /**
   * Tracks all loggers with given names.
   * 
   * @param loggerNames the names of loggers to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  @Override
  default Junit5Log4j2Tracker trackLogger(String... loggerNames)
  {
    return Junit5Log4j2Tracker.track(loggerNames);
  }
}
