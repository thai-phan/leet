package dpattern.creational.c7objectpool;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PlayBallGame {

  @Getter
  @AllArgsConstructor
  public static class Ball {
    private int number;
  }

  public static class BallPool {
    private final Queue<Ball> balls = new LinkedList<>(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));

    public synchronized Ball provideBall() {
      return balls.isEmpty() ? null : balls.poll();
    }

    public synchronized void offerBall(Ball ball) {
      balls.offer(ball);
    }
  }

  @Getter
  @AllArgsConstructor
  public static class Player {
    private final String name;

    public void play(Ball ball) {
      if (ball == null) {
        System.out.println(name + " has no ball to play");
      } else {
        System.out.println(name + " play: " + "Ball (" + ball.getNumber() + ")");
      }
    }
  }

  public static void main(String[] args) {
    final Player[] players = new Player[10];
    for (int i = 0; i < players.length; ++i) {
      players[i] = new Player("Player-" + (i + 1));
    }

    final BallPool ballPool = new BallPool();
    for (Player player : players) {
      new Thread(() -> {
        final Ball ball = ballPool.provideBall();
        try {
          player.play(ball);
        } finally {
          ballPool.offerBall(ball);
        }
      }).start();
    }
  }

}
