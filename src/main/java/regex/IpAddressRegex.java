/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

public class IpAddressRegex
{

    private static final String REGEX = "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

    private IpAddressRegex(){}

    public static boolean isIp4Adress(String address)
    {
        //return false;
        return address.matches(REGEX);
    }

}
