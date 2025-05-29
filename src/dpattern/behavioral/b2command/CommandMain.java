package dpattern.behavioral.b2command;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class CommandMain {
  public static class Receiver {

    public void action1() {
      System.out.println("do action 1");
    }

    public void action2() {
      System.out.println("do action 2");
    }
  }

  public interface Command {
    void execute();
  }

  @AllArgsConstructor
  public static class ConcreteCommand1 implements Command {
    private final Receiver receiver;

    @Override
    public void execute() {
      receiver.action1();
    }
  }

  @AllArgsConstructor
  public static class ConcreteCommand2 implements Command {
    private final Receiver receiver;

    @Override
    public void execute() {
      receiver.action2();
    }
  }

  public static class Invoker {
    private final Map<String, Command> commands;

    public Invoker(Receiver receiver) {
      commands = new HashMap<>();
      commands.put("command1", new ConcreteCommand1(receiver));
      commands.put("command2", new ConcreteCommand2(receiver));
    }

    public void invoke(String command) {
      commands.get(command).execute();
    }
  }

  public static void main(String[] args) {
    final Receiver receiver = new Receiver();
    final Invoker invoker = new Invoker(receiver);
    invoker.invoke("command1");
    invoker.invoke("command2");
  }
}
