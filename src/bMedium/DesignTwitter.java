package bMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignTwitter {
  public static void main(String[] args) {
    DesignTwitter twitter = new DesignTwitter();

    twitter.postTweet(1, 5);
    List<Integer> feed1 = twitter.getNewsFeed(1);
    System.out.println("News Feed for User 1: " + feed1);

    twitter.follow(1, 2);
    twitter.postTweet(2, 6);
    List<Integer> feed2 = twitter.getNewsFeed(1);
    System.out.println("News Feed for User 1 after following User 2: " + feed2);

    twitter.unfollow(1, 2);
    List<Integer> feed3 = twitter.getNewsFeed(1);
    System.out.println("News Feed for User 1 after unfollowing User 2: " + feed3);
  }

  static class ListNode {
    int tweetId;
    int userId;
    ListNode next;

    ListNode(int t, int u) {
      this.tweetId = t;
      this.userId = u;
      next = null;
    }
  }

  Map<Integer, int[]> map;
  ListNode head;

  private void addFirst(ListNode n) {
    if (head == null) head = n;
    else {
      n.next = head;
      head = n;
    }
  }

  public DesignTwitter() {
    map = new HashMap<>();
    head = null;
  }

  private void addUser(int userId) {
    map.put(userId, new int[500]);
    int[] list = map.get(userId);
    list[userId] = 1;
  }

  public void postTweet(int userId, int tweetId) {
    if (!map.containsKey(userId)) addUser(userId);
    addFirst(new ListNode(tweetId, userId));
  }

  public List<Integer> getNewsFeed(int user) {
    List<Integer> out = new ArrayList<>();
    int[] list = map.get(user);
    if (list == null) return out;
    ListNode temp = head;
    while (temp != null && out.size() < 10) {
      int userId = temp.userId;
      if (list[userId] == 1) out.add(temp.tweetId);
      temp = temp.next;
    }
    return out;
  }

  public void follow(int followerId, int followeeId) {
    if (followerId == followeeId) return;
    if (!map.containsKey(followerId)) map.put(followerId, new int[500]);
    int[] list = map.get(followerId);
    list[followeeId] = 1;
    list[followerId] = 1;
  }

  public void unfollow(int followerId, int followeeId) {
    if (followerId == followeeId) return;
    if (!map.containsKey(followerId)) return;
    int[] list = map.get(followerId);
    list[followeeId] = 0;
  }
}
