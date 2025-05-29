package theory.dpattern.behavioral.b2command;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Soldier {
  private final String name;
  private final Map<String, Command> commandMap;

  public Soldier(String name) {
    this.name = name;
    this.commandMap = new HashMap<>();
    this.commandMap.put("walk", this::walk);
    this.commandMap.put("run", this::run);
    this.commandMap.put("fly", this::fly);
  }

  public void walk() {

  }

  public void run() {

  }

  public void fly() {

  }

  public void execute(String command) {
    commandMap.get(command).execute();
  }
}
