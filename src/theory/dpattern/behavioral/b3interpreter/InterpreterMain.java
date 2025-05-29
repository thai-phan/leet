package theory.dpattern.behavioral.b3interpreter;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterpreterMain {
  @Data
  public static class Context {
    private String input;
    private String output;

    public Context(String input) {
      this.input = input;
      this.output = input;
    }
  }

  public interface AbstractExpression {
    void interpret(Context context);
  }

  public static class TerminalExpression implements AbstractExpression {
    @Override
    public void interpret(Context context) {
      if ("Hello World".equals(context.getInput())) {
        context.setOutput("Xin chao the gioi!");
      }
    }
  }

  public static class NonTerminalExpression implements AbstractExpression {
    private final List<AbstractExpression> children;

    public NonTerminalExpression() {
      children = Arrays.asList(new HolaExpression(), new MundoExpression());
    }

    @Override
    public void interpret(Context context) {
      final List<String> outputWords = new ArrayList<>();
      final String[] words = context.getInput().split(" ");
      for (String word : words) {
        outputWords.add(interpretWord(word));
      }
      context.setOutput(String.join(" ", outputWords));
    }

    private String interpretWord(String word) {
      String wordOutput = word;
      for (AbstractExpression expression : children) {
        final Context wordContext = new Context(wordOutput);
        expression.interpret(wordContext);
        wordOutput = wordContext.getOutput();
      }

      return wordOutput;

    }
  }

  public static class HolaExpression implements AbstractExpression {
    @Override
    public void interpret(Context context) {
      if ("Hola".equals(context.getInput())) {
        context.setOutput("Hello");
      }
    }
  }

  public static class MundoExpression implements AbstractExpression {
    @Override
    public void interpret(Context context) {
      if ("Mundo".equals(context.getInput())) {
        context.setOutput("World");
      }
    }
  }

  public static void main(String[] args) {
    final AbstractExpression nonTerminalExpression = new NonTerminalExpression();
    final AbstractExpression terminalExpression = new TerminalExpression();

    final Context context = new Context("Hola Mundo");
    nonTerminalExpression.interpret(context);
    terminalExpression.interpret(context);

    System.out.println(context.getInput() + " => " + context.getOutput());
  }
}
