package dstructure.btree;

public class Btree {
  class Node {
    int MAX_KEYS = 3;
    int MAX_CHILDREN = MAX_KEYS + 1;

    int n;
    int[] key = new int[MAX_KEYS];
    Node[] child = new Node[MAX_CHILDREN];
    boolean leaf;
  }

  Node BtreeSearch(Node x, int k) {
    int i = 0;
    while (i < x.n && k > x.key[i]) {
      i++;
    }
    if (i < x.n && k == x.key[i]) {
      return x;
    }
    if (x.leaf) {
      return null;
    }
    return BtreeSearch(x.child[i], k);
  }
}


