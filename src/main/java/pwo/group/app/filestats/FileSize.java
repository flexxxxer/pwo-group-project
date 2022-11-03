package pwo.group.app.filestats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Aleksandr Kovalyov
 */
public class FileSize implements IFileStatisticalProperty {
    private String size;
    
    public FileSize(String filePath) {
        try {
            size = Files.size(Path.of(filePath)) / 1024.0 + " kb";
        } catch (IOException ex) {
            size = "unknown";
        }
    }
    
    @Override
    public String GetName() {
        return "FileSize";
    }

    @Override
    public Object GetValue() {
        return size;
    }
    
}
