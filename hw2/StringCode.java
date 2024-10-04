import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        int count = 1;
        int max1 = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
                max1 = Math.max(count, max1);
            } else {
                count = 1;
            }
        }
        return max1;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        String res = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (Character.isDigit(str.charAt(i))) {
                for (int j = 1; j <= Character.getNumericValue(str.charAt(i)); j++) {
                    res += str.charAt(i + 1);
                }
            } else {
                res += str.charAt(i);
            }
        }
        if (Character.isDigit(str.charAt(str.length() - 1))) {
            return res;
        } else {
            return res + str.charAt(str.length() - 1);
        }
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }
        for (int i = 0; i < b.length() - len; i++) {
            if (set.contains(b.substring(i, i + len))) {
                return true;
            }
        }
        return false;
    }

}
