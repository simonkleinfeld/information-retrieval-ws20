/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AustrianPhoneNumberRegexTest
{

    @Test
    void normalizePhoneNr_ExampleFromSlides_True()
    {
        assertEquals("+43 (512) 507-45010", AustrianPhoneNumberRegex.getNormalizedPhoneNumber("0512 507-45010"));
    }

}
