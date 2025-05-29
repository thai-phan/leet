package theory.dpattern.creational.c5builder;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class BuilderApp {
  @ToString
  @AllArgsConstructor
  public static class Product {
    private String property;
  }

  public abstract static class Builder {
    @Setter
    protected String property;

    public abstract void buildPart();

    public abstract Product getResult();
  }

  @Setter
  public static class ConcreteBuilder extends Builder {
    @Override
    public void buildPart() {

    }

    @Override
    public Product getResult() {
      return new Product(property);
    }
  }

  @AllArgsConstructor
  public static class Director {
    private final Builder builder;

    public void construct() {
      builder.setProperty("Builder Design Pattern");
      builder.buildPart();
    }

    public Product getResult() {
      return builder.getResult();
    }
  }

  public static void main(String[] args) {
    final Director director = new Director(new ConcreteBuilder());
    director.construct();
    final Product product = director.getResult();
    System.out.println(product);
  }
}
