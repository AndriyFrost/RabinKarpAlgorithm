package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoTest {

    private static int PRIME_NUMBER = 101;
    private Scanner scanner;

    @BeforeEach
    public void initializeScanner() {
        try {
            scanner = new Scanner(new File("src/main/java/ua/lviv/iot/test/test.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    void test1() {
        testResult("src/main/java/ua/lviv/iot/test/test1.in",
                "hello","Pattern found at index 3","Pattern end at index 7");
    }

    @Test
    void test2() {
        testResult("src/main/java/ua/lviv/iot/test/test2.in",
                "for",
                "Pattern found at index 14",
                "Pattern end at index 16");
    }

    @Test
    void test3() {
        testResult("src/main/java/ua/lviv/iot/test/test3.in",
                "think",
                "Pattern found at index 16",
                "Pattern end at index 20");
    }
    @Test
    void test4() {
        testResult("src/main/java/ua/lviv/iot/test/test4.in",
                "tale",
                "Pattern found at index 14",
                "Pattern end at index 17");
    }

    private void testResult(String pathToFile,String pattern ,String findPattern,String endPattern) {
        String lineFromFile = ReaderAndWriter.readFromFile(pathToFile);
        RabinKarpAlgorithm.search(pattern,lineFromFile, PRIME_NUMBER);
        assertEquals(findPattern, scanner.nextLine());
        assertEquals(endPattern, scanner.nextLine());
    }
}


