package pwo.group.app.filestats.RegexMatchCountBased;

import java.util.regex.Pattern;
import pwo.group.app.filestats.TypeNamedStatisticalProperty;

/**
 * @author Aleksandr Kovalyov
 */
public abstract class RegexMatchCount extends TypeNamedStatisticalProperty {
    private final Integer matchCount;
    
    public RegexMatchCount(String text, Pattern regex) {
        matchCount = Math.toIntExact(regex.matcher(text).results().count());
    }
    
    @Override
    public Integer GetValue() {
        return matchCount;
    }    
}
