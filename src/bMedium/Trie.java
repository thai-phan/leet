package bMedium;

public class Trie {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("app");
    boolean param_2 = trie.search("app");
    boolean param_3 = trie.startsWith("appeee");
//    trie.insert("app");
    boolean param_4 = trie.search("app");
    System.out.println("param_2 = " + param_2);
    System.out.println("param_3 = " + param_3);
    System.out.println("param_4 = " + param_4);
  }

  static class Tree {
    char c;
    Tree[] sub;

    public Tree() {
      this.sub = new Tree[27];
    }

    public Tree(char c) {
      this.c = c;
      this.sub = new Tree[27];
    }
  }

  Tree treeO;

  public Trie() {
    treeO = new Tree();
  }

  public void insert(String word) {
    char[] cs = word.toCharArray();
    int idx = 0;
    Tree tree = treeO;
    while (idx < cs.length) {
      if (tree.sub[cs[idx] - 'a'] != null) {
        tree = tree.sub[cs[idx] - 'a'];
        idx++;
        continue;
      }
      Tree t = new Tree(cs[idx]);
      tree.sub[cs[idx] - 'a'] = t;
      tree = t;
      idx++;
    }
    tree.sub[26] = new Tree('!');
  }

  public boolean search(String word) {
    char[] cs = word.toCharArray();
    Tree tree = treeO;
    int idx = 0;

    while (idx < cs.length) {
      if (tree.sub[cs[idx] - 'a'] == null) {
        return false;
      }
      tree = tree.sub[cs[idx] - 'a'];
      idx++;
    }
    return tree.sub[26] != null;
  }

  public boolean startsWith(String prefix) {
    char[] cs = prefix.toCharArray();
    Tree tree = treeO;
    int idx = 0;

    while (idx < cs.length) {
      if (tree.sub[cs[idx] - 'a'] == null) {
        return false;
      }
      tree = tree.sub[cs[idx] - 'a'];
      idx++;
    }
    return true;
  }
}

