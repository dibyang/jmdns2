/**
 *
 */
package javax.jmdns.test;

import org.junit.Before;
import org.junit.Test;

import javax.jmdns.impl.DNSCache;
import javax.jmdns.impl.DNSEntry;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.constants.DNSRecordClass;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class DNSCacheTest {

  @Before
  public void setup() {
    //
  }

  @Test
  public void testCacheCreation() {
    DNSCache cache = new DNSCache();
    assertNotNull("Could not create a new DNS cache.", cache);
  }

  @Test
  public void testCacheAddEntry() {
    DNSCache cache = new DNSCache();

    DNSEntry entry = new DNSRecord.Service("pierre._home-sharing._tcp.local.", DNSRecordClass.CLASS_IN, false, 0, 0, 0, 0, "panoramix.local.");
    cache.addDNSEntry(entry);
    assertEquals("Could not retrieve the value we inserted", entry, cache.getDNSEntry(entry));

  }

  @Test
  public void testCacheRemoveEntry() {
    DNSCache cache = new DNSCache();

    DNSEntry entry = new DNSRecord.Service("pierre._home-sharing._tcp.local.", DNSRecordClass.CLASS_IN, false, 0, 0, 0, 0, "panoramix.local.");
    cache.addDNSEntry(entry);
    assertEquals("Could not retrieve the value we inserted", entry, cache.getDNSEntry(entry));
    cache.removeDNSEntry(entry);
    assertNull("Could not remove the value we inserted", cache.getDNSEntry(entry));

    List<DNSEntry> values = cache.get(entry.getKey());
    assertTrue("Cache still has entries for the key", values == null || values.isEmpty());
    assertNull("Cache contains key with no entries", values);
  }

}
