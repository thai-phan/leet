package theory.dpattern.creational.c3factorymethod;


public class ProductOrderCreatorImpl extends ProductOrderCreator {
  private static final long DEFAULT_PRICE = 1000;

  @Override
  protected Product newProduct(String productName) {
    final Product product;
    if (productName.endsWith("FREE!")) {
      product = new FreeProduct();
    } else {
      final PricedProduct pricedProduct = new PricedProduct();
      pricedProduct.price = DEFAULT_PRICE;
      product = pricedProduct;
    }
    product.name = productName;
    return product;
  }
}