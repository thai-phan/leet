package theory.dpattern.behavioral.b1chainofresponsibility;

import java.util.Arrays;
import java.util.List;

public class Logger {
  private final List<LogAppender> appenderList;

  public Logger(LogAppender... appenderList) {
    this.appenderList = Arrays.asList(appenderList);
  }

  public void log(LogLevel level, String message) {
    appenderList.forEach(
        logAppender -> logAppender.append(level, message)
    );
  }

  public void error(String message) {
    log(LogLevel.LEVEL_ERROR, message);
  }

  public void info(String message) {
    log(LogLevel.LEVEL_INFO, message);
  }

  public static void main(String[] args) {
    final Logger logger = new Logger(new LogConsoleAppender(LogLevel.LEVEL_INFO),
        new LogFileAppender(LogLevel.LEVEL_ERROR));

    logger.info("Hello World");
    logger.error("Errrorrrrrr");
  }
}
