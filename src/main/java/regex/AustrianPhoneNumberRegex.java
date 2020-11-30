/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AustrianPhoneNumberRegex
{



    private AustrianPhoneNumberRegex()
    {
    }



    public static String getNormalizedPhoneNumber(String nr){

        var cleaned = nr.replaceAll("[^0-9]", "");
        Pattern pattern = Pattern.compile("([0-9]{4})([0-9]{3})([0-9]*)");
        Matcher matcher = pattern.matcher(cleaned);


        if (matcher.matches()) {
            return "+43 (" + matcher.group(1).replaceAll("^0+(?!$)", "") + ") " + matcher.group(2) + "-" + matcher.group(3);
        }
        return null;

    }
}
