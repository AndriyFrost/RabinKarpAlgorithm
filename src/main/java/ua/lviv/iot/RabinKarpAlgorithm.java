package ua.lviv.iot;

import java.util.LinkedList;
import java.util.List;

public final class RabinKarpAlgorithm {

    public final static int CHARACTERS_IN_ALPHABET = 256;

    public static void search(String pattern, String text, int primeNumber) {
        List<String> foundedPattern = new LinkedList<>();
        int lengthOfPattern = pattern.length();
        int lengthOfText = text.length();
        int i, j;
        int hashValueForPattern = 0;
        int hashValueForText = 0;
        int h = 1;

        for (i = 0; i < lengthOfPattern - 1; i++) {
            h = (h * CHARACTERS_IN_ALPHABET) % primeNumber;
        }

        for (i = 0; i < lengthOfPattern; i++) {
            hashValueForPattern = (CHARACTERS_IN_ALPHABET * hashValueForPattern + pattern.charAt(i)) % primeNumber;
            hashValueForText = (CHARACTERS_IN_ALPHABET * hashValueForText + text.charAt(i)) % primeNumber;
        }

        for (i = 0; i <= lengthOfText - lengthOfPattern; i++) {
            if (hashValueForPattern == hashValueForText) {

                for (j = 0; j < lengthOfPattern; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == lengthOfPattern) {
                    foundedPattern.add("Pattern found at index " + i);
                    foundedPattern.add("Pattern end at index " + (i + pattern.length() - 1));
                }
            }
            if (i < lengthOfText - lengthOfPattern) {
                hashValueForText = (CHARACTERS_IN_ALPHABET * (hashValueForText - text.charAt(i) * h)
                        + text.charAt(i + lengthOfPattern)) % primeNumber;
                if (hashValueForText < 0) {
                    hashValueForText = (hashValueForText + primeNumber);
                }
            }
        }
        ReaderAndWriter.writeToFile(foundedPattern);
    }

    private RabinKarpAlgorithm() {

    }
}
