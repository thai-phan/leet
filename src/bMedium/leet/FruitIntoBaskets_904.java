package bMedium.leet;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

//904. Fruit Into Baskets
public class FruitIntoBaskets_904 {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < fruits.length; ++j) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            while (count.size() > 2) {
                count.put(fruits[i], count.get(fruits[i]) - 1);
                if (count.get(fruits[i]) == 0) count.remove(fruits[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

  public static int _totalFruit(int[] fruits) {
    int maxFruit = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    Queue<Integer> queue = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int fruit : fruits) {
      if (queue.size() < 2 && !queue.contains(fruit)) {
        queue.add(fruit);
        map.put(fruit, 1);
      } else {
        if (!queue.contains(fruit)) {
          queue.add(fruit);
          int temp = queue.remove();
          map.remove(temp);
          map.put(fruit, 1);
        } else {
          map.replace(fruit, map.get(fruit) + 1);
        }
      }
      atomicInteger.set(0);
      queue.forEach(num -> atomicInteger.set(atomicInteger.get() + map.get(num)));
      if (atomicInteger.get() > maxFruit) {
        maxFruit = atomicInteger.get();
      }
    }

    return maxFruit;
  }

  public static int __totalFruit(int[] fruits) {
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    int res = 0, i = 0;
    for (int j = 0; j < fruits.length; ++j) {
      count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
      while (count.size() > 2) {
        count.put(fruits[i], count.get(fruits[i]) - 1);
        if (count.get(fruits[i]) == 0) count.remove(fruits[i]);
        i++;
      }
      res = Math.max(res, j - i + 1);
    }
    return res;
  }
}
