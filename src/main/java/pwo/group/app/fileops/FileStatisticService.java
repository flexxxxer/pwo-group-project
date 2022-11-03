/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.group.app.fileops;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import pwo.group.app.filestats.IFileStatisticalProperty;
import pwo.group.app.core.CollectionBuilder;
import pwo.group.app.filestats.FileSize;
import pwo.group.app.filestats.RegexMatchCountBased.*;
/**
 *
 * @author Aleksandr Kovalyov
 */
public class FileStatisticService implements IFileStatisticService {

    @Override
    public ArrayList<IFileStatisticalProperty> GetFileStatistics(String filePath) {
        if(Files.notExists(Path.of(filePath))) {
            return new ArrayList<IFileStatisticalProperty>();
        }
        
        var fileText = "";
        try {
            fileText = Files.readString(Path.of(filePath));
        } catch (IOException ex) {
            fileText = "";
        }
        
        var extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        var fileStats = CollectionBuilder
                .fromCollection(new ArrayList<IFileStatisticalProperty>())
                .add(new FileSize(filePath));
        
        switch(extension) {
            case "cs" -> fileStats
                    .add(new CodeFileClassCount(fileText))
                    .add(new CodeFileMethodsCount(fileText))
                    .add(new CodeFileLambdaCount(fileText))
                    .add(new CodeFileMethodsCallCount(fileText))
                    .add(new CodeFileLiteralsCount(fileText))
                    .add(new CodeFileVariablesCount(fileText));
            case "java" -> fileStats
                    .add(new CodeFileClassCount(fileText))
                    .add(new CodeFileMethodsCallCount(fileText))
                    .add(new CodeFileLiteralsCount(fileText))
                    .add(new CodeFileMethodsCount(fileText))
                    .add(new CodeFileVariablesCount(fileText));
            
            case "py" -> fileStats
                    .add(new CodeFileMethodsCallCount(fileText))
                    .add(new CodeFileLiteralsCount(fileText))
                    .add(new CodeFileVariablesCount(fileText));
            
            default -> { }
        }
        
        return fileStats.build();
    }
    
}
