package net.thumbtack.school.base;

import java.text.DecimalFormat;
import java.util.StringJoiner;

public class StringOperations {
    public static int getSummaryLength(String[] strings) {
        int length = 0;
        for (String num : strings) {
            length += num.length();
        }
        return length;
    }

    public static String getFirstAndLastLetterString(String string) {
        StringBuilder string3 = new StringBuilder();
        string3.append(string.charAt(0)).append(string.charAt(string.length() - 1));
        return string3.toString();
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string2.compareTo(string1) > 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string2.compareToIgnoreCase(string1) > 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int i = 0;
        while ((i < (Math.min(string1.length(), string2.length())) && isSameCharAtPosition(string1, string2, i))) {
            i++;
        }
        return string1.substring(0, i);
    }

    public static boolean isPalindrome(String string) {
        return string.equals((new StringBuilder(string)).reverse().toString());
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase((new StringBuilder(string)).reverse().toString().toLowerCase());
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String string3 = "";
        for (String num : strings) {
            if (isPalindromeIgnoreCase(num) && num.length() > string3.length()) {
                string3 = num;
            }
        }
        return string3;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (index + length <= (Math.min(string1.length(), string2.length()))) {
            return isEqual(string1.substring(index, index + length), string2.substring(index, index + length));
        } else {
            return false;
        }

    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return isEqual(string1.replace(replaceInStr1, replaceByInStr1), string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return isEqual(string1.replace(replaceInStr1, replaceByInStr1), string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replace(" ", ""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return isEqual(string1.trim(), string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringJoiner joiner = new StringJoiner(",");
        for (int num : array) {
            joiner.add(String.valueOf(num));
        }
        return joiner.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        DecimalFormat df = new DecimalFormat("#0.00");
        StringJoiner joiner = new StringJoiner(",");
        for (double num : array) {
            joiner.add(df.format(num));
        }
        return joiner.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        return new StringBuilder(makeCsvStringFromInts(array));
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return new StringBuilder(makeCsvStringFromDoubles(array));
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder string3 = new StringBuilder();
        string3.append(string);
        for (int i = 0; i < positions.length; i++) {
            string3.deleteCharAt(positions[i] - i);
        }
        return string3;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder string3 = new StringBuilder();
        string3.append(string);
        for (int i = 0; i < positions.length; i++) {
            string3.insert(positions[i] + i, characters[i]);
        }

        return string3;
    }
}
