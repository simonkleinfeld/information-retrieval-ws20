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
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

public class SearchEngine
{

    public static void main(String... args)
            throws InterruptedException
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

    protected static ArrayList<String> processFiles(String regex, String path)
            throws InterruptedException
    {
        var matchingFiles = new ConcurrentLinkedQueue<String>();

        File directory = new File(path);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        var list = listOfFiles == null ? new ArrayList<File>() : Arrays.asList(listOfFiles);
        var latch = new CountDownLatch(list.size());

        list.parallelStream()
                .forEach(file -> {
                    try
                    {
                        String data = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                        var matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
                                .matcher(data);

                        if ( matcher.find() )
                        {
                            matchingFiles.add(file.getName());
                        }
                    }
                    catch ( IOException e )
                    {
                        System.out.println("File: " + file.getName() + " cannot be read");

                    }

                    latch.countDown();
                });

        latch.await();

        var l = new ArrayList<>(matchingFiles);

        l.sort(String::compareTo);
        return l;
    }

}
