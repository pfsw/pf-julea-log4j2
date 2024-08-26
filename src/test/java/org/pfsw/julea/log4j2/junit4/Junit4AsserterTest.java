package org.pfsw.julea.log4j2.junit4;

import static org.pfsw.julea.log4j2.testhelper.UnitTestHelper.MESSAGE_1;
import static org.pfsw.julea.log4j2.testhelper.UnitTestHelper.MESSAGE_2;
import static org.pfsw.julea.log4j2.testhelper.UnitTestHelper.MESSAGE_3;

import org.junit.Rule;
import org.junit.Test;
import org.pfsw.julea.core.LogEntriesTracker;
import org.pfsw.julea.log4j2.testhelper.LogId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit4AsserterTest implements Junit4Log4j2Asserter
{
  private static final Logger LOG = LoggerFactory.getLogger(Junit4AsserterTest.class);

  @Rule
  public Junit4Log4j2Tracker logTracker = trackLogger(Junit4AsserterTest.class);

  @Override
  public LogEntriesTracker getLogTracker()
  {
    return logTracker;
  }

  @Test
  public void test_existing_log_entry_by_text_snippets()
  {
    LOG.info(MESSAGE_1);
    LOG.warn(MESSAGE_2);
    assertLogEntry("quick", "fox", "dog");
    assertLogEntry("get");
  }

  @Test
  public void test_existing_log_entry_by_enum_value_and_text_snippets()
  {
    LOG.info(MESSAGE_1);
    LOG.info(MESSAGE_2);
    LOG.error(MESSAGE_3);
    assertLogEntry(LogId.ID001, "quick", "lazy");
    assertLogEntry(LogId.ID003, "went");
  }

  @Test
  public void test_existing_log_entry_by_regex_pattern()
  {
    LOG.error(MESSAGE_1);
    LOG.debug(MESSAGE_2);
    assertLogEntryMessage(".*The .*jumps.*");
    assertLogEntryMessage(".*what you.*");
  }

  @Test
  public void test_not_existing_log_entry_by_text_snippets()
  {
    LOG.warn(MESSAGE_1);
    LOG.info(MESSAGE_2);
    assertNoLogEntry("brown", "green");
    assertNoLogEntry("wrong");
  }

  @Test
  public void test_not_existing_log_entry_by_enum_value()
  {
    LOG.warn(MESSAGE_1);
    LOG.info(MESSAGE_2);
    assertNoLogEntry(LogId.ID001, "yellow");
    assertNoLogEntry(LogId.ID003);
  }

  @Test
  public void test_not_existing_log_entry_by_regex_pattern()
  {
    LOG.error(MESSAGE_1);
    LOG.warn(MESSAGE_2);
    assertNoLogEntryMessage(".*The .*over.*cat$");
  }
}
