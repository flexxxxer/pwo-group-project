package pwo.group.app.fileops;

import java.util.ArrayList;
import pwo.group.app.filestats.IFileStatisticalProperty;

/**
 * @author Aleksandr Kovalyov
 */
public interface IFileStatisticService {
    ArrayList<? extends IFileStatisticalProperty> GetFileStatistics(String filePath);
}
