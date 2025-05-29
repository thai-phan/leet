package theory.dpattern.creational.c6prototype;

import theory.dpattern.creational.c5builder.BuilderDocument;

public class PrototypeMain {

  public static void main(String[] args) {
    BuilderDocument builderDocument = BuilderDocument.builder()
      .title("title")
      .category("category")
      .build();
    BuilderDocument copy = builderDocument.clone();
  }
}
