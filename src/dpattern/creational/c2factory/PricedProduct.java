package dpattern.creational.c2factory;

public class PricedProduct extends Product {
  @Override
  public long order(long amount) {
    return price * amount;
  }
}