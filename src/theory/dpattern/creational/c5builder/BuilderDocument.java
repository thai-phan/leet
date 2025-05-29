package theory.dpattern.creational.c5builder;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BuilderDocument implements Cloneable {
  private String title;
  private String author;
  private String category;
  private String content;
  private LocalDateTime releaseAt;

  protected BuilderDocument(Builder builder) {
    this.title = builder.title;
    this.author = builder.author;
    this.category = builder.category;
    this.content = builder.contentBuilder.toString();
    this.releaseAt = builder.releaseAt;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String title;
    private String author;
    private String category;
    private LocalDateTime releaseAt;
    private final StringBuilder contentBuilder = new StringBuilder();

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder author(String author) {
      this.author = author;
      return this;
    }

    public Builder category(String category) {
      this.category = category;
      return this;
    }

    public Builder addToContent(String contentPart) {
      if (!contentBuilder.isEmpty()) {
        contentBuilder.append(' ');
      }
      contentBuilder.append(contentPart);
      return this;
    }

    public Builder releaseAt(LocalDateTime releaseAt) {
      this.releaseAt = releaseAt;
      return this;
    }

    public BuilderDocument build() {
      return new BuilderDocument(this);
    }
  }

  public BuilderDocument clone() {
    return builder()
        .title(title)
        .author(author)
        .category(category)
        .addToContent(content)
        .releaseAt(releaseAt)
        .build();
  }
}
