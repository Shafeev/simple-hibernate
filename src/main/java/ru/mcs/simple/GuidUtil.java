package ru.mcs.simple;

public class GuidUtil {
    private static String KHEX_CHARS = "0123456789abcdef";

    public static String newGuid() {

        StringBuilder returnValue = new StringBuilder();
        int nextByte = 0;

        for (int i = 0; i<16; i++) {

            if (i==4 || i==6 || i==8 || i==10)
                returnValue.append("-");

            nextByte = Math.toIntExact((Math.round(Math.random() * 255) - 128) & 255);

            if (i==6) {
                nextByte = nextByte & 15;
                nextByte = nextByte | (4 << 4);
            }

            if (i==8) {
                nextByte = nextByte & 63;
                nextByte = nextByte | 128;
            }

            returnValue.append(getCharAtIndex(KHEX_CHARS, nextByte >> 4));
            returnValue.append(getCharAtIndex(KHEX_CHARS, nextByte & 15));
        }

        return returnValue.toString();
    }

    public static String getCharAtIndex(String str, Integer index) {
        if (str == null) return null;
        if (str.length() <= 0) return str;
        if (index == str.length()) return null;
        return str.substring(index, index+1);
    }
}
