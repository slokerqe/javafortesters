package com.subway2.chap001.examples;


import com.subway2.doaineobjects.TestDataFile;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.nio.file.StandardCopyOption;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.jupiter.api.Assertions.*;
import static sun.nio.cs.Surrogate.is;

public class FirstTest {
    @Test
    public void verifyJunitTest() {
        String str = "Hello World!";
        assertEquals("Hello World!", str);
    }

    //....................................................................
    //EXERCISE
    @Test
    public void verifyFilledFile() throws IOException {
        TestDataFile myFile = new TestDataFile();
        BufferedReader reader = new BufferedReader(
                new FileReader(myFile.writeTheTestDataFile()));

        String fileData;
        while ((fileData = reader.readLine()) != null) {
            System.out.println(fileData);
        }
        reader.close();
        System.out.println(myFile.writeTheTestDataFile().getPath());

    }

    //.......................................................
    @Test
    public void verifySeparator() {
        assertTrue(File.separator.equals("\\") ||
                File.separator.equals("/"), "Unrecognised OS file separator");
        assertTrue(File.pathSeparator.equals(";") ||
                File.pathSeparator.equals(":"), "Unrecognised OS path separator");

        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
    }

    //.....................................................................
    //EXERCIE : Create a Temporary File With Custom Code
    @Test
    public void verifyCreateFile() throws IOException {
        File myTempFile = new File("d:/helloFile.txt");
        assertEquals(myTempFile.exists(), false);

        myTempFile.createNewFile();

        PrintWriter printFile = new PrintWriter(new BufferedWriter(
                new FileWriter(myTempFile)));
        for (int lineNumber = 1; lineNumber < 6; lineNumber++) {
            long nanoTime = System.nanoTime();
            printFile.println("Line number - " + lineNumber + ", and time is - " + nanoTime);
        }
        printFile.close(); // always close Writers

        BufferedReader myReader = new BufferedReader(new FileReader(myTempFile));
        String fStr;
        while ((fStr = myReader.readLine()) != null) {
            System.out.println(fStr);
        }
        myReader.close(); // always close Readers

        if (myTempFile.exists()) {
            System.out.println(myTempFile.getPath());
        } else {
            fail();
        }
        assertEquals(myTempFile.exists(), true);

        myTempFile.delete();
        assertEquals(myTempFile.exists(), false);
    }
    //............................................................................

    @Test
    public void verifyDeleteonExit() throws IOException {
        File aTempFile = File.createTempFile("hello", "world");
        System.out.println(aTempFile.getAbsolutePath());
        System.out.println(aTempFile.getPath());
        System.out.println(aTempFile.getName());
        System.out.println(aTempFile.getCanonicalPath());
        System.out.println(aTempFile.getCanonicalFile());

        assertEquals(true, aTempFile.getName().startsWith("hello"));

        aTempFile.delete();
        assertEquals(false, aTempFile.exists());
    }

    //..............................................................................
    //EXERCISE : Write an @Test method To Check Canonical Conversion
    @Test
    public void verifyCacnonicalConversion() throws IOException {
        File trainintCanon = new File("..\\test.txt");
//        trainintCanon.createNewFile();

        String cannonical = trainintCanon.getCanonicalPath();

        System.out.println(cannonical);
        System.out.println(trainintCanon.getPath());
        System.out.println(trainintCanon.getAbsolutePath());

        trainintCanon.delete();
    }

    @Test
    public void all_about_path() {
        Path absolute1 = Paths.get("E:\\Java_practice\\src\\main\\" +
                "java\\com\\subway2\\doaineobjects\\test.txt");

        Path relativePath = Paths.get("./com.subway2/domaineobject/test.txt");

        assertEquals(Files.exists(absolute1), is(1));
        assertEquals(true, absolute1.isAbsolute());
        assertEquals(false, relativePath.isAbsolute());
    }

    //................................................................
    @Test
    public void verifyMkDir() {
        String tempDirectory = System.getProperty("java.io.tmpdir");
//        System.out.println(System.getProperty("java.io.tmpdir"));

        String newDirectoryStructure = tempDirectory + System.currentTimeMillis() + // first path
                File.separator + // file separator "/" by this sign we separate path in Windows
                System.currentTimeMillis(); // child of first path (second path)
        File aDirectory = new File(newDirectoryStructure);

        assertEquals(false, aDirectory.mkdir());
        assertEquals(true, aDirectory.mkdirs());

        assertEquals(true, System.getProperty(newDirectoryStructure).isEmpty());
    }
    // EXERCISE
    @Test
    public void verifyIsDirectory() throws IOException {
        File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
        File newFile = new File(tempDirectory + "\\test.txt");
        newFile.createNewFile();

        assertEquals(true, tempDirectory.isDirectory());
        assertEquals(false, tempDirectory.isFile());

        assertEquals(false, newFile.isDirectory());
        assertEquals(true, newFile.isFile());

        newFile.delete();

        assertEquals(false, newFile.exists());
    }//.....................................

