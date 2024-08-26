package org.pfsw.julea.log4j2.junit5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Junit5Log4j2TrackerTest
{
  @Test
  public void test_toString()
  {
    assertEquals("Junit5Log4j2Tracker()", Junit5Log4j2Tracker.track(Junit5Log4j2TrackerTest.class).toString());
  }
}
