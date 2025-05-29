package theory.dpattern.behavioral.b3interpreter;


import java.util.HashMap;
import java.util.Map;

public class TranslatorMain {
  public interface Translator {
    String translate(String input);
  }

  public static class EnToViTranslator implements Translator {
    private final Map<String, String> dictionary = loadDictionary();

    @Override
    public String translate(String input) {
      return dictionary.getOrDefault(input, input);
    }

    private Map<String, String> loadDictionary() {
      final Map<String, String> example = new HashMap<>();
      example.put("Hello", "Xin chao");
      example.put("World", "The gioi");
      return example;
    }
  }


}

