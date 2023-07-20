package org.pfsw.julea.log4j2.testhelper;

public class UnitTestHelper
{
  public static final String STATS_LOGGER_NAME = "test.Statistics";
  public static final String MESSAGE_1 =  String.format("[%s] The quick brown fox jumps over the lazy dog", LogId.ID001);
  public static final String MESSAGE_2 = String.format("[%s} You can't always get what you want", LogId.ID002);
  public static final String MESSAGE_3 = String.format("[%s] Something went wrong", LogId.ID003);
}