    @Test
    public void fileWriter() throws IOException {
        File output = File.createTempFile("meTempfile", null);
        PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(output)));

        for (int line = 1; line < 11; line++){
            write.println("This is my skill number " + line);
        }
        write.close();

        assertEquals(true, output.isFile());

        FileWriter newWriter = new FileWriter(output, true);
        newWriter.append('S');
        newWriter.append('A');
        newWriter.append('S');
        newWriter.append('H');
        newWriter.append('A');

        newWriter.write("\n This string is written by WRITE method");

        PrintWriter advancedWriter = new PrintWriter(new BufferedWriter(newWriter));
        advancedWriter.println("\n       Hello motherfucker");

        advancedWriter.close();
        newWriter.close();

        System.out.println(output.getAbsolutePath());

        BufferedReader reader = new BufferedReader(new FileReader(output));
        String allText;
        while ((allText = reader.readLine()) != null){
            System.out.println(allText);
        }
        reader.close();

        Scanner scanner = new Scanner(output);
        int lineNum = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            lineNum++;
            String search = "motherfucker";
            if (line.contains(search)){
                System.out.println("ho hum, I found it ("+ search +") on line " + lineNum);
            } else {
                System.out.println("There is no matches");
            }
        }
        scanner.close();

        long fileTotalSpace = output.getTotalSpace();
        long fileFreeSpace = output.getFreeSpace();
        long fileUsedSpace = output.getUsableSpace();
        System.out.println(fileTotalSpace + "\n" + fileFreeSpace + "\n" + fileUsedSpace);
        System.out.println("not used space = "+ (fileTotalSpace - fileUsedSpace));

        String lineEnd = System.lineSeparator(); // the same as "\n" (new line)
        System.out.println("hello " + lineEnd + "       world");

        output.delete();
        assertEquals(false, output.exists());
    }

    //..............................................
    //EXERCISE: Use listFiles to show the Temp Directory contents
    @Test
    public void verifylistFiles(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        String[] fileList = tempDir.list();
        String path = tempDir.getPath();

        for (String i : fileList){
            File verify = new File(path + "\\" + i);
            if (verify.isFile()){
                System.out.println("File - " + verify);
            } else {
                System.out.println("DIR - " + verify);
            }
//            System.out.println(i);
        }
    }

    // EXERCISE: Output Attributes of Files In Temp Directory
    @Test
    public void verifyOutputAttributes() {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File[] fileList = tempDir.listFiles();

        long time = 100000000;

        for (File i : fileList){
            String output = "";
            if (i.isFile()){
                output = output + " --- isFile";
            } else {
                output  = output + " --- isDirectory";
            }

            if (i.canRead()){
                output = output + "   -------- canRead";
            } else {
                output = output + " ------ can NOT Read";
            }

            if (i.canWrite()){
                output = output + " ------- canWrite";
            } else {
                output = output + " ------ can Not Write";
            }

            if (i.canExecute()){
                output = output + " -------- canExecute ";
            } else {
                output = output + " -------- can NOT Execute ";
            }

            SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");

            output = output + i.getName();

            String date = sdf.format(new Date(i.lastModified()));

            output = output + " ---> " + date;

            System.out.println(output);
        }
        System.out.println(tempDir.getPath());
    }
    //..........................................
    @Test
    public void verifyFilesCopy() throws IOException {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));

        String myDisc = "D:\\";
        String pathName = "java_Practice_test_data";
//
        File myPath = new File(myDisc + pathName);
//        myPath.mkdir();
//
        File myFile = new File(myPath.getAbsolutePath() + "\\myFile.txt");
        myFile.createNewFile();

        PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(myFile)));
        write.println("Hello my Lord");
        write.close();

        File myPath2 = new File("D:\\java_verify_test");
        System.out.println(myFile.getName());

        File myReplacedFile = new File(myPath2.getAbsolutePath() + "\\myCopyFile.txt");

        System.out.println(myFile.getPath());

        Files.copy(myFile.toPath(), myReplacedFile.toPath(),
                REPLACE_EXISTING);
        System.out.println(myFile.getPath());


    }
}
