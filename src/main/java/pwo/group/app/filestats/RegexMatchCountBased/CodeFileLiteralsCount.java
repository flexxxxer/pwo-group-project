package pwo.group.app.filestats.RegexMatchCountBased;

import java.util.regex.Pattern;

/**
 * @author Aleksandr Kovalyov
 */
public class CodeFileLiteralsCount extends RegexMatchCount {
    private static final Pattern REGEX = Pattern.compile("(\\d+|\\d+\\.\\d+m?|\"\"\\S+\"\"|[T|t]rue|[F|f]alse)");
    
    public CodeFileLiteralsCount(String text) {
        super(text, REGEX);
    }
}
