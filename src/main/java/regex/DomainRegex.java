/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

public class DomainRegex
{
    private static final String REGEX = "(?=^.{1,254}$)(^(?:(?!\\d+\\.)[a-zA-Z0-9_\\-]{1,63}\\.?)+(?:[a-zA-Z]{2,})$)";

    private DomainRegex(){};

    public static boolean isDomain(String address)
    {
        return address.matches(REGEX);
    }
}
