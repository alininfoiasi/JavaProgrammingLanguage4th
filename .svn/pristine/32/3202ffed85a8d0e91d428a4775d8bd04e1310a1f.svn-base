package ch13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

    public static void replaceWith(String input, String toBeReplacedText, String replacementText) {
        Pattern pat = Pattern.compile(toBeReplacedText);
        Matcher matcher = pat.matcher(input);
        StringBuffer result = new StringBuffer();
        boolean found;
        while ((found = matcher.find())) {
            // copy text from current position to next match into result
            // then append the replacement text
            matcher.appendReplacement(result, replacementText);
        }
        matcher.appendTail(result);
        System.out.println(result);
    }

    public static void replaceNumberWithNext(String input) {
        Pattern pat = Pattern.compile("[-+]?[0-9]+");
        Matcher matcher = pat.matcher(input);
        StringBuffer result = new StringBuffer();
        boolean found;
        while ((found = matcher.find())) {
            String numStr = matcher.group();
            int num = Integer.parseInt(numStr);
            String plusOne = Integer.toString(num + 1);
            matcher.appendReplacement(result, plusOne);
        }
        matcher.appendTail(result);
        System.out.println(result);
    }

    public static void main(String args[]) {
        RegularExpressions.replaceWith("  11Some text goes here 456 78", "o", "0");
        RegularExpressions.replaceNumberWithNext("  11Some text goes here 456 78");
    }
}
