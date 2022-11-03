package pwo.group.app.filestats.RegexMatchCountBased;

import java.util.regex.Pattern;

/**
 * @author Aleksandr Kovalyov
 */
public class CodeFileVariablesCount extends RegexMatchCount {
    private static final Pattern REGEX = Pattern.compile("(var|\\w+) ?\\w+ = \\w+");
    
    public CodeFileVariablesCount(String text) {
        super(text, REGEX);
    }
}
