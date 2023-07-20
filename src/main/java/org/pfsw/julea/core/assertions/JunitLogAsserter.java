// ===========================================================================
// CONTENT  : CLASS JunitLogAsserter
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 20/07/2023
// HISTORY  :
//  20/07/2023  mdu  CREATED
//
// Copyright (c) 2023, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core.assertions;

import org.pfsw.julea.core.LogEntriesTracker;

/**
 * This interface is the common base of the different JUnit version specific log asserter interfaces.
 */
public interface JunitLogAsserter
{
  /**
   * Returns the tracker for all log entries being captured during test execution.
   * 
   * @return The log tracker created for the unit test.
   */
  LogEntriesTracker getLogTracker();
}
