package dpattern.creational.c3factorymethod;


public abstract class ProductOrderCreator {
  public void orderProduct(String productName, long amount) {
    final Product product = newProduct(productName);
    storeOrder(product, amount);
  }

  protected abstract Product newProduct(String productName);

  private void storeOrder(Product product, long amount) {

  }
}