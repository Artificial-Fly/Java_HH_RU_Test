package org.first;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long k = scanner.nextLong();

        System.out.println(getCharacterAtPosition(s, k));
        scanner.close();
    }

    public static char getCharacterAtPosition(String s, long k) {
        String[] words = s.split(" ");

        long currentPos = 0;

        for (int i = 0; i < words.length; i++) {
            long expandedLen = (long) words[i].length() * (words[i].length() + 1) / 2;

            if (k < currentPos + expandedLen) {
                long posInExpanded = k - currentPos;

                int idx = 0;
                long sum = 0;
                while (sum + (idx + 1) <= posInExpanded) {
                    sum += (idx + 1);
                    idx++;
                }
                return words[i].charAt(idx);
            }

            currentPos += expandedLen;

            if (i < words.length - 1) {
                if (k == currentPos) {
                    return ' ';
                }
                currentPos++;
            }
        }

        return ' ';
    }
}