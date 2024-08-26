package org.pfsw.julea.log4j2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Log4j2InMemoryLogAppenderTest
{
  @Test
  public void test_toString()
  {
    assertEquals("Log4j2InMemoryLogAppender()", Log4j2InMemoryLogAppender.createAppender("test", null).toString());
  }
}
