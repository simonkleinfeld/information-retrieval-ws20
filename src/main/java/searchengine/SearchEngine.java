/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package searchengine;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

public class SearchEngine
{

    public static void main(String... args)
    {

        if ( args.length > 0 && args.length <= 2 )
        {

            var regex = args[0];
            var path = args.length == 2 ? args[1] : ".";

            System.out.println("Searching for regex " + regex + " in path " + path);

            var l = processFiles(regex, path);

            System.out.println("Results: " + l.size());
            System.out.println("Matching Files: " + l);

        }
        else
        {
            System.out.println("Usage: java -jar refoldersearch.jar REGEX [PATH TO FOLDER]");
        }

    }

    protected static List<String> processFiles(String regex, String path)
    {
        File directory = new File(path);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        var list = listOfFiles == null ? new ArrayList<File>() : Arrays.asList(listOfFiles);

        return list.parallelStream()
                .filter(file -> {
                    try
                    {
                        String data = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                        var matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
                                .matcher(data);

                        return matcher.find();
                    }
                    catch ( IOException e )
                    {
                        System.out.println("File: " + file.getName() + " cannot be read");
                        return false;
                    }
                })
                .map(File::getName)
                .sorted()
                .collect(Collectors.toList());

    }

}
