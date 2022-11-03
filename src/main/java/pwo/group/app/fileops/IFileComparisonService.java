package pwo.group.app.fileops;

import java.util.ArrayList;

/**
 * @author Vladyslav Hutsenko
 */
public interface IFileComparisonService {
    ArrayList<FileWithStats> TrimNonCommonProperties(ArrayList<FileWithStats> filesWithStats);
}
