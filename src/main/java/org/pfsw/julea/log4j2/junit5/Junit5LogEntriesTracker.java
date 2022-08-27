// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.log4j2.junit5;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.pfsw.julea.core.LogEntriesTracker;

public interface Junit5LogEntriesTracker extends LogEntriesTracker, AfterEachCallback, BeforeEachCallback
{
  // nothing additional
}
