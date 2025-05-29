package bMedium.hack;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class SurfaceArea3D {
    public static int surfaceArea(List<List<Integer>> A) {
        // Write your code here

        int area = 0;

        for (int i = 0; i < A.size(); i++) {
            List<Integer> aaa = A.get(i);
            int areaOfOneRow = A.get(i).get(0);
            for (int j = 0; j < A.get(i).size() - 1; j++) {
                if (A.get(i).get(j + 1) > A.get(i).get(j)) {
                    areaOfOneRow += A.get(i).get(j + 1) - A.get(i).get(j);
                }
            }
            area += areaOfOneRow * 2;
        }

        for (int i = 0; i < A.get(0).size(); i++) {
            int areaOfOneColumn = A.get(0).get(i);
            List<Integer> bbb = new ArrayList<>();
            for (int j = 0; j < A.size() - 1; j++) {
                bbb.add(A.get(j).get(i));
                if (A.get(j + 1).get(i) > A.get(j).get(i)) {
                    areaOfOneColumn += A.get(j + 1).get(i) - A.get(j).get(i);
                }
            }
            area += areaOfOneColumn * 2;
        }

        area += A.size() * A.get(0).size() * 2;

        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/SurfaceArea3D/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("input/SurfaceArea3D/output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
