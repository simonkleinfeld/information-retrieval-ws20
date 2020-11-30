/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package homework4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;

public class CoreNLP
{

    public static void main(String... args)
            throws IOException
    {

        String data = FileUtils.readFileToString(new File("/resources/texts/doyle_-_the_hound_of_the_baskervilles.txt"), StandardCharsets.UTF_8);


    }

}
