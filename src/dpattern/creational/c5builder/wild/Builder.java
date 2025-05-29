package dpattern.creational.c5builder.wild;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Builder {
    @Getter
    @Setter
    public static class Document {
        private String title;
        private String author;
        private String category;
        private String content;
        private LocalDateTime releaseAt;

        // Init function
        public Document(String title, String author, String category, String content, LocalDateTime releaseAt) {
            this.title = title;
            this.author = author;
            this.category = category;
            this.content = content;
            this.releaseAt = releaseAt;
        }
    }

    public static class DocumentFactory {
        public  Document newDocument(
                String title, String author,
                String category,
                String content,
                LocalDateTime releaseAt
        ) {
            return new Document(title, author, category, category, releaseAt);
        }
    }
}

