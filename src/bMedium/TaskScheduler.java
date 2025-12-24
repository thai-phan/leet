package bMedium;

import java.util.*;

public class TaskScheduler {
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    String a = "AAA";
    String b = a.replaceAll("A" , "");

    char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
    int n = 2;
    int result = leastInterval(tasks, n);
    System.out.println("Least Interval: " + result);

  }

  static class Task {
    char a;
    int freq;

    Task(char a, int freq) {
      this.a = a;
      this.freq = freq;
    }

  }


  public static int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();
    for (char t : tasks) {
      map.put(t, map.getOrDefault(t, 0) + 1);
    }
    PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
    for (char k : map.keySet()) {
      pq.offer(new Task(k, map.get(k)));
    }


    int remain = tasks.length;
    int count = 0;

    while (pq.peek().freq > 0) {
      Queue<Task> q = new LinkedList<>();
      int tC = 0;
      for (int i = 0; i < n; i++) {
        if (!pq.isEmpty()) {
          Task t = pq.poll();
          t.freq--;
          q.add(t);
        }
        tC++;
      }
      count += tC;

      while (!q.isEmpty()) {
        Task t = q.poll();
        if (t.freq > 0) {
          pq.offer(t);
        }
      }
    }

    return count;
  }
}
