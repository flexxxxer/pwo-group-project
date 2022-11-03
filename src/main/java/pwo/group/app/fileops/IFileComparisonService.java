package pwo.group.app.fileops;

import java.util.ArrayList;

/**
 * @author Aleksandr Kovalyov
 */
public interface IFileComparisonService {
    ArrayList<FileWithStats> TrimNonCommonProperties(ArrayList<FileWithStats> filesWithStats);
}
