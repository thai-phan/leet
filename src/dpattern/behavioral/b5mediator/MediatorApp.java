package dpattern.behavioral.b5mediator;

import java.util.Arrays;
import java.util.List;

public class MediatorApp {
  public  interface Colleague {
    void setState(int state);
  }

  public static class ConcreteColleague1 implements Colleague {
    @Override
    public void setState(int state) {
      System.out.println("ConcreteColleage1 state: " + state);
    }
  }

  public static class ConcreateColleage2 implements Colleague {
    @Override
    public void setState(int state) {
      System.out.println("ConcreateColleage2 state: " + state);
    }
  }

  public interface Mediator {
    void setState(int state);
  }

  public static class ConcreteMediator implements Mediator {
    private final List<Colleague> colleagueList;

    public ConcreteMediator (Colleague... colleagues) {
      this.colleagueList = Arrays.asList(colleagues);
    }

    @Override
    public void setState(int state) {
      colleagueList.forEach(colleague -> {
        colleague.setState(state);
      });
    }
  }

  public static void main(String[] args ) {
    final Mediator mediator = new ConcreteMediator(new ConcreteColleague1(), new ConcreateColleage2());
    mediator.setState(123);
  }
}
