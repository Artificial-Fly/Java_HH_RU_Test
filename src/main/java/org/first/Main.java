/*Вам дана строка s, состоящая из одного или нескольких слов, разделённых одиночными пробелами. Каждое слово содержит только строчные английские буквы. Длина строки не превышает 100000 символов.

Мы получаем расширенную строку t из s следующим образом:

Для каждого слова в s:

— первую букву повторяем один раз,
— вторую букву — дважды,
— третью букву — трижды,
— и так далее.

Например, если s = "hello echo", то t = "heelllllllooooo ecchhhoooo".

Также дано целое число k, представляющее корректный индекс строки t.

Требуется вывести символ строки t с индексом k.


Входные данные (поступают в стандартный поток ввода)
В первой строке подаётся строка s, состоящая из слов, разделённых одиночными пробелами. Каждое слово состоит из строчных английских букв.

Во второй строке подаётся одно целое число k — индекс расширенной строки t.

Гарантируется, что индекс k корректный, то есть 0 ≤ k < |t|.*/
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