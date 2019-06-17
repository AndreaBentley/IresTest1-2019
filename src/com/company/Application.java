package com.company;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        String[] input ;
        StringTransformer[] stringTransformers;
        TextResult textResult;

        TextAnalyzer textAnalyzer = new TextAnalyzer(input,stringTransformers);

        textResult = textAnalyzer.run();
        textResult.print();

    }

}
