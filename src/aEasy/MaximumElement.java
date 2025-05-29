package aEasy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MaximumElement {

//  public static class Element {
//    public int data;
//    public int max;
//
//    public Element(int data, int max) {
//      this.data = data;
//      this.max = max;
//    }
//  }

  public static List<Integer> getMax(List<String> operations) {
    // Write your code here
    List<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    int max = -1;

    for (String op : operations) {
      char firstChar = op.charAt(0);
      if (firstChar == '1') {
        String[] temp = op.split(" ");
        int newNum = Integer.parseInt(temp[1]);

        max = Math.max(max, newNum);

        stack.push(newNum);
        maxStack.push(max);
      } else if (firstChar == '2') {

        stack.pop();
        maxStack.pop();

        if (maxStack.empty()) {
          max = -1;
        } else {
          max = maxStack.peek();
        }


      } else if (firstChar == '3') {
        if (!maxStack.isEmpty()) {
          result.add(maxStack.peek());
        }
      }
    }
    return result;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> ops = IntStream.range(0, n).mapToObj(i -> {
          try {
            return bufferedReader.readLine();
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .collect(toList());

    List<Integer> res = MaximumElement.getMax(ops);

    bufferedWriter.write(
        res.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
