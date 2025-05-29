package dpattern.behavioral.b1chainofresponsibility;

public class LogConsoleAppender extends LogAppender {
  public LogConsoleAppender(LogLevel minLogLevel) {
    super(minLogLevel);
  }

  @Override
  protected void doAppend(String message) {
    System.out.println(message);
  }
}
