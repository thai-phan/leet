package theory.dpattern.creational.c3factorymethod.wild;


import theory.dpattern.creational.c3factorymethod.FreeProduct;
import theory.dpattern.creational.c3factorymethod.PricedProduct;
import theory.dpattern.creational.c3factorymethod.Product;

public class Wild {
  public static void main(String[] args) {
    final Product product;
    String name = "Some name FREE";
    long amount = 2;
    long price = 1000;
    if (name.endsWith("FREE")) {
      product = new FreeProduct();
      product.name = name;
    } else {
      final PricedProduct pricedProduct = new PricedProduct();
      pricedProduct.name = name;
      pricedProduct.price = price;
      product = pricedProduct;
    }

    final ProductOrderCreator creator = new ProductOrderCreator();
    creator.orderProduct(product, amount);

  }
}