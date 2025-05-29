package dpattern.behavioral.b4iterator;

import lombok.AllArgsConstructor;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterator {

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object next() {
    return null;
  }

  @AllArgsConstructor
  private static class Node<E> {
    E data;
    Node<E> next;
  }

  private Node<E> firstNode;

  public void add(E element) {
    firstNode = new Node<>(element, firstNode);
  }

  public Iterator<E> iterator() {
    return new Iterator<E>() {

      Node<E> currentNode = firstNode;

      @Override
      public boolean hasNext() {
        return currentNode != null;
      }

      @Override
      public E next() {
        final E element = currentNode.data;
        currentNode = currentNode.next;
        return element;
      }
    };
  }

  public static void main(String[] args) {
    final MyLinkedList<Integer> list = new MyLinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
//        list.forEach(System.out::println);
  }
}
