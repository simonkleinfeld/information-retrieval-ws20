/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisitRegex
{

    private static final String REGEX = "(?i)visit[a-z]*";

    private VisitRegex()
    {
    }

    public static boolean isOccurenceOfVisit(String visit)
    {
        return visit.matches(REGEX);
    }

    private static String readFileAsString(String fileName)
            throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static int occurencesInFile(String fileName)
            throws Exception
    {
        Matcher matcher = Pattern.compile(REGEX)
                .matcher(readFileAsString(fileName));

        int res = 0;

        // for every presence of character ch
        // increment the counter res by 1
        while ( matcher.find() )
        {
            res++;
        }

        return res;
    }

}
