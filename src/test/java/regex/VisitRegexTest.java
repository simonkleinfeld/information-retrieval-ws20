/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VisitRegexTest
{
    @Test
    void isOccurenceOfVisit_visit_True()
    {

        assertTrue(VisitRegex.isOccurenceOfVisit("visit"));

    }

    @Test
    void isOccurenceOfVisit_Visit_True()
    {

        assertTrue(VisitRegex.isOccurenceOfVisit("Visit"));

    }

    @Test
    void isOccurenceOfVisit_Visitors_True()
    {

        assertTrue(VisitRegex.isOccurenceOfVisit("Visitors"));

    }

    @Test
    void isOccurenceOfVisit_visits_True()
    {

        assertTrue(VisitRegex.isOccurenceOfVisit("visits"));

    }

    @Test
    void isOccurenceOfVisit_revisitting_True()
    {

        assertFalse(VisitRegex.isOccurenceOfVisit("revisitting"));

    }

    @Test
    void isOccurenceOfVisit_visited_True()
    {

        assertTrue(VisitRegex.isOccurenceOfVisit("visited"));

    }

    @Test
    void isOccurenceOfVisit_sited_False()
    {

        assertFalse(VisitRegex.isOccurenceOfVisit("sited"));

    }

    @Test
    void isOccurenceOfVisit_abc_False()
    {

        assertFalse(VisitRegex.isOccurenceOfVisit("abc"));

    }

    @Test
    void occurencesOfVisit_bronteJane_53()
            throws Exception
    {

        assertEquals(53, VisitRegex.occurencesInFile("src/test/resources/bronte_jane_eyre.txt"));

    }

    @Test
    void occurencesOfVisit_aquinasSumma_53()
            throws Exception
    {

        assertEquals(3, VisitRegex.occurencesInFile("src/test/resources/aquinas_-_summa_i.txt"));

    }
}
