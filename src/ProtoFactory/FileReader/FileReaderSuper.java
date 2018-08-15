package ProtoFactory.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderSuper {
    protected String[] read(String filename) throws IOException {
        File file = new File(filename);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
        } catch (Exception e) {
            return new String[0];
        }

        try {
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            return new String[0];
        }

        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return (String[]) lines.toArray(new String[lines.size()]);
    }
}
