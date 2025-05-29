package medium.hack;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;





//  def nonDivisibleSubset(k, s):
//    rem=[0]*k
//    for i in range(len(s)):
//        rem[s[i]%k]+=1
//    count=min(rem[0],1)
//    for j in range(1,(k//2)+1):
//        if j!=k-j:
//            count+=max(rem[j],rem[k-j])
//        else:
//            count+=min(rem[j],1)
//    return count

public class NonDivisibleSubset {
  public static int nonDivisibleSubset(int K, List<Integer> s) {

    int[] f = new int[K];
    Arrays.fill(f, 0);
    int N = s.size();
    Integer[] arr = s.toArray(new Integer[0]);
    // Fill frequency array with values modulo K
    for (int i = 0; i < N; i++)
      f[arr[i] % K]++;

    // if K is even, then update f[K/2]
    if (K % 2 == 0)
      f[K/2] = Math.min(f[K/2], 1);

    // Initialize result by minimum of 1 or
    // count of numbers giving remainder 0
    int res = Math.min(f[0], 1);

    // Choose maximum of count of numbers
    // giving remainder i or K-i
    for (int i = 1; i <= K/2; i++)
      res += Math.max(f[i], f[K-i]);

    return res;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("NonDivisibleSubset.txt"));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = nonDivisibleSubset(k, s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
