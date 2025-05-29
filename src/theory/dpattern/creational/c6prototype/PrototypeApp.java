package theory.dpattern.creational.c6prototype;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PrototypeApp {

  @Data
  public abstract static class Prototype implements Cloneable {
    protected String property;

    @Override
    public abstract Prototype clone();
  }

  @Setter
  @Getter
  @ToString
  public static class ConcretePrototype1 extends Prototype {
    private String property1;

    @Override
    public Prototype clone() {
      final ConcretePrototype1 prototype = new ConcretePrototype1();
      prototype.property = property;
      prototype.property1 = property1;
      return prototype;
    }
  }

  @Getter
  @Setter
  @ToString
  public static class ConcretePrototype2 extends Prototype {
    private String property2;

    @Override
    public Prototype clone() {
      final ConcretePrototype2 prototype = new ConcretePrototype2();
      prototype.property = property;
      prototype.property2 = property2;
      return prototype;
    }
  }

  public static void main(String[] args) {
//        final ConcretePrototype1 prototype1 = new ConcretePrototype1();
//        prototype1.setProperty("Hello");
//        prototype1.setProperty1("Tada");
//        final Prototype copy = prototype1.clone();
//        System.out.println(copy);
  }
}
