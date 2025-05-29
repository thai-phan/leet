package medium.hack;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XorSequence {
    static long xorSequenceAuthor(long l, long r) {
        return G(r) ^ G(l - 1);
    }

    static long G(long x) {
        long a = x % 8;
        if (a == 0 || a == 1) return x;
        if (a == 2 || a == 3) return 2;
        if (a == 4 || a == 5) return x + 2;
        if (a == 6 || a == 7) return 0;
        return 0;
    }


    // Complete the xorSequence function below.
    static long xorSequence(long l, long r) {

        long curValue = 0;
        long index = 0;
        long sum = 0;
        List<Long> aa = new ArrayList<>();
        while (index <= r) {
            curValue = curValue ^ index;
            aa.add(curValue);
            if (index == l) {
                sum = curValue;
            }
            if (index > l) {
                sum = sum ^ curValue;
            }
            index++;
        }

        return sum;
    }


    public static void main(String[] args) throws IOException {

        File file = new File("input/XorSequence/input.txt");

        Scanner scanner = new Scanner(file);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("input/XorSequence/output.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] lr = scanner.nextLine().split(" ");

            long l = Long.parseLong(lr[0]);

            long r = Long.parseLong(lr[1]);

            long result = xorSequence(l, r);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
