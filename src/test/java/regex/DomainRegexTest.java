/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DomainRegexTest
{
    @Test
    void isValidDomainName_ValidDomain_true()
    {

        assertTrue(DomainRegex.isDomain("google.com"));
        assertTrue(DomainRegex.isDomain("www.google.com"));
        assertTrue(DomainRegex.isDomain("drive.google.com"));
        assertTrue(DomainRegex.isDomain("uibk.ac.at"));
        assertTrue(DomainRegex.isDomain("cl-informatik.uibk.ac.at"));

    }

    @Test
    void isValidDomainName_NotValidDomain_false()
    {

        assertFalse(DomainRegex.isDomain(".com"));
        assertFalse(DomainRegex.isDomain("www.m"));
        assertFalse(DomainRegex.isDomain("drive.google com"));
        assertFalse(DomainRegex.isDomain("uib,at"));
        assertFalse(DomainRegex.isDomain("cl-informatik:uibk.ac.at"));

    }
}
