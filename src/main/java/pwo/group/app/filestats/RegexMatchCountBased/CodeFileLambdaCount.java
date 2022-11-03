package pwo.group.app.filestats.RegexMatchCountBased;

import java.util.regex.Pattern;

/**
 * @author Aleksandr Kovalyov
 */
public class CodeFileLambdaCount extends RegexMatchCount {
    private static final Pattern REGEX = Pattern.compile("\\(\\w+\\)? =>");
    
    public CodeFileLambdaCount(String text) {
        super(text, REGEX);
    }
}
