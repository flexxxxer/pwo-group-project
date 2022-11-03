package pwo.group.app.fileops;

import java.util.ArrayList;
import pwo.group.app.filestats.IFileStatisticalProperty;

/**
 * @author Aleksandr Kovalyov
 */
public class FileWithStats {
    private final String _filePath;
    private final ArrayList<IFileStatisticalProperty> _stats;
    
    public FileWithStats(String filePath, ArrayList<IFileStatisticalProperty> stats){
        _filePath = filePath;
        _stats = stats;
    }
    
    public String GetFilePath(){
        return _filePath;
    }
    
    public ArrayList<IFileStatisticalProperty> GetStats(){
        return _stats;
    }
}
