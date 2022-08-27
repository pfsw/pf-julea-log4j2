// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 27/08/2022
// HISTORY  :
//  27/08/2022  mdu  created
//
// Copyright (c) 2022, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core;

public enum LogLevel
{
  //@formatter:off
  ALL,
  DEBUG, 
  ERROR,
  FATAL,
  INFO,
  OFF,
  TRACE, 
  WARN;
  //@formatter:on

  @Override
  public String toString()
  {
    return String.format("%s(%s)", getClass().getSimpleName(), name());
  }
}
