package com.subway2.doaineobjects;

import java.io.*;

public class TestDataFile {
    public File writeTheTestDataFile() throws IOException{
        File outputFile = File.createTempFile("forReading", null);
        PrintWriter print = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(outputFile)));
        for (int lineNumber = 1; lineNumber < 6; lineNumber++){
            print.println("Line number - " + lineNumber);
        }
        print.close();
        return outputFile;
    }
//    public File getWriteTheTestDataFile() throws IOException { return writeTheTestDataFile();}
}
