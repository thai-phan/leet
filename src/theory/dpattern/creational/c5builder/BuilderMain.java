package theory.dpattern.creational.c5builder;


import java.time.LocalDateTime;

public class BuilderMain {

  public static void main(String[] args) {
    final BuilderDocument builderDocument = BuilderDocument.builder().title("Master Design Pattern").
      author("Dina Phan")
      .category("Tech")
      .addToContent("Builder")
      .addToContent("Responsss")
      .releaseAt(LocalDateTime.now())
      .build();
  }
}

