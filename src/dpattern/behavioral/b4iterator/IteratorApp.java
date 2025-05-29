package dpattern.behavioral.b4iterator;

import lombok.AllArgsConstructor;

public class IteratorApp {
  public interface MyIterator<E> {
    E next();

    boolean hasNext();
  }

  public static class ConcreteMyIterator<E> implements MyIterator<E> {
    private int currentIndex;
    private final E[] elements;

    public ConcreteMyIterator(E[] elements) {
      this.elements = elements;
    }

    @Override
    public E next() {
      return elements[currentIndex++];
    }

    @Override
    public boolean hasNext() {
      return currentIndex < elements.length;
    }
  }

  public interface Aggregate<E> {
    MyIterator<E> createIterator();
  }

  @AllArgsConstructor
  public static class ConcreateAggregate<E> implements Aggregate<E> {
    private final E[] elements;

    @Override
    public MyIterator<E> createIterator() {
      return new ConcreteMyIterator<>(elements);
    }
  }

  public static void main(String[] args) {
    final Aggregate<Integer> aggregate = new ConcreateAggregate<>(new Integer[]{1, 2, 3});
    final MyIterator<Integer> myIterator = aggregate.createIterator();
    while (myIterator.hasNext()) {
      System.out.println(myIterator.next());
    }
  }
}
