package dpattern.creational.c2factory;

public class FreeProduct extends Product {
  @Override
  public long order(long amount) {
    return 0;
  }
}