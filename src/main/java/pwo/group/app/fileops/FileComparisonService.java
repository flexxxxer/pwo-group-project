package pwo.group.app.fileops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Vladyslav Hutsenko
 */
public class FileComparisonService implements IFileComparisonService {

    @Override
    public ArrayList<FileWithStats> TrimNonCommonProperties(ArrayList<FileWithStats> filesWithStats) {
        var propertiesRating = new HashMap<Class<?>, Integer>() {};
        
        for(var fileWithStats : filesWithStats){
            for(var statProp : fileWithStats.GetStats()){
                var t = statProp.getClass();
                if(propertiesRating.containsKey(t)){
                    propertiesRating.replace(t, propertiesRating.get(t) + 1);
                }
                else {
                    propertiesRating.put(t, 1);
                }
            }
        }
        
        var onlyCommonProperties = propertiesRating.entrySet().stream()
                .filter(prop -> prop.getValue() == filesWithStats.size())
                .map(prop -> prop.getKey())
                .collect(Collectors.toCollection(ArrayList::new));
        
        return filesWithStats.stream()
                .map(fileWithStats -> new FileWithStats(
                        fileWithStats.GetFilePath(), fileWithStats.GetStats().stream()
                                .filter(prop -> onlyCommonProperties.contains(prop.getClass()))
                                .collect(Collectors.toCollection(ArrayList::new))))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
}
