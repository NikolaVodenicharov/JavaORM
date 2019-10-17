package spring.intro.common;

import java.io.IOException;
import java.util.List;

public interface FileManager {
    List<String> readFile(String path) throws IOException;
}
