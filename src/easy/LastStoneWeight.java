package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

  public static int lastStoneWeight(int[] stones) {
    Comparator<Integer> comparator = (o1, o2) -> {
      if (o1 > o2) return 1;
      return 0;
    };
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int stone : stones) {
      queue.offer(stone);
    }
    while (queue.size() > 1) {
      int last = queue.poll();
      int last2 = queue.poll();
      if (last > last2) {
        queue.offer(last - last2);
      }
    }

    if (queue.size() == 1)
      return queue.poll();
    else
      return 0;
  }

  public static  void main(String[] args) {
    int[] stones = {2,7,4,1,8,1};

    System.out.println(lastStoneWeight(stones));


  }



}
