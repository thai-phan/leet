package dpattern.behavioral.b1chainofresponsibility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class LogMain {
    public static void main(String[] args) throws Exception {
        LogLevel logLevel = LogLevel.LEVEL_ERROR;
        String message = "aaa";
        System.out.println(logLevel + ": " + message);
        if (logLevel.compareTo(LogLevel.LEVEL_INFO) > 0) {
            Files.write(Paths.get("application.log"), Collections.singleton(message), StandardOpenOption.APPEND);
        }
    }
}
