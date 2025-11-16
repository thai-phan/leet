package bMedium;

import java.util.*;

public class CloneGraph {
  public static void main(String[] args) {
    // Test case can be added here

    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    node1.neighbors.add(node2);
    node1.neighbors.add(node4);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node3.neighbors.add(node2);
    node3.neighbors.add(node4);
    node4.neighbors.add(node1);
    node4.neighbors.add(node3);
    Node clonedGraph = cloneGraph(node1);
    System.out.println("Cloned graph node value: " + clonedGraph.val);
  }

  static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }


  public static Node cloneGraph(Node node) {
    Map<Node, Node> map = new HashMap<>();

    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      Node originNode = queue.poll();
      map.put(originNode, new Node(originNode.val));
      for (Node nNode : originNode.neighbors) {
        if (!map.containsKey(nNode)) {
          queue.offer(nNode);
        }
      }
    }

    for (Node originNode : map.keySet()) {
      Node clonedNode = map.get(originNode);
      for (Node nNode : originNode.neighbors) {
        clonedNode.neighbors.add(map.get(nNode));
      }
    }

    return map.get(node);

  }
}
