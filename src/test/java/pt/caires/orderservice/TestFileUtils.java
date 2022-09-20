package pt.caires.orderservice;

import java.io.File;
import java.nio.file.Files;
import java.util.Objects;

public class TestFileUtils {

  public static String getBody(String filePath) throws Exception {
    return TestFileUtils.getBodyFrom(filePath,
        Thread.currentThread()
            .getContextClassLoader());
  }

  private static String getBodyFrom(String filePath, ClassLoader classLoader) throws Exception {
    return new String(getContentFrom(filePath, classLoader));
  }

  private static byte[] getContentFrom(String filePath, ClassLoader classLoader) throws Exception {
    File file = new File(Objects.requireNonNull(classLoader.getResource(filePath)).getFile());
    return Files.readAllBytes(file.toPath());
  }

}
