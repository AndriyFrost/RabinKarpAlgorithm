package ua.lviv.iot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class ReaderAndWriter {
    public static void writeToFile(List<String> patternFound) {
        try (FileWriter fileWriter = new FileWriter(new File("src/main/java/ua/lviv/iot/test/test.out"))) {
            for (String founded : patternFound) {
                fileWriter.write("" + founded);
                fileWriter.write("\n");
            }
            fileWriter.flush();
        } catch (Exception ignored) {
        }
    }

    public static String readFromFile(String pathToFile) {
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
           return scanner.nextLine();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return " ";
    }
}
