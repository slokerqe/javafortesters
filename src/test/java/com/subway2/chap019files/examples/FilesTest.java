package com.subway2.chap019files.examples;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.subway2.doaineobjects.TestDataFile;
import org.junit.jupiter.api.Test;

public class FilesTest {

    @Test
    public void readTheTempFile() throws IOException {
        TestDataFile myFile = new TestDataFile();

        File inputFile = myFile.writeTheTestDataFile();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        System.out.println(System.getProperty("java.io.tmpdir"));
        try {
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } finally {
            reader.close();
        }

        new File(String.valueOf(inputFile)).delete(); // automatically delete just created file
    }

    @Test
    public void readMyCSVFile() throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ad1\\Desktop\\Card Orders CSV\\CSV for java learning.csv"));
        System.out.println(System.getProperty("java.io.tmpdir"));
        try {
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } finally {
            reader.close();
        }
//        Assert.assertThat(reader.);

       // new File(String.valueOf(inputFile)).delete(); // automatically delete just created file
    }

}
