/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

import org.junit.jupiter.api.Test;

public class FlatNfaRegexTest
{

    @Test
    void testStringForA()
    {
        String a = "001010111";

        System.out.println(a + " matches for i: " + FlatNfaRegex.matchesI(a));
        System.out.println(a + " matches for ii: " + FlatNfaRegex.matchesII(a));
        System.out.println(a + " matches for iii: " + FlatNfaRegex.matchesIII(a));
        System.out.println(a + " matches for iv: " + FlatNfaRegex.matchesIV(a));
        System.out.println(a + " matches for v: " + FlatNfaRegex.matchesV(a));
    }

    @Test
    void testStringForB()
    {
        String a = "010000010";

        System.out.println(a + " matches for i: " + FlatNfaRegex.matchesI(a));
        System.out.println(a + " matches for ii: " + FlatNfaRegex.matchesII(a));
        System.out.println(a + " matches for iii: " + FlatNfaRegex.matchesIII(a));
        System.out.println(a + " matches for iv: " + FlatNfaRegex.matchesIV(a));
        System.out.println(a + " matches for v: " + FlatNfaRegex.matchesV(a));
    }

    @Test
    void testStringForC()
    {
        String a = "010011";

        System.out.println(a + " matches for i: " + FlatNfaRegex.matchesI(a));
        System.out.println(a + " matches for ii: " + FlatNfaRegex.matchesII(a));
        System.out.println(a + " matches for iii: " + FlatNfaRegex.matchesIII(a));
        System.out.println(a + " matches for iv: " + FlatNfaRegex.matchesIV(a));
        System.out.println(a + " matches for v: " + FlatNfaRegex.matchesV(a));
    }

    @Test
    void testStringForD()
    {
        String a = "001111111111000";

        System.out.println(a + " matches for i: " + FlatNfaRegex.matchesI(a));
        System.out.println(a + " matches for ii: " + FlatNfaRegex.matchesII(a));
        System.out.println(a + " matches for iii: " + FlatNfaRegex.matchesIII(a));
        System.out.println(a + " matches for iv: " + FlatNfaRegex.matchesIV(a));
        System.out.println(a + " matches for v: " + FlatNfaRegex.matchesV(a));
    }

    @Test
    void testStringForE()
    {
        String a = "0111000011010";

        System.out.println(a + " matches for i: " + FlatNfaRegex.matchesI(a));
        System.out.println(a + " matches for ii: " + FlatNfaRegex.matchesII(a));
        System.out.println(a + " matches for iii: " + FlatNfaRegex.matchesIII(a));
        System.out.println(a + " matches for iv: " + FlatNfaRegex.matchesIV(a));
        System.out.println(a + " matches for v: " + FlatNfaRegex.matchesV(a));
    }
}
