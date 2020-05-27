/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.utilities;

/**
 * String Checker Utility.
 * @author abel
 */
public final class StringUtil {
    
    /**
     * This method can calculate the string length.
     * @param word String.
     * @param len Integer.
     * @return true if string length is equals to len.
     */
    public static boolean isStringThisLen(final String word, final int len) {
        return word.length() == len;
    }
    
    /**
     * This method is for cut a String in a small string.
     * @param word String
     * @param init Integer
     * @param end Integer
     * @return A Original String or SubString.
     */
    public static String cutString(String word, int init, int end) {
        String newWord;
        try {
            newWord = word.substring(init, end);
            return newWord;
        } catch (StringIndexOutOfBoundsException e) {
            return word;
        }
    }
    
    /**
     * Verifies if String is empty.
     * @param word String
     * @return true if it is empty.
     */
    public static boolean isEmpty(final String word) {
        return word.length() == 0;
    }
    
    /**
     * Verifies if String is null.
     * @param word String
     * @return true if it is null.
     */
    public static boolean isNull(final String word) {
        return word == null;
    }
    
    /**
     * Verifies if String is empty or null.
     * @param word String
     * @return true if it is empty or null.
     */
    public static boolean isNullOrEmpty(final String word) {
        return word == null || word.length() == 0;
    }
    
    /**
     * Verifies if a character sent is an . point
     * @param letter Character
     * @return true if it be . point
     */
    public static boolean isPointFound(final char letter) {
        return letter == '.';
    }
    
    /**
     * Verifies if a character sent is an _.
     * @param letter Character
     * @return true if it be _
     */
    public static boolean isUnderscoreFound(final char letter) {
        return letter == '_';
    }
    
    /**
     * Verifies if a character sent is a ' '
     * @param letter Character
     * @return true if it be ' '
     */
    public static boolean isSpaceFound(final char letter) {
        return letter == ' ';
    }
    
    /**
     * Verifies if a character is a letter
     * @param letter Character
     * @return true if it is a letter.
     */
    public static boolean isLetter(final char letter) {
        return Character.isLetter(letter);
    }
    
    /**
     * Verifies if a character is numeric by ascii table.
     * @param letter Character
     * @return true if it is a number.
     */
    public static boolean isNumeric(final char letter) {
        return letter > 47 && letter < 58;
    }
    
    /**
     * Verifies if a character is a '-' hyphen
     * @param letter Character
     * @return true if it is '-' hyphen
     */
    public static boolean isHyphen(final char letter) {
        return letter == 45;
    }
    
    /**
     * This method verifies each character searching if something is different 
     * of a letter of alphabet. It is need to verifies personal names for example.
     * @param word String.
     * @return true if all characters is a letter.
     */
    public static boolean isNameValidLetters(final String word) {
        for (short i = 0; i < word.length(); i += 1) {
            if (!isLetter(word.charAt(i))) {
                if (isSpaceFound(word.charAt(i))) continue;
                if (isHyphen(word.charAt(i))) continue;
                return false;
            }
        }
        return true;
    }
    
}
