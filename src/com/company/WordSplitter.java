package com.company;

import java.io.IOException;

public class WordSplitter extends CheckThatInput implements StringTransformer {

    private String endOfFileSecretWord = "THIS IS THE END OF THE FILE, NO FOR REAL. NOBODY WRITE THIS SENTENCE IN THEIR FILE OR ME AND MY PROGRAM ARE SCREWED. (NO SWEARING PLEASE)";

    String[] inputSentences;
    String[] result;

    public WordSplitter(){}

    @Override
    public String[] transform(String[] inputSentences) throws IOException {

        this.inputSentences = inputSentences;
        checkInput();

        int resultCounter = 0;

        for (int i = 0; i < inputSentences.length; i++) {
            String singleSentence = inputSentences[i];
            if(!singleSentence.equals(endOfFileSecretWord)) {
                for (int j = 0; j < singleSentence.length(); j++) {
                    for (int k = j; k < singleSentence.length(); k++) {
                        if (singleSentence.charAt(k) == ' ') {
                            this.result[resultCounter] = singleSentence.substring(j, k);
                            resultCounter++;
                            this.result[resultCounter] = ". ";
                            resultCounter++;
                            j = k;
                            k = singleSentence.length();
                        }
                    }
                }
            }
        }

        return this.result;
    }

    @Override
    public void checkInput() {
        if(this.inputSentences == null)
            throw new IllegalArgumentException();
    }


}
