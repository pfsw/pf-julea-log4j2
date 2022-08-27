package org.pfsw.julea.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LogLevelTest
{
  @Test
  public void test_toString()
  {
    assertEquals("LogLevel(FATAL)", LogLevel.FATAL.toString());
  }
}
