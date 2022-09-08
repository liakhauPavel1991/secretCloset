package tools.utils;

import tools.constants.StringConstants;

public class StringUtils {

    public static int getOnlyIntFromString(String str) {
        return Integer.parseInt(str.replaceAll(RegExpUtils.ONLY_NUMBERS_AND_LETTERS, StringConstants.EMPTY_STRING));
    }
}
