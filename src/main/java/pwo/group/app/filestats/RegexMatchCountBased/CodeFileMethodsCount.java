package pwo.group.app.filestats.RegexMatchCountBased;

import java.util.regex.Pattern;

/**
 * @author Aleksandr Kovalyov
 */
public class CodeFileMethodsCount extends RegexMatchCount {
    private static final Pattern REGEX = Pattern.compile("(static )?(public |private |protected |internal )?(static )?(override )?\\b(?!new\\b)\\S+ \\w+\\((\\S+ \\w+)?\\)");
    
    public CodeFileMethodsCount(String text) {
        super(text, REGEX);
    }
}
