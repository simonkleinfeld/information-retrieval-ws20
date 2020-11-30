/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.net.InetAddresses;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class IpAddressRegexTest
{

    @Test
    void isIp4Adress_IpAdress_True()
    {
        Random random = new Random();
        String ipString = InetAddresses.fromInteger(random.nextInt()).getHostAddress();

        System.out.println(ipString);

        assertTrue(IpAddressRegex.isIp4Adress(ipString));

    }

    @Test
    void isIp4Adress_IpAdressLocalhost_True()
    {
        assertTrue(IpAddressRegex.isIp4Adress("127.0.0.0"));

    }


    @Test
    void isIp4Adress_NoIpAdress_False()
    {
        assertFalse(IpAddressRegex.isIp4Adress("127.0.0.a"));

    }

    @Test
    void isIp4Adress_NoValidIpAdress_False()
    {
        assertFalse(IpAddressRegex.isIp4Adress("138.277.0.9"));
        assertFalse(IpAddressRegex.isIp4Adress("138.2555.0.9"));
    }
}
