package com.company;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileReader implements StringTransformer {

    public FileReader{
        List<String> lines = Files.readAllLines(Paths.get(uri),
                Charset.defaultCharset());
    }

}
