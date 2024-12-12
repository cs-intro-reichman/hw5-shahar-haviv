import java.util.Random;

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        // String hello = "hello";
        // System.out.println(countChar(hello, 'h'));
        // System.out.println(countChar(hello, 'l'));
        // System.out.println(countChar(hello, 'z'));
        // System.out.println(spacedString(hello));
        System.out.println(subsetOf("runi", "running"));
        System.out.println(subsetOf("pass", "space"));
        // System.out.println( spacedString("silent"));
        // System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c')
     * returns 0.
     * 
     * @param str - a string
     * @param c   - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        for (char c : str1.toCharArray()) {
            if (str2.indexOf(c) == -1) {
                return false; // If a character from str2 is not found in str1
            } else {
                str2 = str2.replace(String.valueOf(c), "");
            }
        }
        return true; // All characters of str2 are found in str1
    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String spaced = "";
        if (str.length() < 1)
            return spaced;
        else {
            for (int i = 0; i < str.length(); i++) {
                spaced += str.charAt(i);
                if (i < str.length() - 1) {
                    spaced += " ";
                }
            }
        }
        return spaced;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        Random rnd = new Random();
        int random = 97;
        for (int i = 0; i < n; i++) {
            str += (char) (random + rnd.nextInt(122 - 97 + 1));
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in
     * the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String hand, String other) {
        String result = hand;
        for (int i = 0; i < other.length(); i++) {
            char currentChar = other.charAt(i);
            int index = result.indexOf(currentChar);
            if (index != -1) {
                result = result.substring(0, index) + result.substring(index + 1);
            }
        }
        return result;
    }

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or
     * "cast", or "cats".
     * 
     * @param ch  - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
        return result;
    }
}