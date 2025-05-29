package medium.hack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] charArray = w.toCharArray();

        List<Character> sortChar = new ArrayList<>();
        StringBuilder resultPart = new StringBuilder();
        for (int index = charArray.length - 1; index > 0; index--) {
            sortChar.add(charArray[index]);
            if (charArray[index] > charArray[index - 1]) {
                Character lowChar = charArray[index-1];
                sortChar.add(lowChar);
                sortChar.sort(Character::compare);
                Character replaceChar = sortChar.getFirst();
                for (Character a : sortChar) {
                    if (lowChar < a) {
                        replaceChar = a;
                        break;
                    }
                }

                for (int i = 0; i<index-1; i++) {
                    resultPart.append(charArray[i]);
                }
                resultPart.append(replaceChar);
                sortChar.remove(replaceChar);
                sortChar.sort(Character::compare);
                for (Character aaa : sortChar) {
                    resultPart.append(aaa);
                }
                return resultPart.toString();
            }
        }
        return "no answer";
    }

    public static void main(String[] args) throws IOException {
        var aaa = biggerIsGreater("dkhc");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
