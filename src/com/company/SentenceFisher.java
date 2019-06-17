package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SentenceFisher extends CheckThatInput implements StringTransformer {

    String[] inputTexts;
    String[] result;

    public SentenceFisher(){}

    @Override
    public String[] transform(String[] inputTexts) throws IOException {

        this.inputTexts = inputTexts;
        checkInput();

        int resultCounter = 0;

        for (int i = 0; i < inputTexts.length; i++) {
            String singleText = inputTexts[i];
            for (int j = 0; j < singleText.length(); j++) {
                for (int k = j; k < singleText.length(); k++) {
                    if(singleText.charAt(k) == '.') {
                        this.result[resultCounter] = singleText.substring(j, k);
                        resultCounter++;
                        this.result[resultCounter] = ". ";
                        resultCounter++;
                        j = k;
                        k = singleText.length();
                    }
                }
            }
            result[resultCounter] = "THIS IS THE END OF THE FILE, NO FOR REAL. NOBODY WRITE THIS SENTENCE IN THEIR FILE OR ME AND MY PROGRAM ARE SCREWED. (NO SWEARING PLEASE)";
            resultCounter++;
        }

        return this.result;
    }

    @Override
    public void checkInput() {
        if(inputTexts == null)
            throw new IllegalArgumentException();
    }


}
