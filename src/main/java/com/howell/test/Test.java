package com.howell.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Live templates
 */
public class Test {

    public static final String STRING = "A String";

    // psf
    public static final int a = 1;
    // psfs

    // shift + cmd + U = toggle case
    public static final String c = "dd";
    // prsf
    private static final boolean b = false;

    // "private FileOutputStream " ctrl + space to suggest name
    private FileOutputStream fileOutputStream;

//     Live templates

    // psvm
    public static void main(String[] args) {

        char[] c = new char[]{'a', 'b', 'c'};

        // itar
        for (int i = 0; i < c.length; i++) {
            char c1 = c[i];

        }

        // Find:
        // cmd + o // open class
        // opt + cmd + o // find symbol
        // shift + cmd + o // open file
        // cmd + l // go to line/col

        // cmd + b = find def
        // opt + cmd + b = find implementation

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

        int[] i = new int[]{1, 2, 3};

        for (int j = 0; j < i.length; j++) {
            int i1 = i[j];

        }

        // opt + enter to list imports
        // shift + ctrl + space after new to auto complete instant
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();

        map.put("a", 1);

        // map.put(). cursor inside Parens...cmd + P to show params

        // command J

        // cmd + option + t to surround
        // cmd + option + t ...6 for try/catch
        //sout
        System.out.println("String:");
        System.out.println(STRING);

        // ctrl + up for selection

        // cmd + option + / to block comment

        // "String s = (" then press ctrl space
        String s = (String) "adf";

        // Find usages fn + opt + f7

    }

}
