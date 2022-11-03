package pwo.group.app.filestats.RegexMatchCountBased;

import java.util.regex.Pattern;

/**
 * @author Aleksandr Kovalyov
 */
public class CodeFileClassCount extends RegexMatchCount {
    private static final Pattern REGEX = Pattern.compile("class \\w+");
    
    public CodeFileClassCount(String text) {
        super(text, REGEX);
    }
}
