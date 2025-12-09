package bMedium;

public class WordDictionary {
  public static void main(String[] args) {
    // ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
    //[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("at");
    wordDictionary.addWord("and");
    wordDictionary.addWord("an");
    wordDictionary.addWord("add");
    System.out.println(wordDictionary.search("a")); // false
    System.out.println(wordDictionary.search(".at")); // false
    wordDictionary.addWord("bat");
    System.out.println(wordDictionary.search(".at")); // true
    System.out.println(wordDictionary.search("an.")); // true
    System.out.println(wordDictionary.search("a.d.")); // false
    System.out.println(wordDictionary.search("b.")); // false
    System.out.println(wordDictionary.search("a.d")); // true
    System.out.println(wordDictionary.search(".")); // false
  }

  class Tree {
    char c;
    Tree[] lNext = new Tree[26];
    boolean isEnd;

    public Tree() {
    }

    public Tree(char c) {
      this.c = c;
    }
  }

  // Map<String, Boolean> map;
  Tree tree;

  public WordDictionary() {
    tree = new Tree();
    // map = new HashMap<>();
  }

  public void addWord(String word) {
    char[] cs = word.toCharArray();
    Tree tTree = tree;
    for (int i = 0; i < cs.length; i++) {
      if (tTree.lNext[cs[i] - 'a'] == null) {
        tTree.lNext[cs[i] - 'a'] = new Tree(cs[i]);
      }
      tTree = tTree.lNext[cs[i] - 'a'];
    }
    tTree.isEnd = true;
  }

  public boolean search(String word) {
    char[] cs = word.toCharArray();
    if (tree == null) {
      return false;
    }
    return recur(tree, cs, 0);
  }

  public boolean recur(Tree tree, char[] cs, int idx) {
    if (tree == null) {
      return false;
    }
    if (idx == cs.length) {
      return tree.isEnd;
    }

    int c = cs[idx];
    if (c != '.') {
      if (tree.lNext[c - 'a'] != null) {
        if (recur(tree.lNext[c - 'a'], cs, idx + 1)) {
          return true;
        }
      } else {
        return false;
      }
    } else {
      for (Tree t : tree.lNext) {
        if (recur(t, cs, idx + 1)) {
          return true;
        }
      }
    }
    return false;
  }

}
