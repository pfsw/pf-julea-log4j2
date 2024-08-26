package org.pfsw.julea.log4j2.junit4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Junit4Log4j2TrackerTest
{
  @Test
  public void test_toString()
  {
    assertEquals("Junit4Log4j2Tracker()", Junit4Log4j2Tracker.track(Junit4Log4j2TrackerTest.class).toString());
  }
}
