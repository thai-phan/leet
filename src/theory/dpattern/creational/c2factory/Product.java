package theory.dpattern.creational.c2factory;

public abstract class Product {
  public String name;
  public long price;

  public abstract long order(long amount);
}
