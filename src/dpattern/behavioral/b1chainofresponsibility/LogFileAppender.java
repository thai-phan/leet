package dpattern.behavioral.b1chainofresponsibility;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class LogFileAppender extends LogAppender {
  public LogFileAppender(LogLevel minLogLevel) {
    super(minLogLevel);
  }

  @Override
  protected void doAppend(String message) throws Exception {
    final Path path = Paths.get("application.log");
    if (!Files.exists(path)) {
      Files.createFile(path);
    }
    Files.write(path, Collections.singleton(message), StandardOpenOption.APPEND);
  }
}
