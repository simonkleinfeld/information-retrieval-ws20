/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package regex;

public class FlatNfaRegex
{
    private static String regex_i = "0(01*1|00)*01*";
    private static String regex_ii = "0(10*1|10)*10*";
    private static String regex_iii = "0(10*1|00)*0";
    private static String regex_iv = "0(01*1|00)*0";
    private static String regex_v = "0(10*1|10)*1";


    public static boolean matchesI(String s){
        return s.matches(regex_i);
    }

    public static boolean matchesII(String s){
        return s.matches(regex_ii);
    }

    public static boolean matchesIII(String s){
        return s.matches(regex_iii);
    }

    public static boolean matchesIV(String s){
        return s.matches(regex_iv);
    }

    public static boolean matchesV(String s){
        return s.matches(regex_v);
    }

}
