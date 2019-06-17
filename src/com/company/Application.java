package com.company;

public class Application {

    public static void main(String[] args) {

        String[] input;
        StringTransformer[] stringTransformers;

        TextAnalyzer textAnalyzer = new TextAnalyzer(input,stringTransformers);

        TextAnalyzer.run();

    }

}
