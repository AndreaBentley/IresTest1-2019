package com.company;

import java.io.IOException;

public class TextAnalyzer {


    private String[] input;
    private StringTransformer[] stringTransformers;

    public TextAnalyzer(String[] input, StringTransformer[] stringTransformers){
        this.stringTransformers = stringTransformers;
        this.input = input;
    }

    public TextResult run() throws IOException {

        String[] result;

        StringTransformer transformer = stringTransformers[0];
        result = transformer.transform(input);

        for (int i = 1; i < stringTransformers.length; i++) {
            transformer = stringTransformers[i];
            result = transformer.transform(result);
        }

        TextResult textResult = new TextResult();
        textResult.totalNumberOfWords = countTheTotalNumberOfWords(result);;
        textResult.dictionary = countForDictionary(result);;

        return textResult;

    }

    private int countTheTotalNumberOfWords(String[] text){

        int result = 0;

        for (int i = 0; i < text.length; i++) {
            if( !text[i].equals(". ") && text[i].equals(", ") && text[i].equals("THIS IS THE END OF THE FILE, NO FOR REAL. NOBODY WRITE THIS SENTENCE IN THEIR FILE OR ME AND MY PROGRAM ARE SCREWED. (NO SWEARING PLEASE)")) {
                result++;
            }
        }

        return result;
    }

    private int[] countForDictionary(String[] text){
        int largest = 0;
        int counter = 0;

        TextResult textResult = new TextResult();

        for (int i = 0; i < text.length; i++) {
            for (int j = i; j < text.length ; j++) {
                if(text[j].length() > largest){
                    largest = text[j].length();
                }

                if(text[j].length() == largest){
                    counter++;
                }
            }

            textResult.dictionary[largest] = counter;

        }

        return textResult.dictionary;
    }

}
