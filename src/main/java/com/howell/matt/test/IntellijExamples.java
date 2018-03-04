package com.howell.matt.test;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Intelli-j shortcuts.
 */
@Slf4j
public final class IntellijExamples {

    /**
     * String.
     */
    private static final String STRING = "A String";

    private IntellijExamples() {
    }

    /**
     * psf.
     */
    // public static final int CREATED_USING_PSF = 1;

    /**
     * psfs. shift + cmd + U = toggle case.
     */
    // public static final String EXAMPLE_TO_TOGGLE_CASE = "dd";

    /**
     * prsf.
     */
    // private static final boolean CREATED_USING_PRSF = false;

    /**
     * Output stream. ctrl + space to suggest name.
     */
    // private FileOutputStream fileOutputStream;

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(final String[] args) {

        // Find:
        // cmd + o // open class
        // opt + cmd + o // find symbol
        // shift + cmd + o // open file
        // cmd + l // go to line/col

        // cmd + aBool = find def
        // opt + cmd + aBool = find implementation

        // cmd + [ and cmd + ] to go back/forward in history

        // shift + cmd + T = Create test class
        // ctrl + cmd + Up => go to related classes (Class -> Test, etc.)

        // highlight usages = fn + shift + command + F7...cmd + G to cycle
        // cmd + N to generate
        // ctrl + O to override
        // cmd + D to duplicate block/current line

        // fn + f2 to jump to errors
        // cmd + E = recent files
        // shift + cmd + delete to go to last edit location

        // opt + enter to list imports
        // shift + ctrl + space after new to auto complete instant
        //<editor-fold desc="Stuff">
        final Map<String, Integer> map = new HashMap<>();

        map.put("aString", 1);
        //</editor-fold>

        // map.put(). cursor inside Parens...cmd + P to show params

        // command J

        // cmd + option + t to surround
        // cmd + option + t ...6 for try/catch
        //sout
        log.info("String: {}", STRING);

        // ctrl + up for selection

        // cmd + option + / to block comment


        // "String s = (" then press ctrl space
        // String s = (String) "adf";

        map.put("aBool", 2);

        final char[] charList = new char[] {'A', 'b', 'c'};

        // itar
        for (int i = 0; i < charList.length; i++) {
            char charEntry = charList[i];
            log.info("{}", charEntry);
        }

        // anInt.for + tab
        for (char charEntry : charList) {
            log.info("{}", charEntry);
        }

        final int[] intList = new int[] {1, 2, 3};

        for (int j = 0; j < intList.length; j++) {
            final int i1 = intList[j];
            log.info("{}", i1);
        }
    }
}
