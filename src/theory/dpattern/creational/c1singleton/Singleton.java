package theory.dpattern.creational.c1singleton;

public class Singleton {
  public static final class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
      return INSTANCE;
    }
  }


  public static final class LazyInitSingleton {
    private static LazyInitSingleton instance;

    private LazyInitSingleton() {
    }

    public static LazyInitSingleton getInstance() {
      if (instance == null) {
        synchronized (LazyInitSingleton.class) {
          if (instance == null) {
            instance = new LazyInitSingleton();
          }
        }
      }
      return instance;
    }
  }

  public static final class LazyInitSingletonSlowly {
    private static LazyInitSingletonSlowly instance;

    private LazyInitSingletonSlowly() {
      try {
        System.out.println("Initializing by thread: " + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("Initialized: " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public static LazyInitSingletonSlowly getInstance() {
      if (instance == null) {
        instance = new LazyInitSingletonSlowly();
      }
      return instance;
    }

    public static void main(String[] args) {
      final Thread[] threads = new Thread[5];
      for (int i = 0; i < threads.length; ++i) {
        threads[i] = new Thread(LazyInitSingletonSlowly::getInstance);
      }
      for (Thread thread : threads) {
        thread.start();
      }
    }
  }
}
