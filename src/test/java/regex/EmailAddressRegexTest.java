/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmailAddressRegexTest
{
    @Test
    void isEmailAdress_ValidAdress_true()
    {

        assertTrue(EmailAdressRegex.isEmailAdress("kleinfelds@google.com"));
        assertTrue(EmailAdressRegex.isEmailAdress("simon.kleinfeld@google.com"));
        assertTrue(EmailAdressRegex.isEmailAdress("kl@drive.google.com"));
        assertTrue(EmailAdressRegex.isEmailAdress("a.b.c@uibk.ac.at"));
        assertTrue(EmailAdressRegex.isEmailAdress("gmail@cl-informatik.uibk.ac.at"));

    }

    @Test
    void isValidDomainName_NotValidDomain_false()
    {

        assertFalse(EmailAdressRegex.isEmailAdress("kleinfelds@.com"));
        assertFalse(EmailAdressRegex.isEmailAdress("kleinfelds@google"));
        assertFalse(EmailAdressRegex.isEmailAdress("kl at drive.google com"));
        assertFalse(EmailAdressRegex.isEmailAdress("kl@uib,at"));
        assertFalse(EmailAdressRegex.isEmailAdress("kl@cl-informatik:uibk.ac.at"));

    }
}
