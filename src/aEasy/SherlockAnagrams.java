package aEasy;


import java.io.*;
import java.util.stream.IntStream;


public class SherlockAnagrams {
    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        int result = 0;
        int group = 1;
        while (group < s.length()) {


            for (int i = 0; i < s.length() - group; i++) {
                String subI = s.substring(i, i + group);
                for (int j = i + 1; j < s.length() - group + 1; j++) {
                    String subJ = s.substring(j, j + group);
                    if (checkAnagram(subI, subJ)) {
                        result++;
                    }
                }
            }

            group++;

        }

        return result;
    }

    public static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] char1 = s1.toLowerCase().toCharArray();
        char[] char2 = s2.toLowerCase().toCharArray();

        int[] char1Check = new int[26];
        int[] char2Check = new int[26];

        for (int i = 0; i < char1.length; i++) {
            char1Check[char1[i] % 26]++;
            char2Check[char2[i] % 26]--;
        }

        for (int i = 0; i < char1Check.length; i++) {
            if (char1Check[i] + char2Check[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        int aaaa = sherlockAndAnagrams("abba");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
