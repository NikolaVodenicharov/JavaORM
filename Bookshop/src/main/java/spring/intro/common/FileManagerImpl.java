package spring.intro.common;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileManagerImpl implements FileManager {
    @Override
    public List<String> readFile(String path) throws IOException {
        var file = new File(path);
        var fileReader = new FileReader(file);
        var reader = new BufferedReader(fileReader);

        var data = new ArrayList<String>();

        while(true){
            var line = reader.readLine();

            if (line == null){
                break;
            }

            if (line.isEmpty()){
                continue;
            }

            data.add(line);
        }

        return data;
    }
}
