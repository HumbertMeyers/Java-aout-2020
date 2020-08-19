/**
 * 
 */
package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.IP;

/**
 * @author Humbert Meyers
 *
 */
class IPTest {
	
	IP test1 = new IP(24);
	IP test2 = new IP();
	IP test3 = new IP("192.168.1.5");
	IP test4 = new IP("192.168.1.1", 24);
	IP test5 = new IP("192.168.1.2", 28);
	IP test6 = new IP("192.168.1.1", 24);
	IP test7 = new IP("192.168.1.1");
	IP test8 = new IP();
	

	/**
	 * Test method for {@link model.IP#getIpAdr()}.
	 */
	@Test
	void testGetIpAdr() {
		assertNotEquals(test1, test3);
		test1.getIpAdr().equals(test4.getIpAdr());
		test1.getIpAdr().equals(test5.getIpAdr());
	}

	/**
	 * Test method for {@link model.IP#getMasque()}.
	 */
	@Test
	void testGetMasque() {
		assertNotEquals(test1.getMasque(), "255.255.252.0");
		assertEquals(test2.getMasque(), "255.255.0.0");
	}

	/**
	 * Test method for {@link model.IP#getMasqueInt(java.lang.String)}.
	 */
	@Test
	void testGetMasqueInt() {
		assertEquals(test2.getMasqueInt("255.255.0.0"), 16);
		assertEquals(test7.getMasqueInt("255.255.255.252"), 30);
		assertEquals(test4.getMasqueInt(test4.getMasque()), 24);
	}

}
