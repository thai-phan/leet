package theory.dpattern.behavioral.b1chainofresponsibility;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class LogAppender {
  private final LogLevel minLogLevel;

  protected abstract void doAppend(String message) throws Exception;

  public void append(LogLevel level, String message) {
    if (level.compareTo(minLogLevel) > 0) {
      try {
        doAppend(message);
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
    }
  }
}


