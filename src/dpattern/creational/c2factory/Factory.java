package dpattern.creational.c2factory;

public class Factory {


  public Product newProduct(String name, long price) {

    final Product product;
    if (price == 0) {
      product = new FreeProduct();
      product.name = name + "FREE";
    } else {
      product = new PricedProduct();
      product.price = price;
      product.name = name;
    }
    return product;
  }

  public static void main(String[] args) {
    final Factory factory = new Factory();
    final Product pricedProduct = factory.newProduct("Computer", 1000);
    final Product freeProduct = factory.newProduct("Book", 0);
  }
}
