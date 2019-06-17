package com.company;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileReader extends CheckThatInput implements StringTransformer {

    private String[] inputFiles;

    public FileReader(){}

    @Override
    public String[] transform(String[] inputFiles) throws IOException {

        this.inputFiles = inputFiles;
        checkInput();

        String[] result = new String [inputFiles.length];

        for (int i = 0; i < inputFiles.length; i++) {
            Path path = Paths.get(inputFiles[i]);
            result[i] = String.valueOf(Files.readAllLines(path,
                    Charset.defaultCharset()));
        }

        return result;

    }

    @Override
    public void checkInput() {
        if(this.inputFiles == null)
            throw new IllegalArgumentException();
    }
}
