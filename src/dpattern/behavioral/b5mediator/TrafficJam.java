package dpattern.behavioral.b5mediator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class TrafficJam {
  @Getter
  public static class Lane {
    private int vehicleCount;
    private final int number;

    public Lane(int number) {
      this.number = number;
    }

    public synchronized void increaseVehicleCount() {
      ++vehicleCount;
    }

    public synchronized void decreaseVehicleCount() {
      --vehicleCount;
    }

    public synchronized int getVehicleCount() {
      return vehicleCount;
    }
  }

  @AllArgsConstructor
  public static class Vehicle {
    private final int number;

    public void move(Lane lane) {
      System.out.println("Vehicle [" + number + "]: move on lane: " + lane.getNumber());
      lane.increaseVehicleCount();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    final Lane[] lanes = new Lane[2];
    for (int i = 0; i < lanes.length ; i++) {
      lanes[i] = new Lane(i + 1);
    }

    final AtomicInteger vehicleCount = new AtomicInteger();

    final Thread[] threads = new Thread[5];

    for (int i = 0; i < threads.length; ++i) {
      threads[i] = new Thread(() -> {
        final Vehicle vehicle = new Vehicle(vehicleCount.incrementAndGet());
        final int laneNumber = ThreadLocalRandom.current().nextInt(lanes.length);
        final Lane lane = lanes[laneNumber];
        vehicle.move(lanes[laneNumber]);
//        TODO:
        if (true) {
          System.out.println("Traffic jams");
        }
        lane.decreaseVehicleCount();
      });

      threads[i].start();
    }
  }
}
