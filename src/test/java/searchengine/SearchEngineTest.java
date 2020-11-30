/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package searchengine;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SearchEngineTest
{

    @Test
    void processFiles_RegexNoPath_ReturnKleist()
            throws InterruptedException
    {

        var listOfFiles = SearchEngine.processFiles("zerbrochene", ".");

        assertAll(
                () -> assertEquals(1, listOfFiles.size()),
                () -> assertTrue(listOfFiles.contains("kleist_-_der_zerbrochene_krug.txt"))


        );

    }

    @Test
    void processFiles_RegexPath_de_00001()
            throws InterruptedException
    {

        var listOfFiles = SearchEngine.processFiles("01805", "src/main/resources");

        assertAll(
                () -> assertEquals(1, listOfFiles.size()),
                () -> assertTrue(listOfFiles.contains("de_00000.txt"))


        );

    }

    @Test
    void processFiles_RegexPath1_de_00001()
            throws InterruptedException
    {

        var listOfFiles = SearchEngine.processFiles("[0-9]{5}", "src/main/resources");

        assertAll(
                () -> assertEquals(2, listOfFiles.size()),
                () -> assertTrue(listOfFiles.contains("de_00000.txt")),
                () -> assertTrue(listOfFiles.contains("de_00001.txt"))


        );

    }
}
