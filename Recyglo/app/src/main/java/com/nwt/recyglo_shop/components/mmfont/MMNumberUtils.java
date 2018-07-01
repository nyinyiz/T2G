package com.nwt.recyglo_shop.components.mmfont;

public class MMNumberUtils {

    private MMNumberUtils(){}

    /**
     * Transform Burmese number to English number (e.g "၃၀" -> "30")
     * @param n Burmese Number in String type
     * @return English Number in String type
     */
    public static String getEngNumber(String n) {
        String eng = "";
        for(char c: n.toCharArray()) {
            if(isNumber(c))
                eng += (char) (c - 4112);
            else
                eng += (char) c;
        }
        return eng;
    }

    /**
     * Transform English number to Burmese number (e.g "30" -> "၃၀");
     * @param n English Number in String type.
     * @return Burmese Number in String type.
     */
    public static String getMMNumber(String n) {
        String mm = "";
        for (char c: n.toCharArray()) {
            if(isNumber(c))
                mm += (char) (c + 4112);
            else
                mm += (char) c;
        }
        return mm;
    }

    /**
     * Transform English number to Burmese number (e.g 30 -> "၃၀")
     * @param n English Number in int type
     * @return Burmese Number in String type
     */
    public static String getMMNumber(int n) {
        return getMMNumber(String.valueOf(n));
    }

    /**
     * Check whether a char is a number
     * @param c a character
     * @return true if c is a number, otherwise false
     */
    public static boolean isNumber(char c) {
        return '0' <= c && c <= '9' || '၀' <= c && c <= '၉';
    }
}
